package com.infra.factura.dto;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.infra.core.util.SessionUtil;
import com.infra.factura.business.common.GenericCFD;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDEstatus;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDOrigen;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDTipo;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDVersion;
import com.infra.factura.util.FeConstantes;

public class FeFacturaDto {
	private long idFactura;
	private int idProveedor;
	private CFDVersion versionCFD;
	private String rfcEmisor;
	private String rfcReceptor;
	private String folio;
	private String serie;
	private String numeroAprobacion;
	private String numeroCertificado;
	private String anioAprobacion;
	private Date fechaEmision;
	private GenericCFD comprobante;
	private String xmlComprobante;
	private Date fechaRecepcion;
	private CFDTipo tipoCFD = CFDTipo.None;
	private CFDEstatus estatus = CFDEstatus.None;
	private InputStream pdfGenerado;
	private Date fechaEmisionFin;
	private Date fechaRecepcionFin;
	private BigDecimal subTotal;
	private BigDecimal descuento;
	private BigDecimal total;
	private CFDOrigen origen = CFDOrigen.None;
	private String currencyCode;
	private String purchaseOrder;
	private String goodReceipt;
	private String deliveryNote;
	private String parkNumber;
	private String accountNumber;
	private String resguardoNom151;
	private FeArchivoSoporteDto archivoSoporte;
	private String uuid;
	private String uuidImportaciones;
	private String tmsBillingId;
	private String tmsServiceType;
	private String esEnviadoWs;
	private String as2EsProcesado;
	private Boolean as2Enviado;
	private String esProcesadoWs;
    private List<String> rfcsPermitidos;
    private String xmlAddenda;
    private int idEscenario;
    private byte[] pdfFirmado;
    private byte[] pdfFactura;
//    private Impuestos impuestos;
//    private com.infra.factura.business.cfdi.iii.schema.Comprobante.Impuestos impuestos33;
//    private ImpuestosLocales impuestosLocales;
    private String fechaEmisionSap;
    private String fechaRecepcionSap;
    private String horaRecepcionSap;
    private String anioEmision;
    private Date fechaPago;
    private String noDoctoSap;
    private Date fechaRegistro;
    
    private Boolean pdf;
    private Boolean pdfSellado;
    private Boolean xml;
    
	//Addenda CLIENTE
	//Encabezado
	private String moneda = null;
	private BigDecimal tipoCambio = null;
	//COC
	private String ordenCompra = null;
	private String cadenaDocumentosMaterial = null;
	//SOC
	private String sociedad = null;
	private String referencia = null;
	private String textoCabecera = null;
	private boolean excentoImpuestoTrasladado = false;
	
	//Termina Addenda CLIENTE
	
	//Addenda CLIENTE AGENTE ADUANAL
	private long idFacturaAduanal;
	private boolean agenteAduanal;
	
	private String pedimento;
	private String cuentaContableConceptos;
	private String aduana;
	private String patente;
	private String planta;
	
	private String nombreProveedor;
	private String rfcProveedor;
	private String concepto;
	private BigDecimal iva;
	private BigDecimal tasa;
	//Termina Addenda CLIENTE
    
	private String idsEstatus;
	
	private Boolean aplicaUuidLike = false;
	private Boolean aplicaFolioLike = false;
	

	/**
	 * Constructor de clase
	 */
	public FeFacturaDto() {
	}

//	public FeFacturaDto (CFDVersion version, GenericCFD cfd, CFDEstatus estatus) {
//		if(cfd != null){
//			switch (version) {
//			case CFDv3_2:
//				com.infra.factura.business.cfdi.ii.schema.Comprobante cfdv3_2 = (com.infra.factura.business.cfdi.ii.schema.Comprobante)cfd.getDocument();
//				setFolio(cfdv3_2.getFolio());
//				setRfcEmisor(cfdv3_2.getEmisor().getRfc());
//				setRfcReceptor(cfdv3_2.getReceptor().getRfc());
//				setSerie(cfdv3_2.getSerie());
//				setNumeroCertificado(cfdv3_2.getNoCertificado());
//				setEstatus(estatus);
//				setFechaRecepcion(new Date());
////				setFechaEmision(cfdv3_2.getFecha());
//				setXmlComprobante(cfd.getXmlDocument());
//				setVersionCFD(version);
//				if(cfdv3_2.getTipoDeComprobante() != null){
//					setTipoCFD(CFDTipo.valueOf(cfdv3_2.getTipoDeComprobante().toUpperCase()));
//				}
//				setSubTotal(new BigDecimal(cfdv3_2.getSubTotal()));
//				setTotal(new BigDecimal(cfdv3_2.getTotal()));
//				if(cfdv3_2.getDescuento() != null){
//					setDescuento(new BigDecimal(cfdv3_2.getDescuento()));
//				}
//				setEsEnviadoWs("0");
//				setImpuestos(cfdv3_2.getImpuestos());
//				
//				try {
//					
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//					String fechaRecepcionVar = sdf.format(getFechaRecepcion());
//					sdf.applyPattern("hh:mm:ss");
//					String horaRecepcionVar = sdf.format(getFechaRecepcion());
//					GregorianCalendar c = new GregorianCalendar();
//					c.setTime(getFechaEmision());
//					XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//					cal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
//					cal.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
//					
//					setFechaEmisionSap(cal.toString());
//					setFechaRecepcionSap(fechaRecepcionVar);
//					setHoraRecepcionSap(horaRecepcionVar);
//					setAnioEmision(cal.getYear() + "");
//					
//					TimbreFiscalDigital timbreFiscalDigital = TFDv1.getTimbreFiscalDigital(cfdv3_2);
//					if(timbreFiscalDigital != null){
//						setUuid(timbreFiscalDigital.getUUID());
//					}
//					
//					String impuestosLocalesStr = getImpuestosLocalesStr(cfd.getXmlDocument());
//					
//					if(impuestosLocalesStr != null){
//						
//						impuestosLocalesStr = impuestosLocalesStr.replaceAll("xmlns:implocal=\"http://www.sat.gob.mx/implocal\"", "");
//						impuestosLocalesStr = impuestosLocalesStr.replaceAll("<implocal:ImpuestosLocales", "<implocal:ImpuestosLocales xmlns:implocal=\"http://www.sat.gob.mx/implocal\"");
//						
////						JAXBContext jaxbContext = JAXBContext.newInstance(ImpuestosLocales.class);
////						Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
////						ImpuestosLocales impuestosLocalesObj = (ImpuestosLocales) jaxbUnmarshaller.unmarshal(StringAndInputstreamUtil.convertStringToStream(impuestosLocalesStr));
////						setImpuestosLocales(impuestosLocalesObj);
//						
//					}
//					
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				if(estatus.equals(CFDEstatus.Aceptado)){
////					GeneradorPdfCFDv3_2 generadorPdfCFDv3 = new GeneradorPdfCFDv3_2();
////					try {
////						final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////						generadorPdfCFDv3.generaPDF(outputStream, cfdv3_2, fechaRecepcion);
////						setPdfGenerado(new ByteArrayInputStream(outputStream.toByteArray()));
////					} catch (Exception e) {
////						e.printStackTrace();
////					}
//				}
//				break;
//			case CFDv3_3:				
//				com.infra.factura.business.cfdi.iii.schema.Comprobante cfdv3_3 = (com.infra.factura.business.cfdi.iii.schema.Comprobante)cfd.getDocument();
//				setFolio(cfdv3_3.getFolio());
//				setRfcEmisor(cfdv3_3.getEmisor().getRfc());
//				setRfcReceptor(cfdv3_3.getReceptor().getRfc());
//				setSerie(cfdv3_3.getSerie());
//				setNumeroCertificado(cfdv3_3.getNoCertificado());
//				setEstatus(estatus);
//				setFechaRecepcion(new Date());
////				setFechaEmision(cfdv3_3.getFecha());
//				setXmlComprobante(cfd.getXmlDocument());
//				setVersionCFD(version);
//				if(cfdv3_3.getTipoDeComprobante() != null){
//					setTipoCFD((CFDTipo.valueOf(cfdv3_3.getTipoDeComprobante().toUpperCase())));
//				}
//				setSubTotal(new BigDecimal(cfdv3_3.getSubTotal()));
//				setTotal(new BigDecimal(cfdv3_3.getTotal()));
//				if(cfdv3_3.getDescuento() != null){
//					setDescuento(new BigDecimal(cfdv3_3.getDescuento()));
//				}
//				setEsEnviadoWs("0");
//				setImpuestos33(cfdv3_3.getImpuestos());
//				
//				try {
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//					String fechaRecepcionVar = sdf.format(getFechaRecepcion());
//					sdf.applyPattern("hh:mm:ss");
//					String horaRecepcionVar = sdf.format(getFechaRecepcion());
//					GregorianCalendar c = new GregorianCalendar();
//					c.setTime(getFechaEmision());
//					XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//					cal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
//					cal.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
//					
//					setFechaEmisionSap(cal.toString());
//					setFechaRecepcionSap(fechaRecepcionVar);
//					setHoraRecepcionSap(horaRecepcionVar);
//					setAnioEmision(cal.getYear() + "");
//					
//					com.infra.factura.business.cfdi.timbre.i.schema.TimbreFiscalDigital timbreFiscalDigital = TFDv1_1.getTimbreFiscalDigital(cfdv3_3);
//					if(timbreFiscalDigital != null){
//						setUuid(timbreFiscalDigital.getUUID());
//					}
//					
//					String impuestosLocalesStr = getImpuestosLocalesStr(cfd.getXmlDocument());
//					
//					if(impuestosLocalesStr != null){
//						
//						impuestosLocalesStr = impuestosLocalesStr.replaceAll("xmlns:implocal=\"http://www.sat.gob.mx/implocal\"", "");
//						impuestosLocalesStr = impuestosLocalesStr.replaceAll("<implocal:ImpuestosLocales", "<implocal:ImpuestosLocales xmlns:implocal=\"http://www.sat.gob.mx/implocal\"");
//						
////						JAXBContext jaxbContext = JAXBContext.newInstance(ImpuestosLocales.class);
////						Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
////						ImpuestosLocales impuestosLocalesObj = (ImpuestosLocales) jaxbUnmarshaller.unmarshal(StringAndInputstreamUtil.convertStringToStream(impuestosLocalesStr));
////						setImpuestosLocales(impuestosLocalesObj);
//						
//					}
//					
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				if(estatus.equals(CFDEstatus.Aceptado)){
////					GeneradorPdfCFDv3_2 generadorPdfCFDv3 = new GeneradorPdfCFDv3_2();
////					try {
////						final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////						generadorPdfCFDv3.generaPDF(outputStream, cfdv3_2, fechaRecepcion);
////						setPdfGenerado(new ByteArrayInputStream(outputStream.toByteArray()));
////					} catch (Exception e) {
////						e.printStackTrace();
////					}
//				}
//				break;
//			default:
//				break;
//			}
//		}
//		
//	}

	
	public String getEscenarioSap() {
		
		if(idEscenario == FeConstantes.ESCENARIO_COC_OTROS){
			
			return FeConstantes.ESCENARIO_COC_OTROS_SAP;
			
		}else if(idEscenario == FeConstantes.ESCENARIO_COC_CONSIGNACION){
			
			return FeConstantes.ESCENARIO_COC_CONSIGNACION_SAP;
			
		}else if(idEscenario == FeConstantes.ESCENARIO_COC_ANTICIPO){
			
			return FeConstantes.ESCENARIO_COC_ANTICIPO_SAP;
			
		}else if(idEscenario == FeConstantes.ESCENARIO_SOC_FINANCIERA){
			
			return FeConstantes.ESCENARIO_SOC_FINANCIERA_SAP;
			
		}else if(idEscenario == FeConstantes.ESCENARIO_SOC_ABONO){
			
			return FeConstantes.ESCENARIO_SOC_ABOONO_SAP;
			
		}else if(idEscenario == FeConstantes.ESCENARIO_SOC_ANTICIPO){
			
			return FeConstantes.ESCENARIO_SOC_ANTICIPO_SAP;
			
		}else if(idEscenario == FeConstantes.ESCENARIO_COC_TRANSPORTE_CONSOLIDADO){
			
			return FeConstantes.ESCENARIO_COC_TRANSPORTE_CONSOLIDADO_SAP;
			
		}else{
			return null;
		}
		
	}
	
	public String getNoDoctoSap() {
		return noDoctoSap;
	}

	public void setNoDoctoSap(String noDoctoSap) {
		this.noDoctoSap = noDoctoSap;
	}

	public String getUuidImportaciones() {
		return uuidImportaciones;
	}

	public void setUuidImportaciones(String uuidImportaciones) {
		this.uuidImportaciones = uuidImportaciones;
	}

	public Boolean getPdf() {
		return pdf;
	}

	public void setPdf(Boolean pdf) {
		this.pdf = pdf;
	}

	public Boolean getPdfSellado() {
		return pdfSellado;
	}

	public void setPdfSellado(Boolean pdfSellado) {
		this.pdfSellado = pdfSellado;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
		//TODO EN Bocar la fecha de pago no existe y se pone la fecha de Registro o Contable.
		this.fechaRegistro = fechaPago;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaEmisionSap() {
		return fechaEmisionSap;
	}

	public void setFechaEmisionSap(String fechaEmisionSap) {
		this.fechaEmisionSap = fechaEmisionSap;
	}

	public String getFechaRecepcionSap() {
		return fechaRecepcionSap;
	}

	public void setFechaRecepcionSap(String fechaRecepcionSap) {
		this.fechaRecepcionSap = fechaRecepcionSap;
	}

	public String getHoraRecepcionSap() {
		return horaRecepcionSap;
	}

	public void setHoraRecepcionSap(String horaRecepcionSap) {
		this.horaRecepcionSap = horaRecepcionSap;
	}

	public String getAnioEmision() {
		return anioEmision;
	}

	public void setAnioEmision(String anioEmision) {
		this.anioEmision = anioEmision;
	}

//	public Impuestos getImpuestos() {
//		return impuestos;
//	}
//	
//	public com.infra.factura.business.cfdi.iii.schema.Comprobante.Impuestos getImpuestos33() {
//		return impuestos33;
//	}
//
//	public void setImpuestos(Impuestos impuestos) {
//		this.impuestos = impuestos;
//		
//		if(impuestos == null){
//			excentoImpuestoTrasladado = true;
//		}else{
//			Traslados traslados = impuestos.getTraslados();
//			
//			if(traslados == null || traslados.getTraslado() == null || traslados.getTraslado().isEmpty()){
//				excentoImpuestoTrasladado = true;
//			}else{
////				for(Traslado traslado: traslados.getTraslado()){
////					if(traslado.getImporte() != null && 
////							(traslado.getImporte().compareTo(BigDecimal.ZERO) < 0 || traslado.getImporte().compareTo(BigDecimal.ZERO) > 0)){
////						excentoImpuestoTrasladado = false;
////						break;
////					}else{
////						excentoImpuestoTrasladado = true;
////					}
////				}
//			}
//		}
//	}
//	
//	public void setImpuestos33(
//			com.infra.factura.business.cfdi.iii.schema.Comprobante.Impuestos impuestos33) {
//		this.impuestos33 = impuestos33;
//		
//		if(impuestos33 == null){
//			excentoImpuestoTrasladado = true;
//		}else{
//			com.infra.factura.business.cfdi.iii.schema.Comprobante.Impuestos.Traslados traslados = impuestos33.getTraslados();
//			
//			if(traslados == null || traslados.getTraslado() == null || traslados.getTraslado().isEmpty()){
//				excentoImpuestoTrasladado = true;
//			}else{
//				for(com.infra.factura.business.cfdi.iii.schema.Comprobante.Impuestos.Traslados.Traslado traslado: traslados.getTraslado()){
//					if(traslado.getImporte() != null && 
//							(new BigDecimal(traslado.getImporte()).compareTo(BigDecimal.ZERO) < 0 || new BigDecimal(traslado.getImporte()).compareTo(BigDecimal.ZERO) > 0)){
//						excentoImpuestoTrasladado = false;
//						break;
//					}else{
//						excentoImpuestoTrasladado = true;
//					}
//				}
//			}
//		}
//	}
//	
//	public Traslado getImpuestoIva(Impuestos impuestos) {
//		Traslado impuestoIva = null;
//		
//		if(impuestos != null){
//			Traslados traslados = impuestos.getTraslados();
//			
//			if(traslados != null && traslados.getTraslado() != null && !traslados.getTraslado().isEmpty()){
//				for(Traslado traslado: traslados.getTraslado()){
//					if(traslado.getImpuesto().equalsIgnoreCase(FeConstantes.IMPUESTO_IVA)){
//						impuestoIva = traslado;
//						break;
//					}else{
//						excentoImpuestoTrasladado = true;
//					}
//				}
//			}
//		}
//		
//		return impuestoIva;
//	}
//	
//	public Concepto getConcepto(Conceptos conceptos) {
//		Concepto concepto = null;
//		
//		if(conceptos != null && conceptos.getConcepto() != null && !conceptos.getConcepto().isEmpty()){
//			concepto = conceptos.getConcepto().get(0);
//		}
//		
//		return concepto;
//	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public FeArchivoSoporteDto getArchivoSoporte() {
		return archivoSoporte;
	}

	public void setArchivoSoporte(FeArchivoSoporteDto archivoSoporte) {
		this.archivoSoporte = archivoSoporte;
	}

	public CFDOrigen getOrigen() {
		return origen;
	}

	public void setOrigen(CFDOrigen origen) {
		this.origen = origen;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getFechaEmisionFin() {
		return fechaEmisionFin;
	}

	public void setFechaEmisionFin(Date fechaEmisionFin) {
		this.fechaEmisionFin = fechaEmisionFin;
	}

	public Date getFechaRecepcionFin() {
		return fechaRecepcionFin;
	}

	public void setFechaRecepcionFin(Date fechaRecepcionFin) {
		this.fechaRecepcionFin = fechaRecepcionFin;
	}

	public InputStream getPdfGenerado() {
		return pdfGenerado;
	}

	public void setPdfGenerado(InputStream pdfGenerado) {
		this.pdfGenerado = pdfGenerado;
	}

	public CFDEstatus getEstatus() {
		return estatus;
	}
	
	public String getEstatusDescripcion() {
		Locale locale = SessionUtil.getLocale();
		
		return estatus.getNombre(locale);
	}
	
	public boolean getCambioEstatusPermitido() {
    	if(estatus.ordinal() == CFDEstatus.RegistroIncompleto.ordinal()
    			||estatus.ordinal() == CFDEstatus.RechazoFiscal.ordinal()
    			||estatus.ordinal() == CFDEstatus.Rechazado.ordinal()){
    		
    		return true;
    	}
		return false;
	}

	public void setEstatus(CFDEstatus estatus) {
		this.estatus = estatus;
	}

	public CFDTipo getTipoCFD() {
		return tipoCFD;
	}
	
	public String getTipoCFDNombre() {
		Locale locale = SessionUtil.getLocale();
		
		return tipoCFD.getNombre(locale);
	}

	public void setTipoCFD(CFDTipo tipoCFD) {
		this.tipoCFD = tipoCFD;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getAnioAprobacion() {
		return anioAprobacion;
	}

	public void setAnioAprobacion(String anioAprobacion) {
		this.anioAprobacion = anioAprobacion;
	}

	public String getNumeroCertificado() {
		return numeroCertificado;
	}

	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getNumeroAprobacion() {
		numeroAprobacion = null == numeroAprobacion ? "" : numeroAprobacion; 
		return numeroAprobacion;
	}

	public void setNumeroAprobacion(String numeroAprobacion) {
		this.numeroAprobacion = numeroAprobacion;
	}

	public String getXmlComprobante() {
		return xmlComprobante;
	}

	public void setXmlComprobante(String xmlComprobante) {
		this.xmlComprobante = xmlComprobante;
		setXml(this.xmlComprobante != null);
	}

	public CFDVersion getVersionCFD() {
		return versionCFD;
	}

	public void setVersionCFD(CFDVersion versionCFD) {
		this.versionCFD = versionCFD;
	}

	public String getRfcEmisor() {
		return rfcEmisor;
	}

	public void setRfcEmisor(String rfcEmisor) {
		this.rfcEmisor = rfcEmisor;
	}

	public String getRfcReceptor() {
		return rfcReceptor;
	}

	public void setRfcReceptor(String rfcReceptor) {
		this.rfcReceptor = rfcReceptor;
	}

	public String getFolio() {
		return folio == null ? "" : folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getSerie() {
		serie = null == serie ? "" : serie; 
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie == null ? serie : (serie.trim().length() > FeConstantes.TAMANIO_CAMPO_SERIE ? serie.substring(0, FeConstantes.TAMANIO_CAMPO_SERIE) : serie.trim());
	}

	public GenericCFD getComprobante() {
		return comprobante;
	}

	public void setComprobante(GenericCFD comprobante) {
		this.comprobante = comprobante;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getGoodReceipt() {
		return goodReceipt;
	}

	public void setGoodReceipt(String goodReceipt) {
		this.goodReceipt = goodReceipt;
	}

	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public String getParkNumber() {
		return parkNumber;
	}

	public void setParkNumber(String parkNumber) {
		this.parkNumber = parkNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getResguardoNom151() {
		return resguardoNom151;
	}

	public void setResguardoNom151(String resguardoNom151) {
		this.resguardoNom151 = resguardoNom151;
	}
	
	public String getTmsBillingId() {
		return tmsBillingId;
	}

	public void setTmsBillingId(String tmsBillingId) {
		this.tmsBillingId = tmsBillingId;
	}

	public String getTmsServiceType() {
		return tmsServiceType;
	}

	public void setTmsServiceType(String tmsServiceType) {
		this.tmsServiceType = tmsServiceType;
	}
	
	

//	public void setAddendaPnG(FeAddendaDto addendaPnG) {
//		if(addendaPnG != null){
//			this.moneda = addendaPnG.getMoneda();
//			this.tipoCambio = addendaPnG.getTipoCambio();
//			this.ordenCompra = addendaPnG.getNumeroPedido();
//			this.referencia = addendaPnG.getNumeroReferencia();
//			
//			if(addendaPnG.getNumeroPedido() != null){
//				this.purchaseOrder = addendaPnG.getNumeroPedido().trim().split(",")[0];	
//			}
//			
////			this.sapSystem = addendaPnG.getSystemSAP();
////			this.currencyCode = addendaPnG.getCurrencyISOCode();
////			this.purchaseOrder = addendaPnG.getPurchaseOrder();
////			this.goodReceipt = addendaPnG.getGoodReceipt();
////			this.deliveryNote = addendaPnG.getDeliveryNote();
////			this.parkNumber = addendaPnG.getParkNumber();
////			this.accountNumber = addendaPnG.getAccountNumber();
////			this.costCenter = addendaPnG.getCostCenter();
////			this.approverEmail = addendaPnG.getApproverEmail();
//		}
//	}
	
//	public void setAddendaClienteAgenteAduanal(CFDVersion version, GenericCFD cfd, FeAddendaPedimentosDto addenda) {
//		if(addenda != null){
//			this.pedimento = addenda.getPedimento();
//			this.cuentaContableConceptos = addenda.getCuentaContableConceptos();
//			this.aduana = addenda.getAduana();
//			this.patente = addenda.getPatente();
//			this.planta = addenda.getPlanta();
//			this.tasa = BigDecimal.ZERO;
//			this.iva = BigDecimal.ZERO;
//			
//			if(cfd != null){
//				switch (version) {
//					case CFDv3_2:
//						com.infra.factura.business.cfdi.ii.schema.Comprobante cfdv3_2 = (com.infra.factura.business.cfdi.ii.schema.Comprobante)cfd.getDocument();
//						this.nombreProveedor = cfdv3_2.getEmisor().getNombre();
//						this.rfcProveedor = cfdv3_2.getEmisor().getRfc();
//						com.infra.factura.business.cfdi.ii.schema.Comprobante.Impuestos.Traslados.Traslado impuestoIva = getImpuestoIva(cfdv3_2.getImpuestos());
//						com.infra.factura.business.cfdi.ii.schema.Comprobante.Conceptos.Concepto concepto = getConcepto(cfdv3_2.getConceptos());
//						
////						if(impuestoIva != null){
////							this.tasa = impuestoIva.getTasa();
////							this.iva = impuestoIva.getImporte();
////						}
//						
//						if(concepto != null){
//							this.concepto = concepto.getDescripcion();
//						}
//						break;
//					default:
//						break;
//				}
//			}
//		}
//	}
	
	public void setAddendaClienteAgenteAduanal(CFDVersion version, GenericCFD cfd) {
//		FeAddendaPedimentosDto addenda = new FeAddendaPedimentosDto();
//		
//		addenda.setPedimento("");
//		addenda.setCuentaContableConceptos("");
//		addenda.setAduana("");
//		addenda.setPatente("");
//		addenda.setPlanta("");
		
//		setAddendaClienteAgenteAduanal(version, cfd, addenda);
	}

	/**
	 * @return the esEnviadoWs
	 */
	public String getEsEnviadoWs() {
		return esEnviadoWs;
	}

	/**
	 * @param esEnviadoWs the esEnviadoWs to set
	 */
	public void setEsEnviadoWs(String esEnviadoWs) {
		this.esEnviadoWs = esEnviadoWs;
	}

	/**
	 * @return the as2Enviado
	 */
	public Boolean getAs2Enviado() {
		return as2Enviado;
	}

	/**
	 * @param as2Enviado the as2Enviado to set
	 */
	public void setAs2Enviado(Boolean as2Enviado) {
		this.as2Enviado = as2Enviado;
	}

	/**
	 * @return the as2EsProcesado
	 */
	public String getAs2EsProcesado() {
		return as2EsProcesado;
	}

	/**
	 * @param as2EsProcesado the as2EsProcesado to set
	 */
	public void setAs2EsProcesado(String as2EsProcesado) {
		this.as2EsProcesado = as2EsProcesado;
	}

	/**
	 * @return the esProcesadoWs
	 */
	public String getEsProcesadoWs() {
		return esProcesadoWs;
	}

	/**
	 * @param esProcesadoWs the esProcesadoWs to set
	 */
	public void setEsProcesadoWs(String esProcesadoWs) {
		this.esProcesadoWs = esProcesadoWs;
	}

    public List<String> getRfcsPermitidos() {
        return rfcsPermitidos;
    }

    public void setRfcsPermitidos(List<String> rfcsPermitidos) {
        this.rfcsPermitidos = rfcsPermitidos;
    }

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(String ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public String getCadenaDocumentosMaterial() {
		return cadenaDocumentosMaterial;
	}

	public void setCadenaDocumentosMaterial(String cadenaDocumentosMaterial) {
		this.cadenaDocumentosMaterial = cadenaDocumentosMaterial;
	}

	public String getSociedad() {
		return sociedad;
	}

	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getTextoCabecera() {
		return textoCabecera;
	}

	public void setTextoCabecera(String textoCabecera) {
		this.textoCabecera = textoCabecera;
	}

	public String getXmlAddenda() {
		return xmlAddenda;
	}

	public void setXmlAddenda(String xmlAddenda) {
		this.xmlAddenda = xmlAddenda;
	}

	public int getIdEscenario() {
		return idEscenario;
	}

	public void setIdEscenario(int idEscenario) {
		this.idEscenario = idEscenario;
	}

    public byte[] getPdfFirmado() {
        return pdfFirmado;
    }

    public void setPdfFirmado(byte[] pdfFirmado) {
        this.pdfFirmado = pdfFirmado;
        setPdfSellado(this.pdfFirmado != null);
    }

    public byte[] getPdfFactura() {
        return pdfFactura;
    }

    public void setPdfFactura(byte[] pdfFactura) {
        this.pdfFactura = pdfFactura;
        setPdf(this.pdfFactura != null);
    }

//	public ImpuestosLocales getImpuestosLocales() {
//		return impuestosLocales;
//	}
//
//	public void setImpuestosLocales(ImpuestosLocales impuestosLocales) {
//		this.impuestosLocales = impuestosLocales;
//	}
	
	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public String getImpuestosLocalesStr(String xml){
		if(xml != null && xml.trim().length() > 0){
			if(xml.indexOf(FeConstantes.TAG_INICIO_IMPUESTOS_LOCALES) > -1){
				return xml.substring(xml.indexOf(FeConstantes.TAG_INICIO_IMPUESTOS_LOCALES), xml.indexOf(FeConstantes.TAG_FIN_IMPUESTOS_LOCALES)) + FeConstantes.TAG_FIN_IMPUESTOS_LOCALES;
			}else{
				return null;	
			}
		}else{
			return null;	
		}
	}

	public Boolean getXml() {
		return xml;
	}

	public void setXml(Boolean xml) {
		this.xml = xml;
	}

	public boolean isExcentoImpuestoTrasladado() {
		return excentoImpuestoTrasladado;
	}

	public void setExcentoImpuestoTrasladado(boolean excentoImpuestoTrasladado) {
		this.excentoImpuestoTrasladado = excentoImpuestoTrasladado;
	}
	
	public String getNombreArchivo() {
		return currencyCode;
	}

	public void setNombreArchivo(String nombre) {
		this.currencyCode = nombre;
	}

	public String getIdsEstatus() {
		return idsEstatus;
	}

	public void setIdsEstatus(String idsEstatus) {
		this.idsEstatus = idsEstatus;
	}
	
	public Boolean getAplicaUuidLike() {
		return aplicaUuidLike;
	}

	public void setAplicaUuidLike(Boolean aplicaUuidLike) {
		this.aplicaUuidLike = aplicaUuidLike;
	}

	public Boolean getAplicaFolioLike() {
		return aplicaFolioLike;
	}

	public void setAplicaFolioLike(Boolean aplicaFolioLike) {
		this.aplicaFolioLike = aplicaFolioLike;
	}

	public String getPedimento() {
		return pedimento;
	}

	public void setPedimento(String pedimento) {
		this.pedimento = pedimento;
	}

	public String getCuentaContableConceptos() {
		return cuentaContableConceptos;
	}

	public void setCuentaContableConceptos(String cuentaContableConceptos) {
		this.cuentaContableConceptos = cuentaContableConceptos;
	}

	public String getAduana() {
		return aduana;
	}

	public void setAduana(String aduana) {
		this.aduana = aduana;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
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

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public BigDecimal getTasa() {
		return tasa;
	}

	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public boolean isAgenteAduanal() {
		return agenteAduanal;
	}

	public void setAgenteAduanal(boolean agenteAduanal) {
		this.agenteAduanal = agenteAduanal;
	}

	public long getIdFacturaAduanal() {
		return idFacturaAduanal;
	}

	public void setIdFacturaAduanal(long idFacturaAduanal) {
		this.idFacturaAduanal = idFacturaAduanal;
	}
	
	
	/** CFDI v3.3 y pagos**/
//	public String tipoCFD(com.infra.factura.business.cfdi.iii.schema.CTipoDeComprobante tipoDeComprobante){
//		
//		String respuesta;
//		switch (tipoDeComprobante) {
//		case I:
//			respuesta = "INGRESO";
//			break;
//		case E:
//			respuesta = "EGRESO";
//			break;
//		case T:
//			respuesta = "TRASLADO";
//			break;
//		case N:
//			respuesta = "NOMINA";
//			break;
//		case P:
//			respuesta = "PAGO";
//			break;
//		default:
//			respuesta = "none";
//			break;
//		}
//		return respuesta;
//	}
}
