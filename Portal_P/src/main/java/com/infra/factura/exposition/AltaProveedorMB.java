package com.infra.factura.exposition;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.infra.cliente.service.ws.WSService;
import com.infra.core.exposition.InternacionalizacionMB;
import com.infra.core.util.LocaleUtil;
import com.infra.core.util.ValidatorUtil;
import com.infra.factura.util.Base64;
import com.infra.factura.util.ConstantesGenerales;
import com.infra.service.LregionRequest;
import com.infra.service.ProvrRequest;
import com.infra.util.AbstractControlador;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_LSOC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_NPROV;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_NPROV_A;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_REGION;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Controller
@Scope("session")
public class AltaProveedorMB extends AbstractControlador {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(AltaProveedorMB.class);
	@Autowired
	private WSService wsService;
	@Autowired
	private InternacionalizacionMB internacionalizacionMB;

	/**
	 * Para alta de proveedor
	 */
	private UploadedFile acta;
	private UploadedFile poder;
	private UploadedFile situacion;
	private UploadedFile estadoCuenta;
	private UploadedFile ine;
	private UploadedFile comprobante;
	private UploadedFile formato;
	private ZPORTAL_S_LSOC sociedad;
	private List<ZPORTAL_S_LSOC> sociedades;
	private ZPORTAL_S_REGION region;
	private List<ZPORTAL_S_REGION> regiones;

	private String rfc;
	private String razonSocial;
	private String calle;
	private String colonia;
	private String numero;
	private String cp;
	private String municipio;

	private String nombreRepresentante;
	private String cuenta;
	private String nombreBanco;
	private String correoProveedor;
	private String correoContactoInfra;

	private boolean isMoral;
	
	
	 public void  onload(){
		    // Do something
		 String asd = "As223";
		 transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.cp.check")
					.replaceAll("\\{0\\}", asd));
		 }

	
	/*
	 * Prueba
	 */
	
	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla
	 */
	public void reset() {
		if (!FacesContext.getCurrentInstance().isPostback()) {
			sociedad = null;
			loadSociedades();
			acta = null;
			poder = null;
			situacion = null;
			estadoCuenta = null;
			ine = null;
			comprobante = null;
			formato = null;
			rfc = null;
			razonSocial = null;
			nombreRepresentante = null;
			cuenta = null;
			nombreBanco = null;
			correoProveedor = null;
			correoContactoInfra = null;
			isMoral = false;

			calle = null;
			numero = null;
			cp = null;
			municipio = null;
			colonia = null;
			region = null;
		}
	}

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla
	 */
	public void reset(boolean limpiar) {
		if (limpiar) {
			sociedad = null;
			loadSociedades();
			acta = null;
			poder = null;
			situacion = null;
			estadoCuenta = null;
			ine = null;
			comprobante = null;
			formato = null;
			rfc = null;
			razonSocial = null;
			nombreRepresentante = null;
			cuenta = null;
			nombreBanco = null;
			correoProveedor = null;
			correoContactoInfra = null;
			isMoral = false;

			calle = null;
			numero = null;
			cp = null;
			municipio = null;
			colonia = null;
			region = null;
		}
	}

	public void validaTipoPersona() {
		isMoral = false;
		if (null != rfc && !rfc.isEmpty()) {
			if (validarRFC())
				// isMoral = !(rfc.length() == 13);
				isMoral = !(rfc.length() == 13);
		}
	} 

	public boolean validarRFC() {
		final Matcher matcher = Pattern.compile(ConstantesGenerales.RFC_PATTERN).matcher(rfc);
		if (!matcher.matches()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.rfc.invalido"));
			RequestContext.getCurrentInstance().execute("PF('wid_prueba').show()");
			return false;
		}
		return true;
	}

	public void loadEscenarios() {
	}

	// public void manejadorPdf(FileUploadEvent event) {
	// this.setPdf(event.getFile());
	// }

	public String getLanguage() {
		return ("es".equals(internacionalizacionMB.getLanguage()) ? "S" : "E");
	}

	private void loadSociedades() {
		try {
			logger.info("Cargando sociedades del proveedor");
			sociedades = new ArrayList<>();
			Map<String, Object> respuesta = wsService.getSociedades(getLanguage(), "");
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				sociedades = Arrays.asList((ZPORTAL_S_LSOC[]) respuesta.get("lista"));
				if (!ValidatorUtil.isEmpty(sociedades)) {
					if (sociedades.size() == 1) {
						sociedad = sociedades.get(0);
					} else {
						sociedad = null;
						logger.info("El usuario tiene mas de un sociedad");
					}
				} else {
					sociedad = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar las sociedades", e);
		}
		loadRegiones();
	}

	private void loadRegiones() {
		try {
			logger.info("Cargando regiones para el alta del proveedor");
			regiones = new ArrayList<>();
			LregionRequest request = new LregionRequest();
			request.setIdioma(getLanguage());
			Map<String, Object> respuesta = wsService.lregion(request);
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
				regiones = Arrays.asList((ZPORTAL_S_REGION[]) respuesta.get("lista"));
				if (!ValidatorUtil.isEmpty(regiones)) {
					if (regiones.size() == 1) {
						region = regiones.get(0);
					} else {
						region = null;
					}
				} else {
					region = null;
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar las regiones", e);
		}
	}

	private boolean validarDatos() {
		if (null == sociedad) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
			return false;
		}
		if (null == rfc || rfc.trim().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.rfc.invalido"));
			return false;
		}
		if (null == razonSocial || razonSocial.trim().isEmpty()) {
			transaccionErronea("Error",
					LocaleUtil.getResourceBundle().getString("error.proveedor.columna.razon.social.obigatorio"));
			return false;
		}
		if (null == region) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.estado.seleccionar"));
			return false;
		}
		if (null == cuenta) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.cuenta.seleccionar"));
			return false;
		}
		// if (null == nombreBanco) {
		// transaccionErronea("Error",
		// LocaleUtil.getResourceBundle().getString("msg.alta_prov.banco.seleccionar"));
		// return;
		// }
		if (null == calle || calle.isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.direccion.calle"));
			return false;
		}
		if (null == numero || numero.isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.direccion.numero"));
			return false;
		}
		if (null == cp || cp.isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.direccion.cp"));
			return false;
		}
		if (null == colonia || colonia.isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.direccion.colonia"));
			return false;
		}
		if (null == municipio || municipio.isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.direccion.municipio"));
			return false;
		}
		if (isMoral()) { // es persona moral
			if (null == nombreRepresentante) {
				transaccionErronea("Error",
						LocaleUtil.getResourceBundle().getString("msg.alta_prov.representanteLegal.seleccionar"));
				return false;
			}
			if (null == acta || acta.getFileName().isEmpty()) {
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.pdf.acta.requerido"));
				return false;
			} else if (!acta.getFileName().endsWith(".pdf") && !acta.getFileName().endsWith(".PDF")) {
				transaccionErronea("Error",
						MessageFormat.format(
								LocaleUtil.getResourceBundle().getString("msg.error.archivo.extension.pdf"),
								(acta.getFileName())));
				return false;
			}
			if (null == poder || poder.getFileName().isEmpty()) {
				transaccionErronea("Error",
						LocaleUtil.getResourceBundle().getString("msg.alta_prov.poder.seleccionar"));
				return false;
			} else if (!poder.getFileName().endsWith(".pdf") && !poder.getFileName().endsWith(".PDF")) {
				transaccionErronea("Error",
						MessageFormat.format(
								LocaleUtil.getResourceBundle().getString("msg.error.archivo.extension.pdf"),
								(poder.getFileName())));
				return false;
			}
		}
		if (null == situacion || situacion.getFileName().isEmpty()) {
			transaccionErronea("Error",
					LocaleUtil.getResourceBundle().getString("msg.alta_prov.situacion.seleccionar"));
			return false;
		} else if (!situacion.getFileName().endsWith(".pdf") && !situacion.getFileName().endsWith(".PDF")) {
			transaccionErronea("Error",
					MessageFormat.format(
							LocaleUtil.getResourceBundle().getString("msg.error.archivo.extension.pdf"),
							(situacion.getFileName())));
			return false;
		}
		if (null == ine || ine.getFileName().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.ine.seleccionar"));
			return false;
		} else if (!ine.getFileName().endsWith(".pdf") && !ine.getFileName().endsWith(".PDF")) {
			transaccionErronea("Error",
					MessageFormat.format(
							LocaleUtil.getResourceBundle().getString("msg.error.archivo.extension.pdf"),
							(ine.getFileName())));
			return false;
		}
		if (null == estadoCuenta || estadoCuenta.getFileName().isEmpty()) {
			transaccionErronea("Error",
					LocaleUtil.getResourceBundle().getString("msg.alta_prov.estadoCuenta.seleccionar"));
			return false;
		} else if (!estadoCuenta.getFileName().endsWith(".pdf") && !estadoCuenta.getFileName().endsWith(".PDF")) {
			transaccionErronea("Error",
					MessageFormat.format(LocaleUtil.getResourceBundle().getString("msg.error.archivo.extension.pdf"),
							(estadoCuenta.getFileName())));
			return false;
		}
		if (null == comprobante || comprobante.getFileName().isEmpty()) {
			transaccionErronea("Error",
					LocaleUtil.getResourceBundle().getString("msg.alta_prov.comprobante.seleccionar"));
			return false;
		} else if (!comprobante.getFileName().endsWith(".pdf") && !comprobante.getFileName().endsWith(".PDF")) {
			transaccionErronea("Error", MessageFormat.format(
					LocaleUtil.getResourceBundle().getString("msg.error.archivo.extension.pdf"), (comprobante.getFileName())));
			return false;
		}
		if (null == formato || formato.getFileName().isEmpty()) {
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.alta_prov.formato.seleccionar"));
			return false;
		} else if (!formato.getFileName().endsWith(".pdf") && !formato.getFileName().endsWith(".PDF")) {
			transaccionErronea("Error", MessageFormat.format(
					LocaleUtil.getResourceBundle().getString("msg.error.archivo.extension.pdf"), (formato.getFileName())));
			return false;
		}
		return true;
	}

	public void guardarProveedor() {
		logger.info("guardarProveedor");
		try {
			if (validarDatos()) {

				ZPORTAL_S_NPROV proveedor = new ZPORTAL_S_NPROV();
				proveedor.setBUKRS(sociedad.getBUKRS());
				proveedor.setCORREO_INFRA(correoContactoInfra);
				proveedor.setCORREO(correoProveedor);
				proveedor.setCALLE(calle);
				proveedor.setCOLONIA(colonia);
				proveedor.setCP(cp);
				proveedor.setCUENTA(cuenta);
				proveedor.setMUNIC(municipio);
				proveedor.setESTADO(region.getREGION());
				proveedor.setNOMBRE(razonSocial);
				proveedor.setNUM(numero);
				proveedor.setREP_LEGAL(null != nombreRepresentante ? nombreRepresentante : "");
				proveedor.setRFC(rfc);

				ZPORTAL_S_NPROV_A archivos = new ZPORTAL_S_NPROV_A();

				byte[] bytesActa = null;
				byte[] bytesPoder = null;
				byte[] bytesSituacion = null;
				byte[] bytesEstadoCta = null;
				byte[] bytesINE = null;
				byte[] bytesComprobante = null;
				byte[] bytesFormato = null;
				try {
					if (null != acta)
						bytesActa = IOUtils.toByteArray(acta.getInputstream());
					if (null != poder)
						bytesPoder = IOUtils.toByteArray(poder.getInputstream());
					if (null != situacion)
						bytesSituacion = IOUtils.toByteArray(situacion.getInputstream());
					if (null != estadoCuenta)
						bytesEstadoCta = IOUtils.toByteArray(estadoCuenta.getInputstream());
					if (null != ine)
						bytesINE = IOUtils.toByteArray(ine.getInputstream());
					if (null != comprobante)
						bytesComprobante = IOUtils.toByteArray(comprobante.getInputstream());
					if (null != formato)
						bytesFormato = IOUtils.toByteArray(formato.getInputstream());
				} catch (IOException e) {
					logger.info("guardarProveedor excp: "+e.getMessage());
					e.printStackTrace();
				}
				
				try {
					archivos.setACTA(bytesActa != null ? Base64.encodeBase64String(bytesActa) : "");
					archivos.setPODER(bytesPoder != null ? Base64.encodeBase64String(bytesPoder) : "");
					archivos.setSITUACION(bytesSituacion != null ? Base64.encodeBase64String(bytesSituacion) : "");
					archivos.setEDOCTA(bytesEstadoCta != null ? Base64.encodeBase64String(bytesEstadoCta) : "");
					archivos.setIFE_REP(bytesINE != null ? Base64.encodeBase64String(bytesINE) : "");
					archivos.setCOMP_DOMI(bytesComprobante != null ? Base64.encodeBase64String(bytesComprobante) : "");
					archivos.setFORMATO(bytesFormato != null ? Base64.encodeBase64String(bytesFormato) : "");
				} catch (Exception e) {
					logger.info("guardarProveedor excp al asignar archivos: "+e.getMessage());
					e.printStackTrace();
				}

				logger.info("guardarProveedor ya asigno archivos");
				ProvrRequest request = new ProvrRequest();
				request.setIdioma(getLanguage());
				request.setProveedor(proveedor);
				request.setArchivos(archivos);
				logger.info("guardarProveedor mandar llamar provr ");
				Map<String, Object> respuesta = wsService.provr(request);
				if ("0".equals((String) respuesta.get("estatus"))) {
					transaccionCompletada(false, SEVERITY_FACES_CORRECTO, "OK", MessageFormat.format(
							LocaleUtil.getResourceBundle().getString("msg.proveedor.registro.ok"), (razonSocial)));
					reset();
				} else {
					transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
				}
			}
		} catch (Exception e) {
			transaccionErronea("Error: ", e.getMessage());
			logger.info("Error al guardar el proveedor", e.getMessage());
		}

	}
	
	//Nuevo Junio 2022
	//Razon Social X
	public boolean validarazonSocial() {
		boolean esValido = false;
		if (razonSocial == null && razonSocial.isEmpty()) { 
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.razonSocial"));
		}
		return esValido;
	}
	//nombreRepresentante x
	public boolean validanombreRepresentante() {
		boolean esValido = false;
		if (nombreRepresentante == null && nombreRepresentante.isEmpty()) { 
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.nombreRepresentante"));
		}
		return esValido;
	}
	//Cuenta Bancaria o CLABE x
	public boolean validacuenta() {
		boolean esValido = false;
		if (cuenta == null && cuenta.isEmpty()) { 
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.cuenta"));
		}
		return esValido;
	}  
	//Calle x
	public boolean validaCalle() {
		boolean esValido = false;
		if (calle == null && calle.isEmpty()) { 
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.calle"));
		}
		return esValido;
	}
	//Código postal. x
	public boolean validacp() {
		boolean esValido = false;
		if (cp == null && cp.isEmpty()) { 
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.cp"));
		}
		return esValido;
	}
	//Colonia.
	public boolean validacolonia() {
		boolean esValido = false;
		if (colonia == null && colonia.isEmpty()) { 
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.colonia"));
		}
		return esValido;
	}
	//Municipio o delegación. x
	public boolean validamunicipio() {
		boolean esValido = false;
		if (municipio == null && municipio.isEmpty()) { 
			transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.municipio"));
		}
		return esValido;
	}
	
	//

	public boolean validaCorreoProveedor() {
		boolean esValido = false;
		if (null != correoProveedor) {
			esValido = ValidatorUtil.validaCorreo(correoProveedor);
			if (!esValido)
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.email")
						.replaceAll("\\{0\\}", correoProveedor));
		}
		return esValido;
	}
	
	
	//Codigo Postal
	public boolean validaCodigoPostal() {
		boolean esValido = false;
		int lcp;
		lcp = cp.length();  
		if (lcp < 5) {
			System.out.println("Lenght  "+ lcp);
			//esValido = ValidatorUtil.validaCorreo(correoProveedor);
			esValido = false;
			System.out.println("Band  "+ esValido);
			if (!esValido){ 
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.cp.check")
						.replaceAll("\\{0\\}", cp));
				
			}
		}
		return esValido;
	}
	//Codigo Postal
	
	//CLABE
	public boolean validaCLABE() {
		boolean esValido = false;
		int lcuenta;
		lcuenta = cuenta.length();  
		if (lcuenta < 18) {
			System.out.println("Lenght  "+ lcuenta);
			//esValido = ValidatorUtil.validaCorreo(correoProveedor);
			esValido = false; 
			if (!esValido){ 
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.CLABE")
						.replaceAll("\\{0\\}", cuenta));
				
			}
		}
		return esValido;
	}
	//CLABE

	public boolean validaCorreoContacto() {
		boolean esValido = false;
		if (null != correoContactoInfra) {
			esValido = ValidatorUtil.validaCorreo(correoContactoInfra);
			if (!esValido)
				transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.email")
						.replaceAll("\\{0\\}", correoContactoInfra));
		}
		return esValido;
	}

	public InternacionalizacionMB getInternacionalizacionMB() {
		return internacionalizacionMB;
	}

	public void setInternacionalizacionMB(InternacionalizacionMB internacionalizacionMB) {
		this.internacionalizacionMB = internacionalizacionMB;
	}

	public ZPORTAL_S_LSOC getSociedad() {
		return sociedad;
	}

	public void setSociedad(ZPORTAL_S_LSOC sociedad) {
		this.sociedad = sociedad;
	}

	public List<ZPORTAL_S_LSOC> getSociedades() {
		return sociedades;
	}

	public void setSociedades(List<ZPORTAL_S_LSOC> sociedades) {
		this.sociedades = sociedades;
	}

	public UploadedFile getActa() {
		return acta;
	}

	public void setActa(UploadedFile acta) {
		this.acta = acta;
	}

	public UploadedFile getPoder() {
		return poder;
	}

	public void setPoder(UploadedFile poder) {
		this.poder = poder;
	}

	public UploadedFile getSituacion() {
		return situacion;
	}

	public void setSituacion(UploadedFile situacion) {
		this.situacion = situacion;
	}

	public UploadedFile getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(UploadedFile estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public UploadedFile getIne() {
		return ine;
	}

	public void setIne(UploadedFile ine) {
		this.ine = ine;
	}

	public UploadedFile getComprobante() {
		return comprobante;
	}

	public void setComprobante(UploadedFile comprobante) {
		this.comprobante = comprobante;
	}

	public UploadedFile getFormato() {
		return formato;
	}

	public void setFormato(UploadedFile formato) {
		this.formato = formato;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNombreRepresentante() {
		return nombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public String getCorreoProveedor() {
		return correoProveedor;
	}

	public void setCorreoProveedor(String correoProveedor) {
		this.correoProveedor = correoProveedor;
	}

	public String getCorreoContactoInfra() {
		return correoContactoInfra;
	}

	public void setCorreoContactoInfra(String correoContactoInfra) {
		this.correoContactoInfra = correoContactoInfra;
	}

	public boolean isMoral() {
		return isMoral;
	}

	public void setMoral(boolean isMoral) {
		this.isMoral = isMoral;
	}

	public ZPORTAL_S_REGION getRegion() {
		return region;
	}

	public void setRegion(ZPORTAL_S_REGION region) {
		this.region = region;
	}

	public List<ZPORTAL_S_REGION> getRegiones() {
		return regiones;
	}

	public void setRegiones(List<ZPORTAL_S_REGION> regiones) {
		this.regiones = regiones;
	}

}
