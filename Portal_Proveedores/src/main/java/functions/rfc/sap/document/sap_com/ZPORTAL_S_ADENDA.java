/**
 * ZPORTAL_S_ADENDA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_ADENDA  implements java.io.Serializable {
    private java.lang.String XML;

    private java.lang.String PDF;

    public ZPORTAL_S_ADENDA() {
    }

    public ZPORTAL_S_ADENDA(
           java.lang.String XML,
           java.lang.String PDF) {
           this.XML = XML;
           this.PDF = PDF;
    }


    /**
     * Gets the XML value for this ZPORTAL_S_ADENDA.
     * 
     * @return XML
     */
    public java.lang.String getXML() {
        return XML;
    }


    /**
     * Sets the XML value for this ZPORTAL_S_ADENDA.
     * 
     * @param XML
     */
    public void setXML(java.lang.String XML) {
        this.XML = XML;
    }


    /**
     * Gets the PDF value for this ZPORTAL_S_ADENDA.
     * 
     * @return PDF
     */
    public java.lang.String getPDF() {
        return PDF;
    }


    /**
     * Sets the PDF value for this ZPORTAL_S_ADENDA.
     * 
     * @param PDF
     */
    public void setPDF(java.lang.String PDF) {
        this.PDF = PDF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_ADENDA)) return false;
        ZPORTAL_S_ADENDA other = (ZPORTAL_S_ADENDA) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.XML==null && other.getXML()==null) || 
             (this.XML!=null &&
              this.XML.equals(other.getXML()))) &&
            ((this.PDF==null && other.getPDF()==null) || 
             (this.PDF!=null &&
              this.PDF.equals(other.getPDF())));
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
        if (getXML() != null) {
            _hashCode += getXML().hashCode();
        }
        if (getPDF() != null) {
            _hashCode += getPDF().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_ADENDA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_ADENDA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XML");
        elemField.setXmlName(new javax.xml.namespace.QName("", "XML"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PDF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PDF"));
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
