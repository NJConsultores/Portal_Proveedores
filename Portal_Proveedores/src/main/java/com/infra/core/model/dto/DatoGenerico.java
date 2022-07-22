
package com.infra.core.model.dto;

import java.io.Serializable;

/**
 * Clase generica para mostrar informacion
 * 
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public class DatoGenerico implements Serializable{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private String idDato;
    private String nombre;
    private String relacion;

    public String getIdDato() {
        return idDato;
    }

    public void setIdDato(String idDato) {
        this.idDato = idDato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	@Override
    public String toString() {
        return idDato;
    }
    

}