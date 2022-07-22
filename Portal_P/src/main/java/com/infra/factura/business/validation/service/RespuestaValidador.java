package com.infra.factura.business.validation.service;

import java.io.Serializable;

public class RespuestaValidador implements Serializable {

	private static final long serialVersionUID = 1L;
	private String estatus;
	private String mensaje;
	
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
