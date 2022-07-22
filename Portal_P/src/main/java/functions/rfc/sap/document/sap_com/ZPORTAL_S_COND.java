/**
 * ZPORTAL_S_COND.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_COND  implements java.io.Serializable {
    private java.lang.String ZTERM;

    private java.lang.String TEXT1;

    public ZPORTAL_S_COND() {
    }

    public ZPORTAL_S_COND(
           java.lang.String ZTERM,
           java.lang.String TEXT1) {
           this.ZTERM = ZTERM;
           this.TEXT1 = TEXT1;
    }


    /**
     * Gets the ZTERM value for this ZPORTAL_S_COND.
     * 
     * @return ZTERM
     */
    public java.lang.String getZTERM() {
        return ZTERM;
    }


    /**
     * Sets the ZTERM value for this ZPORTAL_S_COND.
     * 
     * @param ZTERM
     */
    public void setZTERM(java.lang.String ZTERM) {
        this.ZTERM = ZTERM;
    }


    /**
     * Gets the TEXT1 value for this ZPORTAL_S_COND.
     * 
     * @return TEXT1
     */
    public java.lang.String getTEXT1() {
        return TEXT1;
    }


    /**
     * Sets the TEXT1 value for this ZPORTAL_S_COND.
     * 
     * @param TEXT1
     */
    public void setTEXT1(java.lang.String TEXT1) {
        this.TEXT1 = TEXT1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_COND)) return false;
        ZPORTAL_S_COND other = (ZPORTAL_S_COND) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ZTERM==null && other.getZTERM()==null) || 
             (this.ZTERM!=null &&
              this.ZTERM.equals(other.getZTERM()))) &&
            ((this.TEXT1==null && other.getTEXT1()==null) || 
             (this.TEXT1!=null &&
              this.TEXT1.equals(other.getTEXT1())));
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
        if (getZTERM() != null) {
            _hashCode += getZTERM().hashCode();
        }
        if (getTEXT1() != null) {
            _hashCode += getTEXT1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_COND.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_COND"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ZTERM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ZTERM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TEXT1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TEXT1"));
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
