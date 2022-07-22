package com.infra.factura.util;

import java.math.BigDecimal;
import java.util.Locale;

import com.infra.core.util.CoreConstantes;

public class FeConstantes {
	public static enum Rol {
		None, Administrador, Administrador_Proveedor, Administrador_PyG, Usuario_Proveedor, Usuario_PyG, Soporte, Usuario_HP, Proveedor_Terceros
	};

	public static enum TipoProveedor {
		None(0), Nacional(1), Extranjero(2), Agente_Viajes(3), Agente_Aduanal_Nacional(4), Agente_Aduanal_Extranjero(
				5), Forwarder_Nacional(6), Forwarder_Extranjero(7);

		private int value;

		private TipoProveedor(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public String getNombre(Locale locale) {
			if (locale == null) {
				return getNombreES();
			}

			switch (locale.getLanguage().toUpperCase()) {
			case CoreConstantes.SUFIJO_ESP:
				return getNombreES();
			case CoreConstantes.SUFIJO_ING:
				return getNombreUS();
			default:
				return getNombreES();
			}
		}

		private String getNombreES() {
			switch (this) {
			case None:
				return NINGUNO_ES;
			case Nacional:
				return NACIONAL_ES;
			case Extranjero:
				return EXTRANJERO_ES;
			case Agente_Viajes:
				return AGENTE_VIAJES_ES;
			case Agente_Aduanal_Nacional:
				return AGENTE_ADUANAL_NACIONAL_ES;
			case Agente_Aduanal_Extranjero:
				return AGENTE_ADUANAL_EXTRANJERO_ES;
			case Forwarder_Nacional:
				return FORWARDER_NACIONAL_ES;
			case Forwarder_Extranjero:
				return FORWARDER_EXTRAJERO_ES;
			default:
				return NINGUNO_ES;
			}
		}

		private String getNombreUS() {
			switch (this) {
			case None:
				return NINGUNO_US;
			case Nacional:
				return NACIONAL_US;
			case Extranjero:
				return EXTRANJERO_US;
			case Agente_Viajes:
				return AGENTE_VIAJES_US;
			case Agente_Aduanal_Nacional:
				return AGENTE_ADUANAL_NACIONAL_US;
			case Agente_Aduanal_Extranjero:
				return AGENTE_ADUANAL_EXTRANJERO_US;
			case Forwarder_Nacional:
				return FORWARDER_NACIONAL_US;
			case Forwarder_Extranjero:
				return FORWARDER_EXTRAJERO_US;
			default:
				return NINGUNO_US;
			}
		}

		private static final String NINGUNO_ES = "Ninguno";
		private static final String NINGUNO_US = "None";
		private static final String NACIONAL_ES = "Nacional";
		private static final String NACIONAL_US = "Mexican";
		private static final String EXTRANJERO_ES = "Extranjero";
		private static final String EXTRANJERO_US = "Foreign";
		private static final String AGENTE_VIAJES_ES = "Agente Viajes";
		private static final String AGENTE_VIAJES_US = "Travel Agent";
		private static final String AGENTE_ADUANAL_NACIONAL_ES = "Agente Aduanal";
		private static final String AGENTE_ADUANAL_NACIONAL_US = "Mexican Forwarding Agent";
		private static final String AGENTE_ADUANAL_EXTRANJERO_ES = "Agente Aduanal Extranjero";
		private static final String AGENTE_ADUANAL_EXTRANJERO_US = "Foreign Forwarding Agent";
		private static final String FORWARDER_NACIONAL_ES = "Forwarder";
		private static final String FORWARDER_NACIONAL_US = "Mexican Forwarder";
		private static final String FORWARDER_EXTRAJERO_ES = "Forwarder Extranjero";
		private static final String FORWARDER_EXTRAJERO_US = "Foreign Forwarder";
	};

	public static enum Estatus_Usuario {
		Inactivo(0), Activo(1), Pwd_Provisional(2), Bloqueado(3);
		private final int id;

		private Estatus_Usuario(int id) {
			this.id = id;
		}

		public int id() {
			return id;
		}
	};

	public static enum Estatus_Bloqueo_Proveedor {
		Sin_bloqueo(0), Bloqueado(1), Bloqueo_temporal(2);
		private final int id;

		private Estatus_Bloqueo_Proveedor(int id) {
			this.id = id;
		}

		public int id() {
			return id;
		}
	};

	public static enum Tipo_Correo {
		Empty, Recuperacion_Pwd, Registro_Usr, Validacion, Validacion_correo, Reinicio_AS2, Alerta_Conexiones_Pool
	};

	public static enum Estatus_Mensaje_AS2 {
		PendienteEnvio, EnProceso, Enviado, Confirmado, NoEnviado, NoConfirmado, Cancelado, Retransmitir
	};

	public static enum Estatus_Archivo_AS2 {
		NoProcesado, Procesado, EnReenvio, Bloqueado, NoGenerado
	};

	public static enum Destino_Mensaje {
		As2, Ws
	};

	public static enum Tipo_Mensaje_AS2 {
		Otro, CFD, CBB
	};

	public static enum Nivel_Aprobacion {
		SinNivel(0), Uno(1), Dos(2), Tres(3), Cuatro(4);

		private int value;

		private Nivel_Aprobacion(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	};

	public static final String HPBES_MESSAGE_PREFIX = "WS-HPBES";

	public static final String PROPIEDAD_DOMINIO_APROBADOR_EMAIL = "CATALOGOS_DOMINIO_APROBADOR_EMAIL";

	public static final String PROPIEDAD_CORREOS_NOTIFICACION_USUARIOS_NUEVOS = "MAIL_NEW_USERS_DISTRIBUTION_LIST";

	public static final String PROPIEDAD_MSG_ENVIO_NO_PERMITIDO = "SYS_AVISO_BLOQUEO";

	public static final String SAT_CERTIFICADO_FIEL = "SAT_CERTIFICADO_FIEL";

	public static final String SAT_DELIMITA_FIEL1 = "6";

	public static final String SAT_DELIMITA_FIEL2 = "2";

	public static final String SAT_EXTCERT_FIEL = ".cer";

	public static final String SAT_HOST = "SAT_HOST";

	public static final String SAT_USER = "SAT_USER";

	public static final String SAT_PASSWORD = "SAT_PASSWORD";

	public static final String PROPIEDAD_SYS_ENABLE_TESTS = "SYS_ENABLE_TESTS";

	public static final int DEFAULT_RESGUARDO = 3;

	public static final String APPLICATION_RESOURCES = "com.infra.factura.struts.ApplicationResources";

	public static final String PROPIEDAD_AS2_BASE_FOLDER_PATH = "AS2_BASE_FOLDER_PATH";

	public static final String PROPIEDAD_AS2_OUTBOX_NAME = "AS2_OUTBOX_NAME";

	public static final String PROPIEDAD_RUTA_FACT_WS = "RUTA_FACT_WS";

	public static final String PROPIEDAD_RUTA_TMP = "RUTA_TMP";

	public static final String PROPIEDAD_CFD_v2 = "SYS_CFD_v2";

	public static final String PROPIEDAD_CFD_v3 = "SYS_CFD_v3";

	public static final String PROPIEDAD_CFD_v2_2 = "SYS_CFD_v2_2";

	public static final String PROPIEDAD_CFDv3_2 = "SYS_CFDv3_2";

	public static final String PROPIEDAD_CBB = "SYS_CBB";

	public static final String PROPIEDAD_SENTFILES = "sentFiles";

	public static final String PROPIEDAD_ENVIADOS = "enviados";

	public static final String ACCION_REENVIAR_FACTURA = "/StatusReenviar";

	// public static final String SAT_CERT_LOCAL = "SAT_CERT_LOCAL";

	public static final String SAT_CERT_REMOTO = "SAT_CERT_REMOTO";

	// public static final String REENVIO_FACTURA_COMPLEMENTO = "";

	/**
	 * Clase Enum para estatus de control en el envio del WS para HPBES
	 * 
	 * @since 25-04-13
	 * @author infra
	 */
	public static enum EstatusControlFactura {
		NONE(0), RECIBIDO(1), PROCESANDO(2), FINALIZADO_OK(3), FINALIZADO_ERROR(4);

		private int id;

		private EstatusControlFactura(int id) {
			this.id = id;
		}

		public int id() {
			return id;
		}
	};

	/**
	 * Enum para respuesta de Ws HPBES
	 * 
	 * @since 29-04-13
	 * @author infra
	 */
	public static enum WsRespuestas {

		NONE(0),
		/**
		 * WS OK
		 */
		WS_OK(200),

		/**
		 * Archivo Incompleto
		 */
		INCOMPLETE_FILE(404),

		/**
		 * Usuario o contraseña invalida
		 */
		INVALID_CREDENTIAL(406),
		/**
		 * 
		 * Error de servidor
		 */
		SERVER_ERROR(500);

		private int id;

		public int getId() {
			return id;
		}

		public static String getDescripcion(String id) {
			if (id != null) {
				int idRespuesta = Integer.valueOf(id);
				for (WsRespuestas respuesta : WsRespuestas.values()) {
					if (respuesta.getId() == idRespuesta) {
						return respuesta.name() + "(" + id + ")";
					}
				}
			} else {
				return NONE.name();
			}
			return id;
		}

		private WsRespuestas(int id) {
			this.id = id;
		}

	};

	/* constantes de parametros para logs informativos */
	public static final String PRM_ACT = "accion";
	public static final String PRM_GEN = "origen_error";
	public static final String PRM_ID = "id";
	public static final Object ID = "ID_";

	/* Ruta error resources */
	public static final String MRE = "com.infra.factura.struts.ErrorsResources";

	/* constantes para mensajes informativos */
	public static final String MI0001 = "INFO.M0001";
	public static final String MI0002 = "INFO.M0002";
	public static final String MI0003 = "INFO.M0003";
	public static final String MI0004 = "INFO.M0004";
	public static final String MI0005 = "INFO.M0005";
	public static final String MI0006 = "INFO.M0006";
	public static final String MI0007 = "INFO.M0007";
	public static final String MI0008 = "INFO.M0008";
	public static final String MI0009 = "INFO.M0009";
	public static final String MI0010 = "INFO.M0010";
	public static final String MI0011 = "INFO.M0011";
	public static final String MI0012 = "INFO.M0012";
	public static final String MI0013 = "INFO.M0013";
	public static final String MI0014 = "INFO.M0014";
	public static final String MI0015 = "INFO.M0015";
	public static final String MI0016 = "INFO.M0016";
	public static final String MI0017 = "INFO.M0017";
	public static final String MI0018 = "INFO.M0018";
	public static final String MI0019 = "INFO.M0019";
	public static final String MI0020 = "INFO.M0020";
	public static final String MI0021 = "INFO.M0021";
	public static final String MI0022 = "INFO.M0022";
	public static final String MI0023 = "INFO.M0023";

	/* constantes para estatus sap */
	public static final String ESTATUS_SAP_RECHAZADO = "RE";
	public static final String ESTATUS_SAP_ACEPTADO = "AC";
	public static final String ESTATUS_SAP_ACEPTADO_MANUAL = "AM";
	public static final String ESTATUS_SAP_PENDIENTE = "PE";
	public static final String ESTATUS_SAP_SIN_ENTRADA_MERCANCIA = "SE";
	public static final String ESTATUS_SAP_ERROR_BAPI = "BA";
	public static final String ESTATUS_SAP_EDITADO = "ED";
	public static final String ESTATUS_PORTAL_POR_AUTRIZAR = "PORA";

	/* constantes para acciones en el job de actualizacion de proveedores */
	public static final String REGISTRO_NUEVO = "NEW";
	public static final String REGISTRO_ACTUALIZADO = "MAIL";
	public static final String REGISTRO_BAJA = "LOCK";

	public static final String SALTO_LINEA = "\r\n";

	/* constantes para importaciones */
	public static final String CLAVE_MONEDA_NACIONAL = "MXP";
	public static final String CLAVE_TIPO_DOCUMENTO = "INGRESO";
	public static final String CLAVE_ESCENARIO = "IM";

	// Usuario con el que entra al sistema por el web service
	public static final String USUARIO_WEB_SERVICE = "Administrador.infra";

	public static final long TAMANIO_MAXIMO_ARCHIVOS_1300KB = 1363150;
	public static final long TAMANIO_MAXIMO_ARCHIVO_ZIP_5000KB = 5242885;
	public static final long TAMANIO_MAXIMO_ARCHIVO_EXCEL_ZIP_8000KB = 8388615;
	public static final int TAMANIO_CAMPO_SERIE = 10;

	public static final String MENSAJE_ERROR_PROVEEDOR_ES = "PROVEEDOR DUPLICADO";
	public static final String MENSAJE_ERROR_PROVEEDOR_EN = "VENDOR IS DUPLICATED";

	public static final String TIPO_IMPUESTO_IEPS = "IEPS";
	public static final String TIPO_IMPUESTO_IEPS33 = "003";

	public static final BigDecimal TOLERANCIA_CALCULO_IEPS = new BigDecimal(1).setScale(2, BigDecimal.ROUND_CEILING);

	public static final String TAG_INICIO_IMPUESTOS_LOCALES = "<implocal:ImpuestosLocales";
	public static final String TAG_FIN_IMPUESTOS_LOCALES = "</implocal:ImpuestosLocales>";
	public static final String TAG_ADDENDA_CLIENTE_START = "<cfdi:Bocar>";
	public static final String TAG_ADDENDA_CLIENTE_END = "</cfdi:Bocar>";

	public static final int ESCENARIO_COC_OTROS = 1;
	public static final int ESCENARIO_COC_CONSIGNACION = 2;
	public static final int ESCENARIO_COC_ANTICIPO = 3;
	public static final int ESCENARIO_COC_TRANSPORTE_CONSOLIDADO = 7;
	public static final int ESCENARIO_SOC_FINANCIERA = 4;
	public static final int ESCENARIO_SOC_ABONO = 5;
	public static final int ESCENARIO_SOC_ANTICIPO = 6;

	public static final String ESCENARIO_COC_OTROS_SAP = "CO";
	public static final String ESCENARIO_COC_CONSIGNACION_SAP = "CS";
	public static final String ESCENARIO_COC_ANTICIPO_SAP = "AN";
	public static final String ESCENARIO_SOC_FINANCIERA_SAP = "FI";
	public static final String ESCENARIO_SOC_ABOONO_SAP = "AB";
	public static final String ESCENARIO_SOC_ANTICIPO_SAP = "AN";
	public static final String ESCENARIO_COC_TRANSPORTE_CONSOLIDADO_SAP = "TC";

	public static final String FLUJO_EXTRANJERO = "X";
	public static final String FLUJO_NACIONAL = "N";
	public static final String FLUJO_AGENTE_ADUANAL_NACIONAL = "V";
	public static final String FLUJO_FORWARDER_NACIONAL = "W";
	public static final String FLUJO_AGENTE_ADUANAL_EXTRANJERO = "Y";
	public static final String FLUJO_FORWARDER_EXTRANJERO = "Z";
	public static final String INDICADOR_IMPUESTO_EXCENTO = "T0";

	public static final String ARCHIVO_TIPO_XML = "XML";
	public static final String ARCHIVO_TIPO_PDF = "PDF";
	public static final String CHARSET_PERMITIDA = "UTF-8";
	public static final String NOMBRE_ARCHIVO = "NOMBRE_ARCHIVO";
	public static final String XML_ADDENDA = "ADDENDA";
	public static final String RFC_AGENTE_ADUANAL = "RFC_AA";
	public static final String IMPUESTO_IVA = "IVA";

	public static final String VALIDACION_ZIP_VACIO = "1";
	public static final String VALIDACION_SIN_ARCHIVOS_XML_PDF = "2";
	public static final String VALIDACION_SIN_ARCHIVO_PDF = "3";
	public static final String VALIDACION_SIN_ARCHIVO_XML = "4";
	public static final String VALIDACION_RFC_RECEPTOR_DISTINTO = "5";
	public static final String VALIDACION_RFC_RECEPTOR_NO_COINCIDE = "6";
	public static final String VALIDACION_MAS_ADDENDAS = "7";
	public static final String VALIDACION_NO_ES_PROVEEDOR_AGENTE_ADUANAL = "8";
	public static final String VALIDACION_EXCEPCION = "9";
	public static final String VALIDACION_SIN_ADDENDA = "10";
	public static final String VALIDACION_MAS_PROVEEDOR_FORWARDER = "11";
}