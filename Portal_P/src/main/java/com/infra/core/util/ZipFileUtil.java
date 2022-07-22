/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infra.core.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;

/**
 *
 * @author rlagunas
 */
public class ZipFileUtil {

    /**
     * Metodo que obtiene la lista de archivos en un ZIP.
     *
     * @param is InputStream con el contenido del ZIP
     * @param extensiones Lista de extensiones a filtrar
     * @return Lista con los nombres de los archivos
     * @throws Exception Si el archivo es null o no es un ZIP se lanza una
     * excepción.
     */
    public static List<String> obtenerArchivosZip(InputStream is, String... extensiones) throws Exception {
        if (is == null) {
            throw new Exception(LocaleUtil.getResourceBundle().getString("error.contenido.vacio"));
        }

        List<String> archivos = new ArrayList<>();

        ZipInputStream zip = new ZipInputStream(new BufferedInputStream(is));
        ZipEntry entry = zip.getNextEntry();

        while (entry != null) {
            if (extensiones != null) {
                for (String e : extensiones) {
                    if (entry.getName().endsWith(e)) {
                        archivos.add(entry.getName());
                    }
                }
            } else {
                archivos.add(entry.getName());
            }

            entry = zip.getNextEntry();
        }

        return archivos;
    }

    /**
     * Obtiene el contenido de los archivos a partir de un archivo ZIP.
     * @param is
     * @param extensiones
     * @return
     * @throws Exception 
     */
    public static List<ArchivoZip> obtenerContenidoZip(InputStream is, String... extensiones) throws Exception {
        if (is == null) {
            throw new Exception(LocaleUtil.getResourceBundle().getString("error.contenido.vacio"));
        }
        
        List<ArchivoZip> archivos = new ArrayList<>();
        ZipInputStream zip = new ZipInputStream(new BufferedInputStream(is));

        ZipEntry entry = zip.getNextEntry();
        while (entry != null) {
            if (!entry.isDirectory()) {
                if (extensiones != null && extensiones.length > 0) {
                    for (String e : extensiones) {
                        if (entry.getName().toLowerCase().endsWith(e)) {
                            archivos.add(buildArchivoZip(entry, zip));
                        }
                    }
                } else {
                    archivos.add(buildArchivoZip(entry, zip));
                }
            }
            
            entry = zip.getNextEntry();
        }
        
        is.close();

        return archivos;
    }
    
    /**
     * Obtiene el contenido de los archivos a partir de un archivo ZIP.
     * @param is
     * @param extensiones
     * @return
     * @throws Exception 
     */
    public static HashMap<String, ArchivoZip> obtenerHashContenidoZip(InputStream is, String... extensiones) throws Exception {
        if (is == null) {
            throw new Exception(LocaleUtil.getResourceBundle().getString("error.contenido.vacio"));
        }
        
        HashMap<String, ArchivoZip> archivos = new HashMap<String, ArchivoZip>();
        ArchivoZip archivo = null;
        ZipInputStream zip = new ZipInputStream(new BufferedInputStream(is));

        ZipEntry entry = zip.getNextEntry();
        while (entry != null) {
            if (!entry.isDirectory()) {
                if (extensiones != null && extensiones.length > 0) {
                    for (String e : extensiones) {
                        if (entry.getName().toLowerCase().endsWith(e)) {
                        	archivo = buildArchivoZip(entry, zip);
                        	
                        	if(archivo != null && archivo.getContenido() != null){
                        		archivos.put(archivo.getNombre().toUpperCase(), archivo);
                        	}
                        }
                    }
                } else {
                	archivo = buildArchivoZip(entry, zip);
                	
                	if(archivo != null && archivo.getContenido() != null){
                		archivos.put(archivo.getNombre().toUpperCase(), archivo);
                	}
                }
            }
            
            entry = zip.getNextEntry();
        }
        
        is.close();
        zip.close();
        
        archivo = null;
        is = null;
        zip = null;
        
        return archivos;
    }

    private static ArchivoZip buildArchivoZip(ZipEntry entry, ZipInputStream zip) throws Exception {

        String valor = entry.getName();
        int pos = valor.lastIndexOf("/");

        String name;
        if (pos != -1) {
            name = valor.substring(pos + 1);
        } else {
            name = entry.getName();
        }

        byte[] data = IOUtils.toByteArray(zip);
        ArchivoZip a = new ArchivoZip();
        a.setPath(entry.getName());
        a.setSize(entry.getSize());
        a.setNombre(name);
        a.setContenido(data);
        a.setDirectorio(entry.isDirectory());

       
        return a;

    }
    
    
}
