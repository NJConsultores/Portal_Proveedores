package com.infra.factura.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infra.core.model.UsuarioWS;
import com.infra.core.util.SessionUtil;
import com.infra.core.util.ValidatorUtil;
import com.infra.factura.business.FeFacturaBusiness;
import com.infra.factura.business.validation.util.FeConstantesValidacion;
import com.infra.factura.dto.FeFacturaDto;
import com.infra.factura.dto.FeResultadoValidaCFDDto;
import com.infra.factura.exception.EnvioFacturaException;

/**
 *
 * @author rlagunas
 */
@Service
public class FacturaServiceImpl implements FacturaService {

    private static final Logger logger = LoggerFactory.getLogger(FacturaServiceImpl.class);
    @Autowired
    private FeFacturaBusiness facturaBusiness;

    public void init(){
        logger.info("Init de FacturaService");
    }
    
    @Override
	public FeFacturaBusiness getFacturaBusiness() throws Exception {
		return facturaBusiness;
	}

    @Override
    public FeResultadoValidaCFDDto validarFactura(String nombreArchivoXMl, byte[] dataXML) throws Exception {
    	long startTime = System.currentTimeMillis();
    	logger.debug(":::: Validar factura :::: ");
        InputStream xml = new ByteArrayInputStream(dataXML);
        FeResultadoValidaCFDDto resultado = null;
        UsuarioWS usuario = SessionUtil.getUsuario();
        Locale locale = SessionUtil.getLocale();
//        resultado = facturaBusiness.validarFactura(FeConstantesValidacion.CFDOrigen.WEB_PORTAL, xml, null, usuario, locale);
        if (resultado.isValido()) {
        	 FeFacturaDto factura = resultado.getFactura();
             logger.info("Registrando archivos PDF");
            if (resultado.isAceptada() && ValidatorUtil.isEmpty(resultado.getErrores())) {
                //Guardar
//                SAPEnviarFacturaStrategy sapStrategy = new SAPEnviarFacturaStrategy();
//                EnviarFactura enviarFactura = new EnviarFactura();
//                enviarFactura.setStrategy(sapStrategy);
//                enviarFactura.enviarFacturaCliente();
            } else {
                   logger.error("Errores");
                     throw new EnvioFacturaException(resultado, "Error" );
            }
        } else {
            logger.error("No es valido");
               logger.error("Errores");
               throw new EnvioFacturaException(resultado, "Error" );
                       //request.setAttribute("errores", resultado.getErrores());
        }
        logger.info("enviarFactura("+nombreArchivoXMl+") : " + ( (System.currentTimeMillis()-startTime) / 1000.0 ) + "s");
        return resultado;
    }
	
}