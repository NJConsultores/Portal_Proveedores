
package com.infra.core.model.dto;

import java.io.Serializable;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public class PermisoTransaccion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String idTransaccion;
    private String transaccion;
    private String idAccion;
    private String accion;

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public String getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(String idAccion) {
        this.idAccion = idAccion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
    

}
