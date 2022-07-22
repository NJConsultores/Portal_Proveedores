/**
 * CpfactsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class CpfactsRequest  implements java.io.Serializable {
    private java.lang.String estatus;

    private java.lang.String idioma;

    private java.lang.String laufd;

    private java.lang.String laufi;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_CPFACTS[] listado;

    private java.lang.String mensaje;

    private java.lang.String proveedor;

    private java.lang.String sociedad;

    private java.lang.String vblnr;

    public CpfactsRequest() {
    }

    public CpfactsRequest(
           java.lang.String estatus,
           java.lang.String idioma,
           java.lang.String laufd,
           java.lang.String laufi,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_CPFACTS[] listado,
           java.lang.String mensaje,
           java.lang.String proveedor,
           java.lang.String sociedad,
           java.lang.String vblnr) {
           this.estatus = estatus;
           this.idioma = idioma;
           this.laufd = laufd;
           this.laufi = laufi;
           this.listado = listado;
           this.mensaje = mensaje;
           this.proveedor = proveedor;
           this.sociedad = sociedad;
           this.vblnr = vblnr;
    }


    /**
     * Gets the estatus value for this CpfactsRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this CpfactsRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this CpfactsRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this CpfactsRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the laufd value for this CpfactsRequest.
     * 
     * @return laufd
     */
    public java.lang.String getLaufd() {
        return laufd;
    }


    /**
     * Sets the laufd value for this CpfactsRequest.
     * 
     * @param laufd
     */
    public void setLaufd(java.lang.String laufd) {
        this.laufd = laufd;
    }


    /**
     * Gets the laufi value for this CpfactsRequest.
     * 
     * @return laufi
     */
    public java.lang.String getLaufi() {
        return laufi;
    }


    /**
     * Sets the laufi value for this CpfactsRequest.
     * 
     * @param laufi
     */
    public void setLaufi(java.lang.String laufi) {
        this.laufi = laufi;
    }


    /**
     * Gets the listado value for this CpfactsRequest.
     * 
     * @return listado
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_CPFACTS[] getListado() {
        return listado;
    }


    /**
     * Sets the listado value for this CpfactsRequest.
     * 
     * @param listado
     */
    public void setListado(functions.rfc.sap.document.sap_com.ZPORTAL_S_CPFACTS[] listado) {
        this.listado = listado;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_CPFACTS getListado(int i) {
        return this.listado[i];
    }

    public void setListado(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_CPFACTS _value) {
        this.listado[i] = _value;
    }


    /**
     * Gets the mensaje value for this CpfactsRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this CpfactsRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the proveedor value for this CpfactsRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this CpfactsRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }


    /**
     * Gets the sociedad value for this CpfactsRequest.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this CpfactsRequest.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }


    /**
     * Gets the vblnr value for this CpfactsRequest.
     * 
     * @return vblnr
     */
    public java.lang.String getVblnr() {
        return vblnr;
    }


    /**
     * Sets the vblnr value for this CpfactsRequest.
     * 
     * @param vblnr
     */
    public void setVblnr(java.lang.String vblnr) {
        this.vblnr = vblnr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CpfactsRequest)) return false;
        CpfactsRequest other = (CpfactsRequest) obj;
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
            ((this.laufd==null && other.getLaufd()==null) || 
             (this.laufd!=null &&
              this.laufd.equals(other.getLaufd()))) &&
            ((this.laufi==null && other.getLaufi()==null) || 
             (this.laufi!=null &&
              this.laufi.equals(other.getLaufi()))) &&
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
              this.sociedad.equals(other.getSociedad()))) &&
            ((this.vblnr==null && other.getVblnr()==null) || 
             (this.vblnr!=null &&
              this.vblnr.equals(other.getVblnr())));
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
        if (getLaufd() != null) {
            _hashCode += getLaufd().hashCode();
        }
        if (getLaufi() != null) {
            _hashCode += getLaufi().hashCode();
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
        if (getVblnr() != null) {
            _hashCode += getVblnr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CpfactsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "cpfactsRequest"));
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
        elemField.setFieldName("laufd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "laufd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("laufi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "laufi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listado"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_CPFACTS"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vblnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vblnr"));
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
