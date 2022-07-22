
package com.infra.core.model.enumeration;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public enum SecuenciaEnum {
    CONFIGURACION("CONFIGURACION"),
    GRUPOS_AUTORIZACION("GRUPOS DE AUTORIZACION"),
    ROLES("ROLES"),
    USUARIOS("USUARIOS"),
    CATALOGOS("CATALOGOS"),
    GENERICO("GENERICOS"),
    RELACIONES_TABLAS("RELACIONES ENTRE TABLAS"),
    SOCIEDADES("SOCIEDADES"),
    CLIENTES("CLIENTES"),
    EMPRESAS("EMPRESAS"),
    TEMPLATE_CORREO("TEMPLATE CORREO ELECTRONICO"),
    PROVEEDORES("PROVEEDORES"),
    PLANTAS("PLANTAS");
    
    /*** FACTURA CORE ***/
    
    
    private final String tabla;

    private SecuenciaEnum(String tabla) {
        this.tabla = tabla;
    }
    
    public String getTabla(){
        return tabla;
    }

}
