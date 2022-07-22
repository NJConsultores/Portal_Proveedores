




package com.infra.core.service;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.xml.rpc.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.infra.core.ws.exception.WSException;
import com.infra.service.CoreService;
import com.infra.service.CoreServiceImplServiceLocator;
import com.infra.service.CorreoRequest;
import com.infra.service.LoginRequest;
import com.infra.service.MultasRequest;
import com.infra.service.PasswdRequest;
import com.infra.service.PinRequest;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas@infra.com.mx>
 */
@Service
public class WSLoginServiceImpl implements WSLoginService {

	private final static Logger logger = Logger.getLogger(WSLoginServiceImpl.class);
	private final static ResourceBundle resources = ResourceBundle.getBundle("wsdl/wsdl");

	@Override
	public Map<String, Object> iniciarSesion(String idioma, String username, String password) {
		Map<String, Object> informacionSesion = new HashMap<>();
		CoreServiceImplServiceLocator locator = new CoreServiceImplServiceLocator();
		LoginRequest request = new LoginRequest();
		try {
			locator.setCoreServiceImplPortEndpointAddress(resources.getString("core"));

			request.setUsuario(username);
			request.setPassword(password);
			request.setIdioma(idioma);

			// System.out.println("Antes de invocar el WS:
			// "+request.getDatos());

			CoreService service = locator.getCoreServiceImplPort();

			request = service.login(request);

			// System.out.println("Despues de invocar el WS:
			// "+request.getDatos());

			informacionSesion.put("datos", request.getDatos());
			informacionSesion.put("mensaje", request.getMensaje());
			informacionSesion.put("opciones", request.getOpciones());
			informacionSesion.put("status", request.getEstatus());
			informacionSesion.put("sociedades", request.getSociedades());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			System.out.println("RemoteException: " + e.getMessage());
			logger.error("RemoteException: ", e);
			throw new WSException(e.getMessage());
		}
		return informacionSesion;
	}

	@Override
	public Map<String, String> actualizarPassword(String idioma, String nuevoPassword, String oldPassword, String pin,
			String usuario) {
		Map respuesta = new HashMap<String, String>();
		CoreServiceImplServiceLocator locator = new CoreServiceImplServiceLocator();
		PasswdRequest request = new PasswdRequest();
		try {
			locator.setCoreServiceImplPortEndpointAddress(resources.getString("core"));

			CoreService service = locator.getCoreServiceImplPort();

			request.setIdioma(idioma);
			request.setPassword(nuevoPassword);
			request.setOldPassword(oldPassword);
			request.setPin(pin);
			request.setUsuario(usuario);

			request = service.passwd(request);

			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("RLA Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RLA RemoteException: ", e);
			System.out.println("RLA: " + e.getMessage());
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Map<String, String> actualizarCorreo(String idioma, String correo, String proveedor) {
		Map respuesta = new HashMap<String, String>();
		CoreServiceImplServiceLocator locator = new CoreServiceImplServiceLocator();
		CorreoRequest request = new CorreoRequest();
		try {
			locator.setCoreServiceImplPortEndpointAddress(resources.getString("core"));

			CoreService service = locator.getCoreServiceImplPort();

			request.setIdioma(idioma);
			request.setCorreo(correo);
			request.setProveedor(proveedor);
			request = service.correo(request);

			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("RLA Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RLA RemoteException: ", e);
			System.out.println("RLA: " + e.getMessage());
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Map<String, String> solicitarRestablecerPassword(String idioma, String usuario) {
		Map respuesta = new HashMap<String, String>();
		CoreServiceImplServiceLocator locator = new CoreServiceImplServiceLocator();
		PinRequest request = new PinRequest();
		try {
			locator.setCoreServiceImplPortEndpointAddress(resources.getString("core"));

			CoreService service = locator.getCoreServiceImplPort();

			request.setIdioma(idioma);
			request.setUsuario(usuario);

			request = service.pin(request);

			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
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
	public Map<String, Object> cargarMultas(String idioma, String proveedor, String sociedad) {
		Map respuesta = new HashMap<String, Object>();
		CoreServiceImplServiceLocator locator = new CoreServiceImplServiceLocator();
		MultasRequest request = new MultasRequest();
		try {
			locator.setCoreServiceImplPortEndpointAddress(resources.getString("core"));
			
			CoreService service = locator.getCoreServiceImplPort();
			
			request.setIdioma(idioma);
			request.setProveedor(proveedor);
			request.setSociedad(sociedad);
			
			request = service.multas(request);
			
			respuesta.put("S_BONIF_ESP", request.getS_BONIF_ESP());
			respuesta.put("S_BONIFICACIONES", request.getS_BONIFICACIONES());
			respuesta.put("S_MULTAS", request.getS_MULTAS());
			respuesta.put("S_REB_ANUAL", request.getS_REB_ANUAL());
			respuesta.put("S_DETALLE_MULTAS", request.getS_DETALLE_MULTAS());
			
			respuesta.put("estatus", request.getEstatus());
			respuesta.put("mensaje", request.getMensaje());
		} catch (ServiceException e) {
			logger.error("Unable to reach service:", e);
			throw new WSException(e.getMessage());
		} catch (RemoteException e) {
			logger.error("RemoteException: ", e);
			throw new WSException(e.getMessage());
		}
		return respuesta;
	}

}
