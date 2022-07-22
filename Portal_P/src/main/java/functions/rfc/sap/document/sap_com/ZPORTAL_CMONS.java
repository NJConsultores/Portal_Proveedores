/**
 * ZPORTAL_CMONS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_CMONS  implements java.io.Serializable {
    private java.lang.String MANDT;

    private java.lang.String WAERS;

    public ZPORTAL_CMONS() {
    }

    public ZPORTAL_CMONS(
           java.lang.String MANDT,
           java.lang.String WAERS) {
           this.MANDT = MANDT;
           this.WAERS = WAERS;
    }


    /**
     * Gets the MANDT value for this ZPORTAL_CMONS.
     * 
     * @return MANDT
     */
    public java.lang.String getMANDT() {
        return MANDT;
    }


    /**
     * Sets the MANDT value for this ZPORTAL_CMONS.
     * 
     * @param MANDT
     */
    public void setMANDT(java.lang.String MANDT) {
        this.MANDT = MANDT;
    }


    /**
     * Gets the WAERS value for this ZPORTAL_CMONS.
     * 
     * @return WAERS
     */
    public java.lang.String getWAERS() {
        return WAERS;
    }


    /**
     * Sets the WAERS value for this ZPORTAL_CMONS.
     * 
     * @param WAERS
     */
    public void setWAERS(java.lang.String WAERS) {
        this.WAERS = WAERS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_CMONS)) return false;
        ZPORTAL_CMONS other = (ZPORTAL_CMONS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.MANDT==null && other.getMANDT()==null) || 
             (this.MANDT!=null &&
              this.MANDT.equals(other.getMANDT()))) &&
            ((this.WAERS==null && other.getWAERS()==null) || 
             (this.WAERS!=null &&
              this.WAERS.equals(other.getWAERS())));
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
        if (getMANDT() != null) {
            _hashCode += getMANDT().hashCode();
        }
        if (getWAERS() != null) {
            _hashCode += getWAERS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_CMONS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_CMONS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MANDT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MANDT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WAERS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WAERS"));
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
