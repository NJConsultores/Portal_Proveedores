//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.12.31 a las 11:45:03 AM CST 
//


package com.infra.factura.business.cfd.addenda.schema;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.infra.factura.business.cfd.addenda.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.infra.factura.business.cfd.addenda.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Addenda }
     * 
     */
    public Addenda createAddenda() {
        return new Addenda();
    }

    /**
     * Create an instance of {@link Addenda.Bocar }
     * 
     */
    public Addenda.Bocar createAddendaBocar() {
        return new Addenda.Bocar();
    }

    /**
     * Create an instance of {@link Addenda.Bocar.Partidas }
     * 
     */
    public Addenda.Bocar.Partidas createAddendaBocarPartidas() {
        return new Addenda.Bocar.Partidas();
    }

    /**
     * Create an instance of {@link Addenda.Bocar.DocumentosMaterial }
     * 
     */
    public Addenda.Bocar.DocumentosMaterial createAddendaBocarDocumentosMaterial() {
        return new Addenda.Bocar.DocumentosMaterial();
    }

    /**
     * Create an instance of {@link Addenda.Bocar.Partidas.Partida }
     * 
     */
    public Addenda.Bocar.Partidas.Partida createAddendaBocarPartidasPartida() {
        return new Addenda.Bocar.Partidas.Partida();
    }

}
