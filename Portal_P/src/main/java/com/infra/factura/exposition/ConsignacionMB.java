package com.infra.factura.exposition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.infra.cliente.model.TomaMaterial;
import com.infra.cliente.service.ws.WSFactura;
import com.infra.cliente.service.ws.WSService;
import com.infra.core.exposition.InternacionalizacionMB;
import com.infra.core.util.CoreConstantes;
import com.infra.core.util.LocaleUtil;
import com.infra.core.util.SessionUtil;
import com.infra.core.util.ValidatorUtil;
import com.infra.core.ws.exception.WSException;
import com.infra.factura.util.FechaUtil;
import com.infra.service.LconsRequest;
import com.infra.service.RconsRequest;
import com.infra.util.AbstractControlador;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_CNLISTA;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_LSOC;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Controller()
@Scope("session")
public class ConsignacionMB extends AbstractControlador {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ConsignacionMB.class);
	@Autowired
	private WSService wsService;
	@Autowired
	private WSFactura wsFactura;
	@Autowired
	private InternacionalizacionMB internacionalizacionMB;

	/**
	 * Para Recepcion de Facturas de Consignacion
	 */
	private Date fechaDesde;
	private Date fechaHasta;
	private Date fechaMaxima;
	private UploadedFile pdf;
	private UploadedFile xml;
	private ZPORTAL_S_LSOC sociedad;
	private List<ZPORTAL_S_LSOC> sociedades;
	private List<TomaMaterial> materiales;

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 */
	public void reset() {
		if (tienePermiso("ROLE_CONSIGNACION")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				xml = null;
				pdf = null;
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
				materiales = new ArrayList();
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 */
	public void reset(boolean limpiar) {
		if (tienePermiso("ROLE_CONSIGNACION")) {
			if (limpiar) {
				sociedad = null;
				loadSociedades();
				xml = null;
				pdf = null;
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
				materiales = new ArrayList();
			}
		}
	}

	public void loadEscenarios() {
	}

	public void manejadorXml(FileUploadEvent event) {
		this.setXml(event.getFile());
	}

	public void buscarMateriales() {
		if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
		} else {
			LconsRequest request = new LconsRequest();
			request.setIdioma(getLanguage());
			request.setSociedad(sociedad.getBUKRS());
			request.setProveedor(SessionUtil.getUsuarioActual());
			request.setFechaInicio(FechaUtil.formatoWS(fechaDesde));
			request.setFechaFin(FechaUtil.formatoWS(fechaHasta));
			try {
				materiales = new ArrayList<>();
				Map<String, Object> respuesta = wsFactura.lcons(request);
				if ("1".equals((String) respuesta.get("estatus"))) {
					transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
				} else {
//					List<ZPORTAL_S_CNLISTA> tmp = (List<ZPORTAL_S_CNLISTA>) respuesta.get("lista");
					List<ZPORTAL_S_CNLISTA> tmp = Arrays.asList((ZPORTAL_S_CNLISTA[]) respuesta.get("lista"));
					for (ZPORTAL_S_CNLISTA material : tmp) {
						materiales.add(new TomaMaterial(material, false));
					}
				}
			} catch (WSException e) {
				transaccionErronea("Error de WS", e.getMessage());
			}
		}
	}

	public String getLanguage() {
		return ("es".equals(internacionalizacionMB.getLanguage()) ? "S" : "E");
	}

	private void loadSociedades() {
		try {
			logger.info("Cargando sociedades del proveedor");
			sociedades = new ArrayList<>();
			Map<String, Object> respuesta = wsService.getSociedades(getLanguage(), SessionUtil.getUsuarioActual());
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				ZPORTAL_S_LSOC[] listado = (ZPORTAL_S_LSOC[]) respuesta.get("lista");
				sociedades = Arrays.asList(listado);
				if (!ValidatorUtil.isEmpty(sociedades)) {
					if (sociedades.size() == 1) {
						sociedad = sociedades.get(0);
					} else {
						sociedad = null;
						logger.info("El usuario tiene mas de un sociedad");
					}
				} else {
					sociedad = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar las sociedades", e);
		}
	}

	private boolean tienePermiso(String permiso) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		boolean tienePermiso = authentication.getAuthorities().contains(new SimpleGrantedAuthority(permiso));
		if (!tienePermiso) {
			throw new AccessDeniedException(CoreConstantes.ACCION_NO_PERMITIDA);
		}
		return tienePermiso;
	}

	public void seleccionarTodas() {
		for (TomaMaterial tm : materiales) {
			tm.setSeleccionada(true);
		}
	}

	public void deseleccionarTodas() {
		for (TomaMaterial tm : materiales) {
			tm.setSeleccionada(false);
		}
	}

	public void chequear(TomaMaterial material) {
		material.setSeleccionada(!material.isSeleccionada());
	}

	private boolean tieneTMSeleccionadas() {
		for (TomaMaterial tm : materiales) {
			if (tm.isSeleccionada()) {
				return true;
			}
		}
		return false;
	}

	public String arreglarParaIn() {
		int cuantas = 0;
		for (TomaMaterial tm : materiales) {
			if (tm.isSeleccionada())
				cuantas++;
		}
		String rtrn = "";
		int numeroValor = 1;
		for (TomaMaterial tm : materiales) {
			if (tm.isSeleccionada()) {
				rtrn += ("".equals(rtrn) ? tm.getToma().getEBELN() + (numeroValor == cuantas ? "" : ",")
						: tm.getToma().getEBELN() + (numeroValor == cuantas ? "" : ","));
				numeroValor++;
			}
		}
		return rtrn;
	}

	private void validarEnvioConsignacion() {
		try {
			if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
				return;
			}
			if (null == pdf || pdf.getFileName().isEmpty() || null == pdf.getInputstream()) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.pdf"));
				return;
			}
			if (null == xml || xml.getFileName().isEmpty() || null == xml.getInputstream()) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.xml"));
				return;
			}
			if (!tieneTMSeleccionadas()) {
				transaccionErronea("Error",
						LocaleUtil.getResourceBundle().getString("msg.consignacion.error.seleccionar"));
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enviarConsignacion() {
		validarEnvioConsignacion();
		RconsRequest request = new RconsRequest();
		request.setIdioma(getLanguage());
		request.setProveedor(SessionUtil.getUsuarioActual());
		request.setSociedad(sociedad.getBUKRS());
		// TODOrequest.setLista(lista);
		String cadenaXML = "";
		byte[] bytesPDF = null;
		try {
			if (null != xml)
				cadenaXML = com.infra.factura.business.schema.util.StringAndInputstreamUtil
						.convertStreamToString(xml.getInputstream());
			if (null != pdf)
				bytesPDF = org.apache.commons.io.IOUtils.toByteArray(pdf.getInputstream());
		} catch (IOException e) {
			System.out.println("Surgio un error al convertir Stream a String");
			e.printStackTrace();
		}
		request.setPdf(com.infra.factura.util.Base64.encodeBase64String(bytesPDF));
		request.setXml(com.infra.factura.util.Base64.encodeBase64String(cadenaXML.getBytes()));
		request.setLista(arreglarParaIn());
		Map<String, Object> respuesta = wsFactura.rcons(request);
		if ("0".equals(respuesta.get("estatus"))) {
			transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK",(String) respuesta.get("mensaje")); 
			//LocaleUtil.getResourceBundle().getString("msg.consignacion.registro.ok"));
			reset(true);
		} else {
			transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
		}
	}

	public UploadedFile getXml() {
		return xml;
	}

	public void setXml(UploadedFile xml) {
		this.xml = xml;
	}

	public UploadedFile getPdf() {
		return pdf;
	}

	public void setPdf(UploadedFile pdf) {
		this.pdf = pdf;
	}

	public InternacionalizacionMB getInternacionalizacionMB() {
		return internacionalizacionMB;
	}

	public void setInternacionalizacionMB(InternacionalizacionMB internacionalizacionMB) {
		this.internacionalizacionMB = internacionalizacionMB;
	}

	public ZPORTAL_S_LSOC getSociedad() {
		return sociedad;
	}

	public void setSociedad(ZPORTAL_S_LSOC sociedad) {
		this.sociedad = sociedad;
	}

	public List<ZPORTAL_S_LSOC> getSociedades() {
		return sociedades;
	}

	public void setSociedades(List<ZPORTAL_S_LSOC> sociedades) {
		this.sociedades = sociedades;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public List<TomaMaterial> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<TomaMaterial> materiales) {
		this.materiales = materiales;
	}

	public Date getFechaMaxima() {
		return fechaMaxima;
	}

	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}

}
