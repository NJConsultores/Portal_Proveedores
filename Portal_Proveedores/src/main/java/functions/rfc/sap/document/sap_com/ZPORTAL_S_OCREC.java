/**
 * ZPORTAL_S_OCREC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_OCREC  implements java.io.Serializable {
    private java.lang.String EBELN;

    private java.lang.String EBELP;

    private java.lang.String MBLNR;

    private java.lang.String MJAHR;

    private java.lang.String MBLPO;

    private java.lang.String XBLNR;

    private java.math.BigDecimal WRBTR;

    private java.math.BigDecimal MENGE;

    private java.lang.String KPOSN;

    public ZPORTAL_S_OCREC() {
    }

    public ZPORTAL_S_OCREC(
           java.lang.String EBELN,
           java.lang.String EBELP,
           java.lang.String MBLNR,
           java.lang.String MJAHR,
           java.lang.String MBLPO,
           java.lang.String XBLNR,
           java.math.BigDecimal WRBTR,
           java.math.BigDecimal MENGE,
           java.lang.String KPOSN) {
           this.EBELN = EBELN;
           this.EBELP = EBELP;
           this.MBLNR = MBLNR;
           this.MJAHR = MJAHR;
           this.MBLPO = MBLPO;
           this.XBLNR = XBLNR;
           this.WRBTR = WRBTR;
           this.MENGE = MENGE;
           this.KPOSN = KPOSN;
    }


    /**
     * Gets the EBELN value for this ZPORTAL_S_OCREC.
     * 
     * @return EBELN
     */
    public java.lang.String getEBELN() {
        return EBELN;
    }


    /**
     * Sets the EBELN value for this ZPORTAL_S_OCREC.
     * 
     * @param EBELN
     */
    public void setEBELN(java.lang.String EBELN) {
        this.EBELN = EBELN;
    }


    /**
     * Gets the EBELP value for this ZPORTAL_S_OCREC.
     * 
     * @return EBELP
     */
    public java.lang.String getEBELP() {
        return EBELP;
    }


    /**
     * Sets the EBELP value for this ZPORTAL_S_OCREC.
     * 
     * @param EBELP
     */
    public void setEBELP(java.lang.String EBELP) {
        this.EBELP = EBELP;
    }


    /**
     * Gets the MBLNR value for this ZPORTAL_S_OCREC.
     * 
     * @return MBLNR
     */
    public java.lang.String getMBLNR() {
        return MBLNR;
    }


    /**
     * Sets the MBLNR value for this ZPORTAL_S_OCREC.
     * 
     * @param MBLNR
     */
    public void setMBLNR(java.lang.String MBLNR) {
        this.MBLNR = MBLNR;
    }


    /**
     * Gets the MJAHR value for this ZPORTAL_S_OCREC.
     * 
     * @return MJAHR
     */
    public java.lang.String getMJAHR() {
        return MJAHR;
    }


    /**
     * Sets the MJAHR value for this ZPORTAL_S_OCREC.
     * 
     * @param MJAHR
     */
    public void setMJAHR(java.lang.String MJAHR) {
        this.MJAHR = MJAHR;
    }


    /**
     * Gets the MBLPO value for this ZPORTAL_S_OCREC.
     * 
     * @return MBLPO
     */
    public java.lang.String getMBLPO() {
        return MBLPO;
    }


    /**
     * Sets the MBLPO value for this ZPORTAL_S_OCREC.
     * 
     * @param MBLPO
     */
    public void setMBLPO(java.lang.String MBLPO) {
        this.MBLPO = MBLPO;
    }


    /**
     * Gets the XBLNR value for this ZPORTAL_S_OCREC.
     * 
     * @return XBLNR
     */
    public java.lang.String getXBLNR() {
        return XBLNR;
    }


    /**
     * Sets the XBLNR value for this ZPORTAL_S_OCREC.
     * 
     * @param XBLNR
     */
    public void setXBLNR(java.lang.String XBLNR) {
        this.XBLNR = XBLNR;
    }


    /**
     * Gets the WRBTR value for this ZPORTAL_S_OCREC.
     * 
     * @return WRBTR
     */
    public java.math.BigDecimal getWRBTR() {
        return WRBTR;
    }


    /**
     * Sets the WRBTR value for this ZPORTAL_S_OCREC.
     * 
     * @param WRBTR
     */
    public void setWRBTR(java.math.BigDecimal WRBTR) {
        this.WRBTR = WRBTR;
    }


    /**
     * Gets the MENGE value for this ZPORTAL_S_OCREC.
     * 
     * @return MENGE
     */
    public java.math.BigDecimal getMENGE() {
        return MENGE;
    }


    /**
     * Sets the MENGE value for this ZPORTAL_S_OCREC.
     * 
     * @param MENGE
     */
    public void setMENGE(java.math.BigDecimal MENGE) {
        this.MENGE = MENGE;
    }


    /**
     * Gets the KPOSN value for this ZPORTAL_S_OCREC.
     * 
     * @return KPOSN
     */
    public java.lang.String getKPOSN() {
        return KPOSN;
    }


    /**
     * Sets the KPOSN value for this ZPORTAL_S_OCREC.
     * 
     * @param KPOSN
     */
    public void setKPOSN(java.lang.String KPOSN) {
        this.KPOSN = KPOSN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_OCREC)) return false;
        ZPORTAL_S_OCREC other = (ZPORTAL_S_OCREC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.EBELN==null && other.getEBELN()==null) || 
             (this.EBELN!=null &&
              this.EBELN.equals(other.getEBELN()))) &&
            ((this.EBELP==null && other.getEBELP()==null) || 
             (this.EBELP!=null &&
              this.EBELP.equals(other.getEBELP()))) &&
            ((this.MBLNR==null && other.getMBLNR()==null) || 
             (this.MBLNR!=null &&
              this.MBLNR.equals(other.getMBLNR()))) &&
            ((this.MJAHR==null && other.getMJAHR()==null) || 
             (this.MJAHR!=null &&
              this.MJAHR.equals(other.getMJAHR()))) &&
            ((this.MBLPO==null && other.getMBLPO()==null) || 
             (this.MBLPO!=null &&
              this.MBLPO.equals(other.getMBLPO()))) &&
            ((this.XBLNR==null && other.getXBLNR()==null) || 
             (this.XBLNR!=null &&
              this.XBLNR.equals(other.getXBLNR()))) &&
            ((this.WRBTR==null && other.getWRBTR()==null) || 
             (this.WRBTR!=null &&
              this.WRBTR.equals(other.getWRBTR()))) &&
            ((this.MENGE==null && other.getMENGE()==null) || 
             (this.MENGE!=null &&
              this.MENGE.equals(other.getMENGE()))) &&
            ((this.KPOSN==null && other.getKPOSN()==null) || 
             (this.KPOSN!=null &&
              this.KPOSN.equals(other.getKPOSN())));
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
        if (getEBELN() != null) {
            _hashCode += getEBELN().hashCode();
        }
        if (getEBELP() != null) {
            _hashCode += getEBELP().hashCode();
        }
        if (getMBLNR() != null) {
            _hashCode += getMBLNR().hashCode();
        }
        if (getMJAHR() != null) {
            _hashCode += getMJAHR().hashCode();
        }
        if (getMBLPO() != null) {
            _hashCode += getMBLPO().hashCode();
        }
        if (getXBLNR() != null) {
            _hashCode += getXBLNR().hashCode();
        }
        if (getWRBTR() != null) {
            _hashCode += getWRBTR().hashCode();
        }
        if (getMENGE() != null) {
            _hashCode += getMENGE().hashCode();
        }
        if (getKPOSN() != null) {
            _hashCode += getKPOSN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_OCREC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_OCREC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EBELN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EBELN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EBELP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EBELP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MBLNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MBLNR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MJAHR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MJAHR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MBLPO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MBLPO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XBLNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "XBLNR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WRBTR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WRBTR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MENGE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MENGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KPOSN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KPOSN"));
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
