package com.infra.factura.dto;

import java.io.InputStream;
import java.util.Date;

public class FeArchivoSoporteDto {

    private String nombre;
    private byte[] contenido;
    private long idFactura;
    private InputStream stream;
    private int size;
    private Date fechaRecepcion;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

}
