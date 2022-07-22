/**
 * ZPORTAL_CSOCA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_CSOCA  implements java.io.Serializable {
    private java.lang.String MANDT;

    private java.lang.String BUKRS;

    private java.lang.String AREID;

    private java.lang.String AREDS;

    public ZPORTAL_CSOCA() {
    }

    public ZPORTAL_CSOCA(
           java.lang.String MANDT,
           java.lang.String BUKRS,
           java.lang.String AREID,
           java.lang.String AREDS) {
           this.MANDT = MANDT;
           this.BUKRS = BUKRS;
           this.AREID = AREID;
           this.AREDS = AREDS;
    }


    /**
     * Gets the MANDT value for this ZPORTAL_CSOCA.
     * 
     * @return MANDT
     */
    public java.lang.String getMANDT() {
        return MANDT;
    }


    /**
     * Sets the MANDT value for this ZPORTAL_CSOCA.
     * 
     * @param MANDT
     */
    public void setMANDT(java.lang.String MANDT) {
        this.MANDT = MANDT;
    }


    /**
     * Gets the BUKRS value for this ZPORTAL_CSOCA.
     * 
     * @return BUKRS
     */
    public java.lang.String getBUKRS() {
        return BUKRS;
    }


    /**
     * Sets the BUKRS value for this ZPORTAL_CSOCA.
     * 
     * @param BUKRS
     */
    public void setBUKRS(java.lang.String BUKRS) {
        this.BUKRS = BUKRS;
    }


    /**
     * Gets the AREID value for this ZPORTAL_CSOCA.
     * 
     * @return AREID
     */
    public java.lang.String getAREID() {
        return AREID;
    }


    /**
     * Sets the AREID value for this ZPORTAL_CSOCA.
     * 
     * @param AREID
     */
    public void setAREID(java.lang.String AREID) {
        this.AREID = AREID;
    }


    /**
     * Gets the AREDS value for this ZPORTAL_CSOCA.
     * 
     * @return AREDS
     */
    public java.lang.String getAREDS() {
        return AREDS;
    }


    /**
     * Sets the AREDS value for this ZPORTAL_CSOCA.
     * 
     * @param AREDS
     */
    public void setAREDS(java.lang.String AREDS) {
        this.AREDS = AREDS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_CSOCA)) return false;
        ZPORTAL_CSOCA other = (ZPORTAL_CSOCA) obj;
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
            ((this.BUKRS==null && other.getBUKRS()==null) || 
             (this.BUKRS!=null &&
              this.BUKRS.equals(other.getBUKRS()))) &&
            ((this.AREID==null && other.getAREID()==null) || 
             (this.AREID!=null &&
              this.AREID.equals(other.getAREID()))) &&
            ((this.AREDS==null && other.getAREDS()==null) || 
             (this.AREDS!=null &&
              this.AREDS.equals(other.getAREDS())));
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
        if (getBUKRS() != null) {
            _hashCode += getBUKRS().hashCode();
        }
        if (getAREID() != null) {
            _hashCode += getAREID().hashCode();
        }
        if (getAREDS() != null) {
            _hashCode += getAREDS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_CSOCA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_CSOCA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MANDT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MANDT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUKRS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUKRS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AREID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AREID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AREDS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AREDS"));
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
