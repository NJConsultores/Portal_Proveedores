package com.infra.core.util;

import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

import com.infra.factura.dto.FeErrorValidacionDto;

@Service
public class ErrorValidacionUtil {
	
	private final static ResourceBundle resources = ResourceBundle.getBundle("errores_validacion");
	
	public static FeErrorValidacionDto obtenerErrorValidacion(String claveError) {
		return new FeErrorValidacionDto(claveError, obtenerMensaje(claveError, 0));
	}

	public static FeErrorValidacionDto obtenerErrorValidacionEn(String claveError) {
		return new FeErrorValidacionDto(claveError, obtenerMensaje(claveError, 1));
	}
	
	private static String obtenerMensaje(String claveError, int indice){
		String errorCompleto = resources.getString(claveError);
//		System.out.println("errorCompleto: "+errorCompleto);
		String [] valores = errorCompleto.split(" \\|");
		return valores[indice];
	}

}
