package com.infra.factura.dto;

public class FeMenuDto {
	private int idMenu;
	private String texto;
	private String url;
	private int idSubmenu;
	
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIdSubmenu() {
		return idSubmenu;
	}
	public void setIdSubmenu(int idSubmenu) {
		this.idSubmenu = idSubmenu;
	}
}
