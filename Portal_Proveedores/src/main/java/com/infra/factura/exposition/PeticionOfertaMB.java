package com.infra.factura.exposition;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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

import com.infra.cliente.model.DetallePeticion;
import com.infra.cliente.service.ws.WSFactura;
import com.infra.cliente.service.ws.WSService;
import com.infra.core.exposition.InternacionalizacionMB;
import com.infra.core.util.CoreConstantes;
import com.infra.core.util.LocaleUtil;
import com.infra.core.util.SessionUtil;
import com.infra.core.util.ValidatorUtil;
import com.infra.factura.util.Base64;
import com.infra.factura.util.ConstantesGenerales;
import com.infra.factura.util.FechaUtil;
import com.infra.service.LcondRequest;
import com.infra.service.LincotRequest;
import com.infra.service.LspoferRequest;
import com.infra.service.PoferdRequest;
import com.infra.service.PoferhRequest;
import com.infra.service.PoferrRequest;
import com.infra.service.PofersRequest;
import com.infra.util.AbstractControlador;

import functions.rfc.sap.document.sap_com.ZPORTAL_CMONS;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_COND;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_INCOT;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_LSOC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERD;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERH;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_D;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_H;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERS;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_SPOFER;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Controller
@Scope("session")
public class PeticionOfertaMB extends AbstractControlador {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PeticionOfertaMB.class);
	@Autowired
	private WSService wsService;
	@Autowired
	private WSFactura wsFactura;
	@Autowired
	private InternacionalizacionMB internacionalizacionMB;
	
	static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Para la consulta de estatus de las peticiones de oferta
	 */

	/**
	 * Para Recepcion de peticiones de oferta
	 */
	private UploadedFile pdf;
	private ZPORTAL_S_LSOC sociedad;
	private List<ZPORTAL_S_LSOC> sociedades;
	private ZPORTAL_S_INCOT incoterm;
	private List<ZPORTAL_S_INCOT> incoterms;
	private Date fechaDesde;
	private Date fechaHasta;
	private Date fechaMaxima;
	private List<ZPORTAL_S_POFERH> listado;

	/**
	 * Para Recepcion de peticiones de oferta, muestra y carga de detalle
	 */
	private String texto1;
	private String texto2;
	private String pdfDetalle;

	private ZPORTAL_S_COND condicion;
	private List<ZPORTAL_S_COND> condiciones;
	private ZPORTAL_CMONS moneda;
	private List<ZPORTAL_CMONS> monedas;
	private ZPORTAL_S_POFERH peticion;
	private List<DetallePeticion> detalles;
	private StreamedContent pdfCargado;
	private boolean cabeceroCargado = false;;

	/**
	 * Para consulta de estatus de peticiones
	 */
	private ZPORTAL_S_SPOFER status;
	private List<ZPORTAL_S_SPOFER> listaEstatus;
	private List<ZPORTAL_S_POFERS> peticiones;

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla de peticiones
	 * de oferta
	 */
	public void reset() {
		if (tienePermiso("ROLE_PETICIONES")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				pdf = null;
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla peticionOferta
	 */
	public void reset(boolean limpiar) {
		if (tienePermiso("ROLE_PETICIONES")) {
			if (limpiar) {
				sociedad = null;
				loadSociedades();
				loadMonedas();
				loadCondiciones();
				loadIncoterms();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				listado = null;
			}
		}
	}

	public void resetConsulta() {
		if (tienePermiso("ROLE_PETICIONES")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				loadMonedas();
				loadCondiciones();
				loadIncoterms();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				listado = null;
			}
		}
	}

	public void resetConsultaEstatus() {
		if (tienePermiso("ROLE_PETICIONES")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				loadEstatusPO();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				peticiones = null;
			}
		}
	}

	public void resetConsultaEstatus(boolean limpiar) {
		if (tienePermiso("ROLE_PETICIONES")) {
			if (limpiar) {
				sociedad = null;
				loadSociedades();
				loadEstatusPO();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				peticiones = null;
			}
		}
	}

	public void loadEscenarios() {
	}

	public void manejadorPdf(FileUploadEvent event) {
		this.setPdf(event.getFile());
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

	private void loadEstatusPO() {
		try {
			logger.info("Cargando los estatus de las peticiones de oferta");
			listaEstatus = new ArrayList<>();

			LspoferRequest request = new LspoferRequest();
			request.setIdioma(getLanguage());

			Map<String, Object> respuesta = wsFactura.lspofer(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				listaEstatus = Arrays.asList((ZPORTAL_S_SPOFER[]) respuesta.get("lista"));
				if (!ValidatorUtil.isEmpty(listaEstatus)) {
					if (listaEstatus.size() == 1) {
						status = listaEstatus.get(0);
					} else {
						status = null;
						logger.info("El usuario tiene mas de un estatus de peticiones");
					}
				} else {
					status = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar los estatus de peticiones", e);
		}
	}

	public void consultarPeticiones() {
		if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
		} else {
			listado = new ArrayList<>();
			PoferhRequest request = new PoferhRequest();
			request.setSociedad(sociedad.getBUKRS());
			request.setFechaInicio(FechaUtil.formatoWS(fechaDesde));
			request.setFechaFin(FechaUtil.formatoWS(fechaHasta));
			request.setIdioma(getLanguage());
			request.setProveedor(SessionUtil.getUsuarioActual());

			Map<String, Object> respuesta = wsFactura.poferh(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
				listado = new ArrayList<ZPORTAL_S_POFERH>();
			} else {
				listado = Arrays.asList((ZPORTAL_S_POFERH[]) respuesta.get("lista"));
			}
		}
	}

	public void cargarDetalle(ZPORTAL_S_POFERH obj) {
		limpiarDatosDetalles();
		peticion = obj;
		// cargar el detalle de la petición
		cargarPosiciones(obj);
	}

	private void cargarMoneda(String waers) {
		for (ZPORTAL_CMONS mon : monedas) {
			if (mon.getWAERS().equals(waers)) {
				moneda = mon;
				break;
			}
		}
	}

	private void cargarCondicion(String zterm) {
		for (ZPORTAL_S_COND cond : condiciones) {
			if (cond.getZTERM().equals(zterm)) {
				condicion = cond;
				break;
			}
		}
	}
	
	private void cargarIncoterm(String inco1) {
		for (ZPORTAL_S_INCOT incot : incoterms) {
			if (incot.getINCO1().equals(inco1)) {
				incoterm = incot;
				break;
			}
		}
	}
	

	private void cargarPosiciones(ZPORTAL_S_POFERH obj) {
		detalles = new ArrayList<>();
		PoferdRequest request = new PoferdRequest();
		request.setIdioma(getLanguage());
		request.setProveedor(SessionUtil.getUsuarioActual());
		request.setSociedad(sociedad.getBUKRS());
		request.setIdOC(obj.getEBELN());
		// cargar cabeceros
		if (null != obj.getWAERS() && !obj.getWAERS().isEmpty()) {
			// moneda = new ZPORTAL_CMONS("", obj.getWAERS());
			cargarMoneda(obj.getWAERS());
			cabeceroCargado = true;
		}
		if (null != obj.getZTERM() && !obj.getZTERM().isEmpty()) {
			// condicion = new ZPORTAL_S_COND(obj.getZTERM(), "");
			cargarCondicion(obj.getZTERM());
			cabeceroCargado = true;
		}
		if (null != obj.getINCO1() && null != obj.getINCO2() && !obj.getINCO1().isEmpty()
				&& !obj.getINCO2().isEmpty()) {
//			incoterm = new ZPORTAL_S_INCOT(obj.getINCO1(), obj.getINCO2());
			cargarIncoterm(obj.getINCO1());
			cabeceroCargado = true;
		}
		texto1 = obj.getBKTXT();
		texto2 = obj.getBKTX2();
		// if (null != obj.getPDF() && !obj.getPDF().isEmpty()) {
		// pdfDetalle = obj.getPDF();
		// cabeceroCargado = true;
		// }

		Map<String, Object> respuesta = wsFactura.poferd(request);
		if ("1".equals((String) respuesta.get("estatus"))) {
			transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
		} else {
			ZPORTAL_S_POFERR_D detalleTmp = null;
			List<ZPORTAL_S_POFERD> detallesTmp = Arrays.asList((ZPORTAL_S_POFERD[]) respuesta.get("lista"));
			for (ZPORTAL_S_POFERD objLista : detallesTmp) {
				detalleTmp = new ZPORTAL_S_POFERR_D();
				detalleTmp.setEBELN(objLista.getEBELN());
				detalleTmp.setEBELP(objLista.getEBELP());
				detalleTmp.setEINDT(objLista.getEINDT());

				try {
					detalles.add(new DetallePeticion(objLista, detalleTmp, formato.parse(objLista.getEINDT())));
				} catch (ParseException e) {
					logger.error("Suegio un error para llenar la fecha de entrega que viene de SAP");
					e.printStackTrace();
				}
			}
		}
	}

	public void armarDescargaPDF() {
		pdfCargado = null;
		if (null == peticion) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.Error.formato.archivos"));
		} else {
			byte[] pdf = Base64.decodeBase64(peticion.getPDF());
			InputStream is = new ByteArrayInputStream(pdf);
			pdfCargado = new DefaultStreamedContent(is, "pdf",
					(String) peticion.getEBELN() + ConstantesGenerales.EXTENSION_PDF);
		}
	}

	public void armarPDFPeticion(ZPORTAL_S_POFERS obj) {
		pdfCargado = null;
		if (null == obj) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.Error.formato.archivos"));
		} else {
			byte[] pdf = Base64.decodeBase64(obj.getPDF());
			InputStream is = new ByteArrayInputStream(pdf);
			pdfCargado = new DefaultStreamedContent(is, "pdf",
					(String) obj.getEBELN() + ConstantesGenerales.EXTENSION_PDF);
		}
	}

	public void armarPDFDetallePeticion(ZPORTAL_S_POFERH obj) {
		pdfCargado = null;
		if (null == obj) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.Error.formato.archivos"));
		} else {
			byte[] pdf = Base64.decodeBase64(obj.getPDF());
			InputStream is = new ByteArrayInputStream(pdf);
			pdfCargado = new DefaultStreamedContent(is, "pdf",
					(String) obj.getEBELN() + ConstantesGenerales.EXTENSION_PDF);
		}
	}

	private boolean validarDatosRecepcion() {
		boolean isValido = true;
		if (null == moneda) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("peticiones.moneda.requerido"));
			isValido = false;
		} else if (null == condicion) {
			transaccionErronea("Error",
					LocaleUtil.getResourceBundle().getString("peticiones.condicion_pago.requerido"));
			isValido = false;
		} else if (null == incoterm) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("peticiones.incoterm.requerido"));
			isValido = false;
		} else if (null == pdf) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("peticiones.pdf.requerido"));
			isValido = false;
		}
		if (!isValido)
			RequestContext.getCurrentInstance().execute("PF('detallePeticionModal').show()");
		return isValido;
	}

	public void guardarDetalles() {
		try {

			if (!validarDatosRecepcion())
				return;

			byte[] bytesPDF = null;
			try {
				if (null != pdf)
					bytesPDF = IOUtils.toByteArray(pdf.getInputstream());
			} catch (IOException e) {
				System.out.println("Surgio un error al convertir Stream a String");
				e.printStackTrace();
			}

			PoferrRequest request = new PoferrRequest();
			request.setProveedor(SessionUtil.getUsuarioActual());
			request.setSociedad(sociedad.getBUKRS());
			request.setIdioma(getLanguage());

			ZPORTAL_S_POFERR_H[] cabeceros = new ZPORTAL_S_POFERR_H[1];
			ZPORTAL_S_POFERR_H cabecero = new ZPORTAL_S_POFERR_H();
			cabecero.setWAERS(moneda.getWAERS());
			cabecero.setBKTXT(texto1);
			cabecero.setBKTX2(texto2);
			cabecero.setZTERM(condicion.getZTERM());
			cabecero.setEBELN(peticion.getEBELN());
			cabecero.setINCO1(incoterm.getINCO1());
			cabecero.setINCO2(incoterm.getINCO2());
			cabecero.setPDF(Base64.encodeBase64String(bytesPDF));
			cabeceros[0] = cabecero;

			request.setListadoCabecero(cabeceros);
			SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
			String fechaEntrega = null;

			ZPORTAL_S_POFERR_D[] detallesTmp = new ZPORTAL_S_POFERR_D[detalles.size()];
			int cont = 0;
			for (DetallePeticion dp : detalles) {
				if(null != dp.getFechaEntrega()){
					fechaEntrega = dateformatter.format(dp.getFechaEntrega());
					dp.getEntradaProveedor().setEINDT(fechaEntrega);
					detallesTmp[cont] = dp.getEntradaProveedor();
				}
				cont++;
				// }
			}
			request.setListadoDetalle(detallesTmp);

			Map<String, Object> respuesta = wsFactura.poferr(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK",
						LocaleUtil.getResourceBundle().getString("msg.peticiones_oferta_ok"));
				detalles = new ArrayList<>();
//				consultarPeticiones(); //para que no se muestre el rojo cuando se manda la petición con un solo detalle
			}

		} catch (Exception e) {
			transaccionErronea("Error: ", e.getMessage());
			e.printStackTrace();
		}
		limpiarDatosDetalles();

	}

	public void limpiarDatosDetalles() {
		moneda = null;
		condicion = null;
		incoterm = null;
		texto1 = null;
		texto2 = null;
		pdf = null;
		detalles = null;
		cabeceroCargado = false;
		peticion = null;
	}

	public void consultarStatusPeticiones() {
		if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
		} else {
			peticiones = new ArrayList<>();
			PofersRequest request = new PofersRequest();
			request.setSociedad(sociedad.getBUKRS());
			request.setFechaInicio(FechaUtil.formatoWS(fechaDesde));
			request.setFechaFin(FechaUtil.formatoWS(fechaHasta));
			request.setIdioma(getLanguage());
			request.setProveedor(SessionUtil.getUsuarioActual());
			request.setStatus(null != status ? status.getSTATUS() : "");

			Map<String, Object> respuesta = wsFactura.pofers(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				// if(null != respuesta.get("lista"))
				peticiones = Arrays.asList((ZPORTAL_S_POFERS[]) respuesta.get("lista"));
			}
		}
	}

	public void loadMonedas() {
		monedas = new ArrayList<>();
		Map<String, Object> respuesta = wsService.getMonedas(getLanguage());
		if ("1".equals((String) respuesta.get("estatus"))) {
			transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
		} else {
			monedas = Arrays.asList((ZPORTAL_CMONS[]) respuesta.get("lista"));
		}
	}

	private void loadCondiciones() {
		try {
			condiciones = new ArrayList<>();
			logger.info("Cargando lista de condiciones");
			LcondRequest request = new LcondRequest();
			request.setIdioma(getLanguage());
			Map<String, Object> respuesta = wsFactura.lcond(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				condiciones = Arrays.asList((ZPORTAL_S_COND[]) respuesta.get("lista"));
				if (!ValidatorUtil.isEmpty(condiciones)) {
					if (condiciones.size() == 1) {
						condicion = condiciones.get(0);
					} else {
						condicion = null;
						logger.info("El usuario tiene mas de una condicion de pago");
					}
				} else {
					condicion = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar las condiciones", e);
		}
	}

	private void loadIncoterms() {
		try {
			incoterms = new ArrayList<>();
			logger.info("Cargando el listado de incoterms");
			LincotRequest request = new LincotRequest();
			request.setIdioma(getLanguage());

			Map<String, Object> respuesta = wsFactura.lincot(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				incoterms = Arrays.asList((ZPORTAL_S_INCOT[]) respuesta.get("lista"));
				if (!ValidatorUtil.isEmpty(incoterms)) {
					if (incoterms.size() == 1) {
						incoterm = incoterms.get(0);
					} else {
						incoterm = null;
						logger.info("El usuario tiene mas de un incoterm");
					}
				} else {
					incoterm = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar los incoterms", e);
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

	public List<ZPORTAL_CMONS> getMonedas() {
		return monedas;
	}

	public void setMonedas(List<ZPORTAL_CMONS> monedas) {
		this.monedas = monedas;
	}

	public ZPORTAL_CMONS getMoneda() {
		return moneda;
	}

	public void setMoneda(ZPORTAL_CMONS moneda) {
		this.moneda = moneda;
	}

	public Date getFechaMaxima() {
		return fechaMaxima;
	}

	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}

	public List<ZPORTAL_S_POFERH> getListado() {
		return listado;
	}

	public void setListado(List<ZPORTAL_S_POFERH> listado) {
		this.listado = listado;
	}

	public ZPORTAL_S_POFERH getPeticion() {
		return peticion;
	}

	public void setPeticion(ZPORTAL_S_POFERH peticion) {
		this.peticion = peticion;
	}

	public ZPORTAL_S_INCOT getIncoterm() {
		return incoterm;
	}

	public void setIncoterm(ZPORTAL_S_INCOT incoterm) {
		this.incoterm = incoterm;
	}

	public ZPORTAL_S_COND getCondicion() {
		return condicion;
	}

	public void setCondicion(ZPORTAL_S_COND condicion) {
		this.condicion = condicion;
	}

	public List<ZPORTAL_S_INCOT> getIncoterms() {
		return incoterms;
	}

	public void setIncoterms(List<ZPORTAL_S_INCOT> incoterms) {
		this.incoterms = incoterms;
	}

	public List<ZPORTAL_S_COND> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<ZPORTAL_S_COND> condiciones) {
		this.condiciones = condiciones;
	}

	public List<DetallePeticion> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePeticion> detalles) {
		this.detalles = detalles;
	}

	public StreamedContent getPdfCargado() {
		return pdfCargado;
	}

	public void setPdfCargado(StreamedContent pdfCargado) {
		this.pdfCargado = pdfCargado;
	}

	public String getTexto1() {
		return texto1;
	}

	public void setTexto1(String texto1) {
		this.texto1 = texto1;
	}

	public String getTexto2() {
		return texto2;
	}

	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}

	public ZPORTAL_S_SPOFER getStatus() {
		return status;
	}

	public void setStatus(ZPORTAL_S_SPOFER status) {
		this.status = status;
	}

	public List<ZPORTAL_S_SPOFER> getListaEstatus() {
		return listaEstatus;
	}

	public void setListaEstatus(List<ZPORTAL_S_SPOFER> listaEstatus) {
		this.listaEstatus = listaEstatus;
	}

	public List<ZPORTAL_S_POFERS> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(List<ZPORTAL_S_POFERS> peticiones) {
		this.peticiones = peticiones;
	}

	public boolean isCabeceroCargado() {
		return cabeceroCargado;
	}

	public void setCabeceroCargado(boolean cabeceroCargado) {
		this.cabeceroCargado = cabeceroCargado;
	}

	public String getPdfDetalle() {
		return pdfDetalle;
	}

	public void setPdfDetalle(String pdfDetalle) {
		this.pdfDetalle = pdfDetalle;
	}

	public static void main(String[] args) {
		try {
			Date fecha = formato.parse("2019-10-06");
			System.out.println("fecha: "+fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
