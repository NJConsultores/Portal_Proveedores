/**
 * ZPORTAL_OPROVResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_OPROVResponse  implements java.io.Serializable {
    private java.lang.String s_MSG;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_OPRO s_OPC;

    private org.apache.axis.types.UnsignedByte s_STAT;

    public ZPORTAL_OPROVResponse() {
    }

    public ZPORTAL_OPROVResponse(
           java.lang.String s_MSG,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_OPRO s_OPC,
           org.apache.axis.types.UnsignedByte s_STAT) {
           this.s_MSG = s_MSG;
           this.s_OPC = s_OPC;
           this.s_STAT = s_STAT;
    }


    /**
     * Gets the s_MSG value for this ZPORTAL_OPROVResponse.
     * 
     * @return s_MSG
     */
    public java.lang.String getS_MSG() {
        return s_MSG;
    }


    /**
     * Sets the s_MSG value for this ZPORTAL_OPROVResponse.
     * 
     * @param s_MSG
     */
    public void setS_MSG(java.lang.String s_MSG) {
        this.s_MSG = s_MSG;
    }


    /**
     * Gets the s_OPC value for this ZPORTAL_OPROVResponse.
     * 
     * @return s_OPC
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_OPRO getS_OPC() {
        return s_OPC;
    }


    /**
     * Sets the s_OPC value for this ZPORTAL_OPROVResponse.
     * 
     * @param s_OPC
     */
    public void setS_OPC(functions.rfc.sap.document.sap_com.ZPORTAL_S_OPRO s_OPC) {
        this.s_OPC = s_OPC;
    }


    /**
     * Gets the s_STAT value for this ZPORTAL_OPROVResponse.
     * 
     * @return s_STAT
     */
    public org.apache.axis.types.UnsignedByte getS_STAT() {
        return s_STAT;
    }


    /**
     * Sets the s_STAT value for this ZPORTAL_OPROVResponse.
     * 
     * @param s_STAT
     */
    public void setS_STAT(org.apache.axis.types.UnsignedByte s_STAT) {
        this.s_STAT = s_STAT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_OPROVResponse)) return false;
        ZPORTAL_OPROVResponse other = (ZPORTAL_OPROVResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.s_MSG==null && other.getS_MSG()==null) || 
             (this.s_MSG!=null &&
              this.s_MSG.equals(other.getS_MSG()))) &&
            ((this.s_OPC==null && other.getS_OPC()==null) || 
             (this.s_OPC!=null &&
              this.s_OPC.equals(other.getS_OPC()))) &&
            ((this.s_STAT==null && other.getS_STAT()==null) || 
             (this.s_STAT!=null &&
              this.s_STAT.equals(other.getS_STAT())));
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
        if (getS_MSG() != null) {
            _hashCode += getS_MSG().hashCode();
        }
        if (getS_OPC() != null) {
            _hashCode += getS_OPC().hashCode();
        }
        if (getS_STAT() != null) {
            _hashCode += getS_STAT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_OPROVResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">ZPORTAL_OPROVResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_MSG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_MSG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_OPC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_OPC"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_OPRO"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_STAT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_STAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
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
