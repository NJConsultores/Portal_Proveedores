/**
 * Sociedad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class Sociedad  implements java.io.Serializable {
    private java.lang.String bukrs;

    private java.lang.String butxt;

    private java.lang.String stcd1;

    public Sociedad() {
    }

    public Sociedad(
           java.lang.String bukrs,
           java.lang.String butxt,
           java.lang.String stcd1) {
           this.bukrs = bukrs;
           this.butxt = butxt;
           this.stcd1 = stcd1;
    }


    /**
     * Gets the bukrs value for this Sociedad.
     * 
     * @return bukrs
     */
    public java.lang.String getBukrs() {
        return bukrs;
    }


    /**
     * Sets the bukrs value for this Sociedad.
     * 
     * @param bukrs
     */
    public void setBukrs(java.lang.String bukrs) {
        this.bukrs = bukrs;
    }


    /**
     * Gets the butxt value for this Sociedad.
     * 
     * @return butxt
     */
    public java.lang.String getButxt() {
        return butxt;
    }


    /**
     * Sets the butxt value for this Sociedad.
     * 
     * @param butxt
     */
    public void setButxt(java.lang.String butxt) {
        this.butxt = butxt;
    }


    /**
     * Gets the stcd1 value for this Sociedad.
     * 
     * @return stcd1
     */
    public java.lang.String getStcd1() {
        return stcd1;
    }


    /**
     * Sets the stcd1 value for this Sociedad.
     * 
     * @param stcd1
     */
    public void setStcd1(java.lang.String stcd1) {
        this.stcd1 = stcd1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sociedad)) return false;
        Sociedad other = (Sociedad) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bukrs==null && other.getBukrs()==null) || 
             (this.bukrs!=null &&
              this.bukrs.equals(other.getBukrs()))) &&
            ((this.butxt==null && other.getButxt()==null) || 
             (this.butxt!=null &&
              this.butxt.equals(other.getButxt()))) &&
            ((this.stcd1==null && other.getStcd1()==null) || 
             (this.stcd1!=null &&
              this.stcd1.equals(other.getStcd1())));
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
        if (getBukrs() != null) {
            _hashCode += getBukrs().hashCode();
        }
        if (getButxt() != null) {
            _hashCode += getButxt().hashCode();
        }
        if (getStcd1() != null) {
            _hashCode += getStcd1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sociedad.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "sociedad"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bukrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bukrs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("butxt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "butxt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stcd1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stcd1"));
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
