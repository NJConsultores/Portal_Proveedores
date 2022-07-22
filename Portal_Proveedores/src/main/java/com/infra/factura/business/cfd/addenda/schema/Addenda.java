//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.12.31 a las 11:45:03 AM CST 
//


package com.infra.factura.business.cfd.addenda.schema;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bocar">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;group ref="{}Ambos" minOccurs="0"/>
 *                   &lt;choice>
 *                     &lt;group ref="{}COC"/>
 *                     &lt;group ref="{}SOC"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *                 &lt;attribute name="tipo" use="required" type="{}tipoAddenda" />
 *                 &lt;attribute name="moneda" type="{}idMoneda" />
 *                 &lt;attribute name="tipoCambio" type="{http://www.w3.org/2001/XMLSchema}float" />
 *                 &lt;attribute name="total" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="numeroFactura" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bocar"
})
@XmlRootElement(name = "Addenda")
public class Addenda {

    @XmlElement(name = "Bocar", required = true)
    protected Addenda.Bocar bocar;

    /**
     * Obtiene el valor de la propiedad bocar.
     * 
     * @return
     *     possible object is
     *     {@link Addenda.Bocar }
     *     
     */
    public Addenda.Bocar getBocar() {
        return bocar;
    }

    /**
     * Define el valor de la propiedad bocar.
     * 
     * @param value
     *     allowed object is
     *     {@link Addenda.Bocar }
     *     
     */
    public void setBocar(Addenda.Bocar value) {
        this.bocar = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;group ref="{}Ambos" minOccurs="0"/>
     *         &lt;choice>
     *           &lt;group ref="{}COC"/>
     *           &lt;group ref="{}SOC"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *       &lt;attribute name="tipo" use="required" type="{}tipoAddenda" />
     *       &lt;attribute name="moneda" type="{}idMoneda" />
     *       &lt;attribute name="tipoCambio" type="{http://www.w3.org/2001/XMLSchema}float" />
     *       &lt;attribute name="total" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="numeroFactura" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "textoCabecera",
        "claveImpuesto",
        "numeroReferencia",
        "documentosMaterial",
        "numeroPedido",
        "partidas",
        "referencia"
    })
    public static class Bocar {

        protected String textoCabecera;
        protected String claveImpuesto;
        protected String numeroReferencia;
        protected Addenda.Bocar.DocumentosMaterial documentosMaterial;
        protected String numeroPedido;
        protected Addenda.Bocar.Partidas partidas;
        protected String referencia;
        @XmlAttribute(name = "tipo", required = true)
        protected int tipo;
        @XmlAttribute(name = "moneda")
        protected IdMoneda moneda;
        @XmlAttribute(name = "tipoCambio")
        protected Float tipoCambio;
        @XmlAttribute(name = "total", required = true)
        protected BigDecimal total;
        @XmlAttribute(name = "numeroFactura")
        protected String numeroFactura;

        /**
         * Obtiene el valor de la propiedad textoCabecera.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTextoCabecera() {
            return textoCabecera;
        }

        /**
         * Define el valor de la propiedad textoCabecera.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTextoCabecera(String value) {
            this.textoCabecera = value;
        }

        /**
         * Obtiene el valor de la propiedad claveImpuesto.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClaveImpuesto() {
            return claveImpuesto;
        }

        /**
         * Define el valor de la propiedad claveImpuesto.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClaveImpuesto(String value) {
            this.claveImpuesto = value;
        }

        /**
         * Obtiene el valor de la propiedad numeroReferencia.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroReferencia() {
            return numeroReferencia;
        }

        /**
         * Define el valor de la propiedad numeroReferencia.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroReferencia(String value) {
            this.numeroReferencia = value;
        }

        /**
         * Obtiene el valor de la propiedad documentosMaterial.
         * 
         * @return
         *     possible object is
         *     {@link Addenda.Bocar.DocumentosMaterial }
         *     
         */
        public Addenda.Bocar.DocumentosMaterial getDocumentosMaterial() {
            return documentosMaterial;
        }

        /**
         * Define el valor de la propiedad documentosMaterial.
         * 
         * @param value
         *     allowed object is
         *     {@link Addenda.Bocar.DocumentosMaterial }
         *     
         */
        public void setDocumentosMaterial(Addenda.Bocar.DocumentosMaterial value) {
            this.documentosMaterial = value;
        }

        /**
         * Obtiene el valor de la propiedad numeroPedido.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroPedido() {
            return numeroPedido;
        }

        /**
         * Define el valor de la propiedad numeroPedido.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroPedido(String value) {
            this.numeroPedido = value;
        }

        /**
         * Obtiene el valor de la propiedad partidas.
         * 
         * @return
         *     possible object is
         *     {@link Addenda.Bocar.Partidas }
         *     
         */
        public Addenda.Bocar.Partidas getPartidas() {
            return partidas;
        }

        /**
         * Define el valor de la propiedad partidas.
         * 
         * @param value
         *     allowed object is
         *     {@link Addenda.Bocar.Partidas }
         *     
         */
        public void setPartidas(Addenda.Bocar.Partidas value) {
            this.partidas = value;
        }

        /**
         * Obtiene el valor de la propiedad referencia.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReferencia() {
            return referencia;
        }

        /**
         * Define el valor de la propiedad referencia.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReferencia(String value) {
            this.referencia = value;
        }

        /**
         * Obtiene el valor de la propiedad tipo.
         * 
         */
        public int getTipo() {
            return tipo;
        }

        /**
         * Define el valor de la propiedad tipo.
         * 
         */
        public void setTipo(int value) {
            this.tipo = value;
        }

        /**
         * Obtiene el valor de la propiedad moneda.
         * 
         * @return
         *     possible object is
         *     {@link IdMoneda }
         *     
         */
        public IdMoneda getMoneda() {
            return moneda;
        }

        /**
         * Define el valor de la propiedad moneda.
         * 
         * @param value
         *     allowed object is
         *     {@link IdMoneda }
         *     
         */
        public void setMoneda(IdMoneda value) {
            this.moneda = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoCambio.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getTipoCambio() {
            return tipoCambio;
        }

        /**
         * Define el valor de la propiedad tipoCambio.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setTipoCambio(Float value) {
            this.tipoCambio = value;
        }

        /**
         * Obtiene el valor de la propiedad total.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotal() {
            return total;
        }

        /**
         * Define el valor de la propiedad total.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotal(BigDecimal value) {
            this.total = value;
        }

        /**
         * Obtiene el valor de la propiedad numeroFactura.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroFactura() {
            return numeroFactura;
        }

        /**
         * Define el valor de la propiedad numeroFactura.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroFactura(String value) {
            this.numeroFactura = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="documentoMaterial" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "documentoMaterial"
        })
        public static class DocumentosMaterial {

            @XmlElement(required = true)
            protected List<String> documentoMaterial;

            /**
             * Gets the value of the documentoMaterial property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the documentoMaterial property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDocumentoMaterial().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getDocumentoMaterial() {
                if (documentoMaterial == null) {
                    documentoMaterial = new ArrayList<String>();
                }
                return this.documentoMaterial;
            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="partida">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="cuentaContable" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ceco" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="importePartida" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
         *                 &lt;attribute name="claveImpuesto" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "partida"
        })
        public static class Partidas {

            @XmlElement(required = true)
            protected List<Addenda.Bocar.Partidas.Partida> partida;

            /**
             * Gets the value of the partida property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the partida property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPartida().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Addenda.Bocar.Partidas.Partida }
             * 
             * 
             */
            public List<Addenda.Bocar.Partidas.Partida> getPartida() {
                if (partida == null) {
                    partida = new ArrayList<Addenda.Bocar.Partidas.Partida>();
                }
                return this.partida;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="cuentaContable" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ceco" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="importePartida" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
             *       &lt;attribute name="claveImpuesto" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Partida {

                @XmlAttribute(name = "cuentaContable", required = true)
                protected String cuentaContable;
                @XmlAttribute(name = "ceco")
                protected String ceco;
                @XmlAttribute(name = "importePartida", required = true)
                protected float importePartida;
                @XmlAttribute(name = "claveImpuesto", required = true)
                protected String claveImpuesto;

                /**
                 * Obtiene el valor de la propiedad cuentaContable.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCuentaContable() {
                    return cuentaContable;
                }

                /**
                 * Define el valor de la propiedad cuentaContable.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCuentaContable(String value) {
                    this.cuentaContable = value;
                }

                /**
                 * Obtiene el valor de la propiedad ceco.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCeco() {
                    return ceco;
                }

                /**
                 * Define el valor de la propiedad ceco.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCeco(String value) {
                    this.ceco = value;
                }

                /**
                 * Obtiene el valor de la propiedad importePartida.
                 * 
                 */
                public float getImportePartida() {
                    return importePartida;
                }

                /**
                 * Define el valor de la propiedad importePartida.
                 * 
                 */
                public void setImportePartida(float value) {
                    this.importePartida = value;
                }

                /**
                 * Obtiene el valor de la propiedad claveImpuesto.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getClaveImpuesto() {
                    return claveImpuesto;
                }

                /**
                 * Define el valor de la propiedad claveImpuesto.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setClaveImpuesto(String value) {
                    this.claveImpuesto = value;
                }

            }

        }

    }

}
