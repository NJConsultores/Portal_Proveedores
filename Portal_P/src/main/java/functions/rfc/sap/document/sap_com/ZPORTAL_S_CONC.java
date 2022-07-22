/**
 * ZPORTAL_S_CONC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_CONC  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte IDCON;

    private java.lang.String TEXT;

    private java.lang.String XREB;

    public ZPORTAL_S_CONC() {
    }

    public ZPORTAL_S_CONC(
           org.apache.axis.types.UnsignedByte IDCON,
           java.lang.String TEXT,
           java.lang.String XREB) {
           this.IDCON = IDCON;
           this.TEXT = TEXT;
           this.XREB = XREB;
    }


    /**
     * Gets the IDCON value for this ZPORTAL_S_CONC.
     * 
     * @return IDCON
     */
    public org.apache.axis.types.UnsignedByte getIDCON() {
        return IDCON;
    }


    /**
     * Sets the IDCON value for this ZPORTAL_S_CONC.
     * 
     * @param IDCON
     */
    public void setIDCON(org.apache.axis.types.UnsignedByte IDCON) {
        this.IDCON = IDCON;
    }


    /**
     * Gets the TEXT value for this ZPORTAL_S_CONC.
     * 
     * @return TEXT
     */
    public java.lang.String getTEXT() {
        return TEXT;
    }


    /**
     * Sets the TEXT value for this ZPORTAL_S_CONC.
     * 
     * @param TEXT
     */
    public void setTEXT(java.lang.String TEXT) {
        this.TEXT = TEXT;
    }


    /**
     * Gets the XREB value for this ZPORTAL_S_CONC.
     * 
     * @return XREB
     */
    public java.lang.String getXREB() {
        return XREB;
    }


    /**
     * Sets the XREB value for this ZPORTAL_S_CONC.
     * 
     * @param XREB
     */
    public void setXREB(java.lang.String XREB) {
        this.XREB = XREB;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_CONC)) return false;
        ZPORTAL_S_CONC other = (ZPORTAL_S_CONC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.IDCON==null && other.getIDCON()==null) || 
             (this.IDCON!=null &&
              this.IDCON.equals(other.getIDCON()))) &&
            ((this.TEXT==null && other.getTEXT()==null) || 
             (this.TEXT!=null &&
              this.TEXT.equals(other.getTEXT()))) &&
            ((this.XREB==null && other.getXREB()==null) || 
             (this.XREB!=null &&
              this.XREB.equals(other.getXREB())));
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
        if (getIDCON() != null) {
            _hashCode += getIDCON().hashCode();
        }
        if (getTEXT() != null) {
            _hashCode += getTEXT().hashCode();
        }
        if (getXREB() != null) {
            _hashCode += getXREB().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_CONC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_CONC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDCON");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IDCON"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TEXT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TEXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XREB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "XREB"));
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
