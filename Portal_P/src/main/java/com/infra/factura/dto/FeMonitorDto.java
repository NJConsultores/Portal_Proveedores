package com.infra.factura.dto;

public class FeMonitorDto {
	private String nombre;
	private long valorMAX;
	private long valorMIN;
	private long valor;
	private String valorString;

	final private String estatusAlto = "Excelente";
	final private String estatusMedio = "Bien";
	final private String estatusBajo = "Mal";

	public String getStatus() {
		float porcentaje = (valor * 100) / valorMAX;
		String retorno = "";
		if (porcentaje < 50) {
			retorno = estatusAlto;
		}
		if (porcentaje > 50 && porcentaje < 90) {
			retorno = estatusMedio;
		}
		if (porcentaje > 90) {
			retorno = estatusBajo;
		}
		// if ( (valor * 100)/ )
		return retorno;
	}

	public String getValorString() {
		return valorString;
	}

	public void setValorString(String valorString) {
		this.valorString = valorString;
	}

	private String tipo;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getValorMAX() {
		return valorMAX;
	}

	public void setValorMAX(long valorMAX) {
		this.valorMAX = valorMAX;
	}

	public long getValorMIN() {
		return valorMIN;
	}

	public void setValorMIN(long valorMIN) {
		this.valorMIN = valorMIN;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public String getEstatus() {
		return "";

	}

}
