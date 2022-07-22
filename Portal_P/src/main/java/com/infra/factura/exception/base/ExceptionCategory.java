package com.infra.factura.exception.base;

import java.io.Serializable;

public class ExceptionCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5862758229766616736L;

	public static final ExceptionCategory INFO =

	new ExceptionCategory(0);

	public static final ExceptionCategory WARNING =

	new ExceptionCategory(1);

	public static final ExceptionCategory GENERAL_PROBLEM =

	new ExceptionCategory(2);

	public static final ExceptionCategory DATA_PROBLEM =

	new ExceptionCategory(3);

	public static final ExceptionCategory CONFIG_PROBLEM =

	new ExceptionCategory(4);

	public static final ExceptionCategory FATAL =

	new ExceptionCategory(5);

	public int getType() {
		return type;
	}

	private int type;

	private ExceptionCategory(int aType) {

		this.type = aType;

	}
}
