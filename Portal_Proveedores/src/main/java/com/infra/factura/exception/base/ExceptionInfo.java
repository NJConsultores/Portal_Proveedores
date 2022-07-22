package com.infra.factura.exception.base;

import java.io.Serializable;

import com.infra.factura.exception.util.UniqueExceptionIDGeneratorImpl;

public class ExceptionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7005480794257122463L;

	private ExceptionCategory exceptionCategory;

	private String errorCode;

	private long exceptionID;

	private boolean logged;

	public ExceptionInfo(ExceptionCategory aCategory,

	String aErrorCode) {
		this.exceptionCategory = aCategory;
		this.errorCode = aErrorCode;
		this.logged = false;
		this.exceptionID =
		UniqueExceptionIDGeneratorImpl.getUniqueIDGenerator().getUniqueID();
	}

	public ExceptionCategory getExceptionCategory() {
		return exceptionCategory;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public long getExceptionID() {
		return exceptionID;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
}
