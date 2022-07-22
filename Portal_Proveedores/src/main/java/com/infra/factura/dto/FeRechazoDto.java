package com.infra.factura.dto;

public class FeRechazoDto extends FeCatalogoDto {
	private int idErrorValidacion;
	private boolean activo;

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getIdErrorValidacion() {
		return idErrorValidacion;
	}

	public void setIdErrorValidacion(int idErrorValidacion) {
		this.idErrorValidacion = idErrorValidacion;
	}
}
