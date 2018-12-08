/**
 * HubSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface HubSoap extends java.rmi.Remote {
    public String helloWorld() throws java.rmi.RemoteException;
    public String sendService(String strMobile, String strMessage) throws java.rmi.RemoteException;
}
