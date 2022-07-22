package com.infra.cliente.service.ws;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.infra.service.AvisoPdfRequest;
import com.infra.service.CpfactsRequest;
import com.infra.service.CppagosRequest;
import com.infra.service.CprecepRequest;
import com.infra.service.LconcRequest;
import com.infra.service.LcondRequest;
import com.infra.service.LconsRequest;
import com.infra.service.LincotRequest;
import com.infra.service.ListaOCRequest;
import com.infra.service.ListanRequest;
import com.infra.service.LspoferRequest;
import com.infra.service.PoferdRequest;
import com.infra.service.PoferhRequest;
import com.infra.service.PoferrRequest;
import com.infra.service.PofersRequest;
import com.infra.service.RadendaRequest;
import com.infra.service.RantRequest;
import com.infra.service.RconsRequest;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_CONC;
import functions.rfc.sap.document.sap_com.ZPORTAL_S_OCREC;
public interface WSFactura {
	public Map<String, Object> guardarCFDIOC(String idioma, String proveedorActual, String rfcActual, String sociedad,
			String ordenes, InputStream xml, InputStream pdf, InputStream otroPdf, ZPORTAL_S_OCREC[] holder, String tipo);

	public Map<String, Object> guardarCFDI(String idioma, String proveedorActual, String rfcActual, String sociedad,
			String area, String responsable, String factura, ZPORTAL_S_CONC concepto, InputStream xml, InputStream pdf,
			InputStream otroPdf);

	public Map<String, Object> guardarCBB(String idioma, String proveedorActual, String rfcActual, String sociedad,
			String area, String responsable, Date fechaFactura, String factura, ZPORTAL_S_CONC concepto, BigDecimal subtotal,
			String iva, String moneda, InputStream pdf, InputStream otroPdf, boolean isNotaCredito);

	public Map<String, Object> guardarCBBOC(String idioma, String proveedorActual, String rfcActual, String sociedad,
			InputStream pdf, InputStream otroPdf, String factura, String moneda, Date fechaFactura, String iva,
			String ordenes, ZPORTAL_S_OCREC[] holder, boolean isNotaCredito, String tipo);

	public Map<String, Object> getFacturas(Date fechaDesde, Date fechaHasta, String idioma, String proveedorActual,
			String sociedad, String estatusFactura, InputStream xml, InputStream pdf);
	
	public Map<String, Object> guardarAnticipos(RantRequest request);
	
	public Map<String, Object> getListaOC(ListaOCRequest request);
	
	public Map<String, Object> notificaDescargaPDF(AvisoPdfRequest request);
	
	public Map<String, Object> cpfacts(CpfactsRequest request);
	
	public Map<String, Object> cppagos(CppagosRequest request);
	
	public Map<String, Object> cprecep(CprecepRequest request);
	
	public Map<String, Object> lcons(LconsRequest request);
	
	public Map<String, Object> rcons(RconsRequest request);
	
	public Map<String, Object> lconc(LconcRequest request);
	
	public Map<String, Object> lcond(LcondRequest request);
	
	public Map<String, Object> lincot(LincotRequest request);
	
	public Map<String, Object> listan(ListanRequest request);
	
	public Map<String, Object> poferd(PoferdRequest request);
	
	public Map<String, Object> poferh(PoferhRequest request);
	
	public Map<String, Object> poferr(PoferrRequest request);
	
	public Map<String, Object> pofers(PofersRequest request);
	
	public Map<String, Object> lspofer(LspoferRequest request);
	
	public Map<String, Object> radenda(RadendaRequest request);
}