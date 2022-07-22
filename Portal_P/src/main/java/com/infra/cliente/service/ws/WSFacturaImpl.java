package com.infra.cliente.service.ws;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.xml.rpc.ServiceException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.infra.core.ws.exception.WSException;
import com.infra.factura.business.schema.util.StringAndInputstreamUtil;
import com.infra.factura.util.Base64;
import com.infra.factura.util.FechaUtil;
import com.infra.service.AvisoPdfRequest;
import com.infra.service.CpfactsRequest;
import com.infra.service.CppagosRequest;
import com.infra.service.CprecepRequest;
import com.infra.service.FactRequest;
import com.infra.service.FacturaService;
import com.infra.service.FacturaServiceImplServiceLocator;
import com.infra.service.LconcRequest;
import com.infra.service.LcondRequest;
import com.infra.service.LconsRequest;
import com.infra.service.LfactRequest;
import com.infra.service.LincotRequest;
import com.infra.service.ListaOCRequest;
import com.infra.service.ListanRequest;
import com.infra.service.LspoferRequest;
import com.infra.service.PoferdRequest;
import com.infra.service.PoferhRequest;
import com.infra.service.PoferrRequest;
import com.infra.service.PofersRequest;
import com.infra.service.RadendaRequest;
import com.infra.service.RantRequest;
import com.infra.service.RconsRequest;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_CONC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC;

/**
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Service
public class WSFacturaImpl implements WSFactura {

	private final static Logger logger = Logger.getLogger(WSFacturaImpl.class);
	private final static ResourceBundle resources = ResourceBundle.getBundle("wsdl/wsdl");

	@Override
	public Map<String, Object> guardarCFDIOC(String idioma, String proveedorActual, String rfcActual, String sociedad,
			String ordenes, InputStream xml, InputStream pdf, InputStream otroPdf, ZPORTAL_S_OCREC[] holder, String tipo) {
		logger.info("guardarCFDIOC [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		String cadenaXML = "";
		byte[] bytesOtro = null;
		byte[] bytesPDF = null;
		try {
			if (null != xml)
				cadenaXML = StringAndInputstreamUtil.convertStreamToString(xml);
			if (null != otroPdf)
				bytesOtro = IOUtils.toByteArray(otroPdf);
			if (null != pdf)
				bytesPDF = IOUtils.toByteArray(pdf);
		} catch (IOException e) {
			System.out.println("Surgio un error al convertir Stream a String");
			e.printStackTrace();
		}
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		FactRequest request = new FactRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(proveedorActual);
			request.setRfc(rfcActual);
			request.setSociedad(sociedad);
			request.setOrdenes(holder);
			request.setPdf(Base64.encodeBase64String(bytesPDF));
			request.setTipo(tipo);
			request.setOtroPDF((null != otroPdf ? Base64.encodeBase64String(bytesOtro) : ""));
			request.setXml(Base64.encodeBase64String(cadenaXML.getBytes()));
			
			FacturaService service = locator.getFacturaServiceImplPort();

			request = service.fact(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Map<String, Object> guardarCFDI(String idioma, String proveedorActual, String rfcActual, String sociedad,
			String area, String responsable, String factura, ZPORTAL_S_CONC concepto, InputStream xml, InputStream pdf,
			InputStream otroPdf) {
		logger.info("guardarCFDI [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		String cadenaXML = "";
		byte[] bytesOtro = null;
		byte[] bytesPDF = null;
		try {
			if (null != xml)
				cadenaXML = StringAndInputstreamUtil.convertStreamToString(xml);
			if (null != otroPdf)
				bytesOtro = IOUtils.toByteArray(otroPdf);
			if (null != pdf)
				bytesPDF = IOUtils.toByteArray(pdf);
		} catch (IOException e) {
			System.out.println("Surgio un error al convertir Stream a String");
			e.printStackTrace();
		}
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		FactRequest request = new FactRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(proveedorActual);
			request.setRfc(rfcActual);
			request.setSociedad(sociedad);
			request.setArea(area);
			request.setResponsable(responsable);
			request.setSerie(factura);
			request.setConcepto(concepto);
			request.setPdf(Base64.encodeBase64String(bytesPDF));
			request.setTipo("1");
			request.setOtroPDF((null != otroPdf ? Base64.encodeBase64String(bytesOtro) : ""));
			request.setXml(Base64.encodeBase64String(cadenaXML.getBytes()));
			
			FacturaService service = locator.getFacturaServiceImplPort();

			request = service.fact(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Map<String, Object> guardarCBB(String idioma, String proveedorActual, String rfcActual, String sociedad,
			String area, String responsable, Date fechaFactura, String factura, ZPORTAL_S_CONC concepto, BigDecimal subtotal,
			String iva, String moneda, InputStream pdf, InputStream otroPdf, boolean isNotaCredito) {
		logger.info("guardarCBB [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		byte[] bytesOtro = null;
		byte[] bytesPDF = null;
		try {
			if (null != otroPdf)
				bytesOtro = IOUtils.toByteArray(otroPdf);
			bytesPDF = IOUtils.toByteArray(pdf);
		} catch (IOException e) {
			System.out.println("Surgio un error al convertir Stream a String");
			e.printStackTrace();
		}
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		FactRequest request = new FactRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(proveedorActual);
			request.setRfc(rfcActual);
			request.setSociedad(sociedad);
			request.setArea(area);
			request.setResponsable(responsable);
			request.setFecha(FechaUtil.formatoWS(fechaFactura));
			request.setSerie(factura);
			request.setConcepto(concepto);
			request.setSubtotal(subtotal);
			request.setIva(iva);
			request.setMoneda(moneda);
			request.setNotaCredito(isNotaCredito ? "X": " ");
			request.setPdf(Base64.encodeBase64String(bytesPDF));
			request.setTipo("1");
			request.setOtroPDF((null != otroPdf ? Base64.encodeBase64String(bytesOtro) : ""));

			FacturaService service = locator.getFacturaServiceImplPort();

			request = service.fact(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Map<String, Object> guardarCBBOC(String idioma, String proveedorActual, String rfcActual, String sociedad,
			InputStream pdf, InputStream otroPdf, String factura, String moneda, Date fechaFactura, String iva,
			String ordenes, ZPORTAL_S_OCREC[] holder, boolean isNotaCredito, String tipo) {
		logger.info("guardarCBBOC [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		FactRequest request = new FactRequest();
		byte[] bytesOtro = null;
		byte[] bytesPDF = null;
		try {
			if (null != otroPdf)
				bytesOtro = IOUtils.toByteArray(otroPdf);
			bytesPDF = IOUtils.toByteArray(pdf);
		} catch (IOException e) {
			System.out.println("Surgio un error al convertir Stream a String");
			e.printStackTrace();
		}
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(proveedorActual);
			request.setRfc(rfcActual);
			request.setSociedad(sociedad);
			// request.setArea(area);
			// request.setResponsable(responsable);
			request.setFecha(FechaUtil.formatoWS(fechaFactura));
			request.setSerie(factura);
			// request.setConcepto(concepto);
			// request.setSubtotal(subtotal);
			request.setIva(iva);
			request.setMoneda(moneda);
			request.setNotaCredito(isNotaCredito ? "X" : " ");
			request.setPdf(Base64.encodeBase64String(bytesPDF));
			request.setTipo(tipo);
			request.setOtroPDF((null != otroPdf ? Base64.encodeBase64String(bytesOtro) : ""));
			request.setOrdenes(holder);

			FacturaService service = locator.getFacturaServiceImplPort();

			request = service.fact(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Map<String, Object> getFacturas(Date fechaDesde, Date fechaHasta, String idioma, String proveedorActual,
			String sociedad, String estatusFactura, InputStream xml, InputStream pdf) {
		logger.info("getFacturas [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		String cadenaXML = "";
		byte[] bytesPDF = null;
		try {
			if (null != xml)
				cadenaXML = StringAndInputstreamUtil.convertStreamToString(xml);
			if (null != pdf)
				bytesPDF = IOUtils.toByteArray(pdf);
		} catch (IOException e) {
			System.out.println("Surgio un error al convertir Stream a String");
			e.printStackTrace();
		}
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		LfactRequest request = new LfactRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(proveedorActual);
			request.setStatus(estatusFactura);
			request.setSociedad(sociedad);
			request.setFechaInicio(FechaUtil.formatoWS(fechaDesde));
			request.setFechaFin(FechaUtil.formatoWS(fechaHasta));
			
			request.setPdf(Base64.encodeBase64String(bytesPDF));
			request.setXml(Base64.encodeBase64String(cadenaXML.getBytes()));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.lfact(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getListado());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	// @Override
	// public Map<String, Object> getEdoCta(Date fechaDesde, Date fechaHasta,
	// String idioma, String proveedorActual,
	// String sociedad, String estatusFactura) {
	// logger.info("getEdoCta [" + new SimpleDateFormat("dd/MM/yyyy
	// HH:mm:ss").format(new Date()) + "]");
	// StringHolder mensaje = new javax.xml.rpc.holders.StringHolder();
	// org.apache.axis.holders.UnsignedByteHolder status = new
	// org.apache.axis.holders.UnsignedByteHolder();
	// ZfeTEdoctaHolder holder = new ZfeTEdoctaHolder();
	// Map respuesta = new HashMap<String, String>();
	// List<ZfeSEdocta> listaEdo = new ArrayList();
	// try {
	// GET_EDO_CTALocator locator = new GET_EDO_CTALocator();
	// locator.setGET_EDO_CTAEndpointAddress(resources.getString("listaEdoCta"));
	// ZFE_GET_EDO_CTA getEdoCta = locator.getGET_EDO_CTA();
	// getEdoCta.zfeGetEdoCta(sociedad, FechaUtil.formatoWS(fechaHasta),
	// FechaUtil.formatoWS(fechaDesde), idioma,
	// proveedorActual, estatusFactura, holder, mensaje, status);
	// ZfeSEdocta[] arreglo = holder.value.getItem();
	// if (null != arreglo) {
	// listaEdo = Arrays.asList(arreglo);
	// }
	// respuesta.put("estatus", status.value.toString());
	// respuesta.put("mensaje", mensaje.value);
	// } catch (ServiceException e) {
	// logger.error("Unable to reach service:", e);
	// throw new WSException(e.getMessage());
	// } catch (RemoteException e) {
	// logger.error("RemoteException: ", e);
	// throw new WSException(e.getMessage());
	// }
	// return respuesta;
	// }
	
	@Override
	public Map<String, Object> guardarAnticipos(RantRequest request) {
		logger.info("guardarAnticipos [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.rant(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> getListaOC(ListaOCRequest request){
		logger.info("getListaOC [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.lista_oc(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getListado());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> notificaDescargaPDF(AvisoPdfRequest request){
		logger.info("notificaDescargaPDF [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.aviso_pdf(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> cpfacts(CpfactsRequest request){
		logger.info("cpfacts [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.cpfacts(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> cppagos(CppagosRequest request){
		logger.info("cppagos [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.cppagos(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> cprecep(CprecepRequest request){
		logger.info("cprecep [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.cprecep(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Map<String, Object> lcons(LconsRequest request){
		logger.info("lcons [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.lcons(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> rcons(RconsRequest request){
		logger.info("rcons [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.rcons(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> lconc(LconcRequest request){
		logger.info("lconc [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.lconc(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> lcond(LcondRequest request){
		logger.info("lcond [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.lcond(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> lincot(LincotRequest request){
		logger.info("lincot [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.lincot(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> listan(ListanRequest request){
		logger.info("listan [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.listan(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> poferd(PoferdRequest request){
		logger.info("poferd [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.poferd(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> poferh(PoferhRequest request){
		logger.info("poferh [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.poferh(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> poferr(PoferrRequest request){
		logger.info("poferr [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.poferr(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> pofers(PofersRequest request){
		logger.info("pofers [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			System.out.println("locator: "+locator.getFacturaServiceImplPortAddress());
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.pofers(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> lspofer(LspoferRequest request){
		logger.info("lspofer [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.lspofer(request);
			respuesta.put("lista", request.getListado());
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public Map<String, Object> radenda(RadendaRequest request){
		logger.info("radenda [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			
			System.out.println("locator: "+locator.getFacturaServiceImplPortAddress());
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.radenda(request);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException:", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}
	
}
