package com.infra.cliente.service.ws;

import java.util.Date;
import java.util.Map;

import com.infra.service.LregionRequest;
import com.infra.service.ProvrRequest;

/**
 *
  * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public interface WSService {
	public Map<String, Object> getMonedas(String idioma);

	public Map<String, Object> getSociedades(String idioma, String sociedad);

	public Map<String, Object> getImpuestos(String idioma, String sociedad);

	public Map<String, Object> getOrdenes(String idioma, String sociedad, String proveedor, Date fechaDesde,
			Date fechaHasta, String tipo, String filtroOrdenes, String pedimentos);

	public Map<String, Object> getAvisos(String idioma, String sociedad);

	public Map<String, Object> getTiposRecepcion(String idioma, String sociedad);

	public Map<String, Object> getAreas(String idioma, String sociedad);

	public Map<String, Object> getResponsables(String idioma, String sociedad, String area);

	public String descartarMensaje(short idAviso, String idioma, String sociedad);
	
	public Map<String, Object> lregion(LregionRequest request);
	
	public Map<String, Object> provr(ProvrRequest request);
}
