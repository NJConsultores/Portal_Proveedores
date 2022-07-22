package com.infra.factura.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class NumeroUtil {
	private static DecimalFormat FORMATO = new DecimalFormat();
	
	public static String formato(BigDecimal numero, String patron){
		Locale.setDefault(new Locale("es_MX"));
		
		FORMATO.applyPattern(patron);
		
		return FORMATO.format(numero);
	}
	
	public static String formatoMoneda(BigDecimal numero){
		return formato(numero, "$ #,###.00");
	}
	
	public static String formatoMoneda(double numero){
		return formatoMoneda(new BigDecimal(numero));
	}
	
	public static String formatoMoneda(float numero){
		return formatoMoneda(new BigDecimal(numero));
	}
	
	public static String formatoNumero(BigDecimal numero){
		return formato(numero, "###0.00");
	}
	
	public static String formatoNumero(double numero){
		return formatoNumero(new BigDecimal(numero));
	}
	
	public static String formatoNumero(float numero){
		return formatoNumero(new BigDecimal(numero));
	}
	
	public static String formatoDecimales(BigDecimal numero){
		return formato(numero, "#,###.00");
	}	
}
