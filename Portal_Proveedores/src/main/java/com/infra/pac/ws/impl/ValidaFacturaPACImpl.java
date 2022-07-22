package com.infra.pac.ws.impl;

import java.io.IOException;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.infra.factura.business.FeFacturaBusiness;
import com.infra.factura.dto.RespuestaPACDto;
import com.infra.pac.ws.ValidaFacturaPAC;

@WebService(endpointInterface = "com.infra.pac.ws.ValidaFacturaPAC", serviceName = "ValidaFacturaPAC")
public class ValidaFacturaPACImpl implements ValidaFacturaPAC{
	
	@Autowired
    private FeFacturaBusiness facturaBusiness;
	
	public FeFacturaBusiness getFacturaBusiness() {
		return facturaBusiness;
	}

	public void setFacturaBusiness(FeFacturaBusiness facturaBusiness) {
		this.facturaBusiness = facturaBusiness;
	}

	@Override
	public RespuestaPACDto validarXML(@WebParam(name = "base64Archivo") String base64Archivo) throws IOException {
		return facturaBusiness.validarXML(base64Archivo);
	}

}
