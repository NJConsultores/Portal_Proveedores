/**
 * ZPORTAL_S_POFERS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_POFERS  implements java.io.Serializable {
    private java.lang.String EBELN;

    private java.lang.String EBELP;

    private java.lang.String IHRAN;

    private java.lang.String ANGDT;

    private java.lang.String MATNR;

    private java.lang.String MAKTX;

    private java.math.BigDecimal ANMNG;

    private java.math.BigDecimal NETPR;

    private java.lang.String STATU;

    private java.lang.String PDF;

    public ZPORTAL_S_POFERS() {
    }

    public ZPORTAL_S_POFERS(
           java.lang.String EBELN,
           java.lang.String EBELP,
           java.lang.String IHRAN,
           java.lang.String ANGDT,
           java.lang.String MATNR,
           java.lang.String MAKTX,
           java.math.BigDecimal ANMNG,
           java.math.BigDecimal NETPR,
           java.lang.String STATU,
           java.lang.String PDF) {
           this.EBELN = EBELN;
           this.EBELP = EBELP;
           this.IHRAN = IHRAN;
           this.ANGDT = ANGDT;
           this.MATNR = MATNR;
           this.MAKTX = MAKTX;
           this.ANMNG = ANMNG;
           this.NETPR = NETPR;
           this.STATU = STATU;
           this.PDF = PDF;
    }


    /**
     * Gets the EBELN value for this ZPORTAL_S_POFERS.
     * 
     * @return EBELN
     */
    public java.lang.String getEBELN() {
        return EBELN;
    }


    /**
     * Sets the EBELN value for this ZPORTAL_S_POFERS.
     * 
     * @param EBELN
     */
    public void setEBELN(java.lang.String EBELN) {
        this.EBELN = EBELN;
    }


    /**
     * Gets the EBELP value for this ZPORTAL_S_POFERS.
     * 
     * @return EBELP
     */
    public java.lang.String getEBELP() {
        return EBELP;
    }


    /**
     * Sets the EBELP value for this ZPORTAL_S_POFERS.
     * 
     * @param EBELP
     */
    public void setEBELP(java.lang.String EBELP) {
        this.EBELP = EBELP;
    }


    /**
     * Gets the IHRAN value for this ZPORTAL_S_POFERS.
     * 
     * @return IHRAN
     */
    public java.lang.String getIHRAN() {
        return IHRAN;
    }


    /**
     * Sets the IHRAN value for this ZPORTAL_S_POFERS.
     * 
     * @param IHRAN
     */
    public void setIHRAN(java.lang.String IHRAN) {
        this.IHRAN = IHRAN;
    }


    /**
     * Gets the ANGDT value for this ZPORTAL_S_POFERS.
     * 
     * @return ANGDT
     */
    public java.lang.String getANGDT() {
        return ANGDT;
    }


    /**
     * Sets the ANGDT value for this ZPORTAL_S_POFERS.
     * 
     * @param ANGDT
     */
    public void setANGDT(java.lang.String ANGDT) {
        this.ANGDT = ANGDT;
    }


    /**
     * Gets the MATNR value for this ZPORTAL_S_POFERS.
     * 
     * @return MATNR
     */
    public java.lang.String getMATNR() {
        return MATNR;
    }


    /**
     * Sets the MATNR value for this ZPORTAL_S_POFERS.
     * 
     * @param MATNR
     */
    public void setMATNR(java.lang.String MATNR) {
        this.MATNR = MATNR;
    }


    /**
     * Gets the MAKTX value for this ZPORTAL_S_POFERS.
     * 
     * @return MAKTX
     */
    public java.lang.String getMAKTX() {
        return MAKTX;
    }


    /**
     * Sets the MAKTX value for this ZPORTAL_S_POFERS.
     * 
     * @param MAKTX
     */
    public void setMAKTX(java.lang.String MAKTX) {
        this.MAKTX = MAKTX;
    }


    /**
     * Gets the ANMNG value for this ZPORTAL_S_POFERS.
     * 
     * @return ANMNG
     */
    public java.math.BigDecimal getANMNG() {
        return ANMNG;
    }


    /**
     * Sets the ANMNG value for this ZPORTAL_S_POFERS.
     * 
     * @param ANMNG
     */
    public void setANMNG(java.math.BigDecimal ANMNG) {
        this.ANMNG = ANMNG;
    }


    /**
     * Gets the NETPR value for this ZPORTAL_S_POFERS.
     * 
     * @return NETPR
     */
    public java.math.BigDecimal getNETPR() {
        return NETPR;
    }


    /**
     * Sets the NETPR value for this ZPORTAL_S_POFERS.
     * 
     * @param NETPR
     */
    public void setNETPR(java.math.BigDecimal NETPR) {
        this.NETPR = NETPR;
    }


    /**
     * Gets the STATU value for this ZPORTAL_S_POFERS.
     * 
     * @return STATU
     */
    public java.lang.String getSTATU() {
        return STATU;
    }


    /**
     * Sets the STATU value for this ZPORTAL_S_POFERS.
     * 
     * @param STATU
     */
    public void setSTATU(java.lang.String STATU) {
        this.STATU = STATU;
    }


    /**
     * Gets the PDF value for this ZPORTAL_S_POFERS.
     * 
     * @return PDF
     */
    public java.lang.String getPDF() {
        return PDF;
    }


    /**
     * Sets the PDF value for this ZPORTAL_S_POFERS.
     * 
     * @param PDF
     */
    public void setPDF(java.lang.String PDF) {
        this.PDF = PDF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_POFERS)) return false;
        ZPORTAL_S_POFERS other = (ZPORTAL_S_POFERS) obj;
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
            ((this.IHRAN==null && other.getIHRAN()==null) || 
             (this.IHRAN!=null &&
              this.IHRAN.equals(other.getIHRAN()))) &&
            ((this.ANGDT==null && other.getANGDT()==null) || 
             (this.ANGDT!=null &&
              this.ANGDT.equals(other.getANGDT()))) &&
            ((this.MATNR==null && other.getMATNR()==null) || 
             (this.MATNR!=null &&
              this.MATNR.equals(other.getMATNR()))) &&
            ((this.MAKTX==null && other.getMAKTX()==null) || 
             (this.MAKTX!=null &&
              this.MAKTX.equals(other.getMAKTX()))) &&
            ((this.ANMNG==null && other.getANMNG()==null) || 
             (this.ANMNG!=null &&
              this.ANMNG.equals(other.getANMNG()))) &&
            ((this.NETPR==null && other.getNETPR()==null) || 
             (this.NETPR!=null &&
              this.NETPR.equals(other.getNETPR()))) &&
            ((this.STATU==null && other.getSTATU()==null) || 
             (this.STATU!=null &&
              this.STATU.equals(other.getSTATU()))) &&
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
        if (getEBELN() != null) {
            _hashCode += getEBELN().hashCode();
        }
        if (getEBELP() != null) {
            _hashCode += getEBELP().hashCode();
        }
        if (getIHRAN() != null) {
            _hashCode += getIHRAN().hashCode();
        }
        if (getANGDT() != null) {
            _hashCode += getANGDT().hashCode();
        }
        if (getMATNR() != null) {
            _hashCode += getMATNR().hashCode();
        }
        if (getMAKTX() != null) {
            _hashCode += getMAKTX().hashCode();
        }
        if (getANMNG() != null) {
            _hashCode += getANMNG().hashCode();
        }
        if (getNETPR() != null) {
            _hashCode += getNETPR().hashCode();
        }
        if (getSTATU() != null) {
            _hashCode += getSTATU().hashCode();
        }
        if (getPDF() != null) {
            _hashCode += getPDF().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_POFERS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_POFERS"));
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
        elemField.setFieldName("IHRAN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IHRAN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ANGDT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ANGDT"));
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
        elemField.setFieldName("ANMNG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ANMNG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NETPR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NETPR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATU");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATU"));
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
