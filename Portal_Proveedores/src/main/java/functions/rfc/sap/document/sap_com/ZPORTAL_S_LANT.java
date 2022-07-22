/**
 * ZPORTAL_S_LANT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_LANT  implements java.io.Serializable {
    private java.lang.String XBLNR;

    private java.lang.String BUKRS;

    private java.lang.String BELNR;

    private java.lang.String GJAHR;

    private java.lang.String XML;

    private java.lang.String PDF;

    public ZPORTAL_S_LANT() {
    }

    public ZPORTAL_S_LANT(
           java.lang.String XBLNR,
           java.lang.String BUKRS,
           java.lang.String BELNR,
           java.lang.String GJAHR,
           java.lang.String XML,
           java.lang.String PDF) {
           this.XBLNR = XBLNR;
           this.BUKRS = BUKRS;
           this.BELNR = BELNR;
           this.GJAHR = GJAHR;
           this.XML = XML;
           this.PDF = PDF;
    }


    /**
     * Gets the XBLNR value for this ZPORTAL_S_LANT.
     * 
     * @return XBLNR
     */
    public java.lang.String getXBLNR() {
        return XBLNR;
    }


    /**
     * Sets the XBLNR value for this ZPORTAL_S_LANT.
     * 
     * @param XBLNR
     */
    public void setXBLNR(java.lang.String XBLNR) {
        this.XBLNR = XBLNR;
    }


    /**
     * Gets the BUKRS value for this ZPORTAL_S_LANT.
     * 
     * @return BUKRS
     */
    public java.lang.String getBUKRS() {
        return BUKRS;
    }


    /**
     * Sets the BUKRS value for this ZPORTAL_S_LANT.
     * 
     * @param BUKRS
     */
    public void setBUKRS(java.lang.String BUKRS) {
        this.BUKRS = BUKRS;
    }


    /**
     * Gets the BELNR value for this ZPORTAL_S_LANT.
     * 
     * @return BELNR
     */
    public java.lang.String getBELNR() {
        return BELNR;
    }


    /**
     * Sets the BELNR value for this ZPORTAL_S_LANT.
     * 
     * @param BELNR
     */
    public void setBELNR(java.lang.String BELNR) {
        this.BELNR = BELNR;
    }


    /**
     * Gets the GJAHR value for this ZPORTAL_S_LANT.
     * 
     * @return GJAHR
     */
    public java.lang.String getGJAHR() {
        return GJAHR;
    }


    /**
     * Sets the GJAHR value for this ZPORTAL_S_LANT.
     * 
     * @param GJAHR
     */
    public void setGJAHR(java.lang.String GJAHR) {
        this.GJAHR = GJAHR;
    }


    /**
     * Gets the XML value for this ZPORTAL_S_LANT.
     * 
     * @return XML
     */
    public java.lang.String getXML() {
        return XML;
    }


    /**
     * Sets the XML value for this ZPORTAL_S_LANT.
     * 
     * @param XML
     */
    public void setXML(java.lang.String XML) {
        this.XML = XML;
    }


    /**
     * Gets the PDF value for this ZPORTAL_S_LANT.
     * 
     * @return PDF
     */
    public java.lang.String getPDF() {
        return PDF;
    }


    /**
     * Sets the PDF value for this ZPORTAL_S_LANT.
     * 
     * @param PDF
     */
    public void setPDF(java.lang.String PDF) {
        this.PDF = PDF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_LANT)) return false;
        ZPORTAL_S_LANT other = (ZPORTAL_S_LANT) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.XBLNR==null && other.getXBLNR()==null) || 
             (this.XBLNR!=null &&
              this.XBLNR.equals(other.getXBLNR()))) &&
            ((this.BUKRS==null && other.getBUKRS()==null) || 
             (this.BUKRS!=null &&
              this.BUKRS.equals(other.getBUKRS()))) &&
            ((this.BELNR==null && other.getBELNR()==null) || 
             (this.BELNR!=null &&
              this.BELNR.equals(other.getBELNR()))) &&
            ((this.GJAHR==null && other.getGJAHR()==null) || 
             (this.GJAHR!=null &&
              this.GJAHR.equals(other.getGJAHR()))) &&
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
        if (getXBLNR() != null) {
            _hashCode += getXBLNR().hashCode();
        }
        if (getBUKRS() != null) {
            _hashCode += getBUKRS().hashCode();
        }
        if (getBELNR() != null) {
            _hashCode += getBELNR().hashCode();
        }
        if (getGJAHR() != null) {
            _hashCode += getGJAHR().hashCode();
        }
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
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_LANT.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_LANT"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XBLNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "XBLNR"));
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
        elemField.setFieldName("BELNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BELNR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GJAHR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GJAHR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
