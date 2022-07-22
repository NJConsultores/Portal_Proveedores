/**
 * LoginRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class LoginRequest  implements java.io.Serializable {
    private com.infra.service.Datos datos;

    private java.lang.Short estatus;

    private java.lang.String idioma;

    private java.lang.String mensaje;

    private com.infra.service.OpcionProv opciones;

    private java.lang.String password;

    private com.infra.service.Sociedad[] sociedades;

    private java.lang.String usuario;

    public LoginRequest() {
    }

    public LoginRequest(
           com.infra.service.Datos datos,
           java.lang.Short estatus,
           java.lang.String idioma,
           java.lang.String mensaje,
           com.infra.service.OpcionProv opciones,
           java.lang.String password,
           com.infra.service.Sociedad[] sociedades,
           java.lang.String usuario) {
           this.datos = datos;
           this.estatus = estatus;
           this.idioma = idioma;
           this.mensaje = mensaje;
           this.opciones = opciones;
           this.password = password;
           this.sociedades = sociedades;
           this.usuario = usuario;
    }


    /**
     * Gets the datos value for this LoginRequest.
     * 
     * @return datos
     */
    public com.infra.service.Datos getDatos() {
        return datos;
    }


    /**
     * Sets the datos value for this LoginRequest.
     * 
     * @param datos
     */
    public void setDatos(com.infra.service.Datos datos) {
        this.datos = datos;
    }


    /**
     * Gets the estatus value for this LoginRequest.
     * 
     * @return estatus
     */
    public java.lang.Short getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this LoginRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.Short estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the idioma value for this LoginRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this LoginRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the mensaje value for this LoginRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this LoginRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the opciones value for this LoginRequest.
     * 
     * @return opciones
     */
    public com.infra.service.OpcionProv getOpciones() {
        return opciones;
    }


    /**
     * Sets the opciones value for this LoginRequest.
     * 
     * @param opciones
     */
    public void setOpciones(com.infra.service.OpcionProv opciones) {
        this.opciones = opciones;
    }


    /**
     * Gets the password value for this LoginRequest.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this LoginRequest.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the sociedades value for this LoginRequest.
     * 
     * @return sociedades
     */
    public com.infra.service.Sociedad[] getSociedades() {
        return sociedades;
    }


    /**
     * Sets the sociedades value for this LoginRequest.
     * 
     * @param sociedades
     */
    public void setSociedades(com.infra.service.Sociedad[] sociedades) {
        this.sociedades = sociedades;
    }

    public com.infra.service.Sociedad getSociedades(int i) {
        return this.sociedades[i];
    }

    public void setSociedades(int i, com.infra.service.Sociedad _value) {
        this.sociedades[i] = _value;
    }


    /**
     * Gets the usuario value for this LoginRequest.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this LoginRequest.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoginRequest)) return false;
        LoginRequest other = (LoginRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datos==null && other.getDatos()==null) || 
             (this.datos!=null &&
              this.datos.equals(other.getDatos()))) &&
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.opciones==null && other.getOpciones()==null) || 
             (this.opciones!=null &&
              this.opciones.equals(other.getOpciones()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.sociedades==null && other.getSociedades()==null) || 
             (this.sociedades!=null &&
              java.util.Arrays.equals(this.sociedades, other.getSociedades()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario())));
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
        if (getDatos() != null) {
            _hashCode += getDatos().hashCode();
        }
        if (getEstatus() != null) {
            _hashCode += getEstatus().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getOpciones() != null) {
            _hashCode += getOpciones().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getSociedades() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSociedades());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSociedades(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "loginRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "datos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "datos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idioma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idioma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "opciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "opcionProv"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sociedades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sociedades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "sociedad"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
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
