/**
 * ZPORTAL_S_INCOT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_INCOT  implements java.io.Serializable {
    private java.lang.String INCO1;

    private java.lang.String INCO2;

    public ZPORTAL_S_INCOT() {
    }

    public ZPORTAL_S_INCOT(
           java.lang.String INCO1,
           java.lang.String INCO2) {
           this.INCO1 = INCO1;
           this.INCO2 = INCO2;
    }


    /**
     * Gets the INCO1 value for this ZPORTAL_S_INCOT.
     * 
     * @return INCO1
     */
    public java.lang.String getINCO1() {
        return INCO1;
    }


    /**
     * Sets the INCO1 value for this ZPORTAL_S_INCOT.
     * 
     * @param INCO1
     */
    public void setINCO1(java.lang.String INCO1) {
        this.INCO1 = INCO1;
    }


    /**
     * Gets the INCO2 value for this ZPORTAL_S_INCOT.
     * 
     * @return INCO2
     */
    public java.lang.String getINCO2() {
        return INCO2;
    }


    /**
     * Sets the INCO2 value for this ZPORTAL_S_INCOT.
     * 
     * @param INCO2
     */
    public void setINCO2(java.lang.String INCO2) {
        this.INCO2 = INCO2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_INCOT)) return false;
        ZPORTAL_S_INCOT other = (ZPORTAL_S_INCOT) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.INCO1==null && other.getINCO1()==null) || 
             (this.INCO1!=null &&
              this.INCO1.equals(other.getINCO1()))) &&
            ((this.INCO2==null && other.getINCO2()==null) || 
             (this.INCO2!=null &&
              this.INCO2.equals(other.getINCO2())));
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
        if (getINCO1() != null) {
            _hashCode += getINCO1().hashCode();
        }
        if (getINCO2() != null) {
            _hashCode += getINCO2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_INCOT.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_INCOT"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INCO1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "INCO1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INCO2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "INCO2"));
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
