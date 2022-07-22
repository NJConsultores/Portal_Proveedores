//package com.infra.factura.util;
//
//import java.text.MessageFormat;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.infra.core.model.ConfiguracionSistema;
//import com.infra.core.persistence.ConfiguracionMapper;
//
//@Component
//public class PropiedadesUtil {
//
//	private final static Logger logger = Logger.getLogger(PropiedadesUtil.class);
//
//	@Autowired
//	private ConfiguracionMapper configuracionMapper;
////	private SistemaMapper sistemaDao;
//
//	public String getProperty(String nombrePropiedad) {
//		ConfiguracionSistema c = configuracionMapper.obtenerConfiguracionPorClave(nombrePropiedad);
//		String resultado = "";
//		if (c != null) {
//			resultado = c.getValor();
//		}
//		return resultado;
//	}
//
////	public SistemaMapper getSistemaDao() {
////		return sistemaDao;
////	}
//
////	public void setSistemaDao(SistemaMapper sistemaDao) {
////		this.sistemaDao = sistemaDao;
////	}
//
////	public int obtenerConexionesAbietas() {
////		try {
////			return sistemaDao.obtenerConexionesAbietas();
////		} catch (Exception e) {
////			logger.error("Error al obtener las conexiones abiertas de la DB", e);
////		}
////		return 0;
////	}
//
//	public static String sustituirArgumentos(String patron, String argumentos) {
//		if (argumentos != null) {
//			if (argumentos.trim().equals("")) {
//				return patron;
//			} else {
//				return sustituirArgumentos(patron, argumentos.split("\\|"));
//			}
//		} else {
//			return null;
//		}
//	}
//
//	public static String sustituirArgumentos(String patron, String[] argumentos) {
//		if (argumentos != null) {
//			if (argumentos.length == 0) {
//				return patron;
//			} else {
//				Object[] args = new Object[argumentos.length];
//				System.arraycopy(argumentos, 0, args, 0, args.length);
//				return sustituirArgumentos(patron, args);
//			}
//		} else {
//			return null;
//		}
//	}
//
//	public static String sustituirArgumentos(String patron, Object[] argumentos) {
//		if (argumentos != null) {
//			if (argumentos.length == 0) {
//				return patron;
//			} else {
//				return MessageFormat.format(patron, argumentos);
//			}
//		} else {
//			return null;
//		}
//	}
//
////	public ArrayList<?> obtenerAvisos() {
////		List<?> avisos = null;
////		try {
////			avisos = sistemaDao.obtenerAvisos();
////		} catch (Exception e) {
////			logger.error("Error al obtener los Avisos del Portal", e);
////		}
////		return (ArrayList<?>) avisos;
////	}
////
////	public int obtenerEstatusAs2() {
////		try {
////			return sistemaDao.obtenerEstatusAs2();
////		} catch (Exception e) {
////			logger.error("Error al obtener el Estatus del servidor AS2", e);
////		}
////		return 0;
////	}
//
////	public void actualizarFechaArchivosEncoladosAs2(String fecha) throws Exception {
////		sistemaDao.actualizarFechaArchivosEncoladosAs2(fecha);
////	}
//}
