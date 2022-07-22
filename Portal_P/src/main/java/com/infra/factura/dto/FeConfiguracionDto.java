package com.infra.factura.dto;

public class FeConfiguracionDto {

	private int idPropiedad;
	private String nombre;
	private String valor;
	private String descripcion;
	private String tipoDato;
	private String estatus;

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

}
