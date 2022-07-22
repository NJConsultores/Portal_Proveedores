package com.infra.cliente.util; 
public class ClienteConstantes {
    public static final String CORREO_FORMATO_37A = "FORMATO_37A";
    public static final String CORREO_TITULO_FORMATO_37A = "SOLICITUD FORMATO 37-A"; 
    public static final String CORREO_USUARIO_NUEVO_ES = "USUARIO_NUEVO_ES";
    public static final String CORREO_TITULO_USUARIO_NUEVO_ES = "Datos de la cuenta / Account data";
    public static final String CORREO_RECUPERACION_PWD_ES = "RECUPERACION_PWD_ES";
    public static final String CORREO_TITULO_RECUPERACION_PWD_ES = "Contraseña restablecida / Password reset";
    public static final String CORREO_FACTURA_ACEPTADA_ES = "FACTURA_ACEPTADA_ES";
    public static final String CORREO_TITULO_FACTURA_ACEPTADA_ES = "Comprobante ACEPTADO / Invoice ACCEPTED: ";
    public static final String CORREO_FACTURA_ACEPTADA_ADUANAL_ZIP = "FACTURA_ACEPTADA_ADUANAL_ZIP";
    public static final String CORREO_TITULO_AGENTE_ADUANAL_ZIP_ACEPTADA_ES = "Archivo ZIP ACEPTADO / ZIP file ACCEPTED: ";
    public static final String CORREO_FACTURA_RECHAZADA_SAP_ES = "FACTURA_RECHAZADA_SAP_ES";
    public static final String CORREO_TITULO_FACTURA_RECHAZADA_SAP_ES = "Comprobante RECHAZADO / Invoice REJECTED: ";
    public static final String CORREO_FACTURA_RECHAZADA_PORTAL_ES = "FACTURA_RECHAZADA_PORTAL_ES";
    public static final String CORREO_TITULO_FACTURA_RECHAZADA_PORTAL_ES = "Comprobante RECHAZADO / Invoice REJECTED: ";
    public static final String CORREO_FACTURA_RECHAZADA_PORTAL_ADUANAL_ZIP = "FACTURA_RECHAZADA_PORTAL_ADUANAL_ZIP";
    public static final String CORREO_TITULO_FACTURA_RECHAZADA_PORTAL_ADUANAL_ZIP_ES = "Archivo ZIP RECHAZADO / ZIP file REJECTED";
    public static final String CORREO_FACTURA_RECHAZADA_EMAIL_ES = "FACTURA_RECHAZADA_EMAIL_ES";
    public static final String CORREO_TITULO_FACTURA_RECHAZADA_EMAIL_ES = "Recepción Factura Electrónica por CORREO - Error de factura / Electornic Invoice - Error into Invoice ";
    public static final String CORREO_TITULO_CAMBIO_ESTATUS_FACTURA_ES = "Cambio de estatus / Change of status: ";
    public static final String CORREO_CAMBIO_ESTATUS_FACTURA_ES = "CAMBIO_ESTATUS_FACTURA_ES";
    public static final String CORREO_FACTURA_AGENTE_ADUANAL_RESULTADO_VALIDACION = "FACTURA_AGENTE_ADUANAL_RESULTADO_VALIDACION";
    public static final String CORREO_TITULO_FACTURA_AGENTE_ADUANAL_RESULTADO_VALIDACION = "Validación de Cuenta Aduanal / Customs Account Validation";
    public static final String CORREO_FACTURA_COORDINADOR_AGENTE_ADUANAL_FAC = "FACTURA_COORDINADOR_AGENTE_ADUANAL_FAC";
    public static final String CORREO_TITULO_FACTURA_COORDINADOR_AGENTE_ADUANAL_FAC = "Cuenta de Gasto Aprobada";
    
    public static final String CORREO_RECHAZO_AGENTE_ADUANAL_ES = "Motivo de Rechazo: {0}";
    public static final String CORREO_RECHAZO_AGENTE_ADUANAL_EN = "Reason for rejection: {0}";
    public static final String CORREO_ACEPTADO_AGENTE_ADUANAL_ES = "Fecha de Registro SAP: {0}";
    public static final String CORREO_ACEPTADO_AGENTE_ADUANAL_EN = "Registration Date SAP: {0}";
    
    public static final String ERROR_DESTINARIO_FALTA = "3010 - DESTINATARIOS SIN CONFIGURAR";
    public static final String MSG_FORMATO_SOLICITADO = "El formato ha sido solicitado";
    public static final String ERROR_SOLICITAR_FORMATO = "3020 Error al solicitar formato 37-A";
    public static final String CONTACTE_ADMINISTRADOR = "Contacte al administrador";
    public static final String ADDENDA_COC = "COC";
    public static final String ADDENDA_SOC = "SOC";
    public static final String ADDENDA_AGA = "AGA";
    public static final String ERROR_LAYOUT = "ERROR LAYOUT";
    public static final String EXTENSION_XLSX = ".xlsx";
    public static final String SI = "SI";
    public static final String NO = "NO"; 
    public static final String NO_ELEGIDO = "NO ELEGIDO";
    
    public static final String URL_RESULTADO_FACTURA = "/content/restricted/factura/enviarFactura.jsf";
    public static final String URL_RESULTADO_FACTURAS = "/content/restricted/factura/enviarFacturas.jsf";
    public static final String URL_RESULTADO_RECIBO = "/content/restricted/factura/enviarRecibo.jsf";
    public static final String URL_RESULTADO_FACTURA_EXTRANJERO = "/content/restricted/factura/enviarFacturaExtranjero.jsf";
    public static final String URL_RESULTADO_FACTURA_AGENTE_ADUANAL = "/content/restricted/factura/enviarFacturasAgenteAduanal.jsf";
    public static final String URL_RESULTADO_FACTURA_AGENTE_ADUANAL_EXTRANJERO = "/content/restricted/factura/enviarFacturaAgenteAduanalExtranjero.jsf";
    public static final String URL_RESULTADO_FACTURAS_FORWARDER = "/content/restricted/factura/enviarFacturasForwarder.jsf";
    public static final String URL_RESULTADO_FACTURA_FORWARDER_EXTRANJERO = "/content/restricted/factura/enviarFacturaForwarderExtranjero.jsf";
    public static final String URL_RESULTADO_DOCTO_IMPRESO_AGENTE_ADUANAL = "/content/restricted/factura/enviarDoctoImpresoAgenteAduanal.jsf";
 
    
    public static final Integer DEFAULT_MESES_EDOCUENTA = 3; 
    
    public static final String ADDENDA_DEFAULT = "<cfdi:Addenda><cfdi:Bocar tipo=\"1\" moneda=\"MXP\" total=\"10\"><cfdi:ordenCompra>1234567890</cfdi:ordenCompra></cfdi:Bocar></cfdi:Addenda>";
    public static final String CONCEPTO_HONORARIOS = "HONORARIOS";
    public static final String CONCEPTO_HONORARIOS_EXTRAJERO = "HONORARIOS PROVEEDOR EXTRANJERO";
    public static final String CONCEPTO_PAGO_TERCEROS = "PAGO A TERCEROS PROVEEDOR EXTRANJERO";
    
    public static final String MSG_PROVEEDOR_VACIO = "Debe seleccionar un proveedor";
    public static final String MSG_ERROR_IMPORTACIONES = "Se encontraron errores al procesar importaciones";
    
    public static final String ESTATUS_SAP_REGISTRO_INCOMPLETO = "RI";
    public static final String ESTATUS_SAP_RECHAZO_FISCAL = "RF";
    public static final String ESTATUS_SAP_RECHAZADO = "RE";
    public static final String ESTATUS_SAP_PENDIENTE = "PE";
    public static final String ESTATUS_SAP_EN_REVISION = "RV";
    public static final String ESTATUS_SAP_ACEPTADO = "AC";
    public static final String ESTATUS_SAP_CANCELADO = "CA";
    public static final String ESTATUS_SAP_ACEPTADO_MANUAL = "AM";
    
    public static final String PDF_FILE_PATTERN = "([^\\s]+(\\.(?i)(pdf))$)";
}
