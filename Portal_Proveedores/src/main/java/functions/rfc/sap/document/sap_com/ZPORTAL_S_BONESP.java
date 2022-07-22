/**
 * ZPORTAL_S_BONESP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_BONESP  implements java.io.Serializable {
    private java.lang.String EMLIF;

    private java.lang.String NAME1;

    private java.math.BigDecimal DMONTO;

    private java.lang.String COMENTARIO;

    public ZPORTAL_S_BONESP() {
    }

    public ZPORTAL_S_BONESP(
           java.lang.String EMLIF,
           java.lang.String NAME1,
           java.math.BigDecimal DMONTO,
           java.lang.String COMENTARIO) {
           this.EMLIF = EMLIF;
           this.NAME1 = NAME1;
           this.DMONTO = DMONTO;
           this.COMENTARIO = COMENTARIO;
    }


    /**
     * Gets the EMLIF value for this ZPORTAL_S_BONESP.
     * 
     * @return EMLIF
     */
    public java.lang.String getEMLIF() {
        return EMLIF;
    }


    /**
     * Sets the EMLIF value for this ZPORTAL_S_BONESP.
     * 
     * @param EMLIF
     */
    public void setEMLIF(java.lang.String EMLIF) {
        this.EMLIF = EMLIF;
    }


    /**
     * Gets the NAME1 value for this ZPORTAL_S_BONESP.
     * 
     * @return NAME1
     */
    public java.lang.String getNAME1() {
        return NAME1;
    }


    /**
     * Sets the NAME1 value for this ZPORTAL_S_BONESP.
     * 
     * @param NAME1
     */
    public void setNAME1(java.lang.String NAME1) {
        this.NAME1 = NAME1;
    }


    /**
     * Gets the DMONTO value for this ZPORTAL_S_BONESP.
     * 
     * @return DMONTO
     */
    public java.math.BigDecimal getDMONTO() {
        return DMONTO;
    }


    /**
     * Sets the DMONTO value for this ZPORTAL_S_BONESP.
     * 
     * @param DMONTO
     */
    public void setDMONTO(java.math.BigDecimal DMONTO) {
        this.DMONTO = DMONTO;
    }


    /**
     * Gets the COMENTARIO value for this ZPORTAL_S_BONESP.
     * 
     * @return COMENTARIO
     */
    public java.lang.String getCOMENTARIO() {
        return COMENTARIO;
    }


    /**
     * Sets the COMENTARIO value for this ZPORTAL_S_BONESP.
     * 
     * @param COMENTARIO
     */
    public void setCOMENTARIO(java.lang.String COMENTARIO) {
        this.COMENTARIO = COMENTARIO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_BONESP)) return false;
        ZPORTAL_S_BONESP other = (ZPORTAL_S_BONESP) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.EMLIF==null && other.getEMLIF()==null) || 
             (this.EMLIF!=null &&
              this.EMLIF.equals(other.getEMLIF()))) &&
            ((this.NAME1==null && other.getNAME1()==null) || 
             (this.NAME1!=null &&
              this.NAME1.equals(other.getNAME1()))) &&
            ((this.DMONTO==null && other.getDMONTO()==null) || 
             (this.DMONTO!=null &&
              this.DMONTO.equals(other.getDMONTO()))) &&
            ((this.COMENTARIO==null && other.getCOMENTARIO()==null) || 
             (this.COMENTARIO!=null &&
              this.COMENTARIO.equals(other.getCOMENTARIO())));
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
        if (getEMLIF() != null) {
            _hashCode += getEMLIF().hashCode();
        }
        if (getNAME1() != null) {
            _hashCode += getNAME1().hashCode();
        }
        if (getDMONTO() != null) {
            _hashCode += getDMONTO().hashCode();
        }
        if (getCOMENTARIO() != null) {
            _hashCode += getCOMENTARIO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_BONESP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_BONESP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EMLIF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EMLIF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NAME1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NAME1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DMONTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DMONTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMENTARIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMENTARIO"));
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
