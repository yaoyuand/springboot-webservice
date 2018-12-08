package org.tempuri;

public class HubSoapProxy implements org.tempuri.HubSoap {
  private String _endpoint = null;
  private org.tempuri.HubSoap hubSoap = null;
  
  public HubSoapProxy() {
    _initHubSoapProxy();
  }
  
  public HubSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initHubSoapProxy();
  }
  
  private void _initHubSoapProxy() {
    try {
      hubSoap = (new org.tempuri.HubLocator()).getHubSoap();
      if (hubSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hubSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hubSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hubSoap != null)
      ((javax.xml.rpc.Stub)hubSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.HubSoap getHubSoap() {
    if (hubSoap == null)
      _initHubSoapProxy();
    return hubSoap;
  }
  
  public String helloWorld() throws java.rmi.RemoteException{
    if (hubSoap == null)
      _initHubSoapProxy();
    return hubSoap.helloWorld();
  }
  
  public String sendService(String strMobile, String strMessage) throws java.rmi.RemoteException{
    if (hubSoap == null)
      _initHubSoapProxy();
    return hubSoap.sendService(strMobile, strMessage);
  }
  
  
}