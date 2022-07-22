/**
 * ZPORTAL_OPROV.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_OPROV  implements java.io.Serializable {
    private java.lang.String e_LANG;

    private java.lang.String e_LIFNR;

    public ZPORTAL_OPROV() {
    }

    public ZPORTAL_OPROV(
           java.lang.String e_LANG,
           java.lang.String e_LIFNR) {
           this.e_LANG = e_LANG;
           this.e_LIFNR = e_LIFNR;
    }


    /**
     * Gets the e_LANG value for this ZPORTAL_OPROV.
     * 
     * @return e_LANG
     */
    public java.lang.String getE_LANG() {
        return e_LANG;
    }


    /**
     * Sets the e_LANG value for this ZPORTAL_OPROV.
     * 
     * @param e_LANG
     */
    public void setE_LANG(java.lang.String e_LANG) {
        this.e_LANG = e_LANG;
    }


    /**
     * Gets the e_LIFNR value for this ZPORTAL_OPROV.
     * 
     * @return e_LIFNR
     */
    public java.lang.String getE_LIFNR() {
        return e_LIFNR;
    }


    /**
     * Sets the e_LIFNR value for this ZPORTAL_OPROV.
     * 
     * @param e_LIFNR
     */
    public void setE_LIFNR(java.lang.String e_LIFNR) {
        this.e_LIFNR = e_LIFNR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_OPROV)) return false;
        ZPORTAL_OPROV other = (ZPORTAL_OPROV) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.e_LANG==null && other.getE_LANG()==null) || 
             (this.e_LANG!=null &&
              this.e_LANG.equals(other.getE_LANG()))) &&
            ((this.e_LIFNR==null && other.getE_LIFNR()==null) || 
             (this.e_LIFNR!=null &&
              this.e_LIFNR.equals(other.getE_LIFNR())));
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
        if (getE_LANG() != null) {
            _hashCode += getE_LANG().hashCode();
        }
        if (getE_LIFNR() != null) {
            _hashCode += getE_LIFNR().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_OPROV.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">ZPORTAL_OPROV"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("e_LANG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "E_LANG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("e_LIFNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "E_LIFNR"));
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
