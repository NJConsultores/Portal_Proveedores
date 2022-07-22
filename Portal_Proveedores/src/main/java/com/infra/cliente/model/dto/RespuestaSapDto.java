package com.infra.cliente.model.dto;

public class RespuestaSapDto {

	private long idFactura;
	private String estatus;
	private String mensaje;
	private String fechaPago;
	private String noDoctoSap;
	
	public long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	public String getNoDoctoSap() {
		return noDoctoSap;
	}
	public void setNoDoctoSap(String noDoctoSap) {
		this.noDoctoSap = noDoctoSap;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	
}
