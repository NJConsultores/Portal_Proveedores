package com.infra.factura.dto;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.infra.factura.util.FeConstantes.Tipo_Correo;

public class FeMailDto implements Serializable {

	private static final long serialVersionUID = 8375055304261161841L;
	//private static MessageResources messageResources = MessageResources.getMessageResources(FeConstantes.APPLICATION_RESOURCES);
	private String[] destinatarios;
	private String[] dest_copias;
	private String[] dest_ocultos;
	private String saludo;
	private String cuerpo;
	private String encabezado;
	private String subject;
	private String aviso;
	private String footer;
	private String hostname;
	//private byte[][] attach;

	public FeMailDto(Tipo_Correo tipoCorreo, String... params) {
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		saludo = "saludo";//messageResources.getMessage("mail.saludo");
		aviso = "aviso";//messageResources.getMessage("mail.aviso");
		footer = "footer";//messageResources.getMessage("mail.footer");
		switch (tipoCorreo) {
		case Recuperacion_Pwd:
			subject = "subject";//messageResources.getMessage("mail.usuarios.recuperacion.password.subject");
			encabezado = "encabezado";//messageResources.getMessage("mail.usuarios.recuperacion.password.header", params[0]);//nombre usuario
			cuerpo = "cuerpo";//messageResources.getMessage("mail.usuarios.recuperacion.password.body", hostname, params[1]);//password
			break;
		case Registro_Usr:
			subject = "";//messageResources.getMessage("mail.usuarios.alta.subject");
			encabezado = "";//messageResources.getMessage("mail.usuarios.alta.header", params[0], params[1], params[2]);//nombre usuario, usuario, password
			cuerpo = "";//messageResources.getMessage("mail.usuarios.alta.body", hostname);
			break;
		case Validacion:
			subject = "";//messageResources.getMessage("mail.validacion.subject");
			encabezado = "";//messageResources.getMessage("mail.validacion.header", params[0]);//nombre usuario
			break;
		case Validacion_correo:
			subject = "";//messageResources.getMessage("mail.validacion.correo.subject");
			encabezado = "";//messageResources.getMessage("mail.validacion.correo.header");
			break;
		case Reinicio_AS2:
			subject = "";//messageResources.getMessage("mail.reinicioAs2.correo.subject");
			encabezado = "";//messageResources.getMessage("mail.reinicioAs2.correo.header");
			break;
		case Alerta_Conexiones_Pool:
			subject = "";//messageResources.getMessage("mail.alerta.max.num.conexiones.correo.subject");
			encabezado = "";//messageResources.getMessage("mail.reinicioAs2.correo.header");
			break;
		default:
			break;
		}
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String[] getDestinatarios() {
		return destinatarios;
	}
	public String[] getDest_copias() {
		return dest_copias;
	}
	public void setDest_copias(String[] dest_copias) {
		this.dest_copias = dest_copias;
	}
	public String[] getDest_ocultos() {
		return dest_ocultos;
	}
	public void setDest_ocultos(String[] dest_ocultos) {
		this.dest_ocultos = dest_ocultos;
	}
	public void setDestinatarios(String[] destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public String getSaludo() {
		return saludo;
	}
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public String getEncabezado() {
		return encabezado;
	}
	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
