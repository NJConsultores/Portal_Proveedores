package com.infra.factura.dto;

import java.io.Serializable;
import java.util.List;

public class FeResultadoValidaCFDDto implements Serializable {
	
	private static final long serialVersionUID = -1223737164097333170L;
	private List<FeErrorValidacionDto> errores;
	private FeFacturaDto factura;
	private boolean valido;
	private boolean aceptada;
	private boolean tieneCertificado;
	private String xmlAperak;
	private boolean editarAddenda;
	private boolean addendaPnG = true;
	private boolean addendaVacia = false;
	private boolean addendaValida = true;
	private boolean proveedorTMS = true;
	private boolean rechazadoSAP = false;
	private boolean pendienteSAP = false;
	private boolean revisionSAP = false;
	private String mensajeSAP;
	private String noProveedorSAP;
	private List<FeFacturaDto> facturas;
	private FeActualizaEstatusDto estatusSAP;

	public boolean isRevisionSAP() {
		return revisionSAP;
	}

	public void setRevisionSAP(boolean revisionSAP) {
		this.revisionSAP = revisionSAP;
	}

	public String getMensajeSAP() {
		return mensajeSAP;
	}

	public void setMensajeSAP(String mensajeSAP) {
		this.mensajeSAP = mensajeSAP;
	}

	public boolean isRechazadoSAP() {
		return rechazadoSAP;
	}

	public void setRechazadoSAP(boolean rechazadoSAP) {
		this.rechazadoSAP = rechazadoSAP;
	}

	public boolean isPendienteSAP() {
		return pendienteSAP;
	}

	public void setPendienteSAP(boolean pendienteSAP) {
		this.pendienteSAP = pendienteSAP;
	}

	public boolean isAddendaVacia() {
		return addendaVacia;
	}

	public void setAddendaVacia(boolean addendaVacia) {
		this.addendaVacia = addendaVacia;
	}

	public boolean isAddendaPnG() {
		return addendaPnG;
	}

	public void setAddendaPnG(boolean addendaPnG) {
		this.addendaPnG = addendaPnG;
	}

	public boolean isAddendaValida() {
		return addendaValida;
	}

	public void setAddendaValida(boolean addendaValida) {
		this.addendaValida = addendaValida;
	}

	public boolean isEditarAddenda() {
		return editarAddenda;
	}

	public void setEditarAddenda(boolean editarAddenda) {
		this.editarAddenda = editarAddenda;
	}

	public String getXmlAperak() {
		return xmlAperak;
	}

	public void setXmlAperak(String xmlAperak) {
		this.xmlAperak = xmlAperak;
	}

	public List<FeErrorValidacionDto> getErrores() {
		return errores;
	}

	public void setErrores(List<FeErrorValidacionDto> errores) {
		this.errores = errores;
	}

	public FeFacturaDto getFactura() {
		return factura;
	}

	public void setFactura(FeFacturaDto factura) {
		this.factura = factura;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public boolean isAceptada() {
		return aceptada;
	}

	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

	public boolean isTieneCertificado() {
		return tieneCertificado;
	}

	public void setTieneCertificado(boolean tieneCertificado) {
		this.tieneCertificado = tieneCertificado;
	}

	public boolean isProveedorTMS() {
		return proveedorTMS;
	}

	public void setProveedorTMS(boolean proveedorTMS) {
		this.proveedorTMS = proveedorTMS;
	}

	public String getNoProveedorSAP() {
		return noProveedorSAP;
	}

	public void setNoProveedorSAP(String noProveedorSAP) {
		this.noProveedorSAP = noProveedorSAP;
	}

	public List<FeFacturaDto> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FeFacturaDto> facturas) {
		this.facturas = facturas;
	}

	public FeActualizaEstatusDto getEstatusSAP() {
		return estatusSAP;
	}

	public void setEstatusSAP(FeActualizaEstatusDto estatusSAP) {
		this.estatusSAP = estatusSAP;
	}
}
