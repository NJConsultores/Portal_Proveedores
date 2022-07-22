package com.infra.factura.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

import com.infra.cliente.model.Archivo;

/**
 * Clase de utilidades para archivos
 * @since 25-04-13
 * @author infra
 */
public class FileUtil {
	private final static Logger LOGGER = Logger.getLogger(FileUtil.class);
	private static final int BUFFER = 65536;
	
//	private PropiedadesUtil propiedadesUtil;
	/**
	 * Constructor de clase
	 * @since 25-04-13
	 */
	public FileUtil() {
	}
	
//	
//	/**
//	 * @return the propiedadesUtil
//	 */
//	public PropiedadesUtil getPropiedadesUtil() {
//		return propiedadesUtil;
//	}
//
//
//	/**
//	 * @param propiedadesUtil the propiedadesUtil to set
//	 */
//	public void setPropiedadesUtil(PropiedadesUtil propiedadesUtil) {
//		this.propiedadesUtil = propiedadesUtil;
//	}


	/**
	 * @param contenidoEscribir
	 * @param rutaCompleta 
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean escribeArchivo(String contenidoEscribir,String rutaCompleta) throws IOException{
		File 			file = null;
		BufferedWriter 	bw	 = null;
		PrintWriter 	wr 	 = null;
		FileWriter 		w 	 = null;
		boolean esExito = false;
		System.out.println("Inicio de la escritura de archivo");
		try{
			file = new File(rutaCompleta);
			
			w = new FileWriter(file);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
			
			if(!contenidoEscribir.equals("")){
				contenidoEscribir+="|";
			}
			wr.write(contenidoEscribir);
			wr.append("|");
			LOGGER.info("Termina Escritura de archivo");
			esExito = true;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(wr != null){
				wr.close();
				wr = null;
			}
			if(bw != null){
				bw.close();
				bw = null;
			}
		}
		
		return esExito;
	}
	
	/**
	 * Metodo que borra el archivo especificado en determinad ruta
	 * @since 29-04-13
	 * @param nombreArchivo	: {@link String}
	 * @param RUTA  			: {@link String}
	 * @throws Exception
	 */
	public static void borradoFinalizadosOk(final String RUTA,final String nombreArchivo) throws Exception {
		 LOGGER.info("Entra borradoFinalizadosOk");
		 File file = null;
		try{
			
			if(nombreArchivo == null){
				file = new File(RUTA);
			}else{
				file = new File(RUTA + nombreArchivo);
			}
			if(file.exists()){
				if(file.delete()){
					LOGGER.info("El archivo borrado satisfactoriamente: "+file.getName());
				}else{
					LOGGER.info("El archivo no pudo ser borrado: "+file.getName());
				}
			}else{
				LOGGER.info("El archivo no existe: "+ file.getName());
			}
			 LOGGER.info("Finaliza borradoFinalizadosOk");
		}catch(Exception ex){
			LOGGER.error("No se pudo realizar el borrado del archivo");
			throw new Exception("No se pudo realizar el borrado del archivo");
		}
		
	}
	
	/**
	 * MEtodo que regresa el contenido de un archivo
	 * a partir de la ruta proporcionada
	 * @param rutaArchivo
	 * @return {@link StringBuffer}
	 * @throws IOException
	 */
	public static StringBuffer readFile(final String rutaArchivo) throws IOException {

		StringBuffer text = new StringBuffer();
		
		File fileFact = new File(rutaArchivo);
		
		if(fileFact.exists()){
		
			BufferedReader bufferedReader = null;
	
			try {
				FileReader lector=new FileReader(rutaArchivo);
				
				bufferedReader = new BufferedReader(lector);
	
				char[] buffer = new char[1024 * 16];
				int length;
	
				while ((length = bufferedReader.read(buffer)) != -1) {
					text.append(buffer, 0, length);
				}
			}
			finally {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			}
		}

		return text;
	}
	
	/**
	 * Metodo para copiar el fichero source en el fichero destination
	 * devuelve true si funciona correctamente
	 * @param sourcePath		: {@link File}
	 * @param destinationPath	: {@link File}
	 * @return	boolean		: {@link Boolean}
	 * @throws Exception
	 */
	public static Boolean copiar(final String sourcePath, final String destinationPath) throws Exception
	{
	        boolean resultado = false;
	        // declaración del flujo
	        java.io.FileInputStream sourceFile=null;
	        java.io.FileOutputStream destinationFile=null;
	        try {
	        		File source = new File(sourcePath);
	        		File destination = new File(destinationPath);
	                // creamos fichero
	                destination.createNewFile();
	                // abrimos flujo
	                sourceFile = new java.io.FileInputStream(source);
	                destinationFile = new java.io.FileOutputStream(destination);
	                // lectura por segmentos de 0.5Mb
	                byte buffer[]=new byte[512*1024];
	                int nbLectura;
	                while( (nbLectura = sourceFile.read(buffer)) != -1 ) {
	                        destinationFile.write(buffer, 0, nbLectura);
	                }
	                // copia correcta
	                resultado = true;
	        } catch( java.io.FileNotFoundException f ) {
	        	throw new FileNotFoundException("FileUtil.copiar - No existe el archivo o ruta");
	        } catch( java.io.IOException e ) {
	        	throw new IOException("FileUtil.copiar - No existe el archivo o ruta",e);
	        } finally {
	                // pase lo que pase, cerramos flujo
	                try {
	                        sourceFile.close();
	                } catch(Exception e) { }
	                try {
	                        destinationFile.close();
	                } catch(Exception e) { }
	        }
	        return( resultado );
	}
	
	/**
	 * Main para prueba de clase
	 * @param args : {@link String}
	 */
	public static void main(String...args){
		//String xml = "<?xml version='1.0' encoding='UTF-8'?> <cfdi:Comprobante xmlns:cfdi='http://www.sat.gob.mx/cfd/3' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv3.xsd' version='3.0' folio='709' fecha='2011-04-14T10:13:10' sello='MypxM/YD4vtisUFS7GdEtluT+opccxaRIviYtZcV5K1NX81A8nN8T2KFBuxDKMhyyhWN/lTzRLXAUjrQ6GS5qJ7srBCfnb7VhwsseAH9SeiXQ1EMKl7TK8HRyVgzDOIDwTz9WMQ6lXHZidnl/F2zxDYmEoMHxDpr+S1/XxXpxus=' formaDePago='Pago en una sola exhibición' noCertificado='00001000000102723184' certificado='MIIEMzCCAxugAwIBAgIUMDAwMDEwMDAwMDAxMDI3MjMxODQwDQYJKoZIhvcNAQEFBQAwggE2MTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExHzAdBgkqhkiG9w0BCQEWEGFjb2RzQHNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxEzARBgNVBAcMCkN1YXVodGVtb2MxMzAxBgkqhkiG9w0BCQIMJFJlc3BvbnNhYmxlOiBGZXJuYW5kbyBNYXJ0w61uZXogQ29zczAeFw0xMTAxMjkyMDIwMDlaFw0xMzAxMjgyMDIwMDlaMIHTMScwJQYDVQQDEx5UVVJJU1RJQ0EgRElWRVJUUk9OSUsgU0EgREUgQ1YxJzAlBgNVBCkTHlRVUklTVElDQSBESVZFUlRST05JSyBTQSBERSBDVjEnMCUGA1UEChMeVFVSSVNUSUNBIERJVkVSVFJPTklLIFNBIERFIENWMSUwIwYDVQQtExxUREk5MDA4MTVDQTEgLyBGT01KNTYxMjA2R1AzMR4wHAYDVQQFExUgLyBGT01KNTYxMjA2SFlOTE5SMDIxDzANBgNVBAsTBk1BVFJJWjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAuErE8gQP+K5LyWZqfQBZuiJ17JJgeA+qq0vRzZuipszIsMSkxF29HTdVEh79RGQ2kKD9UY9IuY0Z76wpMND5N59ZjS/SfV+AvyGv37UYmupq4TQxLEGWWyRQeGZtD8529KB+lz5brxchPi7sUyrrUunx/h9byQuQhyBdAA4LWlsCAwEAAaMdMBswDAYDVR0TAQH/BAIwADALBgNVHQ8EBAMCBsAwDQYJKoZIhvcNAQEFBQADggEBAItjIN9MuA82cpTikOuDUniLWi9w3i5arZ0neLAHRYq4VzSfGreP5fuQ9xPKLLnT34swcHsoZReiCwGZIC1YKMnL5oAZjnaFy/+xVZT/Yv5ZDhmU+4j0M1j9wcM9JCvOxlmZW1HEazjn4qCyaKiEYpgpTWbcGHU48Ix4aSXVInMLRX9dI0L4NZ7j4lh6RNX0MwaN3hd+u8NId3QXr7uk3591Pxu78rUSNbtg3+mJnvxDsTvGwKznBIgDFhfwd7bFOl7iDX/ThjH6HsGR+NoGm6qiTL7L8jqo9LmVc7fttUzCifj+4geqtdmQcQ/L2V+GKaAaAIYQwngzWvIIVs+stPM=' subTotal='508.4900' Moneda='MXN' total='600.0000' tipoDeComprobante='ingreso'> <cfdi:Emisor rfc='TDI900815CA1' nombre='TURÍSTICA DIVERTRONIK SA DE CV'> <cfdi:DomicilioFiscal calle='AV JUAREZ ENTRE 61-A Y AV CAMARON' noExterior='320' colonia='MORELOS' municipio='CD DEL CARMEN' estado='Campeche' pais='México' codigoPostal='24115' /> </cfdi:Emisor> <cfdi:Receptor rfc='PHA820319Q36' nombre='PRODUCTOS DE HARINA S.A. DE C.V.'> <cfdi:Domicilio calle='CALLE 32 X 21 Y 28 A' noExterior='231' colonia='GARCIA GINERES' municipio='MERIDA' estado='Yucatán' pais='México' codigoPostal='97070' /> </cfdi:Receptor> <cfdi:Conceptos> <cfdi:Concepto cantidad='1000.0' unidad='HAB.317' descripcion='SERVICIO DE HOSPEDAJE POR UNA NOCHE DEL 13 AL 14 DE ABRIL.' valorUnitario='508.4900' importe='508.4900' /></cfdi:Conceptos> <cfdi:Impuestos totalImpuestosTrasladados='91.5100'> <cfdi:Traslados> <cfdi:Traslado impuesto='IVA' tasa='16.0000' importe='81.3500' /> <cfdi:Traslado impuesto='IVA' tasa='2.0000' importe='10.1600' /> </cfdi:Traslados> </cfdi:Impuestos> <cfdi:Complemento> <tfd:TimbreFiscalDigital xmlns:tfd='http://www.sat.gob.mx/TimbreFiscalDigital' version='1.0' xsi:schemaLocation='http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/sitio_internet/TimbreFiscalDigital/TimbreFiscalDigital.xsd' UUID='ACE16524-BC96-4A6F-BDC2-EA58A013D228' FechaTimbrado='2011-04-14T10:13:17' selloCFD='MypxM/YD4vtisUFS7GdEtluT+opccxaRIviYtZcV5K1NX81A8nN8T2KFBuxDKMhyyhWN/lTzRLXAUjrQ6GS5qJ7srBCfnb7VhwsseAH9SeiXQ1EMKl7TK8HRyVgzDOIDwTz9WMQ6lXHZidnl/F2zxDYmEoMHxDpr+S1/XxXpxus=' noCertificadoSAT='00001000000102508041' selloSAT='ezzl1i6Nnjjfbrxkg5E7yxV5RBB2S2ZrlqGX7THfNh/wJ5BfbbmC/KvUQerPlHLSe+i++Lmf+AiKAOcWCOcUd3ZDelDkBc/WTdIQBk9F43kwZD7tiClU01175a3lRVGY8APJtOX8Y3AXcNE6UNTyNBOdXUnG0kkKqxnwTc3SpuY=' /> </cfdi:Complemento> </cfdi:Comprobante>";
		
		/*FeFacturaDtoHtml facturaDtoHtml = new FeFacturaDtoHtml();
		facturaDtoHtml.setIdFactura(22);
		
		facturaDtoHtml.setXmlComprobante(xml);*/
		try {
			//escribeArchivoEnRuta("C:\\filesWS\\", facturaDtoHtml);
			//FileUtil.borradoFinalizadosOk("87.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] cargaProveedores(final String rutaArchivo){
		StringBuffer sbf = new StringBuffer();
		String[] aProveedores = null;
		
		try {
			sbf = readFile(rutaArchivo);
			if(sbf != null && sbf.length()>0){
				aProveedores = sbf.toString().split(",");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return aProveedores;
	}
	
	public static String getNombreArchivo(Archivo archivo){
		StringBuilder stb = new StringBuilder();
    	
    	if(archivo.getUuid() != null && archivo.getUuid().trim().length() > 0){
	    	if(archivo.getRfcEmisor() != null && archivo.getRfcEmisor().trim().length() > 0){
	    		stb.append(archivo.getRfcEmisor().trim().toUpperCase() + "-");
	    	}
	    	
	    	if(archivo.getUuid() != null && archivo.getUuid().trim().length() > 0){
	    		stb.append(archivo.getUuid().trim().toUpperCase() + "-");
	    	}
    	}else{
    		if(archivo.getNumCta() != null && archivo.getNumCta().trim().length() > 0){
	    		stb.append(archivo.getRfcEmisor().trim().toUpperCase() + "-");
	    	}
	    	
	    	if(archivo.getFolio() != null && archivo.getFolio().trim().length() > 0){
	    		stb.append(archivo.getFolio().trim().toUpperCase() + "-");
	    	}
    	}
    	
    	return stb.toString().substring(0, stb.toString().length() - 1);
    }
	
	public static void generaArchivoBuffer(InputStream origin, ZipOutputStream out, String nombreArchivo) throws Exception {
		int count = 0;
		byte data[] = new byte[BUFFER];
		
		ZipEntry entry = new ZipEntry(nombreArchivo);
	    out.putNextEntry(entry);
	    
	    while((count = origin.read(data, 0, BUFFER)) != -1) {
	    	out.write(data, 0, count);
	    }
	    
	    out.flush();
	    out.closeEntry();
	}
}
