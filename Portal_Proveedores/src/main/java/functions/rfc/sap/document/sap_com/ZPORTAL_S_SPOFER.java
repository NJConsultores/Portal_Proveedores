/**
 * ZPORTAL_S_SPOFER.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_SPOFER  implements java.io.Serializable {
    private java.lang.String STATUS;

    private java.lang.String TEXTO;

    public ZPORTAL_S_SPOFER() {
    }

    public ZPORTAL_S_SPOFER(
           java.lang.String STATUS,
           java.lang.String TEXTO) {
           this.STATUS = STATUS;
           this.TEXTO = TEXTO;
    }


    /**
     * Gets the STATUS value for this ZPORTAL_S_SPOFER.
     * 
     * @return STATUS
     */
    public java.lang.String getSTATUS() {
        return STATUS;
    }


    /**
     * Sets the STATUS value for this ZPORTAL_S_SPOFER.
     * 
     * @param STATUS
     */
    public void setSTATUS(java.lang.String STATUS) {
        this.STATUS = STATUS;
    }


    /**
     * Gets the TEXTO value for this ZPORTAL_S_SPOFER.
     * 
     * @return TEXTO
     */
    public java.lang.String getTEXTO() {
        return TEXTO;
    }


    /**
     * Sets the TEXTO value for this ZPORTAL_S_SPOFER.
     * 
     * @param TEXTO
     */
    public void setTEXTO(java.lang.String TEXTO) {
        this.TEXTO = TEXTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_SPOFER)) return false;
        ZPORTAL_S_SPOFER other = (ZPORTAL_S_SPOFER) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.STATUS==null && other.getSTATUS()==null) || 
             (this.STATUS!=null &&
              this.STATUS.equals(other.getSTATUS()))) &&
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
        if (getSTATUS() != null) {
            _hashCode += getSTATUS().hashCode();
        }
        if (getTEXTO() != null) {
            _hashCode += getTEXTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_SPOFER.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_SPOFER"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATUS"));
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
