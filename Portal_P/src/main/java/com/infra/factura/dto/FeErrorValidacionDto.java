package com.infra.factura.dto;

import java.util.Date;

import com.infra.core.util.SatUtil;

public class FeErrorValidacionDto {
    private int idErrorValidacion;
    private String clave;
    private String descripcion;	
    private String estatus;
    private String[] parametros;
    private String mensaje;
    private Date fechaValidacion;
    
    
    public FeErrorValidacionDto() {
    }
    
    public FeErrorValidacionDto(String clave, String descripcion) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
	}

    public FeErrorValidacionDto(String clave, String descripcion, String[] parametros) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.parametros = parametros;
	}

	/**
     * @return the idErrorValidacion
     */
    public int getIdErrorValidacion() {
        return idErrorValidacion;
    }

    /**
     * @param idErrorValidacion the idErrorValidacion to set
     */
    public void setIdErrorValidacion(int idErrorValidacion) {
        this.idErrorValidacion = idErrorValidacion;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    public String[] getParametros() {
	return parametros;
    }
    
    public void setParametros(String[] parametros) {
    	this.parametros = parametros;
    }	

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(Date fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
    }
    
    
    public String getStringParametros() {
        StringBuilder parametrosBuffer = new StringBuilder();
        if (parametros != null && parametros.length > 0) {
            for (int i = 0; i < parametros.length; i++) {
                parametrosBuffer.append(parametros[i]);
                if (i != (parametros.length - 1)) {
                    parametrosBuffer.append("|");
                }
            }
        }
        return parametrosBuffer.toString();
    }
    
    @Override
	public String toString() {
    	if(clave == null || clave.trim().isEmpty()){
    		if(parametros != null){
    			return SatUtil.sustituirArgumentos(descripcion, parametros);
    		}else{
    			return descripcion;
    		}
    	}
    	
    	if(parametros != null){
    		return clave + ":" + SatUtil.sustituirArgumentos(descripcion, parametros);
		}
    	
		return descripcion;
	}
}
