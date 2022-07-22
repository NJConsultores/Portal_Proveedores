package com.infra.service;

public class CatalogoServiceProxy implements com.infra.service.CatalogoService {
  private String _endpoint = null;
  private com.infra.service.CatalogoService catalogoService = null;
  
  public CatalogoServiceProxy() {
    _initCatalogoServiceProxy();
  }
  
  public CatalogoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCatalogoServiceProxy();
  }
  
  private void _initCatalogoServiceProxy() {
    try {
      catalogoService = (new com.infra.service.CatalogoServiceImplServiceLocator()).getCatalogoServiceImplPort();
      if (catalogoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)catalogoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)catalogoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (catalogoService != null)
      ((javax.xml.rpc.Stub)catalogoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.infra.service.CatalogoService getCatalogoService() {
    if (catalogoService == null)
      _initCatalogoServiceProxy();
    return catalogoService;
  }
  
  public com.infra.service.LregionRequest lregion(com.infra.service.LregionRequest params) throws java.rmi.RemoteException{
    if (catalogoService == null)
      _initCatalogoServiceProxy();
    return catalogoService.lregion(params);
  }
  
  public com.infra.service.LrareaRequest lrarea(com.infra.service.LrareaRequest params) throws java.rmi.RemoteException{
    if (catalogoService == null)
      _initCatalogoServiceProxy();
    return catalogoService.lrarea(params);
  }
  
  public com.infra.service.LareasRequest lareas(com.infra.service.LareasRequest params) throws java.rmi.RemoteException{
    if (catalogoService == null)
      _initCatalogoServiceProxy();
    return catalogoService.lareas(params);
  }
  
  public com.infra.service.LmonRequest lmon(com.infra.service.LmonRequest params) throws java.rmi.RemoteException{
    if (catalogoService == null)
      _initCatalogoServiceProxy();
    return catalogoService.lmon(params);
  }
  
  public com.infra.service.LimpsRequest limps(com.infra.service.LimpsRequest params) throws java.rmi.RemoteException{
    if (catalogoService == null)
      _initCatalogoServiceProxy();
    return catalogoService.limps(params);
  }
  
  public com.infra.service.ProvrRequest provr(com.infra.service.ProvrRequest params) throws java.rmi.RemoteException{
    if (catalogoService == null)
      _initCatalogoServiceProxy();
    return catalogoService.provr(params);
  }
  
  
}