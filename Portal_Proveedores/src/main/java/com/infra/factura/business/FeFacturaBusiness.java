package com.infra.factura.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.infra.factura.business.base.FeBaseBusiness;
import com.infra.factura.dto.RespuestaPACDto;
import com.infra.factura.dto.ValidacionDto;
import com.infra.factura.dto.ValidacionPACDto;
import com.infra.factura.util.Base64;  

/**
 * Clase para manejo de negocio en el modulo de facturas
 * 
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Component
public class FeFacturaBusiness extends FeBaseBusiness {
	private final static Logger LOGGER = Logger.getLogger(FeFacturaBusiness.class);

	private final static ResourceBundle resources = ResourceBundle.getBundle("wsdl/wsdl");
	//private static final String URL = "https://web-service.com.mx/infra/read-xml";
	private static final String URL = "https://web-service.com.mx/qa/xml__read";
	private static final String VALIDO = "XML Válido";
	private static final String INVALIDO = "XML Inválido";

	public RespuestaPACDto validarXML(String base64Archivo) throws IOException {
		RespuestaPACDto dtoRespuesta = new RespuestaPACDto();

		if ("SI".equals(resources.getString("en_pruebas"))) {
			dtoRespuesta.setValido(true);
			return dtoRespuesta;
		}
		// System.out.println("base64Archivo: "+base64Archivo);
		//MOD MARZO 2022
//		 try {
			 
		 
		LOGGER.info("validarXML inicia" + new SimpleDateFormat("dd/MM/yyyHH:mm:ss").format(new Date())); 
		URL url = new URL(resources.getString("url_pac")); 

		byte[] xml = Base64.decodeBase64(base64Archivo);
		
		//Modificado marzo 2022
		//LOGGER.info("BASE64 respuesta" + base64Archivo);
		byte[] bytesXml2 = Base64.decodeBase64(base64Archivo);
		String cadenaXml2 = new String(bytesXml2);
		LOGGER.info("BASE64 respuesta" + cadenaXml2);
		
		
		Map<String, Object> params = new LinkedHashMap<>();
		LOGGER.info("ENTRA Object params");
		params.put("user", Base64.encodeBase64String(resources.getString("user_pac").getBytes()));
		LOGGER.info("ENTRA user_pac");
		params.put("password", Base64.encodeBase64String(resources.getString("password_pac").getBytes()));
		LOGGER.info("ENTRA password_pac");
		params.put("xml_content", Base64.encodeBase64String(xml));
		// System.out.println("como se va: "+Base64.encodeBase64String(xml));
		
		byte[] bytesXml3 = Base64.decodeBase64(xml);
		String cadenaXml3 = new String(bytesXml3);
		LOGGER.info("BASE64 respuesta" + cadenaXml3);
		LOGGER.info("como se va: "+Base64.encodeBase64String(xml));
		
		
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');

			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		}
		
		
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		LOGGER.info("ENTRA postdatbtes" + postDataBytes);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		
		conn.setDoOutput(true);
		conn.getOutputStream().write(postDataBytes);
		LOGGER.info("ENTRA postdatbtes" + postDataBytes);
		
		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		StringBuilder data = new StringBuilder();
		LOGGER.info("ENTRA data" + data);
		LOGGER.info("Entra vacio DATA");
		String respuesta2 = data.toString();
		LOGGER.info("ENTRA respuesta" + respuesta2);
		for (int c; (c = in.read()) >= 0;) {
			data.append((char) c);
		}
		String respuesta = data.toString();
		LOGGER.info("ENTRA respuesta" + respuesta);
		 
		
		LOGGER.info("validarXML respuesta" + respuesta);
		// System.out.println("Respuesta: " + respuesta);
		byte[] bytesXml = Base64.decodeBase64(respuesta);
		String cadenaXml = new String(bytesXml);
		dtoRespuesta = procesaRespuesta(cadenaXml);
		conn.disconnect();
		LOGGER.info("validarXML termina" + new SimpleDateFormat("dd/MM/yyyHH:mm:ss").format(new Date()));
		
		//END TRY - CATCH MOD 2022
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// System.out.println("catch 1: " + e.getMessage());
		// } catch (ProtocolException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// System.out.println("catch 2: " + e.getMessage());
//		 } catch (IOException e) {
//		// // TODO Auto-generated catch block
//		 e.printStackTrace();
//		
		// System.out.println("catch 3: " + e.getMessage()); 
//		 }
//		 catch (Exception e) {  
//		 }
		return dtoRespuesta;
	}

	private RespuestaPACDto procesaRespuesta(String cadenaRespuesta) {
		Gson gson = new Gson();
		RespuestaPACDto pac = gson.fromJson(cadenaRespuesta, RespuestaPACDto.class);

		ValidacionDto valPac = pac.getValidaciones();

		JsonParser parser = new JsonParser();
		JsonElement element = (JsonElement) parser.parse(cadenaRespuesta);

		JsonObject object = element.getAsJsonObject();
		String validaciones = object.get("Validaciones").toString();
//Modificado febrero 28 2022
		System.out.println("validaciones: " + validaciones); 
		LOGGER.info("I am testing my logging");
        LOGGER.info("Here is an exception", new Exception());

		JsonElement elementValidaciones = (JsonElement) parser.parse(validaciones);
		JsonObject objectValidaciones = elementValidaciones.getAsJsonObject();

		JsonObject codigoPostal = objectValidaciones.get("Codigo postal").getAsJsonObject();
		JsonObject tipoComprobante = objectValidaciones.get("Tipo de comprobante").getAsJsonObject();
		JsonObject regimenFiscal = objectValidaciones.get("Regimen fiscal").getAsJsonObject();
		JsonObject rfcEmisor = objectValidaciones.get("RFC Emisor").getAsJsonObject();
		JsonObject rfcReceptor = objectValidaciones.get("RFC Receptor").getAsJsonObject();
		JsonObject usoCFDI = objectValidaciones.get("Uso CFDI").getAsJsonObject();
		JsonObject claveProducto = objectValidaciones.get("Clave de producto").getAsJsonObject();
		JsonObject metodoPago = objectValidaciones.get("Metodo de pago").getAsJsonObject();
		JsonObject formaPago = objectValidaciones.get("Forma de pago").getAsJsonObject();
		JsonObject claveUnidad = objectValidaciones.get("Clave de unidad").getAsJsonObject();
		JsonObject fechaEmision = objectValidaciones.get("Fecha de Emision").getAsJsonObject();
		JsonObject cadenaOriginal = objectValidaciones.get("Cadena Original").getAsJsonObject();
		JsonObject codificacionCadenaOriginal = objectValidaciones.get("Codificacion Cadena Original")
				.getAsJsonObject();
		JsonObject relMetodoForma = objectValidaciones.get("Relación Método - Forma").getAsJsonObject();

		valPac.setCodigoPostal(gson.fromJson(codigoPostal, ValidacionPACDto.class));
		valPac.setTipoComprobante(gson.fromJson(tipoComprobante, ValidacionPACDto.class));
		valPac.setRegimenFiscal(gson.fromJson(regimenFiscal, ValidacionPACDto.class));
		valPac.setRfcEmisor(gson.fromJson(rfcEmisor, ValidacionPACDto.class));
		valPac.setRfcReceptor(gson.fromJson(rfcReceptor, ValidacionPACDto.class));
		valPac.setUsoCfdi(gson.fromJson(usoCFDI, ValidacionPACDto.class));
		valPac.setClaveProducto(gson.fromJson(claveProducto, ValidacionPACDto.class));
		valPac.setMetodoPago(gson.fromJson(metodoPago, ValidacionPACDto.class));
		valPac.setFormaPago(gson.fromJson(formaPago, ValidacionPACDto.class));
		valPac.setClaveUnidad(gson.fromJson(claveUnidad, ValidacionPACDto.class));
		valPac.setFechaEmision(gson.fromJson(fechaEmision, ValidacionPACDto.class));
		valPac.setCadenaOriginal(gson.fromJson(cadenaOriginal, ValidacionPACDto.class));
		valPac.setCodificacionCadenaOriginal(gson.fromJson(codificacionCadenaOriginal, ValidacionPACDto.class));
		valPac.setRelacionMetodoForma(gson.fromJson(relMetodoForma, ValidacionPACDto.class));

		pac.setValido(VALIDO.equals(pac.getComentario()));

		StringBuilder msg = new StringBuilder();

		if (pac.getValidaciones().getXML() != null && !pac.getValidaciones().getXML().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getXML().getStatus()).append("|");
		}
		if (pac.getValidaciones().getVersion() != null && !pac.getValidaciones().getVersion().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getVersion().getStatus()).append("|");
		}
		if (pac.getValidaciones().getTipoComprobante() != null && !pac.getValidaciones().getTipoComprobante().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getTipoComprobante().getStatus()).append("|");
		}
		if (pac.getValidaciones().getCodigoPostal() != null && !pac.getValidaciones().getCodigoPostal().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getCodigoPostal().getStatus()).append("|");
		}
		if (pac.getValidaciones().getRegimenFiscal() != null && !pac.getValidaciones().getRegimenFiscal().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getRegimenFiscal().getStatus()).append("|");
		}
		if (pac.getValidaciones().getRfcEmisor() != null && !pac.getValidaciones().getRfcEmisor().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getRfcEmisor().getStatus()).append("|");
		}
		if (pac.getValidaciones().getRfcReceptor() != null && !pac.getValidaciones().getRfcReceptor().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getRfcReceptor().getStatus()).append("|");
		}
		if (pac.getValidaciones().getUsoCfdi() != null && !pac.getValidaciones().getUsoCfdi().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getUsoCfdi().getStatus()).append("|");
		}
		if (pac.getValidaciones().getClaveProducto() != null && !pac.getValidaciones().getClaveProducto().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getClaveProducto().getStatus()).append("|");
		}
		if (pac.getValidaciones().getMetodoPago() != null && !pac.getValidaciones().getMetodoPago().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getMetodoPago().getStatus()).append("|");
		}
		if (pac.getValidaciones().getFormaPago() != null && !pac.getValidaciones().getFormaPago().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getFormaPago().getStatus()).append("|");
		}
		if (pac.getValidaciones().getMoneda() != null && !pac.getValidaciones().getMoneda().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getMoneda().getStatus()).append("|");
		}
		if (pac.getValidaciones().getClaveUnidad() != null && !pac.getValidaciones().getClaveUnidad().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getClaveUnidad().getStatus()).append("|");
		}
//		if (pac.getValidaciones().getListaNegra() != null && !pac.getValidaciones().getListaNegra().getValidacion().equals("0")) {
//			msg.append("|").append(pac.getValidaciones().getListaNegra().getStatus()).append("|");
//		}
//		if (pac.getValidaciones().getLista69b() != null && !pac.getValidaciones().getLista69b().getValidacion().equals("0")) {
//			msg.append("|").append(pac.getValidaciones().getLista69b().getStatus()).append("|");
//		}
		if (pac.getValidaciones().getDuplicidad() != null && !pac.getValidaciones().getDuplicidad().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getDuplicidad().getStatus()).append("|");
		}
		if (pac.getValidaciones().getLegibilidad() != null && !pac.getValidaciones().getLegibilidad().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getLegibilidad().getStatus()).append("|");
		}
		if (pac.getValidaciones().getEncabezado() != null && !pac.getValidaciones().getEncabezado().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getEncabezado().getStatus()).append("|");
		}
		if (pac.getValidaciones().getVigencia() != null && !pac.getValidaciones().getVigencia().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getVigencia().getStatus()).append("|");
		}
		if (pac.getValidaciones().getFechaEmision() != null && !pac.getValidaciones().getFechaEmision().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getFechaEmision().getStatus()).append("|");
		}
		if (pac.getValidaciones().getCadenaOriginal() != null && !pac.getValidaciones().getCadenaOriginal().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getCadenaOriginal().getStatus()).append("|");
		}
		if (pac.getValidaciones().getRelacionMetodoForma() != null && !pac.getValidaciones().getRelacionMetodoForma().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getRelacionMetodoForma().getStatus()).append("|");
		}
		if (pac.getValidaciones().getImportes() != null && !pac.getValidaciones().getImportes().getValidacion().equals("0")) {
			msg.append("|").append(pac.getValidaciones().getImportes().getStatus()).append("|");
		}
		
		if(msg.toString().isEmpty()){
			msg.append("|").append(pac.getComentario()).append("|");
		}
		
		pac.setErrores(msg.toString());
		pac.setValidaciones(valPac);
		return pac;
	}

}
