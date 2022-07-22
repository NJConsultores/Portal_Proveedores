package com.infra.cliente.service.ws;

import java.io.InputStream;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public interface WSStatusRecepcion {

	public Map<String, String> guardarStatusRecepcion(String idioma, String proveedorActual, InputStream xml,
			InputStream pdf, String resultado, String statusResultado);

	public Map<String, Object> getEstatusRecepcion(Date fechaDesde, Date fechaHasta, String idioma,
			String proveedorActual, String sociedad);

}
