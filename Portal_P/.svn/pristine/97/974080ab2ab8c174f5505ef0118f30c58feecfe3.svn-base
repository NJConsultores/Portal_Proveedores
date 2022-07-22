package com.infra.core.util;

import java.io.IOException;
import java.io.InputStream;

import org.mozilla.universalchardet.UniversalDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infra.factura.util.ApplicationResources;

public class CharsetDetector {
	private final static Logger LOG = LoggerFactory.getLogger(CharsetDetector.class);
	private static UniversalDetector DETECTOR = new UniversalDetector(null);

	public static String detectEncoding(InputStream file) throws IOException {
		String encoding = null;
		byte[] buf = new byte[4096];
		// (2)
		int nread;

		while ((nread = file.read(buf)) > 0 && !DETECTOR.isDone()) {
			DETECTOR.handleData(buf, 0, nread);
		}

		// (3)
		DETECTOR.dataEnd();

		// (4)
		encoding = DETECTOR.getDetectedCharset();

		if (encoding != null) {
			LOG.debug("Detected encoding = " + encoding);
		} else {
			LOG.debug("No encoding detected.");
			throw new IOException(ApplicationResources.getString("catalogo.error.no.encoding.file"));
		}

		// (5)
		DETECTOR.reset();

		return encoding;
	}
}