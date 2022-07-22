/**
 * ZPORTAL_S_REGION.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_REGION  implements java.io.Serializable {
    private java.lang.String REGION;

    private java.lang.String TEXTO;

    public ZPORTAL_S_REGION() {
    }

    public ZPORTAL_S_REGION(
           java.lang.String REGION,
           java.lang.String TEXTO) {
           this.REGION = REGION;
           this.TEXTO = TEXTO;
    }


    /**
     * Gets the REGION value for this ZPORTAL_S_REGION.
     * 
     * @return REGION
     */
    public java.lang.String getREGION() {
        return REGION;
    }


    /**
     * Sets the REGION value for this ZPORTAL_S_REGION.
     * 
     * @param REGION
     */
    public void setREGION(java.lang.String REGION) {
        this.REGION = REGION;
    }


    /**
     * Gets the TEXTO value for this ZPORTAL_S_REGION.
     * 
     * @return TEXTO
     */
    public java.lang.String getTEXTO() {
        return TEXTO;
    }


    /**
     * Sets the TEXTO value for this ZPORTAL_S_REGION.
     * 
     * @param TEXTO
     */
    public void setTEXTO(java.lang.String TEXTO) {
        this.TEXTO = TEXTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_REGION)) return false;
        ZPORTAL_S_REGION other = (ZPORTAL_S_REGION) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.REGION==null && other.getREGION()==null) || 
             (this.REGION!=null &&
              this.REGION.equals(other.getREGION()))) &&
            ((this.TEXTO==null && other.getTEXTO()==null) || 
             (this.TEXTO!=null &&
              this.TEXTO.equals(other.getTEXTO())));
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
        if (getREGION() != null) {
            _hashCode += getREGION().hashCode();
        }
        if (getTEXTO() != null) {
            _hashCode += getTEXTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_REGION.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_REGION"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REGION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "REGION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TEXTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TEXTO"));
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
