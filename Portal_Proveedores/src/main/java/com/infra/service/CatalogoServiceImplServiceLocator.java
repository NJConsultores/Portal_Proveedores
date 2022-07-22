/**
 * CatalogoServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.infra.service;

public class CatalogoServiceImplServiceLocator extends org.apache.axis.client.Service implements com.infra.service.CatalogoServiceImplService {

    public CatalogoServiceImplServiceLocator() {
    }


    public CatalogoServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CatalogoServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CatalogoServiceImplPort
    private java.lang.String CatalogoServiceImplPort_address = "http://localhost:8080/webservices/services/CatalogoServiceImplPort";

    public java.lang.String getCatalogoServiceImplPortAddress() {
        return CatalogoServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CatalogoServiceImplPortWSDDServiceName = "CatalogoServiceImplPort";

    public java.lang.String getCatalogoServiceImplPortWSDDServiceName() {
        return CatalogoServiceImplPortWSDDServiceName;
    }

    public void setCatalogoServiceImplPortWSDDServiceName(java.lang.String name) {
        CatalogoServiceImplPortWSDDServiceName = name;
    }

    public com.infra.service.CatalogoService getCatalogoServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CatalogoServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCatalogoServiceImplPort(endpoint);
    }

    public com.infra.service.CatalogoService getCatalogoServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.infra.service.CatalogoServiceImplServiceSoapBindingStub _stub = new com.infra.service.CatalogoServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCatalogoServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCatalogoServiceImplPortEndpointAddress(java.lang.String address) {
        CatalogoServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.infra.service.CatalogoService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.infra.service.CatalogoServiceImplServiceSoapBindingStub _stub = new com.infra.service.CatalogoServiceImplServiceSoapBindingStub(new java.net.URL(CatalogoServiceImplPort_address), this);
                _stub.setPortName(getCatalogoServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CatalogoServiceImplPort".equals(inputPortName)) {
            return getCatalogoServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.infra.com/", "CatalogoServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.infra.com/", "CatalogoServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CatalogoServiceImplPort".equals(portName)) {
            setCatalogoServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
