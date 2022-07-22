package com.infra.factura.exception.base;


public abstract class SRFEBaseRuntimeException extends SRFEBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8847115910663851461L;

	private Throwable wrappedException;

	public SRFEBaseRuntimeException(ExceptionInfo aInfo,

	Throwable aWrappedException) {
		super(aInfo);
		this.wrappedException = aWrappedException;
	}

	public Throwable getWrappedException() {
		return wrappedException;
	}

}
