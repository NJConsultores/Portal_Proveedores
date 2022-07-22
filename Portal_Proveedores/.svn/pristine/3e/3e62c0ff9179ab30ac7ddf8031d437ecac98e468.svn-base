/*
 *
 */
package com.infra.core.util;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author rlagunas
 * @param <T> Objeto al cual se parseara
 */
public class CoreParseUtil<T> {
    private Class<T> c;

    public CoreParseUtil(Class<T> c) {
        this.c = c;
    }
    
    
    /**
     * Metodo que parsea un arreglo de bytes y retorna una lista de Objetos especificado en T.
     * Debe indicarse en propiedades la posicion del arreglo generado a partir de separar cada linea
     * y la propiedad java para poder asociarse a ella.
     * 
     * @param data Fuente de bytes
     * @param propiedades Posicion y propiedad Java de la clase T
     * @param t Objeto Java al cual se convertirá
     * @param separator String que separara cada linea
     * @return Lista de objetos parseados
     */
    public List<T> parse(byte[] data, Map<Integer, String> propiedades, T t, String separator) {

        List<T> lista = new ArrayList<>();
        try {
          
            if(data != null){
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                Scanner scanner = new Scanner(in);
                
                while(scanner.hasNext()){
                    lista.add(parse(scanner.nextLine(), propiedades, separator));
                }
                
                
            }
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return lista;
    }
    
     public T parse(String cadena, Map<Integer, String> propiedades, String separator) {
               
        T resultado = null;
        
        try {
            resultado = (T) c.newInstance();
            
            if(cadena != null){
                String[] data = cadena.split(separator,-1);
                
                if(data != null){
                    Set<Integer> set = propiedades.keySet();
                    String propiedad;
                    for(Integer i : set){
                        propiedad = propiedades.get(i); //Propiedad java
                        Object value = data[i]; //Valor en el string
                        
                        Field field = c.getDeclaredField(propiedad);
                        field.setAccessible(true);
                        
                        Class tipoDato = field.getType();
                        
                        field.set(resultado, getValue(tipoDato, value));                                                
                      
                    }
                }
                
                
            }
            
        } catch (Exception ex) {
            System.err.println("Error al parsear" + ex);
            
        }
        return resultado;
    }
     
    private Object getValue(Class c, Object value){
        Object o = null;

        if(c != null){
            
            if(Short.class.equals(c)){
                o = new Short(value.toString());
            }else if(Integer.class.equals(c)){
                o = new Integer(value.toString());
            }else if(Long.class.equals(c)){
                o = new Long(value.toString());
            }else if(Float.class.equals(c)){
                o = new Float(value.toString());
            }else if(Double.class.equals(c)){
                o = new Double(value.toString());
            }else if(String.class.equals(c)){
                o = (String) value;
            }else{
                //otros tipos se debe procesar despues
            }
            
        }
        
        return o;
    } 
    
}
