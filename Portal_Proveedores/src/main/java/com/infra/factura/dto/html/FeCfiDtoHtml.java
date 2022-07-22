package com.infra.factura.dto.html;

import com.infra.factura.dto.FeCfiDto;

public class FeCfiDtoHtml extends FeCfiDto {
	private String documento;
	private boolean error = false;
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getVerXML(){
		return getRfcProveedor() == null || getRfcProveedor().trim().equals("") ? getNombreArchivo() :
					"<a href=\"CodigoQr.do?do=verXML&rfcProveedor="+getRfcProveedor()+"&numAprobacion="+getNumAprobacion()+
							"&folios="+getFolio()+"&serie="+getSerie()+"&tipoDocumento="+getTipoDocumento()+"\" target=\"_new\">"+getNombreArchivo()+".xml</a>";
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
