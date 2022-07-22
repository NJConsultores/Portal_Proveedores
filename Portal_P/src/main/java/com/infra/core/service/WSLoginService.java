package com.infra.core.service;

import java.util.List;
import java.util.Map;

/**
*
* @author Reyna Lagunas Aranda <reyna.lagunas@infra.com.mx>
*/
public interface WSLoginService {
	public Map<String, Object> iniciarSesion(String idioma, String username, String password);

	public Map<String, String> actualizarPassword(String idioma, String nuevoPassword, String oldPassword, String pin,
			String usuario);

	public Map<String, String> solicitarRestablecerPassword(String idioma, String usuario);
	
	public Map<String, String> actualizarCorreo(String idioma, String correo, String proveedor);
	
	public Map<String, Object> cargarMultas(String idioma, String proveedor, String sociedad);
}
