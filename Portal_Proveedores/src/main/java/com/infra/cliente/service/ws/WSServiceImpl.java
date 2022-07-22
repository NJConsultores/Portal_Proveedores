package com.infra.cliente.service.ws;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.infra.core.ws.exception.WSException;
import com.infra.factura.util.FechaUtil;
import com.infra.service.AvisosRequest;
import com.infra.service.CatalogoService;
import com.infra.service.CatalogoServiceImplServiceLocator;
import com.infra.service.CoreService;
import com.infra.service.CoreServiceImplServiceLocator;
import com.infra.service.FacturaService;
import com.infra.service.FacturaServiceImplServiceLocator;
import com.infra.service.LareasRequest;
import com.infra.service.LimpsRequest;
import com.infra.service.LmonRequest;
import com.infra.service.LpedRequest;
import com.infra.service.LrareaRequest;
import com.infra.service.LregionRequest;
import com.infra.service.OavisosRequest;
import com.infra.service.ProvrRequest;
import com.infra.service.SociedadesRequest;
import com.infra.service.TiposRequest;

/**
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Service
public class WSServiceImpl implements WSService {

	private final static Logger logger = Logger.getLogger(WSServiceImpl.class);

	private final static ResourceBundle resources = ResourceBundle.getBundle("wsdl/wsdl");

	@Override
	public Map<String, Object> getMonedas(String idioma) {
		Map respuesta = new HashMap<String, Object>();
		CatalogoServiceImplServiceLocator locator = new CatalogoServiceImplServiceLocator();
		LmonRequest request = new LmonRequest();
		try {
			locator.setCatalogoServiceImplPortEndpointAddress(resources.getString("catalogo"));
			request.setIdioma(idioma);
			
			CatalogoService service = locator.getCatalogoServiceImplPort();
			
			request = service.lmon(request);
			
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getMonedas());
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
	public Map<String, Object> getOrdenes(String idioma, String proveedor, String sociedad, Date fechaDesde,
			Date fechaHasta, String tipo, String filtroOrdenes, String pedimentos) {
		Map respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		LpedRequest request = new LpedRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(proveedor);
			request.setSociedad(sociedad);
			request.setFechaInicio(FechaUtil.formatoWS(fechaDesde));
			request.setFechaFin(FechaUtil.formatoWS(fechaHasta));
			request.setTipo(tipo);
			request.setOcBuscar(filtroOrdenes);
			request.setPedimentosBuscar(pedimentos);
			
			FacturaService service = locator.getFacturaServiceImplPort();
			
			request = service.lped(request);
			
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
	public Map<String, Object> getSociedades(String idioma, String sociedad) {
		logger.info("getSociedades [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		SociedadesRequest request = new SociedadesRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(sociedad);
			
			FacturaService service = locator.getFacturaServiceImplPort();
			
			request = service.sociedades(request);
			
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
	public Map<String, Object> getImpuestos(String idioma, String sociedad) {
		logger.info("getImpuestos [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		CatalogoServiceImplServiceLocator locator = new CatalogoServiceImplServiceLocator();
		LimpsRequest request = new LimpsRequest();
		try {
			locator.setCatalogoServiceImplPortEndpointAddress(resources.getString("catalogo"));
			request.setIdioma(idioma);
			request.setSociedad(sociedad);
			
			CatalogoService service = locator.getCatalogoServiceImplPort();
			
			request = service.limps(request);
			
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getImpuestos());
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
	public Map<String, Object> getAvisos(String idioma, String sociedad) {
		logger.info("getAvisos [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		CoreServiceImplServiceLocator locator = new CoreServiceImplServiceLocator();
		OavisosRequest request = new OavisosRequest();
		try {
			locator.setCoreServiceImplPortEndpointAddress(resources.getString("core"));
			
			CoreService service = locator.getCoreServiceImplPort();
			
			request.setIdioma(idioma);
			request.setProveedor(sociedad);
			
			request = service.oavisos(request);
//			System.out.println("request.getAvisos(): "+request.getAvisos().length);
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getAvisos());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException: ", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Map<String, Object> getTiposRecepcion(String idioma, String sociedad) {
		logger.info("getTiposRecepcion [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		FacturaServiceImplServiceLocator locator = new FacturaServiceImplServiceLocator();
		TiposRequest request = new TiposRequest();
		try {
			locator.setFacturaServiceImplPortEndpointAddress(resources.getString("factura"));
			request.setIdioma(idioma);
			request.setProveedor(sociedad);
			
			FacturaService service = locator.getFacturaServiceImplPort();
			
			request = service.tipos(request);
			
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getTipos());
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
	public Map<String, Object> getAreas(String idioma, String sociedad) {
		logger.info("getAreas [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		CatalogoServiceImplServiceLocator locator = new CatalogoServiceImplServiceLocator();
		LareasRequest request = new LareasRequest();
		try {
			locator.setCatalogoServiceImplPortEndpointAddress(resources.getString("catalogo"));
			request.setIdioma(idioma);
			request.setSociedad(sociedad);
			
			CatalogoService service = locator.getCatalogoServiceImplPort();
			
			request = service.lareas(request);
			
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getAreas());
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
	public Map<String, Object> getResponsables(String idioma, String sociedad, String area) {
		logger.info("getResponsables [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		CatalogoServiceImplServiceLocator locator = new CatalogoServiceImplServiceLocator();
		LrareaRequest request = new LrareaRequest();
		try {
			locator.setCatalogoServiceImplPortEndpointAddress(resources.getString("catalogo"));
			request.setIdioma(idioma);
			request.setSociedad(sociedad);
			request.setArea(area);
			
			CatalogoService service = locator.getCatalogoServiceImplPort();
			
			request = service.lrarea(request);
			
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getResponsables());
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
	public String descartarMensaje(short idAviso, String idioma, String sociedad) {
		logger.info("descartarMensaje [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		CoreServiceImplServiceLocator locator = new CoreServiceImplServiceLocator();
		AvisosRequest request = new AvisosRequest();
		try {
			locator.setCoreServiceImplPortEndpointAddress(resources.getString("core"));
			
			CoreService service = locator.getCoreServiceImplPort();
			
			request.setIdioma(idioma);
			request.setProveedor(sociedad);
			request.setEstatusAviso(idAviso);
			
			request = service.avisos(request);
			
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException: ", e);
			throw new WSException(e.getMessage());
		}
		return request.getMensaje();
	}
	
	@Override
	public Map<String, Object> lregion(LregionRequest request) {
		logger.info("lregion [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		CatalogoServiceImplServiceLocator locator = new CatalogoServiceImplServiceLocator();
		try {
			locator.setCatalogoServiceImplPortEndpointAddress(resources.getString("catalogo"));
			
			CatalogoService service = locator.getCatalogoServiceImplPort();
			
			request = service.lregion(request);
			
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
			respuesta.put("lista", request.getRegiones());
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
	public Map<String, Object> provr(ProvrRequest request) {
		logger.info("provr [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]");
		Map respuesta = new HashMap<String, Object>();
		CatalogoServiceImplServiceLocator locator = new CatalogoServiceImplServiceLocator();
		try {
			locator.setCatalogoServiceImplPortEndpointAddress(resources.getString("catalogo"));
			
			CatalogoService service = locator.getCatalogoServiceImplPort();
			
			request = service.provr(request);
			
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
