package com.infra.service;

public class FacturaServiceProxy implements com.infra.service.FacturaService {
  private String _endpoint = null;
  private com.infra.service.FacturaService facturaService = null;
  
  public FacturaServiceProxy() {
    _initFacturaServiceProxy();
  }
  
  public FacturaServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFacturaServiceProxy();
  }
  
  private void _initFacturaServiceProxy() {
    try {
      facturaService = (new com.infra.service.FacturaServiceImplServiceLocator()).getFacturaServiceImplPort();
      if (facturaService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)facturaService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)facturaService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (facturaService != null)
      ((javax.xml.rpc.Stub)facturaService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.infra.service.FacturaService getFacturaService() {
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService;
  }
  
  public com.infra.service.LfactRequest lfact(com.infra.service.LfactRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.lfact(params);
  }
  
  public com.infra.service.StatusRequest status(com.infra.service.StatusRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.status(params);
  }
  
  public com.infra.service.LconsRequest lcons(com.infra.service.LconsRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.lcons(params);
  }
  
  public com.infra.service.CprecepRequest cprecep(com.infra.service.CprecepRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.cprecep(params);
  }
  
  public com.infra.service.LspoferRequest lspofer(com.infra.service.LspoferRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.lspofer(params);
  }
  
  public com.infra.service.ListaOCRequest lista_oc(com.infra.service.ListaOCRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.lista_oc(params);
  }
  
  public com.infra.service.TiposRequest tipos(com.infra.service.TiposRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.tipos(params);
  }
  
  public com.infra.service.LcondRequest lcond(com.infra.service.LcondRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.lcond(params);
  }
  
  public com.infra.service.LconcRequest lconc(com.infra.service.LconcRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.lconc(params);
  }
  
  public com.infra.service.PoferdRequest poferd(com.infra.service.PoferdRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.poferd(params);
  }
  
  public com.infra.service.PoferhRequest poferh(com.infra.service.PoferhRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.poferh(params);
  }
  
  public com.infra.service.CppagosRequest cppagos(com.infra.service.CppagosRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.cppagos(params);
  }
  
  public com.infra.service.LpedRequest lped(com.infra.service.LpedRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.lped(params);
  }
  
  public com.infra.service.LincotRequest lincot(com.infra.service.LincotRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.lincot(params);
  }
  
  public com.infra.service.RconsRequest rcons(com.infra.service.RconsRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.rcons(params);
  }
  
  public com.infra.service.PoferrRequest poferr(com.infra.service.PoferrRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.poferr(params);
  }
  
  public com.infra.service.PofersRequest pofers(com.infra.service.PofersRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.pofers(params);
  }
  
  public com.infra.service.CpfactsRequest cpfacts(com.infra.service.CpfactsRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.cpfacts(params);
  }
  
  public com.infra.service.AvisoPdfRequest aviso_pdf(com.infra.service.AvisoPdfRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.aviso_pdf(params);
  }
  
  public com.infra.service.ListanRequest listan(com.infra.service.ListanRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.listan(params);
  }
  
  public com.infra.service.FactRequest fact(com.infra.service.FactRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.fact(params);
  }
  
  public com.infra.service.OstatusRequest ostatus(com.infra.service.OstatusRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.ostatus(params);
  }
  
  public com.infra.service.RantRequest rant(com.infra.service.RantRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.rant(params);
  }
  
  public com.infra.service.RadendaRequest radenda(com.infra.service.RadendaRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.radenda(params);
  }
  
  public com.infra.service.SociedadesRequest sociedades(com.infra.service.SociedadesRequest params) throws java.rmi.RemoteException{
    if (facturaService == null)
      _initFacturaServiceProxy();
    return facturaService.sociedades(params);
  }
  
  
}