/**
 * MultasRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class MultasRequest  implements java.io.Serializable {
    private java.lang.String estatus;

    private java.lang.String idioma;

    private java.lang.String mensaje;

    private java.lang.String proveedor;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_DETALLE_MULTAS;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL;

    private java.lang.String sociedad;

    public MultasRequest() {
    }

    public MultasRequest(
           java.lang.String estatus,
           java.lang.String idioma,
           java.lang.String mensaje,
           java.lang.String proveedor,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_DETALLE_MULTAS,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL,
           java.lang.String sociedad) {
           this.estatus = estatus;
           this.idioma = idioma;
           this.mensaje = mensaje;
           this.proveedor = proveedor;
           this.s_BONIFICACIONES = s_BONIFICACIONES;
           this.s_BONIF_ESP = s_BONIF_ESP;
           this.s_DETALLE_MULTAS = s_DETALLE_MULTAS;
           this.s_MULTAS = s_MULTAS;
           this.s_REB_ANUAL = s_REB_ANUAL;
           this.sociedad = sociedad;
    }


    /**
     * Gets the estatus value for this MultasRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this MultasRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this MultasRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this MultasRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the mensaje value for this MultasRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this MultasRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the proveedor value for this MultasRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this MultasRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }


    /**
     * Gets the s_BONIFICACIONES value for this MultasRequest.
     * 
     * @return s_BONIFICACIONES
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] getS_BONIFICACIONES() {
        return s_BONIFICACIONES;
    }


    /**
     * Sets the s_BONIFICACIONES value for this MultasRequest.
     * 
     * @param s_BONIFICACIONES
     */
    public void setS_BONIFICACIONES(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES) {
        this.s_BONIFICACIONES = s_BONIFICACIONES;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE getS_BONIFICACIONES(int i) {
        return this.s_BONIFICACIONES[i];
    }

    public void setS_BONIFICACIONES(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE _value) {
        this.s_BONIFICACIONES[i] = _value;
    }


    /**
     * Gets the s_BONIF_ESP value for this MultasRequest.
     * 
     * @return s_BONIF_ESP
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] getS_BONIF_ESP() {
        return s_BONIF_ESP;
    }


    /**
     * Sets the s_BONIF_ESP value for this MultasRequest.
     * 
     * @param s_BONIF_ESP
     */
    public void setS_BONIF_ESP(functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP) {
        this.s_BONIF_ESP = s_BONIF_ESP;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP getS_BONIF_ESP(int i) {
        return this.s_BONIF_ESP[i];
    }

    public void setS_BONIF_ESP(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP _value) {
        this.s_BONIF_ESP[i] = _value;
    }


    /**
     * Gets the s_DETALLE_MULTAS value for this MultasRequest.
     * 
     * @return s_DETALLE_MULTAS
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] getS_DETALLE_MULTAS() {
        return s_DETALLE_MULTAS;
    }


    /**
     * Sets the s_DETALLE_MULTAS value for this MultasRequest.
     * 
     * @param s_DETALLE_MULTAS
     */
    public void setS_DETALLE_MULTAS(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_DETALLE_MULTAS) {
        this.s_DETALLE_MULTAS = s_DETALLE_MULTAS;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB getS_DETALLE_MULTAS(int i) {
        return this.s_DETALLE_MULTAS[i];
    }

    public void setS_DETALLE_MULTAS(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB _value) {
        this.s_DETALLE_MULTAS[i] = _value;
    }


    /**
     * Gets the s_MULTAS value for this MultasRequest.
     * 
     * @return s_MULTAS
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] getS_MULTAS() {
        return s_MULTAS;
    }


    /**
     * Sets the s_MULTAS value for this MultasRequest.
     * 
     * @param s_MULTAS
     */
    public void setS_MULTAS(functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS) {
        this.s_MULTAS = s_MULTAS;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS getS_MULTAS(int i) {
        return this.s_MULTAS[i];
    }

    public void setS_MULTAS(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS _value) {
        this.s_MULTAS[i] = _value;
    }


    /**
     * Gets the s_REB_ANUAL value for this MultasRequest.
     * 
     * @return s_REB_ANUAL
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] getS_REB_ANUAL() {
        return s_REB_ANUAL;
    }


    /**
     * Sets the s_REB_ANUAL value for this MultasRequest.
     * 
     * @param s_REB_ANUAL
     */
    public void setS_REB_ANUAL(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL) {
        this.s_REB_ANUAL = s_REB_ANUAL;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL getS_REB_ANUAL(int i) {
        return this.s_REB_ANUAL[i];
    }

    public void setS_REB_ANUAL(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL _value) {
        this.s_REB_ANUAL[i] = _value;
    }


    /**
     * Gets the sociedad value for this MultasRequest.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this MultasRequest.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MultasRequest)) return false;
        MultasRequest other = (MultasRequest) obj;
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
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.proveedor==null && other.getProveedor()==null) || 
             (this.proveedor!=null &&
              this.proveedor.equals(other.getProveedor()))) &&
            ((this.s_BONIFICACIONES==null && other.getS_BONIFICACIONES()==null) || 
             (this.s_BONIFICACIONES!=null &&
              java.util.Arrays.equals(this.s_BONIFICACIONES, other.getS_BONIFICACIONES()))) &&
            ((this.s_BONIF_ESP==null && other.getS_BONIF_ESP()==null) || 
             (this.s_BONIF_ESP!=null &&
              java.util.Arrays.equals(this.s_BONIF_ESP, other.getS_BONIF_ESP()))) &&
            ((this.s_DETALLE_MULTAS==null && other.getS_DETALLE_MULTAS()==null) || 
             (this.s_DETALLE_MULTAS!=null &&
              java.util.Arrays.equals(this.s_DETALLE_MULTAS, other.getS_DETALLE_MULTAS()))) &&
            ((this.s_MULTAS==null && other.getS_MULTAS()==null) || 
             (this.s_MULTAS!=null &&
              java.util.Arrays.equals(this.s_MULTAS, other.getS_MULTAS()))) &&
            ((this.s_REB_ANUAL==null && other.getS_REB_ANUAL()==null) || 
             (this.s_REB_ANUAL!=null &&
              java.util.Arrays.equals(this.s_REB_ANUAL, other.getS_REB_ANUAL()))) &&
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
        if (getS_BONIFICACIONES() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_BONIFICACIONES());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_BONIFICACIONES(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_BONIF_ESP() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_BONIF_ESP());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_BONIF_ESP(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_DETALLE_MULTAS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_DETALLE_MULTAS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_DETALLE_MULTAS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_MULTAS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_MULTAS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_MULTAS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_REB_ANUAL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_REB_ANUAL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_REB_ANUAL(), i);
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
        new org.apache.axis.description.TypeDesc(MultasRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "multasRequest"));
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
        elemField.setFieldName("s_BONIFICACIONES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_BONIFICACIONES"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_REBATE"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_BONIF_ESP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_BONIF_ESP"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_BONESP"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_DETALLE_MULTAS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_DETALLE_MULTAS"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_REBANUAL_CAB"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_MULTAS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_MULTAS"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_MULTAS"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_REB_ANUAL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_REB_ANUAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_REBANUAL"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sociedad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sociedad"));
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
