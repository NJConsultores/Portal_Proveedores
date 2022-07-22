/**
 * LspoferRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class LspoferRequest  implements java.io.Serializable {
    private java.lang.String estatus;

    private java.lang.String idioma;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_SPOFER[] listado;

    private java.lang.String mensaje;

    public LspoferRequest() {
    }

    public LspoferRequest(
           java.lang.String estatus,
           java.lang.String idioma,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_SPOFER[] listado,
           java.lang.String mensaje) {
           this.estatus = estatus;
           this.idioma = idioma;
           this.listado = listado;
           this.mensaje = mensaje;
    }


    /**
     * Gets the estatus value for this LspoferRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this LspoferRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this LspoferRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this LspoferRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the listado value for this LspoferRequest.
     * 
     * @return listado
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_SPOFER[] getListado() {
        return listado;
    }


    /**
     * Sets the listado value for this LspoferRequest.
     * 
     * @param listado
     */
    public void setListado(functions.rfc.sap.document.sap_com.ZPORTAL_S_SPOFER[] listado) {
        this.listado = listado;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_SPOFER getListado(int i) {
        return this.listado[i];
    }

    public void setListado(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_SPOFER _value) {
        this.listado[i] = _value;
    }


    /**
     * Gets the mensaje value for this LspoferRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this LspoferRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LspoferRequest)) return false;
        LspoferRequest other = (LspoferRequest) obj;
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
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.listado==null && other.getListado()==null) || 
             (this.listado!=null &&
              java.util.Arrays.equals(this.listado, other.getListado()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje())));
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
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getListado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LspoferRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "lspoferRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("listado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listado"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_SPOFER"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
