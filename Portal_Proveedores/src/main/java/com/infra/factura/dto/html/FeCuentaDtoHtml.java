package com.infra.factura.dto.html;

public class FeCuentaDtoHtml extends FeCatalogoDtoHtml {
	public String getActualizar() {
		return "<a href=\"Cuenta.do?do=verRegistro&id="+getId()+"\" class='texto'><img border='0' src=\"fe_imagenes/fe_edit.png\" alt='Editar'/></a>";
	}
	
	public String getEliminar() {
		return "<a href=\"javascript:eliminarCuenta('"+getId()+"');\" class='texto'><img border='0' src=\"fe_imagenes/fe_delete.png\" alt='Eliminar'/></a>";
	}
}