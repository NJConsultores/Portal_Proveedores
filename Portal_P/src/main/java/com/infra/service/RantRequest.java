/**
 * RantRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class RantRequest  implements java.io.Serializable {
    private functions.rfc.sap.document.sap_com.ZPORTAL_S_LANT[] anticipos;

    private java.lang.String estatus;

    private java.lang.String idioma;

    private java.lang.String mensaje;

    private java.lang.String proveedor;

    private java.lang.String sociedad;

    public RantRequest() {
    }

    public RantRequest(
           functions.rfc.sap.document.sap_com.ZPORTAL_S_LANT[] anticipos,
           java.lang.String estatus,
           java.lang.String idioma,
           java.lang.String mensaje,
           java.lang.String proveedor,
           java.lang.String sociedad) {
           this.anticipos = anticipos;
           this.estatus = estatus;
           this.idioma = idioma;
           this.mensaje = mensaje;
           this.proveedor = proveedor;
           this.sociedad = sociedad;
    }


    /**
     * Gets the anticipos value for this RantRequest.
     * 
     * @return anticipos
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_LANT[] getAnticipos() {
        return anticipos;
    }


    /**
     * Sets the anticipos value for this RantRequest.
     * 
     * @param anticipos
     */
    public void setAnticipos(functions.rfc.sap.document.sap_com.ZPORTAL_S_LANT[] anticipos) {
        this.anticipos = anticipos;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_LANT getAnticipos(int i) {
        return this.anticipos[i];
    }

    public void setAnticipos(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_LANT _value) {
        this.anticipos[i] = _value;
    }


    /**
     * Gets the estatus value for this RantRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this RantRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this RantRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this RantRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the mensaje value for this RantRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this RantRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the proveedor value for this RantRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this RantRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }


    /**
     * Gets the sociedad value for this RantRequest.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this RantRequest.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RantRequest)) return false;
        RantRequest other = (RantRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anticipos==null && other.getAnticipos()==null) || 
             (this.anticipos!=null &&
              java.util.Arrays.equals(this.anticipos, other.getAnticipos()))) &&
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
              this.proveedor.equals(other.getProveedor()))) &&
            ((this.sociedad==null && other.getSociedad()==null) || 
             (this.sociedad!=null &&
              this.sociedad.equals(other.getSociedad())));
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
        if (getAnticipos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnticipos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnticipos(), i);
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
        if (getSociedad() != null) {
            _hashCode += getSociedad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RantRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "rantRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anticipos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anticipos"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_LANT"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sociedad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sociedad"));
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
