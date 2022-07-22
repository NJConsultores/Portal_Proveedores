package com.infra.core.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import java.util.List;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import java.util.Collection;
import com.infra.core.model.UsuarioWS;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.infra.service.CoreService;
import com.infra.factura.dto.FeErrorValidacionDto;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import com.infra.service.LoginRequest;
import com.infra.core.util.ErrorValidacionUtil;
import com.infra.service.CoreServiceImplServiceLocator;
import java.util.Map;
import com.infra.service.Datos;
import com.infra.service.OpcionProv;
import org.springframework.security.authentication.BadCredentialsException;
import com.infra.core.ws.exception.WSException;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import com.infra.core.service.WSLoginService;
import org.springframework.security.authentication.AuthenticationProvider;

public class AutentificadorProvider implements AuthenticationProvider
{
    @Autowired
    private WSLoginService wsLoginService;
    
    public Authentication authenticate(final Authentication authentication) {
        Authentication auth = null;
        final String claveUsuario = authentication.getName();
        final String contrasena = authentication.getCredentials().toString();
        System.out.println("Datos de acceso: " + claveUsuario);
        final Map<String, Object> resultado = (Map<String, Object>)this.wsLoginService.iniciarSesion("S", claveUsuario, contrasena);
        if (resultado == null || resultado.get("opciones") == null || resultado.get("datos") == null) {
            throw new WSException("Not able to connect to WS");
        }
        //Short status = resultado.get("status");
        Short status = (Short) resultado.get("status");
        if (1 == status) {
            throw new BadCredentialsException((String)resultado.get("mensaje"));
        }
        //auth = procesarSesion(claveUsuario, contrasena, resultado.get("opciones"), resultado.get("datos"));
        auth = procesarSesion(claveUsuario, contrasena, (OpcionProv) resultado.get("opciones"),	(Datos) resultado.get("datos"));
        return auth;
    }
    
    private void probar() {
        final CoreServiceImplServiceLocator locator = new CoreServiceImplServiceLocator();
        final FeErrorValidacionDto dto = ErrorValidacionUtil.obtenerErrorValidacion("validacion-010");
        if (dto != null) {
            System.out.println("Clave: " + dto.getClave());
            System.out.println("Descripcion: " + dto.getDescripcion());
        }
        String respuesta = "sin respuesta: ";
        try {
            LoginRequest lr = new LoginRequest();
            lr.setIdioma("E");
            lr.setUsuario("700");
            lr.setPassword("12345");
            final CoreService coreService = locator.getCoreServiceImplPort();
            try {
                respuesta = String.valueOf(respuesta) + Integer.toString(coreService.sumar(7, 8));
                lr = coreService.login(lr);
                System.out.println("lR: " + lr.getMensaje());
            }
            catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        catch (ServiceException e2) {
            e2.printStackTrace();
        }
        System.out.println("con el locator: " + locator.getCoreServiceImplPortAddress() + " y la respuesta en prueba: " + respuesta);
    }
    
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
    private Authentication procesarSesion(final String usuario, final String contrasena, final OpcionProv opciones, final Datos datos) {
        final UsuarioWS usuarioWS = new UsuarioWS();
        final String sociedad = datos.getLifnr();
        final String idProveedor = datos.getBukrs();
        final String nombre = datos.getName1().concat(" ").concat(datos.getName2());
        final String email = datos.getEmail();
        final String rfc = datos.getStcd1();
        final String dias = opciones.getConsper().toString();
        usuarioWS.setIdUsuario(idProveedor);
        usuarioWS.setPassword(contrasena);
        usuarioWS.setNombreUser(usuario);
        usuarioWS.setNombre(nombre);
        usuarioWS.setCorreo(email);
        usuarioWS.setRfc(rfc);
        usuarioWS.setSociedad(sociedad);
        usuarioWS.setConsper(dias);
        usuarioWS.setCalificacion(datos.getEvalua());
        usuarioWS.setMultas(datos.getMultas());
        usuarioWS.setCambiarCorreo("X".equals(datos.getCorreo()));
        usuarioWS.setXConc("X".equals(opciones.getXconc()));
        final AbstractAuthenticationToken auth = (AbstractAuthenticationToken)new UsernamePasswordAuthenticationToken((Object)usuarioWS, (Object)contrasena, (Collection)this.procesarAuthorities(opciones));
        auth.setDetails((Object)usuarioWS);
        return (Authentication)auth;
    }
    
    private List<GrantedAuthority> procesarAuthorities(final OpcionProv opciones) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if ("X".equals(opciones.getAvisos())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_GET_AVISOS"));
        }
        if ("X".equals(opciones.getListafac())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_GET_FACTURAS"));
        }
        if ("X".equals(opciones.getCfdiocc())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_V_CFDI_OC"));
        }
        if ("X".equals(opciones.getCbbocc())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_V_CBB_OC"));
        }
        if ("X".equals(opciones.getCfdi())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_V_CFDI"));
        }
        if ("X".equals(opciones.getCbb())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_V_CBB"));
        }
        if ("X".equals(opciones.getStatrec())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_STAT_RECEPCION"));
        }
        if ("X".equals(opciones.getListaoc())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_GET_OC_PENDIENTES"));
        }
        if ("X".equals(opciones.getEdocta())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_GET_EDO_CTA"));
        }
        if ("X".equals(opciones.getPassven())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_VENCE_PASS"));
        }
        if ("X".equals(opciones.getPdfotr())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_PDF_ADICIONAL"));
        }
        if ("X".equals(opciones.getMonses())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_MONITOR_SESION"));
        }
        if ("X".equals(opciones.getValidad())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_VALIDA_XML"));
        }
        if ("X".equals(opciones.getCompcp())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_COMPLEMENTO"));
        }
        if ("X".equals(opciones.getPofer())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_PETICIONES"));
        }
        if ("X".equals(opciones.getConsig())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_CONSIGNACION"));
        }
        if ("X".equals(opciones.getListaoc2())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_LISTA_OC2"));
        }
        if ("X".equals(opciones.getAdenda())) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_ADDENDA"));
        }
        return authorities;
    }
}