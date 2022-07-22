
package com.infra.factura.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 8/12/2014
 * @author rlagunas
 */
public class SAPEnviarFacturaStrategy implements EnviarFacturaStrategy{
    private static final Logger logger = LoggerFactory.getLogger(SAPEnviarFacturaStrategy.class);

    @Override
    public void enviarFactura() {
        logger.info("Enviar factura a SAP");
        
        try {
            
        } catch (Exception e) {
            logger.error("Error al enviar factura a SAP",e);
        }
        
        logger.info("Terminando envio de factura a SAP.");

    }

}
