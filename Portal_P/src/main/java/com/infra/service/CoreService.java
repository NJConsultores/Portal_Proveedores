/**
 * CoreService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public interface CoreService extends java.rmi.Remote {
    public com.infra.service.OavisosRequest oavisos(com.infra.service.OavisosRequest params) throws java.rmi.RemoteException;
    public com.infra.service.OprovRequest oprov(com.infra.service.OprovRequest params) throws java.rmi.RemoteException;
    public com.infra.service.LoginRequest login(com.infra.service.LoginRequest params) throws java.rmi.RemoteException;
    public com.infra.service.MultasRequest multas(com.infra.service.MultasRequest params) throws java.rmi.RemoteException;
    public com.infra.service.CorreoRequest correo(com.infra.service.CorreoRequest params) throws java.rmi.RemoteException;
    public int sumar(int param1, int param2) throws java.rmi.RemoteException;
    public com.infra.service.PinRequest pin(com.infra.service.PinRequest params) throws java.rmi.RemoteException;
    public java.lang.String test(java.lang.String nombre) throws java.rmi.RemoteException;
    public com.infra.service.AvisosRequest avisos(com.infra.service.AvisosRequest params) throws java.rmi.RemoteException;
    public com.infra.service.PasswdRequest passwd(com.infra.service.PasswdRequest params) throws java.rmi.RemoteException;
}
