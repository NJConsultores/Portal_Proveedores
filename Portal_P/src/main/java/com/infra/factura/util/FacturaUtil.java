/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.factura.util;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase utilidad para generar el PDF
 * 
 * @author rlagunas
 */
public class FacturaUtil {

	public static byte[] generarPDF(InputStream xml) throws Exception {

		if (xml != null) {

		}

		return null;
	}

	// public static String removerAddenda(String xml) {
	// String xmlSinAddenda = new String(xml);
	// final Pattern pattern = Pattern.compile(
	// ConstantesGenerales.CFDI_ADDENDA_START_TAG + "(.+?)" +
	// ConstantesGenerales.CFDI_ADDENDA_END_TAG);
	//
	// xml.replaceFirst(regex, replacement)
	//
	// String addenda = xml.su
	//
	//
	// return xmlSinAddenda.trim();
	// }

	public static String removerAddenda(String xml) {
		String xmlSinAddenda = new String(xml);
		final Pattern pattern = Pattern.compile(
				ConstantesGenerales.CFDI_ADDENDA_START_TAG + "(.+?)" + ConstantesGenerales.CFDI_ADDENDA_END_TAG);
		final Matcher matcher = pattern.matcher(xml);

		try {
			if (matcher.find()) {
				xmlSinAddenda = xml.replaceFirst(
						ConstantesGenerales.CFDI_ADDENDA_START_TAG + "(.+?)" + ConstantesGenerales.CFDI_ADDENDA_END_TAG,
						"");
			} else {
				xmlSinAddenda = xml.replaceFirst(ConstantesGenerales.CFDI_ADDENDA_TAG, "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xmlSinAddenda.trim();
	}

	// public static String removerAddenda(String xmlSellado) {
	// String xmlCFDISinAddenda = "";
	//
	// try {
	// xmlCFDISinAddenda = new
	// String(xmlSellado.getBytes(FeIConstantes.ENCODING_UTF8),
	// FeIConstantes.ENCODING_UTF8);
	// final Pattern patternAddenda = Pattern
	// .compile(FeIConstantes.CFDI_ADDENDA_START_TAG + "(.+?)" +
	// FeIConstantes.CFDI_ADDENDA_END_TAG);
	// final Matcher matcherAddenda = patternAddenda.matcher(xmlSellado);
	//
	// try {
	//// if (matcherAddenda.find()) {
	// xmlCFDISinAddenda = xmlSellado.replaceFirst(
	// FeIConstantes.CFDI_ADDENDA_START_TAG + "(.+?)" +
	// FeIConstantes.CFDI_ADDENDA_END_TAG, "");
	//// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return xmlCFDISinAddenda.trim();
	// }

	public static String extraerAddenda(String xml) {
		String xmlAddenda = null;
		final Pattern pattern = Pattern.compile(
				ConstantesGenerales.CFDI_ADDENDA_START_TAG + "(.+?)" + ConstantesGenerales.CFDI_ADDENDA_END_TAG);
		final Matcher matcher = pattern.matcher(xml);

		try {
			if (matcher.find()) {
				xmlAddenda = matcher.group(1).trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xmlAddenda;
	}

	public static String extraerPedimentos(String xml) {
		String xmlAddendaPedimentos = null;
		final Pattern pattern = Pattern.compile(ConstantesGenerales.CFDI_ADDENDA_PEDIMENTOS_START_TAG + "(.+?)"
				+ ConstantesGenerales.CFDI_ADDENDA_PEDIMENTOS_END_TAG);
		String xmlAddenda = extraerAddenda(xml);

		if (xmlAddenda != null) {
			final Matcher matcher = pattern.matcher(xmlAddenda);

			try {
				if (matcher.find()) {
					xmlAddendaPedimentos = ConstantesGenerales.CFDI_ADDENDA_PEDIMENTOS_START_TAG
							+ matcher.group(1).trim() + ConstantesGenerales.CFDI_ADDENDA_PEDIMENTOS_END_TAG;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return xmlAddendaPedimentos;
	}

//	public static String agregarAddendaAgenteAduanal(String xmlOriginal, String xmlAddenda) {
//		FeAddendaPedimentosDto addendaPedimentos = new FeAddendaPedimentosDto(xmlAddenda);
//		FeAddendaDto addenda = new FeAddendaDto();
//		String xmlConAddendaBocar = null;
//
//		if (xmlOriginal != null) {
//			if (xmlAddenda != null) {
//				addenda.setVersion(CFDVersion.CFDv3_2);
//				addenda.setTotal(BigDecimal.ZERO);
//				addenda.setTipoCliente(CFDTipo_Cliente.COC);
//				addenda.setNumeroPedido(addendaPedimentos.getPedimento());
//				try {
//					StringWriter sw = new StringWriter();
//					String CFD_NAMESPACE = GenericCFD.CFD_3_NAMESPACE;
//					ImmutableMap<String, String> PREFIXES = ImmutableMap.of("http://www.w3.org/2001/XMLSchema-instance",
//							"xsi", CFD_NAMESPACE, "cfdi");
//					JAXBContext jaxbContext = JAXBContext
//							.newInstance(com.infra.cliente.addenda.ObjectFactory.class.getPackage().getName());
//					com.infra.cliente.addenda.Addenda addendaV3 = (com.infra.cliente.addenda.Addenda) addenda
//							.getAddendaForXML();
//					Map<String, String> localPrefixes = Maps.newHashMap(PREFIXES);
//					Marshaller marshaller = jaxbContext.createMarshaller();
//					marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper",
//							new NamespacePrefixMapperImpl(localPrefixes));
//					marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//					marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
//					marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//					marshaller.marshal(addendaV3, sw);
//
//					xmlAddenda = sw.toString();
//					xmlOriginal = xmlOriginal.trim();
//					xmlOriginal = xmlOriginal.replaceAll("\r\n", " ");
//					xmlOriginal = xmlOriginal.replaceAll("\r", " ");
//					xmlOriginal = xmlOriginal.replaceAll("\n", " ");
//					xmlOriginal = xmlOriginal.replaceAll("\t", " ");
//					xmlOriginal = StringAndInputstreamUtil.convertUnicodeEscape(xmlOriginal);
//
//					if (xmlOriginal.contains(FeConstantesValidacion.CFDI_ADDENDA_EMPTY_TAG)
//							|| xmlOriginal.contains(FeConstantesValidacion.CFDI_ADDENDA_EMPTY_TAG_ALT)) {
//						xmlOriginal = xmlOriginal.replaceFirst(FeConstantesValidacion.CFDI_ADDENDA_EMPTY_TAG, "");
//						xmlOriginal = xmlOriginal.replaceFirst(FeConstantesValidacion.CFDI_ADDENDA_EMPTY_TAG_ALT, "");
//					}
//					final Pattern pattern1 = Pattern.compile(FeConstantesValidacion.CFDI_COMPLEMENTO_END_TAG
//							+ "[\\S\\s]*" + FeConstantesValidacion.CFDI_ADDENDA_START_TAG + "(.+?)"
//							+ FeConstantesValidacion.CFDI_ADDENDA_END_TAG);
//					final Matcher matcher1 = pattern1.matcher(xmlOriginal);
//					final Pattern pattern = Pattern.compile(FeConstantesValidacion.CFDI_ADDENDA_START_TAG + "(.+?)"
//							+ FeConstantesValidacion.CFDI_ADDENDA_END_TAG);
//					final Matcher matcher = pattern.matcher(xmlOriginal);
//
//					if (matcher1.find() && matcher.find()) {
//						xmlConAddendaBocar = matcher.replaceAll(xmlAddenda);
//					} else {
//						xmlConAddendaBocar = xmlOriginal.replaceFirst(FeConstantesValidacion.CFDI_COMPROBANTE_END_TAG,
//								xmlAddenda + "\n" + FeConstantesValidacion.CFDI_COMPROBANTE_END_TAG);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//
//					xmlConAddendaBocar = xmlOriginal;
//				}
//			} else {
//				xmlConAddendaBocar = xmlOriginal;
//			}
//		}
//
//		return xmlConAddendaBocar;
//	}
}
