package com.infra.cliente.model;

import java.io.Serializable;

import org.primefaces.model.UploadedFile;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_LFACT;

public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;

	private ZPORTAL_S_LFACT factura;
	private boolean seleccionada;
	private UploadedFile xml;
	private UploadedFile pdf;
	private int posicion;
	
	public Factura(ZPORTAL_S_LFACT factura, boolean seleccionada) {
		this.factura = factura;
		this.seleccionada = seleccionada;
	}

	public ZPORTAL_S_LFACT getFactura() {
		return factura;
	}

	public void setFactura(ZPORTAL_S_LFACT factura) {
		this.factura = factura;
	}

	public boolean isSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}

	public UploadedFile getXml() {
		return xml;
	}

	public void setXml(UploadedFile xml) {
		this.xml = xml;
	}

	public UploadedFile getPdf() {
		return pdf;
	}

	public void setPdf(UploadedFile pdf) {
		this.pdf = pdf;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

}
