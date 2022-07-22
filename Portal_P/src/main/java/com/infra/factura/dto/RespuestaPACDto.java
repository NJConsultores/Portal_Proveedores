




package com.infra.factura.dto;

public class RespuestaPACDto {
	private boolean valido;
    private String errores;
    private String Comentario;
    private String uuid;
    private String json;
    private ValidacionDto Validaciones;
    
    
    
	
	public boolean isValido() {
		return valido;
	}
	
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
	public String getErrores() {
		return errores;
	}
	
	public void setErrores(String errores) {
		this.errores = errores;
	}
	
	public String getComentario() {
		return Comentario;
	}
	
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	
	public String getUuid() {
        return this.uuid;
    }
	
	public void setUuid(String uuid) {
        this.uuid = uuid;
    }
	
	public String getJson() {
        return this.json;
    }
	
	public void setJson(String json) {
        this.json = json;
    }
	
	public ValidacionDto getValidaciones() {
		return Validaciones;
	}
	
	public void setValidaciones(ValidacionDto validaciones) {
		Validaciones = validaciones;
	}
}
