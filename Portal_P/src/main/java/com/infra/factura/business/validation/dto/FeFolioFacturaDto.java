package com.infra.factura.business.validation.dto;

public class FeFolioFacturaDto {
	private String rfc;
	private int folioInicial;
	private int folioFinal;
	private String serie;
	private String numeroAprobacion;
	private String anioAprobacion;

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public int getFolioInicial() {
		return folioInicial;
	}

	public void setFolioInicial(int folioInicial) {
		this.folioInicial = folioInicial;
	}

	public int getFolioFinal() {
		return folioFinal;
	}

	public void setFolioFinal(int folioFinal) {
		this.folioFinal = folioFinal;
	}

	public String getSerie() {
		return null == serie ? "" : serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNumeroAprobacion() {
		return numeroAprobacion;
	}

	public void setNumeroAprobacion(String numeroAprobacion) {
		this.numeroAprobacion = numeroAprobacion;
	}

	public String getAnioAprobacion() {
		return anioAprobacion;
	}

	public void setAnioAprobacion(String anioAprobacion) {
		this.anioAprobacion = anioAprobacion;
	}

}
