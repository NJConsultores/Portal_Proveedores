/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.factura.service;

import java.util.List;
import com.infra.factura.dto.FeCertificadoPacDto;

/**
 *
 * @author rlagunas
 */
public interface CertificadoPacService {
    List<FeCertificadoPacDto> obtenerCertificados(FeCertificadoPacDto certificadoDto) throws Exception;
}
