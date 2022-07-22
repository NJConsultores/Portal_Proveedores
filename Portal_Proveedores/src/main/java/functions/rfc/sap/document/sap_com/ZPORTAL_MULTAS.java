/**
 * ZPORTAL_MULTAS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_MULTAS  implements java.io.Serializable {
    private java.lang.String e_BUKRS;

    private java.lang.String e_LANG;

    private java.lang.String e_LIFNR;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_REB_ANUAL_CAB;

    public ZPORTAL_MULTAS() {
    }

    public ZPORTAL_MULTAS(
           java.lang.String e_BUKRS,
           java.lang.String e_LANG,
           java.lang.String e_LIFNR,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_REB_ANUAL_CAB) {
           this.e_BUKRS = e_BUKRS;
           this.e_LANG = e_LANG;
           this.e_LIFNR = e_LIFNR;
           this.s_BONIFICACIONES = s_BONIFICACIONES;
           this.s_BONIF_ESP = s_BONIF_ESP;
           this.s_MULTAS = s_MULTAS;
           this.s_REB_ANUAL = s_REB_ANUAL;
           this.s_REB_ANUAL_CAB = s_REB_ANUAL_CAB;
    }


    /**
     * Gets the e_BUKRS value for this ZPORTAL_MULTAS.
     * 
     * @return e_BUKRS
     */
    public java.lang.String getE_BUKRS() {
        return e_BUKRS;
    }


    /**
     * Sets the e_BUKRS value for this ZPORTAL_MULTAS.
     * 
     * @param e_BUKRS
     */
    public void setE_BUKRS(java.lang.String e_BUKRS) {
        this.e_BUKRS = e_BUKRS;
    }


    /**
     * Gets the e_LANG value for this ZPORTAL_MULTAS.
     * 
     * @return e_LANG
     */
    public java.lang.String getE_LANG() {
        return e_LANG;
    }


    /**
     * Sets the e_LANG value for this ZPORTAL_MULTAS.
     * 
     * @param e_LANG
     */
    public void setE_LANG(java.lang.String e_LANG) {
        this.e_LANG = e_LANG;
    }


    /**
     * Gets the e_LIFNR value for this ZPORTAL_MULTAS.
     * 
     * @return e_LIFNR
     */
    public java.lang.String getE_LIFNR() {
        return e_LIFNR;
    }


    /**
     * Sets the e_LIFNR value for this ZPORTAL_MULTAS.
     * 
     * @param e_LIFNR
     */
    public void setE_LIFNR(java.lang.String e_LIFNR) {
        this.e_LIFNR = e_LIFNR;
    }


    /**
     * Gets the s_BONIFICACIONES value for this ZPORTAL_MULTAS.
     * 
     * @return s_BONIFICACIONES
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] getS_BONIFICACIONES() {
        return s_BONIFICACIONES;
    }


    /**
     * Sets the s_BONIFICACIONES value for this ZPORTAL_MULTAS.
     * 
     * @param s_BONIFICACIONES
     */
    public void setS_BONIFICACIONES(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE[] s_BONIFICACIONES) {
        this.s_BONIFICACIONES = s_BONIFICACIONES;
    }


    /**
     * Gets the s_BONIF_ESP value for this ZPORTAL_MULTAS.
     * 
     * @return s_BONIF_ESP
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] getS_BONIF_ESP() {
        return s_BONIF_ESP;
    }


    /**
     * Sets the s_BONIF_ESP value for this ZPORTAL_MULTAS.
     * 
     * @param s_BONIF_ESP
     */
    public void setS_BONIF_ESP(functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP[] s_BONIF_ESP) {
        this.s_BONIF_ESP = s_BONIF_ESP;
    }


    /**
     * Gets the s_MULTAS value for this ZPORTAL_MULTAS.
     * 
     * @return s_MULTAS
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] getS_MULTAS() {
        return s_MULTAS;
    }


    /**
     * Sets the s_MULTAS value for this ZPORTAL_MULTAS.
     * 
     * @param s_MULTAS
     */
    public void setS_MULTAS(functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS[] s_MULTAS) {
        this.s_MULTAS = s_MULTAS;
    }


    /**
     * Gets the s_REB_ANUAL value for this ZPORTAL_MULTAS.
     * 
     * @return s_REB_ANUAL
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] getS_REB_ANUAL() {
        return s_REB_ANUAL;
    }


    /**
     * Sets the s_REB_ANUAL value for this ZPORTAL_MULTAS.
     * 
     * @param s_REB_ANUAL
     */
    public void setS_REB_ANUAL(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL[] s_REB_ANUAL) {
        this.s_REB_ANUAL = s_REB_ANUAL;
    }


    /**
     * Gets the s_REB_ANUAL_CAB value for this ZPORTAL_MULTAS.
     * 
     * @return s_REB_ANUAL_CAB
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] getS_REB_ANUAL_CAB() {
        return s_REB_ANUAL_CAB;
    }


    /**
     * Sets the s_REB_ANUAL_CAB value for this ZPORTAL_MULTAS.
     * 
     * @param s_REB_ANUAL_CAB
     */
    public void setS_REB_ANUAL_CAB(functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB[] s_REB_ANUAL_CAB) {
        this.s_REB_ANUAL_CAB = s_REB_ANUAL_CAB;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_MULTAS)) return false;
        ZPORTAL_MULTAS other = (ZPORTAL_MULTAS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.e_BUKRS==null && other.getE_BUKRS()==null) || 
             (this.e_BUKRS!=null &&
              this.e_BUKRS.equals(other.getE_BUKRS()))) &&
            ((this.e_LANG==null && other.getE_LANG()==null) || 
             (this.e_LANG!=null &&
              this.e_LANG.equals(other.getE_LANG()))) &&
            ((this.e_LIFNR==null && other.getE_LIFNR()==null) || 
             (this.e_LIFNR!=null &&
              this.e_LIFNR.equals(other.getE_LIFNR()))) &&
            ((this.s_BONIFICACIONES==null && other.getS_BONIFICACIONES()==null) || 
             (this.s_BONIFICACIONES!=null &&
              java.util.Arrays.equals(this.s_BONIFICACIONES, other.getS_BONIFICACIONES()))) &&
            ((this.s_BONIF_ESP==null && other.getS_BONIF_ESP()==null) || 
             (this.s_BONIF_ESP!=null &&
              java.util.Arrays.equals(this.s_BONIF_ESP, other.getS_BONIF_ESP()))) &&
            ((this.s_MULTAS==null && other.getS_MULTAS()==null) || 
             (this.s_MULTAS!=null &&
              java.util.Arrays.equals(this.s_MULTAS, other.getS_MULTAS()))) &&
            ((this.s_REB_ANUAL==null && other.getS_REB_ANUAL()==null) || 
             (this.s_REB_ANUAL!=null &&
              java.util.Arrays.equals(this.s_REB_ANUAL, other.getS_REB_ANUAL()))) &&
            ((this.s_REB_ANUAL_CAB==null && other.getS_REB_ANUAL_CAB()==null) || 
             (this.s_REB_ANUAL_CAB!=null &&
              java.util.Arrays.equals(this.s_REB_ANUAL_CAB, other.getS_REB_ANUAL_CAB())));
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
        if (getE_BUKRS() != null) {
            _hashCode += getE_BUKRS().hashCode();
        }
        if (getE_LANG() != null) {
            _hashCode += getE_LANG().hashCode();
        }
        if (getE_LIFNR() != null) {
            _hashCode += getE_LIFNR().hashCode();
        }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_MULTAS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">ZPORTAL_MULTAS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("e_BUKRS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "E_BUKRS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
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
