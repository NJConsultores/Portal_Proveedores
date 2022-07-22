package com.infra.factura.dto;

import com.infra.core.model.dto.ArchivoAdjuntoDto;

public class FeEnviaArchivoFACPedEmpDto {
	private boolean satisfactorio;
    private String mensajeError;
    private ArchivoAdjuntoDto archivo;
    
	public boolean isSatisfactorio() {
		return satisfactorio;
	}
	public void setSatisfactorio(boolean satisfactorio) {
		this.satisfactorio = satisfactorio;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public ArchivoAdjuntoDto getArchivo() {
		return archivo;
	}
	public void setArchivo(ArchivoAdjuntoDto archivo) {
		this.archivo = archivo;
	}
}
