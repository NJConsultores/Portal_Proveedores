package com.infra.factura.exposition;

import com.infra.core.model.dto.ArchivoAdjuntoDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.function.Function;
import java.util.Comparator;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;
import com.infra.factura.util.Base64;
import java.io.IOException;
import com.infra.factura.business.schema.util.StringAndInputstreamUtil;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_ADENDA;
import com.infra.service.RadendaRequest;
import com.infra.core.util.LocaleUtil;
import java.util.Map;
import com.infra.core.util.ValidatorUtil;
import java.util.Arrays;
import com.infra.core.util.SessionUtil;
import org.primefaces.event.FileUploadEvent;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import com.infra.util.MyBasicProfiler;
import org.slf4j.LoggerFactory;
import com.infra.util.FileUploadDto;
import org.primefaces.model.UploadedFile;
import java.util.List;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_LSOC;
import com.infra.core.exposition.InternacionalizacionMB;
import com.infra.cliente.service.ws.WSFactura;
import org.springframework.beans.factory.annotation.Autowired;
import com.infra.cliente.service.ws.WSService;
import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.infra.util.AbstractControlador;

@Controller
@Scope("session")
public class AddendaMB extends AbstractControlador
{
    private static final long serialVersionUID = 1L;
    private static final Logger logger;
    @Autowired
    private WSService wsService;
    @Autowired
    private WSFactura wsFactura;
    @Autowired
    private InternacionalizacionMB internacionalizacionMB;
    private ZPORTAL_S_LSOC sociedad;
    private List<ZPORTAL_S_LSOC> sociedades;
    private List<UploadedFile> archivos;
    private List<FileUploadDto> archivosDto;
    
    static {
        logger = LoggerFactory.getLogger((Class)PeticionOfertaMB.class);
    }
    
    public void reset() {
        System.out.println("reset La memoria maxima es: " + MyBasicProfiler.getHeapMaxSize());
        System.out.println("reset La memoria usada es: " + MyBasicProfiler.getHeapFreeSize());
        if (this.tienePermiso("ROLE_ADDENDA") && !FacesContext.getCurrentInstance().isPostback()) {
            this.sociedad = null;
            this.loadSociedades();
            this.archivos = new ArrayList<UploadedFile>();
        }
    }
    
    public void reset(final boolean limpiar) {
        System.out.println("reset limpiar La memoria maxima es: " + MyBasicProfiler.getHeapMaxSize());
        System.out.println("reset limpiar La memoria usada es: " + MyBasicProfiler.getHeapFreeSize());
        if (this.tienePermiso("ROLE_ADDENDA") && limpiar) {
            this.sociedad = null;
            this.loadSociedades();
            this.archivos = new ArrayList<UploadedFile>();
        }
    }
    
    public void resetConsulta() {
        if (this.tienePermiso("ROLE_ADDENDA") && !FacesContext.getCurrentInstance().isPostback()) {
            this.sociedad = null;
            this.loadSociedades();
        }
    }
    
    public void loadEscenarios() {
    }
    
    public void manejadorArchivo(final FileUploadEvent event) {
        System.out.println(String.valueOf(this.archivos.size() + 1) + " - manejadorArchivo: " + event.getFile().getFileName());
        this.archivos.add(event.getFile());
    }
    
    public String getLanguage() {
        return "es".equals(this.internacionalizacionMB.getLanguage()) ? "S" : "E";
    }
    
    private void loadSociedades() {
        try {
            AddendaMB.logger.info("Cargando sociedades del proveedor");
            this.sociedades = new ArrayList<ZPORTAL_S_LSOC>();
            final Map<String, Object> respuesta = (Map<String, Object>)this.wsService.getSociedades(this.getLanguage(), SessionUtil.getUsuarioActual());
            if ("1".equals(respuesta.get("estatus"))) {
                this.transaccionErronea("Error: ", (String)respuesta.get("mensaje"));
            }
            else {
                this.sociedades = Arrays.asList((ZPORTAL_S_LSOC[])respuesta.get("lista"));
                if (!ValidatorUtil.isEmpty((List)this.sociedades)) {
                    if (this.sociedades.size() == 1) {
                        this.sociedad = this.sociedades.get(0);
                    }
                    else {
                        this.sociedad = null;
                        AddendaMB.logger.info("El usuario tiene mas de un sociedad");
                    }
                }
                else {
                    this.sociedad = null;
                }
            }
        }
        catch (Exception e) {
            AddendaMB.logger.error("Error al cargar las sociedades", (Throwable)e);
        }
    }
    
    public void guardarFacturas() {
        System.out.println("La memoria maxima es: " + MyBasicProfiler.getHeapMaxSize());
        System.out.println("La memoria usada es: " + MyBasicProfiler.getHeapFreeSize());
        System.out.println("guardarFacturas: " + MyBasicProfiler.getUsedMemory());
        final long startTime = System.currentTimeMillis();
        try {
            if (this.sociedad == null) {
                this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.sociedad"));
                return;
            }
            if (!this.validaPares()) {
                return;
            }
            if (!this.validarExtensionesArchivos()) {
                return;
            }
            if (!this.validaNumeroPorNombre()) {
                return;
            }
            if (!this.validarXML()) {
                return;
            }
            System.out.println("va a mandar las facturas: " + this.archivos.size());
            RadendaRequest request = new RadendaRequest();
            request.setSociedad(this.sociedad.getBUKRS());
            request.setProveedor(SessionUtil.getUsuarioActual());
            request.setIdioma(this.getLanguage());
            request.setFacturas(this.ordenarFacturas());
            System.out.println("Tamanio guardarFacturas: " + MyBasicProfiler.getSize(request));
            System.out.println("guardarFacturas.size: " + MyBasicProfiler.getSize(request));
            System.out.println("guardarFacturas antes raddenda: " + MyBasicProfiler.getUsedMemory());
            final Map<String, Object> respuesta = (Map<String, Object>)this.wsFactura.radenda(request);
            request = null;
            if ("0".equals(respuesta.get("estatus"))) {
                this.transaccionCompletada(false, 1, "OK", LocaleUtil.getResourceBundle().getString("msg.addenda.ok"));
                this.archivos = new ArrayList<UploadedFile>();
                request = null;
            }
            else {
                request = null;
                this.transaccionErronea("Error: ", (String)respuesta.get("mensaje"));
            }
        }
        catch (Exception e) {
            AddendaMB.logger.error("Error al cargar las facturas con addenda", (Throwable)e);
            this.transaccionErronea("Error: ", e.getMessage());
        }
        System.out.println("mando las facturas: " + this.archivos.size());
    }
    
    public void eliminaArchivo(final UploadedFile archivo) {
        this.archivos.remove(archivo);
    }
    
    private ZPORTAL_S_ADENDA[] ordenarFacturas() {
        final ZPORTAL_S_ADENDA[] facturas = new ZPORTAL_S_ADENDA[this.archivos.size() / 2];
        String cadenaXML = "";
        byte[] bytesPDF = null;
        String nombreArchivo = "";
        String nombreArchivoCompleto = "";
        int contadorCoincidencias = 0;
        int contadorFactura = 0;
        ZPORTAL_S_ADENDA obj = new ZPORTAL_S_ADENDA();
        for (final FileUploadDto file : this.archivosDto) {
            nombreArchivoCompleto = file.getNombreArchivo();
            System.out.println("nombreArchivoCompleto: " + nombreArchivoCompleto);
            if (nombreArchivo.equals(file.getNombreArchivo().substring(0, file.getNombreArchivo().lastIndexOf("."))) && nombreArchivoCompleto.toLowerCase().endsWith(".xml")) {
                try {
                    if (file != null) {
                        cadenaXML = StringAndInputstreamUtil.convertStreamToString(file.getArchivo().getInputstream());
                    }
                }
                catch (IOException e) {
                    System.out.println("Surgio un error al convertir XML a String");
                    e.printStackTrace();
                }
                obj.setXML(Base64.encodeBase64String(cadenaXML.getBytes()));
                ++contadorCoincidencias;
            }
            else {
                nombreArchivo = file.getNombreArchivo().substring(0, file.getNombreArchivo().lastIndexOf("."));
                try {
                    if (file != null) {
                        bytesPDF = IOUtils.toByteArray(file.getArchivo().getInputstream());
                    }
                }
                catch (IOException e) {
                    System.out.println("Surgio un error al convertir PDF a String");
                    e.printStackTrace();
                }
                obj.setPDF(Base64.encodeBase64String(bytesPDF));
                contadorCoincidencias = 1;
            }
            if (contadorCoincidencias == 2) {
                facturas[contadorFactura] = obj;
                obj = new ZPORTAL_S_ADENDA();
                ++contadorFactura;
            }
        }
        return facturas;
    }
    
    private boolean validarExtensionesArchivos() {
        for (final UploadedFile file : this.archivos) {
            if (!file.getFileName().toLowerCase().endsWith(".pdf") && !file.getFileName().toLowerCase().endsWith(".xml")) {
                this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.addenda.error.numero"));
                return false;
            }
        }
        return true;
    }
    
    private boolean validaPares() {
        boolean isValido = true;
        if (this.archivos.size() % 2 != 0) {
            this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.addenda.error.numero"));
            isValido = false;
        }
        return isValido;
    }
    
    private boolean validaNumeroPorNombre() {
        boolean isValido = true;
        this.archivosDto = new ArrayList<FileUploadDto>();
        for (final UploadedFile fi : this.archivos) {
            this.archivosDto.add(new FileUploadDto(fi, fi.getFileName().toLowerCase()));
        }
        this.archivosDto.sort(Comparator.comparing((Function<? super FileUploadDto, ? extends Comparable>)FileUploadDto::getNombreArchivo));
        String nombreArchivo = "";
        int contadorCoincidencias = 0;
        for (final FileUploadDto file : this.archivosDto) {
            if (nombreArchivo.equals(file.getNombreArchivo().substring(0, file.getNombreArchivo().lastIndexOf(".")))) {
                if (++contadorCoincidencias > 2) {
                    isValido = false;
                    this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.addenda.error.numero"));
                    break;
                }
                continue;
            }
            else {
                if (contadorCoincidencias == 1) {
                    isValido = false;
                    this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("msg.addenda.error.numero"));
                    break;
                }
                nombreArchivo = file.getNombreArchivo().substring(0, file.getNombreArchivo().lastIndexOf("."));
                contadorCoincidencias = 1;
            }
        }
        return isValido;
    }
    
    private boolean validarXML() {
        boolean isValido = false;
        final long startTime = System.currentTimeMillis();
        StringBuilder msg = null;
        msg = new StringBuilder();
        try {
            String contenido = null;
            for (final UploadedFile file : this.archivos) {
                if (file.getFileName().toLowerCase().endsWith(".xml")) {
                    AddendaMB.logger.info("Validar XML " + new SimpleDateFormat("dd/MM/yyyHH:mm:ss").format(new Date()));
                    AddendaMB.logger.debug("XML Size: " + file.getSize());
                    byte[] dataXML = IOUtils.toByteArray(file.getInputstream());
                    if (dataXML.length > 0) {
                        contenido = new String(dataXML);
                        if (contenido.contains("cfdi:Addenda")) {
                            isValido = true;
                        }
                        else {
                            msg.append("|" + file.getFileName());
                            isValido = false;
                        }
                    }
                    dataXML = null;
                }
            }
        }
        catch (Exception e) {
            isValido = false;
            AddendaMB.logger.error("Error al cargar el comprobante", (Throwable)e);
            msg.append(e.getMessage());
        }
        if (!isValido) {
            this.transaccionErronea("Error", String.valueOf(LocaleUtil.getResourceBundle().getString("msg.comprobante.addenda.incorrecto")) + " :: " + msg.toString());
        }
        return isValido;
    }
    
    private boolean tienePermiso(final String permiso) {
        final SecurityContext context = SecurityContextHolder.getContext();
        final Authentication authentication = context.getAuthentication();
        final boolean tienePermiso = authentication.getAuthorities().contains(new SimpleGrantedAuthority(permiso));
        if (!tienePermiso) {
            throw new AccessDeniedException("Acci\u00f3n no permitida");
        }
        return tienePermiso;
    }
    
    public InternacionalizacionMB getInternacionalizacionMB() {
        return this.internacionalizacionMB;
    }
    
    public void setInternacionalizacionMB(final InternacionalizacionMB internacionalizacionMB) {
        this.internacionalizacionMB = internacionalizacionMB;
    }
    
    public ZPORTAL_S_LSOC getSociedad() {
        return this.sociedad;
    }
    
    public void setSociedad(final ZPORTAL_S_LSOC sociedad) {
        this.sociedad = sociedad;
    }
    
    public List<ZPORTAL_S_LSOC> getSociedades() {
        return this.sociedades;
    }
    
    public void setSociedades(final List<ZPORTAL_S_LSOC> sociedades) {
        this.sociedades = sociedades;
    }
    
    public List<UploadedFile> getArchivos() {
        return this.archivos;
    }
    
    public void setArchivos(final List<UploadedFile> archivos) {
        this.archivos = archivos;
    }
    
    public WSService getWsService() {
        return this.wsService;
    }
    
    public void setWsService(final WSService wsService) {
        this.wsService = wsService;
    }
    
    public WSFactura getWsFactura() {
        return this.wsFactura;
    }
    
    public void setWsFactura(final WSFactura wsFactura) {
        this.wsFactura = wsFactura;
    }
    
    public static void main(final String[] args) {
        final String nombreArchivo = "D00109607.XML";
        nombreArchivo.toLowerCase().endsWith(".xml");
        System.out.println("termina con xml: " + nombreArchivo.toLowerCase().endsWith(".xml"));
        System.out.println("Nombre archivo en minusculas: " + nombreArchivo);
        ArchivoAdjuntoDto dto = new ArchivoAdjuntoDto();
        final List<ArchivoAdjuntoDto> archivos = new ArrayList<ArchivoAdjuntoDto>();
        dto.setNombre("D00109607.pdf");
        archivos.add(dto);
        dto = new ArchivoAdjuntoDto();
        dto.setNombre("D00109607.xml");
        archivos.add(dto);
        dto = new ArchivoAdjuntoDto();
        dto.setNombre("D00111433.XML");
        archivos.add(dto);
        dto = new ArchivoAdjuntoDto();
        dto.setNombre("D00111433.pdf");
        archivos.add(dto);
        dto = new ArchivoAdjuntoDto();
        dto.setNombre("D00111548.XML");
        archivos.add(dto);
        dto = new ArchivoAdjuntoDto();
        dto.setNombre("D00111548.pdf");
        archivos.add(dto);
        archivos.sort(Comparator.comparing((Function<? super ArchivoAdjuntoDto, ? extends Comparable>)ArchivoAdjuntoDto::getNombre));
    }
}

