/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.factura.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rlagunas
 */
public class ResultadoMasivoDto {
    private boolean error;
    private final List<RespuestaEnvioMasivoDto> respuestas;
    private boolean verErroresLayout;

    public ResultadoMasivoDto() {
        respuestas = new ArrayList<>();
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<RespuestaEnvioMasivoDto> getRespuestas() {
        return respuestas;
    }

	public boolean isVerErroresLayout() {
		return verErroresLayout;
	}

	public void setVerErroresLayout(boolean verErroresLayout) {
		this.verErroresLayout = verErroresLayout;
	}
}
