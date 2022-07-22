/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.factura.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para almacenar la informacion de las respuesta de envio masivo
 *
 * @author rlagunas
 */
public class RespuestaEnvioMasivoDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String archivo;
    private boolean error;
    private String mensaje;
    private int idProveedor;
    private List<FeErrorValidacionDto> resultadoValidacion;
    private List<FeResultadoValidaCFDDto> resultados;

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<FeErrorValidacionDto> getResultadoValidacion() {
        return resultadoValidacion;
    }

    public void setResultadoValidacion(List<FeErrorValidacionDto> resultadoValidacion) {
        this.resultadoValidacion = resultadoValidacion;
    }
    
    public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public List<FeResultadoValidaCFDDto> getResultados() {
    	FeResultadoValidaCFDDto res = null;
    	
    	if(resultados==null){
    		res = new FeResultadoValidaCFDDto();
    		resultados = new ArrayList<FeResultadoValidaCFDDto>();
    		
    		resultados.add(res);
    	}
    	
		return resultados;
	}

	public void setResultados(List<FeResultadoValidaCFDDto> resultados) {
		this.resultados = resultados;
	}
	
	public List<FeFacturaDto> getFacturas() {
		List<FeFacturaDto> facturas = new ArrayList<FeFacturaDto>();
    	
    	if(resultados!=null){
    		for(FeResultadoValidaCFDDto resultado:resultados){
    			FeFacturaDto factura = resultado.getFactura();
    			
    			if(factura != null){
    				if(factura.isAgenteAduanal()){
    					this.idProveedor = factura.getIdProveedor();
    				}
    				
    				facturas.add(resultado.getFactura());
    			}
    		}
    	}
    	
		return facturas;
	}
}
