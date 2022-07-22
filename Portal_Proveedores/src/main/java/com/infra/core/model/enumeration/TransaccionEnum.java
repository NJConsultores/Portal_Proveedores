/*
 * Prospectiva Recibos de nomina
 */

package com.infra.core.model.enumeration;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public enum TransaccionEnum {
    SEGURIDAD("Transacción para gestionar la seguridad de la aplicación"),
    BITACORA("Transacción para consultar la información de las bitácoras"),
    USUARIOS("Transacción para gestionar los usuarios"),
    CONFIGURACION("Transacción para gestionar las configuraciones del sistema"),
    CUENTA("Transacción para gestionar la cuenta del usuario"),
    FULL_ACCESS("Transaccion que agrupa a todas las transacciones"),
    IDENTIFICADORES("Transacción para gestionar las secuencias de las tablasde la base de datos"),
    MONITOR_SESIONES("Transacción para ver las sesiones activas en el sistema"),
    EMPRESAS("TX para administrar las empresas"),
    CLIENTES("TX para administrar los clientes"),
    CONFIGURACION_SISTEMA("TX para configurar el sistema"),
    CATALOGOS("TX para ver los catalogos"),
    SOCIEDADES("TX para gestionar las sociedades"),
    PLANTAS("TX para gestionar las Plantas Industriales"),
    EMPRESA_ADMINISTRADORA("TX para gestionar otras empresas"),
    ACTIVAR_EMPRESAS("TX permite activar empresas generadas por clientes"),
    REACTIVAR_CLIENTES("TX permite reactivar clientes eliminados"),
    TEMPLATE_CORREO("TX para templates de correo electronico"),
    EDITAR_PANTALLA_INICIO("TX para editar la pantalla de inicio"),
    /**
     * TX DE FACTURA ELECTRONICA
     */
    FACTURA_ENVIO("TX para envío manual de facturas de Proveedores Nacionales"),
    FACTURA_ENVIO_EXTRANJEROS("TX para envío manual de facturas de Proveedores Extranjeros"),
    FACTURA_ENVIO_AGENTE_VIAJE("TX para envío de facturas de Proveedores Agentes de Viajes"),
    FACTURA_ENVIO_AGENTE_ADUANAL("TX para envío de facturas de Proveedores Agentes Aduanales"),
    FACTURA_ENVIO_AGENTE_ADUANAL_EXTRANJERO("TX para envío de facturas de Proveedores Agentes Aduanales Extranjeros"),
    FACTURA_ENVIO_FORWARDER("TX para envío de facturas de Proveedores Forwarders"),
    FACTURA_ENVIO_FORWARDER_EXTRANJERO("TX para envío de facturas de Proveedores Forwarders Extranjeros"),
    FACTURA_ADDENDA("TX para armado de addenda"),
    FACTURA_ADDENDAS("TX para armado de varias addendas"),
    FACTURA_CONSULTA("TX para consulta de facturas"),
    FACTURA_MASIVA("TX envio masivo de facturas"),
    FACTURA_CAMBIO_ESTATUS("Tx para cambio de estatus de facturas"),
    FACTURA_REPORTE("Tx para visualizar los reportes de facturas"),
    FACTURA_APROBACION_AGENTE_ADUANAL("TX para aprobación de facturas de Proveedores de Agentes Aduanales"),
    FACTURA_CONSULTA_AGENTE_ADUANAL("TX para Consulta de facturas de Cuenta de Gastos de Agentes Aduanales y Forwarders"),
    FACTURA_REPORTE_AGENTE_ADUANAL("TX para Reporte de facturas de Cuenta de Gastos de Agentes Aduanales y Forwarders"),
    PROVEEDOR_REGISTRO("TX para registro de proveedores"),
    PROVEEDOR_MASIVA("TX para carga masiva de proveedores"),
    PROVEEDOR_CONSULTA("TX para consulta de proveedores"),
    CERTIFICADO_PAC_MASIVO("TX para carga masiva de certificados PAC"),
    CERTIFICADO_PAC_MANUAL("TX para carga manual de certificados PAC"),
    CERTIFICADO_FIEL_MANUAL("TX para carga manual de FIEL"),
    CERTIFICADO_FIEL_BUSCAR("TX para busqueda de FIEL"),
    CERTIFICADO_SAT("TX para certificados SAT"),
    CERTIFICADO_PAC_BUSQUEDA("TX para la busqueda de certificados PAC"), 
    /**
     * TX CLIENTE
     */
    INDICADOR_IMPUESTO("TX para catalogo de indicador de impuesto"),
    SOLICITAR_FORMATO_37A("TX para solicitud de formato 37A"),
    IMPORTACIONES("TX para importaciones"),
    MONEDA("TX para catalogo de moneda"),
    CLAVE_CONDICION("TX para catalogo de clave de condicion"),
    ESTADO_CUENTA("TX estado de cuenta"),
    PROVEEDORES_SAP("TX actualizacion de proveedores");
    
    private final String descripcion;

    private TransaccionEnum(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
}
