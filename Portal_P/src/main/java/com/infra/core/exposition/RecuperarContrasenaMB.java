// 
// Decompiled by Procyon v0.5.36
// 


package com.infra.core.exposition;

import javax.faces.context.FacesContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import com.infra.core.util.LocaleUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.infra.core.service.WSLoginService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import com.infra.util.AbstractControlador;

@Scope("request")
@Controller
public class RecuperarContrasenaMB extends AbstractControlador
{
    private static final long serialVersionUID = 1L;
    private final Logger logger;
    @Autowired
    protected WSLoginService loginService;
    @Autowired
    protected InternacionalizacionMB internacionalizacionMB;
    protected String username;
    protected String nuevoPassword;
    protected String nuevoPasswordConfirmar;
    protected String pin;
    protected boolean pinSolicitado;
    protected boolean disable;
    protected boolean recuperada;
    protected boolean cambioEnProceso;
    
    public RecuperarContrasenaMB() {
        this.logger = LoggerFactory.getLogger((Class)RecuperarContrasenaMB.class);
    }
    
    public void submit() {
        this.pinSolicitado = true;
        this.recuperada = false;
        this.logger.debug("Intentando recuperar contrasena");
        final Map<String, String> respuesta = (Map<String, String>)this.loginService.solicitarRestablecerPassword(this.getLanguage(), this.username);
        if ("1".equals(respuesta.get("estatus"))) {
            this.transaccionErronea("Error: ", (String)respuesta.get("mensaje"));
            this.pinSolicitado = false;
            this.limpiarCampos(true);
        }
        else {
            final String usuario = this.username;
            System.out.println("usuario: " + usuario);
            this.username = usuario;
            System.out.println("username: " + this.username);
            this.transaccionCompletada(false, 1, "OK", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.solicitud.procesarPin"));
            this.cambioEnProceso = true;
        }
    }
    
    public void validarPin() {
        this.logger.debug("Restableciendo contrasena");
        this.pinSolicitado = true;
        final String usuario = this.username;
        System.out.println("usuario: " + usuario);
        this.username = usuario;
        System.out.println("username: " + this.username);
        if (this.validarDatos() && this.validaPassword(this.nuevoPassword)) {
            try {
                final Map<String, String> respuesta = (Map<String, String>)this.loginService.actualizarPassword(this.getLanguage(), this.nuevoPassword, (String)null, this.pin, this.username);
                if (!respuesta.isEmpty()) {
                    if ("1".equals(respuesta.get("estatus"))) {
                        this.transaccionErronea("Error: ", (String)respuesta.get("mensaje"));
                    }
                    else {
                        this.recuperada = true;
                        this.transaccionCompletada(this.cambioEnProceso = false, 1, "OK", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.ok"));
                        this.limpiarCampos(true);
                    }
                }
                else {
                    this.transaccionErronea("Error: ", "No se recibio respuesta");
                }
            }
            catch (Exception ex) {
                this.transaccionErronea("Error: ", ex.getMessage());
            }
        }
    }
    
    private boolean validarDatos() {
        this.cambioEnProceso = true;
        if (this.pin == null || this.pin.isEmpty()) {
            this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.pin"));
            return false;
        }
        if (this.nuevoPassword == null || this.nuevoPassword.isEmpty()) {
            this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.nueva.requerido"));
            return false;
        }
        if (this.nuevoPasswordConfirmar == null || this.nuevoPasswordConfirmar.isEmpty() || !this.nuevoPasswordConfirmar.equals(this.nuevoPassword)) {
            this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.nuevas.no.coinciden"));
            return false;
        }
        return true;
    }
    
    private boolean validaPassword(final String password) {
        boolean isCorrecto = false;
        final Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$");
        final Matcher matcher = pattern.matcher(password);
        isCorrecto = matcher.matches();
        if (!isCorrecto) {
            final String usuario = this.username;
            System.out.println("usuario: " + usuario);
            this.username = usuario;
            this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.password").replaceAll("\\{0\\}", this.nuevoPassword));
        }
        return isCorrecto;
    }
    
    public void limpiarCampos(final boolean limpiar) {
        if (!FacesContext.getCurrentInstance().isPostback() || limpiar) {
            this.username = null;
            this.nuevoPassword = null;
            this.nuevoPasswordConfirmar = null;
            this.pin = null;
            this.recuperada = false;
        }
    }
    
    public String getLanguage() {
        return "es".equals(this.internacionalizacionMB.getLanguage()) ? "S" : "E";
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getNuevoPassword() {
        return this.nuevoPassword;
    }
    
    public void setNuevoPassword(final String newPassword) {
        this.nuevoPassword = newPassword;
    }
    
    public String getPin() {
        return this.pin;
    }
    
    public void setPin(final String pin) {
        this.pin = pin;
    }
    
    public boolean isPinSolicitado() {
        return this.pinSolicitado;
    }
    
    public void setPinSolicitado(final boolean pinSolicitado) {
        this.pinSolicitado = pinSolicitado;
    }
    
    public String getNuevoPasswordConfirmar() {
        return this.nuevoPasswordConfirmar;
    }
    
    public void setNuevoPasswordConfirmar(final String nuevoPasswordConfirmar) {
        this.nuevoPasswordConfirmar = nuevoPasswordConfirmar;
    }
    
    public boolean isDisable() {
        return this.disable;
    }
    
    public void setDisable(final boolean disable) {
        this.disable = disable;
    }
    
    public boolean isRecuperada() {
        return this.recuperada;
    }
    
    public void setRecuperada(final boolean recuperada) {
        this.recuperada = recuperada;
    }
    
    public boolean isCambioEnProceso() {
        return this.cambioEnProceso;
    }
    
    public void setCambioEnProceso(final boolean cambioEnProceso) {
        this.cambioEnProceso = cambioEnProceso;
    }
}

