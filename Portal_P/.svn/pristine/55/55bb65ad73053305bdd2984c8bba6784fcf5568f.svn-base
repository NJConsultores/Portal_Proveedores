package com.infra.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

import com.infra.factura.util.ConstantesGenerales;

public class SatUtil {
	private static Logger logger = Logger.getLogger(SatUtil.class);
	private static final int TAM_NUMERO_CERTIFICADO = 20;
	private static final int TIMEOUT_VALUE = 25000;

	public static InputStream descargarCertificadoCSD(String numeroCertificado) {
		InputStream cert = descargarCertificado(numeroCertificado);

		return cert;
	}

	public static InputStream descargarCertificado(String numeroCertificado) {
		// PropiedadesUtil propiedadesUtil = (PropiedadesUtil)
		// ContextLoader.getCurrentWebApplicationContext().getBean("propiedadesUtil");
		StringBuilder parametros = new StringBuilder();
		StringBuilder urlFtp = new StringBuilder();

		if (numeroCertificado != null && numeroCertificado.length() >= TAM_NUMERO_CERTIFICADO) {
			parametros.append(numeroCertificado.substring(0, 6));
			parametros.append("|");
			parametros.append(numeroCertificado.substring(6, 12));
			parametros.append("|");
			parametros.append(numeroCertificado.substring(12, 14));
			parametros.append("|");
			parametros.append(numeroCertificado.substring(14, 16));
			parametros.append("|");
			parametros.append(numeroCertificado.substring(16, 18));
			parametros.append("|");
			parametros.append(numeroCertificado);

			urlFtp.append(sustituirArgumentos(ConstantesGenerales.URL_SAT_CERT, parametros.toString()));
		}
		logger.info("Se armo la URL: " + urlFtp);
		return descargarCertificado(urlFtp);
	}

	public static InputStream descargarCertificado(StringBuilder urlFtp) {
		InputStream respuesta = null;
		URL url = null;
		StringBuilder answer = null;
		URLConnection connection = null;
		long start = 0;
		long elapsed = 0;

		try {
			url = new URL(urlFtp.toString());
			connection = url.openConnection();

			connection.setConnectTimeout(TIMEOUT_VALUE);
			connection.setReadTimeout(TIMEOUT_VALUE);

			start = System.nanoTime();
			respuesta = connection.getInputStream();
			elapsed = System.nanoTime() - start;

			logger.info("Elapsed (ms): " + elapsed / 1000000);
			logger.info("Answer:" + answer);
		} catch (SocketTimeoutException e) {
			logger.error("More than " + TIMEOUT_VALUE + " elapsed.", e);
		} catch (MalformedURLException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}

		return respuesta;
	}

	public static String sustituirArgumentos(String patron, Object[] argumentos) {
		if (argumentos != null) {
			if (argumentos.length == 0) {
				return patron;
			} else {
				return MessageFormat.format(patron, argumentos);
			}
		} else {
			return null;
		}
	}

	public static String sustituirArgumentos(String patron, String argumentos) {
		if (argumentos != null) {
			if (argumentos.trim().equals("")) {
				return patron;
			} else {
				return sustituirArgumentos(patron, argumentos.split("\\|"));
			}
		} else {
			return null;
		}
	}

}
