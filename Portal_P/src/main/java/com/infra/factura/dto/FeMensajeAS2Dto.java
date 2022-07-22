package com.infra.factura.dto;

import java.util.Date;

import com.infra.factura.util.FeConstantes.Destino_Mensaje;
import com.infra.factura.util.FeConstantes.Estatus_Archivo_AS2;
import com.infra.factura.util.FeConstantes.Estatus_Mensaje_AS2;
import com.infra.factura.util.FeConstantes.Tipo_Mensaje_AS2;

public class FeMensajeAS2Dto {
	private String idFactura;
	private String idMensaje;
	private String nombreArchivo;
	private Date fecProcesMsg;
	private Date fecProcesArchivo;
	private Estatus_Mensaje_AS2 estatusMensaje = Estatus_Mensaje_AS2.PendienteEnvio;
	private Estatus_Archivo_AS2 estatusArchivo = Estatus_Archivo_AS2.NoProcesado;
	private Tipo_Mensaje_AS2 tipoMensaje = Tipo_Mensaje_AS2.Otro;
	private String cadenaMensaje;
	private Destino_Mensaje destinoMensaje;
	
	public Destino_Mensaje getDestinoMensaje() {
		return destinoMensaje;
	}

	public void setDestinoMensaje(Destino_Mensaje destinoMensaje) {
		this.destinoMensaje = destinoMensaje;
	}

	public boolean envioPermitido() {
		if ((estatusMensaje == Estatus_Mensaje_AS2.EnProceso)
				|| (estatusMensaje == Estatus_Mensaje_AS2.Confirmado)) {
			return false;
		} else {
			return true;
		}
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Date getFecProcesMsg() {
		return fecProcesMsg;
	}

	public void setFecProcesMsg(Date fecProcesMsg) {
		this.fecProcesMsg = fecProcesMsg;
	}

	public Date getFecProcesArchivo() {
		return fecProcesArchivo;
	}

	public void setFecProcesArchivo(Date fecProcesArchivo) {
		this.fecProcesArchivo = fecProcesArchivo;
	}

	public Estatus_Mensaje_AS2 getEstatusMensaje() {
		return estatusMensaje;
	}

	public void setEstatusMensaje(Estatus_Mensaje_AS2 estatusMensaje) {
		this.estatusMensaje = estatusMensaje;
	}

	public Estatus_Archivo_AS2 getEstatusArchivo() {
		return estatusArchivo;
	}

	public void setEstatusArchivo(Estatus_Archivo_AS2 estatusArchivo) {
		this.estatusArchivo = estatusArchivo;
	}

	public Tipo_Mensaje_AS2 getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(Tipo_Mensaje_AS2 tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public String getCadenaMensaje() {
		return cadenaMensaje;
	}

	public void setCadenaMensaje(String cadenaMensaje) {
		this.cadenaMensaje = cadenaMensaje;
	}
}
