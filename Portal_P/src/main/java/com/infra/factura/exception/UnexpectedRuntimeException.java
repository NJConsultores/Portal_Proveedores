package com.infra.factura.exception;

import com.infra.factura.exception.base.ExceptionCategory;
import com.infra.factura.exception.base.ExceptionInfo;
import com.infra.factura.exception.base.SRFEBaseRuntimeException;

public class UnexpectedRuntimeException extends SRFEBaseRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319516030501257818L;

	public UnexpectedRuntimeException(ExceptionInfo aInfo,
			Throwable aWrappedException) {
		super(aInfo, aWrappedException);
	}

	public UnexpectedRuntimeException(Throwable e) {
		this(new ExceptionInfo(ExceptionCategory.FATAL,
				((Throwable) e).getMessage()), ((Throwable) e));
	}

}
