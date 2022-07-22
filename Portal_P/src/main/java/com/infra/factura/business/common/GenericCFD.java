package com.infra.factura.business.common;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.infra.factura.bigdata.sat.common.CFD;
import com.infra.factura.bigdata.sat.common.URIResolverImpl;
import com.infra.factura.business.schema.util.StringAndInputstreamUtil;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDVersion;

import org.w3c.dom.Document;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/*import cpdetector.io.ASCIIDetector;
import cpdetector.io.CodepageDetectorProxy;
import cpdetector.io.JChardetFacade;
import cpdetector.io.ParsingDetector;
import cpdetector.io.UnicodeDetector;*/

public abstract class GenericCFD implements CFD {

	protected static final String URL_CFDV2_XSD = "http://www.sat.gob.mx/sitio_internet/cfd/2/cfdv2.xsd";

	protected static final String URL_CFDV2_2_XSD = "http://www.sat.gob.mx/sitio_internet/cfd/2/cfdv22.xsd";

	public static final String CFD_2_NAMESPACE = "http://www.sat.gob.mx/cfd/2";

	protected static final String XSLTv2 = "/xslt/cadenaoriginal_2_0.xslt";

	protected static final String XSLTv2_2 = "/xslt/cadenaoriginal_2_2.xslt";

	protected static final String XSDv2 = "/xsd/v2/cfdv2.xsd";

	protected static final String XSDv2_2 = "/xsd/v2/cfdv2_2.xsd";

	public static final String URL_CFDV3_XSD = "http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv3.xsd";

	public static final String URL_CFDV3_2_XSD = "https://pginvoice.com/srfe/cfd/ver_3_2/cfdv32.xsd";
	
	public static final String CFD_3_NAMESPACE = "http://www.sat.gob.mx/cfd/3";

	protected static final String XSLTv3 = "/xslt/cadenaoriginal_3_0.xslt";

	protected static final String XSLTv3_2 = "/xslt/cadenaoriginal_3_2.xslt";

	protected static final String XSDv3 = "/xsd/v3/cfdv3.xsd";

	protected static final String XSDv3_2 = "/xsd/v3/cfdv3_2.xsd";

	protected static final String TIMBRE_FISCAL_DIGITAL_NAMESPACE = "http://www.sat.gob.mx/TimbreFiscalDigital";

	protected static final String XSD_TFDv3 = "/xsd/v3/TimbreFiscalDigital.xsd";
	
	//Archivos XSD locales
	protected static final String XSD_AEROLINEAS = "/xsd/v3/aerolineas.xsd";
	protected static final String XSD_DETALLISTA = "/xsd/v3/detallista.xsd";
	protected static final String XSD_DIVISAS = "/xsd/v3/divisas.xsd";
	protected static final String XSD_DONAT11 = "/xsd/v3/donat11.xsd";
	protected static final String XSD_ECC = "/xsd/v3/ecc.xsd";
	protected static final String XSD_ECC11 = "/xsd/v3/ecc11.xsd";
	protected static final String XSD_IMPLOCAL = "/xsd/v3/implocal.xsd";
	protected static final String XSD_LEYENDASFISC = "/xsd/v3/leyendasFisc.xsd";
	protected static final String XSD_TERCEROS11 = "/xsd/v3/terceros11.xsd";
	protected static final String XSD_TURISTAPASAJEROEXTRANJERO = "/xsd/v3/TuristaPasajeroExtranjero.xsd";
	protected static final String XSD_VENTAVEHICULOS11 = "/xsd/v3/ventavehiculos11.xsd";
	protected static final String XSD_CFDI_REGISTRO_FISCAL = "/xsd/v3/cfdiregistrofiscal.xsd";

	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	protected static final String BASE_CONTEXT_CFDv2 = "com.infra.factura.business.cfd.schema";

	protected static final String BASE_CONTEXT_CFDv2_2 = "com.infra.factura.business.cfd.ii.schema";

	protected static final String BASE_CONTEXT_CFDv3 = "com.infra.factura.business.cfdi.schema";

	protected static final String BASE_CONTEXT_CFDv3_2 = "com.infra.factura.business.cfdi.ii.schema";

	protected static final String BASE_CONTEXT_TFDv3 = "com.infra.factura.business.cfdi.timbre.schema";
	
	protected static final String BASE_CONTEXT_TFDv1_1 = "com.infra.factura.business.cfdi.timbre.i.schema";

	public static final String COMPLEMENTO_ECC_NAMESPACE = "http://www.sat.gob.mx/ecc";
	
	public static final String COMPLEMENTO_PSGECFD_NAMESPACE = "http://www.sat.gob.mx/psgecfd";
	
	public static final String COMPLEMENTO_DONAT_NAMESPACE = "http://www.sat.gob.mx/donat";
	
	public static final String COMPLEMENTO_DIVISAS_NAMESPACE = "http://www.sat.gob.mx/divisas";
	
	public static final String COMPLEMENTO_ECB_NAMESPACE = "http://www.sat.gob.mx/ecb";
	
	public static final String COMPLEMENTO_DETALLISTA_NAMESPACE = "http://www.sat.gob.mx/detallista";
	
	public static final String COMPLEMENTO_IMPLOCAL_NAMESPACE = "http://www.sat.gob.mx/implocal";
	
	public static final String COMPLEMENTO_TERCEROS_NAMESPACE = "http://www.sat.gob.mx/terceros";
	
	public static final String COMPLEMENTO_ECC_XSD = "/xsd/v3/ecc.xsd";
	
	public static final String COMPLEMENTO_PSGECFD_XSD = "/xsd/v3/psgecfd.xsd";
	
	public static final String COMPLEMENTO_DONAT_XSD = "/xsd/cfd/donat/donat.xsd";
	
	public static final String COMPLEMENTO_DONAT2_XSD = "/xsd/cfd/donat/donat11.xsd";
	
	public static final String COMPLEMENTO_DIVISAS_XSD = "/xsd/v3/divisas.xsd";
	
	public static final String COMPLEMENTO_ECB_XSD = "/xsd/v3/ecb.xsd";
	
	public static final String COMPLEMENTO_DETALLISTA_XSD = "/xsd/v3/detallista.xsd";
	
	public static final String COMPLEMENTO_IMPLOCAL_XSD = "/xsd/v3/implocal.xsd";
	
	public static final String COMPLEMENTO_TERCEROS_XSD = "/xsd/v3/terceros.xsd";

	public static final String COMPLEMENTO_TERCEROS11_XSD = "/xsd/v3/terceros11.xsd";
	
	public static final String COMPLEMENTO_PSGCFDSP_XSD = "/xsd/v3/psgcfdsp.xsd";
	
	public static final String COMPLEMENTO_LEYENDAS_FISCALES_XSD = "/xsd/v3/leyendasFisc.xsd";
	
	public static final String COMPLEMENTO_PFIC_XSD = "/xsd/cfd/pfic/pfic.xsd";
	
	public static final String COMPLEMENTO_TURISTAPASAJEROEXTRANJERO_XSD = "/xsd/v3/TuristaPasajeroExtranjero.xsd";
	
	public static final String COMPLEMENTO_IEDU_XSD = "/xsd/v3/iedu.xsd";
	
	public static final String COMPLEMENTO_VENTA_VEHICULOS_XSD = "/xsd/v3/ventavehiculos11.xsd";

	public static final String COMPLEMENTO_AEROLINEAS_XSD = "/xsd/v3/aerolineas.xsd";
	
	public static final String COMPLEMENTO_VALES_DESPENSA = "/xsd/cfd/valesdedespensa/valesdedespensa.xsd";
	
	public static final String COMPLEMENTO_SPEI_XSD = "/xsd/cfd/spei/spei.xsd";
	
	public static final String COMPLEMENTO_VEHICULO_USADO_XSD = "/xsd/cfd/vehiculousado/vehiculousado.xsd";
	
	public static final String COMPLEMENTO_NOMINA_XSD = "/xsd/cfd/nomina/nomina11.xsd";
	
	public static final String COMPLEMENTO_OBRAS_ANTIGUEDADES_XSD = "/xsd/cfd/obrasarteantiguedades/obrasarteantiguedades.xsd";
	
	public static final String COMPLEMENTO_PAGO_ESPECIES_XSD = "/xsd/cfd/pagoenespecie/pagoenespecie.xsd";
	
	public static final String COMPLEMENTO_RENOVACION_SUSTITUCION_VEHICULOS_XSD = "/xsd/cfd/renovacionysustitucionvehiculos/renovacionysustitucionvehiculos.xsd";
	
	public static final String COMPLEMENTO_SERVICIO_PARCIAL_CONSTRUCCION_XSD = "/xsd/cfd/servicioparcialconstruccion/servicioparcialconstruccion.xsd";
	
	public static final String COMPLEMENTO_INE_XSD = "/xsd/cfd/ine/ine10.xsd";
	
	public static final String COMPLEMENTO_AEROLINEA_XSD = "/xsd/cfd/aerolineas/aerolineas.xsd";
	
	public static final String COMPLEMENTO_CDESTRUCCION_XSD = "/xsd/cfd/certificadodedestruccion/certificadodedestruccion.xsd";
	
	public static final String COMPLEMENTO_REGISTRO_FISCAL_XSD = "/xsd/cfd/cfdiregistrofiscal/cfdiregistrofiscal.xsd";
	
	//public static final String COMPLEMENTO_COMERCIO_EXTERIOR_XSD = "http://localhost:8080/cfd/ComercioExterior10.xsd";
	public static final String COMPLEMENTO_COMERCIO_EXTERIOR_XSD = "/xsd/cfd/ComercioExterior/ComercioExterior10.xsd";
	
	public static final String COMPLEMENTO_CONSUMO_COMBUSTIBLES_XSD = "/xsd/cfd/consumodecombustibles/consumodecombustibles.xsd";
	
	public static final String COMPLEMENTO_NOTARIOS_PUBLICOS = "/xsd/cfd/notariosPublicos/notariospublicos.xsd";
	
	public static final String COMPLEMENTO_VENTA_VEHICULOS_XSD11 = "/xsd/cfd/ventavehiculos/ventavehiculos11.xsd";
	
//	public static final String COMPLEMENTO_ECC_XSD = "https://pginvoice.com/srfe/cfd/ecc/ecc.xsd";
//	
//	public static final String COMPLEMENTO_PSGECFD_XSD = "https://pginvoice.com/srfe/cfd/psgecfd/psgecfd.xsd";
//	
//	public static final String COMPLEMENTO_DONAT_XSD = "https://pginvoice.com/srfe/cfd/donat/donat.xsd";
//	
//	public static final String COMPLEMENTO_DONAT2_XSD = "https://pginvoice.com/srfe/cfd/donat/donat11.xsd";
//	
//	public static final String COMPLEMENTO_DIVISAS_XSD = "https://pginvoice.com/srfe/cfd/divisas/divisas.xsd";
//	
//	public static final String COMPLEMENTO_ECB_XSD = "https://pginvoice.com/srfe/cfd/ecb/ecb.xsd";
//	
//	public static final String COMPLEMENTO_DETALLISTA_XSD = "https://pginvoice.com/srfe/cfd/detallista/detallista.xsd";
//	
//	public static final String COMPLEMENTO_IMPLOCAL_XSD = "https://pginvoice.com/srfe/cfd/implocal/implocal.xsd";
//	
//	public static final String COMPLEMENTO_TERCEROS_XSD = "https://pginvoice.com/srfe/cfd/terceros/terceros.xsd";
//
//	public static final String COMPLEMENTO_TERCEROS11_XSD = "https://pginvoice.com/srfe/cfd/terceros/terceros11.xsd";
//	
//	public static final String COMPLEMENTO_PSGCFDSP_XSD = "https://pginvoice.com/srfe/cfd/psgcfdsp/psgcfdsp.xsd";
//	
//	public static final String COMPLEMENTO_LEYENDAS_FISCALES_XSD = "https://pginvoice.com/srfe/cfd/leyendasFiscales/leyendasFisc.xsd";
//	
//	public static final String COMPLEMENTO_PFIC_XSD = "https://pginvoice.com/srfe/cfd/pfic/pfic.xsd";
//	
//	public static final String COMPLEMENTO_TURISTAPASAJEROEXTRANJERO_XSD = "https://pginvoice.com/srfe/cfd/TuristaPasajeroExtranjero/TuristaPasajeroExtranjero.xsd";
//	
//	public static final String COMPLEMENTO_IEDU_XSD = "https://pginvoice.com/srfe/cfd/iedu/iedu.xsd";
//	
//	public static final String COMPLEMENTO_VENTA_VEHICULOS_XSD = "https://pginvoice.com/srfe/cfd/ventavehiculos/ventavehiculos.xsd";
//	
//	
//	public static final String COMPLEMENTO_NOTARIOS_PUBLICOS = "https://pginvoice.com/srfe/cfd/notariosPublicos/notariospublicos.xsd";
//
//	public static final String COMPLEMENTO_VALES_DESPENSA = "https://pginvoice.com/srfe/cfd/valesdedespensa/valesdedespensa.xsd";
	
	/**Complementos para v3.3**/
	public static final String URL_CFDV3_3_XSD = "http://127.0.0.1:8080/RecepcionFacturaElectronica/cfd/ver_3_3/cfdv33.xsd";
	protected static final String BASE_CONTEXT_CFDv3_3 = "com.infra.factura.business.cfdi.iii.schema";
	protected static final String XSLTv3_3 = "/xslt/cadenaoriginal_3_3.xslt";	
    protected static final String XSDv3_3 = "/xsd/v3/cfdv33.xsd";
    protected static final String XSD_TFDv11 = "/xsd/v3/TimbreFiscalDigitalv11.xsd";
	protected static final String XSD_CAT_CFDI = "/xsd/cfd/catalogos/catCFDI.xsd";
	protected static final String XSD_T_CFDI = "/xsd/cfd/catalogos/tdCFDI.xsd";
	protected static final String XSD_CAT_PAGOS = "/xsd/cfd/catalogos/catPagos.xsd";
	protected static final String XSD_CAT_COM_EXT = "/xsd/cfd/catalogos/catComExt.xsd";
    protected static final String XSD_PAGOS = "/xsd/cfd/pagos/Pagos10.xsd";
	protected static final String XSD_COMERCIO_EXTERIOR11 = "/xsd/cfd/ComercioExterior/ComercioExterior11.xsd";
	protected static final String XSD_DONAT2 = "/xsd/cfd/donat/donat11.xsd";
	//protected static final String XSD_DIVISAS = "/xsd/cfd/divisas/divisas.xsd";
	//protected static final String XSD_IMPLOCAL = "/xsd/cfd/implocal/implocal.xsd";
	protected static final String XSD_LEYENDAS_FISCALES = "/xsd/cfd/leyendasFiscales/leyendasFisc.xsd";
	protected static final String XSD_PFIC = "/xsd/cfd/pfic/pfic.xsd";
	//protected static final String XSD_TURISTAPASAJEROEXTRANJERO = "/xsd/cfd/TuristaPasajeroExtranjero/TuristaPasajeroExtranjero.xsd";
	protected static final String XSD_VENTA_VEHICULOS11 = "/xsd/cfd/ventavehiculos/ventavehiculos11.xsd";
	protected static final String XSD_SPEI = "/xsd/cfd/spei/spei.xsd";
	//protected static final String XSD_DETALLISTA = "/xsd/cfd/detallista/detallista.xsd";
	protected static final String XSD_REGISTRO_FISCAL = "/xsd/cfd/cfdiregistrofiscal/cfdiregistrofiscal.xsd";
	protected static final String XSD_NOMINA11 = "/xsd/cfd/nomina/nomina11.xsd";
	protected static final String XSD_PAGO_ESPECIES = "/xsd/cfd/pagoenespecie/pagoenespecie.xsd";
	protected static final String XSD_VALES_DESPENSA = "/xsd/cfd/valesdedespensa/valesdedespensa.xsd";
	protected static final String XSD_CONSUMO_COMBUSTIBLES = "/xsd/cfd/consumodecombustibles/consumodecombustibles.xsd";
	protected static final String XSD_AEROLINEA = "/xsd/cfd/aerolineas/aerolineas.xsd";
	protected static final String XSD_NOTARIOS_PUBLICOS = "/xsd/cfd/notariosPublicos/notariospublicos.xsd";
	protected static final String XSD_VEHICULO_USADO = "/xsd/cfd/vehiculousado/vehiculousado.xsd";
	protected static final String XSD_SERVICIO_PARCIAL_CONSTRUCCION = "/xsd/cfd/servicioparcialconstruccion/servicioparcialconstruccion.xsd";
	protected static final String XSD_RENOVACION_SUSTITUCION_VEHICULOS = "/xsd/cfd/renovacionysustitucionvehiculos/renovacionysustitucionvehiculos.xsd";
	protected static final String XSD_CDESTRUCCION = "/xsd/cfd/certificadodedestruccion/certificadodedestruccion.xsd";
	protected static final String XSD_OBRAS_ANTIGUEDADES = "/xsd/cfd/obrasarteantiguedades/obrasarteantiguedades.xsd";
	protected static final String XSD_INE = "/xsd/cfd/ine/ine11.xsd";
	protected static final String XSD_ECC_11 = "/xsd/cfd/EstadoDeCuentaCombustible/ecc11.xsd";
	//protected static final String XSD_TERCEROS11 = "/xsd/cfd/terceros/terceros11.xsd";
	/****/
	
	protected final static Joiner JOINER = Joiner.on(':');

	protected final JAXBContext context;

	protected final Object document;

	protected String xmlDocument;

	protected TransformerFactory tf;

	protected CFDVersion version;

	private GenericCFD() {
		this.version = null;
		this.context = null;
		this.document = null;
	}
	
	/**Versión 3.3**/
//	public GenericCFD(com.infra.factura.business.cfdi.iii.schema.Comprobante comprobante,
//			String... contexts) throws Exception {
//		this.context = getContext(CFDVersion.getVersionByNumber(comprobante.getVersion()),contexts);
//		this.document = comprobante;
//	}
	
	public GenericCFD(CFDVersion version, InputStream in, String... contexts)
			throws Exception {
		this.version = version;
		this.context = getContext(version,contexts);
		this.document = load(version, in);
	}
	
	
	public GenericCFD(CFDVersion version, String xmlString, String... contexts)
			throws Exception {
		this.version = version;
		this.context = getContext(version,contexts);
		this.document = load(version, xmlString);
	}

	public GenericCFD(com.infra.factura.business.cfd.schema.Comprobante comprobante,
			String... contexts) throws Exception {
		this.context = getContext(CFDVersion.getVersionByNumber(comprobante.getVersion()),contexts);
		this.document = comprobante;
	}

	public GenericCFD(com.infra.factura.business.cfdi.schema.Comprobante comprobante,
			String... contexts) throws Exception {
		this.context = getContext(CFDVersion.getVersionByNumber(comprobante.getVersion()),contexts);
//		this.document = copy(comprobante, this.context);
		this.document = comprobante;
	}

	public GenericCFD(com.infra.factura.business.cfd.ii.schema.Comprobante comprobante,
			String... contexts) throws Exception {
		this.context = getContext(CFDVersion.getVersionByNumber(comprobante.getVersion()),contexts);
		this.document = comprobante;
	}

//	public GenericCFD(com.infra.factura.business.cfdi.ii.schema.Comprobante comprobante,
//			String... contexts) throws Exception {
//		this.context = getContext(CFDVersion.getVersionByNumber(comprobante.getVersion()),contexts);
////		this.document = copy(comprobante, this.context);
//		this.document = comprobante;
//	}
	

	protected static JAXBContext getContext(CFDVersion version, String[] contexts) throws Exception {
		String[] extraContexts = Arrays.copyOf(contexts, contexts.length +2);
		if(version.equals(CFDVersion.CFDv2_2) || version.equals(CFDVersion.CFDv3_2)){
			extraContexts[extraContexts.length - 2] = BASE_CONTEXT_CFDv2_2;
			extraContexts[extraContexts.length - 1] = BASE_CONTEXT_CFDv3_2;
		}else if(version.equals(CFDVersion.CFDv3_3)){
			extraContexts[extraContexts.length - 2] = BASE_CONTEXT_CFDv2_2;
			extraContexts[extraContexts.length - 1] = BASE_CONTEXT_CFDv3_3;
		}else{
			extraContexts[extraContexts.length - 2] = BASE_CONTEXT_CFDv2;
			extraContexts[extraContexts.length - 1] = BASE_CONTEXT_CFDv3;
		}
		List<String> ctx =null;
		if(version.equals(CFDVersion.CFDv3_3)){
			ctx = Lists.asList(BASE_CONTEXT_TFDv1_1, extraContexts);
		}else{
			ctx = Lists.asList(BASE_CONTEXT_TFDv3, extraContexts);
		}
		return JAXBContext.newInstance(JOINER.join(ctx));
	}

	protected static Object load(CFDVersion version, String xmlString,
			String... contexts) throws Exception {
            
		JAXBContext context = getContext(version,contexts);
		
		StreamSource streamSource = new StreamSource(new StringReader(xmlString));
		
		Unmarshaller u = context.createUnmarshaller();
		Object comprobanteUnmarshaled = null;
		switch (version) {
			/*case CFDv2:
				comprobanteUnmarshaled = (com.infra.factura.business.cfd.schema.Comprobante) u
						.unmarshal(in);
				break;
			case CFDv3:
				comprobanteUnmarshaled = (com.infra.factura.business.cfdi.schema.Comprobante) u
						.unmarshal(in);
				break;
			case CFDv2_2:
				comprobanteUnmarshaled = (com.infra.factura.business.cfd.ii.schema.Comprobante) u
				.unmarshal(in);
				break;*/
//			case CFDv3_2:                            
//				comprobanteUnmarshaled = (com.infra.factura.business.cfdi.ii.schema.Comprobante) u
//						.unmarshal(streamSource);
//				break;
			default:
				break;
		}
		
		return comprobanteUnmarshaled;
	}
	
	protected static Object load(CFDVersion version, InputStream in,
			String... contexts) throws Exception {
		JAXBContext context = getContext(version,contexts);
		try {
			if(!(in instanceof FileInputStream)){
				in.reset();
			}
		} catch (IOException e) {
			throw new Exception("Error al reprocesar el InputStream del XML", e);
		}
		try {
			System.out.println("Version en unmarshall "+version);
			Unmarshaller u = context.createUnmarshaller();
			Object comprobanteUnmarshaled = null;
			switch (version) {
			case CFDv2:
				comprobanteUnmarshaled = (com.infra.factura.business.cfd.schema.Comprobante) u
						.unmarshal(in);
				break;
			case CFDv3:
				comprobanteUnmarshaled = (com.infra.factura.business.cfdi.schema.Comprobante) u
						.unmarshal(in);
				break;
			case CFDv2_2:
				comprobanteUnmarshaled = (com.infra.factura.business.cfd.ii.schema.Comprobante) u
				.unmarshal(in);
				break;
//			case CFDv3_2:
//				comprobanteUnmarshaled = (com.infra.factura.business.cfdi.ii.schema.Comprobante) u
//						.unmarshal(in);
//				break;
//			case CFDv3_3:
//				comprobanteUnmarshaled = (com.infra.factura.business.cfdi.iii.schema.Comprobante) u
//				.unmarshal(in);
//				break;
			default:
				break;
			}
			return comprobanteUnmarshaled;
		} finally {
			in.close();
		}
	}

	// Defensive deep-copy
	protected static Object copy(Object comprobante, JAXBContext context)
			throws Exception {
		Object comprobanteUnmarshaled = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		Marshaller m = context.createMarshaller();
		m.marshal(comprobante, doc);
		Unmarshaller u = context.createUnmarshaller();
		if (comprobante instanceof com.infra.factura.business.cfd.schema.Comprobante) {
			comprobanteUnmarshaled = (com.infra.factura.business.cfd.schema.Comprobante) u
					.unmarshal(doc);
		}else if (comprobante instanceof com.infra.factura.business.cfdi.schema.Comprobante) {
			comprobanteUnmarshaled = (com.infra.factura.business.cfdi.schema.Comprobante) u
					.unmarshal(doc);
		}else if (comprobante instanceof com.infra.factura.business.cfd.ii.schema.Comprobante) {
			comprobanteUnmarshaled = (com.infra.factura.business.cfd.ii.schema.Comprobante) u
			.unmarshal(doc);
//		}else if (comprobante instanceof com.infra.factura.business.cfdi.ii.schema.Comprobante) {
//			comprobanteUnmarshaled = (com.infra.factura.business.cfdi.ii.schema.Comprobante) u
//					.unmarshal(doc);
//		}else if (comprobante instanceof com.infra.factura.business.cfdi.iii.schema.Comprobante) {
//			comprobanteUnmarshaled = (com.infra.factura.business.cfdi.iii.schema.Comprobante) u
//					.unmarshal(doc);
		}


		return comprobanteUnmarshaled;
	}

	protected byte[] getOriginalBytes(String locationXSLT) throws Exception {
		JAXBSource in = new JAXBSource(context, document);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Result out = new StreamResult(baos);
		TransformerFactory factory = tf;
		if (factory == null) {
			factory = TransformerFactory.newInstance();
			factory.setURIResolver(new URIResolverImpl());
		}
		System.out.println("XSLT "+locationXSLT);
		Transformer transformer = factory.newTransformer(new StreamSource(
				getClass().getResourceAsStream(locationXSLT)));
		transformer.transform(in, out);
		
//		String cadenaOri = new String(baos.toByteArray());
		String cadenaOri = baos.toString("UTF8");
		cadenaOri = cadenaOri.replaceAll("\r\n", "");
		cadenaOri = cadenaOri.replaceAll("\n", "");
		cadenaOri = cadenaOri.replaceAll("\t", "");
		cadenaOri = StringAndInputstreamUtil.convertUnicodeEscape(cadenaOri);
		return cadenaOri.getBytes("UTF8");
	}

	/*public static boolean isUTF8Encoding(String xmlInput) throws Exception {
		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
		InputStream input = new ByteArrayInputStream(xmlInput.getBytes());
		detector.add(JChardetFacade.getInstance());
		detector.add(new ParsingDetector(true));
		detector.add(ASCIIDetector.getInstance());
		detector.add(UnicodeDetector.getInstance());
		try {
			Charset charset = detector.detectCodepage(input, xmlInput.getBytes().length);
			if (!charset.name().equals("UTF-8")){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			throw new Exception(
					"Error en la validación de la codificación del CFD. Corrija el archivo e Intente nuevamente. Archivo:  "
							+ xmlInput + " Error: " + e.getMessage());
		}

	}*/

	public Object getDocument() {
		return document;
	}

	public String getXmlDocument() {
		return xmlDocument;
	}

	public void setXmlDocument(String xmlDocument) {
		this.xmlDocument = xmlDocument;
	}

}
