/**
 * StatusRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class StatusRequest  implements java.io.Serializable {
    private java.lang.String estatus;

    private java.lang.String estatusRespuesta;

    private java.lang.String fecha;

    private java.lang.String idioma;

    private java.lang.String mensaje;

    private java.lang.String mensajeRespuesta;

    private java.lang.String pdf;

    private java.lang.String proveedor;

    private java.lang.String xml;

    public StatusRequest() {
    }

    public StatusRequest(
           java.lang.String estatus,
           java.lang.String estatusRespuesta,
           java.lang.String fecha,
           java.lang.String idioma,
           java.lang.String mensaje,
           java.lang.String mensajeRespuesta,
           java.lang.String pdf,
           java.lang.String proveedor,
           java.lang.String xml) {
           this.estatus = estatus;
           this.estatusRespuesta = estatusRespuesta;
           this.fecha = fecha;
           this.idioma = idioma;
           this.mensaje = mensaje;
           this.mensajeRespuesta = mensajeRespuesta;
           this.pdf = pdf;
           this.proveedor = proveedor;
           this.xml = xml;
    }


    /**
     * Gets the estatus value for this StatusRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this StatusRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the estatusRespuesta value for this StatusRequest.
     * 
     * @return estatusRespuesta
     */
    public java.lang.String getEstatusRespuesta() {
        return estatusRespuesta;
    }


    /**
     * Sets the estatusRespuesta value for this StatusRequest.
     * 
     * @param estatusRespuesta
     */
    public void setEstatusRespuesta(java.lang.String estatusRespuesta) {
        this.estatusRespuesta = estatusRespuesta;
    }


    /**
     * Gets the fecha value for this StatusRequest.
     * 
     * @return fecha
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this StatusRequest.
     * 
     * @param fecha
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the idioma value for this StatusRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this StatusRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the mensaje value for this StatusRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this StatusRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the mensajeRespuesta value for this StatusRequest.
     * 
     * @return mensajeRespuesta
     */
    public java.lang.String getMensajeRespuesta() {
        return mensajeRespuesta;
    }


    /**
     * Sets the mensajeRespuesta value for this StatusRequest.
     * 
     * @param mensajeRespuesta
     */
    public void setMensajeRespuesta(java.lang.String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }


    /**
     * Gets the pdf value for this StatusRequest.
     * 
     * @return pdf
     */
    public java.lang.String getPdf() {
        return pdf;
    }


    /**
     * Sets the pdf value for this StatusRequest.
     * 
     * @param pdf
     */
    public void setPdf(java.lang.String pdf) {
        this.pdf = pdf;
    }


    /**
     * Gets the proveedor value for this StatusRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this StatusRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }


    /**
     * Gets the xml value for this StatusRequest.
     * 
     * @return xml
     */
    public java.lang.String getXml() {
        return xml;
    }


    /**
     * Sets the xml value for this StatusRequest.
     * 
     * @param xml
     */
    public void setXml(java.lang.String xml) {
        this.xml = xml;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StatusRequest)) return false;
        StatusRequest other = (StatusRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            ((this.estatusRespuesta==null && other.getEstatusRespuesta()==null) || 
             (this.estatusRespuesta!=null &&
              this.estatusRespuesta.equals(other.getEstatusRespuesta()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.mensajeRespuesta==null && other.getMensajeRespuesta()==null) || 
             (this.mensajeRespuesta!=null &&
              this.mensajeRespuesta.equals(other.getMensajeRespuesta()))) &&
            ((this.pdf==null && other.getPdf()==null) || 
             (this.pdf!=null &&
              this.pdf.equals(other.getPdf()))) &&
            ((this.proveedor==null && other.getProveedor()==null) || 
             (this.proveedor!=null &&
              this.proveedor.equals(other.getProveedor()))) &&
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
        if (getEstatus() != null) {
            _hashCode += getEstatus().hashCode();
        }
        if (getEstatusRespuesta() != null) {
            _hashCode += getEstatusRespuesta().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getMensajeRespuesta() != null) {
            _hashCode += getMensajeRespuesta().hashCode();
        }
        if (getPdf() != null) {
            _hashCode += getPdf().hashCode();
        }
        if (getProveedor() != null) {
            _hashCode += getProveedor().hashCode();
        }
        if (getXml() != null) {
            _hashCode += getXml().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StatusRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "statusRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatusRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatusRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("mensajeRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensajeRespuesta"));
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
