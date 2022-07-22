//package com.infra.factura.persistence;
//
//import java.util.List;
//
//import com.infra.factura.dto.FeConfiguracionDto;
//import com.infra.factura.dto.FeSistemaDto;
//
///**
// *
// */
//public interface SistemaMapper {
//	public List<?> obtenerExcepciones(FeSistemaDto sistemaDto) throws Exception;
//	public String obtenerPropiedad(String nombrePropiedad);
//	public List<?> obtenerPropiedadesPorPrefijo(String prefijo) throws Exception;
//	public void actualizarConfiguracion(final List<FeConfiguracionDto> propiedades) throws Exception;
//	public List<?> consultarDestinatariosNotificacion() throws Exception;
//	public List<?> obtenerAvisos() throws Exception;
//	public void actualizarEstatusAs2(String estatus) throws Exception;
//	public void actualizarUsuarioCambioEstatusAs2(String usuario) throws Exception;
//	public int obtenerEstatusAs2() throws Exception;
//	public void actualizarFechaArchivosEncoladosAs2(String fecha) throws Exception;
//	public int obtenerConexionesAbietas() throws Exception;
//}
