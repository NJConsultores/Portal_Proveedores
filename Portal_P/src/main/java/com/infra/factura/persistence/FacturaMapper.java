//package com.infra.factura.persistence;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Param;
//
//import com.infra.factura.business.validation.dto.FeCertificadoFacturaDto;
//import com.infra.factura.dto.FeArchivoSoporteDto;
//import com.infra.factura.dto.FeCertificadoPacDto;
//import com.infra.factura.dto.FeFacturaDto;
//
//public interface FacturaMapper {
//
//	public List<FeCertificadoFacturaDto> consultarCertificados(FeFacturaDto facturaDto) throws Exception;
//
//	public List<FeCertificadoFacturaDto> consultarCertificadosFiel(FeFacturaDto facturaDto) throws Exception;
//
//	public void registrarFiel(@Param("rfcFiel") String rfcFiel,
//			@Param("certificadoPac") FeCertificadoPacDto certificadoDto) throws Exception;
//
//	public void guardarCertificadoComprobante(FeArchivoSoporteDto certificado) throws Exception;
//
//	public boolean existeCertificadoFiel(String certificado) throws Exception;
//
//	public long getSizeArchivoSoporte(long idFactura) throws Exception;
//
//	public boolean buscarFielPorRfcYNumSerie(@Param("rfcFiel") String rfcFiel, @Param("numeroSerie") String numeroSerie)
//			throws Exception;
//
//	public void actualizarFiel(@Param("rfcFiel") String rfcFiel,
//			@Param("certificadoPac") FeCertificadoPacDto certificadoDto) throws Exception;
//
//	public List<FeCertificadoFacturaDto> buscarCertificadosFiel(FeCertificadoFacturaDto c) throws Exception;
//
//}
