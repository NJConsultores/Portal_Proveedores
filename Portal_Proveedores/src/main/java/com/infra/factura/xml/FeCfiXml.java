package com.infra.factura.xml;

/*import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.infra.factura.dto.html.FeCfiDtoHtml;

import org.apache.xerces.dom.DocumentImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.zxing.FormatException;*/

public class FeCfiXml {
	/*public static final String XML_RAIZ = "CbbCfi";
	public static final String XML_ATRIBUTO_RFC_PROVEEDOR = "rfcProveedor";
	public static final String XML_ATRIBUTO_NUMERO_APROBACION = "numAprobacion";
	public static final String XML_ATRIBUTO_FOLIO = "folio";
	public static final String XML_ATRIBUTO_SERIE = "serie";
	public static final String XML_ATRIBUTO_TIPO_DOCUMENTO = "tipoDocumento";
	public static final String XML_ATRIBUTO_FOLIO_INCIAL = "folioInicial";
	public static final String XML_ATRIBUTO_FOLIO_FINAL = "folioFinal";
	public static final String XML_ATRIBUTO_FECHA_ASIGNACION = "fechaAsignacion";
	public static final String XML_ATRIBUTO_VIGENCIA = "vigencia";
	public static final String XML_ELEMENTO_RESULTADO_VALIDACION = "resultadoValidacion";
	public static final String XML_ATRIBUTO_DOC_TYPE = "docType";
	public static final String XML_ATRIBUTO_INVOICE_TYPE = "invoiceType";
	public static final String XML_ATRIBUTO_MM_INDEX = "mmIndex";
	public static final String XML_ATRIBUTO_COMMENTS = "comments";

	public static String generar(FeCfiDtoHtml cfiDto) throws Exception {
		if(null == cfiDto){
			throw new Exception("CFI DTO es nulo");
		}
		
		Document doc = new DocumentImpl();

		Element root = doc.createElement(XML_RAIZ);
		root.setAttribute(XML_ATRIBUTO_RFC_PROVEEDOR, cfiDto.getRfcProveedor() == null ? "" : cfiDto.getRfcProveedor());
		root.setAttribute(XML_ATRIBUTO_NUMERO_APROBACION, cfiDto.getNumAprobacion() == null ? "" : cfiDto.getNumAprobacion());
		root.setAttribute(XML_ATRIBUTO_FOLIO, String.valueOf(cfiDto.getFolio() == 0 ? "" : cfiDto.getFolio()));
		root.setAttribute(XML_ATRIBUTO_SERIE, cfiDto.getSerie() == null ? "" : cfiDto.getSerie());
		root.setAttribute(XML_ATRIBUTO_TIPO_DOCUMENTO, cfiDto.getDocumento() == null ? "" : cfiDto.getDocumento());
		root.setAttribute(XML_ATRIBUTO_FOLIO_INCIAL, cfiDto.getFolioInicial() == null ? "" : cfiDto.getFolioInicial());
		root.setAttribute(XML_ATRIBUTO_FOLIO_FINAL, cfiDto.getFolioFinal() == null ? "" : cfiDto.getFolioFinal());
		root.setAttribute(XML_ATRIBUTO_FECHA_ASIGNACION, cfiDto.getFechaAsignacion() == null ? "" : cfiDto.getFechaAsignacion());
		root.setAttribute(XML_ATRIBUTO_VIGENCIA, cfiDto.getVigencia() == null ? "" : cfiDto.getVigencia());
		root.setAttribute(XML_ATRIBUTO_DOC_TYPE, cfiDto.getDocType() == null ? "" : cfiDto.getDocType());
		root.setAttribute(XML_ATRIBUTO_INVOICE_TYPE, cfiDto.getInvoiceType() == null ? "" : (cfiDto.getInvoiceType().equals("TMS") ? "MM" : cfiDto.getInvoiceType()));
		root.setAttribute(XML_ATRIBUTO_MM_INDEX, cfiDto.getMmIndex() == null ? "" : cfiDto.getMmIndex());
		root.setAttribute(XML_ATRIBUTO_COMMENTS, cfiDto.getComment() == null ? "" : cfiDto.getComment());

		Element resultado = doc.createElement(XML_ELEMENTO_RESULTADO_VALIDACION);

		resultado.appendChild(doc.createTextNode(cfiDto.getResultado()));
		root.appendChild(resultado);
		doc.appendChild(root);

		StringWriter stringOut                = new StringWriter();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer               = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		DOMSource source                      = new DOMSource(doc);
		StreamResult result                   = new StreamResult(stringOut);
		
		try{
			transformer.transform(source, result);
		}catch (NullPointerException e) {
			try {
				throw FormatException.getFormatInstance().initCause(new Exception("No se pudo generar el CfiXML, existen elementos vacíos."));
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}

		return stringOut.toString();
	}*/
}
