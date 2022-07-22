package com.infra.factura.dto.html;

public class FeTmsDtoHtml extends FeCatalogoDtoHtml {
	public String getActualizar() {
		return "<a href=\"Tms.do?do=verRegistro&id="+getId()+"\" class='texto'><img border='0' src=\"fe_imagenes/fe_edit.png\" alt='Editar'/></a>";
	}
	
	public String getEliminar() {
		return "<a href=\"javascript:eliminarTms('"+getId()+"');\" class='texto'><img border='0' src=\"fe_imagenes/fe_delete.png\" alt='Eliminar'/></a>";
	}
}
