package com.infra.factura.xml;

/*import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDVersion;
import com.infra.factura.dto.FeArchivoSoporteDto;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.xerces.dom.DocumentImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
*/
public class FeAs2Xml {
	/*static Logger logger = Logger.getLogger(FeAs2Xml.class);

	public static final String XML_RAIZ = "Recepcion";
	public static final String XML_ATRIBUTO_FECHA_RECEPCION = "fecha";
	public static final String XML_ATRIBUTO_TIPO_COMPROBANTE = "tipo";
	public static final String XML_ELEMENTO_FACTURA = "factura";
	public static final String XML_ELEMENTO_CBB = "cbb";
	public static final String XML_ATRIBUTO_NUMERO_FACTURA = "numero";
	public static final String XML_ATRIBUTO_SAP_BOX = "sapBox";
	public static final String XML_ELEMENTO_PDF_GENERADO = "PdfGenerado";
	public static final String XML_ELEMENTO_PDF_RECIBIDO = "PfdRecibido";
	public static final String XML_ELEMENTO_ARCHIVO = "archivo";
	public static final String XML_ATRIBUTO_NOMBRE_ARCHIVO = "nombre";
	public static final String XML_ELEMENTO_CONTENIDO_ARCHIVO = "contenido";

	public enum TipoElementoXML {
		facturaXML, PDFGenerado, PDFRecibido;
	};

	public static String generar(String[] numFacturaSapBox, CFDVersion version, String xmlFactura,
			Map<TipoElementoXML, FeArchivoSoporteDto> archivosSoporte) {
		// OutputFormat format = null;
		StringWriter stringOut = null;
		Document doc = new DocumentImpl();
		// Create Root Element
		Element root = doc.createElement(XML_RAIZ);
		Element factura = null;
		Element pdfGenerado = null;
		Element pdfRecibido = null;
		Element cbb = null;
		switch (version) {
		case CFDv2_2:
		case CFDv2:
			root.setAttribute(XML_ATRIBUTO_TIPO_COMPROBANTE,"CFD");
			break;
		case CFDv3_2:
		case CFDv3:
			root.setAttribute(XML_ATRIBUTO_TIPO_COMPROBANTE,"CFDI");
			break;
		case CBB:
			root.setAttribute(XML_ATRIBUTO_TIPO_COMPROBANTE,"CBB");
			break;
		default:
			break;
		}
		
		root.setAttribute(XML_ATRIBUTO_FECHA_RECEPCION, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));

		// Create 2nd level Element and attach to the Root Element
		factura = doc.createElement(XML_ELEMENTO_FACTURA);
		cbb = doc.createElement(XML_ELEMENTO_CBB);

		try {
			factura.setAttribute(XML_ATRIBUTO_NUMERO_FACTURA, numFacturaSapBox[0]);
			factura.setAttribute(XML_ATRIBUTO_SAP_BOX, numFacturaSapBox[1]);
			cbb.setAttribute(XML_ATRIBUTO_NUMERO_FACTURA, numFacturaSapBox[0]);
			cbb.setAttribute(XML_ATRIBUTO_SAP_BOX, numFacturaSapBox[1]);
			
			String encodeBase64String = "";
			if(version.compareTo(CFDVersion.CBB) == 0){
				xmlFactura=xmlFactura.toString().replaceFirst("d&amp;eacute;bito", "d&eacute;bito");
				xmlFactura=xmlFactura.toString().replaceFirst("cr&amp;eacute;dito", "cr&eacute;dito");
				encodeBase64String = com.infra.factura.util.Base64.encodeBase64String(xmlFactura.getBytes());
				factura.appendChild(doc.createTextNode(""));
				cbb.appendChild(doc.createTextNode(encodeBase64String));
			}else{
				encodeBase64String = Base64.encodeBase64String(xmlFactura.getBytes());
				factura.appendChild(doc.createTextNode(encodeBase64String));
				cbb.appendChild(doc.createTextNode(""));
			}
			
			// Create one more Element
			pdfGenerado = doc.createElement(XML_ELEMENTO_PDF_GENERADO);
			pdfRecibido = doc.createElement(XML_ELEMENTO_PDF_RECIBIDO);
			Element contenido = null;
			Element archivo = null;

			if(archivosSoporte != null){
				// Create 3rd level from list with two attributes
				for (TipoElementoXML archivoKey : archivosSoporte.keySet()) {
					
					// Create the second element for 3rd level
					contenido = doc.createElement(XML_ELEMENTO_CONTENIDO_ARCHIVO);
					contenido.appendChild(doc.createTextNode(Base64.encodeBase64String(archivosSoporte.get(archivoKey)
									.getContenido())));
					// Create the first element for 3rd level
					archivo = doc.createElement(XML_ELEMENTO_ARCHIVO);
					archivo.setAttribute(XML_ATRIBUTO_NOMBRE_ARCHIVO,
							archivosSoporte.get(archivoKey).getNombre());
					archivo.appendChild(contenido);
					// Add the new element on parent tag
					switch (archivoKey) {
					case PDFGenerado:
						pdfGenerado.appendChild(archivo);
						break;
					case PDFRecibido:
						pdfRecibido.appendChild(archivo);
						break;
					default:
						break;
					}
					archivo = null;
					contenido = null;
				}
			}else{
				contenido = doc.createElement(XML_ELEMENTO_CONTENIDO_ARCHIVO);
				contenido.appendChild(doc.createTextNode(""));
				archivo = doc.createElement(XML_ELEMENTO_ARCHIVO);
				archivo.setAttribute(XML_ATRIBUTO_NOMBRE_ARCHIVO,"");
				archivo.appendChild(contenido);
				pdfGenerado.appendChild(archivo);

				contenido = doc.createElement(XML_ELEMENTO_CONTENIDO_ARCHIVO);
				contenido.appendChild(doc.createTextNode(""));
				archivo = doc.createElement(XML_ELEMENTO_ARCHIVO);
				archivo.setAttribute(XML_ATRIBUTO_NOMBRE_ARCHIVO,"");
				archivo.appendChild(contenido);
				pdfRecibido.appendChild(archivo);
			}
				
			root.appendChild(factura);
			root.appendChild(pdfGenerado);
			root.appendChild(pdfRecibido);
			root.appendChild(cbb);

			// Add the Root Element to Document
			doc.appendChild(root);

			stringOut = new StringWriter();
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			transformerFactory.setAttribute("indent-number", 4);
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(stringOut);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			doc = null;
			root = null;
			factura = null;
			pdfGenerado = null;
			pdfRecibido = null;
		}
		String regresa = stringOut.toString().replaceFirst("encoding=\"\"", "encoding=\"UTF-8\"");
		// Display the XML
		return regresa;
	}
*/
//	public static void main(String[] args) {
//		final File archivoPdf = new File("/Users/Prospectiva/Desktop/pruebaVolumenP&G/TemplateCFDv3.pdf");
//		final String pathname = "/Users/Prospectiva/Desktop/pruebaVolumenP&G/Vx0/CFDi/";
//		File[] files = new File(pathname).listFiles();
//	    for (File file : files) {
//	    	String nombreArchivo = file.getName().substring(0,file.getName().lastIndexOf("."));
//			File archivoPdfGenerado = new File(file.getParent() + "/" + nombreArchivo + ".pdf");
//			FeArchivoSoporteDto dto = new FeArchivoSoporteDto();
//			Map<TipoElementoXML, FeArchivoSoporteDto> archivosFactura = new HashMap<TipoElementoXML, FeArchivoSoporteDto>();
//			InputStream is = null;
//			Writer output = null;
//			byte[] dataByteArray = null;
//			dto.setNombre(nombreArchivo + ".pdf");
//			try {
//				is = new FileInputStream(archivoPdfGenerado);
//				dataByteArray = new byte[(int) archivoPdfGenerado.length()];
//				
//				is.read(dataByteArray, 0, (int) archivoPdfGenerado.length());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			dto.setContenido(dataByteArray);
//			archivosFactura.put(TipoElementoXML.PDFGenerado, dto);
//			
//			dto = new FeArchivoSoporteDto();
//			dto.setNombre("archivoSoportePdf.pdf");
//			try {
//				is = new FileInputStream(archivoPdf);
//				dataByteArray = new byte[(int) archivoPdf.length()];
//				
//				is.read(dataByteArray, 0, (int) archivoPdf.length());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			dto.setContenido(dataByteArray);
//			archivosFactura.put(TipoElementoXML.PDFRecibido, dto);
//			
//			is = null;
//			dataByteArray = null;
//			try {
//				is = new FileInputStream(file);
//				dataByteArray = new byte[(int) file.length()];
//				
//				is.read(dataByteArray, 0, (int) file.length());
//				
//				file = new File(pathname + nombreArchivo.replaceAll("cfdi", "") + ".xml");
//				output = new BufferedWriter(new FileWriter(file));
//				
//				output.write(generar(new String[]{nombreArchivo,"G4A"},CFDVersion.CFDv3, new String(dataByteArray,"UTF-8"), archivosFactura));
//				output.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			dto = null;
//			archivosFactura = null;
//			file = null;
//			is = null;
//			output = null;
//			dataByteArray = null;
//			
//		}
//	}

//	public static void main(String[] args) {
//		final String pathname = "/Users/Prospectiva/Desktop/pruebaVolumenP&G/Vx0/CBB/";
//		File[] files = new File(pathname).listFiles();
//	    for (File file : files) {
//	    	String nombreArchivo = file.getName().substring(0,file.getName().lastIndexOf("."));
//			InputStream is = null;
//			Writer output = null;
//			byte[] dataByteArray = null;
//			
//			is = null;
//			dataByteArray = null;
//			try {
//				is = new FileInputStream(file);
//				dataByteArray = new byte[(int) file.length()];
//				
//				is.read(dataByteArray, 0, (int) file.length());
//				
//				file = new File(pathname + nombreArchivo.replaceAll("cbb", "") + "CBB.xml");
//				output = new BufferedWriter(new FileWriter(file));
//				
//				final String xmlToAS2 = new String(dataByteArray,"UTF-8");
//				output.write(generar(new String[]{nombreArchivo,"G4A"},CFDVersion.CBB, xmlToAS2, null));
//				output.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			file = null;
//			is = null;
//			output = null;
//			dataByteArray = null;
//			
//		}
//	}
}
