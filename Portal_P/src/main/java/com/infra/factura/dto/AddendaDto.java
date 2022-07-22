/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.factura.dto;

import java.io.Serializable;

/**
 * Addenda generica
 * 3/12/2014
 * @author rlagunas
 */
public class AddendaDto implements Serializable{
    private String nombreAddenda;

    public String getNombreAddenda() {
        return nombreAddenda;
    }

    public void setNombreAddenda(String nombreAddenda) {
        this.nombreAddenda = nombreAddenda;
    }
    
    

}
