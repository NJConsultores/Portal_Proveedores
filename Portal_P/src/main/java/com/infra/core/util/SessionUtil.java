
package com.infra.core.util;

import java.util.Locale;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.infra.core.model.UsuarioWS;

/**
 * Clase utilidad para obtener informacion de la session
 * 
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public class SessionUtil {

	public static String getCurrentUser() {
		String name = "";
		SecurityContext ctx = SecurityContextHolder.getContext();

		if (ctx != null) {
			Authentication a = ctx.getAuthentication();

			if (a != null) {
				name = a.getName();
			}
		}

		return name;

	}

	public static String consultaIpCliente() {
		String ip = "";

		FacesContext c = FacesContext.getCurrentInstance();

		if (c != null) {
			ExternalContext exc = c.getExternalContext();

			if (exc != null) {

				HttpServletRequest req = (HttpServletRequest) exc.getRequest();

				if (req != null) {
					ip = req.getHeader("X-FORWARDED-FOR");

					if (ip == null) {
						ip = req.getRemoteAddr();
					}
				}
			}
		}

		return ip;
	}

	public static UsuarioWS getUsuario() {
		UsuarioWS usuario = new UsuarioWS();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null) {
			Object principal = authentication.getPrincipal();

			if (principal != null) {
				if (principal instanceof UsuarioWS) {
					usuario = (UsuarioWS) authentication.getPrincipal();
				}
			}
		}

		return usuario;
	}

	public static Locale getLocale() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = null;
		Locale locale = Locale.getDefault();

		if (context != null) {
			ec = context.getExternalContext();
			if (ec != null) {
				HttpSession session = (HttpSession) ec.getSession(true);
				locale = (Locale) session.getAttribute("locale");
			}
		}

		return locale;
	}

	public static String getUsuarioActual() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioWS usuario = (UsuarioWS) authentication.getPrincipal();
		return usuario.getNombreUser();
	}

	public static String getRFCUsuarioActual() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(null != authentication){
//			System.out.println("getRFCUsuarioActual es diferente de null:");
			UsuarioWS usuario = (UsuarioWS) authentication.getPrincipal();
			return usuario.getRfc();
		}else{
			return "";
		}
	}

	public static int getNumeroDiasEdoCta() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioWS usuario = (UsuarioWS) authentication.getPrincipal();
		return Integer.parseInt((null != usuario.getConsper() ? usuario.getConsper() : "0"));
	}

}
