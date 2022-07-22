/**
 * ZPORTAL_S_AVISO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZPORTAL_S_AVISO  implements java.io.Serializable {
    private java.lang.String TPAVI;

    private short NAVIS;

    private java.lang.String FECHA;

    private java.lang.String TTULO;

    private java.lang.String TEXTO;

    public ZPORTAL_S_AVISO() {
    }

    public ZPORTAL_S_AVISO(
           java.lang.String TPAVI,
           short NAVIS,
           java.lang.String FECHA,
           java.lang.String TTULO,
           java.lang.String TEXTO) {
           this.TPAVI = TPAVI;
           this.NAVIS = NAVIS;
           this.FECHA = FECHA;
           this.TTULO = TTULO;
           this.TEXTO = TEXTO;
    }


    /**
     * Gets the TPAVI value for this ZPORTAL_S_AVISO.
     * 
     * @return TPAVI
     */
    public java.lang.String getTPAVI() {
        return TPAVI;
    }


    /**
     * Sets the TPAVI value for this ZPORTAL_S_AVISO.
     * 
     * @param TPAVI
     */
    public void setTPAVI(java.lang.String TPAVI) {
        this.TPAVI = TPAVI;
    }


    /**
     * Gets the NAVIS value for this ZPORTAL_S_AVISO.
     * 
     * @return NAVIS
     */
    public short getNAVIS() {
        return NAVIS;
    }


    /**
     * Sets the NAVIS value for this ZPORTAL_S_AVISO.
     * 
     * @param NAVIS
     */
    public void setNAVIS(short NAVIS) {
        this.NAVIS = NAVIS;
    }


    /**
     * Gets the FECHA value for this ZPORTAL_S_AVISO.
     * 
     * @return FECHA
     */
    public java.lang.String getFECHA() {
        return FECHA;
    }


    /**
     * Sets the FECHA value for this ZPORTAL_S_AVISO.
     * 
     * @param FECHA
     */
    public void setFECHA(java.lang.String FECHA) {
        this.FECHA = FECHA;
    }


    /**
     * Gets the TTULO value for this ZPORTAL_S_AVISO.
     * 
     * @return TTULO
     */
    public java.lang.String getTTULO() {
        return TTULO;
    }


    /**
     * Sets the TTULO value for this ZPORTAL_S_AVISO.
     * 
     * @param TTULO
     */
    public void setTTULO(java.lang.String TTULO) {
        this.TTULO = TTULO;
    }


    /**
     * Gets the TEXTO value for this ZPORTAL_S_AVISO.
     * 
     * @return TEXTO
     */
    public java.lang.String getTEXTO() {
        return TEXTO;
    }


    /**
     * Sets the TEXTO value for this ZPORTAL_S_AVISO.
     * 
     * @param TEXTO
     */
    public void setTEXTO(java.lang.String TEXTO) {
        this.TEXTO = TEXTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZPORTAL_S_AVISO)) return false;
        ZPORTAL_S_AVISO other = (ZPORTAL_S_AVISO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.TPAVI==null && other.getTPAVI()==null) || 
             (this.TPAVI!=null &&
              this.TPAVI.equals(other.getTPAVI()))) &&
            this.NAVIS == other.getNAVIS() &&
            ((this.FECHA==null && other.getFECHA()==null) || 
             (this.FECHA!=null &&
              this.FECHA.equals(other.getFECHA()))) &&
            ((this.TTULO==null && other.getTTULO()==null) || 
             (this.TTULO!=null &&
              this.TTULO.equals(other.getTTULO()))) &&
            ((this.TEXTO==null && other.getTEXTO()==null) || 
             (this.TEXTO!=null &&
              this.TEXTO.equals(other.getTEXTO())));
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
        if (getTPAVI() != null) {
            _hashCode += getTPAVI().hashCode();
        }
        _hashCode += getNAVIS();
        if (getFECHA() != null) {
            _hashCode += getFECHA().hashCode();
        }
        if (getTTULO() != null) {
            _hashCode += getTTULO().hashCode();
        }
        if (getTEXTO() != null) {
            _hashCode += getTEXTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZPORTAL_S_AVISO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_AVISO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TPAVI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TPAVI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NAVIS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NAVIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FECHA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FECHA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TTULO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TTULO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TEXTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TEXTO"));
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
