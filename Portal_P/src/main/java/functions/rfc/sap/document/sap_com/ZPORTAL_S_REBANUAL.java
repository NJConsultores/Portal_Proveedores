/**
 * ZPORTAL_S_REBANUAL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_REBANUAL  implements java.io.Serializable {
    private java.lang.String GJAHR;

    private java.lang.String MONAT;

    private java.lang.String EMLIF;

    private java.lang.String NAME1;

    private java.lang.String EBELN;

    private java.lang.String MATNR;

    private java.lang.String MAKTX;

    private java.math.BigDecimal BRTWR;

    public ZPORTAL_S_REBANUAL() {
    }

    public ZPORTAL_S_REBANUAL(
           java.lang.String GJAHR,
           java.lang.String MONAT,
           java.lang.String EMLIF,
           java.lang.String NAME1,
           java.lang.String EBELN,
           java.lang.String MATNR,
           java.lang.String MAKTX,
           java.math.BigDecimal BRTWR) {
           this.GJAHR = GJAHR;
           this.MONAT = MONAT;
           this.EMLIF = EMLIF;
           this.NAME1 = NAME1;
           this.EBELN = EBELN;
           this.MATNR = MATNR;
           this.MAKTX = MAKTX;
           this.BRTWR = BRTWR;
    }


    /**
     * Gets the GJAHR value for this ZPORTAL_S_REBANUAL.
     * 
     * @return GJAHR
     */
    public java.lang.String getGJAHR() {
        return GJAHR;
    }


    /**
     * Sets the GJAHR value for this ZPORTAL_S_REBANUAL.
     * 
     * @param GJAHR
     */
    public void setGJAHR(java.lang.String GJAHR) {
        this.GJAHR = GJAHR;
    }


    /**
     * Gets the MONAT value for this ZPORTAL_S_REBANUAL.
     * 
     * @return MONAT
     */
    public java.lang.String getMONAT() {
        return MONAT;
    }


    /**
     * Sets the MONAT value for this ZPORTAL_S_REBANUAL.
     * 
     * @param MONAT
     */
    public void setMONAT(java.lang.String MONAT) {
        this.MONAT = MONAT;
    }


    /**
     * Gets the EMLIF value for this ZPORTAL_S_REBANUAL.
     * 
     * @return EMLIF
     */
    public java.lang.String getEMLIF() {
        return EMLIF;
    }


    /**
     * Sets the EMLIF value for this ZPORTAL_S_REBANUAL.
     * 
     * @param EMLIF
     */
    public void setEMLIF(java.lang.String EMLIF) {
        this.EMLIF = EMLIF;
    }


    /**
     * Gets the NAME1 value for this ZPORTAL_S_REBANUAL.
     * 
     * @return NAME1
     */
    public java.lang.String getNAME1() {
        return NAME1;
    }


    /**
     * Sets the NAME1 value for this ZPORTAL_S_REBANUAL.
     * 
     * @param NAME1
     */
    public void setNAME1(java.lang.String NAME1) {
        this.NAME1 = NAME1;
    }


    /**
     * Gets the EBELN value for this ZPORTAL_S_REBANUAL.
     * 
     * @return EBELN
     */
    public java.lang.String getEBELN() {
        return EBELN;
    }


    /**
     * Sets the EBELN value for this ZPORTAL_S_REBANUAL.
     * 
     * @param EBELN
     */
    public void setEBELN(java.lang.String EBELN) {
        this.EBELN = EBELN;
    }


    /**
     * Gets the MATNR value for this ZPORTAL_S_REBANUAL.
     * 
     * @return MATNR
     */
    public java.lang.String getMATNR() {
        return MATNR;
    }


    /**
     * Sets the MATNR value for this ZPORTAL_S_REBANUAL.
     * 
     * @param MATNR
     */
    public void setMATNR(java.lang.String MATNR) {
        this.MATNR = MATNR;
    }


    /**
     * Gets the MAKTX value for this ZPORTAL_S_REBANUAL.
     * 
     * @return MAKTX
     */
    public java.lang.String getMAKTX() {
        return MAKTX;
    }


    /**
     * Sets the MAKTX value for this ZPORTAL_S_REBANUAL.
     * 
     * @param MAKTX
     */
    public void setMAKTX(java.lang.String MAKTX) {
        this.MAKTX = MAKTX;
    }


    /**
     * Gets the BRTWR value for this ZPORTAL_S_REBANUAL.
     * 
     * @return BRTWR
     */
    public java.math.BigDecimal getBRTWR() {
        return BRTWR;
    }


    /**
     * Sets the BRTWR value for this ZPORTAL_S_REBANUAL.
     * 
     * @param BRTWR
     */
    public void setBRTWR(java.math.BigDecimal BRTWR) {
        this.BRTWR = BRTWR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_REBANUAL)) return false;
        ZPORTAL_S_REBANUAL other = (ZPORTAL_S_REBANUAL) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.GJAHR==null && other.getGJAHR()==null) || 
             (this.GJAHR!=null &&
              this.GJAHR.equals(other.getGJAHR()))) &&
            ((this.MONAT==null && other.getMONAT()==null) || 
             (this.MONAT!=null &&
              this.MONAT.equals(other.getMONAT()))) &&
            ((this.EMLIF==null && other.getEMLIF()==null) || 
             (this.EMLIF!=null &&
              this.EMLIF.equals(other.getEMLIF()))) &&
            ((this.NAME1==null && other.getNAME1()==null) || 
             (this.NAME1!=null &&
              this.NAME1.equals(other.getNAME1()))) &&
            ((this.EBELN==null && other.getEBELN()==null) || 
             (this.EBELN!=null &&
              this.EBELN.equals(other.getEBELN()))) &&
            ((this.MATNR==null && other.getMATNR()==null) || 
             (this.MATNR!=null &&
              this.MATNR.equals(other.getMATNR()))) &&
            ((this.MAKTX==null && other.getMAKTX()==null) || 
             (this.MAKTX!=null &&
              this.MAKTX.equals(other.getMAKTX()))) &&
            ((this.BRTWR==null && other.getBRTWR()==null) || 
             (this.BRTWR!=null &&
              this.BRTWR.equals(other.getBRTWR())));
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
        if (getGJAHR() != null) {
            _hashCode += getGJAHR().hashCode();
        }
        if (getMONAT() != null) {
            _hashCode += getMONAT().hashCode();
        }
        if (getEMLIF() != null) {
            _hashCode += getEMLIF().hashCode();
        }
        if (getNAME1() != null) {
            _hashCode += getNAME1().hashCode();
        }
        if (getEBELN() != null) {
            _hashCode += getEBELN().hashCode();
        }
        if (getMATNR() != null) {
            _hashCode += getMATNR().hashCode();
        }
        if (getMAKTX() != null) {
            _hashCode += getMAKTX().hashCode();
        }
        if (getBRTWR() != null) {
            _hashCode += getBRTWR().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_REBANUAL.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_REBANUAL"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GJAHR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GJAHR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MONAT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MONAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("EBELN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EBELN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MATNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MATNR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MAKTX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MAKTX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BRTWR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BRTWR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
