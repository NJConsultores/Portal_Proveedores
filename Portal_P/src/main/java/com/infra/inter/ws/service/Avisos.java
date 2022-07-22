/**
 * Avisos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.inter.ws.service;

public class Avisos  implements java.io.Serializable {
    private com.infra.service.AvisosRequest params;

    public Avisos() {
    }

    public Avisos(
           com.infra.service.AvisosRequest params) {
           this.params = params;
    }


    /**
     * Gets the params value for this Avisos.
     * 
     * @return params
     */
    public com.infra.service.AvisosRequest getParams() {
        return params;
    }


    /**
     * Sets the params value for this Avisos.
     * 
     * @param params
     */
    public void setParams(com.infra.service.AvisosRequest params) {
        this.params = params;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Avisos)) return false;
        Avisos other = (Avisos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.params==null && other.getParams()==null) || 
             (this.params!=null &&
              this.params.equals(other.getParams())));
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
        if (getParams() != null) {
            _hashCode += getParams().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Avisos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.ws.inter.infra.com/", "avisos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("params");
        elemField.setXmlName(new javax.xml.namespace.QName("", "params"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "avisosRequest"));
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
