/*
 Internacionalizacion
 */


package com.infra.core.exposition;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import com.infra.factura.exposition.AddendaMB;
import com.infra.factura.exposition.AltaProveedorMB;
import com.infra.factura.exposition.ComplementoMB;
import com.infra.factura.exposition.EnviarFacturaMB;
import com.infra.factura.exposition.EstatusRecepcionMB;
import com.infra.factura.exposition.PeticionOfertaMB;

@Controller("language")
@Scope("session")
public class InternacionalizacionMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Locale locale;
	private static final Map<String, Object> countries;
	private String language;

	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("es", new Locale("es", "MX")); // label, value
		countries.put("en", Locale.US);
	}

	@PostConstruct
	public void init() {
		try {
			System.out.println("Iniciando InternacionalizacionMB");
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

			if (ec != null) {
				HttpSession session = (HttpSession) ec.getSession(true);
				setLocale(new Locale("es", "MX"));
				establecerLocale(locale);
			}
		} catch (Exception e) {
		}
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		String lenguaje = locale.getLanguage();
		this.locale = locale;
		setLanguage(lenguaje);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setEnglish(ActionEvent event) {
		setLocale((Locale) getCountriesInMap().get("en"));
		establecerLocale(getLocale());
	}

	public void setSpanish(ActionEvent event) {
		setLocale((Locale) getCountriesInMap().get("es"));
		establecerLocale(getLocale());
	}

	private void establecerLocale(Locale locale) {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		if (ec != null) {
			HttpSession session = (HttpSession) ec.getSession(true);
			session.setAttribute("locale", locale);
		}

		FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) locale);
		Locale.setDefault((Locale) locale);
		
		setManagedBeans();
	}

	public void setManagedBeans() { 
		AvisosMB avisosMB = (AvisosMB) ContextLoader.getCurrentWebApplicationContext().getBean("avisosMB");
		EnviarFacturaMB enviarFacturaMB = (EnviarFacturaMB) ContextLoader.getCurrentWebApplicationContext()
				.getBean("enviarFacturaMB");
		EstatusRecepcionMB estatusRecepcionMB = (EstatusRecepcionMB) ContextLoader.getCurrentWebApplicationContext()
				.getBean("estatusRecepcionMB"); 
		ComplementoMB complementoMB = (ComplementoMB) ContextLoader.getCurrentWebApplicationContext()
				.getBean("complementoMB");
		PeticionOfertaMB peticionOfertaMB = (PeticionOfertaMB) ContextLoader.getCurrentWebApplicationContext()
				.getBean("peticionOfertaMB");
		AltaProveedorMB altaProveedorMB = (AltaProveedorMB) ContextLoader.getCurrentWebApplicationContext()
				.getBean("altaProveedorMB");
		AddendaMB addendaMB = (AddendaMB) ContextLoader.getCurrentWebApplicationContext()
				.getBean("addendaMB");
	 
		
	}
}
