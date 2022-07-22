
package com.infra.factura.exception;

import java.util.List;
import com.infra.factura.dto.FeResultadoValidaCFDDto;

/**
 * 20/01/2015
 * @author rlagunas
 */
public class ImportacionesException extends Exception{
    private final List<FeResultadoValidaCFDDto> resultados;

    public ImportacionesException(String message, List<FeResultadoValidaCFDDto> resultados) {
        super(message);
        this.resultados = resultados;
    }

    public List<FeResultadoValidaCFDDto> getResultados() {
        return resultados;
    }
    

}
