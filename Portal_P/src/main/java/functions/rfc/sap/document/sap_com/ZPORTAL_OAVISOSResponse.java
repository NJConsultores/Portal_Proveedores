/**
 * ZPORTAL_OAVISOSResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_OAVISOSResponse  implements java.io.Serializable {
    private functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO[] s_AVISOS;

    private java.lang.String s_MSG;

    private org.apache.axis.types.UnsignedByte s_STAT;

    public ZPORTAL_OAVISOSResponse() {
    }

    public ZPORTAL_OAVISOSResponse(
           functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO[] s_AVISOS,
           java.lang.String s_MSG,
           org.apache.axis.types.UnsignedByte s_STAT) {
           this.s_AVISOS = s_AVISOS;
           this.s_MSG = s_MSG;
           this.s_STAT = s_STAT;
    }


    /**
     * Gets the s_AVISOS value for this ZPORTAL_OAVISOSResponse.
     * 
     * @return s_AVISOS
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO[] getS_AVISOS() {
        return s_AVISOS;
    }


    /**
     * Sets the s_AVISOS value for this ZPORTAL_OAVISOSResponse.
     * 
     * @param s_AVISOS
     */
    public void setS_AVISOS(functions.rfc.sap.document.sap_com.ZPORTAL_S_AVISO[] s_AVISOS) {
        this.s_AVISOS = s_AVISOS;
    }


    /**
     * Gets the s_MSG value for this ZPORTAL_OAVISOSResponse.
     * 
     * @return s_MSG
     */
    public java.lang.String getS_MSG() {
        return s_MSG;
    }


    /**
     * Sets the s_MSG value for this ZPORTAL_OAVISOSResponse.
     * 
     * @param s_MSG
     */
    public void setS_MSG(java.lang.String s_MSG) {
        this.s_MSG = s_MSG;
    }


    /**
     * Gets the s_STAT value for this ZPORTAL_OAVISOSResponse.
     * 
     * @return s_STAT
     */
    public org.apache.axis.types.UnsignedByte getS_STAT() {
        return s_STAT;
    }


    /**
     * Sets the s_STAT value for this ZPORTAL_OAVISOSResponse.
     * 
     * @param s_STAT
     */
    public void setS_STAT(org.apache.axis.types.UnsignedByte s_STAT) {
        this.s_STAT = s_STAT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_OAVISOSResponse)) return false;
        ZPORTAL_OAVISOSResponse other = (ZPORTAL_OAVISOSResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.s_AVISOS==null && other.getS_AVISOS()==null) || 
             (this.s_AVISOS!=null &&
              java.util.Arrays.equals(this.s_AVISOS, other.getS_AVISOS()))) &&
            ((this.s_MSG==null && other.getS_MSG()==null) || 
             (this.s_MSG!=null &&
              this.s_MSG.equals(other.getS_MSG()))) &&
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
        if (getS_AVISOS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_AVISOS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_AVISOS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_MSG() != null) {
            _hashCode += getS_MSG().hashCode();
        }
        if (getS_STAT() != null) {
            _hashCode += getS_STAT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_OAVISOSResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">ZPORTAL_OAVISOSResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_AVISOS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_AVISOS"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_AVISO"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_MSG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_MSG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
