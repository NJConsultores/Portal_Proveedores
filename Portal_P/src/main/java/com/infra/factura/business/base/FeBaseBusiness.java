package com.infra.factura.business.base;


import com.infra.factura.exception.UnexpectedRuntimeException;
import com.infra.factura.exception.base.ExceptionCategory;
import com.infra.factura.exception.base.ExceptionInfo;
import com.infra.factura.exception.base.SRFEBaseException;
import com.infra.factura.exception.base.SRFEBaseRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FeBaseBusiness {
	private static Logger logger = LoggerFactory.getLogger(FeBaseBusiness.class);

	protected SRFEBaseException handleException(Throwable exception) {
		if ((exception != null) && (exception instanceof Throwable)) {
			if (exception instanceof SRFEBaseException) {
				exception = (SRFEBaseException) exception;
			} else if (exception instanceof SRFEBaseRuntimeException) {
				exception = (SRFEBaseRuntimeException) exception;
			} else {
				if (exception instanceof NullPointerException) {
					exception = new UnexpectedRuntimeException((Throwable) exception);
				} else {
					final Throwable cause = ((Throwable) exception).getCause();
					if (cause != null) {
						exception = new UnexpectedRuntimeException(
								new ExceptionInfo(
										ExceptionCategory.GENERAL_PROBLEM,
										cause.getMessage()
												.replaceAll("'", "''")),
								((Throwable) exception));
					} else {
						exception = new UnexpectedRuntimeException(
								new ExceptionInfo(
										ExceptionCategory.GENERAL_PROBLEM,
										((Throwable) exception).getMessage()),
								((Throwable) exception));
					}
				}
			}
		}

		try{
			((SRFEBaseException) exception).logException();
		}catch (Exception e) {
			logger.error("Ocurrió un error al registrar la excepción.", e);
		}

		return (SRFEBaseException) exception;
	}
}