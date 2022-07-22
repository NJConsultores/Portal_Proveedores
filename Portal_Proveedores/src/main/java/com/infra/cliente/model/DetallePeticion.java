package com.infra.cliente.model;

import java.io.Serializable;
import java.util.Date;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERD;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_D;

public class DetallePeticion implements Serializable {

	private static final long serialVersionUID = 1L;

	private ZPORTAL_S_POFERD detalle;
	private ZPORTAL_S_POFERR_D entradaProveedor;
	private Date fechaEntrega;
	
	public DetallePeticion(ZPORTAL_S_POFERD detalle, ZPORTAL_S_POFERR_D entradaProveedor) {
		super();
		this.detalle = detalle;
		this.entradaProveedor = entradaProveedor;
	}
	public DetallePeticion(ZPORTAL_S_POFERD detalle, ZPORTAL_S_POFERR_D entradaProveedor, Date fechaEntrega) {
		super();
		this.detalle = detalle;
		this.entradaProveedor = entradaProveedor;
		this.fechaEntrega = fechaEntrega;
	}
	public ZPORTAL_S_POFERD getDetalle() {
		return detalle;
	}
	public void setDetalle(ZPORTAL_S_POFERD detalle) {
		this.detalle = detalle;
	}
	public ZPORTAL_S_POFERR_D getEntradaProveedor() {
		return entradaProveedor;
	}
	public void setEntradaProveedor(ZPORTAL_S_POFERR_D entradaProveedor) {
		this.entradaProveedor = entradaProveedor;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

}
