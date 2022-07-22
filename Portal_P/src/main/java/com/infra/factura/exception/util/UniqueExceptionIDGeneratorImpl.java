package com.infra.factura.exception.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.infra.factura.exception.base.IUniqueExceptionIDGenerator;

public class UniqueExceptionIDGeneratorImpl implements
		IUniqueExceptionIDGenerator {
	private static long counter = 0;
	private static IUniqueExceptionIDGenerator instance = new UniqueExceptionIDGeneratorImpl();

	private UniqueExceptionIDGeneratorImpl() {

	}

	public long getUniqueID() {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"ddMMyyyyHHmmss");

		StringBuffer exceptionID = new StringBuffer();
		exceptionID.append(simpleDateFormat.format(new Date()));
		exceptionID.append(String.format("%03d", counter++));
		return Long.parseLong(exceptionID.toString());
	}

	public static IUniqueExceptionIDGenerator getUniqueIDGenerator() {
		return instance;
	}
}
