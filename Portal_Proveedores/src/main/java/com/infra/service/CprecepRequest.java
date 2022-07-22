/**
 * CprecepRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class CprecepRequest  implements java.io.Serializable {
    private java.lang.String documentoPago;

    private java.lang.String ejercicio;

    private java.lang.String estatus;

    private java.lang.String idioma;

    private java.lang.String mensaje;

    private java.lang.String pdf;

    private java.lang.String proveedor;

    private java.lang.String sociedad;

    private java.lang.String xml;

    public CprecepRequest() {
    }

    public CprecepRequest(
           java.lang.String documentoPago,
           java.lang.String ejercicio,
           java.lang.String estatus,
           java.lang.String idioma,
           java.lang.String mensaje,
           java.lang.String pdf,
           java.lang.String proveedor,
           java.lang.String sociedad,
           java.lang.String xml) {
           this.documentoPago = documentoPago;
           this.ejercicio = ejercicio;
           this.estatus = estatus;
           this.idioma = idioma;
           this.mensaje = mensaje;
           this.pdf = pdf;
           this.proveedor = proveedor;
           this.sociedad = sociedad;
           this.xml = xml;
    }


    /**
     * Gets the documentoPago value for this CprecepRequest.
     * 
     * @return documentoPago
     */
    public java.lang.String getDocumentoPago() {
        return documentoPago;
    }


    /**
     * Sets the documentoPago value for this CprecepRequest.
     * 
     * @param documentoPago
     */
    public void setDocumentoPago(java.lang.String documentoPago) {
        this.documentoPago = documentoPago;
    }


    /**
     * Gets the ejercicio value for this CprecepRequest.
     * 
     * @return ejercicio
     */
    public java.lang.String getEjercicio() {
        return ejercicio;
    }


    /**
     * Sets the ejercicio value for this CprecepRequest.
     * 
     * @param ejercicio
     */
    public void setEjercicio(java.lang.String ejercicio) {
        this.ejercicio = ejercicio;
    }


    /**
     * Gets the estatus value for this CprecepRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this CprecepRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this CprecepRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this CprecepRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the mensaje value for this CprecepRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this CprecepRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the pdf value for this CprecepRequest.
     * 
     * @return pdf
     */
    public java.lang.String getPdf() {
        return pdf;
    }


    /**
     * Sets the pdf value for this CprecepRequest.
     * 
     * @param pdf
     */
    public void setPdf(java.lang.String pdf) {
        this.pdf = pdf;
    }


    /**
     * Gets the proveedor value for this CprecepRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this CprecepRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }


    /**
     * Gets the sociedad value for this CprecepRequest.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this CprecepRequest.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }


    /**
     * Gets the xml value for this CprecepRequest.
     * 
     * @return xml
     */
    public java.lang.String getXml() {
        return xml;
    }


    /**
     * Sets the xml value for this CprecepRequest.
     * 
     * @param xml
     */
    public void setXml(java.lang.String xml) {
        this.xml = xml;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CprecepRequest)) return false;
        CprecepRequest other = (CprecepRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documentoPago==null && other.getDocumentoPago()==null) || 
             (this.documentoPago!=null &&
              this.documentoPago.equals(other.getDocumentoPago()))) &&
            ((this.ejercicio==null && other.getEjercicio()==null) || 
             (this.ejercicio!=null &&
              this.ejercicio.equals(other.getEjercicio()))) &&
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.pdf==null && other.getPdf()==null) || 
             (this.pdf!=null &&
              this.pdf.equals(other.getPdf()))) &&
            ((this.proveedor==null && other.getProveedor()==null) || 
             (this.proveedor!=null &&
              this.proveedor.equals(other.getProveedor()))) &&
            ((this.sociedad==null && other.getSociedad()==null) || 
             (this.sociedad!=null &&
              this.sociedad.equals(other.getSociedad()))) &&
            ((this.xml==null && other.getXml()==null) || 
             (this.xml!=null &&
              this.xml.equals(other.getXml())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDocumentoPago() != null) {
            _hashCode += getDocumentoPago().hashCode();
        }
        if (getEjercicio() != null) {
            _hashCode += getEjercicio().hashCode();
        }
        if (getEstatus() != null) {
            _hashCode += getEstatus().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getPdf() != null) {
            _hashCode += getPdf().hashCode();
        }
        if (getProveedor() != null) {
            _hashCode += getProveedor().hashCode();
        }
        if (getSociedad() != null) {
            _hashCode += getSociedad().hashCode();
        }
        if (getXml() != null) {
            _hashCode += getXml().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CprecepRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "cprecepRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoPago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentoPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ejercicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ejercicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idioma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idioma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pdf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pdf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proveedor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proveedor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sociedad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sociedad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xml");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
