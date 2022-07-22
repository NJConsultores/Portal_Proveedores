/*
 * 
 */
package com.infra.core.util;

/**
 * Clase de constantes
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public class CoreConstantes {
    public static final String USUARIO_SESSION = "USUARIO";

    public static final String ROL_SESSION = "ROL";
    
    public static final String CUENTA_AGENTE_ADUANAL_SESSION = "CUENTA_AGENTE_ADUANAL";
    public static final String PROVIENE_DE_REPORTE_AGENTE_ADUANAL_SESSION = "PROVIENE_DE_REPORTE_AGENTE_ADUANAL_SESSION";

    public static final String REDIRECT = "?faces-redirect=true";

    public static final Integer STATUS_ACTIVO = 1;
    public static final Integer STATUS_INACTIVO = 0;
    public static final Integer STATUS_PENDIENTE_AUTORIZACION=2;
    
    public static final Integer STATUS_TODOS = 1;

    public static final String MSG_REGISTRO_OK = "Registrado correctamente";
    public static final String MSG_REGISTRO_ERROR = "Error al guardar el registro";
    public static final String MSG_DATOS_INVALIDOS = "Datos inválidos";
    public static final String MSG_NOMBRE_EXISTE = "El nombre ya existe";
    public static final String MSG_ELIMINAR_OK = "El registro ha sido eliminado";
    public static final String MSG_DESCARTAR_OK = "El registro ha sido descartado";
    public static final String MSG_ELIMINAR_ERROR = "Error al eliminar el registro";
    public static final String MSG_ACTIVAR_OK = "Activado correctamente";
    public static final String MSG_DATOS_REQUERIDOS = "Los datos marcados son obligatorios";

    public static final String ACCION_EDIRAR = "EDITAR";
    public static final String ACCION_NUEVO = "NUEVO";
    public static final String ACCION = "ACCION";
    
    public static final String TX_TODAS = "TODAS";
    public static final String ACCIONES_TODAS = "TODAS";
    public static final String TX_FULL_ACCESS = "FULL_ACCESS";
    
    public static final Integer SI = 1;
    public static final Integer NO = 0;
    
    public static final String FLUJO_USUARIO_NUEVO = "/content/restricted/usuarios/registrarUsuario.jsf";
    public static final String FLUJO_USUARIO_EDITAR = "/content/restricted/usuarios/editar/usuarioEditar.jsf";
    public static final String FLUJO_GRUPOS_EDITAR = "/content/restricted/seguridad/editar/grupoAutorizacionesEditar.jsf";
    public static final String FLUJO_SEGURIDAD = "/content/restricted/seguridad/adminSeguridad.jsf";
    public static final String FLUJO_ROL_EDITAR = "/content/restricted/seguridad/editar/editarRol.jsf";
    public static final String TX_NO_PERMITIDA = "Transacción no permitida";
    public static final String ACCION_NO_PERMITIDA = "Acción no permitida";
    public static final String NO_PERMISOS = "No tiene permiso para ejecutar esta operación.";
    public static final String FLUJO_GESTION_EMPRESAS = "/content/restricted/cliente/detalleCliente.jsf";
    public static final String CLIENTE_SESSION = "CLIENTE_SESSION";
    
//    public static final String MAXIMOS_ERRORES_PASSWORD = "MAXIMOS_ERRORES_PASSWORD";
//    public static final Integer DEFAULT_MAXIMOS_ERRORES_PASSWORD = 5;
    
//    public static final String TEMA = "TEMA";
//    public static final String TEMA_DEFAULT = "bootstrap";
    
    public static final String ERROR_CUENTA = "SEG 1000 - Error al procesar las credenciales";
    public static final String ERROR_CUENTA_VENCIDA = "SEG 1001 - Cuenta vencida";
    public static final String ERROR_CUENTA_BLOQUEADA = "SEG 1002 - Cuenta bloqueada, favor de contactar a cuentas por pagar.";
    public static final String ERROR_CUENTA_NO_LOGIN = "SEG 1003 - Cuenta sin permiso para autenticar";
    public static final String ERROR_CUENTA_LOGIN = "SEG 1004 - Sin informacion de login";
    public static final String ERROR_CUENTA_CREDENCIALES_INVALIDAS = "SEG 1005 - Captura incorrecta, favor de verificar";
    public static final String GRUPO_AUT_ADMIN_EMPRESA ="ADMINISTRADOR EMPRESA";
    public static final String ROL_ADMIN_EMPRESA ="ADMINISTRADOR EMPRESA";
    public static final String ADMIN_EMPRESA="ADMINISTRADOR ";
    public static final String ERROR_EMPRESA_NO_ACTIVA = "Empresa no activa";
    
    public static final String PREFIJO_GRUPO="GA";
    public static final String PREFIJO_ROL="ROL";
    public static final String PREFIJO_GENERICO="CORE";
    public static final String PREFIJO_REL_TABLAS="REL";
    public static final String PREFIJO_CATALOGOS="CAT";
    public static final String PREFIJO_USUARIOS="USR";
    public static final String PREFIJO_CONFIGURACION="CONF";
    
    public static final String RUTA_LOGOTIPOS = "RUTA_LOGITIPOS";
    public static final String CORE_RESTRICTED="/content/restricted/";
    public static final String TODOS = "Todos";
    
    public static final Integer EMPRESA_NORMAL= 0;
    public static final Integer EMPRESA_SISTEMA= 1;
    public static final Integer EMPRESA_ADMINISTRADORA= 2;
//    public static final String CORREO_SERVICE_DESK ="CORREO_SERVICE_DESK";
//    public static final String CORREO_ACTIVAR_EMPRESA = "CORREO_ACTIVAR_EMPRESA";
//    public static final String CORREO_EMPRESA_ACTIVA = "CORREO_EMPRESA_ACTIVA";
    public static final String CORREO_TITULO_ACTIVAR = "Activar empresa";
    
    public static final String TABLA_SOCIEDADES_NOMBRE = "SOCIEDADES";
    public static final String TABLA_SOCIEDADES = "anex_sociedades";
    public static final String CAMPO_RFC = "rfc";
    public static final String CAMPO_NOMBRE = "nombre_corto";
    public static final String SOCIEDAD_NO_PERMITIDA="No tiene permisos sobre la sociedad";
    
    public static final String ROL_ADMINISTRADOR_PROVEEDOR = "ADMINISTRADOR PROVEEDOR";
    public static final String ROL_PROVEEDOR = "Usuario Proveedor";
    public static final String ROL_PROVEEDOR_EXTRANJERO = "Usuario Proveedor Extranjero";
    public static final String ROL_PROVEEDOR_AGENCIA_VIAJES = "Usuario Agencia de Viajes";
    public static final String ROL_PROVEEDOR_AGENTE_ADUANAL_NACIONAL = "Usuario Agente Aduanal";
    public static final String ROL_PROVEEDOR_AGENTE_ADUANAL_EXTRANJERO = "Usuario Agente Aduanal Extranjero";
    public static final String ROL_PROVEEDOR_FORWARDER_NACIONAL = "Usuario Forwarder";
    public static final String ROL_PROVEEDOR_FORWARDER_EXTRANJERO = "Usuario Forwarder Extranjero";
    public static final String ROL_PROVEEDOR_TERCEROS = "PROVEEDOR TERCEROS";
    public static final String ROL_CONSULTA_PROVEEDOR = "CONSULTA PROVEEDOR";
    public static final String ROL_APROBADOR_COMERCIO_EXTERIOR = "Analista Comercio Exterior";
    public static final String ROL_COORINADOR_COMERCIO_EXTERIOR = "Coordinador Comercio Exterior";
    public static final String ROL_GERENTE_COMERCIO_EXTERIOR = "Gerente Comercio Exterior";
    public static final String ROL_USUARIO_INTERNO = "Usuario Interno";
    public static final String ROL_USUARIO_CONSULTA = "Usuario Consulta";
    public static final String ROL_ADMINISTRADOR = "Administrador";
    public static final String FLUJO_ACTIVAR_EMPRESA = "FLUJO_ACTIVAR_EMPRESA";
    public static final String MSG_ERROR_TEMPLATE = "MAIL-1000 TEMPLATE NO ENCONTRADO";
    public static final String FLUJO_EDITAR_ADDENDA = "/content/restricted/factura/addenda.jsf";
    public static final String FLUJO_EDITAR_ADDENDA_AGENTE_ADUANAL = "/content/restricted/factura/addendaAgenteAduanal.jsf";
    public static final String FLUJO_EDITAR_ADDENDA_MASIVA = "/content/restricted/factura/addendaMasiva.jsf";
    public static final String FLUJO_EDITAR_ADDENDA_MASIVA_FORWARDER = "/content/restricted/factura/addendaMasivaForwarder.jsf";
    public static final String CORREO_LECTURA = "CORREO_LECTURA";
    public static final String USUARIO_CORREO = "USUARIO_CORREO";
//    public static final String PASSWORD_CORREO = "PASSWORD_CORREO";
    
//    public static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]*$";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$";
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public static final String CLIENT_ID = "000001";
    public static final String EMPRESA_CLIENTE = "EMP000001";
    public static final String USUARIO_CREACION_CLIENTE = "administrador.infra";
    
//    public static final String DIRECCION_CORREO_ENVIO = "DIRECCION_CORREO_ENVIO";
//    public static final String USUARIO_CORREO_ENVIO = "USUARIO_CORREO_ENVIO";
//    public static final String PASSWORD_CORREO_ENVIO = "PASSWORD_CORREO_ENVIO";
//    public static final String SERVIDOR_CORREO_ENVIO = "SERVIDOR_CORREO_ENVIO";
//    public static final String PUERTO_CORREO_ENVIO = "PUERTO_CORREO_ENVIO";
    
    public static final String SUFIJO_ESP = "ES";
    public static final String SUFIJO_ING = "EN";
}
