/*
 * Prospectiva Recibos de nomina
 */

package com.infra.core.model.enumeration;

/**
 * Enumeracion para las accioens existentes
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public enum AccionEnum {

    CREAR("Permite crear un dato en la entidad"),
    MODIFICAR("Permite modificar la información de la entidad"),
    ELIMINAR("Permite eliminar un registro de la entidad"),
    BUSCAR("Permite buscar un registro"),
    DESCARGAR("Permite descargar información de la pantalla"),
    EJECUTAR("Permite ejecutar"),
    VISUALIZAR("Permite visualizar la información de la entidad"),
    CARGAR("Permite subir archivos");
    
    private AccionEnum(String accion) {
        this.descripcion = accion;
    }
    
    private final String descripcion;

    
    public String getDescripcion(){
        return descripcion;
    }
}
