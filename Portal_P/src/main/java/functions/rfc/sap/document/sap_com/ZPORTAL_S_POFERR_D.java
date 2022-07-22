/**
 * ZPORTAL_S_POFERR_D.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_POFERR_D  implements java.io.Serializable {
    private java.lang.String EBELN;

    private java.lang.String EBELP;

    private java.math.BigDecimal NETPR;

    private java.math.BigDecimal KTMNG;

    private java.lang.String EINDT;

    public ZPORTAL_S_POFERR_D() {
    }

    public ZPORTAL_S_POFERR_D(
           java.lang.String EBELN,
           java.lang.String EBELP,
           java.math.BigDecimal NETPR,
           java.math.BigDecimal KTMNG,
           java.lang.String EINDT) {
           this.EBELN = EBELN;
           this.EBELP = EBELP;
           this.NETPR = NETPR;
           this.KTMNG = KTMNG;
           this.EINDT = EINDT;
    }


    /**
     * Gets the EBELN value for this ZPORTAL_S_POFERR_D.
     * 
     * @return EBELN
     */
    public java.lang.String getEBELN() {
        return EBELN;
    }


    /**
     * Sets the EBELN value for this ZPORTAL_S_POFERR_D.
     * 
     * @param EBELN
     */
    public void setEBELN(java.lang.String EBELN) {
        this.EBELN = EBELN;
    }


    /**
     * Gets the EBELP value for this ZPORTAL_S_POFERR_D.
     * 
     * @return EBELP
     */
    public java.lang.String getEBELP() {
        return EBELP;
    }


    /**
     * Sets the EBELP value for this ZPORTAL_S_POFERR_D.
     * 
     * @param EBELP
     */
    public void setEBELP(java.lang.String EBELP) {
        this.EBELP = EBELP;
    }


    /**
     * Gets the NETPR value for this ZPORTAL_S_POFERR_D.
     * 
     * @return NETPR
     */
    public java.math.BigDecimal getNETPR() {
        return NETPR;
    }


    /**
     * Sets the NETPR value for this ZPORTAL_S_POFERR_D.
     * 
     * @param NETPR
     */
    public void setNETPR(java.math.BigDecimal NETPR) {
        this.NETPR = NETPR;
    }


    /**
     * Gets the KTMNG value for this ZPORTAL_S_POFERR_D.
     * 
     * @return KTMNG
     */
    public java.math.BigDecimal getKTMNG() {
        return KTMNG;
    }


    /**
     * Sets the KTMNG value for this ZPORTAL_S_POFERR_D.
     * 
     * @param KTMNG
     */
    public void setKTMNG(java.math.BigDecimal KTMNG) {
        this.KTMNG = KTMNG;
    }


    /**
     * Gets the EINDT value for this ZPORTAL_S_POFERR_D.
     * 
     * @return EINDT
     */
    public java.lang.String getEINDT() {
        return EINDT;
    }


    /**
     * Sets the EINDT value for this ZPORTAL_S_POFERR_D.
     * 
     * @param EINDT
     */
    public void setEINDT(java.lang.String EINDT) {
        this.EINDT = EINDT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_POFERR_D)) return false;
        ZPORTAL_S_POFERR_D other = (ZPORTAL_S_POFERR_D) obj;
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
            ((this.NETPR==null && other.getNETPR()==null) || 
             (this.NETPR!=null &&
              this.NETPR.equals(other.getNETPR()))) &&
            ((this.KTMNG==null && other.getKTMNG()==null) || 
             (this.KTMNG!=null &&
              this.KTMNG.equals(other.getKTMNG()))) &&
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
        if (getNETPR() != null) {
            _hashCode += getNETPR().hashCode();
        }
        if (getKTMNG() != null) {
            _hashCode += getKTMNG().hashCode();
        }
        if (getEINDT() != null) {
            _hashCode += getEINDT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_POFERR_D.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_POFERR_D"));
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
        elemField.setFieldName("NETPR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NETPR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KTMNG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KTMNG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
