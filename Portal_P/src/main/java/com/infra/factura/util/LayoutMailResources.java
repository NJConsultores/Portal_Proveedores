package com.infra.factura.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class LayoutMailResources {
	private final static ResourceBundle resources = ResourceBundle.getBundle("mail/layout-mail");
	
	public static ResourceBundle getResources(){
		return resources;
	}
	
	public static String getString(String key){
		return resources.getString(key);
	}
	
	public static String getString(String key, Object[] argumentos){
		if(argumentos != null){
			if(argumentos.length == 0){
				return key;
			}else{
				return MessageFormat.format(resources.getString(key), argumentos);
			}
		}else{
			return null;
		}
	}
}
