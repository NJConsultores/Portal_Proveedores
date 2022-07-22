package com.infra.factura.exception.base;

import com.infra.factura.exception.util.StackTraceTool;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public abstract class SRFEBaseException extends Exception {

	private static Logger exceptionLogger = Logger.getLogger(SRFEBaseException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -771709634613457501L;
	protected ExceptionInfo exceptionInfo;

	public SRFEBaseException(ExceptionInfo aInfo) {
		super();
		this.exceptionInfo = aInfo;
	}

	public final ExceptionInfo getExceptionInfo() {
		return exceptionInfo;
	}

	public final String getStackTraceAsString() {
		return StackTraceTool.getStackTraceAsString(this);
	}

	public final void logException(int userId, String ipAddress) {
		if (!(this.getExceptionInfo().isLogged())) {
			MDC.put("exceptionId", this.exceptionInfo.getExceptionID());
			MDC.put("userId", userId);
			MDC.put("directionIP", ipAddress);
			MDC.put("stackTrace",
					StackTraceTool.getStackTraceAsString(this));
			if(this instanceof SRFEBaseRuntimeException){
				final Throwable cause = ((SRFEBaseRuntimeException)this).getWrappedException().getCause();
				if(cause != null){
					String message = cause.getMessage();
					if(message != null){
						message = message.replaceAll("'", "''");
					}
					exceptionLogger.error(message);
				}else{
					String message = ((SRFEBaseRuntimeException)this).getWrappedException().getMessage();
					if(message != null){
						message = message.replaceAll("'", "''");
					}
					exceptionLogger.error(message);
				}
			}else{
				exceptionLogger.error(this.getMessage());
			}
			MDC.remove("exceptionId");
			MDC.remove("userId");
			MDC.remove("directionIP");
			MDC.remove("stackTrace");
			this.getExceptionInfo().setLogged(true);
		}
	}

	public void logException() {
		logException(-1, "127.0.0.1");
	}

}
