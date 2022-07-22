package com.infra.factura.util;

public class CadenaUtil {
	/**
	 * Metodo para generar Claves aleatorias, utilizadas para el registro de usuario o cuando se solicita un cambio de password
	 * @return
	 */
	public static String generaClave(){
		StringBuilder clave = new StringBuilder();
		
		for (int i = 0; i < 5; i++){
			int numAleat = ((int)(Math.random()*122)) + 1;
			if(numAleat >= 97 && numAleat <= 122)
				clave.append((char)numAleat);
			else if(numAleat >= 65 && numAleat <= 90)
				clave.append((char)numAleat);
			else
				clave.append(numAleat);
		}
		
		return clave.toString();
	}
	
	/**
	 * Valida si el valor de un RFC tiene el formato correcto
	 * @param rfc
	 * @return
	 */
	public static boolean rfcValido(String rfc){
            System.out.println("RFC: " + rfc);
		return rfcFisicaValido(rfc) || rfcMoralValido(rfc);
	}
	
	/**
	 * Valida si el valor de un RFC tiene el formato correcto para personas Fisicas
	 * 
	 * FORMATO: 4 caracteres alafanumericos o con el simbolos aaceptados
	 *          2 digitos para el anio
	 *          2 digitos para el mes
	 *          2 digitos para el dia
	 *          3 caracteres alfanumericos
	 *          
	 *          XXXX991231XXX
	 * 
	 * @param rfc
	 * @return
	 */
	public static boolean rfcFisicaValido(String rfc){
		rfc = rfc.toUpperCase();
		boolean banderaValidar;
		
		if(rfc.matches("[A-Z&]{4}[0-9]{2}[0,1][1-9]{1}[0-9]{2}[A-Z0-9]{3}")){
			banderaValidar = true;
		}else{
			banderaValidar = false;
		}
                
                System.out.println("Validando fisica");
		
		return banderaValidar;
	}
	
	/**
	 * Valida si el valor de un RFC tiene el formato correcto para personas Morales
	 * 
	 * FORMATO: 3 caracteres alafanumericos o con el simbolos aaceptados
	 *          2 digitos para el anio
	 *          2 digitos para el mes
	 *          2 digitos para el dia
	 *          3 caracteres alfanumericos
	 *          
	 *          XXX991231XXX
	 * 
	 * @param rfc
	 * @return
	 */
	public static boolean rfcMoralValido(String rfc){
		rfc = rfc.toUpperCase();
		boolean banderaValidar;
		
		if(rfc.matches("[A-Z&]{3}[0-9]{2}[0,1][1-9]{1}[0-9]{2}[A-Z0-9]{3}")){
			banderaValidar = true;
		}else{
			banderaValidar = false;
		}
		
                System.out.println("Validando moral");
		return banderaValidar;
	}
	
	/**
	 * Valida si un correo electronico tiene el formato estandar valido
	 * 
	 * Ejemplos: apodo_nombre@dominio.com
	 *           apodo-nombre@dominio.org
	 *           apodo.nombre@dominio.org.mx
	 *
	 * @param mail
	 * @return
	 */
	public static boolean emailValido(String mail){
		mail = mail.toUpperCase();
		boolean banderaValidar;
		
		if ((mail.matches("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}"))){
			banderaValidar = true;
		}else{
			banderaValidar = false;
		}
		
		return banderaValidar;
	}
	
	
	/**
	 * Metodo para validar caracteres alfanumericos validos en la cadena.
	 * 
	 * @param texto
	 * @return
	 */
	public static boolean validaCarateres(String texto){
		if ((texto.matches("[a-zA-Z0-9|: /]*"))){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Obtiene el nombre de un archivo sin extension
	 * @param nombre
	 * @return el nombre del archivo sin extensión
	 */
	
	public static String obtenerNombreSinExtension(String nombre) {
		String nuevoNombre = "";

		if (nombre != null) {
			int pos = nombre.lastIndexOf(".");

			if (pos != -1) {
				nuevoNombre = nombre.substring(0, pos);
			} else {
				nuevoNombre = nombre;
			}
		}

		return nuevoNombre;
	}
}
