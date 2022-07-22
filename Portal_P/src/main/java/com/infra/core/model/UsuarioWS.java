package com.infra.core.model;

import java.io.Serializable;

public class UsuarioWS implements Serializable {

	private static final long serialVersionUID = 4198599405189001518L;
	private String idUsuario;
	private String nombreUser;
	private String username;
	private String password;
	private String correo;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String rfc;
	private String sociedad;
	private String consper;
	private String calificacion;
	private String multas;
	private boolean isCambiarCorreo;
	private boolean isXConc;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombreCompleto() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre).append(" ").append(apellidoPaterno);

		if (apellidoMaterno != null && !apellidoMaterno.isEmpty()) {
			sb.append(" ").append(apellidoMaterno);
		}

		return sb.toString();
	}

	public String getNombreUser() {
		return nombreUser;
	}

	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}

	public String getSociedad() {
		return sociedad;
	}

	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}

	public String getConsper() {
		return consper;
	}

	public void setConsper(String consper) {
		this.consper = consper;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getMultas() {
		return multas;
	}

	public void setMultas(String multas) {
		this.multas = multas;
	}

	public boolean isCambiarCorreo() {
		return isCambiarCorreo;
	}

	public void setCambiarCorreo(boolean isCambiarCorreo) {
		this.isCambiarCorreo = isCambiarCorreo;
	}

	public boolean isXConc() {
		return isXConc;
	}

	public void setXConc(boolean isXConc) {
		this.isXConc = isXConc;
	}
	
}
