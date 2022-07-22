package com.infra.service;

public class CoreServiceProxy implements com.infra.service.CoreService {
  private String _endpoint = null;
  private com.infra.service.CoreService coreService = null;
  
  public CoreServiceProxy() {
    _initCoreServiceProxy();
  }
  
  public CoreServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCoreServiceProxy();
  }
  
  private void _initCoreServiceProxy() {
    try {
      coreService = (new com.infra.service.CoreServiceImplServiceLocator()).getCoreServiceImplPort();
      if (coreService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)coreService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)coreService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (coreService != null)
      ((javax.xml.rpc.Stub)coreService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.infra.service.CoreService getCoreService() {
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService;
  }
  
  public com.infra.service.OavisosRequest oavisos(com.infra.service.OavisosRequest params) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.oavisos(params);
  }
  
  public com.infra.service.OprovRequest oprov(com.infra.service.OprovRequest params) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.oprov(params);
  }
  
  public com.infra.service.LoginRequest login(com.infra.service.LoginRequest params) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.login(params);
  }
  
  public com.infra.service.MultasRequest multas(com.infra.service.MultasRequest params) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.multas(params);
  }
  
  public com.infra.service.CorreoRequest correo(com.infra.service.CorreoRequest params) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.correo(params);
  }
  
  public int sumar(int param1, int param2) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.sumar(param1, param2);
  }
  
  public com.infra.service.PinRequest pin(com.infra.service.PinRequest params) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.pin(params);
  }
  
  public java.lang.String test(java.lang.String nombre) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.test(nombre);
  }
  
  public com.infra.service.AvisosRequest avisos(com.infra.service.AvisosRequest params) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.avisos(params);
  }
  
  public com.infra.service.PasswdRequest passwd(com.infra.service.PasswdRequest params) throws java.rmi.RemoteException{
    if (coreService == null)
      _initCoreServiceProxy();
    return coreService.passwd(params);
  }
  
  
}