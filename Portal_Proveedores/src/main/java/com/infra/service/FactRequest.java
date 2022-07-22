/**
 * FactRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class FactRequest  implements java.io.Serializable {
    private java.lang.String area;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_CONC concepto;

    private java.lang.String estatus;

    private java.lang.String fecha;

    private java.lang.String folio;

    private java.lang.String idioma;

    private java.lang.String iva;

    private java.lang.String listaOC;

    private java.lang.String mensaje;

    private java.lang.String moneda;

    private java.lang.String notaCredito;

    private functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC[] ordenes;

    private java.lang.String otroPDF;

    private java.lang.String pdf;

    private java.lang.String proveedor;

    private java.lang.String responsable;

    private java.lang.String rfc;

    private java.lang.String serie;

    private java.lang.String sociedad;

    private java.math.BigDecimal subtotal;

    private java.lang.String tipo;

    private java.math.BigDecimal total;

    private java.lang.String xml;

    public FactRequest() {
    }

    public FactRequest(
           java.lang.String area,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_CONC concepto,
           java.lang.String estatus,
           java.lang.String fecha,
           java.lang.String folio,
           java.lang.String idioma,
           java.lang.String iva,
           java.lang.String listaOC,
           java.lang.String mensaje,
           java.lang.String moneda,
           java.lang.String notaCredito,
           functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC[] ordenes,
           java.lang.String otroPDF,
           java.lang.String pdf,
           java.lang.String proveedor,
           java.lang.String responsable,
           java.lang.String rfc,
           java.lang.String serie,
           java.lang.String sociedad,
           java.math.BigDecimal subtotal,
           java.lang.String tipo,
           java.math.BigDecimal total,
           java.lang.String xml) {
           this.area = area;
           this.concepto = concepto;
           this.estatus = estatus;
           this.fecha = fecha;
           this.folio = folio;
           this.idioma = idioma;
           this.iva = iva;
           this.listaOC = listaOC;
           this.mensaje = mensaje;
           this.moneda = moneda;
           this.notaCredito = notaCredito;
           this.ordenes = ordenes;
           this.otroPDF = otroPDF;
           this.pdf = pdf;
           this.proveedor = proveedor;
           this.responsable = responsable;
           this.rfc = rfc;
           this.serie = serie;
           this.sociedad = sociedad;
           this.subtotal = subtotal;
           this.tipo = tipo;
           this.total = total;
           this.xml = xml;
    }


    /**
     * Gets the area value for this FactRequest.
     * 
     * @return area
     */
    public java.lang.String getArea() {
        return area;
    }


    /**
     * Sets the area value for this FactRequest.
     * 
     * @param area
     */
    public void setArea(java.lang.String area) {
        this.area = area;
    }


    /**
     * Gets the concepto value for this FactRequest.
     * 
     * @return concepto
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_CONC getConcepto() {
        return concepto;
    }


    /**
     * Sets the concepto value for this FactRequest.
     * 
     * @param concepto
     */
    public void setConcepto(functions.rfc.sap.document.sap_com.ZPORTAL_S_CONC concepto) {
        this.concepto = concepto;
    }


    /**
     * Gets the estatus value for this FactRequest.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this FactRequest.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the fecha value for this FactRequest.
     * 
     * @return fecha
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this FactRequest.
     * 
     * @param fecha
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the folio value for this FactRequest.
     * 
     * @return folio
     */
    public java.lang.String getFolio() {
        return folio;
    }


    /**
     * Sets the folio value for this FactRequest.
     * 
     * @param folio
     */
    public void setFolio(java.lang.String folio) {
        this.folio = folio;
    }


    /**
     * Gets the idioma value for this FactRequest.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this FactRequest.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the iva value for this FactRequest.
     * 
     * @return iva
     */
    public java.lang.String getIva() {
        return iva;
    }


    /**
     * Sets the iva value for this FactRequest.
     * 
     * @param iva
     */
    public void setIva(java.lang.String iva) {
        this.iva = iva;
    }


    /**
     * Gets the listaOC value for this FactRequest.
     * 
     * @return listaOC
     */
    public java.lang.String getListaOC() {
        return listaOC;
    }


    /**
     * Sets the listaOC value for this FactRequest.
     * 
     * @param listaOC
     */
    public void setListaOC(java.lang.String listaOC) {
        this.listaOC = listaOC;
    }


    /**
     * Gets the mensaje value for this FactRequest.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this FactRequest.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the moneda value for this FactRequest.
     * 
     * @return moneda
     */
    public java.lang.String getMoneda() {
        return moneda;
    }


    /**
     * Sets the moneda value for this FactRequest.
     * 
     * @param moneda
     */
    public void setMoneda(java.lang.String moneda) {
        this.moneda = moneda;
    }


    /**
     * Gets the notaCredito value for this FactRequest.
     * 
     * @return notaCredito
     */
    public java.lang.String getNotaCredito() {
        return notaCredito;
    }


    /**
     * Sets the notaCredito value for this FactRequest.
     * 
     * @param notaCredito
     */
    public void setNotaCredito(java.lang.String notaCredito) {
        this.notaCredito = notaCredito;
    }


    /**
     * Gets the ordenes value for this FactRequest.
     * 
     * @return ordenes
     */
    public functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC[] getOrdenes() {
        return ordenes;
    }


    /**
     * Sets the ordenes value for this FactRequest.
     * 
     * @param ordenes
     */
    public void setOrdenes(functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC[] ordenes) {
        this.ordenes = ordenes;
    }

    public functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC getOrdenes(int i) {
        return this.ordenes[i];
    }

    public void setOrdenes(int i, functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC _value) {
        this.ordenes[i] = _value;
    }


    /**
     * Gets the otroPDF value for this FactRequest.
     * 
     * @return otroPDF
     */
    public java.lang.String getOtroPDF() {
        return otroPDF;
    }


    /**
     * Sets the otroPDF value for this FactRequest.
     * 
     * @param otroPDF
     */
    public void setOtroPDF(java.lang.String otroPDF) {
        this.otroPDF = otroPDF;
    }


    /**
     * Gets the pdf value for this FactRequest.
     * 
     * @return pdf
     */
    public java.lang.String getPdf() {
        return pdf;
    }


    /**
     * Sets the pdf value for this FactRequest.
     * 
     * @param pdf
     */
    public void setPdf(java.lang.String pdf) {
        this.pdf = pdf;
    }


    /**
     * Gets the proveedor value for this FactRequest.
     * 
     * @return proveedor
     */
    public java.lang.String getProveedor() {
        return proveedor;
    }


    /**
     * Sets the proveedor value for this FactRequest.
     * 
     * @param proveedor
     */
    public void setProveedor(java.lang.String proveedor) {
        this.proveedor = proveedor;
    }


    /**
     * Gets the responsable value for this FactRequest.
     * 
     * @return responsable
     */
    public java.lang.String getResponsable() {
        return responsable;
    }


    /**
     * Sets the responsable value for this FactRequest.
     * 
     * @param responsable
     */
    public void setResponsable(java.lang.String responsable) {
        this.responsable = responsable;
    }


    /**
     * Gets the rfc value for this FactRequest.
     * 
     * @return rfc
     */
    public java.lang.String getRfc() {
        return rfc;
    }


    /**
     * Sets the rfc value for this FactRequest.
     * 
     * @param rfc
     */
    public void setRfc(java.lang.String rfc) {
        this.rfc = rfc;
    }


    /**
     * Gets the serie value for this FactRequest.
     * 
     * @return serie
     */
    public java.lang.String getSerie() {
        return serie;
    }


    /**
     * Sets the serie value for this FactRequest.
     * 
     * @param serie
     */
    public void setSerie(java.lang.String serie) {
        this.serie = serie;
    }


    /**
     * Gets the sociedad value for this FactRequest.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this FactRequest.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }


    /**
     * Gets the subtotal value for this FactRequest.
     * 
     * @return subtotal
     */
    public java.math.BigDecimal getSubtotal() {
        return subtotal;
    }


    /**
     * Sets the subtotal value for this FactRequest.
     * 
     * @param subtotal
     */
    public void setSubtotal(java.math.BigDecimal subtotal) {
        this.subtotal = subtotal;
    }


    /**
     * Gets the tipo value for this FactRequest.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this FactRequest.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the total value for this FactRequest.
     * 
     * @return total
     */
    public java.math.BigDecimal getTotal() {
        return total;
    }


    /**
     * Sets the total value for this FactRequest.
     * 
     * @param total
     */
    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }


    /**
     * Gets the xml value for this FactRequest.
     * 
     * @return xml
     */
    public java.lang.String getXml() {
        return xml;
    }


    /**
     * Sets the xml value for this FactRequest.
     * 
     * @param xml
     */
    public void setXml(java.lang.String xml) {
        this.xml = xml;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FactRequest)) return false;
        FactRequest other = (FactRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.concepto==null && other.getConcepto()==null) || 
             (this.concepto!=null &&
              this.concepto.equals(other.getConcepto()))) &&
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.folio==null && other.getFolio()==null) || 
             (this.folio!=null &&
              this.folio.equals(other.getFolio()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.iva==null && other.getIva()==null) || 
             (this.iva!=null &&
              this.iva.equals(other.getIva()))) &&
            ((this.listaOC==null && other.getListaOC()==null) || 
             (this.listaOC!=null &&
              this.listaOC.equals(other.getListaOC()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.moneda==null && other.getMoneda()==null) || 
             (this.moneda!=null &&
              this.moneda.equals(other.getMoneda()))) &&
            ((this.notaCredito==null && other.getNotaCredito()==null) || 
             (this.notaCredito!=null &&
              this.notaCredito.equals(other.getNotaCredito()))) &&
            ((this.ordenes==null && other.getOrdenes()==null) || 
             (this.ordenes!=null &&
              java.util.Arrays.equals(this.ordenes, other.getOrdenes()))) &&
            ((this.otroPDF==null && other.getOtroPDF()==null) || 
             (this.otroPDF!=null &&
              this.otroPDF.equals(other.getOtroPDF()))) &&
            ((this.pdf==null && other.getPdf()==null) || 
             (this.pdf!=null &&
              this.pdf.equals(other.getPdf()))) &&
            ((this.proveedor==null && other.getProveedor()==null) || 
             (this.proveedor!=null &&
              this.proveedor.equals(other.getProveedor()))) &&
            ((this.responsable==null && other.getResponsable()==null) || 
             (this.responsable!=null &&
              this.responsable.equals(other.getResponsable()))) &&
            ((this.rfc==null && other.getRfc()==null) || 
             (this.rfc!=null &&
              this.rfc.equals(other.getRfc()))) &&
            ((this.serie==null && other.getSerie()==null) || 
             (this.serie!=null &&
              this.serie.equals(other.getSerie()))) &&
            ((this.sociedad==null && other.getSociedad()==null) || 
             (this.sociedad!=null &&
              this.sociedad.equals(other.getSociedad()))) &&
            ((this.subtotal==null && other.getSubtotal()==null) || 
             (this.subtotal!=null &&
              this.subtotal.equals(other.getSubtotal()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal()))) &&
            ((this.xml==null && other.getXml()==null) || 
             (this.xml!=null &&
              this.xml.equals(other.getXml())));
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
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getConcepto() != null) {
            _hashCode += getConcepto().hashCode();
        }
        if (getEstatus() != null) {
            _hashCode += getEstatus().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFolio() != null) {
            _hashCode += getFolio().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getIva() != null) {
            _hashCode += getIva().hashCode();
        }
        if (getListaOC() != null) {
            _hashCode += getListaOC().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getMoneda() != null) {
            _hashCode += getMoneda().hashCode();
        }
        if (getNotaCredito() != null) {
            _hashCode += getNotaCredito().hashCode();
        }
        if (getOrdenes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrdenes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrdenes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOtroPDF() != null) {
            _hashCode += getOtroPDF().hashCode();
        }
        if (getPdf() != null) {
            _hashCode += getPdf().hashCode();
        }
        if (getProveedor() != null) {
            _hashCode += getProveedor().hashCode();
        }
        if (getResponsable() != null) {
            _hashCode += getResponsable().hashCode();
        }
        if (getRfc() != null) {
            _hashCode += getRfc().hashCode();
        }
        if (getSerie() != null) {
            _hashCode += getSerie().hashCode();
        }
        if (getSociedad() != null) {
            _hashCode += getSociedad().hashCode();
        }
        if (getSubtotal() != null) {
            _hashCode += getSubtotal().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        if (getXml() != null) {
            _hashCode += getXml().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FactRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.infra.com/", "factRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("", "area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("concepto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "concepto"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_CONC"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("iva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaOC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaOC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("moneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notaCredito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notaCredito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordenes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordenes"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZPORTAL_S_OCREC"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otroPDF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "otroPDF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pdf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pdf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proveedor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proveedor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responsable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responsable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rfc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sociedad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sociedad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subtotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xml");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
