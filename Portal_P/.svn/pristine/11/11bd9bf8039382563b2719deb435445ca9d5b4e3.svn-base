/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infra.factura.ws;

import java.util.Properties;
import com.infra.factura.dto.FeConsultaCfdiSatDto;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prospectiva
 */
@Component
public class ConsultaCFDISAT {
    
    @Autowired
    private IConsultaCFDIService consultaCFDIService;

    public FeConsultaCfdiSatDto consultaCFDI(String rfcEmisor, String rfcReceptor, String montoTotalFactura, String uuid) throws Exception {
        Properties properties = System.getProperties();
        properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
        System.setProperties(properties);
        
        //Hace el replace en caso de que el RFC contenga el caracter de &
        rfcEmisor = rfcEmisor.replace("&", "&amp;");
        rfcReceptor = rfcReceptor.replace("&", "&amp;");
        
        String parametroWs = "re="+rfcEmisor+"&rr="+rfcReceptor+"&tt="+montoTotalFactura+"&id="+uuid;
        System.out.println("parametroWs::"+ parametroWs);
        
        Client cl = ClientProxy.getClient(consultaCFDIService);
        HTTPConduit http = (HTTPConduit) cl.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(10000);
        httpClientPolicy.setReceiveTimeout(10000);
        http.setClient(httpClientPolicy);
        
        Acuse consulta = consultaCFDIService.consulta(parametroWs);

        System.out.println("Estatus::" + consulta.getCodigoEstatus().getValue());
        System.out.println("Estado:: " + consulta.getEstado().getValue());
        
        FeConsultaCfdiSatDto consultaCfdiSatDto = new FeConsultaCfdiSatDto();
        consultaCfdiSatDto.setCodigoEstatus(consulta.getCodigoEstatus().getValue());
        consultaCfdiSatDto.setEstado(consulta.getEstado().getValue());
        
        return consultaCfdiSatDto;
    }

    public static void main(String[] args) throws Exception {
        //Initializes Spring Container 
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-cxf.xml");
        IConsultaCFDIService consultaCFDIService = (IConsultaCFDIService) applicationContext.getBean("consultaCfdiSatClient");

        Client cl = ClientProxy.getClient(consultaCFDIService);        
        HTTPConduit http = (HTTPConduit) cl.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(1000000);
        httpClientPolicy.setReceiveTimeout(0);
        http.setClient(httpClientPolicy);

        Acuse consulta = consultaCFDIService.consulta("re=VAOJ6306025L8&rr=ALS9609181N6&tt=1740.00&id=022B12A5-0C80-424B-9698-CF3E53F7EDDD");

        System.out.println("Estatus::" + consulta.getCodigoEstatus().getValue());
        System.out.println("Estado:: " + consulta.getEstado().getValue());
        
    }
}
