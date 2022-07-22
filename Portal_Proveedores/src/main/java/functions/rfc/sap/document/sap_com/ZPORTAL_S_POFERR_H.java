/**
 * ZPORTAL_S_POFERR_H.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_POFERR_H  implements java.io.Serializable {
    private java.lang.String EBELN;

    private java.lang.String WAERS;

    private java.lang.String ZTERM;

    private java.lang.String INCO1;

    private java.lang.String INCO2;

    private java.lang.String BKTXT;

    private java.lang.String BKTX2;

    private java.lang.String PDF;

    public ZPORTAL_S_POFERR_H() {
    }

    public ZPORTAL_S_POFERR_H(
           java.lang.String EBELN,
           java.lang.String WAERS,
           java.lang.String ZTERM,
           java.lang.String INCO1,
           java.lang.String INCO2,
           java.lang.String BKTXT,
           java.lang.String BKTX2,
           java.lang.String PDF) {
           this.EBELN = EBELN;
           this.WAERS = WAERS;
           this.ZTERM = ZTERM;
           this.INCO1 = INCO1;
           this.INCO2 = INCO2;
           this.BKTXT = BKTXT;
           this.BKTX2 = BKTX2;
           this.PDF = PDF;
    }


    /**
     * Gets the EBELN value for this ZPORTAL_S_POFERR_H.
     * 
     * @return EBELN
     */
    public java.lang.String getEBELN() {
        return EBELN;
    }


    /**
     * Sets the EBELN value for this ZPORTAL_S_POFERR_H.
     * 
     * @param EBELN
     */
    public void setEBELN(java.lang.String EBELN) {
        this.EBELN = EBELN;
    }


    /**
     * Gets the WAERS value for this ZPORTAL_S_POFERR_H.
     * 
     * @return WAERS
     */
    public java.lang.String getWAERS() {
        return WAERS;
    }


    /**
     * Sets the WAERS value for this ZPORTAL_S_POFERR_H.
     * 
     * @param WAERS
     */
    public void setWAERS(java.lang.String WAERS) {
        this.WAERS = WAERS;
    }


    /**
     * Gets the ZTERM value for this ZPORTAL_S_POFERR_H.
     * 
     * @return ZTERM
     */
    public java.lang.String getZTERM() {
        return ZTERM;
    }


    /**
     * Sets the ZTERM value for this ZPORTAL_S_POFERR_H.
     * 
     * @param ZTERM
     */
    public void setZTERM(java.lang.String ZTERM) {
        this.ZTERM = ZTERM;
    }


    /**
     * Gets the INCO1 value for this ZPORTAL_S_POFERR_H.
     * 
     * @return INCO1
     */
    public java.lang.String getINCO1() {
        return INCO1;
    }


    /**
     * Sets the INCO1 value for this ZPORTAL_S_POFERR_H.
     * 
     * @param INCO1
     */
    public void setINCO1(java.lang.String INCO1) {
        this.INCO1 = INCO1;
    }


    /**
     * Gets the INCO2 value for this ZPORTAL_S_POFERR_H.
     * 
     * @return INCO2
     */
    public java.lang.String getINCO2() {
        return INCO2;
    }


    /**
     * Sets the INCO2 value for this ZPORTAL_S_POFERR_H.
     * 
     * @param INCO2
     */
    public void setINCO2(java.lang.String INCO2) {
        this.INCO2 = INCO2;
    }


    /**
     * Gets the BKTXT value for this ZPORTAL_S_POFERR_H.
     * 
     * @return BKTXT
     */
    public java.lang.String getBKTXT() {
        return BKTXT;
    }


    /**
     * Sets the BKTXT value for this ZPORTAL_S_POFERR_H.
     * 
     * @param BKTXT
     */
    public void setBKTXT(java.lang.String BKTXT) {
        this.BKTXT = BKTXT;
    }


    /**
     * Gets the BKTX2 value for this ZPORTAL_S_POFERR_H.
     * 
     * @return BKTX2
     */
    public java.lang.String getBKTX2() {
        return BKTX2;
    }


    /**
     * Sets the BKTX2 value for this ZPORTAL_S_POFERR_H.
     * 
     * @param BKTX2
     */
    public void setBKTX2(java.lang.String BKTX2) {
        this.BKTX2 = BKTX2;
    }


    /**
     * Gets the PDF value for this ZPORTAL_S_POFERR_H.
     * 
     * @return PDF
     */
    public java.lang.String getPDF() {
        return PDF;
    }


    /**
     * Sets the PDF value for this ZPORTAL_S_POFERR_H.
     * 
     * @param PDF
     */
    public void setPDF(java.lang.String PDF) {
        this.PDF = PDF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_POFERR_H)) return false;
        ZPORTAL_S_POFERR_H other = (ZPORTAL_S_POFERR_H) obj;
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
            ((this.WAERS==null && other.getWAERS()==null) || 
             (this.WAERS!=null &&
              this.WAERS.equals(other.getWAERS()))) &&
            ((this.ZTERM==null && other.getZTERM()==null) || 
             (this.ZTERM!=null &&
              this.ZTERM.equals(other.getZTERM()))) &&
            ((this.INCO1==null && other.getINCO1()==null) || 
             (this.INCO1!=null &&
              this.INCO1.equals(other.getINCO1()))) &&
            ((this.INCO2==null && other.getINCO2()==null) || 
             (this.INCO2!=null &&
              this.INCO2.equals(other.getINCO2()))) &&
            ((this.BKTXT==null && other.getBKTXT()==null) || 
             (this.BKTXT!=null &&
              this.BKTXT.equals(other.getBKTXT()))) &&
            ((this.BKTX2==null && other.getBKTX2()==null) || 
             (this.BKTX2!=null &&
              this.BKTX2.equals(other.getBKTX2()))) &&
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
        if (getWAERS() != null) {
            _hashCode += getWAERS().hashCode();
        }
        if (getZTERM() != null) {
            _hashCode += getZTERM().hashCode();
        }
        if (getINCO1() != null) {
            _hashCode += getINCO1().hashCode();
        }
        if (getINCO2() != null) {
            _hashCode += getINCO2().hashCode();
        }
        if (getBKTXT() != null) {
            _hashCode += getBKTXT().hashCode();
        }
        if (getBKTX2() != null) {
            _hashCode += getBKTX2().hashCode();
        }
        if (getPDF() != null) {
            _hashCode += getPDF().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_POFERR_H.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_POFERR_H"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EBELN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EBELN"));
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
        elemField.setFieldName("ZTERM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ZTERM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INCO1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "INCO1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INCO2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "INCO2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BKTXT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BKTXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BKTX2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BKTX2"));
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
