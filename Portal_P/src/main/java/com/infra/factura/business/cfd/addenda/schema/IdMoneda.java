//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.12.31 a las 11:45:03 AM CST 
//


package com.infra.factura.business.cfd.addenda.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para idMoneda.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="idMoneda">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EUR"/>
 *     &lt;enumeration value="MXN"/>
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="GBP"/>
 *     &lt;enumeration value="JPY"/>
 *     &lt;enumeration value="CAD"/>
 *     &lt;enumeration value="CHF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "idMoneda")
@XmlEnum
public enum IdMoneda {

    EUR,
    MXN,
    USD,
    GBP,
    JPY,
    CAD,
    CHF;

    public String value() {
        return name();
    }

    public static IdMoneda fromValue(String v) {
        return valueOf(v);
    }

}
