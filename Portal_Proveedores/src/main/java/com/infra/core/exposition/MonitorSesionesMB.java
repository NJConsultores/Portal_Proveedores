




package com.infra.core.exposition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import com.infra.core.model.UsuarioWS;
import com.infra.core.util.CoreConstantes;
 
@Controller
public class MonitorSesionesMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MonitorSesionesMB.class);
	@Autowired
	private SessionRegistry sessionRegistry;

	public List<UsuarioWS> getUsuariosAutenticados() {
		List<UsuarioWS> usuariosActivos = new ArrayList<UsuarioWS>();
		if (tienePermiso("ROLE_MONITOR_SESION")) {
			List<Object> allPrincipals = sessionRegistry.getAllPrincipals();

			UsuarioWS s;
			for (Object o : allPrincipals) {
				s = (UsuarioWS) o;
				if (s != null) {
					logger.debug("Usuario: " + s.getUsername());
					usuariosActivos.add(s);
				}
			}

		}
		return usuariosActivos;
	}

	private boolean tienePermiso(String permiso) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		boolean tienePermiso = authentication.getAuthorities().contains(new SimpleGrantedAuthority(permiso));
		if (!tienePermiso) {
			throw new AccessDeniedException(CoreConstantes.ACCION_NO_PERMITIDA);
		}
		return tienePermiso;
	}
}
