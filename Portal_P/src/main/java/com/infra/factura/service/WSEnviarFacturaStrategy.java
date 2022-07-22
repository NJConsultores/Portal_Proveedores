/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infra.factura.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rlagunas
 */
public class WSEnviarFacturaStrategy implements EnviarFacturaStrategy {

    private static final Logger logger = LoggerFactory.getLogger(WSEnviarFacturaStrategy.class);

    @Override
    public void enviarFactura() {
        logger.info("Enviando factura por WS");
    }

}