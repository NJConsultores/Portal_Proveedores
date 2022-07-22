/**
 * ZPORTAL_S_CPFACTS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_CPFACTS  implements java.io.Serializable {
    private java.lang.String VBELN;

    private java.lang.String BUDAT;

    private java.lang.String WAERS;

    private java.math.BigDecimal DMBTR;

    private java.math.BigDecimal WRBTR;

    private java.math.BigDecimal KURSF;

    private java.lang.String AUGDT;

    public ZPORTAL_S_CPFACTS() {
    }

    public ZPORTAL_S_CPFACTS(
           java.lang.String VBELN,
           java.lang.String BUDAT,
           java.lang.String WAERS,
           java.math.BigDecimal DMBTR,
           java.math.BigDecimal WRBTR,
           java.math.BigDecimal KURSF,
           java.lang.String AUGDT) {
           this.VBELN = VBELN;
           this.BUDAT = BUDAT;
           this.WAERS = WAERS;
           this.DMBTR = DMBTR;
           this.WRBTR = WRBTR;
           this.KURSF = KURSF;
           this.AUGDT = AUGDT;
    }


    /**
     * Gets the VBELN value for this ZPORTAL_S_CPFACTS.
     * 
     * @return VBELN
     */
    public java.lang.String getVBELN() {
        return VBELN;
    }


    /**
     * Sets the VBELN value for this ZPORTAL_S_CPFACTS.
     * 
     * @param VBELN
     */
    public void setVBELN(java.lang.String VBELN) {
        this.VBELN = VBELN;
    }


    /**
     * Gets the BUDAT value for this ZPORTAL_S_CPFACTS.
     * 
     * @return BUDAT
     */
    public java.lang.String getBUDAT() {
        return BUDAT;
    }


    /**
     * Sets the BUDAT value for this ZPORTAL_S_CPFACTS.
     * 
     * @param BUDAT
     */
    public void setBUDAT(java.lang.String BUDAT) {
        this.BUDAT = BUDAT;
    }


    /**
     * Gets the WAERS value for this ZPORTAL_S_CPFACTS.
     * 
     * @return WAERS
     */
    public java.lang.String getWAERS() {
        return WAERS;
    }


    /**
     * Sets the WAERS value for this ZPORTAL_S_CPFACTS.
     * 
     * @param WAERS
     */
    public void setWAERS(java.lang.String WAERS) {
        this.WAERS = WAERS;
    }


    /**
     * Gets the DMBTR value for this ZPORTAL_S_CPFACTS.
     * 
     * @return DMBTR
     */
    public java.math.BigDecimal getDMBTR() {
        return DMBTR;
    }


    /**
     * Sets the DMBTR value for this ZPORTAL_S_CPFACTS.
     * 
     * @param DMBTR
     */
    public void setDMBTR(java.math.BigDecimal DMBTR) {
        this.DMBTR = DMBTR;
    }


    /**
     * Gets the WRBTR value for this ZPORTAL_S_CPFACTS.
     * 
     * @return WRBTR
     */
    public java.math.BigDecimal getWRBTR() {
        return WRBTR;
    }


    /**
     * Sets the WRBTR value for this ZPORTAL_S_CPFACTS.
     * 
     * @param WRBTR
     */
    public void setWRBTR(java.math.BigDecimal WRBTR) {
        this.WRBTR = WRBTR;
    }


    /**
     * Gets the KURSF value for this ZPORTAL_S_CPFACTS.
     * 
     * @return KURSF
     */
    public java.math.BigDecimal getKURSF() {
        return KURSF;
    }


    /**
     * Sets the KURSF value for this ZPORTAL_S_CPFACTS.
     * 
     * @param KURSF
     */
    public void setKURSF(java.math.BigDecimal KURSF) {
        this.KURSF = KURSF;
    }


    /**
     * Gets the AUGDT value for this ZPORTAL_S_CPFACTS.
     * 
     * @return AUGDT
     */
    public java.lang.String getAUGDT() {
        return AUGDT;
    }


    /**
     * Sets the AUGDT value for this ZPORTAL_S_CPFACTS.
     * 
     * @param AUGDT
     */
    public void setAUGDT(java.lang.String AUGDT) {
        this.AUGDT = AUGDT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_CPFACTS)) return false;
        ZPORTAL_S_CPFACTS other = (ZPORTAL_S_CPFACTS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.VBELN==null && other.getVBELN()==null) || 
             (this.VBELN!=null &&
              this.VBELN.equals(other.getVBELN()))) &&
            ((this.BUDAT==null && other.getBUDAT()==null) || 
             (this.BUDAT!=null &&
              this.BUDAT.equals(other.getBUDAT()))) &&
            ((this.WAERS==null && other.getWAERS()==null) || 
             (this.WAERS!=null &&
              this.WAERS.equals(other.getWAERS()))) &&
            ((this.DMBTR==null && other.getDMBTR()==null) || 
             (this.DMBTR!=null &&
              this.DMBTR.equals(other.getDMBTR()))) &&
            ((this.WRBTR==null && other.getWRBTR()==null) || 
             (this.WRBTR!=null &&
              this.WRBTR.equals(other.getWRBTR()))) &&
            ((this.KURSF==null && other.getKURSF()==null) || 
             (this.KURSF!=null &&
              this.KURSF.equals(other.getKURSF()))) &&
            ((this.AUGDT==null && other.getAUGDT()==null) || 
             (this.AUGDT!=null &&
              this.AUGDT.equals(other.getAUGDT())));
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
        if (getVBELN() != null) {
            _hashCode += getVBELN().hashCode();
        }
        if (getBUDAT() != null) {
            _hashCode += getBUDAT().hashCode();
        }
        if (getWAERS() != null) {
            _hashCode += getWAERS().hashCode();
        }
        if (getDMBTR() != null) {
            _hashCode += getDMBTR().hashCode();
        }
        if (getWRBTR() != null) {
            _hashCode += getWRBTR().hashCode();
        }
        if (getKURSF() != null) {
            _hashCode += getKURSF().hashCode();
        }
        if (getAUGDT() != null) {
            _hashCode += getAUGDT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_CPFACTS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_CPFACTS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VBELN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VBELN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUDAT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUDAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WAERS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WAERS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DMBTR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DMBTR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WRBTR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WRBTR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KURSF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KURSF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AUGDT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AUGDT"));
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
