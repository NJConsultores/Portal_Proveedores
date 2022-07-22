




package com.infra.core.exception; 
public class DatoNoPermitidoException extends Exception{
    private String dato;

    public DatoNoPermitidoException(String dato, String message) {
        super(message);
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
    
}
