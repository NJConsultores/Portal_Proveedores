package com.infra.proveedor.service;

import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.infra.factura.dto.FeResultadoValidaCFDDto;

/**
 *
 * @author rlagunas
 */
@Service
public class EnviarListadoServiceImpl implements EnviarListadoService {

    private static final Logger logger = LoggerFactory.getLogger(EnviarListadoServiceImpl.class);

    public void init(){
        logger.info("Init de FacturaService");
    }
    
    @Override
    public FeResultadoValidaCFDDto enviarListado(UploadedFile xls) throws Exception {
    	long startTime = System.currentTimeMillis();
    	logger.debug(":::: Enviar listado a SAP :::: ");
//        InputStream xml = new ByteArrayInputStream(dataXML);
        FeResultadoValidaCFDDto resultado = null;
//        UsuarioWS usuario = SessionUtil.getUsuario();
//        Locale locale = SessionUtil.getLocale();
//        resultado = facturaBusiness.validarFactura(FeConstantesValidacion.CFDOrigen.WEB_PORTAL, xml, null, usuario, locale);
//        if (resultado.isValido()) {
//        	 FeFacturaDto factura = resultado.getFactura();
//             logger.info("Registrando archivos PDF");
//            if (resultado.isAceptada() && ValidatorUtil.isEmpty(resultado.getErrores())) {
//                //Guardar
////                SAPEnviarFacturaStrategy sapStrategy = new SAPEnviarFacturaStrategy();
////                EnviarFactura enviarFactura = new EnviarFactura();
////                enviarFactura.setStrategy(sapStrategy);
////                enviarFactura.enviarFacturaCliente();
//            } else {
//                   logger.error("Errores");
//                     throw new EnvioFacturaException(resultado, "Error" );
//            }
//        } else {
//            logger.error("No es valido");
//               logger.error("Errores");
//               throw new EnvioFacturaException(resultado, "Error" );
//                       //request.setAttribute("errores", resultado.getErrores());
//        }
//        logger.info("enviarFactura("+nombreArchivoXMl+") : " + ( (System.currentTimeMillis()-startTime) / 1000.0 ) + "s");
        return resultado;
    }
	
}