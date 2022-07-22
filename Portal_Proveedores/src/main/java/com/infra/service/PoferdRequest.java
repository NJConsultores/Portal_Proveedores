/**
 * PoferdRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class PoferdRequest  implements java.io.Serializable {
    private java.lang.String estatus;

    private java.lang.String idOC;

    private java.lang.String idioma;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERD[] listado;

    private java.lang.String mensaje;

    private java.lang.String proveedor;

    private java.lang.String sociedad;

    public PoferdRequest() {
    }

    public PoferdRequest(
           java.lang.String estatus,
           java.lang.String idOC,
           java.lang.String idioma,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERD[] listado,
           java.lang.String mensaje,
           java.lang.String proveedor,
           java.lang.String sociedad) {
           this.estatus = estatus;
           this.idOC = idOC;
           this.idioma = idioma;
           this.listado = listado;
           this.mensaje = mensaje;
           this.proveedor = proveedor;
           this.sociedad = sociedad;
    }


    /**
     * Gets the estatus value for this PoferdRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this PoferdRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idOC value for this PoferdRequest.
     * 
     * @return idOC
     */
    public java.lang.String getIdOC() {
        return idOC;
    }


    /**
     * Sets the idOC value for this PoferdRequest.
     * 
     * @param idOC
     */
    public void setIdOC(java.lang.String idOC) {
        this.idOC = idOC;
    }


    /**
     * Gets the idioma value for this PoferdRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this PoferdRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the listado value for this PoferdRequest.
     * 
     * @return listado
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERD[] getListado() {
        return listado;
    }


    /**
     * Sets the listado value for this PoferdRequest.
     * 
     * @param listado
     */
    public void setListado(functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERD[] listado) {
        this.listado = listado;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERD getListado(int i) {
        return this.listado[i];
    }

    public void setListado(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_POFERD _value) {
        this.listado[i] = _value;
    }


    /**
     * Gets the mensaje value for this PoferdRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this PoferdRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the proveedor value for this PoferdRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this PoferdRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }


    /**
     * Gets the sociedad value for this PoferdRequest.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this PoferdRequest.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PoferdRequest)) return false;
        PoferdRequest other = (PoferdRequest) obj;
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
            ((this.idOC==null && other.getIdOC()==null) || 
             (this.idOC!=null &&
              this.idOC.equals(other.getIdOC()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.listado==null && other.getListado()==null) || 
             (this.listado!=null &&
              java.util.Arrays.equals(this.listado, other.getListado()))) &&
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
        if (getIdOC() != null) {
            _hashCode += getIdOC().hashCode();
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
        new org.apache.axis.description.TypeDesc(PoferdRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "poferdRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idOC"));
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
        elemField.setFieldName("listado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listado"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_POFERD"));
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
