//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: AM.04.24 a las 10:00:55 AM CDT 
//


package com.infra.factura.business.cfdi.timbre.i.schema;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.infra.factura.business.cfdi.schema.Adapter1;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="1.1" />
 *       &lt;attribute name="UUID" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;length value="36"/>
 *             &lt;pattern value="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="FechaTimbrado" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_FechaH" />
 *       &lt;attribute name="RfcProvCertif" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC_PM" />
 *       &lt;attribute name="Leyenda">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;minLength value="12"/>
 *             &lt;maxLength value="150"/>
 *             &lt;pattern value="([A-Z]|[a-z]|[0-9]| |�|�|!|"|%|&amp;|'|�|-|:|;|>|=|&lt;|@|_|,|\{|\}|`|~|�|�|�|�|�|�|�|�|�|�|�|�){1,150}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SelloCFD" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NoCertificadoSAT" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;length value="20"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[0-9]{20}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SelloSAT" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "TimbreFiscalDigital")
public class TimbreFiscalDigital {

    @XmlAttribute(name = "Version", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String version;
    @XmlAttribute(name = "UUID", required = true)
    protected String uuid;
    @XmlAttribute(name = "FechaTimbrado", required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Date fechaTimbrado;
    @XmlAttribute(name = "RfcProvCertif", required = true)
    protected String rfcProvCertif;
    @XmlAttribute(name = "Leyenda")
    protected String leyenda;
    @XmlAttribute(name = "SelloCFD", required = true)
    protected String selloCFD;
    @XmlAttribute(name = "NoCertificadoSAT", required = true)
    protected String noCertificadoSAT;
    @XmlAttribute(name = "SelloSAT", required = true)
    protected String selloSAT;

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "1.1";
        } else {
            return version;
        }
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad uuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Define el valor de la propiedad uuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaTimbrado.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getFechaTimbrado() {
        return fechaTimbrado;
    }

    /**
     * Define el valor de la propiedad fechaTimbrado.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setFechaTimbrado(Date value) {
        this.fechaTimbrado = value;
    }

    /**
     * Obtiene el valor de la propiedad rfcProvCertif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfcProvCertif() {
        return rfcProvCertif;
    }

    /**
     * Define el valor de la propiedad rfcProvCertif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfcProvCertif(String value) {
        this.rfcProvCertif = value;
    }

    /**
     * Obtiene el valor de la propiedad leyenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeyenda() {
        return leyenda;
    }

    /**
     * Define el valor de la propiedad leyenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeyenda(String value) {
        this.leyenda = value;
    }

    /**
     * Obtiene el valor de la propiedad selloCFD.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelloCFD() {
        return selloCFD;
    }

    /**
     * Define el valor de la propiedad selloCFD.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelloCFD(String value) {
        this.selloCFD = value;
    }

    /**
     * Obtiene el valor de la propiedad noCertificadoSAT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoCertificadoSAT() {
        return noCertificadoSAT;
    }

    /**
     * Define el valor de la propiedad noCertificadoSAT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoCertificadoSAT(String value) {
        this.noCertificadoSAT = value;
    }

    /**
     * Obtiene el valor de la propiedad selloSAT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelloSAT() {
        return selloSAT;
    }

    /**
     * Define el valor de la propiedad selloSAT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelloSAT(String value) {
        this.selloSAT = value;
    }

}
