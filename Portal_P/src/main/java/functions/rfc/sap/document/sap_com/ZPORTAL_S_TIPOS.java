/**
 * ZPORTAL_S_TIPOS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_TIPOS  implements java.io.Serializable {
    private java.lang.String TIPO;

    private java.lang.String TEXTO;

    public ZPORTAL_S_TIPOS() {
    }

    public ZPORTAL_S_TIPOS(
           java.lang.String TIPO,
           java.lang.String TEXTO) {
           this.TIPO = TIPO;
           this.TEXTO = TEXTO;
    }


    /**
     * Gets the TIPO value for this ZPORTAL_S_TIPOS.
     * 
     * @return TIPO
     */
    public java.lang.String getTIPO() {
        return TIPO;
    }


    /**
     * Sets the TIPO value for this ZPORTAL_S_TIPOS.
     * 
     * @param TIPO
     */
    public void setTIPO(java.lang.String TIPO) {
        this.TIPO = TIPO;
    }


    /**
     * Gets the TEXTO value for this ZPORTAL_S_TIPOS.
     * 
     * @return TEXTO
     */
    public java.lang.String getTEXTO() {
        return TEXTO;
    }


    /**
     * Sets the TEXTO value for this ZPORTAL_S_TIPOS.
     * 
     * @param TEXTO
     */
    public void setTEXTO(java.lang.String TEXTO) {
        this.TEXTO = TEXTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_TIPOS)) return false;
        ZPORTAL_S_TIPOS other = (ZPORTAL_S_TIPOS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.TIPO==null && other.getTIPO()==null) || 
             (this.TIPO!=null &&
              this.TIPO.equals(other.getTIPO()))) &&
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
        if (getTIPO() != null) {
            _hashCode += getTIPO().hashCode();
        }
        if (getTEXTO() != null) {
            _hashCode += getTEXTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_TIPOS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_TIPOS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TIPO"));
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
