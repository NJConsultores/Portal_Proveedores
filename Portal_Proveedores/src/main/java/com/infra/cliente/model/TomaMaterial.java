package com.infra.cliente.model;

import java.io.Serializable;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_CNLISTA;

public class TomaMaterial implements Serializable {

	private static final long serialVersionUID = 1L;

	private ZPORTAL_S_CNLISTA toma;
	private boolean seleccionada;

	public TomaMaterial(ZPORTAL_S_CNLISTA toma, boolean seleccionada) {
		this.toma = toma;
		this.seleccionada = seleccionada;
	}

	public ZPORTAL_S_CNLISTA getToma() {
		return toma;
	}

	public void setToma(ZPORTAL_S_CNLISTA toma) {
		this.toma = toma;
	}

	public boolean isSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}

}
