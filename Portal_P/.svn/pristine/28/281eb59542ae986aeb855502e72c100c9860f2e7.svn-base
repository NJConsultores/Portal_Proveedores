package com.infra.factura.dto;

import com.infra.cliente.util.ClienteConstantes;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDEstatus;
import com.infra.factura.util.FeConstantes;

public class FeActualizaEstatusDto {

	private long idFactura;
	private String noDocto;
	private String estatus;
	private String fechaPago;
	private String[] mensajes;
	
	
	public long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	public String getNoDocto() {
		return noDocto;
	}
	public void setNoDocto(String noDocto) {
		this.noDocto = noDocto;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public String[] getMensajes() {
		return mensajes;
	}
	public void setMensajes(String[] mensajes) {
		this.mensajes = mensajes;
	}
	
	public int getEstatusPortal() {
		if(estatus.equals(FeConstantes.ESTATUS_SAP_ACEPTADO) || estatus.equals(FeConstantes.ESTATUS_SAP_ACEPTADO_MANUAL)){
			return CFDEstatus.Aceptado.ordinal();
		}else if(estatus.equals(FeConstantes.ESTATUS_SAP_PENDIENTE)  || estatus.equals(FeConstantes.ESTATUS_SAP_ERROR_BAPI)){
			return CFDEstatus.Pendiente.ordinal();
		}else if(estatus.equals(FeConstantes.ESTATUS_SAP_RECHAZADO)){
			return CFDEstatus.Rechazado.ordinal();
		}else if(estatus.equals(FeConstantes.ESTATUS_SAP_SIN_ENTRADA_MERCANCIA)){
			return CFDEstatus.EnRevision.ordinal();
		}else if(estatus.equals(FeConstantes.ESTATUS_PORTAL_POR_AUTRIZAR)){
			return CFDEstatus.PorAutorizar.ordinal();
		}else if(estatus.equals(ClienteConstantes.ESTATUS_SAP_CANCELADO)){
			return CFDEstatus.Cancelado.ordinal();
		}else{
			return CFDEstatus.None.ordinal();
		}
	}
}
