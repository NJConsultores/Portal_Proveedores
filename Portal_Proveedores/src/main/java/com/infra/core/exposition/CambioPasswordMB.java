//
// 
// 
// 
 
package com.infra.core.exposition;

import com.infra.core.model.UsuarioWS;
import com.infra.core.service.WSLoginService;
import com.infra.core.util.LocaleUtil;
import com.infra.util.AbstractControlador;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
 
@Controller
@Scope("request")
public class CambioPasswordMB extends AbstractControlador {
	private static final Logger logger = LoggerFactory.getLogger(CambioPasswordMB.class);
	private static final long serialVersionUID = 1L;
	@Autowired
    protected WSLoginService loginService;
    @Autowired
    protected InternacionalizacionMB internacionalizacionMB;
    private UsuarioWS usuario;
    protected String password;
    protected String nuevoPassword;
    protected String confirmarPassword;
    protected boolean diseable;
    
    
    
    
    @PostConstruct
    public void init() {
        this.password = "";
        this.nuevoPassword = "";
        this.confirmarPassword = "";
        this.buildUsuarioSeguridad();
    }

    private void buildUsuarioSeguridad() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal != null) {
                this.usuario = (UsuarioWS)authentication.getDetails();
            } else {
                logger.debug("El objeto principal es nulo");
            }
        }

    }

	public String getUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public String getNombreCompleto() {
		logger.debug("Nombre completo");
		diseable = false;
		String nombre = "NOMBRE COMPLETO";
		return nombre;
	}
	//if (validaPassword(nuevoPassword)) { 
	public void cambiarPassword() {
		logger.debug("Cambiar Password");
        logger.debug("Cuenta");
        
        try {
        	if (validaPassword(nuevoPassword)) { 
                if (this.validaPassword(this.nuevoPassword)) {
                    Map<String, String> respuesta = this.loginService.actualizarPassword(this.getLanguage(), this.nuevoPassword, this.password, (String)null, this.usuario.getNombreUser());
                    if ("1".equals((String)respuesta.get("estatus"))) {
                        this.transaccionErronea("Error: ", (String)respuesta.get("mensaje"));
                    } else {
                        this.transaccionCompletada(false, 1, "OK", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.ok"));
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.password").replaceAll("\\{0\\}", this.nuevoPassword), ""));
                }
            }
        } catch (Exception var2) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.error")));
        }

	}
	
    private boolean validarCampos() {
        if (this.password != null && !this.password.isEmpty()) {
            if (this.nuevoPassword != null && !this.nuevoPassword.isEmpty()) {
                if (this.confirmarPassword != null && !this.confirmarPassword.isEmpty()) {
                    if (this.nuevoPassword != null && !this.nuevoPassword.isEmpty() && (this.confirmarPassword != null || !this.confirmarPassword.isEmpty()) && !this.nuevoPassword.equals(this.confirmarPassword)) {
                        FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.nuevas.no.coinciden")));
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.nueva.confirmar.requerido")));
                    return false;
                }
            } else {
                FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.nueva.requerido")));
                return false;
            }
        } else {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.actual.requerido")));
            return false;
        }
    }

	 private boolean validaPassword(String password) {
	        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$");
	        Matcher matcher = pattern.matcher(password);
	        return matcher.matches();
	    }

	private String getLanguage() {
        return "es".equals(this.internacionalizacionMB.getLanguage()) ? "S" : "E";
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNuevoPassword() {
        return this.nuevoPassword;
    }

    public void setNuevoPassword(String nuevoPassword) {
        this.nuevoPassword = nuevoPassword;
    }

    public String getConfirmarPassword() {
        return this.confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    public boolean isDiseable() {
        return this.diseable;
    }

    public void setDiseable(boolean diseable) {
        this.diseable = diseable;
    }
}
