package com.infra.factura.exception.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.infra.factura.exception.UnexpectedRuntimeException;
import com.infra.factura.exception.base.ExceptionCategory;
import com.infra.factura.exception.base.ExceptionInfo;
import com.infra.factura.exception.base.SRFEBaseException;
import com.infra.factura.exception.base.SRFEBaseRuntimeException;

public class StackTraceTool {

	private StackTraceTool() {
	}

	public static String getStackTraceAsString(Throwable exception) {
		StringBuffer message = new StringBuffer();
		String exceptionMessage = exception.getMessage();

		if (exception instanceof SRFEBaseException) {
			if (exception instanceof SRFEBaseRuntimeException) {
				exceptionMessage = ((SRFEBaseRuntimeException) exception)
						.getWrappedException().getMessage();
			}
		} else {
			exception = new UnexpectedRuntimeException(new ExceptionInfo(
					ExceptionCategory.GENERAL_PROBLEM, exception.getMessage()),
					exception);
		}

		message.append(" ");
		message.append(exceptionMessage);
		message.append(" ");
		message.append(System.getProperty("line.separator"));

		return getStackMessage(message.toString(), exception);
	}

	private static String getStackMessage(String message, Throwable exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.print(" [ ");
		if(exception instanceof SRFEBaseRuntimeException){
			pw.print(((SRFEBaseRuntimeException)exception).getWrappedException().getClass().getName());
		}else{
			pw.print(exception.getClass().getName());
		}
		pw.print(" ] ");
		pw.print(message);
		if(exception instanceof SRFEBaseRuntimeException){
			((SRFEBaseRuntimeException)exception).getWrappedException().printStackTrace(pw);
		}else{
			exception.printStackTrace(pw);
		}
		return sw.toString().replaceAll("'", "''");
	}
}
