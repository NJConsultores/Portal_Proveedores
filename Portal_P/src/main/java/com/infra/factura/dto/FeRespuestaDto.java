package com.infra.factura.dto;

public class FeRespuestaDto {

    private boolean error = false;
    private boolean registroNoEncontrado = false;
    private boolean advertencia = false;
    private String descripcion;
    private Object respuesta;

    public boolean isAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(boolean advertencia) {
        this.advertencia = advertencia;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Object respuesta) {
        this.respuesta = respuesta;
    }

	public boolean isRegistroNoEncontrado() {
		return registroNoEncontrado;
	}

	public void setRegistroNoEncontrado(boolean registroNoEncontrado) {
		this.registroNoEncontrado = registroNoEncontrado;
	}

}
