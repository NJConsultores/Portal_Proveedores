//
// 
//
//

package com.infra.core.exposition;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.infra.cliente.service.ws.WSService;
import com.infra.core.util.CoreConstantes;
import com.infra.core.util.SessionUtil;
import com.infra.util.AbstractControlador;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO;
 
@Controller
@Scope("session")
public class AvisosMB extends AbstractControlador {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(AvisosMB.class);
	@Autowired
	private WSService wsService;
	@Autowired
	private InternacionalizacionMB internacionalizacionMB;
	private List<ZPORTAL_S_AVISO> avisos;
	private StreamedContent descarga;

	@PostConstruct
	protected void init() {
		// loadAvisos();
	}

	public void loadAvisos() {
		try {
			avisos = new ArrayList<>();
			Map<String, Object> respuesta = wsService.getAvisos(getLanguage(), SessionUtil.getUsuarioActual());
			// avisos = (List<ZPORTAL_S_AVISO>) respuesta.get("lista");
			// ZPORTAL_S_AVISO[] listado = (ZPORTAL_S_AVISO[])
			// respuesta.get("lista");
			// avisos = Arrays.asList(listado);
			avisos = Arrays.asList((ZPORTAL_S_AVISO[]) respuesta.get("lista"));
		} catch (Exception e) {
			logger.debug("Error al recuperar la pantalla de inicio", e);
		}
	}

	private String getLanguage() {
		return ("es".equals(internacionalizacionMB.getLanguage()) ? "S" : "E");
	}

	public void descartarAviso(short navis) {
//		System.out.println("descartarAviso: " + navis);
		String respuesta = wsService.descartarMensaje(navis, getLanguage(), SessionUtil.getUsuarioActual());
//		System.out.println("respuesta: " + respuesta);
		if (null == respuesta || respuesta.isEmpty()) {
			transaccionCompletada(TRANSACCION_CORRECTA, SEVERITY_FACES_CORRECTO, "OK", CoreConstantes.MSG_DESCARTAR_OK);
			loadAvisos();
		} else {
			transaccionErronea("Error", respuesta);
		}
	}

	public int checarAvisosProveedor() {
		// loadAvisos();
		int cuantosAvisosProveedor = 0;
		if (null != avisos) {
			for (ZPORTAL_S_AVISO aviso : avisos) {
				if ("P".equals(aviso.getTPAVI())) {
					cuantosAvisosProveedor++;
				}
			}
		}
		return cuantosAvisosProveedor;
	}

	public StreamedContent descargarAyuda() {
		InputStream stream = null;
		stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/MANUAL DE USUARIO.pdf");
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return new DefaultStreamedContent(stream, externalContext.getMimeType("MANUAL DE USUARIO.pdf"),
				"MANUAL DE USUARIO.pdf");
	}

	public List<ZPORTAL_S_AVISO> getAvisos() {
		return avisos;
	}

	public void setAvisos(List<ZPORTAL_S_AVISO> avisos) {
		this.avisos = avisos;
	}

	public StreamedContent getDescarga() {
		return descarga;
	}

	public void setDescarga(StreamedContent descarga) {
		this.descarga = descarga;
	}

}