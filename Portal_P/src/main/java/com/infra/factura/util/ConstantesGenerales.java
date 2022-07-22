/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.factura.util;

/**
 *
 * @author rlagunas
 */
public class ConstantesGenerales {
    public static final String SI = "S";
    public static final String NO = "N";
    public static final String EXTENSION_PDF = ".pdf";
    public static final String EXTENSION_XML = ".xml";
    public static final String EXTENSION_CER = ".cer";
    public static final String CONFIRMAR = "confirmar";
    public static final String MSG_CERT_EXISTE ="El certificado ya existe, debe realizar la carga manual.";
    public static final String MSG_RFC_EXISTE ="La RFC capturada ya existe..";
    public static final String MSG_RFC_INVALIDA ="La RFC es incorrecta";
    
    public static final String USUARIO_CORREO = "USUARIO_CORREO";
    public static final String PWD_WS_PED_EMP = "PWD_WS_PED_EMP";
    
    public static final String RFC_EXTRANJERO = "XEXX010101000";
    
    public static final String MONEDA_DOLAR_AMERICANO = "USD";
    public static final String MONEDA_PESO_MEXICANO = "MXN";
    
    public static final String CFDI_ADDENDA_START_TAG = "<cfdi:Addenda";
    public static final String CFDI_ADDENDA_END_TAG = "</cfdi:Addenda>";
    public static final String CFDI_ADDENDA_TAG = "<cfdi:Addenda/>";
    public static final String CFDI_ADDENDA_PEDIMENTOS_START_TAG = "<Pedimentos>";
    public static final String CFDI_ADDENDA_PEDIMENTOS_END_TAG = "</Pedimentos>";
    
    public static final String CORE_ROLE_ACTIVO = "X";
    
    public static final String URL_SAT_CERT = "https://rdc.sat.gob.mx/rccf/{0}/{1}/{2}/{3}/{4}/{5}.cer";
    
    public static final boolean AMBIENTE_PROD	= false;
    public static final boolean EN_MODO_PRUEBA	= false;
    public static final int MESES_ATRAS_PERMITIDOS = 6;
    public static final String SAT_CERTIFICADO_FIEL	= "certificados/FEA/";
    public static final String SAT_CERT_REMOTO	= "agti_servicio_ftp/verifica_comprobante_ftp/CSD.txt";
    public static final String SAT_HOST	= "ftp2.sat.gob.mx";
    public static final String SAT_PASSWORD	= "any@dot.com";
    public static final String SAT_USER	="ANONYMOUS";
    
    public static final String RFC_PATTERN= "^(([ÑA-Z|ña-z|&]{3}|[A-Z|a-z]{4})\\d{2}((0[1-9]|1[012])(0[1-9]|1\\d|2[0-8])|(0[13456789]|1[012])(29|30)|(0[13578]|1[02])31)(\\w{2})([A|a|0-9]{1}))$|^(([ÑA-Z|ña-z|&]{3}|[A-Z|a-z]{4})([02468][048]|[13579][26])0229)(\\w{2})([A|a|0-9]{1})$";
}
