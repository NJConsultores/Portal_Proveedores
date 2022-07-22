package com.infra.factura.util;

import java.util.List;

public class HtmlUtil {
	private static final int TAM_RENGLON         = 35;
	private static final int TAM_RENGLON_PADDING = 150;
	
	public static int obtenerAlturaTablaHtml(List<?> lista){
		if(lista == null || lista.size() == 0){
			return TAM_RENGLON;
		}else if(lista.size() == 1){
			return lista.size()*TAM_RENGLON+TAM_RENGLON_PADDING-65;
		}
		else{
			return lista.size()*TAM_RENGLON+TAM_RENGLON_PADDING;
		}
	}
}
