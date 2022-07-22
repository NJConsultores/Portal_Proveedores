/**
 * ZPORTAL_S_STREC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_STREC  implements java.io.Serializable {
    private java.lang.String XBLNR;

    private java.lang.String FEREC;

    private java.lang.String ESTAT;

    private java.lang.String MESGE;

    public ZPORTAL_S_STREC() {
    }

    public ZPORTAL_S_STREC(
           java.lang.String XBLNR,
           java.lang.String FEREC,
           java.lang.String ESTAT,
           java.lang.String MESGE) {
           this.XBLNR = XBLNR;
           this.FEREC = FEREC;
           this.ESTAT = ESTAT;
           this.MESGE = MESGE;
    }


    /**
     * Gets the XBLNR value for this ZPORTAL_S_STREC.
     * 
     * @return XBLNR
     */
    public java.lang.String getXBLNR() {
        return XBLNR;
    }


    /**
     * Sets the XBLNR value for this ZPORTAL_S_STREC.
     * 
     * @param XBLNR
     */
    public void setXBLNR(java.lang.String XBLNR) {
        this.XBLNR = XBLNR;
    }


    /**
     * Gets the FEREC value for this ZPORTAL_S_STREC.
     * 
     * @return FEREC
     */
    public java.lang.String getFEREC() {
        return FEREC;
    }


    /**
     * Sets the FEREC value for this ZPORTAL_S_STREC.
     * 
     * @param FEREC
     */
    public void setFEREC(java.lang.String FEREC) {
        this.FEREC = FEREC;
    }


    /**
     * Gets the ESTAT value for this ZPORTAL_S_STREC.
     * 
     * @return ESTAT
     */
    public java.lang.String getESTAT() {
        return ESTAT;
    }


    /**
     * Sets the ESTAT value for this ZPORTAL_S_STREC.
     * 
     * @param ESTAT
     */
    public void setESTAT(java.lang.String ESTAT) {
        this.ESTAT = ESTAT;
    }


    /**
     * Gets the MESGE value for this ZPORTAL_S_STREC.
     * 
     * @return MESGE
     */
    public java.lang.String getMESGE() {
        return MESGE;
    }


    /**
     * Sets the MESGE value for this ZPORTAL_S_STREC.
     * 
     * @param MESGE
     */
    public void setMESGE(java.lang.String MESGE) {
        this.MESGE = MESGE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_STREC)) return false;
        ZPORTAL_S_STREC other = (ZPORTAL_S_STREC) obj;
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
            ((this.FEREC==null && other.getFEREC()==null) || 
             (this.FEREC!=null &&
              this.FEREC.equals(other.getFEREC()))) &&
            ((this.ESTAT==null && other.getESTAT()==null) || 
             (this.ESTAT!=null &&
              this.ESTAT.equals(other.getESTAT()))) &&
            ((this.MESGE==null && other.getMESGE()==null) || 
             (this.MESGE!=null &&
              this.MESGE.equals(other.getMESGE())));
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
        if (getFEREC() != null) {
            _hashCode += getFEREC().hashCode();
        }
        if (getESTAT() != null) {
            _hashCode += getESTAT().hashCode();
        }
        if (getMESGE() != null) {
            _hashCode += getMESGE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_STREC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_STREC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XBLNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "XBLNR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FEREC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FEREC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ESTAT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ESTAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MESGE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MESGE"));
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
