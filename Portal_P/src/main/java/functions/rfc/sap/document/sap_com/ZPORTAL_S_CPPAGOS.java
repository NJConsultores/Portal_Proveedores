/**
 * ZPORTAL_S_CPPAGOS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_CPPAGOS  implements java.io.Serializable {
    private java.lang.String LAUFD;

    private java.lang.String LAUFI;

    private java.lang.String VBLNR;

    private java.lang.String GJAHR;

    private java.lang.String MONAT;

    private java.math.BigDecimal DMBTR;

    private java.math.BigDecimal WRBTR;

    private java.math.BigDecimal KURSF;

    public ZPORTAL_S_CPPAGOS() {
    }

    public ZPORTAL_S_CPPAGOS(
           java.lang.String LAUFD,
           java.lang.String LAUFI,
           java.lang.String VBLNR,
           java.lang.String GJAHR,
           java.lang.String MONAT,
           java.math.BigDecimal DMBTR,
           java.math.BigDecimal WRBTR,
           java.math.BigDecimal KURSF) {
           this.LAUFD = LAUFD;
           this.LAUFI = LAUFI;
           this.VBLNR = VBLNR;
           this.GJAHR = GJAHR;
           this.MONAT = MONAT;
           this.DMBTR = DMBTR;
           this.WRBTR = WRBTR;
           this.KURSF = KURSF;
    }


    /**
     * Gets the LAUFD value for this ZPORTAL_S_CPPAGOS.
     * 
     * @return LAUFD
     */
    public java.lang.String getLAUFD() {
        return LAUFD;
    }


    /**
     * Sets the LAUFD value for this ZPORTAL_S_CPPAGOS.
     * 
     * @param LAUFD
     */
    public void setLAUFD(java.lang.String LAUFD) {
        this.LAUFD = LAUFD;
    }


    /**
     * Gets the LAUFI value for this ZPORTAL_S_CPPAGOS.
     * 
     * @return LAUFI
     */
    public java.lang.String getLAUFI() {
        return LAUFI;
    }


    /**
     * Sets the LAUFI value for this ZPORTAL_S_CPPAGOS.
     * 
     * @param LAUFI
     */
    public void setLAUFI(java.lang.String LAUFI) {
        this.LAUFI = LAUFI;
    }


    /**
     * Gets the VBLNR value for this ZPORTAL_S_CPPAGOS.
     * 
     * @return VBLNR
     */
    public java.lang.String getVBLNR() {
        return VBLNR;
    }


    /**
     * Sets the VBLNR value for this ZPORTAL_S_CPPAGOS.
     * 
     * @param VBLNR
     */
    public void setVBLNR(java.lang.String VBLNR) {
        this.VBLNR = VBLNR;
    }


    /**
     * Gets the GJAHR value for this ZPORTAL_S_CPPAGOS.
     * 
     * @return GJAHR
     */
    public java.lang.String getGJAHR() {
        return GJAHR;
    }


    /**
     * Sets the GJAHR value for this ZPORTAL_S_CPPAGOS.
     * 
     * @param GJAHR
     */
    public void setGJAHR(java.lang.String GJAHR) {
        this.GJAHR = GJAHR;
    }


    /**
     * Gets the MONAT value for this ZPORTAL_S_CPPAGOS.
     * 
     * @return MONAT
     */
    public java.lang.String getMONAT() {
        return MONAT;
    }


    /**
     * Sets the MONAT value for this ZPORTAL_S_CPPAGOS.
     * 
     * @param MONAT
     */
    public void setMONAT(java.lang.String MONAT) {
        this.MONAT = MONAT;
    }


    /**
     * Gets the DMBTR value for this ZPORTAL_S_CPPAGOS.
     * 
     * @return DMBTR
     */
    public java.math.BigDecimal getDMBTR() {
        return DMBTR;
    }


    /**
     * Sets the DMBTR value for this ZPORTAL_S_CPPAGOS.
     * 
     * @param DMBTR
     */
    public void setDMBTR(java.math.BigDecimal DMBTR) {
        this.DMBTR = DMBTR;
    }


    /**
     * Gets the WRBTR value for this ZPORTAL_S_CPPAGOS.
     * 
     * @return WRBTR
     */
    public java.math.BigDecimal getWRBTR() {
        return WRBTR;
    }


    /**
     * Sets the WRBTR value for this ZPORTAL_S_CPPAGOS.
     * 
     * @param WRBTR
     */
    public void setWRBTR(java.math.BigDecimal WRBTR) {
        this.WRBTR = WRBTR;
    }


    /**
     * Gets the KURSF value for this ZPORTAL_S_CPPAGOS.
     * 
     * @return KURSF
     */
    public java.math.BigDecimal getKURSF() {
        return KURSF;
    }


    /**
     * Sets the KURSF value for this ZPORTAL_S_CPPAGOS.
     * 
     * @param KURSF
     */
    public void setKURSF(java.math.BigDecimal KURSF) {
        this.KURSF = KURSF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_CPPAGOS)) return false;
        ZPORTAL_S_CPPAGOS other = (ZPORTAL_S_CPPAGOS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LAUFD==null && other.getLAUFD()==null) || 
             (this.LAUFD!=null &&
              this.LAUFD.equals(other.getLAUFD()))) &&
            ((this.LAUFI==null && other.getLAUFI()==null) || 
             (this.LAUFI!=null &&
              this.LAUFI.equals(other.getLAUFI()))) &&
            ((this.VBLNR==null && other.getVBLNR()==null) || 
             (this.VBLNR!=null &&
              this.VBLNR.equals(other.getVBLNR()))) &&
            ((this.GJAHR==null && other.getGJAHR()==null) || 
             (this.GJAHR!=null &&
              this.GJAHR.equals(other.getGJAHR()))) &&
            ((this.MONAT==null && other.getMONAT()==null) || 
             (this.MONAT!=null &&
              this.MONAT.equals(other.getMONAT()))) &&
            ((this.DMBTR==null && other.getDMBTR()==null) || 
             (this.DMBTR!=null &&
              this.DMBTR.equals(other.getDMBTR()))) &&
            ((this.WRBTR==null && other.getWRBTR()==null) || 
             (this.WRBTR!=null &&
              this.WRBTR.equals(other.getWRBTR()))) &&
            ((this.KURSF==null && other.getKURSF()==null) || 
             (this.KURSF!=null &&
              this.KURSF.equals(other.getKURSF())));
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
        if (getLAUFD() != null) {
            _hashCode += getLAUFD().hashCode();
        }
        if (getLAUFI() != null) {
            _hashCode += getLAUFI().hashCode();
        }
        if (getVBLNR() != null) {
            _hashCode += getVBLNR().hashCode();
        }
        if (getGJAHR() != null) {
            _hashCode += getGJAHR().hashCode();
        }
        if (getMONAT() != null) {
            _hashCode += getMONAT().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_CPPAGOS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_CPPAGOS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LAUFD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LAUFD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LAUFI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LAUFI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VBLNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VBLNR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
