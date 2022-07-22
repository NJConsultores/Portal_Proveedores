/**
 * ZPORTAL_S_NPROV_A.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_NPROV_A  implements java.io.Serializable {
    private java.lang.String ACTA;

    private java.lang.String PODER;

    private java.lang.String SITUACION;

    private java.lang.String EDOCTA;

    private java.lang.String IFE_REP;

    private java.lang.String COMP_DOMI;

    private java.lang.String FORMATO;

    public ZPORTAL_S_NPROV_A() {
    }

    public ZPORTAL_S_NPROV_A(
           java.lang.String ACTA,
           java.lang.String PODER,
           java.lang.String SITUACION,
           java.lang.String EDOCTA,
           java.lang.String IFE_REP,
           java.lang.String COMP_DOMI,
           java.lang.String FORMATO) {
           this.ACTA = ACTA;
           this.PODER = PODER;
           this.SITUACION = SITUACION;
           this.EDOCTA = EDOCTA;
           this.IFE_REP = IFE_REP;
           this.COMP_DOMI = COMP_DOMI;
           this.FORMATO = FORMATO;
    }


    /**
     * Gets the ACTA value for this ZPORTAL_S_NPROV_A.
     * 
     * @return ACTA
     */
    public java.lang.String getACTA() {
        return ACTA;
    }


    /**
     * Sets the ACTA value for this ZPORTAL_S_NPROV_A.
     * 
     * @param ACTA
     */
    public void setACTA(java.lang.String ACTA) {
        this.ACTA = ACTA;
    }


    /**
     * Gets the PODER value for this ZPORTAL_S_NPROV_A.
     * 
     * @return PODER
     */
    public java.lang.String getPODER() {
        return PODER;
    }


    /**
     * Sets the PODER value for this ZPORTAL_S_NPROV_A.
     * 
     * @param PODER
     */
    public void setPODER(java.lang.String PODER) {
        this.PODER = PODER;
    }


    /**
     * Gets the SITUACION value for this ZPORTAL_S_NPROV_A.
     * 
     * @return SITUACION
     */
    public java.lang.String getSITUACION() {
        return SITUACION;
    }


    /**
     * Sets the SITUACION value for this ZPORTAL_S_NPROV_A.
     * 
     * @param SITUACION
     */
    public void setSITUACION(java.lang.String SITUACION) {
        this.SITUACION = SITUACION;
    }


    /**
     * Gets the EDOCTA value for this ZPORTAL_S_NPROV_A.
     * 
     * @return EDOCTA
     */
    public java.lang.String getEDOCTA() {
        return EDOCTA;
    }


    /**
     * Sets the EDOCTA value for this ZPORTAL_S_NPROV_A.
     * 
     * @param EDOCTA
     */
    public void setEDOCTA(java.lang.String EDOCTA) {
        this.EDOCTA = EDOCTA;
    }


    /**
     * Gets the IFE_REP value for this ZPORTAL_S_NPROV_A.
     * 
     * @return IFE_REP
     */
    public java.lang.String getIFE_REP() {
        return IFE_REP;
    }


    /**
     * Sets the IFE_REP value for this ZPORTAL_S_NPROV_A.
     * 
     * @param IFE_REP
     */
    public void setIFE_REP(java.lang.String IFE_REP) {
        this.IFE_REP = IFE_REP;
    }


    /**
     * Gets the COMP_DOMI value for this ZPORTAL_S_NPROV_A.
     * 
     * @return COMP_DOMI
     */
    public java.lang.String getCOMP_DOMI() {
        return COMP_DOMI;
    }


    /**
     * Sets the COMP_DOMI value for this ZPORTAL_S_NPROV_A.
     * 
     * @param COMP_DOMI
     */
    public void setCOMP_DOMI(java.lang.String COMP_DOMI) {
        this.COMP_DOMI = COMP_DOMI;
    }


    /**
     * Gets the FORMATO value for this ZPORTAL_S_NPROV_A.
     * 
     * @return FORMATO
     */
    public java.lang.String getFORMATO() {
        return FORMATO;
    }


    /**
     * Sets the FORMATO value for this ZPORTAL_S_NPROV_A.
     * 
     * @param FORMATO
     */
    public void setFORMATO(java.lang.String FORMATO) {
        this.FORMATO = FORMATO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_NPROV_A)) return false;
        ZPORTAL_S_NPROV_A other = (ZPORTAL_S_NPROV_A) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ACTA==null && other.getACTA()==null) || 
             (this.ACTA!=null &&
              this.ACTA.equals(other.getACTA()))) &&
            ((this.PODER==null && other.getPODER()==null) || 
             (this.PODER!=null &&
              this.PODER.equals(other.getPODER()))) &&
            ((this.SITUACION==null && other.getSITUACION()==null) || 
             (this.SITUACION!=null &&
              this.SITUACION.equals(other.getSITUACION()))) &&
            ((this.EDOCTA==null && other.getEDOCTA()==null) || 
             (this.EDOCTA!=null &&
              this.EDOCTA.equals(other.getEDOCTA()))) &&
            ((this.IFE_REP==null && other.getIFE_REP()==null) || 
             (this.IFE_REP!=null &&
              this.IFE_REP.equals(other.getIFE_REP()))) &&
            ((this.COMP_DOMI==null && other.getCOMP_DOMI()==null) || 
             (this.COMP_DOMI!=null &&
              this.COMP_DOMI.equals(other.getCOMP_DOMI()))) &&
            ((this.FORMATO==null && other.getFORMATO()==null) || 
             (this.FORMATO!=null &&
              this.FORMATO.equals(other.getFORMATO())));
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
        if (getACTA() != null) {
            _hashCode += getACTA().hashCode();
        }
        if (getPODER() != null) {
            _hashCode += getPODER().hashCode();
        }
        if (getSITUACION() != null) {
            _hashCode += getSITUACION().hashCode();
        }
        if (getEDOCTA() != null) {
            _hashCode += getEDOCTA().hashCode();
        }
        if (getIFE_REP() != null) {
            _hashCode += getIFE_REP().hashCode();
        }
        if (getCOMP_DOMI() != null) {
            _hashCode += getCOMP_DOMI().hashCode();
        }
        if (getFORMATO() != null) {
            _hashCode += getFORMATO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_NPROV_A.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_NPROV_A"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACTA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ACTA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PODER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PODER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SITUACION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SITUACION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EDOCTA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EDOCTA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IFE_REP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IFE_REP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMP_DOMI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMP_DOMI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FORMATO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FORMATO"));
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
