package com.infra.pac.ws;

import java.io.IOException;

import javax.jws.WebService;

import com.infra.factura.dto.RespuestaPACDto;

@WebService()
public interface ValidaFacturaPAC extends java.rmi.Remote{
	
	 public RespuestaPACDto validarXML(String base64Archivo) throws java.rmi.RemoteException, IOException;

}
