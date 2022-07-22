package com.infra.factura.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

import com.infra.core.util.SessionUtil;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDEstatus;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDTipo;
import com.infra.factura.util.FeConstantes.TipoProveedor;

public class FeReporteFacturaDto {
	
	private long idReporteFactura;
	private long idFactura;
	private String sociedad;
	private String nombreProveedor;
	private String rfcProveedor;
	private String rfcReceptor;
	private String folio;
	private String uuid;
	private String numeroProveedorSap;
	private String grupoCompras;
	private String mensajeProceso;
	private String descripcionProceso;
	private String moneda;
	private String referencia;
	private String xmlAddenda;
	private String serie;
	private Date fechaEmision;
	private Date fechaRecepcion;
	private Date fechaRegistro;
	//private int idEstatus;
	private int idProveedor;
	private BigDecimal total;
	//private String[] estatus;
	private CFDTipo tipoCFD = CFDTipo.None;
	private CFDEstatus estatus = CFDEstatus.None;
	private boolean esAgenteViajes;
	private TipoProveedor tipoProveedor;
	
	public long getIdReporteFactura() {
		return idReporteFactura;
	}
	public void setIdReporteFactura(long idReporteFactura) {
		this.idReporteFactura = idReporteFactura;
	}
	public long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	public String getSociedad() {
		return sociedad;
	}
	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getRfcProveedor() {
		return rfcProveedor;
	}
	public void setRfcProveedor(String rfcProveedor) {
		this.rfcProveedor = rfcProveedor;
	}
	
	public String getRfcReceptor() {
		return rfcReceptor;
	}
	public void setRfcReceptor(String rfcReceptor) {
		this.rfcReceptor = rfcReceptor;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getNumeroProveedorSap() {
		return numeroProveedorSap;
	}
	public void setNumeroProveedorSap(String numeroProveedorSap) {
		this.numeroProveedorSap = numeroProveedorSap;
	}
	public String getGrupoCompras() {
		return grupoCompras;
	}
	public void setGrupoCompras(String grupoCompras) {
		this.grupoCompras = grupoCompras;
	}
	public String getMensajeProceso() {
		return mensajeProceso;
	}
	public void setMensajeProceso(String mensajeProceso) {
		this.mensajeProceso = mensajeProceso;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getXmlAddenda() {
		return xmlAddenda;
	}
	public void setXmlAddenda(String xmlAddenda) {
		this.xmlAddenda = xmlAddenda;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public CFDTipo getTipoCFD() {
		return tipoCFD;
	}
	public void setTipoCFD(CFDTipo tipoCFD) {
		this.tipoCFD = tipoCFD;
	}
	
	public String getTipoCFDNombre() {
		Locale locale = SessionUtil.getLocale();
		return tipoCFD.getNombre(locale);
	}
	public boolean isEsAgenteViajes() {
		return esAgenteViajes;
	}
	public void setEsAgenteViajes(boolean esAgenteViajes) {
		this.esAgenteViajes = esAgenteViajes;
	}
	public TipoProveedor getTipoProveedor() {
		return tipoProveedor;
	}
	public void setTipoProveedor(TipoProveedor tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}
	public CFDEstatus getEstatus() {
		return estatus;
	}
	public void setEstatus(CFDEstatus estatus) {
		this.estatus = estatus;
	}
	public String getDescripcionProceso() {
		return descripcionProceso;
	}
	public void setDescripcionProceso(String descripcionProceso) {
		this.descripcionProceso = descripcionProceso;
	}
	
	public String getEstatusDescripcion() {
		Locale locale = SessionUtil.getLocale();
		return estatus.getNombre(locale);
	}
	
	public String getTipoProveedorHtml(){
		Locale locale = SessionUtil.getLocale();
		return  tipoProveedor.getNombre(locale);
	}
}
