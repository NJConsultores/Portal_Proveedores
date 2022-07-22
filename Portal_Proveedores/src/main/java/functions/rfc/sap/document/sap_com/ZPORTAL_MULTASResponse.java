/**
 * ZPORTAL_MULTASResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_MULTASResponse  implements java.io.Serializable {
    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP;

    private java.lang.String s_MSG;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_REB_ANUAL_CAB;

    private int s_STAT;

    public ZPORTAL_MULTASResponse() {
    }

    public ZPORTAL_MULTASResponse(
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP,
           java.lang.String s_MSG,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_REB_ANUAL_CAB,
           int s_STAT) {
           this.s_BONIFICACIONES = s_BONIFICACIONES;
           this.s_BONIF_ESP = s_BONIF_ESP;
           this.s_MSG = s_MSG;
           this.s_MULTAS = s_MULTAS;
           this.s_REB_ANUAL = s_REB_ANUAL;
           this.s_REB_ANUAL_CAB = s_REB_ANUAL_CAB;
           this.s_STAT = s_STAT;
    }


    /**
     * Gets the s_BONIFICACIONES value for this ZPORTAL_MULTASResponse.
     * 
     * @return s_BONIFICACIONES
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] getS_BONIFICACIONES() {
        return s_BONIFICACIONES;
    }


    /**
     * Sets the s_BONIFICACIONES value for this ZPORTAL_MULTASResponse.
     * 
     * @param s_BONIFICACIONES
     */
    public void setS_BONIFICACIONES(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES) {
        this.s_BONIFICACIONES = s_BONIFICACIONES;
    }


    /**
     * Gets the s_BONIF_ESP value for this ZPORTAL_MULTASResponse.
     * 
     * @return s_BONIF_ESP
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] getS_BONIF_ESP() {
        return s_BONIF_ESP;
    }


    /**
     * Sets the s_BONIF_ESP value for this ZPORTAL_MULTASResponse.
     * 
     * @param s_BONIF_ESP
     */
    public void setS_BONIF_ESP(functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP) {
        this.s_BONIF_ESP = s_BONIF_ESP;
    }


    /**
     * Gets the s_MSG value for this ZPORTAL_MULTASResponse.
     * 
     * @return s_MSG
     */
    public java.lang.String getS_MSG() {
        return s_MSG;
    }


    /**
     * Sets the s_MSG value for this ZPORTAL_MULTASResponse.
     * 
     * @param s_MSG
     */
    public void setS_MSG(java.lang.String s_MSG) {
        this.s_MSG = s_MSG;
    }


    /**
     * Gets the s_MULTAS value for this ZPORTAL_MULTASResponse.
     * 
     * @return s_MULTAS
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] getS_MULTAS() {
        return s_MULTAS;
    }


    /**
     * Sets the s_MULTAS value for this ZPORTAL_MULTASResponse.
     * 
     * @param s_MULTAS
     */
    public void setS_MULTAS(functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS) {
        this.s_MULTAS = s_MULTAS;
    }


    /**
     * Gets the s_REB_ANUAL value for this ZPORTAL_MULTASResponse.
     * 
     * @return s_REB_ANUAL
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] getS_REB_ANUAL() {
        return s_REB_ANUAL;
    }


    /**
     * Sets the s_REB_ANUAL value for this ZPORTAL_MULTASResponse.
     * 
     * @param s_REB_ANUAL
     */
    public void setS_REB_ANUAL(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL) {
        this.s_REB_ANUAL = s_REB_ANUAL;
    }


    /**
     * Gets the s_REB_ANUAL_CAB value for this ZPORTAL_MULTASResponse.
     * 
     * @return s_REB_ANUAL_CAB
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] getS_REB_ANUAL_CAB() {
        return s_REB_ANUAL_CAB;
    }


    /**
     * Sets the s_REB_ANUAL_CAB value for this ZPORTAL_MULTASResponse.
     * 
     * @param s_REB_ANUAL_CAB
     */
    public void setS_REB_ANUAL_CAB(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_REB_ANUAL_CAB) {
        this.s_REB_ANUAL_CAB = s_REB_ANUAL_CAB;
    }


    /**
     * Gets the s_STAT value for this ZPORTAL_MULTASResponse.
     * 
     * @return s_STAT
     */
    public int getS_STAT() {
        return s_STAT;
    }


    /**
     * Sets the s_STAT value for this ZPORTAL_MULTASResponse.
     * 
     * @param s_STAT
     */
    public void setS_STAT(int s_STAT) {
        this.s_STAT = s_STAT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_MULTASResponse)) return false;
        ZPORTAL_MULTASResponse other = (ZPORTAL_MULTASResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.s_BONIFICACIONES==null && other.getS_BONIFICACIONES()==null) || 
             (this.s_BONIFICACIONES!=null &&
              java.util.Arrays.equals(this.s_BONIFICACIONES, other.getS_BONIFICACIONES()))) &&
            ((this.s_BONIF_ESP==null && other.getS_BONIF_ESP()==null) || 
             (this.s_BONIF_ESP!=null &&
              java.util.Arrays.equals(this.s_BONIF_ESP, other.getS_BONIF_ESP()))) &&
            ((this.s_MSG==null && other.getS_MSG()==null) || 
             (this.s_MSG!=null &&
              this.s_MSG.equals(other.getS_MSG()))) &&
            ((this.s_MULTAS==null && other.getS_MULTAS()==null) || 
             (this.s_MULTAS!=null &&
              java.util.Arrays.equals(this.s_MULTAS, other.getS_MULTAS()))) &&
            ((this.s_REB_ANUAL==null && other.getS_REB_ANUAL()==null) || 
             (this.s_REB_ANUAL!=null &&
              java.util.Arrays.equals(this.s_REB_ANUAL, other.getS_REB_ANUAL()))) &&
            ((this.s_REB_ANUAL_CAB==null && other.getS_REB_ANUAL_CAB()==null) || 
             (this.s_REB_ANUAL_CAB!=null &&
              java.util.Arrays.equals(this.s_REB_ANUAL_CAB, other.getS_REB_ANUAL_CAB()))) &&
            this.s_STAT == other.getS_STAT();
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
        if (getS_BONIFICACIONES() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_BONIFICACIONES());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_BONIFICACIONES(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_BONIF_ESP() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_BONIF_ESP());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_BONIF_ESP(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_MSG() != null) {
            _hashCode += getS_MSG().hashCode();
        }
        if (getS_MULTAS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_MULTAS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_MULTAS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_REB_ANUAL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_REB_ANUAL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_REB_ANUAL(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getS_REB_ANUAL_CAB() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getS_REB_ANUAL_CAB());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getS_REB_ANUAL_CAB(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getS_STAT();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_MULTASResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">ZPORTAL_MULTASResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_BONIFICACIONES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_BONIFICACIONES"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_REBATE"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_BONIF_ESP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_BONIF_ESP"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_BONESP"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("s_MULTAS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_MULTAS"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_MULTAS"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_REB_ANUAL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_REB_ANUAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_REBANUAL"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_REB_ANUAL_CAB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_REB_ANUAL_CAB"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_REBANUAL_CAB"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_STAT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "S_STAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
