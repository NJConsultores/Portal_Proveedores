/**
 * Sumar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.inter.ws.service;

public class Sumar  implements java.io.Serializable {
    private int param1;

    private int param2;

    public Sumar() {
    }

    public Sumar(
           int param1,
           int param2) {
           this.param1 = param1;
           this.param2 = param2;
    }


    /**
     * Gets the param1 value for this Sumar.
     * 
     * @return param1
     */
    public int getParam1() {
        return param1;
    }


    /**
     * Sets the param1 value for this Sumar.
     * 
     * @param param1
     */
    public void setParam1(int param1) {
        this.param1 = param1;
    }


    /**
     * Gets the param2 value for this Sumar.
     * 
     * @return param2
     */
    public int getParam2() {
        return param2;
    }


    /**
     * Sets the param2 value for this Sumar.
     * 
     * @param param2
     */
    public void setParam2(int param2) {
        this.param2 = param2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sumar)) return false;
        Sumar other = (Sumar) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.param1 == other.getParam1() &&
            this.param2 == other.getParam2();
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
        _hashCode += getParam1();
        _hashCode += getParam2();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sumar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.ws.inter.infra.com/", "sumar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "param1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "param2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
