package com.infra.factura.dto.html;

public class FeScoreCardDtoHtml {
	private String tipo;
	private String categoria;
	private long cantidad;
	private float porcentaje;
	private String strCantidad;
	private String strPorcentaje;
	
	
	public String getStrCantidad() {
		return strCantidad;
	}
	public void setStrCantidad(String strCantidad) {
		this.strCantidad = strCantidad;
	}
	public String getStrPorcentaje() {
		return strPorcentaje;
	}
	public void setStrPorcentaje(String strPorcentaje) {
		this.strPorcentaje = strPorcentaje;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
}
