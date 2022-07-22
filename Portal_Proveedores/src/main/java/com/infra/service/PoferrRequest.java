/**
 * PoferrRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class PoferrRequest  implements java.io.Serializable {
    private java.lang.String estatus;

    private java.lang.String idioma;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_H[] listadoCabecero;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_D[] listadoDetalle;

    private java.lang.String mensaje;

    private java.lang.String proveedor;

    private java.lang.String sociedad;

    public PoferrRequest() {
    }

    public PoferrRequest(
           java.lang.String estatus,
           java.lang.String idioma,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_H[] listadoCabecero,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_D[] listadoDetalle,
           java.lang.String mensaje,
           java.lang.String proveedor,
           java.lang.String sociedad) {
           this.estatus = estatus;
           this.idioma = idioma;
           this.listadoCabecero = listadoCabecero;
           this.listadoDetalle = listadoDetalle;
           this.mensaje = mensaje;
           this.proveedor = proveedor;
           this.sociedad = sociedad;
    }


    /**
     * Gets the estatus value for this PoferrRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this PoferrRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this PoferrRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this PoferrRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the listadoCabecero value for this PoferrRequest.
     * 
     * @return listadoCabecero
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_H[] getListadoCabecero() {
        return listadoCabecero;
    }


    /**
     * Sets the listadoCabecero value for this PoferrRequest.
     * 
     * @param listadoCabecero
     */
    public void setListadoCabecero(functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_H[] listadoCabecero) {
        this.listadoCabecero = listadoCabecero;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_H getListadoCabecero(int i) {
        return this.listadoCabecero[i];
    }

    public void setListadoCabecero(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_H _value) {
        this.listadoCabecero[i] = _value;
    }


    /**
     * Gets the listadoDetalle value for this PoferrRequest.
     * 
     * @return listadoDetalle
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_D[] getListadoDetalle() {
        return listadoDetalle;
    }


    /**
     * Sets the listadoDetalle value for this PoferrRequest.
     * 
     * @param listadoDetalle
     */
    public void setListadoDetalle(functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_D[] listadoDetalle) {
        this.listadoDetalle = listadoDetalle;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_D getListadoDetalle(int i) {
        return this.listadoDetalle[i];
    }

    public void setListadoDetalle(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERR_D _value) {
        this.listadoDetalle[i] = _value;
    }


    /**
     * Gets the mensaje value for this PoferrRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this PoferrRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the proveedor value for this PoferrRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this PoferrRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }


    /**
     * Gets the sociedad value for this PoferrRequest.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this PoferrRequest.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PoferrRequest)) return false;
        PoferrRequest other = (PoferrRequest) obj;
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
            ((this.listadoCabecero==null && other.getListadoCabecero()==null) || 
             (this.listadoCabecero!=null &&
              java.util.Arrays.equals(this.listadoCabecero, other.getListadoCabecero()))) &&
            ((this.listadoDetalle==null && other.getListadoDetalle()==null) || 
             (this.listadoDetalle!=null &&
              java.util.Arrays.equals(this.listadoDetalle, other.getListadoDetalle()))) &&
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
        if (getEstatus() != null) {
            _hashCode += getEstatus().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getListadoCabecero() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListadoCabecero());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListadoCabecero(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListadoDetalle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListadoDetalle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListadoDetalle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(PoferrRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "poferrRequest"));
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
        elemField.setFieldName("listadoCabecero");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listadoCabecero"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_POFERR_H"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listadoDetalle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listadoDetalle"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_POFERR_D"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
