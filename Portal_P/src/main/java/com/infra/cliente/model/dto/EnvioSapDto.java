




package com.infra.cliente.model.dto;
import com.infra.factura.util.FeConstantes;
import com.infra.factura.util.FeConstantes.TipoProveedor;
import java.util.Date;
import java.util.List;

public class EnvioSapDto {
	private Long idFactura;
	private String xmlAddenda;
	private String folioSat;
	private String folio;
	private String rfcEmisor;
	private String rfcReceptor;
	private String tipoDoc;
	private String total;
	private String subtotal;
	private String descuento;
	private String fechaHoraFac;
	private String fechaRecepcionFormat;
	private String horaRecepcion;
	private String year;
	private String escenario; 
	private Date fechaRecepcion;
	private String trasladosLayout;
	private String retencionesLayout;
	private String claveMoneda;
	private String condicionPago;
	private List<LayoutClienteDto> detalleLayout;
	private TipoProveedor tipoProveedor;
	private String numProveedorSAP;
	
    public EnvioSapDto() {
    } 
	
	public String getCondicionPago() {
		return condicionPago;
	}

	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}

	public List<LayoutClienteDto> getDetalleLayout() {
		return detalleLayout;
	}

	public void setDetalleLayout(List<LayoutClienteDto> detalleLayout) {
		this.detalleLayout = detalleLayout;
	}

	public String getClaveMoneda() {
		return claveMoneda;
	}

	public void setClaveMoneda(String claveMoneda) {
		this.claveMoneda = claveMoneda;
	}

	public String getTrasladosLayout() {
		return trasladosLayout;
	}

	public void setTrasladosLayout(String trasladosLayout) {
		this.trasladosLayout = trasladosLayout;
	}

	public String getRetencionesLayout() {
		return retencionesLayout;
	}

	public void setRetencionesLayout(String retencionesLayout) {
		this.retencionesLayout = retencionesLayout;
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public String getXmlAddenda() {
		return xmlAddenda;
	}

	public void setXmlAddenda(String xmlAddenda) {
		this.xmlAddenda = xmlAddenda;
	}

	public String getFolioSat() {
		return folioSat;
	}

	public void setFolioSat(String folioSat) {
		this.folioSat = folioSat;
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

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getFechaHoraFac() {
		return fechaHoraFac;
	}

	public void setFechaHoraFac(String fechaHoraFac) {
		this.fechaHoraFac = fechaHoraFac;
	}

	public String getFechaRecepcionFormat() {
		return fechaRecepcionFormat;
	}

	public void setFechaRecepcionFormat(String fechaRecepcionFormat) {
		this.fechaRecepcionFormat = fechaRecepcionFormat;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getHoraRecepcion() {
		return horaRecepcion;
	}

	public void setHoraRecepcion(String horaRecepcion) {
		this.horaRecepcion = horaRecepcion;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEscenario() {
		return escenario;
	}

	public void setEscenario(String escenario) {
		this.escenario = escenario;
	} 

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public TipoProveedor getTipoProveedor() {
		return tipoProveedor;
	}
	
	public String getTipoProveedorSAP() {
		String tipo = null;
		
		switch (tipoProveedor) {
			case Nacional:
				tipo = FeConstantes.FLUJO_NACIONAL;
				break;
			case Extranjero:
				tipo = FeConstantes.FLUJO_EXTRANJERO;
				break;
			case Agente_Aduanal_Nacional:
				tipo = FeConstantes.FLUJO_AGENTE_ADUANAL_NACIONAL;
				break;
			case Forwarder_Nacional:
				tipo = FeConstantes.FLUJO_FORWARDER_NACIONAL;
				break;
			case Agente_Aduanal_Extranjero:
				tipo = FeConstantes.FLUJO_AGENTE_ADUANAL_EXTRANJERO;
				break;
			case Forwarder_Extranjero:
				tipo = FeConstantes.FLUJO_FORWARDER_EXTRANJERO;
				break;
			default:
				tipo = FeConstantes.FLUJO_NACIONAL;
				break;
		}
		
		return tipo;
	}

	public void setTipoProveedor(TipoProveedor tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}

	public String getNumProveedorSAP() {
		return numProveedorSAP;
	}

	public void setNumProveedorSAP(String numProveedorSAP) {
		this.numProveedorSAP = numProveedorSAP;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}	 
} 