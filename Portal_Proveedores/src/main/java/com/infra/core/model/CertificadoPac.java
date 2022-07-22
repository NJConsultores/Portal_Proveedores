package com.infra.core.model;

import java.io.Serializable;
import java.util.Date;


public class CertificadoPac implements Serializable{
    
	private static final long serialVersionUID = 4489581249283867055L;
	
	private int idCertificadoPac;
	private String numeroCertificado;
	private Date fechaValidezIni;
	private Date fechaValidezFin;
	private Date fechaCarga;
	private boolean estatus;
	private byte[] certificado;
	
	public byte[] getCertificado() {
		return certificado;
	}
	public void setCertificado(byte[] certificado) {
		this.certificado = certificado;
	}
	public int getIdCertificadoPac() {
		return idCertificadoPac;
	}
	public void setIdCertificadoPac(int idCertificadoPac) {
		this.idCertificadoPac = idCertificadoPac;
	}
	public String getNumeroCertificado() {
		return numeroCertificado;
	}
	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}
	public Date getFechaValidezIni() {
		return fechaValidezIni;
	}
	public void setFechaValidezIni(Date fechaValidezIni) {
		this.fechaValidezIni = fechaValidezIni;
	}
	public Date getFechaValidezFin() {
		return fechaValidezFin;
	}
	public void setFechaValidezFin(Date fechaValidezFin) {
		this.fechaValidezFin = fechaValidezFin;
	}
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}	
}
