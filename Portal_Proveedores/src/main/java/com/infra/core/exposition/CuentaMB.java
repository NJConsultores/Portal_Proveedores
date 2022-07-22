package com.infra.core.exposition;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.primefaces.model.DefaultStreamedContent;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_REBATE;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_MULTAS;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_BONESP;
import java.math.BigDecimal;
import java.util.Arrays;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_REBANUAL_CAB;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.infra.core.util.ValidatorUtil;
import java.util.ArrayList;
import org.primefaces.context.RequestContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.infra.core.util.LocaleUtil;
import com.infra.core.util.SessionUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import java.util.Map;
import org.primefaces.model.StreamedContent;
import com.infra.core.model.dto.DatoGenerico;
import java.util.List;
import com.infra.core.model.UsuarioWS;
import org.springframework.beans.factory.annotation.Autowired;
import com.infra.core.service.WSLoginService;
import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.infra.util.AbstractControlador;

@Controller
@Scope("session")
public class CuentaMB extends AbstractControlador
{
    private static final Logger logger;
    private static final long serialVersionUID = 1L;
    @Autowired
    protected WSLoginService loginService;
    @Autowired
    protected InternacionalizacionMB internacionalizacionMB;
    private UsuarioWS usuario;
    protected String password;
    protected String nuevoPassword;
    protected String correo;
    protected String confirmarPassword;
    protected boolean disable;
    private List<DatoGenerico> multas;
    private StreamedContent archivo;
    private Map<String, Object> listados;
    
    static {
        logger = LoggerFactory.getLogger((Class)CuentaMB.class);
    }
    
    @PostConstruct
    public void init() {
        this.password = "";
        this.nuevoPassword = "";
        this.confirmarPassword = "";
        this.correo = "";
        this.buildUsuarioSeguridad();
        this.llenarMultas();
        this.debeCambiarPassword();
        this.almacenarListados();
    }
    
    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
    private void buildUsuarioSeguridad() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final Object principal = authentication.getPrincipal();
            if (principal != null) {
                this.usuario = (UsuarioWS)authentication.getDetails();
            }
            else {
                CuentaMB.logger.debug("El objeto principal es nulo");
            }
        }
    }
    
    public String getNombreCompleto() {
        CuentaMB.logger.debug("Nombre completo");
        this.disable = false;
        final String nombre = null;
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final Object principal = authentication.getPrincipal();
            final UsuarioWS usuario = (UsuarioWS)authentication.getDetails();
            if (usuario != null) {
                return usuario.getNombre();
            }
            CuentaMB.logger.debug("El objeto principal usuario es nulo");
        }
        return nombre;
    }
    
    public String getRfc() {
        CuentaMB.logger.debug("RFC");
        this.disable = false;
        return SessionUtil.getRFCUsuarioActual();
    }
    
    public void cambiarPassword() {
        CuentaMB.logger.debug("Cambiar Password");
        CuentaMB.logger.debug("Cuenta");
        try {
            if (this.validarCampos()) {
                if (this.validaPassword(this.nuevoPassword)) {
                    final Map<String, String> respuesta = (Map<String, String>)this.loginService.actualizarPassword(this.getLanguage(), this.nuevoPassword, this.password, (String)null, this.usuario.getNombreUser());
                    if ("1".equals(respuesta.get("estatus"))) {
                        this.transaccionErronea("Error: ", (String)respuesta.get("mensaje"));
                    }
                    else {
                        this.transaccionCompletada(false, 1, "OK", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.ok"));
                    }
                }
                else {
                    FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.password").replaceAll("\\{0\\}", this.nuevoPassword), ""));
                }
            }
        }
        catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.error")));
        }
    }
    
    private boolean validarCampos() {
        if (this.password == null || this.password.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.actual.requerido")));
            return false;
        }
        if (this.nuevoPassword == null || this.nuevoPassword.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.nueva.requerido")));
            return false;
        }
        if (this.confirmarPassword == null || this.confirmarPassword.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.nueva.confirmar.requerido")));
            return false;
        }
        if (this.nuevoPassword != null && !this.nuevoPassword.isEmpty() && (this.confirmarPassword != null || !this.confirmarPassword.isEmpty()) && !this.nuevoPassword.equals(this.confirmarPassword)) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.password.nuevas.no.coinciden")));
            return false;
        }
        return true;
    }
    
    private boolean validaPassword(final String password) {
        final Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$");
        final Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    private String getLanguage() {
        return "es".equals(this.internacionalizacionMB.getLanguage()) ? "S" : "E";
    }
    
    public void llenarMultas() {
        CuentaMB.logger.debug("llenarMultas");
        this.disable = false;
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final UsuarioWS usuario = (UsuarioWS)authentication.getDetails();
            if (usuario.getMultas() == null) {
                usuario.setMultas("Enc1|valor1|Enc2|valor2|Enc3|valor3");
            }
            if (usuario != null && usuario.getMultas() != null) {
                this.procesarMultas(usuario.getMultas());
            }
            else {
                CuentaMB.logger.debug("El objeto principal usuario es nulo");
            }
        }
    }
    
    private void almacenarListados() {
        this.listados = (Map<String, Object>)this.loginService.cargarMultas(this.getLanguage(), this.usuario.getNombreUser(), "");
    }
    
    public void debeCambiarPassword() {
        CuentaMB.logger.debug("debeCambiarPassword");
        this.disable = false;
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final UsuarioWS usuario = (UsuarioWS)authentication.getDetails();
            if (usuario != null && usuario.isCambiarCorreo()) {
                RequestContext.getCurrentInstance().execute("PF('dlgCorreo').show()");
            }
        }
    }
    
    private void procesarMultas(final String multas) {
        boolean mostrarModal = false;
        String valor = null;
        int posicion = 0;
        if (multas != null && !multas.isEmpty()) {
            final List<DatoGenerico> listado = new ArrayList<DatoGenerico>();
            final String[] arreglo = multas.split("\\|");
            DatoGenerico dato = null;
            for (int pos = 0; pos < arreglo.length; ++pos, ++pos, ++pos) {
                dato = new DatoGenerico();
                dato.setIdDato(arreglo[pos]);
                valor = arreglo[pos + 1];
                dato.setNombre(valor);
                posicion = valor.indexOf(".");
                valor = valor.substring(0, posicion);
                valor = valor.replaceAll(",", "");
                if (!mostrarModal && Integer.parseInt(valor) > 0) {
                    mostrarModal = true;
                }
                dato.setRelacion(arreglo[pos + 2]);
                listado.add(dato);
            }
            this.multas = listado;
        }
        else {
            this.multas = null;
        }
        if (mostrarModal) {
            RequestContext.getCurrentInstance().execute("PF('dlgMultas').show()");
        }
    }
    
    public static void main(final String[] args) {
        final String cadena = "0.00";
        try {
            final int entero = new Integer(cadena);
            System.out.println("entero: " + entero);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean validaCorreo() {
        boolean esValido = false;
        esValido = ValidatorUtil.validaCorreo(this.correo);
        if (!esValido) {
            this.transaccionErronea("Error", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.email").replaceAll("\\{0\\}", this.correo));
        }
        return esValido;
    }
    
    public void actualizarCorreo() {
        CuentaMB.logger.debug("actualizarCorreo");
        try {
            if (this.validaCorreo()) {
                final Map<String, String> respuesta = (Map<String, String>)this.loginService.actualizarCorreo(this.getLanguage(), this.correo, this.usuario.getNombreUser());
                if ("1".equals(respuesta.get("estatus"))) {
                    this.transaccionErronea("Error: ", (String)respuesta.get("mensaje"));
                }
                else {
                    this.transaccionCompletada(false, 1, "OK", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.correo.ok"));
                }
            }
            else {
                FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("error.cuenta.cambio.correo").replaceAll("\\{0\\}", this.correo)));
                RequestContext.getCurrentInstance().execute("PF('recargar').show()");
            }
        }
        catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", LocaleUtil.getResourceBundle().getString("msg.cuenta.cambio.correo.error")));
        }
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getNuevoPassword() {
        return this.nuevoPassword;
    }
    
    public void setNuevoPassword(final String nuevoPassword) {
        this.nuevoPassword = nuevoPassword;
    }
    
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(final String correo) {
        this.correo = correo;
    }
    
    public String getConfirmarPassword() {
        return this.confirmarPassword;
    }
    
    public void setConfirmarPassword(final String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }
    
    public boolean isDisable() {
        return this.disable;
    }
    
    public void setDisable(final boolean disable) {
        this.disable = disable;
    }
    
    public void setUsuario(final UsuarioWS usuario) {
        this.usuario = usuario;
    }
    
    public UsuarioWS getUsuario() {
        return this.usuario;
    }
    
    public List<DatoGenerico> getMultas() {
        return this.multas;
    }
    
    public void setMultas(final List<DatoGenerico> multas) {
        this.multas = multas;
    }
    
    public StreamedContent descargarXLS(final String claveArchivo) throws IOException {
        StreamedContent out = null;
        final XSSFWorkbook workbook = new XSSFWorkbook();
        final XSSFSheet sheet = workbook.createSheet(claveArchivo);
        try {
            String[] encabezados = null;
            int rowCount = 0;
            int columnCount = 0;
            Row row = null;
            final List<Object> lista = null;
            switch (claveArchivo) {
                case "S_REB_ANUAL": {
                    encabezados = new String[] { "Proveedor", "Nombre", "Compra a\u00f1o anterior", "Compra a\u00f1o actual", "Diferencia compra", "% de variaci\u00f3n", "% adendum", "Rebate", "Moneda" };
                    final List<ZPORTAL_S_REBANUAL_CAB> multasDetalle = Arrays.asList((ZPORTAL_S_REBANUAL_CAB[])this.listados.get("S_DETALLE_MULTAS"));
                    if (multasDetalle != null) {
                        for (final ZPORTAL_S_REBANUAL_CAB obj : multasDetalle) {
                            ++rowCount;
                            row = (Row)sheet.createRow(rowCount);
                            columnCount = 0;
                            Cell cell = row.createCell(columnCount++);
                            if (obj.getEMLIF() instanceof String) {
                                cell.setCellValue(obj.getEMLIF());
                            }
                            cell = row.createCell(columnCount++);
                            if (obj.getNAME1() instanceof String) {
                                cell.setCellValue(obj.getNAME1());
                            }
                            cell = row.createCell(columnCount++);
                            if (obj.getCALC_ANT() instanceof BigDecimal) {
                                cell.setCellValue(obj.getCALC_ANT().doubleValue());
                            }
                            cell = row.createCell(columnCount++);
                            if (obj.getCALC_ACT() instanceof BigDecimal) {
                                cell.setCellValue(obj.getCALC_ACT().doubleValue());
                            }
                            cell = row.createCell(columnCount++);
                            if (obj.getCALC_DIF() instanceof BigDecimal) {
                                cell.setCellValue(obj.getCALC_DIF().doubleValue());
                            }
                            cell = row.createCell(columnCount++);
                            if (obj.getCALC_VAR() instanceof BigDecimal) {
                                cell.setCellValue(obj.getCALC_VAR().doubleValue());
                            }
                            cell = row.createCell(columnCount++);
                            if (obj.getBONO_APL() instanceof BigDecimal) {
                                cell.setCellValue(obj.getBONO_APL().doubleValue());
                            }
                            cell = row.createCell(columnCount++);
                            if (obj.getBONO_ANUAL() instanceof BigDecimal) {
                                cell.setCellValue(obj.getBONO_ANUAL().doubleValue());
                            }
                            cell = row.createCell(columnCount++);
                            if (obj.getWAERS() instanceof String) {
                                cell.setCellValue(obj.getWAERS());
                            }
                        }
                        break;
                    }
                    break;
                }
                case "S_BONIF_ESP": {
                    encabezados = new String[] { "Proveedor", "Raz\u00f3n social", "Importe total a descontar por NC", "Motivo" };
                    final List<ZPORTAL_S_BONESP> bonificacionesEsp = Arrays.asList((ZPORTAL_S_BONESP[])this.listados.get("S_BONIF_ESP"));
                    if (bonificacionesEsp != null) {
                        for (final ZPORTAL_S_BONESP obj2 : bonificacionesEsp) {
                            ++rowCount;
                            row = (Row)sheet.createRow(rowCount);
                            columnCount = 0;
                            Cell cell2 = row.createCell(columnCount++);
                            if (obj2.getEMLIF() instanceof String) {
                                cell2.setCellValue(obj2.getEMLIF());
                            }
                            cell2 = row.createCell(columnCount++);
                            if (obj2.getNAME1() instanceof String) {
                                cell2.setCellValue(obj2.getNAME1());
                            }
                            cell2 = row.createCell(columnCount++);
                            if (obj2.getDMONTO() instanceof BigDecimal) {
                                cell2.setCellValue(obj2.getDMONTO().doubleValue());
                            }
                            cell2 = row.createCell(columnCount++);
                            if (obj2.getCOMENTARIO() instanceof String) {
                                cell2.setCellValue(obj2.getCOMENTARIO());
                            }
                        }
                        break;
                    }
                    break;
                }
                case "S_MULTAS": {
                    encabezados = new String[] { "Fecha de OC", "Documento compras", "Posici\u00f3n", "No. Proveedor", "Nombre Proveedor", "C\u00f3digo Infra", "Material Proveedor", "Descripci\u00f3n", "Cantidad solicitada", "Cantidad surtida", "Cantidad pendiente", "Fecha Limite para entrega", "Fecha de entrega del Material", "Fecha de Ultima Entrega del material", "Precio del material", "Importe total OC", "Importe total entregado", "Importe pendiente por surtir", "Importe Entrega Tard\u00eda", "Importe FR", "Importe Multa", "Importe total a Descontar por NC" };
                    final List<ZPORTAL_S_MULTAS> multas = Arrays.asList((ZPORTAL_S_MULTAS[])this.listados.get("S_MULTAS"));
                    if (multas != null) {
                        for (final ZPORTAL_S_MULTAS obj3 : multas) {
                            ++rowCount;
                            row = (Row)sheet.createRow(rowCount);
                            columnCount = 0;
                            Cell cell3 = row.createCell(columnCount++);
                            if (obj3.getAEDAT() instanceof String) {
                                cell3.setCellValue(obj3.getAEDAT());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getEBELN() instanceof String) {
                                cell3.setCellValue(obj3.getEBELN());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getEBELP() instanceof String) {
                                cell3.setCellValue(obj3.getEBELP());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getEMLIF() instanceof String) {
                                cell3.setCellValue(obj3.getEMLIF());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getNAME1() instanceof String) {
                                cell3.setCellValue(obj3.getNAME1());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getMATNR() instanceof String) {
                                cell3.setCellValue(obj3.getMATNR());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getIDNLF() instanceof String) {
                                cell3.setCellValue(obj3.getIDNLF());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getTXZ01() instanceof String) {
                                cell3.setCellValue(obj3.getTXZ01());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getMENGE() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getMENGE().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getWEMNG() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getWEMNG().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getCALC_PEND() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getCALC_PEND().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getEINDT() instanceof String) {
                                cell3.setCellValue(obj3.getEINDT());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getEINDT_MAT() instanceof String) {
                                cell3.setCellValue(obj3.getEINDT_MAT());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getEINDT_PROV() instanceof String) {
                                cell3.setCellValue(obj3.getEINDT_PROV());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getNETPR() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getNETPR().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getNETWR() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getNETWR().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getCALC_ENTR() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getCALC_ENTR().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getCAPC_PEND() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getCAPC_PEND().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getCALC_TARD() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getCALC_TARD().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getMDESCU_1_FR() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getMDESCU_1_FR().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getMDESCU_1() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getMDESCU_1().doubleValue());
                            }
                            cell3 = row.createCell(columnCount++);
                            if (obj3.getCALC_TD() instanceof BigDecimal) {
                                cell3.setCellValue(obj3.getCALC_TD().doubleValue());
                            }
                        }
                        break;
                    }
                    break;
                }
                case "S_BONIFICACIONES": {
                    encabezados = new String[] { "Documento compras", "Posici\u00f3n", "Proveedor", "Raz\u00f3n social", "Fecha de OC", "Fecha entrega de material", "C\u00f3digo Infra", "Material proveedor", "Descripci\u00f3n", "Cantidad solicitada", "Cantidad surtida", "Cantidad pendiente", "Precio material", "Importe total OC", "Importe total entregado", "Importe pendiente por surtir", "% Merma", "% Distribuci\u00f3n", "% Publicidad y mercadotecnia", "Importe merma", "Importe distribuci\u00f3n", "Importe publicidad y mercadotecnia", "Importe total a descontar por nota de cr\u00e9dito" };
                    final List<ZPORTAL_S_REBATE> bonificaciones = Arrays.asList((ZPORTAL_S_REBATE[])this.listados.get("S_BONIFICACIONES"));
                    if (bonificaciones != null) {
                        for (final ZPORTAL_S_REBATE obj4 : bonificaciones) {
                            ++rowCount;
                            row = (Row)sheet.createRow(rowCount);
                            columnCount = 0;
                            Cell cell4 = row.createCell(columnCount++);
                            if (obj4.getEBELN() instanceof String) {
                                cell4.setCellValue(obj4.getEBELN());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getEBELP() instanceof String) {
                                cell4.setCellValue(obj4.getEBELP());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getEMLIF() instanceof String) {
                                cell4.setCellValue(obj4.getEMLIF());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getNAME1() instanceof String) {
                                cell4.setCellValue(obj4.getNAME1());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getBEDAT() instanceof String) {
                                cell4.setCellValue(obj4.getBEDAT());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getBUDAT_F() instanceof String) {
                                cell4.setCellValue(obj4.getBUDAT_F());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getMATNR() instanceof String) {
                                cell4.setCellValue(obj4.getMATNR());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getIDNLF() instanceof String) {
                                cell4.setCellValue(obj4.getIDNLF());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getTXZ01() instanceof String) {
                                cell4.setCellValue(obj4.getTXZ01());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getMENGE() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getMENGE().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getMENGE_E() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getMENGE_E().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getCALC_VPE() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getCALC_VPE().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getNETPR() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getNETPR().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getNETWR_P() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getNETWR_P().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getCALC_VNE() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getCALC_VNE().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getNETWR_T() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getNETWR_T().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getCALC_PAM() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getCALC_PAM().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getCALC_PAD() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getCALC_PAD().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getCALC_PAPM() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getCALC_PAPM().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getNETWR_M() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getNETWR_M().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getNETWR_D() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getNETWR_D().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getNETWR_PM() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getNETWR_PM().doubleValue());
                            }
                            cell4 = row.createCell(columnCount++);
                            if (obj4.getCALC_TD() instanceof BigDecimal) {
                                cell4.setCellValue(obj4.getCALC_TD().doubleValue());
                            }
                        }
                        break;
                    }
                    break;
                }
                default:
                    break;
            }
            if (claveArchivo.equals("S_REB_ANUAL")) {
                columnCount = 0;
                row = (Row)sheet.createRow(0);
                String[] array;
                for (int length = (array = encabezados).length, i = 0; i < length; ++i) {
                    final String encabezado = array[i];
                    final Cell cell2 = row.createCell(columnCount);
                    if (encabezado instanceof String) {
                        cell2.setCellValue(encabezado);
                    }
                    ++columnCount;
                }
                encabezados = new String[] { "A\u00f1o", "Mes", "Proveedor", "Pedido", "C\u00f3digo", "Descripci\u00f3n", "Monto" };
                rowCount += 5;
                columnCount = 0;
                row = (Row)sheet.createRow(rowCount);
                String[] array2;
                for (int length2 = (array2 = encabezados).length, j = 0; j < length2; ++j) {
                    final String encabezado = array2[j];
                    final Cell cell2 = row.createCell(columnCount);
                    if (encabezado instanceof String) {
                        cell2.setCellValue(encabezado);
                    }
                    ++columnCount;
                }
                final List<ZPORTAL_S_REBANUAL> rebAnual = Arrays.asList((ZPORTAL_S_REBANUAL[])this.listados.get("S_REB_ANUAL"));
                if (rebAnual != null) {
                    for (final ZPORTAL_S_REBANUAL obj5 : rebAnual) {
                        ++rowCount;
                        row = (Row)sheet.createRow(rowCount);
                        columnCount = 0;
                        Cell cell3 = row.createCell(columnCount++);
                        if (obj5.getGJAHR() instanceof String) {
                            cell3.setCellValue(obj5.getGJAHR());
                        }
                        cell3 = row.createCell(columnCount++);
                        if (obj5.getMONAT() instanceof String) {
                            cell3.setCellValue(obj5.getMONAT());
                        }
                        cell3 = row.createCell(columnCount++);
                        if (obj5.getEMLIF() instanceof String) {
                            cell3.setCellValue(obj5.getEMLIF());
                        }
                        cell3 = row.createCell(columnCount++);
                        if (obj5.getEBELN() instanceof String) {
                            cell3.setCellValue(obj5.getEBELN());
                        }
                        cell3 = row.createCell(columnCount++);
                        if (obj5.getMATNR() instanceof String) {
                            cell3.setCellValue(obj5.getMATNR());
                        }
                        cell3 = row.createCell(columnCount++);
                        if (obj5.getMAKTX() instanceof String) {
                            cell3.setCellValue(obj5.getMAKTX());
                        }
                        cell3 = row.createCell(columnCount++);
                        if (obj5.getBRTWR() instanceof BigDecimal) {
                            cell3.setCellValue(obj5.getBRTWR().doubleValue());
                        }
                    }
                }
            }
            else {
                rowCount = 0;
                columnCount = 0;
                row = (Row)sheet.createRow(rowCount);
                String[] array3;
                for (int length3 = (array3 = encabezados).length, k = 0; k < length3; ++k) {
                    final String encabezado = array3[k];
                    final Cell cell2 = row.createCell(columnCount);
                    if (encabezado instanceof String) {
                        cell2.setCellValue(encabezado);
                    }
                    ++columnCount;
                }
            }
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            workbook.write((OutputStream)output);
            output.close();
            final InputStream inputStream = new ByteArrayInputStream(output.toByteArray());
            out = (StreamedContent)new DefaultStreamedContent(inputStream, "application/xls", String.valueOf(claveArchivo) + ".XLSX");
        }
        catch (Exception e) {
            this.transaccionErronea("Error: ", String.valueOf(LocaleUtil.getResourceBundle().getString("msg.multas.error.descarga")) + " ::: " + e.getMessage());
            RequestContext.getCurrentInstance().execute("PF('dlgCorreo').show()");
        }
        return out;
    }
    
    public StreamedContent getArchivo() {
        return this.archivo;
    }
    
    public void setArchivo(final StreamedContent archivo) {
        this.archivo = archivo;
    }
    
    public Map<String, Object> getListados() {
        return this.listados;
    }
    
    public void setListados(final Map<String, Object> listados) {
        this.listados = listados;
    }
}
 