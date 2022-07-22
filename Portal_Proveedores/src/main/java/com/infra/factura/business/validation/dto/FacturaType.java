package com.infra.factura.business.validation.dto;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class FacturaType {
	private DataHandler xmlFactura;
	
	private DataHandler certFactura;
	
	private DataHandler pdfFactura;

	@XmlMimeType("application/octet-stream")
	public DataHandler getXmlFactura() {
		return xmlFactura;
	}

	public void setXmlFactura(DataHandler xmlFactura) {
		this.xmlFactura = xmlFactura;
	}

	@XmlMimeType("application/octet-stream")
	public DataHandler getCertFactura() {
		return certFactura;
	}

	public void setCertFactura(DataHandler certFactura) {
		this.certFactura = certFactura;
	}

	@XmlMimeType("application/octet-stream")
	public DataHandler getPdfFactura() {
		return pdfFactura;
	}

	public void setPdfFactura(DataHandler pdfFactura) {
		this.pdfFactura = pdfFactura;
	}

}
