package com.infra.factura.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.infra.cliente.util.ClienteConstantes;
import com.infra.factura.business.schema.util.StringAndInputstreamUtil;
import com.infra.factura.dto.FeFacturaDto;

public class AddendaUtil {

	public static final String REPLAZAR_REFERENCIA = "REPLAZAR_REFERENCIA";
	
    public final String CFDI_ADDENDA_EMPTY_TAG = "<cfdi:Addenda/>";
    public final String CFDI_ADDENDA_EMPTY_TAG_ALT = "<cfdi:Addenda />";
    public final String CFDI_ADDENDA_START_TAG = "<cfdi:Addenda";
    public final String CFDI_ADDENDA_END_TAG = "</cfdi:Addenda>";
    public final String CFDI_COMPROBANTE_END_TAG = "</cfdi:Comprobante>";
    public final String CFDI_COMPLEMENTO_END_TAG = "</cfdi:Complemento>";
    
    public InputStream buildXMLAddendaDefault(byte[] contenidoFactura) throws Exception {
        String nuevoXml = null;
        //String xmlOriginal = convertStreamToString(new ByteArrayInputStream(contenidoFactura));

        String xmlOriginal = StringAndInputstreamUtil
                .convertStreamToStringUnicodeEscape(new ByteArrayInputStream(contenidoFactura));

        if (xmlOriginal != null) {
            xmlOriginal = xmlOriginal.trim();
            xmlOriginal = xmlOriginal.replaceAll("\r\n", " ");
            xmlOriginal = xmlOriginal.replaceAll("\n", " ");
            xmlOriginal = xmlOriginal.replaceAll("\r", " ");
            xmlOriginal = xmlOriginal.replaceAll("\t", " ");
        }

        if (null != xmlOriginal) {
            if (xmlOriginal.contains(CFDI_ADDENDA_EMPTY_TAG) || xmlOriginal.contains(CFDI_ADDENDA_EMPTY_TAG_ALT)) {
                xmlOriginal = xmlOriginal.replaceFirst(CFDI_ADDENDA_EMPTY_TAG, "");
                xmlOriginal = xmlOriginal.replaceFirst(CFDI_ADDENDA_EMPTY_TAG_ALT, "");
            }
            final Pattern pattern1 = Pattern.compile(CFDI_COMPLEMENTO_END_TAG + "[\\S\\s]*" + CFDI_ADDENDA_START_TAG + "(.+?)" + CFDI_ADDENDA_END_TAG);
            final Matcher matcher1 = pattern1.matcher(xmlOriginal);
            final Pattern pattern = Pattern.compile(CFDI_ADDENDA_START_TAG + "(.+?)" + CFDI_ADDENDA_END_TAG);
            final Matcher matcher = pattern.matcher(xmlOriginal);
            if (matcher1.find() && matcher.find()) {
                
                nuevoXml = matcher.replaceAll(ClienteConstantes.ADDENDA_DEFAULT);
            } else {
                nuevoXml = xmlOriginal.replaceFirst(CFDI_COMPROBANTE_END_TAG, ClienteConstantes.ADDENDA_DEFAULT + "\n" + CFDI_COMPROBANTE_END_TAG);
            }

        }

       
        return convertStringToStream(nuevoXml);
    }

    public String convertStreamToString(InputStream is)
            throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is,
                        "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }

    public InputStream convertStringToStream(String text) {
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return is;
    }
    
//    public static String buildTextoCabeceraCOC(AddendaCOCDto addendaCOC) {
//        StringBuilder cabecera = new StringBuilder();
//        
//        if(addendaCOC != null){
//        	cabecera.append(addendaCOC.getDescripcion());
//        	cabecera.append(""); //<-- pendiente
//        }
//
//        return cabecera.toString();
//    }
    
    public static String buildReferencia(FeFacturaDto factura, boolean esExtranjero) {
    	String uuid = null;
    	
        if (factura != null) {
            if(esExtranjero){
            	uuid = factura.getFolio().trim();
            }else{
            	if(factura.getFolio() != null && !factura.getFolio().trim().isEmpty()){
            		uuid = factura.getFolio().trim();
            	}else{
            		uuid = factura.getUuid();
            		
            		if(uuid != null && !uuid.isEmpty() && uuid.length() > 5) {
                        int length = uuid.length();
                        return uuid.substring(length - 5);
                    }else{
                    	return uuid;
                    }
            	}
            }
        }

        return uuid;
    }
    
//    public static String buildTextoCabeceraSOC(AddendaSOCDto addendaSOC) {
//        StringBuilder cabecera = new StringBuilder();
//        
//        if(addendaSOC != null){
//        	cabecera.append(addendaSOC.getDescripcion());
//        	cabecera.append(""); //<-- pendiente
//        }
//        
//        return cabecera.toString();
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String xmlAddenda = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><cfdi:Comprobante xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" version=\"3.2\" serie=\"A\" folio=\"622\" fecha=\"2015-01-02T10:42:34\" sello=\"Tn4zDhyzb8rhSut9p3cnuH6LXZ6V0qcoJGXINVSTJrIPxxvfi+aHItan0g16rUZyv6JCRCVLfyDR3zT96Nbj4hNpLorPu47hPvgy7yYuhRUBHJ7aInzx7VYkeVobvJeNqOQDok8SaZh3OWczg8cBnwWCynfWVKOJrTdh6/hzaH8=\" formaDePago=\"PAGO EN UNA SOLA EXHIBICION\" noCertificado=\"00001000000203342284\" certificado=\"MIIEdjCCA16gAwIBAgIUMDAwMDEwMDAwMDAyMDMzNDIyODQwDQYJKoZIhvcNAQEFBQAwggGVMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSEwHwYJKoZIhvcNAQkBFhJhc2lzbmV0QHNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxFDASBgNVBAcMC0N1YXVodMOpbW9jMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxPjA8BgkqhkiG9w0BCQIML1Jlc3BvbnNhYmxlOiBDZWNpbGlhIEd1aWxsZXJtaW5hIEdhcmPDrWEgR3VlcnJhMB4XDTEzMDMyODE4NDkwNFoXDTE3MDMyODE4NDkwNFowgbcxHTAbBgNVBAMTFEZJREVJQ09NSVNPIEYvMzA3ODMxMR0wGwYDVQQpExRGSURFSUNPTUlTTyBGLzMwNzgzMTEdMBsGA1UEChMURklERUlDT01JU08gRi8zMDc4MzExJTAjBgNVBC0THEZGWDEzMDMyMkJVMSAvIFZFT0E1OTA0MjdCMzAxHjAcBgNVBAUTFSAvIFZFT0E1OTA0MjdIREZMUkwwNTERMA8GA1UECxMIRiAzMDc4MzEwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAJgNbYINGo4m4jK6GCXhf1hyX1mWpmQY/4A5y0HMBxsx+LVZ0pt7/OO6B2+xTN8yLqsI+mOvDe4OqyJYQ5DDDt+KbpO/939qqVRW5sXgOcA7CoK32r/f+IYQiW5lzkKZ6LAcb9h7/ugOQ52HZgD7rNyORkMIFfLUCwFjb6PKeaUXAgMBAAGjHTAbMAwGA1UdEwEB/wQCMAAwCwYDVR0PBAQDAgbAMA0GCSqGSIb3DQEBBQUAA4IBAQAnRRNJ+0Q+JB5Qb87phOnU8kRMUGBSBtreqLmrPIRXj8zBA0sopgFAGrxlXx06y5KOm4Ki82s+Kx/OIGWUTStHGZ6VAJBWH8cbsImg+r8i23BkRoVfM+yWHmKqGkdDhHiFdqETt9gKEYocMQEbsc6lNlZUBW/mdP1DGl3UXNHA+fts781Cq46xRkBzWvE8WvM/pMWQhgiCsZmPtbgs1gqeQwCnQpwo8sqByesScyIVORNS4Ppz193F2M+Dsm4phaQLn+Nh8Phsk1B2VwPBm+mfAIT6jERGqxJfm26KQfCqOJZNVDaYqwH1iW1A3ubF2Ew7upQNs2ajseVszhX8xVvp\" subTotal=\"2719.50\" TipoCambio=\"1.00\" Moneda=\"USD\" total=\"3154.62\" tipoDeComprobante=\"ingreso\" metodoDePago=\"NO IDENTIFICADO\" LugarExpedicion=\"MEXICO\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd\">	<cfdi:Emisor rfc=\"FFX130322BU1\" nombre=\"FIDEICOMISO F/307831\">		<cfdi:DomicilioFiscal calle=\"PRESIDENTE MASARIK\" noExterior=\"61\" noInterior=\"PISO 7\" colonia=\"CHAPULTEPEC MORELOS\" municipio=\"MIGUEL HIDALGO,\" estado=\"DF\" pais=\"MEXICO\" codigoPostal=\"11570\" />		<cfdi:RegimenFiscal Regimen=\"REGIMEN GENERAL PERSONAS MORALES\" />	</cfdi:Emisor>	<cfdi:Receptor rfc=\"LVA681016453\" nombre=\"LOGISTICA CLIENTE SA DE CV\">		<cfdi:Domicilio calle=\"PINO SUAREZ LOTE\" noExterior=\"97\" noInterior=\"MANZANA 3\" colonia=\"EL SABINO\" municipio=\"CUAUTITLAN IZCALLI,\" estado=\"IZCALLI,\" pais=\"MEXICO\" codigoPostal=\"54740\" />	</cfdi:Receptor>	<cfdi:Conceptos>		<cfdi:Concepto cantidad=\"1\" unidad=\"NA\" descripcion=\"CAM (MANTENIMIENTO DE AREAS COMUNES) CORRESPONDIENTE AL MES DE ENERO 2015.ESTA FACTURA DEBERÁ SER PAGADA A MÁS TARDAR EN LOS PRÓXIMOS TRES DÍAS HÁBILES POSTERIORES A SU RECEPCIÓN, EN CASO CONTRARIO PODRÁ SER SUJETA AL COBRO DE INTERESES MORATORIOS.\" valorUnitario=\"2719.50\" importe=\"2719.50\">			<cfdi:CuentaPredial numero=\"CUENTA PREDIAL 121-06-477-02-0000\" />		</cfdi:Concepto>	</cfdi:Conceptos>	<cfdi:Impuestos totalImpuestosTrasladados=\"435.12\">		<cfdi:Traslados>			<cfdi:Traslado impuesto=\"IVA\" tasa=\"16.00\" importe=\"435.12\" />		</cfdi:Traslados>	</cfdi:Impuestos>	<cfdi:Complemento>		<tfd:TimbreFiscalDigital version=\"1.0\" UUID=\"4CC703F5-AE29-48BC-9EFA-99BB3BD54032\" FechaTimbrado=\"2015-01-02T10:42:34\" selloCFD=\"Tn4zDhyzb8rhSut9p3cnuH6LXZ6V0qcoJGXINVSTJrIPxxvfi+aHItan0g16rUZyv6JCRCVLfyDR3zT96Nbj4hNpLorPu47hPvgy7yYuhRUBHJ7aInzx7VYkeVobvJeNqOQDok8SaZh3OWczg8cBnwWCynfWVKOJrTdh6/hzaH8=\" noCertificadoSAT=\"00001000000202700691\" selloSAT=\"LK8RBxWYLD/wIsmplj1lQDd037EndKFDsz0KXvQc/BVPUcRMuoSWHIJaeqVmtLB/0XyjlpZeuRTGJ48Z2ThsjQn+Ae9iMQw/1Nh16r+rAmzYxds7paUL00hg9F1Je8BrddIeDn163GVyQ36hcNmmWOxOJCGCsF3EWotcoAGzYR0=\" xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/TimbreFiscalDigital/TimbreFiscalDigital.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" />	</cfdi:Complemento>	<cfdi:Addenda>		<ext:InformacionAdicional xsi:schemaLocation=\"http://www.buzone.com.mx/XSD/ParserGenerico/Generico http://www.buzone.com.mx/XSD/ParserGenerico/Generico/AddendaGenerico.xsd\" xmlns:ext=\"http://www.buzone.com.mx/XSD/ParserGenerico/Generico\">			<ext:SenderID>38746</ext:SenderID>			<ext:CFDI tipoDocumento=\"FA\" complementoCode=\"\" numeroDocumentos=\"1\" />			<ext:EMSR etiqueta1E=\"T83101-242753\" valor1E=\"Como consecuencia de las disposiciones vigentes de la legislacion fiscal aplicable, la presente factura electronica se genera y envia a su destinatario en el dia y mes referido en la misma, sin que esto implique que la misma ha sido pagada total o parcialmente. La presente factura se entendera efectivamente pagada solamente en el caso que esta se encuentre acompanada por el original del comprobante de pago de la misma.\" />			<ext:R conector=\"LVA681016453\" />			<ext:PTDA idPartida=\"1\" partida=\"Partida 1\" />		</ext:InformacionAdicional>	</cfdi:Addenda></cfdi:Comprobante>";

        String xmlNuevo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<cfdi:Comprobante xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" version=\"3.2\" serie=\"A\" folio=\"624\" fecha=\"2015-01-02T10:42:52\" sello=\"NMSioZ0L+u0kEprHBMBITo8mTz+Nl86xitdt7DuEIjTJagk9NZ4JtAixaVGx2aGUHUonhIChY3ZM2yd73stvFchks1/AU7G3vr0SN5IzP2X9dCXs/BITI9pOLBGopvn9RpewRGwdbSvGn6Pyye4ksu6YqWSHPiGUPPMxrzY1Izk=\" formaDePago=\"PAGO EN UNA SOLA EXHIBICION\" noCertificado=\"00001000000203342284\" certificado=\"MIIEdjCCA16gAwIBAgIUMDAwMDEwMDAwMDAyMDMzNDIyODQwDQYJKoZIhvcNAQEFBQAwggGVMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSEwHwYJKoZIhvcNAQkBFhJhc2lzbmV0QHNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxFDASBgNVBAcMC0N1YXVodMOpbW9jMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxPjA8BgkqhkiG9w0BCQIML1Jlc3BvbnNhYmxlOiBDZWNpbGlhIEd1aWxsZXJtaW5hIEdhcmPDrWEgR3VlcnJhMB4XDTEzMDMyODE4NDkwNFoXDTE3MDMyODE4NDkwNFowgbcxHTAbBgNVBAMTFEZJREVJQ09NSVNPIEYvMzA3ODMxMR0wGwYDVQQpExRGSURFSUNPTUlTTyBGLzMwNzgzMTEdMBsGA1UEChMURklERUlDT01JU08gRi8zMDc4MzExJTAjBgNVBC0THEZGWDEzMDMyMkJVMSAvIFZFT0E1OTA0MjdCMzAxHjAcBgNVBAUTFSAvIFZFT0E1OTA0MjdIREZMUkwwNTERMA8GA1UECxMIRiAzMDc4MzEwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAJgNbYINGo4m4jK6GCXhf1hyX1mWpmQY/4A5y0HMBxsx+LVZ0pt7/OO6B2+xTN8yLqsI+mOvDe4OqyJYQ5DDDt+KbpO/939qqVRW5sXgOcA7CoK32r/f+IYQiW5lzkKZ6LAcb9h7/ugOQ52HZgD7rNyORkMIFfLUCwFjb6PKeaUXAgMBAAGjHTAbMAwGA1UdEwEB/wQCMAAwCwYDVR0PBAQDAgbAMA0GCSqGSIb3DQEBBQUAA4IBAQAnRRNJ+0Q+JB5Qb87phOnU8kRMUGBSBtreqLmrPIRXj8zBA0sopgFAGrxlXx06y5KOm4Ki82s+Kx/OIGWUTStHGZ6VAJBWH8cbsImg+r8i23BkRoVfM+yWHmKqGkdDhHiFdqETt9gKEYocMQEbsc6lNlZUBW/mdP1DGl3UXNHA+fts781Cq46xRkBzWvE8WvM/pMWQhgiCsZmPtbgs1gqeQwCnQpwo8sqByesScyIVORNS4Ppz193F2M+Dsm4phaQLn+Nh8Phsk1B2VwPBm+mfAIT6jERGqxJfm26KQfCqOJZNVDaYqwH1iW1A3ubF2Ew7upQNs2ajseVszhX8xVvp\" subTotal=\"2331.00\" TipoCambio=\"1.00\" Moneda=\"USD\" total=\"2703.96\" tipoDeComprobante=\"ingreso\" metodoDePago=\"NO IDENTIFICADO\" LugarExpedicion=\"MEXICO\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd\">\n"
                + "  <cfdi:Emisor rfc=\"FFX130322BU1\" nombre=\"FIDEICOMISO F/307831\">\n"
                + "    <cfdi:DomicilioFiscal calle=\"PRESIDENTE MASARIK\" noExterior=\"61\" noInterior=\"PISO 7\" colonia=\"CHAPULTEPEC MORALES\" municipio=\"MIGUEL HIDALGO,\" estado=\"DF\" pais=\"MEXICO\" codigoPostal=\"11570\" />\n"
                + "    <cfdi:RegimenFiscal Regimen=\"REGIMEN GENERAL PERSONAS MORALES\" />\n"
                + "  </cfdi:Emisor>\n"
                + "  <cfdi:Receptor rfc=\"LVA681016453\" nombre=\"LOGISTICA CLIENTE SA DE CV\">\n"
                + "    <cfdi:Domicilio calle=\"PINO SUAREZ LOTE\" noExterior=\"97\" noInterior=\"MANZANA 3\" colonia=\"EL SABINO\" municipio=\"CUAUTITLAN IZCALLI,\" estado=\"IZCALLI,\" pais=\"MEXICO\" codigoPostal=\"54740\" />\n"
                + "  </cfdi:Receptor>\n"
                + "  <cfdi:Conceptos>\n"
                + "    <cfdi:Concepto cantidad=\"1\" unidad=\"NA\" descripcion=\"NN (MTTO-SEGURO) CORRESPONDIENTE AL MES DE ENERO 2015.ESTA FACTURA DEBERÁ SER PAGADA A MÁS TARDAR EN LOS PRÓXIMOS TRES DÍAS HÁBILES POSTERIORES A SU RECEPCIÓN, EN CASO CONTRARIO PODRÁ SER SUJETA AL COBRO DE INTERESES MORATORIOS.\" valorUnitario=\"2331.00\" importe=\"2331.00\">\n"
                + "      <cfdi:CuentaPredial numero=\"CUENTA PREDIAL 121-06-477-02-0000\" />\n"
                + "    </cfdi:Concepto>\n"
                + "  </cfdi:Conceptos>\n"
                + "  <cfdi:Impuestos totalImpuestosTrasladados=\"372.96\">\n"
                + "    <cfdi:Traslados>\n"
                + "      <cfdi:Traslado impuesto=\"IVA\" tasa=\"16.00\" importe=\"372.96\" />\n"
                + "    </cfdi:Traslados>\n"
                + "  </cfdi:Impuestos>\n"
                + "  <cfdi:Complemento>\n"
                + "    <tfd:TimbreFiscalDigital version=\"1.0\" UUID=\"B76E0F13-2188-4FD0-B842-C0CA0B037E4A\" FechaTimbrado=\"2015-01-02T10:42:53\" selloCFD=\"NMSioZ0L+u0kEprHBMBITo8mTz+Nl86xitdt7DuEIjTJagk9NZ4JtAixaVGx2aGUHUonhIChY3ZM2yd73stvFchks1/AU7G3vr0SN5IzP2X9dCXs/BITI9pOLBGopvn9RpewRGwdbSvGn6Pyye4ksu6YqWSHPiGUPPMxrzY1Izk=\" noCertificadoSAT=\"00001000000202700691\" selloSAT=\"uGZQOLfVJKJPbXQBKM0iNZAOMhNZrHheVK+CPdXY7ZzVEk78LvrTzVxTEsrrhdb6pzxw9g2WHjMZhEgigQc6zXsTqWkpFLodjrfKgl3FoOx1u+i9UTHqU4WFnAEA+JLkb76DEPUAtZiXFwG811sPeE9DjNhXG1V1HmaZTfbtTXA=\" xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/TimbreFiscalDigital/TimbreFiscalDigital.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" />\n"
                + "  </cfdi:Complemento>\n"
                + "  <cfdi:Addenda>\n"
                + "    <ext:InformacionAdicional xsi:schemaLocation=\"http://www.buzone.com.mx/XSD/ParserGenerico/Generico http://www.buzone.com.mx/XSD/ParserGenerico/Generico/AddendaGenerico.xsd\" xmlns:ext=\"http://www.buzone.com.mx/XSD/ParserGenerico/Generico\">\n"
                + "      <ext:SenderID>38746</ext:SenderID>\n"
                + "      <ext:CFDI tipoDocumento=\"FA\" complementoCode=\"\" numeroDocumentos=\"1\" />\n"
                + "      <ext:EMSR etiqueta1E=\"T83101-242753\" valor1E=\"Como consecuencia de las disposiciones vigentes de la legislacion fiscal aplicable, la presente factura electronica se genera y envia a su destinatario en el dia y mes referido en la misma, sin que esto implique que la misma ha sido pagada total o parcialmente. La presente factura se entendera efectivamente pagada solamente en el caso que esta se encuentre acompanada por el original del comprobante de pago de la misma.\" />\n"
                + "      <ext:R conector=\"LVA681016453\" />\n"
                + "      <ext:PTDA idPartida=\"1\" partida=\"Partida 1\" />\n"
                + "    </ext:InformacionAdicional>\n"
                + "  </cfdi:Addenda>\n"
                + "</cfdi:Comprobante>";

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<cfdi:Comprobante xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" version=\"3.2\" serie=\"A\" folio=\"622\" fecha=\"2015-01-02T10:42:34\" sello=\"Tn4zDhyzb8rhSut9p3cnuH6LXZ6V0qcoJGXINVSTJrIPxxvfi+aHItan0g16rUZyv6JCRCVLfyDR3zT96Nbj4hNpLorPu47hPvgy7yYuhRUBHJ7aInzx7VYkeVobvJeNqOQDok8SaZh3OWczg8cBnwWCynfWVKOJrTdh6/hzaH8=\" formaDePago=\"PAGO EN UNA SOLA EXHIBICION\" noCertificado=\"00001000000203342284\" certificado=\"MIIEdjCCA16gAwIBAgIUMDAwMDEwMDAwMDAyMDMzNDIyODQwDQYJKoZIhvcNAQEFBQAwggGVMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSEwHwYJKoZIhvcNAQkBFhJhc2lzbmV0QHNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxFDASBgNVBAcMC0N1YXVodMOpbW9jMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxPjA8BgkqhkiG9w0BCQIML1Jlc3BvbnNhYmxlOiBDZWNpbGlhIEd1aWxsZXJtaW5hIEdhcmPDrWEgR3VlcnJhMB4XDTEzMDMyODE4NDkwNFoXDTE3MDMyODE4NDkwNFowgbcxHTAbBgNVBAMTFEZJREVJQ09NSVNPIEYvMzA3ODMxMR0wGwYDVQQpExRGSURFSUNPTUlTTyBGLzMwNzgzMTEdMBsGA1UEChMURklERUlDT01JU08gRi8zMDc4MzExJTAjBgNVBC0THEZGWDEzMDMyMkJVMSAvIFZFT0E1OTA0MjdCMzAxHjAcBgNVBAUTFSAvIFZFT0E1OTA0MjdIREZMUkwwNTERMA8GA1UECxMIRiAzMDc4MzEwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAJgNbYINGo4m4jK6GCXhf1hyX1mWpmQY/4A5y0HMBxsx+LVZ0pt7/OO6B2+xTN8yLqsI+mOvDe4OqyJYQ5DDDt+KbpO/939qqVRW5sXgOcA7CoK32r/f+IYQiW5lzkKZ6LAcb9h7/ugOQ52HZgD7rNyORkMIFfLUCwFjb6PKeaUXAgMBAAGjHTAbMAwGA1UdEwEB/wQCMAAwCwYDVR0PBAQDAgbAMA0GCSqGSIb3DQEBBQUAA4IBAQAnRRNJ+0Q+JB5Qb87phOnU8kRMUGBSBtreqLmrPIRXj8zBA0sopgFAGrxlXx06y5KOm4Ki82s+Kx/OIGWUTStHGZ6VAJBWH8cbsImg+r8i23BkRoVfM+yWHmKqGkdDhHiFdqETt9gKEYocMQEbsc6lNlZUBW/mdP1DGl3UXNHA+fts781Cq46xRkBzWvE8WvM/pMWQhgiCsZmPtbgs1gqeQwCnQpwo8sqByesScyIVORNS4Ppz193F2M+Dsm4phaQLn+Nh8Phsk1B2VwPBm+mfAIT6jERGqxJfm26KQfCqOJZNVDaYqwH1iW1A3ubF2Ew7upQNs2ajseVszhX8xVvp\" subTotal=\"2719.50\" TipoCambio=\"1.00\" Moneda=\"USD\" total=\"3154.62\" tipoDeComprobante=\"ingreso\" metodoDePago=\"NO IDENTIFICADO\" LugarExpedicion=\"MEXICO\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd\">\n"
                + "  <cfdi:Emisor rfc=\"FFX130322BU1\" nombre=\"FIDEICOMISO F/307831\">\n"
                + "    <cfdi:DomicilioFiscal calle=\"PRESIDENTE MASARIK\" noExterior=\"61\" noInterior=\"PISO 7\" colonia=\"CHAPULTEPEC MORELOS\" municipio=\"MIGUEL HIDALGO,\" estado=\"DF\" pais=\"MEXICO\" codigoPostal=\"11570\" />\n"
                + "    <cfdi:RegimenFiscal Regimen=\"REGIMEN GENERAL PERSONAS MORALES\" />\n"
                + "  </cfdi:Emisor>\n"
                + "  <cfdi:Receptor rfc=\"LVA681016453\" nombre=\"LOGISTICA CLIENTE SA DE CV\">\n"
                + "    <cfdi:Domicilio calle=\"PINO SUAREZ LOTE\" noExterior=\"97\" noInterior=\"MANZANA 3\" colonia=\"EL SABINO\" municipio=\"CUAUTITLAN IZCALLI,\" estado=\"IZCALLI,\" pais=\"MEXICO\" codigoPostal=\"54740\" />\n"
                + "  </cfdi:Receptor>\n"
                + "  <cfdi:Conceptos>\n"
                + "    <cfdi:Concepto cantidad=\"1\" unidad=\"NA\" descripcion=\"CAM (MANTENIMIENTO DE AREAS COMUNES) CORRESPONDIENTE AL MES DE ENERO 2015.ESTA FACTURA DEBERÁ SER PAGADA A MÁS TARDAR EN LOS PRÓXIMOS TRES DÍAS HÁBILES POSTERIORES A SU RECEPCIÓN, EN CASO CONTRARIO PODRÁ SER SUJETA AL COBRO DE INTERESES MORATORIOS.\" valorUnitario=\"2719.50\" importe=\"2719.50\">\n"
                + "      <cfdi:CuentaPredial numero=\"CUENTA PREDIAL 121-06-477-02-0000\" />\n"
                + "    </cfdi:Concepto>\n"
                + "  </cfdi:Conceptos>\n"
                + "  <cfdi:Impuestos totalImpuestosTrasladados=\"435.12\">\n"
                + "    <cfdi:Traslados>\n"
                + "      <cfdi:Traslado impuesto=\"IVA\" tasa=\"16.00\" importe=\"435.12\" />\n"
                + "    </cfdi:Traslados>\n"
                + "  </cfdi:Impuestos>\n"
                + "  <cfdi:Complemento>\n"
                + "    <tfd:TimbreFiscalDigital version=\"1.0\" UUID=\"4CC703F5-AE29-48BC-9EFA-99BB3BD54032\" FechaTimbrado=\"2015-01-02T10:42:34\" selloCFD=\"Tn4zDhyzb8rhSut9p3cnuH6LXZ6V0qcoJGXINVSTJrIPxxvfi+aHItan0g16rUZyv6JCRCVLfyDR3zT96Nbj4hNpLorPu47hPvgy7yYuhRUBHJ7aInzx7VYkeVobvJeNqOQDok8SaZh3OWczg8cBnwWCynfWVKOJrTdh6/hzaH8=\" noCertificadoSAT=\"00001000000202700691\" selloSAT=\"LK8RBxWYLD/wIsmplj1lQDd037EndKFDsz0KXvQc/BVPUcRMuoSWHIJaeqVmtLB/0XyjlpZeuRTGJ48Z2ThsjQn+Ae9iMQw/1Nh16r+rAmzYxds7paUL00hg9F1Je8BrddIeDn163GVyQ36hcNmmWOxOJCGCsF3EWotcoAGzYR0=\" xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/TimbreFiscalDigital/TimbreFiscalDigital.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" />\n"
                + "  </cfdi:Complemento>\n"
                + "  <cfdi:Addenda>\n"
                + "    <ext:InformacionAdicional xsi:schemaLocation=\"http://www.buzone.com.mx/XSD/ParserGenerico/Generico http://www.buzone.com.mx/XSD/ParserGenerico/Generico/AddendaGenerico.xsd\" xmlns:ext=\"http://www.buzone.com.mx/XSD/ParserGenerico/Generico\">\n"
                + "      <ext:SenderID>38746</ext:SenderID>\n"
                + "      <ext:CFDI tipoDocumento=\"FA\" complementoCode=\"\" numeroDocumentos=\"1\" />\n"
                + "      <ext:EMSR etiqueta1E=\"T83101-242753\" valor1E=\"Como consecuencia de las disposiciones vigentes de la legislacion fiscal aplicable, la presente factura electronica se genera y envia a su destinatario en el dia y mes referido en la misma, sin que esto implique que la misma ha sido pagada total o parcialmente. La presente factura se entendera efectivamente pagada solamente en el caso que esta se encuentre acompanada por el original del comprobante de pago de la misma.\" />\n"
                + "      <ext:R conector=\"LVA681016453\" />\n"
                + "      <ext:PTDA idPartida=\"1\" partida=\"Partida 1\" />\n"
                + "    </ext:InformacionAdicional>\n"
                + "  </cfdi:Addenda>\n"
                + "</cfdi:Comprobante>";

        String otroXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><cfdi:Comprobante xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" version=\"3.2\" serie=\"A\" folio=\"622\" fecha=\"2015-01-02T10:42:34\" sello=\"Tn4zDhyzb8rhSut9p3cnuH6LXZ6V0qcoJGXINVSTJrIPxxvfi+aHItan0g16rUZyv6JCRCVLfyDR3zT96Nbj4hNpLorPu47hPvgy7yYuhRUBHJ7aInzx7VYkeVobvJeNqOQDok8SaZh3OWczg8cBnwWCynfWVKOJrTdh6/hzaH8=\" formaDePago=\"PAGO EN UNA SOLA EXHIBICION\" noCertificado=\"00001000000203342284\" certificado=\"MIIEdjCCA16gAwIBAgIUMDAwMDEwMDAwMDAyMDMzNDIyODQwDQYJKoZIhvcNAQEFBQAwggGVMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSEwHwYJKoZIhvcNAQkBFhJhc2lzbmV0QHNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxFDASBgNVBAcMC0N1YXVodMOpbW9jMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxPjA8BgkqhkiG9w0BCQIML1Jlc3BvbnNhYmxlOiBDZWNpbGlhIEd1aWxsZXJtaW5hIEdhcmPDrWEgR3VlcnJhMB4XDTEzMDMyODE4NDkwNFoXDTE3MDMyODE4NDkwNFowgbcxHTAbBgNVBAMTFEZJREVJQ09NSVNPIEYvMzA3ODMxMR0wGwYDVQQpExRGSURFSUNPTUlTTyBGLzMwNzgzMTEdMBsGA1UEChMURklERUlDT01JU08gRi8zMDc4MzExJTAjBgNVBC0THEZGWDEzMDMyMkJVMSAvIFZFT0E1OTA0MjdCMzAxHjAcBgNVBAUTFSAvIFZFT0E1OTA0MjdIREZMUkwwNTERMA8GA1UECxMIRiAzMDc4MzEwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAJgNbYINGo4m4jK6GCXhf1hyX1mWpmQY/4A5y0HMBxsx+LVZ0pt7/OO6B2+xTN8yLqsI+mOvDe4OqyJYQ5DDDt+KbpO/939qqVRW5sXgOcA7CoK32r/f+IYQiW5lzkKZ6LAcb9h7/ugOQ52HZgD7rNyORkMIFfLUCwFjb6PKeaUXAgMBAAGjHTAbMAwGA1UdEwEB/wQCMAAwCwYDVR0PBAQDAgbAMA0GCSqGSIb3DQEBBQUAA4IBAQAnRRNJ+0Q+JB5Qb87phOnU8kRMUGBSBtreqLmrPIRXj8zBA0sopgFAGrxlXx06y5KOm4Ki82s+Kx/OIGWUTStHGZ6VAJBWH8cbsImg+r8i23BkRoVfM+yWHmKqGkdDhHiFdqETt9gKEYocMQEbsc6lNlZUBW/mdP1DGl3UXNHA+fts781Cq46xRkBzWvE8WvM/pMWQhgiCsZmPtbgs1gqeQwCnQpwo8sqByesScyIVORNS4Ppz193F2M+Dsm4phaQLn+Nh8Phsk1B2VwPBm+mfAIT6jERGqxJfm26KQfCqOJZNVDaYqwH1iW1A3ubF2Ew7upQNs2ajseVszhX8xVvp\" subTotal=\"2719.50\" TipoCambio=\"1.00\" Moneda=\"USD\" total=\"3154.62\" tipoDeComprobante=\"ingreso\" metodoDePago=\"NO IDENTIFICADO\" LugarExpedicion=\"MEXICO\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd\">  <cfdi:Emisor rfc=\"FFX130322BU1\" nombre=\"FIDEICOMISO F/307831\">    <cfdi:DomicilioFiscal calle=\"PRESIDENTE MASARIK\" noExterior=\"61\" noInterior=\"PISO 7\" colonia=\"CHAPULTEPEC MORELOS\" municipio=\"MIGUEL HIDALGO,\" estado=\"DF\" pais=\"MEXICO\" codigoPostal=\"11570\" />    <cfdi:RegimenFiscal Regimen=\"REGIMEN GENERAL PERSONAS MORALES\" />  </cfdi:Emisor>  <cfdi:Receptor rfc=\"LVA681016453\" nombre=\"LOGISTICA CLIENTE SA DE CV\">    <cfdi:Domicilio calle=\"PINO SUAREZ LOTE\" noExterior=\"97\" noInterior=\"MANZANA 3\" colonia=\"EL SABINO\" municipio=\"CUAUTITLAN IZCALLI,\" estado=\"IZCALLI,\" pais=\"MEXICO\" codigoPostal=\"54740\" />  </cfdi:Receptor>  <cfdi:Conceptos>    <cfdi:Concepto cantidad=\"1\" unidad=\"NA\" descripcion=\"CAM (MANTENIMIENTO DE AREAS COMUNES) CORRESPONDIENTE AL MES DE ENERO 2015.ESTA FACTURA DEBERÁ SER PAGADA A MÁS TARDAR EN LOS PRÓXIMOS TRES DÍAS HÁBILES POSTERIORES A SU RECEPCIÓN, EN CASO CONTRARIO PODRÁ SER SUJETA AL COBRO DE INTERESES MORATORIOS.\" valorUnitario=\"2719.50\" importe=\"2719.50\">      <cfdi:CuentaPredial numero=\"CUENTA PREDIAL 121-06-477-02-0000\" />    </cfdi:Concepto>  </cfdi:Conceptos>  <cfdi:Impuestos totalImpuestosTrasladados=\"435.12\">    <cfdi:Traslados>      <cfdi:Traslado impuesto=\"IVA\" tasa=\"16.00\" importe=\"435.12\" />    </cfdi:Traslados>  </cfdi:Impuestos>  <cfdi:Complemento>    <tfd:TimbreFiscalDigital version=\"1.0\" UUID=\"4CC703F5-AE29-48BC-9EFA-99BB3BD54032\" FechaTimbrado=\"2015-01-02T10:42:34\" selloCFD=\"Tn4zDhyzb8rhSut9p3cnuH6LXZ6V0qcoJGXINVSTJrIPxxvfi+aHItan0g16rUZyv6JCRCVLfyDR3zT96Nbj4hNpLorPu47hPvgy7yYuhRUBHJ7aInzx7VYkeVobvJeNqOQDok8SaZh3OWczg8cBnwWCynfWVKOJrTdh6/hzaH8=\" noCertificadoSAT=\"00001000000202700691\" selloSAT=\"LK8RBxWYLD/wIsmplj1lQDd037EndKFDsz0KXvQc/BVPUcRMuoSWHIJaeqVmtLB/0XyjlpZeuRTGJ48Z2ThsjQn+Ae9iMQw/1Nh16r+rAmzYxds7paUL00hg9F1Je8BrddIeDn163GVyQ36hcNmmWOxOJCGCsF3EWotcoAGzYR0=\" xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/TimbreFiscalDigital/TimbreFiscalDigital.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" />  </cfdi:Complemento>  <cfdi:Addenda>    <ext:InformacionAdicional xsi:schemaLocation=\"http://www.buzone.com.mx/XSD/ParserGenerico/Generico http://www.buzone.com.mx/XSD/ParserGenerico/Generico/AddendaGenerico.xsd\" xmlns:ext=\"http://www.buzone.com.mx/XSD/ParserGenerico/Generico\">      <ext:SenderID>38746</ext:SenderID>      <ext:CFDI tipoDocumento=\"FA\" complementoCode=\"\" numeroDocumentos=\"1\" />      <ext:EMSR etiqueta1E=\"T83101-242753\" valor1E=\"Como consecuencia de las disposiciones vigentes de la legislacion fiscal aplicable, la presente factura electronica se genera y envia a su destinatario en el dia y mes referido en la misma, sin que esto implique que la misma ha sido pagada total o parcialmente. La presente factura se entendera efectivamente pagada solamente en el caso que esta se encuentre acompanada por el original del comprobante de pago de la misma.\" />      <ext:R conector=\"LVA681016453\" />      <ext:PTDA idPartida=\"1\" partida=\"Partida 1\" />    </ext:InformacionAdicional>  </cfdi:Addenda></cfdi:Comprobante>";
        try {
            System.out.println("XMl ADEDNDA: " + xmlNuevo);
            System.out.println(":::::::");
            new AddendaUtil().buildXMLAddendaDefault(xmlNuevo.getBytes("UTF-8"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
