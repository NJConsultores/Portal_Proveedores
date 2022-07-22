/**
 * ZPORTAL_CSOCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_CSOCR  implements java.io.Serializable {
    private java.lang.String MANDT;

    private java.lang.String BUKRS;

    private java.lang.String AREA;

    private java.lang.String GERID;

    private java.lang.String GERDS;

    private java.lang.String GERUS;

    private java.lang.String ASIUS;

    private java.lang.String GEREM;

    private java.lang.String ASIEM;

    public ZPORTAL_CSOCR() {
    }

    public ZPORTAL_CSOCR(
           java.lang.String MANDT,
           java.lang.String BUKRS,
           java.lang.String AREA,
           java.lang.String GERID,
           java.lang.String GERDS,
           java.lang.String GERUS,
           java.lang.String ASIUS,
           java.lang.String GEREM,
           java.lang.String ASIEM) {
           this.MANDT = MANDT;
           this.BUKRS = BUKRS;
           this.AREA = AREA;
           this.GERID = GERID;
           this.GERDS = GERDS;
           this.GERUS = GERUS;
           this.ASIUS = ASIUS;
           this.GEREM = GEREM;
           this.ASIEM = ASIEM;
    }


    /**
     * Gets the MANDT value for this ZPORTAL_CSOCR.
     * 
     * @return MANDT
     */
    public java.lang.String getMANDT() {
        return MANDT;
    }


    /**
     * Sets the MANDT value for this ZPORTAL_CSOCR.
     * 
     * @param MANDT
     */
    public void setMANDT(java.lang.String MANDT) {
        this.MANDT = MANDT;
    }


    /**
     * Gets the BUKRS value for this ZPORTAL_CSOCR.
     * 
     * @return BUKRS
     */
    public java.lang.String getBUKRS() {
        return BUKRS;
    }


    /**
     * Sets the BUKRS value for this ZPORTAL_CSOCR.
     * 
     * @param BUKRS
     */
    public void setBUKRS(java.lang.String BUKRS) {
        this.BUKRS = BUKRS;
    }


    /**
     * Gets the AREA value for this ZPORTAL_CSOCR.
     * 
     * @return AREA
     */
    public java.lang.String getAREA() {
        return AREA;
    }


    /**
     * Sets the AREA value for this ZPORTAL_CSOCR.
     * 
     * @param AREA
     */
    public void setAREA(java.lang.String AREA) {
        this.AREA = AREA;
    }


    /**
     * Gets the GERID value for this ZPORTAL_CSOCR.
     * 
     * @return GERID
     */
    public java.lang.String getGERID() {
        return GERID;
    }


    /**
     * Sets the GERID value for this ZPORTAL_CSOCR.
     * 
     * @param GERID
     */
    public void setGERID(java.lang.String GERID) {
        this.GERID = GERID;
    }


    /**
     * Gets the GERDS value for this ZPORTAL_CSOCR.
     * 
     * @return GERDS
     */
    public java.lang.String getGERDS() {
        return GERDS;
    }


    /**
     * Sets the GERDS value for this ZPORTAL_CSOCR.
     * 
     * @param GERDS
     */
    public void setGERDS(java.lang.String GERDS) {
        this.GERDS = GERDS;
    }


    /**
     * Gets the GERUS value for this ZPORTAL_CSOCR.
     * 
     * @return GERUS
     */
    public java.lang.String getGERUS() {
        return GERUS;
    }


    /**
     * Sets the GERUS value for this ZPORTAL_CSOCR.
     * 
     * @param GERUS
     */
    public void setGERUS(java.lang.String GERUS) {
        this.GERUS = GERUS;
    }


    /**
     * Gets the ASIUS value for this ZPORTAL_CSOCR.
     * 
     * @return ASIUS
     */
    public java.lang.String getASIUS() {
        return ASIUS;
    }


    /**
     * Sets the ASIUS value for this ZPORTAL_CSOCR.
     * 
     * @param ASIUS
     */
    public void setASIUS(java.lang.String ASIUS) {
        this.ASIUS = ASIUS;
    }


    /**
     * Gets the GEREM value for this ZPORTAL_CSOCR.
     * 
     * @return GEREM
     */
    public java.lang.String getGEREM() {
        return GEREM;
    }


    /**
     * Sets the GEREM value for this ZPORTAL_CSOCR.
     * 
     * @param GEREM
     */
    public void setGEREM(java.lang.String GEREM) {
        this.GEREM = GEREM;
    }


    /**
     * Gets the ASIEM value for this ZPORTAL_CSOCR.
     * 
     * @return ASIEM
     */
    public java.lang.String getASIEM() {
        return ASIEM;
    }


    /**
     * Sets the ASIEM value for this ZPORTAL_CSOCR.
     * 
     * @param ASIEM
     */
    public void setASIEM(java.lang.String ASIEM) {
        this.ASIEM = ASIEM;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_CSOCR)) return false;
        ZPORTAL_CSOCR other = (ZPORTAL_CSOCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.MANDT==null && other.getMANDT()==null) || 
             (this.MANDT!=null &&
              this.MANDT.equals(other.getMANDT()))) &&
            ((this.BUKRS==null && other.getBUKRS()==null) || 
             (this.BUKRS!=null &&
              this.BUKRS.equals(other.getBUKRS()))) &&
            ((this.AREA==null && other.getAREA()==null) || 
             (this.AREA!=null &&
              this.AREA.equals(other.getAREA()))) &&
            ((this.GERID==null && other.getGERID()==null) || 
             (this.GERID!=null &&
              this.GERID.equals(other.getGERID()))) &&
            ((this.GERDS==null && other.getGERDS()==null) || 
             (this.GERDS!=null &&
              this.GERDS.equals(other.getGERDS()))) &&
            ((this.GERUS==null && other.getGERUS()==null) || 
             (this.GERUS!=null &&
              this.GERUS.equals(other.getGERUS()))) &&
            ((this.ASIUS==null && other.getASIUS()==null) || 
             (this.ASIUS!=null &&
              this.ASIUS.equals(other.getASIUS()))) &&
            ((this.GEREM==null && other.getGEREM()==null) || 
             (this.GEREM!=null &&
              this.GEREM.equals(other.getGEREM()))) &&
            ((this.ASIEM==null && other.getASIEM()==null) || 
             (this.ASIEM!=null &&
              this.ASIEM.equals(other.getASIEM())));
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
        if (getMANDT() != null) {
            _hashCode += getMANDT().hashCode();
        }
        if (getBUKRS() != null) {
            _hashCode += getBUKRS().hashCode();
        }
        if (getAREA() != null) {
            _hashCode += getAREA().hashCode();
        }
        if (getGERID() != null) {
            _hashCode += getGERID().hashCode();
        }
        if (getGERDS() != null) {
            _hashCode += getGERDS().hashCode();
        }
        if (getGERUS() != null) {
            _hashCode += getGERUS().hashCode();
        }
        if (getASIUS() != null) {
            _hashCode += getASIUS().hashCode();
        }
        if (getGEREM() != null) {
            _hashCode += getGEREM().hashCode();
        }
        if (getASIEM() != null) {
            _hashCode += getASIEM().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_CSOCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_CSOCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MANDT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MANDT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUKRS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUKRS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AREA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AREA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GERID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GERID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GERDS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GERDS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GERUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GERUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ASIUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ASIUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GEREM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GEREM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ASIEM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ASIEM"));
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
