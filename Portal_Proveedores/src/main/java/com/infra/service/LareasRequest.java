/**
 * LareasRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class LareasRequest  implements java.io.Serializable {
    private functions.rfc.sap.document.sap_com.ZPORTAL_CSOCA[] areas;

    private java.lang.String estatus;

    private java.lang.String idioma;

    private java.lang.String mensaje;

    private functions.rfc.sap.document.sap_com.ZPORTAL_CSOCR[] responsables;

    private java.lang.String sociedad;

    public LareasRequest() {
    }

    public LareasRequest(
           functions.rfc.sap.document.sap_com.ZPORTAL_CSOCA[] areas,
           java.lang.String estatus,
           java.lang.String idioma,
           java.lang.String mensaje,
           functions.rfc.sap.document.sap_com.ZPORTAL_CSOCR[] responsables,
           java.lang.String sociedad) {
           this.areas = areas;
           this.estatus = estatus;
           this.idioma = idioma;
           this.mensaje = mensaje;
           this.responsables = responsables;
           this.sociedad = sociedad;
    }


    /**
     * Gets the areas value for this LareasRequest.
     * 
     * @return areas
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_CSOCA[] getAreas() {
        return areas;
    }


    /**
     * Sets the areas value for this LareasRequest.
     * 
     * @param areas
     */
    public void setAreas(functions.rfc.sap.document.sap_com.ZPORTAL_CSOCA[] areas) {
        this.areas = areas;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_CSOCA getAreas(int i) {
        return this.areas[i];
    }

    public void setAreas(int i, functions.rfc.sap.document.sap_com.ZPORTAL_CSOCA _value) {
        this.areas[i] = _value;
    }


    /**
     * Gets the estatus value for this LareasRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this LareasRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this LareasRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this LareasRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the mensaje value for this LareasRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this LareasRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the responsables value for this LareasRequest.
     * 
     * @return responsables
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_CSOCR[] getResponsables() {
        return responsables;
    }


    /**
     * Sets the responsables value for this LareasRequest.
     * 
     * @param responsables
     */
    public void setResponsables(functions.rfc.sap.document.sap_com.ZPORTAL_CSOCR[] responsables) {
        this.responsables = responsables;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_CSOCR getResponsables(int i) {
        return this.responsables[i];
    }

    public void setResponsables(int i, functions.rfc.sap.document.sap_com.ZPORTAL_CSOCR _value) {
        this.responsables[i] = _value;
    }


    /**
     * Gets the sociedad value for this LareasRequest.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this LareasRequest.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LareasRequest)) return false;
        LareasRequest other = (LareasRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.areas==null && other.getAreas()==null) || 
             (this.areas!=null &&
              java.util.Arrays.equals(this.areas, other.getAreas()))) &&
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.responsables==null && other.getResponsables()==null) || 
             (this.responsables!=null &&
              java.util.Arrays.equals(this.responsables, other.getResponsables()))) &&
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
        if (getAreas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAreas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAreas(), i);
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
        if (getResponsables() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResponsables());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResponsables(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSociedad() != null) {
            _hashCode += getSociedad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LareasRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "lareasRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("areas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "areas"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_CSOCA"));
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
        elemField.setFieldName("responsables");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responsables"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_CSOCR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
