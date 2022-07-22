package com.infra.factura.exposition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
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

import com.infra.cliente.service.ws.WSFactura;
import com.infra.cliente.service.ws.WSService;
import com.infra.cliente.service.ws.WSStatusRecepcion;
import com.infra.core.exposition.InternacionalizacionMB;
import com.infra.core.util.CoreConstantes;
import com.infra.core.util.LocaleUtil;
import com.infra.core.util.SessionUtil;
import com.infra.core.util.ValidatorUtil;
import com.infra.factura.business.FeFacturaBusiness;
import com.infra.factura.dto.RespuestaPACDto;
import com.infra.factura.util.Base64;
import com.infra.factura.util.FeConstantes;
import com.infra.factura.util.FechaUtil;
import com.infra.service.CpfactsRequest;
import com.infra.service.CppagosRequest;
import com.infra.service.CprecepRequest;
import com.infra.service.ListanRequest;
import com.infra.util.AbstractControlador;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_CPFACTS;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_CPPAGOS;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_LSOC;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Controller
@Scope("session")
public class ComplementoMB extends AbstractControlador {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PeticionOfertaMB.class);
	@Autowired
	private WSService wsService;
	@Autowired
	private WSFactura wsFactura;
	@Autowired
	private InternacionalizacionMB internacionalizacionMB;
	@Autowired
	private WSStatusRecepcion wsStatusRecepcion;
	@Autowired
	private FeFacturaBusiness facturaBusiness;

	/**
	 * Para Recepcion de complementos de pago
	 */
	private UploadedFile xml;
	private UploadedFile pdf;
	private ZPORTAL_S_LSOC sociedad;
	private List<ZPORTAL_S_LSOC> sociedades;
	private Date fechaDesde;
	private Date fechaHasta;
	private Date fechaMaxima;
	private ZPORTAL_S_CPPAGOS pago;
	private List<ZPORTAL_S_CPPAGOS> pagos;
	private List<ZPORTAL_S_CPFACTS> facturas;

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 */
	public void reset() {
		if (tienePermiso("ROLE_COMPLEMENTO")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				pdf = null;
				xml = null;
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla peticionOferta
	 */
	public void reset(boolean limpiar) {
		if (tienePermiso("ROLE_COMPLEMENTO")) {
			if (limpiar) {
				sociedad = null;
				loadSociedades();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				pagos = null;
			}
		}
	}

	public void resetConsulta() {
		if (tienePermiso("ROLE_COMPLEMENTO")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				pagos = null;
			}
		}
	}

	public void loadEscenarios() {
	}

	public void manejadorPdf(FileUploadEvent event) {
		this.setPdf(event.getFile());
	}

	public void manejadorXml(FileUploadEvent event) {
		this.setXml(event.getFile());
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
				sociedades = Arrays.asList((ZPORTAL_S_LSOC[]) respuesta.get("lista"));
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

	public void consultarPagos() {
		if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
		} else {
			pagos = new ArrayList<>();
			CppagosRequest request = new CppagosRequest();
			request.setSociedad(sociedad.getBUKRS());
			request.setFechaInicio(FechaUtil.formatoWS(fechaDesde));
			request.setFechaFin(FechaUtil.formatoWS(fechaHasta));
			request.setIdioma(getLanguage());
			request.setProveedor(SessionUtil.getUsuarioActual());
			Map<String, Object> respuesta = wsFactura.cppagos(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				pagos = Arrays.asList((ZPORTAL_S_CPPAGOS[]) respuesta.get("lista"));
			}
		}
	}

	public void cargarDetalle(ZPORTAL_S_CPPAGOS obj) {
		pago = obj;
		// cargar el detalle de la petición
		cargarPosiciones(obj);
	}

	private void cargarPosiciones(ZPORTAL_S_CPPAGOS obj) {
		facturas = new ArrayList<>();
		CpfactsRequest request = new CpfactsRequest();
		request.setIdioma(getLanguage());
		request.setProveedor(SessionUtil.getUsuarioActual());
		request.setSociedad(sociedad.getBUKRS());
		request.setLaufi(obj.getLAUFI());
		request.setLaufd(obj.getLAUFD());
		request.setVblnr(obj.getVBLNR());
		Map<String, Object> respuesta = wsFactura.cpfacts(request);
		if ("1".equals((String) respuesta.get("estatus"))) {
			transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
		} else {
			facturas = Arrays.asList((ZPORTAL_S_CPFACTS[]) respuesta.get("lista"));
		}
	}

	public void guardarFacturas() {
		long startTime = System.currentTimeMillis();
		try {
			if (null == pdf) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.pdf.requerido"));
				return;
			}
			if (null == xml) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.xml"));
				return;
			} else {

				if (null == xml || xml.getFileName().isEmpty() || null == xml.getInputstream()) {
					transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.xml"));
					return;
				} else if (!xml.getFileName().toLowerCase().endsWith(".xml")) {
					transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.tipo.xml")
							.replaceAll("\\{0\\}", xml.getFileName()));
					return;
				} else {
					boolean isXMLValido = validarXML();
					if (!isXMLValido) {
						return;
					}
				}

			}
			CprecepRequest request = new CprecepRequest();
			request.setSociedad(sociedad.getBUKRS());
			request.setProveedor(SessionUtil.getUsuarioActual());
			request.setDocumentoPago(pago.getVBLNR());
			request.setIdioma(getLanguage());
			request.setEjercicio(pago.getGJAHR());
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
			request.setPdf(Base64.encodeBase64String(bytesPDF));
			request.setXml(Base64.encodeBase64String(cadenaXML.getBytes()));

			Map<String, Object> respuesta = wsFactura.cprecep(request);
			if ("0".equals((String) respuesta.get("estatus"))) {
				transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK",
						LocaleUtil.getResourceBundle().getString("msg.complemento_pago.ok"));
				consultarPagos();
			} else {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			}
		} catch (Exception e) {
			logger.error("Error al cargar el comprobante", e);
			transaccionErronea("Error: ", e.getMessage());
		} finally {
			logger.info(
					"cargarFactura(" + xml.getFileName() + ") : " + ((System.currentTimeMillis() - startTime) / 1000.0)
							+ "s " + new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(new Date()));
		}
	}

	public void cancelarGuardadoFacturas() {
		pdf = null;
		xml = null;
	}

	public boolean validarXML() {
		boolean isValido = false;
		long startTime = System.currentTimeMillis();
		StringBuilder msg = null;
		msg = new StringBuilder();
		try {
			logger.info("Validar XML " + new SimpleDateFormat("dd/MM/yyyHH:mm:ss").format(new Date()));
			logger.debug("XML Size: " + xml.getSize());
			boolean errorTipoArchivo = false;
			// StringBuilder stErrorTipo = new StringBuilder();
			RespuestaPACDto resultado = null;
			byte[] dataXML = IOUtils.toByteArray(xml.getInputstream());

			String xmlBase64 = Base64.encodeBase64String(dataXML);
			if (dataXML.length > 0) {
				if (xml.getSize() > FeConstantes.TAMANIO_MAXIMO_ARCHIVOS_1300KB) {
					errorTipoArchivo = true;
					isValido = false;
					//
					msg.append(LocaleUtil.getResourceBundle().getString("msg.tam.archivo"));
				}
			} else {
				if (xml.getSize() > FeConstantes.TAMANIO_MAXIMO_ARCHIVOS_1300KB) {
					errorTipoArchivo = true;
					isValido = false;
					//
					msg.append(LocaleUtil.getResourceBundle().getString("msg.tam.archivo"));
				}
			}
			if (!xml.getFileName().toLowerCase().endsWith(".xml")) {
				errorTipoArchivo = true;
				isValido = false;
				msg.append(LocaleUtil.getResourceBundle().getString("msg.archivo.tipo.xml").replaceAll("\\{0\\}",
						xml.getFileName()));
			}
			if (!errorTipoArchivo) {
				resultado = facturaBusiness.validarXML(xmlBase64);
				if (null != resultado && !resultado.isValido()) {
					transaccionErronea(LocaleUtil.getResourceBundle().getString("msg.comprobante.incorrecto"),
							resultado.getErrores());
					wsStatusRecepcion.guardarStatusRecepcion(getLanguage(), SessionUtil.getUsuarioActual(),
							xml.getInputstream(), pdf.getInputstream(), resultado.getErrores(), "RF");
					// valida y ,si aplica, notifica lista negra
//					if ("1".equals(resultado.getValidaciones().getListaNegra().getValidacion())
//							|| "1".equals(resultado.getValidaciones().getLista69b().getValidacion())) {
//						ListanRequest request = new ListanRequest();
//						request.setIdioma(getLanguage());
//						request.setProveedor(SessionUtil.getUsuarioActual());
//						wsFactura.listan(request);
//					}
				} else {
					isValido = true;
				}
				if(null != resultado && null != resultado.getValidaciones())
					if(null != resultado && null != resultado.getValidaciones().getListaNegra()  && null != resultado.getValidaciones().getLista69b()){
					if ("1".equals(resultado.getValidaciones().getListaNegra().getValidacion())
							|| "1".equals(resultado.getValidaciones().getLista69b().getValidacion())) {
						ListanRequest request = new ListanRequest();
						request.setIdioma(getLanguage());
						request.setProveedor(SessionUtil.getUsuarioActual());
						wsFactura.listan(request);
					}
				}
			} else {
				transaccionErronea(LocaleUtil.getResourceBundle().getString("msg.Error.formato.archivos"),
						msg.toString());
			}
			dataXML = null;
		} catch (Exception e) {
			isValido = false;
			logger.error("Error al cargar el comprobante", e);
			msg.append(e.getMessage());
		} finally {
			logger.info(
					"cargarComplemento(" + xml.getFileName() + ") : " + ((System.currentTimeMillis() - startTime) / 1000.0)
							+ "s " + new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(new Date()));
		}
		if (!isValido) {
			transaccionErronea(LocaleUtil.getResourceBundle().getString("msg.comprobante.incorrecto"), msg.toString());
		}

		return isValido;
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

	public Date getFechaMaxima() {
		return fechaMaxima;
	}

	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}

	public UploadedFile getXml() {
		return xml;
	}

	public void setXml(UploadedFile xml) {
		this.xml = xml;
	}

	public ZPORTAL_S_CPPAGOS getPago() {
		return pago;
	}

	public void setPago(ZPORTAL_S_CPPAGOS pago) {
		this.pago = pago;
	}

	public List<ZPORTAL_S_CPPAGOS> getPagos() {
		return pagos;
	}

	public void setPagos(List<ZPORTAL_S_CPPAGOS> pagos) {
		this.pagos = pagos;
	}

	public List<ZPORTAL_S_CPFACTS> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<ZPORTAL_S_CPFACTS> facturas) {
		this.facturas = facturas;
	}

}
