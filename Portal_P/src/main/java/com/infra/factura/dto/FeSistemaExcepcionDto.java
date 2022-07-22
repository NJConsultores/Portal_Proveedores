package com.infra.factura.dto;

import java.util.Date;

public class FeSistemaExcepcionDto extends FeSistemaDto {
	private String idExcepcion;
	private Date fecha;
	private String mensaje;
	private String excepcion;

	public String getIdExcepcion() {
		return idExcepcion;
	}

	public void setIdExcepcion(String idExcepcion) {
		this.idExcepcion = idExcepcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(String excepcion) {
		this.excepcion = excepcion;
	}

}
