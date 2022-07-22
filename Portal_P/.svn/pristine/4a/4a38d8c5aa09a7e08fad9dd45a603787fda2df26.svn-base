package com.infra.factura.exception;

import java.util.ArrayList;
import java.util.List;

public class ReenvioFacturaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> errores = new ArrayList<String>();
	
	public ReenvioFacturaException(String m){
		super(m);
	}
	
	public ReenvioFacturaException(String m, List<String> errores) {
		// TODO Auto-generated constructor stub
		this(m);
		this.errores = errores;
	}

	public List<String> getErrores() {
		return errores;
	}

	

}
