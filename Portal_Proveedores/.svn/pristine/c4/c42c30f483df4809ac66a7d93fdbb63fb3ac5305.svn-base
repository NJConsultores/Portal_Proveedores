/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.factura.service;

import java.io.Serializable;

/**
 *
 * @author rlagunas
 */
public class EnviarFactura implements Serializable{
    private EnviarFacturaStrategy strategy;

    public EnviarFactura() {
        strategy = new DefaultEnviarFacturaStrategy();
    }

    public void enviarFacturaCliente(){
        strategy.enviarFactura();
    }
    
    public void setStrategy(EnviarFacturaStrategy strategy) {
        this.strategy = strategy;
    }
    
    
    
    
}
