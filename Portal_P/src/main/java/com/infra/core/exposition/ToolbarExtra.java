/*
 * Prospectiva Anexo 24
 */

package com.infra.core.exposition;

import org.primefaces.model.StreamedContent;
 
public interface ToolbarExtra{
    public void cargar();
    public StreamedContent descargarbor();
    public StreamedContent descargarxml();
    public StreamedContent descargarpdf();
    public void eliminar();
    public String irDetalle();
}
