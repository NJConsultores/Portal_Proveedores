package com.infra.factura.model.enumeration;

public enum LayoutExcelCargaMasivaAduanalesEnum {
	RFC_SOCIEDAD("A", 12), FOLIO("B", 16), FECHA_EMISION("C", 10),
	MONTO_HONORARIOS("D", 100), MONTO_TERCEROS("E", 100),
	NOMBRE_ARCHIVO_PDF("F", 100), MONEDA("G", 3),
	NUMERO_REFERENCIA("H", 16), NUMERO_PROVEEDOR("I", 100);
	
	private String columnName;
	private int length;
	
	private LayoutExcelCargaMasivaAduanalesEnum(String columnName, int length) {
		this.columnName = columnName;
		this.length = length;
	}
	
	public String getColumnName() {
		return columnName;
	}

	public int getLength() {
		return length;
	}
}
