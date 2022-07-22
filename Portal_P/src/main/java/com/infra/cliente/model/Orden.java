package com.infra.cliente.model;

import java.io.Serializable;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_PEDIDOS;

public class Orden implements Serializable {

	private static final long serialVersionUID = 1L;

	private ZPORTAL_S_PEDIDOS orden;
	private boolean seleccionada;

	public Orden(ZPORTAL_S_PEDIDOS orden, boolean seleccionada) {
		this.orden = orden;
		this.seleccionada = seleccionada;
	}

	public ZPORTAL_S_PEDIDOS getOrden() {
		return orden;
	}

	public void setOrden(ZPORTAL_S_PEDIDOS orden) {
		this.orden = orden;
	}

	public boolean isSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}

}
