package com.infra.factura.service;

import com.infra.factura.business.FeFacturaBusiness;
import com.infra.factura.dto.FeResultadoValidaCFDDto;

/**
 *
 * @author rlagunas
 */
public interface FacturaService {
    public FeResultadoValidaCFDDto validarFactura(String nombreArchivoXMl, byte[] xml) throws Exception;
    public FeFacturaBusiness getFacturaBusiness() throws Exception;
}
