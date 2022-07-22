package com.infra.cliente.service.ws;

import java.io.IOException;
import java.io.InputStream;
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
import com.infra.service.FacturaService;
import com.infra.service.FacturaServiceImplServiceLocator;
import com.infra.service.OstatusRequest;
import com.infra.service.StatusRequest;

/**
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Service
public class WSStatusRecepcionImpl implements WSStatusRecepcion {

	private final static Logger logger = Logger.getLogger(WSStatusRecepcionImpl.class);

	private final static ResourceBundle resources = ResourceBundle.getBundle("wsdl/wsdl");

	@Override
	public Map<String, String> guardarStatusRecepcion(String idioma, String proveedorActual, InputStream xml,
			InputStream pdf, String resultado, String statusResultado) {
		logger.info("guardarStatusRecepcion [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		byte[] bytesPDF = null;
		String cadenaXML = "";
		try {
			if (null != pdf)
				bytesPDF = IOUtils.toByteArray(pdf);
			cadenaXML = StringAndInputstreamUtil.convertStreamToString(xml);
		} catch (IOException e) {
			System.out.println("Surgio un error al convertir Stream a String");
			e.printStackTrace();
		}
		
		Map respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		StatusRequest request = new StatusRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(proveedorActual);
			request.setPdf(Base64.encodeBase64String(bytesPDF));
			request.setXml(Base64.encodeBase64String(cadenaXML.getBytes()));
			request.setMensajeRespuesta(resultado);
			request.setEstatusRespuesta(statusResultado);
			request.setFecha(FechaUtil.formatoWS(new Date()));
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.status(request);
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
	public Map<String, Object> getEstatusRecepcion(Date fechaDesde, Date fechaHasta, String idioma,
			String proveedorActual, String sociedad) {
		logger.info("getEstatusRecepcion [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		OstatusRequest request = new OstatusRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(proveedorActual);
			request.setSociedad(sociedad);
			request.setFechaInicio(FechaUtil.formatoWS(fechaDesde));
			request.setFechaFin(FechaUtil.formatoWS(fechaHasta));
			
			FacturaService service = locator.getFacturaServiceImplPort();
			request = service.ostatus(request);
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

}
