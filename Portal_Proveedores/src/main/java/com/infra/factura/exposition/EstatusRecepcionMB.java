package com.infra.factura.exposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.infra.cliente.service.ws.WSService;
import com.infra.cliente.service.ws.WSStatusRecepcion;
import com.infra.core.exposition.InternacionalizacionMB;
import com.infra.core.util.CoreConstantes;
import com.infra.core.util.LocaleUtil;
import com.infra.core.util.SessionUtil;
import com.infra.core.util.ValidatorUtil;
import com.infra.factura.util.FechaUtil;
import com.infra.util.AbstractControlador;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_LSOC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_STREC;

/**
 *
 * @author Reyna Lagunas Aranda<reyna.lagunas.aranda@gmail.com>
 */
@Controller
@Scope("session")
public class EstatusRecepcionMB extends AbstractControlador {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(EstatusRecepcionMB.class);
	@Autowired
	private WSStatusRecepcion wsStatus;
	@Autowired
	private WSService wsService;
	@Autowired
	private InternacionalizacionMB internacionalizacionMB;

	/**
	 * Para Filtro de status de recepcion
	 */
	private ZPORTAL_S_LSOC sociedad;
	private List<ZPORTAL_S_LSOC> sociedades;
	private List<ZPORTAL_S_STREC> listado;
	private Date fechaDesde;
	private Date fechaHasta;

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla de consulta de
	 * estatus de recepcion
	 */
	public void reset() {
		if (tienePermiso("ROLE_STAT_RECEPCION")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				fechaHasta = new Date();
				fechaDesde = FechaUtil.sumarMesesFecha(fechaHasta, -4);
				listado = null;
			}
		}
	}

	private String getLanguage() {
		return ("es".equals(internacionalizacionMB.getLanguage()) ? "S" : "E");
	}

	private void loadSociedades() {
		try {
			logger.info("Cargando sociedades del proveedor");
			sociedades = new ArrayList<>();
			Map<String, Object> respuesta = wsService.getSociedades(getLanguage(), SessionUtil.getUsuarioActual());
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				
				ZPORTAL_S_LSOC[] listado = (ZPORTAL_S_LSOC[]) respuesta.get("lista");
				sociedades = Arrays.asList(listado);
				
//				sociedades = (List<ZfeSListaSoc>) respuesta.get("lista");
				if (!ValidatorUtil.isEmpty(sociedades)) {
					if (sociedades.size() == 1) {
						sociedad = sociedades.get(0);
					} else {
						sociedad = null;
						logger.info("El usuario tiene mas de un sociedad");
					}
				} else {
					sociedad = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar las sociedades", e);
		}
	}

	public void consultarStatus() {
		if (null == sociedad || sociedad.getBUKRS().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
		} else {
			listado = new ArrayList<>();
			Map<String, Object> respuesta = wsStatus.getEstatusRecepcion(fechaDesde, fechaHasta, getLanguage(),
					SessionUtil.getUsuarioActual(), sociedad.getBUKRS());
			if ("1".equals((String) respuesta.get("estatus"))) {
				// muestra las facturas encontradas
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
//				listado = (List<ZfeSStrecep>) respuesta.get("lista");
				listado = Arrays.asList((ZPORTAL_S_STREC[]) respuesta.get("lista"));
			}
		}
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

	public InternacionalizacionMB getInternacionalizacionMB() {
		return internacionalizacionMB;
	}

	public void setInternacionalizacionMB(InternacionalizacionMB internacionalizacionMB) {
		this.internacionalizacionMB = internacionalizacionMB;
	}

	public ZPORTAL_S_LSOC getSociedad() {
		return sociedad;
	}

	public void setSociedad(ZPORTAL_S_LSOC sociedad) {
		this.sociedad = sociedad;
	}

	public List<ZPORTAL_S_LSOC> getSociedades() {
		return sociedades;
	}

	public void setSociedades(List<ZPORTAL_S_LSOC> sociedades) {
		this.sociedades = sociedades;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public List<ZPORTAL_S_STREC> getListado() {
		return listado;
	}

	public void setListado(List<ZPORTAL_S_STREC> listado) {
		this.listado = listado;
	}

}