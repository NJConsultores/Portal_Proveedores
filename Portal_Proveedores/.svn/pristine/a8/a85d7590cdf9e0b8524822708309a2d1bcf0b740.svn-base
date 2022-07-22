package com.infra.factura.dto.html;

import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDEstatus;
import com.infra.factura.dto.FeFacturaDto;
import com.infra.factura.util.FeConstantes;

public class FeFacturaDtoHtml extends FeFacturaDto {
	private String nombre;

	public FeFacturaDtoHtml(long idFactura) {
		setIdFactura(idFactura); 
	}

	public FeFacturaDtoHtml() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEstatusView() {
		String estatusView = getEstatus().name();
		String estatusWS = "";
		
		if(getEsEnviadoWs()!=null){	
			if(getEsEnviadoWs().equals(String.valueOf(FeConstantes.WsRespuestas.WS_OK.getId()))){
				estatusWS = "Enviada";
			}else if(getEsEnviadoWs().equals(String.valueOf(FeConstantes.WsRespuestas.INCOMPLETE_FILE.getId()))){
				estatusWS = "Archivo Incompleto";
			}else if(getEsEnviadoWs().equals(String.valueOf(FeConstantes.WsRespuestas.INVALID_CREDENTIAL.getId()))){
				estatusWS = "Seguridad Incorrecta";
			}else if(getEsEnviadoWs().equals(String.valueOf(FeConstantes.WsRespuestas.SERVER_ERROR.getId()))){
				estatusWS = "No Disponible";
			}else{
				estatusWS = "No Enviada";
			}
			
			if(getEstatus().equals(CFDEstatus.RechazoFiscal) || getEstatus().equals(CFDEstatus.Rechazado)) {
				estatusView = "<a href=\"javascript:verErroresFactura("+ getIdFactura() +")\">" + estatusView + "</a>/"+estatusWS;
			}else if(getEstatus().equals(CFDEstatus.Aceptado)){
				estatusView = estatusView +"/"+estatusWS;
			}
		}else{
			if(getEstatus().equals(CFDEstatus.RechazoFiscal) || getEstatus().equals(CFDEstatus.Rechazado)) {
				estatusView = "<a href=\"javascript:verErroresFactura("+ getIdFactura() +")\">" + estatusView + "</a>/";
			}
		}
		return estatusView;
	}
	
	public String getXmlView() {
		final String imagePath = "fe_imagenes/xml_icon.gif";
		String xmlView = "";
		if(getEstatus().equals(CFDEstatus.Aceptado)) {
			xmlView = "<a href=\"javascript:verXML("+ getIdFactura() +")\"><img style=\"border: 0px;\" src=\""+ imagePath + "\" width=\"20\" height=\"20\"></a>";
		}
		return xmlView;
	}
	
	public String getPdfView() {
		final String imagePath = "fe_imagenes/pdf_icon.gif";
		String pdfView = "";
		if(getEstatus().equals(CFDEstatus.Aceptado)) {
			pdfView = "<a href=\"javascript:verPDF("+ getIdFactura() +")\"><img style=\"border: 0px;\" src=\""+ imagePath + "\" width=\"20\" height=\"20\"></a>";
		}
		return pdfView;
	}
	
	public String getSoporteView() {
		final String imagePath = "fe_imagenes/pdf_icon.gif";
		String soporteView = "";
		if(getEstatus().equals(CFDEstatus.Aceptado)) {
			soporteView = "<a href=\"javascript:verSoporte("+ getIdFactura() +")\"><img style=\"border: 0px;\" src=\""+ imagePath + "\" width=\"20\" height=\"20\"></a>";
		}
		return soporteView;
	}
	
	public String getRechazar() {
		final String imagePath = "fe_imagenes/rechazar_icon.png";
		String soporteView     = "";
		
		if(getEstatus().equals(CFDEstatus.Aceptado)) {
			soporteView = "<a href=\"javascript:verRechazarFactura("+ getIdFactura() +", " + getVersionCFD().ordinal() + ")\"><img style=\"border: 0px;\" src=\""+ imagePath + "\" width=\"20\" height=\"20\"></a>";
		}

		return soporteView;
	}
	
	public String getEstatusHtml() {
		return getEstatus().name();
	}
	
	public String getResguardoNom151Html(){
		if(getResguardoNom151() == null || getResguardoNom151().equalsIgnoreCase("n")){
			return "<img style=\"border: 0px;\" src=\"fe_imagenes/fe_no_ok_icon.png\" width=\"20\" height=\"20\">";
		}else{
			return "<img style=\"border: 0px;\" src=\"fe_imagenes/fe_ok_icon.png\" width=\"20\" height=\"20\">";
		}
	}
	
	public String getUuidView(){
		final String uuid = getUuid();
		if(uuid != null && uuid.length() == 36){
			return uuid.substring(0, 18) + " " + uuid.substring(18); 
		}else{
			return uuid;
		}
	}
	
	private String buildReenviar(boolean isWS){
		String reenviar = "";
		final String imagePath = "fe_imagenes/fe_reenviado.png";
		int tipo = 0;
		
		if(isWS){
			tipo = 1;
		}
		
		if(getEstatus().equals(CFDEstatus.Aceptado)){
			reenviar = "<a href=\"javascript:reenviar("+ getIdFactura() +",'" + getRfcEmisor() + "','" + getUuidView()+ "','" + tipo +"')\"><img style=\"border: 0px;\" src=\""+ imagePath + "\" width=\"20\" height=\"20\"></a>";
		}
				
		return reenviar;
	}
	
	public String getReenviarAs2(){
		return buildReenviar(false);
	}
	
	
	public String getReenviarWs(){
		return buildReenviar(true);
	}
}
