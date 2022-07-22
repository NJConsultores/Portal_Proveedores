package com.infra.util;

import org.primefaces.model.UploadedFile;

public class FileUploadDto
{
    private UploadedFile archivo;
    private String nombreArchivo;
    
    public UploadedFile getArchivo() {
        return this.archivo;
    }
    
    public void setArchivo(final UploadedFile archivo) {
        this.archivo = archivo;
    }
    
    public String getNombreArchivo() {
        return this.nombreArchivo;
    }
    
    public void setNombreArchivo(final String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public FileUploadDto(final UploadedFile archivo, final String nombreArchivo) {
        this.archivo = archivo;
        this.nombreArchivo = nombreArchivo;
    }
}
