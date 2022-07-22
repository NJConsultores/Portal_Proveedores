package com.infra.factura.exposition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.infra.cliente.service.ws.WSService;
import com.infra.core.exposition.InternacionalizacionMB;
import com.infra.core.util.CoreConstantes;
import com.infra.core.util.LocaleUtil;
import com.infra.core.util.SessionUtil;
import com.infra.core.util.ValidatorUtil;
import com.infra.factura.util.FeConstantes;
import com.infra.proveedor.service.EnviarListadoService;
import com.infra.util.AbstractControlador;

import functions.rfc.sap.document.sap_com.ZPORTAL_S_LSOC;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
@Controller()
@Scope("session")
public class ListadoPreciosMB extends AbstractControlador {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ListadoPreciosMB.class);
	@Autowired
	private InternacionalizacionMB internacionalizacionMB;
	@Autowired
	private EnviarListadoService enviarListadoService;
	@Autowired
	private WSService wsService;

	private int NUMERO_COLUMNAS = 4;

	private UploadedFile xls;
	private ZPORTAL_S_LSOC sociedad;
	private List<ZPORTAL_S_LSOC> sociedades;

	/**
	 * Metodo para limpiar la informacion cuando entra a pantalla de listado de
	 * precios nueva
	 */
	public void reset() {
		if (tienePermiso("ROLE_V_CFDI_OC")) {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				sociedad = null;
				loadSociedades();
				xls = null;
			}
		}
	}

	public void loadEscenarios() {
	}

	public void cargarArchivo() {
		// if (null == sociedad) {
		// transaccionErronea("Error",
		// LocaleUtil.getResourceBundle().getString("error.sociedad"));
		// return;
		// }
		if (validarXLS() && validarColumnas()) {
			try {
				enviarListadoService.enviarListado(xls);
			} catch (Exception e) {
				transaccionErronea("Error", e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public String getLanguage() {
		return ("es".equals(internacionalizacionMB.getLanguage()) ? "S" : "E");
	}

	private void loadSociedades() {
		try {
			logger.info("Cargando sociedades del proveedor");
			sociedades = new ArrayList<>();
			Map<String, Object> respuesta = wsService.getSociedades(getLanguage(), SessionUtil.getUsuarioActual());
			if ("1".equals((String) respuesta.get("estatus"))) {
				transaccionErronea("Error: ", (String) respuesta.get("mensaje"));
			} else {
//				sociedades = (List<ZPORTAL_S_LSOC>) respuesta.get("lista");
				
				ZPORTAL_S_LSOC[] listado = (ZPORTAL_S_LSOC[]) respuesta.get("lista");
				sociedades = Arrays.asList(listado);
				
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
	}

	private boolean tienePermiso(String permiso) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		boolean tienePermiso = authentication.getAuthorities().contains(new SimpleGrantedAuthority(permiso));
		if (!tienePermiso) {
			throw new AccessDeniedException(CoreConstantes.ACCION_NO_PERMITIDA);
		}
		return tienePermiso;
	}

	public boolean validarXLS() {
		boolean isValido = true;
		StringBuilder msg = null;
		msg = new StringBuilder();
		try {
			logger.info("Validar XLS " + new SimpleDateFormat("dd/MM/yyyHH:mm:ss").format(new Date()));
			logger.debug("XLS Size: " + xls.getSize());
			if (xls.getSize() <= 0) {
				if (xls.getSize() > FeConstantes.TAMANIO_MAXIMO_ARCHIVOS_1300KB) {
					isValido = false;
					msg.append(LocaleUtil.getResourceBundle().getString("msg.tam.archivo"));
				}
			}
			if (!xls.getFileName().toLowerCase().endsWith(".xlsx")) {
				isValido = false;
				msg.append(LocaleUtil.getResourceBundle().getString("msg.archivo.tipo.xls").replaceAll("\\{0\\}",
						xls.getFileName()));
			}
		} catch (Exception e) {
			isValido = false;
			logger.error("Error al cargar el XLS", e);
		}
		if (!isValido) {
			transaccionErronea(LocaleUtil.getResourceBundle().getString("msg.Error.formato.archivos"), msg.toString());
		}
		return isValido;
	}

	private boolean validarColumnas() {
		boolean isValido = true;
		int numeroColumna = 0;
		int numeroRegistro = 0;
		StringBuilder mensaje = null;
		mensaje = new StringBuilder();

		try {
			// FileInputStream excelFile = new FileInputStream(new
			// File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(xls.getInputstream());
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			// no leer los cabeceros, asi que los recorremos
			iterator.next();
			numeroRegistro = 1;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				numeroColumna = 0;
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if (0 == numeroColumna && (null == currentCell.getStringCellValue()
							|| currentCell.getStringCellValue().isEmpty())) {
						isValido = false;
						mensaje.append(MessageFormat.format(
								LocaleUtil.getResourceBundle().getString("proveedor.listado.carga.validacion"),
								(numeroRegistro + 1), (numeroColumna + 1)));
					}
					if (1 == numeroColumna && (currentCell.getCellTypeEnum() != CellType.NUMERIC
							|| currentCell.getNumericCellValue() == 0)) {
						isValido = false;
						mensaje.append(MessageFormat.format(
								LocaleUtil.getResourceBundle().getString("proveedor.listado.carga.validacion"),
								(numeroRegistro + 1), (numeroColumna + 1)));
					}
					if (2 == numeroColumna && (currentCell.getCellTypeEnum() != CellType.NUMERIC
							|| currentCell.getNumericCellValue() == 0)) {
						isValido = false;
						mensaje.append(MessageFormat.format(
								LocaleUtil.getResourceBundle().getString("proveedor.listado.carga.validacion"),
								(numeroRegistro + 1), (numeroColumna + 1)));
					}
					if (3 == numeroColumna && (currentCell.getCellTypeEnum() != CellType.NUMERIC
							|| currentCell.getNumericCellValue() == 0)) {
						isValido = false;
						mensaje.append(MessageFormat.format(
								LocaleUtil.getResourceBundle().getString("proveedor.listado.carga.validacion"),
								(numeroRegistro + 1), (numeroColumna + 1)));
					}
					if (numeroColumna > 3) {
						isValido = false;
						mensaje.append(MessageFormat.format(
								LocaleUtil.getResourceBundle().getString("proveedor.listado.carga.validacion.columnas"),
								(numeroRegistro + 1), NUMERO_COLUMNAS));
					}
					numeroColumna++;
				}
				numeroRegistro++;
			}
//			System.out.println("Mensaje resultante: " + mensaje.toString());
			if (!isValido) {
				transaccionErronea("Error", mensaje.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isValido;
	}

	public StreamedContent descargarFormato() {
		InputStream stream = null;
		stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/listaPreciosNuevos_layout.xlsx");
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return new DefaultStreamedContent(stream, externalContext.getMimeType("listaPreciosNuevos_layout.xlsx"),
				"listaPreciosNuevos_layout.xlsx");
	}

	public InternacionalizacionMB getInternacionalizacionMB() {
		return internacionalizacionMB;
	}

	public void setInternacionalizacionMB(InternacionalizacionMB internacionalizacionMB) {
		this.internacionalizacionMB = internacionalizacionMB;
	}

	public EnviarListadoService getEnviarListadoService() {
		return enviarListadoService;
	}

	public void setEnviarListadoService(EnviarListadoService enviarListadoService) {
		this.enviarListadoService = enviarListadoService;
	}

	public WSService getWsService() {
		return wsService;
	}

	public void setWsService(WSService wsService) {
		this.wsService = wsService;
	}

	public UploadedFile getXls() {
		return xls;
	}

	public void setXls(UploadedFile xls) {
		this.xls = xls;
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

	private static final String FILE_NAME = "C:/Users/reyna.laguna/Documents/Personal/GrupoInfra/Documentacion/listaPreciosNuevos_layout_pruebas.xlsx";

	public static void main(String[] args) {
		int numeroColumna = 0;
		int numeroRegistro = 0;
		boolean isValido = true;
		String mensaje = "";
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			// no leer los cabeceros, asi que los recorremos
			iterator.next();
			numeroRegistro = 1;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				numeroColumna = 0;
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if (0 == numeroColumna && (null == currentCell.getStringCellValue()
							|| currentCell.getStringCellValue().isEmpty())) {
						isValido = false;
						mensaje += "\nError de dato en la linea " + (numeroRegistro + 1) + " y la columna "
								+ (numeroColumna + 1);
					}
					if (1 == numeroColumna && (currentCell.getCellTypeEnum() != CellType.NUMERIC
							|| currentCell.getNumericCellValue() == 0)) {
						mensaje += "\nError de dato en la linea " + (numeroRegistro + 1) + " y la columna "
								+ (numeroColumna + 1);
					}
					if (2 == numeroColumna && (currentCell.getCellTypeEnum() != CellType.NUMERIC
							|| currentCell.getNumericCellValue() == 0)) {
						isValido = false;
						mensaje += "\nError de dato en la linea " + (numeroRegistro + 1) + " y la columna "
								+ (numeroColumna + 1);
					}
					if (3 == numeroColumna && (currentCell.getCellTypeEnum() != CellType.NUMERIC
							|| currentCell.getNumericCellValue() == 0)) {
						isValido = false;
						mensaje += "\nError de dato en la linea " + (numeroRegistro + 1) + " y la columna "
								+ (numeroColumna + 1);
					}
					if (numeroColumna > 3) {
						isValido = false;
						mensaje += "\nLa linea " + (numeroRegistro + 1) + " solo debe tener 4 columnas";
					}
					numeroColumna++;
				}
				numeroRegistro++;
			}

//			System.out.println("Mensaje resultante: " + mensaje);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
