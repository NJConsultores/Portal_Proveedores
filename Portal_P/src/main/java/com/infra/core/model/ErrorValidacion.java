/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.core.model;

import java.io.Serializable;

public class ErrorValidacion implements Serializable{   
    private static final long serialVersionUID = 1L;
    
    private int idErrorValidacion;
    private String clave;
    private String descripcion;	
    private String estatus;

    /**
     * @return the idErrorValidacion
     */
    public int getIdErrorValidacion() {
        return idErrorValidacion;
    }

    /**
     * @param idErrorValidacion the idErrorValidacion to set
     */
    public void setIdErrorValidacion(int idErrorValidacion) {
        this.idErrorValidacion = idErrorValidacion;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
     
}
