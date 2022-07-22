package com.infra.factura.business.validation.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.infra.core.util.CoreConstantes;

public class FeConstantesValidacion {

	public static final String CFD_ADDENDA_EMPTY_TAG = "<Addenda/>";

	public static final String CFD_ADDENDA_EMPTY_TAG_ALT = "<Addenda />";

	public static final String CFD_ADDENDA_START_TAG = "<Addenda";
	
	public static final String CFDI_ADDENDA_EMPTY_TAG = "<cfdi:Addenda/>";

	public static final String CFDI_ADDENDA_EMPTY_TAG_ALT = "<cfdi:Addenda />";

	public static final String CFDI_ADDENDA_START_TAG = "<cfdi:Addenda";

	public static final String CFD_COMPROBANTE_START_TAG = "<Comprobante>";

	public static final String CFDI_COMPROBANTE_START_TAG = "<cfdi:Comprobante";

	public static final String CFD_ADDENDA_END_TAG = "</Addenda>";
	
	public static final String CFDI_ADDENDA_END_TAG = "</cfdi:Addenda>";

	public static final String CFD_COMPROBANTE_END_TAG = "</Comprobante>";

	public static final String CFDI_COMPROBANTE_END_TAG = "</cfdi:Comprobante>";

	public static final String CFDI_COMPLEMENTO_END_TAG = "</cfdi:Complemento>";
	
	public static final String LINEA_DE_RECORRIDO = "Línea de recorrido/Line Haul";
	
	public static final String LINE_HAUL = "LINE_HAUL";
	
	public static final String ACCESORIOS = "Accesorios/Accesorial";
	
	public static final String ACCESORIAL = "ACCESORIAL";


	public static enum CFDVersion {

		None("0.0"), CFDv2("2.0"), CFDv3("3.0"), FE("4.0"), CFDv2_2("2.2"), CFDv3_2("3.2"), CFDv3_3("3.3");
		
		private static final Map<String,CFDVersion> lookup = new HashMap<String,CFDVersion>();

		static {
		    for(CFDVersion s : EnumSet.allOf(CFDVersion.class)){
		        lookup.put(s.getVersionNumber(), s);
		    }
		}

		private String versionNumber;
		private int idVersion = -1;
		
		private CFDVersion(String versionNumber){
			this.versionNumber = versionNumber;
		}

		public String getVersionNumber(){
			return versionNumber;
		}
		
		public int getIdVersion() {
			if(idVersion < 0){
				idVersion = lookup.get(versionNumber) != null ? lookup.get(versionNumber).ordinal() : 0;
			}
			
			return idVersion;
		}
		
		public static CFDVersion getVersionByNumber(String versionNumber) {
			return lookup.get(versionNumber);
		}
	};

	 public static enum CFDEstatus {

        None(0), RegistroIncompleto(1), RechazoFiscal(2), EnRevision(3), Pendiente(4), Rechazado(5), Aceptado(6), Cancelado(7), PorAutorizar(8), Aceptado_Manualmente(999);

        private int value;

        private CFDEstatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        
        public String getNombre(Locale locale) {
        	if (locale == null){
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
        
        private String getNombreES(){
        	switch (this) {
				case None:
					return NADA_ES;
				case RegistroIncompleto:
					return REGISTRO_INCOMPLETO_ES;
				case RechazoFiscal:
					return RECHAZO_FISCAL_ES;
				case EnRevision:
					return EN_REVISION_ES;
				case Pendiente:
					return PENDIENTE_ES;
				case Rechazado:
					return RECHAZADO_ES;
				case Aceptado:
					return ACEPTADO_ES;
				case Cancelado:
					return CANCELADO_ES;
				case PorAutorizar:
					return POR_AUTORIZAR_ES;
				case Aceptado_Manualmente:
					return ACEPTADO_MANUAL_ES;
				default:
					return NADA_ES;
			}
        }
        
        private String getNombreUS(){
        	switch (this) {
			case None:
				return NADA_US;
			case RegistroIncompleto:
				return REGISTRO_INCOMPLETO_US;
			case RechazoFiscal:
				return RECHAZO_FISCAL_US;
			case EnRevision:
				return EN_REVISION_US;
			case Pendiente:
				return PENDIENTE_US;
			case Rechazado:
				return RECHAZADO_US;
			case Aceptado:
				return ACEPTADO_US;
			case Cancelado:
				return CANCELADO_US;
			case PorAutorizar:
				return POR_AUTORIZAR_US;
			case Aceptado_Manualmente:
				return ACEPTADO_MANUAL_US;
			default:
				return NADA_US;
        	}
        }
        
        private static final String NADA_ES = "Vacio";
        private static final String NADA_US = "Empty";
        private static final String REGISTRO_INCOMPLETO_ES = "RegistroIncompleto";
		private static final String REGISTRO_INCOMPLETO_US = "IncompleteRecord";
		private static final String RECHAZO_FISCAL_ES = "RechazoFiscal";
		private static final String RECHAZO_FISCAL_US = "FiscalRejection";
		private static final String EN_REVISION_ES = "EnRevisión";  
		private static final String EN_REVISION_US = "Reviewing";
		private static final String PENDIENTE_ES = "Pendiente";
        private static final String PENDIENTE_US = "Pending";
        private static final String RECHAZADO_ES = "Rechazado";
		private static final String RECHAZADO_US = "Rejected";
		private static final String ACEPTADO_ES = "Aceptado";
		private static final String ACEPTADO_US = "Accepted";
		private static final String CANCELADO_ES = "Cancelado";  
		private static final String CANCELADO_US = "Canceled";
		private static final String POR_AUTORIZAR_ES = "PorAutorizar";  
		private static final String POR_AUTORIZAR_US = "ToAuthorize";
        private static final String ACEPTADO_MANUAL_ES = "Aceptado Manualmente";
        private static final String ACEPTADO_MANUAL_US = "Manually Accepted";
    };

    public static enum CFDEstatusAgenteAduanal {

        None(0), Pendiente(1), Aprobado(2), Rechazado(3), PrimeraAprobacion(99), Aceptado(100);

        private int value;

        private CFDEstatusAgenteAduanal(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        
        public String getNombre(Locale locale) {
        	if (locale == null){
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
        
        private String getNombreES(){
        	switch (this) {
				case None:
					return NADA_ES;
				case Pendiente:
					return PENDIENTE_ES;
				case Rechazado:
					return RECHAZADO_ES;
				case Aprobado:
					return ACEPTADO_ES;
				case PrimeraAprobacion:
					return PRIMERA_APROBACION_ES;
				case Aceptado:
					return ACEPTADO_SAP_ES;
				default:
					return NADA_ES;
			}
        }
        
        private String getNombreUS(){
        	switch (this) {
				case None:
					return NADA_US;
				case Pendiente:
					return PENDIENTE_US;
				case Rechazado:
					return RECHAZADO_US;
				case Aprobado:
					return ACEPTADO_US;
				case PrimeraAprobacion:
					return PRIMERA_APROBACION_US;
				case Aceptado:
					return ACEPTADO_SAP_US;
				default:
					return NADA_US;
        	}
        }
        
        private static final String NADA_ES = "Vacio";
        private static final String NADA_US = "Empty";
        private static final String PENDIENTE_ES = "Pendiente";
		private static final String PENDIENTE_US = "Pending";
		private static final String RECHAZADO_ES = "Rechazado";
		private static final String RECHAZADO_US = "Rejected";
		private static final String ACEPTADO_ES = "Aprobado";  
		private static final String ACEPTADO_US = "Approved";
		private static final String PRIMERA_APROBACION_ES = "Primera Aprobación";  
		private static final String PRIMERA_APROBACION_US = "First Approval";
		private static final String ACEPTADO_SAP_ES = "ACEPTADO y programado para pago";  
		private static final String ACEPTADO_SAP_US = "Accepted and scheduled for payment";
    };
	
	public static enum CFDTipo_Cliente {
		None, COC, SOC, AAN
	};

    
	public static enum CFDTipo {

        None(0), INGRESO(1), EGRESO(2), TRASLADO(3), RECIBO(4), I(1), E(2), T(3), P(5);

        private int value;

        private CFDTipo(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        
        public String getNombre(Locale locale) {
        	if (locale == null){
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
       
        private String getNombreES(){
        	switch (this) {
				case None:
					return VACIO_ES;
				case INGRESO:
					return INGRESO_ES;
				case EGRESO:
					return EGRESO_ES;
				case TRASLADO:
					return TRASLADO_ES;
				case RECIBO:
					return RECIBO_ES;
				default:
					return VACIO_ES;
			}
        }
        
        private String getNombreUS(){
        	switch (this) {
				case None:
					return VACIO_US;
				case INGRESO:
					return INGRESO_US;
				case EGRESO:
					return EGRESO_US;
				case TRASLADO:
					return TRASLADO_US;
				case RECIBO:
					return RECIBO_US;
				default:
					return VACIO_US;
			}
        }

        private static final String VACIO_ES = "Vacio";
        private static final String VACIO_US = "Empty";
        private static final String INGRESO_ES = "Factura";
		private static final String INGRESO_US = "Invoice";
		private static final String EGRESO_ES = "Nota de Crédito";
		private static final String EGRESO_US = "Credit Note";
		private static final String TRASLADO_ES = "Traslado";  
		private static final String TRASLADO_US = "Traslado";
		private static final String RECIBO_ES = "Recibo";  
		private static final String RECIBO_US = "Voucher";
	};

	public static enum CFDOrigen {

        None(0), WEB_PORTAL(1), WEB_SERVICE(2), E_MAIL(3), IMPORTACIONES(4);

        private int value;

        private CFDOrigen(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    };

	public static enum CFDTipo_PndG {
		None, PO, FI, TMS
	};
	
	public static enum SCORECARD_PERIODO {
		Semanal, Mensual
	}
	
	public static enum SCORECARD_TIPOS {
		TIPO, ESTATUS, ERRORES
	}

	public static enum CatalogoPndG {
		SISTEMA_SAP {
			String getTableName() {
				return FE_C_SISTEMA_SAP;
			}
		},
		CODIGO_MONEDA {
			String getTableName() {
				return FE_C_CODIGO_MONEDA;
			}
		},
		CUENTA {
			String getTableName() {
				return FE_C_CUENTA;
			}
		},
		CENTRO_COSTO {
			String getTableName() {
				return FE_C_CENTRO_COSTO;
			}
		},
		RFC_PROVEEDOR {
			String getTableName() {
				return FE_C_RFC_RECEPTOR;
			}
		};

		private static final String FE_C_RFC_RECEPTOR = "fe_c_rfc_receptor";
		private static final String FE_C_CENTRO_COSTO = "fe_c_centro_costo";
		private static final String FE_C_CUENTA = "fe_c_cuenta";
		private static final String FE_C_CODIGO_MONEDA = "fe_c_codigo_moneda";
		private static final String FE_C_SISTEMA_SAP = "fe_c_sistema_sap";

		abstract String getTableName();
	};
	
	public static enum CFDValidaFacturaProcesada {
		None(0), Aceptado(1);
		
		private int id;
		
		private CFDValidaFacturaProcesada(int id){
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}
	};
	
}
