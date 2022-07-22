/**
 * OavisosRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class OavisosRequest  implements java.io.Serializable {
    private functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO[] avisos;

    private java.lang.String estatus;

    private java.lang.String idioma;

    private java.lang.String mensaje;

    private java.lang.String proveedor;

    public OavisosRequest() {
    }

    public OavisosRequest(
           functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO[] avisos,
           java.lang.String estatus,
           java.lang.String idioma,
           java.lang.String mensaje,
           java.lang.String proveedor) {
           this.avisos = avisos;
           this.estatus = estatus;
           this.idioma = idioma;
           this.mensaje = mensaje;
           this.proveedor = proveedor;
    }


    /**
     * Gets the avisos value for this OavisosRequest.
     * 
     * @return avisos
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO[] getAvisos() {
        return avisos;
    }


    /**
     * Sets the avisos value for this OavisosRequest.
     * 
     * @param avisos
     */
    public void setAvisos(functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO[] avisos) {
        this.avisos = avisos;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO getAvisos(int i) {
        return this.avisos[i];
    }

    public void setAvisos(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO _value) {
        this.avisos[i] = _value;
    }


    /**
     * Gets the estatus value for this OavisosRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this OavisosRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this OavisosRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this OavisosRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the mensaje value for this OavisosRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this OavisosRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the proveedor value for this OavisosRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this OavisosRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OavisosRequest)) return false;
        OavisosRequest other = (OavisosRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.avisos==null && other.getAvisos()==null) || 
             (this.avisos!=null &&
              java.util.Arrays.equals(this.avisos, other.getAvisos()))) &&
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.proveedor==null && other.getProveedor()==null) || 
             (this.proveedor!=null &&
              this.proveedor.equals(other.getProveedor())));
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
        if (getAvisos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAvisos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAvisos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getProveedor() != null) {
            _hashCode += getProveedor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OavisosRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "oavisosRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avisos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avisos"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_AVISO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("proveedor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proveedor"));
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
