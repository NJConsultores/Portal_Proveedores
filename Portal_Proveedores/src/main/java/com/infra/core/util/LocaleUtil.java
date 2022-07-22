package com.infra.core.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Clase utilidad para obtener informacion de la session
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public class LocaleUtil {
    
    public static ResourceBundle getResourceBundle() {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    	HttpSession session = (HttpSession) externalContext.getSession(true);
    	Locale locale = (Locale) session.getAttribute("locale");
    	
    	return getResourceBundle(locale);
    }

    public static ResourceBundle getResourceBundle(HttpServletRequest req) {
    	HttpSession session = (HttpSession) req.getSession(true);
    	Locale locale = (Locale) session.getAttribute("locale");
    	
    	return getResourceBundle(locale);
    }
    
    public static ResourceBundle getResourceBundle(Locale locale) {
    	return locale == null ? ResourceBundle.getBundle("i18n.messages") : ResourceBundle.getBundle("i18n.messages", locale);
    }
    
    public static ResourceBundle getResourceBundleText(Locale locale) {
    	return locale == null ? ResourceBundle.getBundle("i18n.textMessages") : ResourceBundle.getBundle("i18n.textMessages", locale);
    }
}
