/**
 * ZPORTAL_S_IMPS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_IMPS  implements java.io.Serializable {
    private java.lang.String MWSKZ;

    private java.lang.String TEXT1;

    private java.math.BigDecimal TASA;

    public ZPORTAL_S_IMPS() {
    }

    public ZPORTAL_S_IMPS(
           java.lang.String MWSKZ,
           java.lang.String TEXT1,
           java.math.BigDecimal TASA) {
           this.MWSKZ = MWSKZ;
           this.TEXT1 = TEXT1;
           this.TASA = TASA;
    }


    /**
     * Gets the MWSKZ value for this ZPORTAL_S_IMPS.
     * 
     * @return MWSKZ
     */
    public java.lang.String getMWSKZ() {
        return MWSKZ;
    }


    /**
     * Sets the MWSKZ value for this ZPORTAL_S_IMPS.
     * 
     * @param MWSKZ
     */
    public void setMWSKZ(java.lang.String MWSKZ) {
        this.MWSKZ = MWSKZ;
    }


    /**
     * Gets the TEXT1 value for this ZPORTAL_S_IMPS.
     * 
     * @return TEXT1
     */
    public java.lang.String getTEXT1() {
        return TEXT1;
    }


    /**
     * Sets the TEXT1 value for this ZPORTAL_S_IMPS.
     * 
     * @param TEXT1
     */
    public void setTEXT1(java.lang.String TEXT1) {
        this.TEXT1 = TEXT1;
    }


    /**
     * Gets the TASA value for this ZPORTAL_S_IMPS.
     * 
     * @return TASA
     */
    public java.math.BigDecimal getTASA() {
        return TASA;
    }


    /**
     * Sets the TASA value for this ZPORTAL_S_IMPS.
     * 
     * @param TASA
     */
    public void setTASA(java.math.BigDecimal TASA) {
        this.TASA = TASA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_IMPS)) return false;
        ZPORTAL_S_IMPS other = (ZPORTAL_S_IMPS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.MWSKZ==null && other.getMWSKZ()==null) || 
             (this.MWSKZ!=null &&
              this.MWSKZ.equals(other.getMWSKZ()))) &&
            ((this.TEXT1==null && other.getTEXT1()==null) || 
             (this.TEXT1!=null &&
              this.TEXT1.equals(other.getTEXT1()))) &&
            ((this.TASA==null && other.getTASA()==null) || 
             (this.TASA!=null &&
              this.TASA.equals(other.getTASA())));
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
        if (getMWSKZ() != null) {
            _hashCode += getMWSKZ().hashCode();
        }
        if (getTEXT1() != null) {
            _hashCode += getTEXT1().hashCode();
        }
        if (getTASA() != null) {
            _hashCode += getTASA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_IMPS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_IMPS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MWSKZ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MWSKZ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TEXT1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TEXT1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TASA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TASA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
