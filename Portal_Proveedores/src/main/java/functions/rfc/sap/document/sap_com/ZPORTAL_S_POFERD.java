/**
 * ZPORTAL_S_POFERD.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_POFERD  implements java.io.Serializable {
    private java.lang.String EBELN;

    private java.lang.String EBELP;

    private java.lang.String MATNR;

    private java.lang.String MAKTX;

    private java.math.BigDecimal KTMNG;

    private java.lang.String MEINS;

    private java.lang.String EINDT;

    public ZPORTAL_S_POFERD() {
    }

    public ZPORTAL_S_POFERD(
           java.lang.String EBELN,
           java.lang.String EBELP,
           java.lang.String MATNR,
           java.lang.String MAKTX,
           java.math.BigDecimal KTMNG,
           java.lang.String MEINS,
           java.lang.String EINDT) {
           this.EBELN = EBELN;
           this.EBELP = EBELP;
           this.MATNR = MATNR;
           this.MAKTX = MAKTX;
           this.KTMNG = KTMNG;
           this.MEINS = MEINS;
           this.EINDT = EINDT;
    }


    /**
     * Gets the EBELN value for this ZPORTAL_S_POFERD.
     * 
     * @return EBELN
     */
    public java.lang.String getEBELN() {
        return EBELN;
    }


    /**
     * Sets the EBELN value for this ZPORTAL_S_POFERD.
     * 
     * @param EBELN
     */
    public void setEBELN(java.lang.String EBELN) {
        this.EBELN = EBELN;
    }


    /**
     * Gets the EBELP value for this ZPORTAL_S_POFERD.
     * 
     * @return EBELP
     */
    public java.lang.String getEBELP() {
        return EBELP;
    }


    /**
     * Sets the EBELP value for this ZPORTAL_S_POFERD.
     * 
     * @param EBELP
     */
    public void setEBELP(java.lang.String EBELP) {
        this.EBELP = EBELP;
    }


    /**
     * Gets the MATNR value for this ZPORTAL_S_POFERD.
     * 
     * @return MATNR
     */
    public java.lang.String getMATNR() {
        return MATNR;
    }


    /**
     * Sets the MATNR value for this ZPORTAL_S_POFERD.
     * 
     * @param MATNR
     */
    public void setMATNR(java.lang.String MATNR) {
        this.MATNR = MATNR;
    }


    /**
     * Gets the MAKTX value for this ZPORTAL_S_POFERD.
     * 
     * @return MAKTX
     */
    public java.lang.String getMAKTX() {
        return MAKTX;
    }


    /**
     * Sets the MAKTX value for this ZPORTAL_S_POFERD.
     * 
     * @param MAKTX
     */
    public void setMAKTX(java.lang.String MAKTX) {
        this.MAKTX = MAKTX;
    }


    /**
     * Gets the KTMNG value for this ZPORTAL_S_POFERD.
     * 
     * @return KTMNG
     */
    public java.math.BigDecimal getKTMNG() {
        return KTMNG;
    }


    /**
     * Sets the KTMNG value for this ZPORTAL_S_POFERD.
     * 
     * @param KTMNG
     */
    public void setKTMNG(java.math.BigDecimal KTMNG) {
        this.KTMNG = KTMNG;
    }


    /**
     * Gets the MEINS value for this ZPORTAL_S_POFERD.
     * 
     * @return MEINS
     */
    public java.lang.String getMEINS() {
        return MEINS;
    }


    /**
     * Sets the MEINS value for this ZPORTAL_S_POFERD.
     * 
     * @param MEINS
     */
    public void setMEINS(java.lang.String MEINS) {
        this.MEINS = MEINS;
    }


    /**
     * Gets the EINDT value for this ZPORTAL_S_POFERD.
     * 
     * @return EINDT
     */
    public java.lang.String getEINDT() {
        return EINDT;
    }


    /**
     * Sets the EINDT value for this ZPORTAL_S_POFERD.
     * 
     * @param EINDT
     */
    public void setEINDT(java.lang.String EINDT) {
        this.EINDT = EINDT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_POFERD)) return false;
        ZPORTAL_S_POFERD other = (ZPORTAL_S_POFERD) obj;
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
            ((this.MATNR==null && other.getMATNR()==null) || 
             (this.MATNR!=null &&
              this.MATNR.equals(other.getMATNR()))) &&
            ((this.MAKTX==null && other.getMAKTX()==null) || 
             (this.MAKTX!=null &&
              this.MAKTX.equals(other.getMAKTX()))) &&
            ((this.KTMNG==null && other.getKTMNG()==null) || 
             (this.KTMNG!=null &&
              this.KTMNG.equals(other.getKTMNG()))) &&
            ((this.MEINS==null && other.getMEINS()==null) || 
             (this.MEINS!=null &&
              this.MEINS.equals(other.getMEINS()))) &&
            ((this.EINDT==null && other.getEINDT()==null) || 
             (this.EINDT!=null &&
              this.EINDT.equals(other.getEINDT())));
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
        if (getMATNR() != null) {
            _hashCode += getMATNR().hashCode();
        }
        if (getMAKTX() != null) {
            _hashCode += getMAKTX().hashCode();
        }
        if (getKTMNG() != null) {
            _hashCode += getKTMNG().hashCode();
        }
        if (getMEINS() != null) {
            _hashCode += getMEINS().hashCode();
        }
        if (getEINDT() != null) {
            _hashCode += getEINDT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_POFERD.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_POFERD"));
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
        elemField.setFieldName("KTMNG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KTMNG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MEINS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MEINS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EINDT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EINDT"));
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
