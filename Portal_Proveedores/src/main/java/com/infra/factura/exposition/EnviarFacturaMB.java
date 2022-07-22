package com.infra.factura.exposition;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
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

import com.infra.cliente.model.Factura;
import com.infra.cliente.model.Orden;
import com.infra.cliente.service.ws.WSFactura;
import com.infra.cliente.service.ws.WSService;
import com.infra.cliente.service.ws.WSStatusRecepcion;
import com.infra.core.exposition.InternacionalizacionMB;
import com.infra.core.model.UsuarioWS;
import com.infra.core.util.CoreConstantes;
import com.infra.core.util.LocaleUtil;
import com.infra.core.util.SessionUtil;
import com.infra.core.util.ValidatorUtil;
import com.infra.core.ws.exception.WSException;
import com.infra.factura.business.FeFacturaBusiness;
import com.infra.factura.dto.RespuestaPACDto;
import com.infra.factura.util.Base64;
import com.infra.factura.util.ConstantesGenerales;
import com.infra.factura.util.FeConstantes;
import com.infra.factura.util.FechaUtil;
import com.infra.factura.util.NumeroUtil;
import com.infra.service.AvisoPdfRequest;
import com.infra.service.LconcRequest;
import com.infra.service.ListaOCRequest;
import com.infra.service.ListanRequest;
import com.infra.service.RantRequest;
import com.infra.util.AbstractControlador;

import functions.rfc.sap.document.sap_com.ZPORTAL_CMONS;
import functions.rfc.sap.document.sap_com.ZPORTAL_CSOCA;
import functions.rfc.sap.document.sap_com.ZPORTAL_CSOCR;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_CONC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_IMPS;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_LANT;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_LFACT;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_LISTAOC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_LSOC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_PEDIDOS;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_TIPOS;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Controller
@Scope("session")
public class EnviarFacturaMB extends AbstractControlador {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(EnviarFacturaMB.class);
	@Autowired
	private WSService wsService;
	@Autowired
	private WSFactura wsFactura;
	@Autowired
	private WSStatusRecepcion wsStatusRecepcion;
	@Autowired
	private InternacionalizacionMB internacionalizacionMB;
	// @Autowired
	// private FacturaService facturaService;
	@Autowired
	private FeFacturaBusiness facturaBusiness;

	/**
	 * Para Recepcion de Facturas General
	 */
	private UploadedFile pdf;
	private UploadedFile xml;
	private UploadedFile pdfSellado;
	private StreamedContent archivoDescarga;
	private String folio;
	private Date fechaFactura;
	private BigDecimal montoFactura;
	private ZPORTAL_S_LSOC sociedad;
	private List<ZPORTAL_S_LSOC> sociedades;
	private List<ZPORTAL_S_CONC> conceptos;
	private List<Orden> ordenes;
	private List<Orden> ordenesSeleccionadas;
	// se usa para cuando se estan haciendo mostrando el modal de busqueda de
	// ordenes, solo si le da agregar esta lista sustituira a la de ordenes
	// seleccionadas
	private List<Orden> ordenesSeleccionadasTmp;

	/**
	 * Para consulta de facturas
	 */
	private List<Factura> facturas;
	// para agregar los archivos de anticipo a las facturas
	private List<Factura> facturasTmp;
	private String estatusFactura;

	/**
	 * Para estado de cuenta
	 */
	// private List<ZfeSEdocta> estados;

	/**
	 * Para Filtro de OC
	 */
	private String ordenesAFiltrar;
	private String ocAgregar;
	private String pedimentos;
	private Date fechaDesde;
	private Date fechaHasta;
	private Date fechaMaxima;
	private ZPORTAL_S_TIPOS tipoRecepcion;
	private List<ZPORTAL_S_TIPOS> listaTiposRecepcion;
	private List<ZPORTAL_S_IMPS> impuestos;
	private ZPORTAL_S_IMPS impuesto;
	private List<ZPORTAL_CMONS> monedas;
	private List<ZPORTAL_CSOCA> areas;
	private List<ZPORTAL_CSOCR> responsables;

	/*
	 * Para la CFDI sin OC
	 */
	private String factura;
	private ZPORTAL_S_CONC concepto;
	private ZPORTAL_CSOCA area;
	private ZPORTAL_CSOCR responsable;

	/*
	 * Para la CFDI sin OC
	 */
	private Double subtotal;
	private float iva;
	private ZPORTAL_CMONS moneda;
	private BigDecimal sumaImportes;
	private BigDecimal sumaImportesSeleccionadas;

	/**
	 * Para la CBB con y sin OC
	 */
	private boolean notaCredito;

	/**
	 * Variables para la pantalla de listado de OC
	 */
	private List<ZPORTAL_S_LISTAOC> listaOC;

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 */
	public void reset() {
		if (tienePermiso("ROLE_V_CFDI_OC")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				loadTiposRecepcion();
				ocAgregar = null;
				pedimentos = null;
				xml = null;
				pdf = null;
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
				pdfSellado = null;
				tipoRecepcion = null;
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
				ordenesAFiltrar = null;
				ordenes = new ArrayList();
				folio = null;
				fechaFactura = null;
				montoFactura = null;
				ordenesSeleccionadas = null;
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 * CFDI sin OC
	 */
	public void resetCFDI() {
		if (tienePermiso("ROLE_V_CFDI")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				area = null;
				responsable = null;
				sociedad = null;
				loadSociedades();
				loadConceptos();
				xml = null;
				pdf = null;
				pdfSellado = null;
				factura = null;
				concepto = null;
				folio = null;
				fechaFactura = null;
				montoFactura = null;
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 * CBB sin OC
	 */
	public void resetCBB() {
		if (tienePermiso("ROLE_V_CBB")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				area = null;
				responsable = null;
				loadSociedades();
				loadMonedas();
				loadImpuestos();
				loadConceptos();
				impuesto = null;
				pdf = null;
				pdfSellado = null;
				concepto = null;
				factura = null;
				iva = 0;
				subtotal = new Double("0");
				moneda = null;
				folio = null;
				fechaFactura = null;
				montoFactura = null;
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 * CBB con OC
	 */
	public void resetCBBOC() {
		if (tienePermiso("ROLE_V_CBB_OC")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				loadMonedas();
				ocAgregar = null;
				pedimentos = null;
				loadTiposRecepcion();
				loadImpuestos();
				impuesto = null;
				xml = null;
				pdf = null;
				pdfSellado = null;
				tipoRecepcion = null;
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
				factura = null;
				fechaFactura = null;
				pdf = null;
				pdfSellado = null;
				area = null;
				responsable = null;
				ordenes = new ArrayList();
				iva = 0;
				subtotal = new Double("0");
				moneda = null;
				folio = null;
				fechaFactura = null;
				montoFactura = null;
				ordenesSeleccionadas = null;
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 */
	public void reset(boolean limpiar) {
		if (tienePermiso("ROLE_V_CFDI_OC")) {
			if (limpiar) {
				sociedad = null;
				loadSociedades();
				loadTiposRecepcion();
				ocAgregar = null;
				pedimentos = null;
				xml = null;
				pdf = null;
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
				pdfSellado = null;
				tipoRecepcion = null;
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
				ordenesAFiltrar = null;
				ordenes = new ArrayList();
				folio = null;
				fechaFactura = null;
				montoFactura = null;
				ordenesSeleccionadas = null;
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 * CFDI sin OC
	 */
	public void resetCFDI(boolean limpiar) {
		if (tienePermiso("ROLE_V_CFDI")) {
			if (limpiar) {
				area = null;
				responsable = null;
				sociedad = null;
				loadSociedades();
				xml = null;
				pdf = null;
				pdfSellado = null;
				factura = null;
				concepto = null;
				folio = null;
				fechaFactura = null;
				montoFactura = null;
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 * CBB sin OC
	 */
	public void resetCBB(boolean limpiar) {
		if (tienePermiso("ROLE_V_CBB")) {
			if (limpiar) {
				sociedad = null;
				area = null;
				responsable = null;
				loadSociedades();
				loadMonedas();
				loadImpuestos();
				impuesto = null;
				pdf = null;
				pdfSellado = null;
				concepto = null;
				factura = null;
				iva = 0;
				subtotal = new Double("0");
				moneda = null;
				folio = null;
				fechaFactura = null;
				montoFactura = null;
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
			}
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla enviarFactura
	 * CBB con OC
	 */
	public void resetCBBOC(boolean limpiar) {
		if (tienePermiso("ROLE_V_CBB_OC")) {
			if (limpiar) {
				sociedad = null;
				loadSociedades();
				loadMonedas();
				ocAgregar = null;
				pedimentos = null;
				loadTiposRecepcion();
				loadImpuestos();
				impuesto = null;
				xml = null;
				pdf = null;
				pdfSellado = null;
				tipoRecepcion = null;
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
				factura = null;
				fechaFactura = null;
				pdf = null;
				pdfSellado = null;
				area = null;
				responsable = null;
				ordenes = new ArrayList();
				iva = 0;
				subtotal = new Double("0");
				moneda = null;
				folio = null;
				fechaFactura = null;
				montoFactura = null;
				ordenesSeleccionadas = null;
			}
		}
	}

	public void resetModalOC() {
		tipoRecepcion = null;
		ordenes = new ArrayList<>();
		sumaImportes = new BigDecimal(0);
		ocAgregar = "";
		pedimentos = "";
		fechaHasta = new Date();
		fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
	}

	public void cancelar() {
		tipoRecepcion = null;
		ordenes = new ArrayList<>();
		sumaImportes = new BigDecimal(0);
		sumaImportesSeleccionadas = new BigDecimal(0);
		ocAgregar = "";
		pedimentos = "";
		fechaHasta = new Date();
		fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
		ordenesSeleccionadas = new ArrayList<>();
	}

	public void cancelarAnticipos() {
		System.out.println("cancelarAnticipos");
		facturasTmp = new ArrayList<>();
	}

	public void guardarAnticipos() {
		System.out.println("procede a guardar los archivos cargados para los anticipos");
		RantRequest request = new RantRequest();
		try {
			request.setIdioma(getLanguage());
			request.setProveedor(SessionUtil.getUsuarioActual());
			request.setSociedad(sociedad.getBUKRS());
			ZPORTAL_S_LANT[] arreglo = new ZPORTAL_S_LANT[facturasTmp.size()];
			ZPORTAL_S_LANT obj = null;
			String cadenaXML = "";
			byte[] bytesPDF = null;
			int pos = 0;
			for (Factura fact : facturasTmp) {
				if (null != fact.getXml() && null != fact.getPdf()) {
					obj = new ZPORTAL_S_LANT();
					try {
						if (null != fact.getXml())
							cadenaXML = com.infra.factura.business.schema.util.StringAndInputstreamUtil
									.convertStreamToString(fact.getXml().getInputstream());
						if (null != fact.getPdf())
							bytesPDF = IOUtils.toByteArray(fact.getPdf().getInputstream());
					} catch (IOException e) {
						System.out.println("Surgio un error al convertir Stream a String");
						e.printStackTrace();
					}
					obj.setPDF(Base64.encodeBase64String(bytesPDF));
					obj.setXML(Base64.encodeBase64String(cadenaXML.getBytes()));
					obj.setBELNR(fact.getFactura().getBELNR());
					obj.setXBLNR(fact.getFactura().getXBLNR());
					
					obj.setBUKRS(fact.getFactura().getBUKRS());
					obj.setGJAHR(fact.getFactura().getGJAHR());
					
					arreglo[pos] = obj;
					pos++;
				}
			}
			request.setAnticipos(arreglo);
			Map<String, Object> respuesta = wsFactura.guardarAnticipos(request);
			if ("0".equals((String) respuesta.get("estatus"))) {
				transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK",
						LocaleUtil.getResourceBundle().getString("msg.factura.anticipos.ok"));
				consultarFacturas();
			} else {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			}
		} catch (Exception e) {
			transaccionErronea("Error: ", e.getMessage());
		}
		// resetConsulta();
	}

	public void resetValidar() {
		if (tienePermiso("ROLE_VALIDA_XML")) {
			xml = null;
			pdf = null;
		}
	}

	public void calcularTotales() {
		sumaImportes = new BigDecimal(0);
		for (Orden orden : ordenes) {
			if (orden.isSeleccionada()) {
				sumaImportes = sumaImportes.add(orden.getOrden().getNETWR());
			}
		}
	}

	public void calcularTotalesSeleccionadas() {
		sumaImportesSeleccionadas = new BigDecimal(0);
		for (Orden orden : ordenesSeleccionadas) {
			if (orden.isSeleccionada()) {
				sumaImportesSeleccionadas = sumaImportesSeleccionadas.add(orden.getOrden().getNETWR());
			}
		}
	}

	public void loadEscenarios() {
	}

	public void manejadorXml(FileUploadEvent event) {
		Integer id = (Integer) event.getComponent().getAttributes().get("pos"); //
		System.out.println("manejadorXml: " + id);
		facturasTmp.get(id).setXml(event.getFile());
		// this.setXml(event.getFile());
	}

	public void manejadorPdf(FileUploadEvent event) {
		Integer id = (Integer) event.getComponent().getAttributes().get("pos"); //
		System.out.println("manejadorPdf: " + id);
		facturasTmp.get(id).setPdf(event.getFile());
		// this.setXml(event.getFile());
	}

	public void agregarArchivos() {
		facturasTmp = new ArrayList<>();
		int pos = 0;
		for (Factura fact : facturas) {
			if (fact.isSeleccionada() && ConstantesGenerales.CORE_ROLE_ACTIVO.equals(fact.getFactura().getANTIC())) {
				fact.setPosicion(pos);
				facturasTmp.add(fact);
				pos++;
			}
		}
	}

	public void buscarOrdenes() {
		if (null == tipoRecepcion || tipoRecepcion.getTIPO().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("orden.tipoDocumento.error"));
		} else if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
		} else {
			try {
				ordenes = new ArrayList<>();
				Map<String, Object> respuesta = wsService.getOrdenes(getLanguage(), SessionUtil.getUsuarioActual(),
						sociedad.getBUKRS(), fechaDesde, fechaHasta, tipoRecepcion.getTIPO(), ocAgregar, pedimentos);
				if ("1".equals((String) respuesta.get("estatus"))) {
					transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
				} else {
					// List<ZfeSPolist> tmp = (List<ZfeSPolist>)
					// respuesta.get("lista");
					List<ZPORTAL_S_PEDIDOS> tmp = new ArrayList<ZPORTAL_S_PEDIDOS>();
					tmp = Arrays.asList((ZPORTAL_S_PEDIDOS[]) respuesta.get("lista"));
					for (ZPORTAL_S_PEDIDOS orden : tmp) {
						ordenes.add(new Orden(orden, false));
					}
				}
			} catch (WSException e) {
				transaccionErronea("Error de WS", e.getMessage());
			}
		}
	}

	public void validarCadenaOrdenes() {
		boolean isValido = false;
		if (null != ocAgregar && !ocAgregar.isEmpty()) {
			final String PATTERN = "^[0-9]+([,][0-9]*)*$";
			Pattern pattern;
			Matcher matcher;
			pattern = Pattern.compile(PATTERN);
			matcher = pattern.matcher(ocAgregar);
			isValido = matcher.matches();
			if (!isValido) {
				// FacesMessage message = null;
				// message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				// "ERROR",
				// "Solo se aceptan numeros separados por comas, sin
				// espacios.");
				// RequestContext.getCurrentInstance().showMessageInDialog(message);
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("orden.ordenes.entrada"));
			}
		}
	}

	public void validarCadenaPedimentos() {
		boolean isValido = false;
		if (null != pedimentos && !pedimentos.isEmpty()) {
			final String PATTERN = "^[0-9]+([,][0-9]*)*$";
			Pattern pattern;
			Matcher matcher;
			pattern = Pattern.compile(PATTERN);
			matcher = pattern.matcher(pedimentos);
			isValido = matcher.matches();
			if (!isValido) {
				// FacesMessage message = null;
				// message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				// "ERROR",
				// "Solo se aceptan numeros separados por comas, sin
				// espacios.");
				// RequestContext.getCurrentInstance().showMessageInDialog(message);
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("orden.ordenes.entrada"));
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
				// sociedades = (List<ZPORTAL_S_LSOC>) respuesta.get("lista");

				// ZPORTAL_S_LSOC[] listado = (ZPORTAL_S_LSOC[])
				// respuesta.get("lista");
				sociedades = Arrays.asList((ZPORTAL_S_LSOC[]) respuesta.get("lista"));

				if (!ValidatorUtil.isEmpty(sociedades)) {
					if (sociedades.size() == 1) {
						sociedad = sociedades.get(0);
						loadAreas();
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

	public void resetConsulta() {
		if (tienePermiso("ROLE_GET_FACTURAS")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				fechaHasta = new Date();
				sumaImportes = new BigDecimal(0);
				sumaImportesSeleccionadas = new BigDecimal(0);
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				facturas = null;
				estatusFactura = "T";
			}
		}
	}

	public void resetConsultaOC() {
		if (tienePermiso("ROLE_LISTA_OC2")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				listaOC = null;
				// if(null != sociedad)
				// consultarOC();
			}
		}
	}

	public void resetEdoCta() {
		if (tienePermiso("ROLE_GET_EDO_CTA")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				fechaMaxima = FechaUtil.sumarDiasFecha(fechaHasta, -SessionUtil.getNumeroDiasEdoCta());
				// estados = null;
				estatusFactura = "T";
			}
		}
	}

	public void consultarFacturas() {
		if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
		} else {
			facturas = new ArrayList<>();
			Map<String, Object> respuesta = wsFactura.getFacturas(fechaDesde, fechaHasta, getLanguage(),
					SessionUtil.getUsuarioActual(), sociedad.getBUKRS(), estatusFactura, null, null);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				List<ZPORTAL_S_LFACT> tmp = new ArrayList<ZPORTAL_S_LFACT>();
				tmp = Arrays.asList((ZPORTAL_S_LFACT[]) respuesta.get("lista"));
				for (ZPORTAL_S_LFACT factura : tmp) {
					// este es solo para pruebas de la pantalla de carga de
					// anticipos
					// factura.setANTIC("X");
					facturas.add(new Factura(factura, false));
				}
			}
		}
	}

	public void consultarOC() {
		if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
		} else {
			listaOC = new ArrayList<>();
			ListaOCRequest request = new ListaOCRequest();
			request.setIdioma(getLanguage());
			request.setSociedad(sociedad.getBUKRS());
			request.setFechaFin(FechaUtil.formatoWS(fechaHasta));
			request.setFechaInicio(FechaUtil.formatoWS(fechaDesde));
			request.setProveedor(SessionUtil.getUsuarioActual());

			Map<String, Object> respuesta = wsFactura.getListaOC(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				listaOC = Arrays.asList((ZPORTAL_S_LISTAOC[]) respuesta.get("lista"));
			}
		}
	}

	public void armarDescargaParaNotificar(ZPORTAL_S_LISTAOC obj) {
		archivoDescarga = null;
		if (null == obj) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.Error.formato.archivos"));
		} else {
			byte[] pdf = Base64.decodeBase64(obj.getPDF());
			InputStream is = new ByteArrayInputStream(pdf);
			archivoDescarga = new DefaultStreamedContent(is, "pdf",
					(String) obj.getEBELN() + ConstantesGenerales.EXTENSION_PDF);
			if (!ConstantesGenerales.CORE_ROLE_ACTIVO.equals(obj.getDESCARGADO())) {
				notificarDescarga(obj);
			}
		}
	}

	private void notificarDescarga(ZPORTAL_S_LISTAOC obj) {
		AvisoPdfRequest request = new AvisoPdfRequest();
		request.setIdioma(getLanguage());
		request.setIdLista(obj.getEBELN());
		request.setProveedor(SessionUtil.getUsuarioActual());

		Map<String, Object> respuesta = wsFactura.notificaDescargaPDF(request);
		if ("0".equals((String) respuesta.get("estatus"))) {
			transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK", (String) respuesta.get("mensaje"));
			consultarOC();
		} else {
			transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
		}
	}

	// public void prepararArchivoPDF(Integer anioFiscal, String idEmpresa,
	// String serie,
	// String folio, Integer factId, String rutaXml){
	// try {
	//
	// List<Object> result = null;
	//
	// result = monitorFactService.generarPDF(anioFiscal, idEmpresa, serie,
	// folio, factId, rutaXml);
	//
	// InputStream inputStream = null;
	// inputStream = new
	// ByteArrayInputStream(((ByteArrayOutputStream)result.get(1)).toByteArray());
	// archivoPdf = new DefaultStreamedContent(inputStream, "pdf",
	// (String)result.get(0));
	//
	// }catch (FileNotFoundException e) {
	// transaccionErronea(
	// ApplicationResources.getString("error2.monitorFacturas.DescargaArchivoExcepPdf"),
	// ApplicationResources.getString("monitorFacturas.error.Pdf"));
	// }catch (Exception e){
	// transaccionErronea(
	// ApplicationResources.getString("monitorFacturas.error"),
	// "No existe el archivo");
	// }
	// }

	// public void consultarEstadosCuenta() {
	// if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
	// transaccionErronea("Error",
	// LocaleUtil.getResourceBundle().getString("error.sociedad"));
	// } else {
	// estados = new ArrayList<>();
	// Map<String, Object> respuesta = wsFactura.getEdoCta(fechaDesde,
	// fechaHasta, getLanguage(),
	// SessionUtil.getUsuarioActual(), sociedad.getBUKRS(), estatusFactura);
	// if ("1".equals((String) respuesta.get("estatus"))) {
	// transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
	// } else {
	// estados = (List<ZfeSEdocta>) respuesta.get("lista");
	// }
	// }
	// }

	public void loadImpuestos() {
		if (null != sociedad) {
			impuestos = new ArrayList<>();
			Map<String, Object> respuesta = wsService.getImpuestos(getLanguage(), sociedad.getBUKRS());
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				// impuestos = (List<ZPORTAL_S_IMPS>) respuesta.get("lista");
				impuestos = Arrays.asList((ZPORTAL_S_IMPS[]) respuesta.get("lista"));
				if (!ValidatorUtil.isEmpty(impuestos)) {
					if (impuestos.size() == 1) {
						impuesto = impuestos.get(0);
					} else {
						impuesto = null;
						logger.info("El usuario tiene mas de un impuesto");
					}
				} else {
					impuesto = null;
				}
			}
		}
	}

	public void loadConceptos() {
		conceptos = new ArrayList<>();
		LconcRequest request = new LconcRequest();
		request.setIdioma(getLanguage());
		Map<String, Object> respuesta = wsFactura.lconc(request);
		if ("1".equals((String) respuesta.get("estatus"))) {
			transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
		} else {
			conceptos = Arrays.asList((ZPORTAL_S_CONC[]) respuesta.get("lista"));
			if (!ValidatorUtil.isEmpty(conceptos)) {
				if (conceptos.size() == 1) {
					concepto = conceptos.get(0);
				} else {
					concepto = null;
					logger.info("La lista de conceptos tiene mas de un concepto");
				}
			} else {
				concepto = null;
			}
		}
	}

	public void cambiaConceptos() {
		notaCredito = !notaCredito;
		loadConceptos();
		List<ZPORTAL_S_CONC> conceptosTmp = new ArrayList<ZPORTAL_S_CONC>();
		if (notaCredito && !getUsuario().isXConc()) {
			for (ZPORTAL_S_CONC conc : conceptos) {
				if (ConstantesGenerales.CORE_ROLE_ACTIVO.equals(conc.getXREB())) {
					conceptosTmp.add(conc);
				}
			}
			conceptos = conceptosTmp;
		}
	}

	public UsuarioWS getUsuario() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			UsuarioWS usuario = (UsuarioWS) authentication.getDetails();  
			if (usuario != null) {
				return usuario;
			} else {
				logger.debug("El objeto principal usuario es nulo");
			}
		}
		return null;
	}

	public void loadMonedas() {
		monedas = new ArrayList<>();
		Map<String, Object> respuesta = wsService.getMonedas(getLanguage());
		if ("1".equals((String) respuesta.get("estatus"))) {
			transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
		} else {
			// monedas = (List<ZPORTAL_CMONS>) respuesta.get("lista");
			monedas = Arrays.asList((ZPORTAL_CMONS[]) respuesta.get("lista"));
		}
	}

	private void loadTiposRecepcion() {
		try {
			listaTiposRecepcion = new ArrayList<>();
			logger.info("Cargando tipos de recepciones");
			Map<String, Object> respuesta = wsService.getTiposRecepcion(getLanguage(), SessionUtil.getUsuarioActual());
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				// listaTiposRecepcion = (List<ZPORTAL_S_TIPOS>)
				// respuesta.get("lista");
				listaTiposRecepcion = Arrays.asList((ZPORTAL_S_TIPOS[]) respuesta.get("lista"));
				if (!ValidatorUtil.isEmpty(listaTiposRecepcion)) {
					if (listaTiposRecepcion.size() == 1) {
						tipoRecepcion = listaTiposRecepcion.get(0);
					} else {
						tipoRecepcion = null;
						logger.info("El usuario tiene mas de un tipo de recepcion");
					}
				} else {
					tipoRecepcion = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar los tipos de recepcion", e);
		}
	}

	public void loadAreas() {
		if (null != sociedad) {
			Map<String, Object> respuesta = wsService.getAreas(getLanguage(), sociedad.getBUKRS());
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				loadImpuestos();
				// areas = (List<ZfeCsocArea>) respuesta.get("lista");

				areas = Arrays.asList((ZPORTAL_CSOCA[]) respuesta.get("lista"));

				if (!ValidatorUtil.isEmpty(areas)) {
					if (areas.size() == 1) {
						area = areas.get(0);
						loadResponsables();
					} else {
						area = null;
						responsables = new ArrayList();
						logger.info("La sociedad tiene mas de un area");
					}
				} else {
					area = null;
					responsable = null;
					areas = null;
					responsables = null;
				}
			}
		} else {
			area = null;
			responsable = null;
			areas = null;
			responsables = null;
		}
	}

	public void loadResponsables() {
		try {
			logger.info("Cargando responsables");
			responsables = new ArrayList<>();
			Map<String, Object> respuesta = wsService.getResponsables(getLanguage(), sociedad.getBUKRS(),
					area.getAREID());
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				// responsables = (List<ZPORTAL_CSOCR>) respuesta.get("lista");
				responsables = Arrays.asList((ZPORTAL_CSOCR[]) respuesta.get("lista"));
				if (!ValidatorUtil.isEmpty(responsables)) {
					if (responsables.size() == 1) {
						responsable = responsables.get(0);
					} else {
						responsable = null;
						logger.info("El area tiene mas de un responsable");
					}
				} else {
					responsable = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar los responsables", e);
		}
	}

	private boolean getDebeAgregarPDFAdicional() {
		// SecurityContext context = SecurityContextHolder.getContext();
		// Authentication authentication = context.getAuthentication();
		// return authentication.getAuthorities().contains(new
		// SimpleGrantedAuthority("ROLE_PDF_ADICIONAL"));
		return false;
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
			logger.info("Inicia validar XML");
			String xmlBase64 = Base64.encodeBase64String(dataXML);
			logger.info("Continua parte 2 Validar XML");
			if (dataXML.length > 0) {
				if (xml.getSize() > FeConstantes.TAMANIO_MAXIMO_ARCHIVOS_1300KB) {
					errorTipoArchivo = true;
					isValido = false;
					//
					msg.append(LocaleUtil.getResourceBundle().getString("msg.tam.archivo"));
					logger.info("entra 1");
				}
			} else {
				if (xml.getSize() > FeConstantes.TAMANIO_MAXIMO_ARCHIVOS_1300KB) {
					errorTipoArchivo = true;
					isValido = false;
					logger.info("entra 2");
					//
					msg.append(LocaleUtil.getResourceBundle().getString("msg.tam.archivo"));
				}
			}
			if (!xml.getFileName().toLowerCase().endsWith(".xml")) {
				errorTipoArchivo = true;
				isValido = false;
				msg.append(LocaleUtil.getResourceBundle().getString("msg.archivo.tipo.xml").replaceAll("\\{0\\}",
						xml.getFileName()));
				logger.info("entra 3");
			}
			if (!errorTipoArchivo) {
				resultado = facturaBusiness.validarXML(xmlBase64);
				
				logger.info("todavia entra");
				
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
					logger.info("ValidarXML valido");
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
			logger.info("aqui esta el error");
			msg.append(e.getMessage());
		} finally {
			logger.info(
					"cargarFactura(" + xml.getFileName() + ") : " + ((System.currentTimeMillis() - startTime) / 1000.0)
							+ "s " + new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(new Date()));
			logger.info("Prueba MODaa");
		}
		if (!isValido) {
			transaccionErronea(LocaleUtil.getResourceBundle().getString("msg.comprobante.incorrecto"), msg.toString());
		}

		return isValido;
	}

	public void seleccionarTodas() {
		for (Orden orden : ordenes) {
			orden.setSeleccionada(true);
		}
		calcularTotales();
	}

	public void deseleccionarTodas() {
		for (Orden orden : ordenes) {
			orden.setSeleccionada(false);
		}
		calcularTotales();
	}

	public void chequear(Orden orden) {
		orden.setSeleccionada(!orden.isSeleccionada());
		calcularTotales();
	}

	public void chequearFact(Factura factura) {
		// if(null == factura.getFactura().getANTIC() ||
		// factura.getFactura().getANTIC().isEmpty()){
		// transaccionErronea("Error",
		// LocaleUtil.getResourceBundle().getString("error.facturas.anticipo"));
		// }else{
		factura.setSeleccionada(!factura.isSeleccionada());
		// }
	}

	public void cambiarNotaCredito() {
		notaCredito = !notaCredito;
	}

	public void chequearSeleccionada(Orden orden) {
		orden.setSeleccionada(!orden.isSeleccionada());
		calcularTotalesSeleccionadas();
	}

	public void agregarOrdenes() {
		ordenesSeleccionadas = new ArrayList();
		for (Orden orden : ordenes) {
			if (orden.isSeleccionada() && !ordenesSeleccionadas.contains(orden))
				ordenesSeleccionadas.add(orden);
		}
		if (!tieneOCSeleccionadas()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.ordenes"));
		}
		calcularTotalesSeleccionadas();
	}

	public void enviarCBB() {
		// validar que los campos hayan sido llenados
		try {
			if (isOK_CBB()) {
				Map<String, Object> respuesta = wsFactura.guardarCBB(getLanguage(), SessionUtil.getUsuarioActual(),
						SessionUtil.getRFCUsuarioActual(), sociedad.getBUKRS(), area.getAREID(), responsable.getGERID(),
						fechaFactura, factura, concepto,
						new BigDecimal(NumeroUtil.formatoNumero(new BigDecimal(subtotal))),
						impuesto.getMWSKZ() + "|" + impuesto.getTASA(), moneda.getWAERS(),
						// (notaCredito ? "X" : " "),
						pdf.getInputstream(), (null != pdfSellado ? pdfSellado.getInputstream() : null),
						// (notaCredito ? new BigDecimal("1") : new
						// BigDecimal("0"))
						notaCredito);

				if ("0".equals(respuesta.get("estatus"))) {
					transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK", (String) respuesta.get("mensaje"));
					resetCBB(true);
				} else {
					transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
				}
			}
		} catch (IOException e) {
			transaccionErronea("Error: ", e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean isOK_CBB() throws IOException {
		if (null == pdf || pdf.getFileName().isEmpty() || null == pdf.getInputstream()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.pdf"));
			return false;
		}
		if (!pdf.getFileName().toLowerCase().endsWith(".pdf")) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.segundo.pdf")
					.replaceAll("\\{0\\}", pdf.getFileName()));
			return false;
		}
		if (null != pdfSellado && !pdfSellado.getFileName().isEmpty() && null != pdfSellado.getInputstream()) {
			if (!pdfSellado.getFileName().toLowerCase().endsWith(".pdf")) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.tercer.pdf")
						.replaceAll("\\{0\\}", pdfSellado.getFileName()));
				return false;
			}
		}
		// // solo si tiene el permiso, debe cargarlo
		// if (getDebeAgregarPDFAdicional()) {
		// if (null == pdfSellado || pdfSellado.getFileName().isEmpty() || null
		// == pdfSellado.getInputstream()) {
		// transaccionErronea("Error",
		// LocaleUtil.getResourceBundle().getString("error.pdfAdicional"));
		// return false;
		// }
		// }
		if (null == sociedad || null == sociedad.getBUKRS()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
			return false;
		}
		if (null == area || null == area.getAREID()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.area"));
			return false;
		}
		if (null == responsable || null == responsable.getGERID()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.responsable"));
			return false;
		}
		if (null == fechaFactura) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.fechaFactura"));
			return false;
		}
		if (null == concepto || null == concepto.getTEXT()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.concepto"));
			return false;
		}
		if (0 == subtotal || subtotal < 0) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.subtotal"));
			return false;
		}
		if (null == impuesto || null == impuesto.getTASA()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.impuesto"));
			return false;
		}
		if (null == moneda || null == moneda.getWAERS()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.moneda"));
			return false;
		}
		return true;
	}

	public boolean isOK_CBB_OC() throws IOException {
		if (null == sociedad || null == sociedad.getBUKRS()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
			return false;
		}
		if (null == pdf || pdf.getFileName().isEmpty() || null == pdf.getInputstream()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.pdf"));
			return false;
		}
		if (!pdf.getFileName().toLowerCase().endsWith(".pdf")) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.segundo.pdf")
					.replaceAll("\\{0\\}", pdf.getFileName()));
			return false;
		}
		// // solo si tiene el permiso, debe cargarlo
		// if (getDebeAgregarPDFAdicional()) {
		// if (null == pdfSellado || pdfSellado.getFileName().isEmpty() || null
		// == pdfSellado.getInputstream()) {
		// transaccionErronea("Error",
		// LocaleUtil.getResourceBundle().getString("error.pdfAdicional"));
		// return false;
		// }
		// }
		if (null != pdfSellado && !pdfSellado.getFileName().isEmpty() && null != pdfSellado.getInputstream()) {
			if (!pdfSellado.getFileName().toLowerCase().endsWith(".pdf")) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.tercer.pdf")
						.replaceAll("\\{0\\}", pdfSellado.getFileName()));
				return false;
			}
		}
		if (null == factura || factura.isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.factura"));
			return false;
		}
		if (null == moneda || null == moneda.getWAERS()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.moneda"));
			return false;
		}
		if (null == fechaFactura) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.fechaFactura"));
			return false;
		}
		if (null == impuesto || null == impuesto.getTASA()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.impuesto"));
			return false;
		}
		if (null == ordenesSeleccionadas || !tieneOCSeleccionadas()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.ordenes"));
			return false;
		}
		return true;
	}

	private boolean tieneOCSeleccionadas() {
		for (Orden orden : ordenesSeleccionadas) {
			if (orden.isSeleccionada()) {
				return true;
			}
		}
		return false;
	}

	public boolean isOK_CFDI() throws IOException {
		if (null == sociedad || null == sociedad.getBUKRS()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
			return false;
		}
		if (null == area || null == area.getAREID()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.area"));
			return false;
		}
		if (null == responsable || null == responsable.getGERID()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.responsable"));
			return false;
		}
		if (null == factura || factura.isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.factura"));
			return false;
		}
		if (null == concepto || null == concepto.getTEXT()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.concepto"));
			return false;
		}
		if (null == pdf || pdf.getFileName().isEmpty() || null == pdf.getInputstream()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.pdf"));
			return false;
		}
		if (!pdf.getFileName().toLowerCase().endsWith(".pdf")) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.segundo.pdf")
					.replaceAll("\\{0\\}", pdf.getFileName()));
			return false;
		}
		if (null == xml || xml.getFileName().isEmpty() || null == xml.getInputstream()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.xml"));
			return false;
		} else if (!xml.getFileName().toLowerCase().endsWith(".xml")) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.tipo.xml")
					.replaceAll("\\{0\\}", xml.getFileName()));
			return false;
		} else {
			boolean isXMLValido = validarXML();
			if (!isXMLValido) {
				return false;
			}
		}
		if (null != pdfSellado && !pdfSellado.getFileName().isEmpty() && null != pdfSellado.getInputstream()) {
			if (!pdfSellado.getFileName().toLowerCase().endsWith(".pdf")) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.tercer.pdf")
						.replaceAll("\\{0\\}", pdfSellado.getFileName()));
				return false;
			}
		}
		// solo si tiene el permiso, debe cargarlo
		if (getDebeAgregarPDFAdicional()) {
			if (null == pdfSellado || pdfSellado.getFileName().isEmpty() || null == pdfSellado.getInputstream()) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.pdfAdicional"));
				return false;
			}
		}
		return true;
	}

	public boolean isOK_CFDI_OC() throws IOException {
		if (null == sociedad || null == sociedad.getBUKRS()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
			return false;
		}
		if (null == pdf || pdf.getFileName().isEmpty() || null == pdf.getInputstream()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.pdf"));
			return false;
		}
		if (!pdf.getFileName().toLowerCase().endsWith(".pdf")) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.segundo.pdf")
					.replaceAll("\\{0\\}", pdf.getFileName()));
			return false;
		}
		if (null == xml || xml.getFileName().isEmpty() || null == xml.getInputstream()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.xml"));
			return false;
		} else if (!xml.getFileName().toLowerCase().endsWith(".xml")) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.tipo.xml")
					.replaceAll("\\{0\\}", xml.getFileName()));
			return false;
		} else {
			boolean isXMLValido = validarXML();
			if (!isXMLValido) {
				return false;
			}
		}
		if (null != pdfSellado && !pdfSellado.getFileName().isEmpty() && null != pdfSellado.getInputstream()) {
			if (!pdfSellado.getFileName().toLowerCase().endsWith(".pdf")) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.archivo.tercer.pdf")
						.replaceAll("\\{0\\}", pdfSellado.getFileName()));
				return false;
			}
		}
		// solo si tiene el permiso, debe cargarlo
		if (getDebeAgregarPDFAdicional()) {
			if (null == pdfSellado || pdfSellado.getFileName().isEmpty() || null == pdfSellado.getInputstream()) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.pdfAdicional"));
				return false;
			}
		}
		if (null == ordenesSeleccionadas || !tieneOCSeleccionadas()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.ordenes"));
			return false;
		}
		return true;
	}

	public String arreglarParaIn() {
		int cuantas = 0;
		for (Orden orden : ordenesSeleccionadas) {
			if (orden.isSeleccionada())
				cuantas++;
		}
		String rtrn = "";
		int numeroValor = 1;
		for (Orden orden : ordenesSeleccionadas) {
			if (orden.isSeleccionada()) {
				rtrn += ("".equals(rtrn) ? orden.getOrden().getEBELN() + (numeroValor == cuantas ? "" : ",")
						: orden.getOrden().getEBELN() + (numeroValor == cuantas ? "" : ","));
				numeroValor++;
			}
		}
		return rtrn;
	}

	public void enviarCBBOC() {
		try {
			if (isOK_CBB_OC()) {
				Map<String, Object> respuesta = wsFactura.guardarCBBOC(getLanguage(), SessionUtil.getUsuarioActual(),
						SessionUtil.getRFCUsuarioActual(), sociedad.getBUKRS(), pdf.getInputstream(),
						(null != pdfSellado ? pdfSellado.getInputstream() : null), factura, moneda.getWAERS(),
						fechaFactura, impuesto.getMWSKZ() + "|" + impuesto.getTASA(), arreglarParaIn(), procesarOC(),
						notaCredito,
						// (notaCredito ? new BigDecimal("1") : new
						// BigDecimal("0"))
						tipoRecepcion.getTIPO());
				if ("0".equals(respuesta.get("estatus"))) {
					transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK", (String) respuesta.get("mensaje"));
					resetCBBOC(true);
				} else {
					transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
				}
			}
		} catch (IOException e) {
			transaccionErronea("Error: ", e.getMessage());
			e.printStackTrace();
		}
	}

	public void enviarCFDI() {
		try {
			if (isOK_CFDI()) {
				Map<String, Object> respuesta = wsFactura.guardarCFDI(getLanguage(), SessionUtil.getUsuarioActual(),
						SessionUtil.getRFCUsuarioActual(), sociedad.getBUKRS(), area.getAREID(), responsable.getGERID(),
						factura, concepto, xml.getInputstream(), pdf.getInputstream(),
						(null != pdfSellado ? pdfSellado.getInputstream() : null));
				if ("0".equals(respuesta.get("estatus"))) {
					transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK", (String) respuesta.get("mensaje"));
					resetCFDI(true);
				} else {
					transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
				}
			}
		} catch (IOException e) {
			transaccionErronea("Error: ", e.getMessage());
			e.printStackTrace();
		}
	}

	public void enviarCFDIOC() {
		try {
			if (isOK_CFDI_OC()) {
				Map<String, Object> respuesta = wsFactura.guardarCFDIOC(getLanguage(), SessionUtil.getUsuarioActual(),
						SessionUtil.getRFCUsuarioActual(), sociedad.getBUKRS(), arreglarParaIn(), xml.getInputstream(),
						pdf.getInputstream(), (null != pdfSellado ? pdfSellado.getInputstream() : null), procesarOC(),
						tipoRecepcion.getTIPO());
				if ("0".equals(respuesta.get("estatus"))) {
					transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK", (String) respuesta.get("mensaje"));
					reset(true);
				} else {
					transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
				}
			}
		} catch (IOException e) {
			transaccionErronea("Error: ", e.getMessage());
			e.printStackTrace();
		}
	}

	private ZPORTAL_S_OCREC[] procesarOC() {
		if (null != ordenesSeleccionadas && !ordenesSeleccionadas.isEmpty()) {
			int posicion = 0;
			ZPORTAL_S_OCREC[] array = new ZPORTAL_S_OCREC[ordenesSeleccionadas.size()];
			List<ZPORTAL_S_OCREC> holder = new ArrayList<ZPORTAL_S_OCREC>();
			ZPORTAL_S_OCREC value = new ZPORTAL_S_OCREC();
			ZPORTAL_S_OCREC item = null;
			for (Orden orden : ordenesSeleccionadas) {
				if (orden.isSeleccionada()) {
					item = new ZPORTAL_S_OCREC();
					item.setEBELN(orden.getOrden().getEBELN());
					item.setEBELP(orden.getOrden().getEBELP());
					item.setMBLNR(orden.getOrden().getMBLNR());
					item.setXBLNR(orden.getOrden().getXBLNR());
					item.setMENGE(orden.getOrden().getMENGE());
					item.setWRBTR(orden.getOrden().getNETWR());
					item.setMBLPO(orden.getOrden().getBUZEI());
					item.setMJAHR(orden.getOrden().getMJAHR());
					// item.setKPOSN(orden.getOrden().getCOND_TYPE());
					item.setKPOSN(orden.getOrden().getINVOICE_DOC_ITEM());

					array[posicion++] = item;
				}
			}
			// value.setItem(array);
			// holder.value = value;
			return array;
		}
		return null;
	}

	// public StreamedContent descargarPDF(ZfeSEdocta obj) {
	// byte[] bytes =
	// org.springframework.security.crypto.codec.Base64.decode(obj.getPdf().getBytes());
	// InputStream inputStream = new ByteArrayInputStream(bytes);
	// ExternalContext externalContext =
	// FacesContext.getCurrentInstance().getExternalContext();
	// return new DefaultStreamedContent(inputStream,
	// externalContext.getMimeType(SessionUtil.getRFCUsuarioActual() + "_" +
	// obj.getXblnr() + ".pdf"),
	// SessionUtil.getRFCUsuarioActual() + "_" + obj.getXblnr() + ".pdf");
	// }
	//
	// public StreamedContent descargarPDFSoporte(ZfeSEdocta obj) {
	// byte[] bytes =
	// org.springframework.security.crypto.codec.Base64.decode(obj.getSoporte().getBytes());
	// InputStream inputStream = new ByteArrayInputStream(bytes);
	// ExternalContext externalContext =
	// FacesContext.getCurrentInstance().getExternalContext();
	// return new DefaultStreamedContent(inputStream,
	// externalContext
	// .getMimeType(SessionUtil.getRFCUsuarioActual() + "_" + obj.getXblnr() +
	// "_Soporte" + ".pdf"),
	// SessionUtil.getRFCUsuarioActual() + "_" + obj.getXblnr() + "_Soporte" +
	// ".pdf");
	// }
	//
	// public StreamedContent descargarxML(ZfeSEdocta obj) {
	//
	// byte[] bytes =
	// org.springframework.security.crypto.codec.Base64.decode(obj.getXml().getBytes());
	// InputStream inputStream = new ByteArrayInputStream(bytes);
	// ExternalContext externalContext =
	// FacesContext.getCurrentInstance().getExternalContext();
	// return new DefaultStreamedContent(inputStream,
	// externalContext.getMimeType(SessionUtil.getRFCUsuarioActual() + "_" +
	// obj.getXblnr() + ".xml"),
	// SessionUtil.getRFCUsuarioActual() + "_" + obj.getXblnr() + ".xml");
	// }

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

	public UploadedFile getPdfSellado() {
		return pdfSellado;
	}

	public void setPdfSellado(UploadedFile pdfSellado) {
		this.pdfSellado = pdfSellado;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public BigDecimal getMontoFactura() {
		return montoFactura;
	}

	public void setMontoFactura(BigDecimal montoFactura) {
		this.montoFactura = montoFactura;
	}

	public InternacionalizacionMB getInternacionalizacionMB() {
		return internacionalizacionMB;
	}

	public void setInternacionalizacionMB(InternacionalizacionMB internacionalizacionMB) {
		this.internacionalizacionMB = internacionalizacionMB;
	}

	public List<ZPORTAL_S_TIPOS> getListaTiposRecepcion() {
		return listaTiposRecepcion;
	}

	public void setListaTiposRecepcion(List<ZPORTAL_S_TIPOS> listaTiposRecepcion) {
		this.listaTiposRecepcion = listaTiposRecepcion;
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

	public List<ZPORTAL_S_CONC> getConceptos() {
		return conceptos;
	}

	public void setConceptos(List<ZPORTAL_S_CONC> conceptos) {
		this.conceptos = conceptos;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}

	public String getOrdenesAFiltrar() {
		return ordenesAFiltrar;
	}

	public void setOrdenesAFiltrar(String ordenesAFiltrar) {
		this.ordenesAFiltrar = ordenesAFiltrar;
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

	public ZPORTAL_S_TIPOS getTipoRecepcion() {
		return tipoRecepcion;
	}

	public void setTipoRecepcion(ZPORTAL_S_TIPOS tipoRecepcion) {
		this.tipoRecepcion = tipoRecepcion;
	}

	public List<Orden> getOrdenesSeleccionadas() {
		return ordenesSeleccionadas;
	}

	public void setOrdenesSeleccionadas(List<Orden> ordenesSeleccionadas) {
		this.ordenesSeleccionadas = ordenesSeleccionadas;
	}

	public List<Orden> getOrdenesSeleccionadasTmp() {
		return ordenesSeleccionadasTmp;
	}

	public void setOrdenesSeleccionadasTmp(List<Orden> ordenesSeleccionadasTmp) {
		this.ordenesSeleccionadasTmp = ordenesSeleccionadasTmp;
	}

	public String getOcAgregar() {
		return ocAgregar;
	}

	public void setOcAgregar(String ocAgregar) {
		this.ocAgregar = ocAgregar;
	}

	public String getPedimentos() {
		return pedimentos;
	}

	public void setPedimentos(String pedimentos) {
		this.pedimentos = pedimentos;
	}

	public List<ZPORTAL_S_IMPS> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(List<ZPORTAL_S_IMPS> impuestos) {
		this.impuestos = impuestos;
	}

	public List<ZPORTAL_CMONS> getMonedas() {
		return monedas;
	}

	public void setMonedas(List<ZPORTAL_CMONS> monedas) {
		this.monedas = monedas;
	}

	public List<ZPORTAL_CSOCA> getAreas() {
		return areas;
	}

	public void setAreas(List<ZPORTAL_CSOCA> areas) {
		this.areas = areas;
	}

	public List<ZPORTAL_CSOCR> getResponsables() {
		return responsables;
	}

	public void setResponsables(List<ZPORTAL_CSOCR> responsables) {
		this.responsables = responsables;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public ZPORTAL_S_CONC getConcepto() {
		return concepto;
	}

	public void setConcepto(ZPORTAL_S_CONC concepto) {
		this.concepto = concepto;
	}

	public ZPORTAL_CSOCA getArea() {
		return area;
	}

	public void setArea(ZPORTAL_CSOCA area) {
		this.area = area;
	}

	public ZPORTAL_CSOCR getResponsable() {
		return responsable;
	}

	public void setResponsable(ZPORTAL_CSOCR responsable) {
		this.responsable = responsable;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public ZPORTAL_CMONS getMoneda() {
		return moneda;
	}

	public void setMoneda(ZPORTAL_CMONS moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getSumaImportes() {
		return sumaImportes;
	}

	public void setSumaImportes(BigDecimal sumaImportes) {
		this.sumaImportes = sumaImportes;
	}

	public ZPORTAL_S_IMPS getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(ZPORTAL_S_IMPS impuesto) {
		this.impuesto = impuesto;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public String getEstatusFactura() {
		return estatusFactura;
	}

	public void setEstatusFactura(String estatusFactura) {
		this.estatusFactura = estatusFactura;
	}

	public BigDecimal getSumaImportesSeleccionadas() {
		return sumaImportesSeleccionadas;
	}

	public void setSumaImportesSeleccionadas(BigDecimal sumaImportesSeleccionadas) {
		this.sumaImportesSeleccionadas = sumaImportesSeleccionadas;
	}

	public Date getFechaMaxima() {
		return fechaMaxima;
	}

	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}

	public boolean isNotaCredito() {
		return notaCredito;
	}

	public void setNotaCredito(boolean notaCredito) {
		this.notaCredito = notaCredito;
	}

	public List<Factura> getFacturasTmp() {
		return facturasTmp;
	}

	public void setFacturasTmp(List<Factura> facturasTmp) {
		this.facturasTmp = facturasTmp;
	}

	public List<ZPORTAL_S_LISTAOC> getListaOC() {
		return listaOC;
	}

	public void setListaOC(List<ZPORTAL_S_LISTAOC> listaOC) {
		this.listaOC = listaOC;
	}

	public StreamedContent getArchivoDescarga() {
		return archivoDescarga;
	}

	public void setArchivoDescarga(StreamedContent archivoDescarga) {
		this.archivoDescarga = archivoDescarga;
	}

	public FeFacturaBusiness getFacturaBusiness() {
		return facturaBusiness;
	}

	public void setFacturaBusiness(FeFacturaBusiness facturaBusiness) {
		this.facturaBusiness = facturaBusiness;
	}

}
