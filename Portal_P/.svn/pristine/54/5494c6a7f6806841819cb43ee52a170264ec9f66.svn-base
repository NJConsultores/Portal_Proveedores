package com.infra.factura.exception;

import com.infra.factura.dto.FeResultadoValidaCFDDto;

/**
 *
 * @author rlagunas
 */
public class EnvioFacturaException extends Exception{
    private final FeResultadoValidaCFDDto resultado;

    public EnvioFacturaException(FeResultadoValidaCFDDto r, String message) {
        super(message);
        this.resultado = r;
    }

    public FeResultadoValidaCFDDto getResultado() {
        return resultado;
    }
    
}
