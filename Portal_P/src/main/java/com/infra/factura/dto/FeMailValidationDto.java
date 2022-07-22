package com.infra.factura.dto;

import java.io.Serializable;

public class FeMailValidationDto implements Serializable {

	/**
	 * <p>Descripción:</p>
	 * POJO para almacenar datos de lectura de facturas por correo electr&oacute;nico
	 *
	 * @author Jorge Conelly
	 */
	private static final long serialVersionUID = -7966113541374603465L;
	
	private String xmlName;
	private String pdfName;
	private String certName;
	private int archivosXml;
	private int archivosPdf;
	private int archivosCert;
	private int xmlSize;
	private int pdfSize;
	private int certSize;
	private byte[] xml;
	private byte[] pdf;
	private byte[] certificado;
	private String correoNotificacion;
	private String infoMail;
	private int filesSize;
	
	
	public String getXmlName() {
		return xmlName;
	}
	public void setXmlName(String xmlName) {
		this.xmlName = xmlName;
	}
	public String getPdfName() {
		return pdfName;
	}
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public int getArchivosXml() {
		return archivosXml;
	}
	public void setArchivosXml(int archivosXml) {
		this.archivosXml = archivosXml;
	}
	public int getArchivosPdf() {
		return archivosPdf;
	}
	public void setArchivosPdf(int archivosPdf) {
		this.archivosPdf = archivosPdf;
	}
	public int getArchivosCert() {
		return archivosCert;
	}
	public void setArchivosCert(int archivosCert) {
		this.archivosCert = archivosCert;
	}
	public int getXmlSize() {
		return xmlSize;
	}
	public void setXmlSize(int xmlSize) {
		this.xmlSize = xmlSize;
	}
	public int getPdfSize() {
		return pdfSize;
	}
	public void setPdfSize(int pdfSize) {
		this.pdfSize = pdfSize;
	}
	public int getCertSize() {
		return certSize;
	}
	public void setCertSize(int certSize) {
		this.certSize = certSize;
	}
	public byte[] getXml() {
		return xml;
	}
	public void setXml(byte[] xml) {
		this.xml = xml;
	}
	public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	public byte[] getCertificado() {
		return certificado;
	}
	public void setCertificado(byte[] certificado) {
		this.certificado = certificado;
	}
	public String getCorreoNotificacion() {
		return correoNotificacion;
	}
	public void setCorreoNotificacion(String correoNotificacion) {
		this.correoNotificacion = correoNotificacion;
	}
	public String getInfoMail() {
		return infoMail;
	}
	public void setInfoMail(String infoMail) {
		this.infoMail = infoMail;
	}
	public int getFilesSize() {
		return filesSize;
	}
	public void setFilesSize(int filesSize) {
		this.filesSize = filesSize;
	}

}
