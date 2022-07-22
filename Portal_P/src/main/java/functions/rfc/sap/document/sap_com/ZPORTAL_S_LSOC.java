/**
 * ZPORTAL_S_LSOC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_LSOC  implements java.io.Serializable {
    private java.lang.String BUKRS;

    private java.lang.String BUTXT;

    private java.lang.String STCD1;

    public ZPORTAL_S_LSOC() {
    }

    public ZPORTAL_S_LSOC(
           java.lang.String BUKRS,
           java.lang.String BUTXT,
           java.lang.String STCD1) {
           this.BUKRS = BUKRS;
           this.BUTXT = BUTXT;
           this.STCD1 = STCD1;
    }


    /**
     * Gets the BUKRS value for this ZPORTAL_S_LSOC.
     * 
     * @return BUKRS
     */
    public java.lang.String getBUKRS() {
        return BUKRS;
    }


    /**
     * Sets the BUKRS value for this ZPORTAL_S_LSOC.
     * 
     * @param BUKRS
     */
    public void setBUKRS(java.lang.String BUKRS) {
        this.BUKRS = BUKRS;
    }


    /**
     * Gets the BUTXT value for this ZPORTAL_S_LSOC.
     * 
     * @return BUTXT
     */
    public java.lang.String getBUTXT() {
        return BUTXT;
    }


    /**
     * Sets the BUTXT value for this ZPORTAL_S_LSOC.
     * 
     * @param BUTXT
     */
    public void setBUTXT(java.lang.String BUTXT) {
        this.BUTXT = BUTXT;
    }


    /**
     * Gets the STCD1 value for this ZPORTAL_S_LSOC.
     * 
     * @return STCD1
     */
    public java.lang.String getSTCD1() {
        return STCD1;
    }


    /**
     * Sets the STCD1 value for this ZPORTAL_S_LSOC.
     * 
     * @param STCD1
     */
    public void setSTCD1(java.lang.String STCD1) {
        this.STCD1 = STCD1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_LSOC)) return false;
        ZPORTAL_S_LSOC other = (ZPORTAL_S_LSOC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.BUKRS==null && other.getBUKRS()==null) || 
             (this.BUKRS!=null &&
              this.BUKRS.equals(other.getBUKRS()))) &&
            ((this.BUTXT==null && other.getBUTXT()==null) || 
             (this.BUTXT!=null &&
              this.BUTXT.equals(other.getBUTXT()))) &&
            ((this.STCD1==null && other.getSTCD1()==null) || 
             (this.STCD1!=null &&
              this.STCD1.equals(other.getSTCD1())));
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
        if (getBUKRS() != null) {
            _hashCode += getBUKRS().hashCode();
        }
        if (getBUTXT() != null) {
            _hashCode += getBUTXT().hashCode();
        }
        if (getSTCD1() != null) {
            _hashCode += getSTCD1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_LSOC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_LSOC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUKRS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUKRS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUTXT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUTXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STCD1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STCD1"));
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
