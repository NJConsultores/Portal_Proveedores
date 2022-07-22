package com.infra.factura.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infra.cliente.util.ClienteConstantes;
import com.infra.factura.business.validation.util.FeConstantesValidacion.CFDVersion;
import com.infra.factura.dto.FeErrorValidacionDto;
import com.infra.factura.dto.FeMailValidationDto;
import com.infra.factura.dto.FeResultadoValidaCFDDto;
import com.infra.factura.dto.html.FeFacturaDtoHtml;
import com.infra.factura.util.LayoutMailResources;

@Component
public class FeMailValidationBusiness {

    private static final Logger logger = Logger.getLogger(FeMailValidationBusiness.class);

    @Autowired
    private FeFacturaBusiness facturaBusiness;

//    @Autowired
//    private PropiedadesUtil propiedadesUtil;

   // @Scheduled(cron = "0/20 * * * * *")
    public void procesaFacturaPorCorreo() {
        logger.info("------------- Consulta el buzon de correo cada 20 segundos -----------------");
        try {

//            FeMailDto correo = new FeMailDto(Tipo_Correo.Validacion_correo);
            FeResultadoValidaCFDDto resultado = null;
            //FeRespuestaDto respuesta = null;
            //String errores = new String();

//            for (Iterator<FeMailValidationDto> it = listaArchivos.iterator(); it.hasNext();) {
//                //FeMailValidationDto mailDto = (FeMailValidationDto)it.next();
//                FeMailValidationDto facturaCorreoValidacion = (FeMailValidationDto) it.next();
//                logger.info("CorreoNotificacion::" + facturaCorreoValidacion.getCorreoNotificacion());
//                String correoBusqueda = facturaCorreoValidacion.getCorreoNotificacion().substring(facturaCorreoValidacion.getCorreoNotificacion().indexOf("<") + 1, facturaCorreoValidacion.getCorreoNotificacion().indexOf(">"));
//                String xml = facturaCorreoValidacion.getXmlName() == null ? "" : facturaCorreoValidacion.getXmlName();
//
//                //TODO JACE ELIMINAR LINEA DONDE SE HARDCODEA el correo
//                //correoBusqueda = "jorge.conelly@infra.com.mx";
//
//            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

    }

    private boolean validarObjetoCorreo(FeMailValidationDto facturaCorreoValidacion) {
        List<String> errores = new ArrayList<>();
        String msg = null;
        String xml = facturaCorreoValidacion.getXmlName() == null ? "" : facturaCorreoValidacion.getXmlName();
        
        if (facturaCorreoValidacion.getFilesSize() > 2097152) {
        	msg = LayoutMailResources.getString("correo.notificacion.comprobante.aceptado", new Object[]{});
            errores.add(msg);
        }
        
        if (facturaCorreoValidacion.getArchivosXml() == 0) {
        	msg = LayoutMailResources.getString("correo.notificacion.comprobante.aceptado", new Object[]{});
            errores.add(msg);
        }
        
        if (facturaCorreoValidacion.getArchivosPdf() == 0) {
        	msg = LayoutMailResources.getString("correo.notificacion.comprobante.aceptado", new Object[]{});
            errores.add(msg);
        }
        
        if (facturaCorreoValidacion.getArchivosXml() > 1) {
        	msg = LayoutMailResources.getString("correo.notificacion.comprobante.aceptado", new Object[]{facturaCorreoValidacion.getArchivosXml()});
            errores.add(msg);
        }
        
        if (facturaCorreoValidacion.getArchivosPdf() > 1) {
        	msg = LayoutMailResources.getString("correo.notificacion.comprobante.aceptado", new Object[]{facturaCorreoValidacion.getArchivosPdf()});
            errores.add(msg);
        }
        
        if (facturaCorreoValidacion.getArchivosCert() > 1) {
        	msg = LayoutMailResources.getString("correo.notificacion.comprobante.aceptado", new Object[]{facturaCorreoValidacion.getArchivosCert()});
            errores.add(msg);
        }

        if (errores.size() > 0) {
            logger.info("getDestinatarios: " + facturaCorreoValidacion.getCorreoNotificacion());
            String mensajeErrores = listToError(errores);
            String subject = ClienteConstantes.CORREO_TITULO_FACTURA_RECHAZADA_EMAIL_ES + xml;
            
            try{
//            	sendEmailUtil.sendMailFromTemplate(new String[]{facturaCorreoValidacion.getCorreoNotificacion()}, subject, 
//            			ClienteConstantes.CORREO_FACTURA_RECHAZADA_EMAIL_ES, new Object[]{mensajeErrores, 
//            																				facturaCorreoValidacion.getInfoMail(), 
//            																				mensajeErrores, 
//            																				facturaCorreoValidacion.getInfoMail()});
            }catch(Exception em){
        		logger.info("[ACTUALIZACION ESTATUS] - No se pudo enviar la notificación por correo electronico del XML: " + xml);
        		logger.error("", em);
	        }
            return false;
        }

        return true;
    }

    private String listToErrorString(List<FeErrorValidacionDto> lista) {
        StringBuilder respuesta = new StringBuilder();
        for (FeErrorValidacionDto itera : lista) {
            logger.info("Descripcion::::::" + itera);
            respuesta.append("<br>");
            respuesta.append(itera); //El método toString de la clase FeErrorValidacionDto es que que hace la chamba
        }
        return respuesta.toString();
    }

    private String listToError(List<String> lista) {
        StringBuilder respuesta = new StringBuilder();
        for (String itera : lista) {
            logger.info("Descripcion::::::" + itera);
            respuesta.append("<br>");
            respuesta.append(itera); //El método toString de la clase FeErrorValidacionDto es que que hace la chamba
        }
        return respuesta.toString();
    }
    
    private Object [] obtenerParametrosMensajeAceptado(FeFacturaDtoHtml facturaDtoSAP){
		Object [] parametros = null;
		String fechaRecepcionCorreo = facturaDtoSAP.getFechaRecepcion() != null ? new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(facturaDtoSAP.getFechaRecepcion()) : "NO DISPONIBLE";
		
		if(facturaDtoSAP.getVersionCFD() == CFDVersion.FE){
			parametros = new Object[]{facturaDtoSAP.getNombre(), facturaDtoSAP.getRfcReceptor() + "-" + facturaDtoSAP.getSociedad(), facturaDtoSAP.getFolio(), fechaRecepcionCorreo};
        }else{
        	parametros = new Object[]{facturaDtoSAP.getRfcEmisor() + "-" + facturaDtoSAP.getNombre(), facturaDtoSAP.getRfcReceptor() + "-" + facturaDtoSAP.getSociedad(), facturaDtoSAP.getUuid(), fechaRecepcionCorreo};
        }
		
		return parametros;
	}
    
    private String obtenerAsuntoMensajeAceptado(FeFacturaDtoHtml facturaDtoSAP){
		String subject = null;

//		if(facturaDtoSAP.getVersionCFD() == CFDVersion.FE){
//			subject = ClienteConstantes.CORREO_TITULO_FACTURA_ACEPTADA_EN + facturaDtoSAP.getFolio();
//        }else{
        	subject = ClienteConstantes.CORREO_TITULO_FACTURA_ACEPTADA_ES + facturaDtoSAP.getUuid();
//        }
		
		return subject;
	}
    
    private String obtenerClaveMensajeAceptado(FeFacturaDtoHtml facturaDtoSAP){
		String subject = null;

		if(facturaDtoSAP.getUuid() == null){
			subject = ClienteConstantes.CORREO_FACTURA_ACEPTADA_ES;
        }else{
        	subject = ClienteConstantes.CORREO_FACTURA_ACEPTADA_ES;
        }
		
		return subject;
	}
}
