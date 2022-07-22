//package com.infra.util;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class FacturaUtil {
//
//	/**
//	 * Elimina el Contenido complemto del TAG Addenda de la Factura (CFDI) del
//	 * atributo xmlSellado asi como el atributo 'noAprobacion' de elemento
//	 * Comprobante
//	 * 
//	 * @return Una Factura (CFDI) en fomrato XML sin el contenido de la Addenda
//	 */
//	private String removerAddenda(String xmlSellado) {
//		String xmlCFDISinAddenda = "";
//
//		try {
//			xmlCFDISinAddenda = new String(xmlSellado.getBytes(FeIConstantes.ENCODING_UTF8),
//					FeIConstantes.ENCODING_UTF8);
//			final Pattern patternAddenda = Pattern
//					.compile(FeIConstantes.CFDI_ADDENDA_START_TAG + "(.+?)" + FeIConstantes.CFDI_ADDENDA_END_TAG);
//			final Matcher matcherAddenda = patternAddenda.matcher(xmlSellado);
//
//			try {
//				if (matcherAddenda.find()) {
//					xmlCFDISinAddenda = xmlSellado.replaceFirst(
//							FeIConstantes.CFDI_ADDENDA_START_TAG + "(.+?)" + FeIConstantes.CFDI_ADDENDA_END_TAG, "");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return xmlCFDISinAddenda.trim();
//	}
//}
