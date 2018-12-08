package org.tempuri;

import java.util.Map;

public class WebServiceContext {
    private String url;//接口地址
    private String portName;
    private String soapAction;
    private String namespaceURl;
    private String method;//方法
    private Object[] object;//传递值
    private Map<String,String> map;//参数

    public WebServiceContext() {
    }

    public WebServiceContext(String url, String portName, String soapAction, String namespaceURl,
                             String method, Object[] object, Map<String, String> map) {
        this.url = url;
        this.portName = portName;
        this.soapAction = soapAction;
        this.namespaceURl = namespaceURl;
        this.method = method;
        this.object = object;
        this.map = map;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getSoapAction() {
        return soapAction;
    }

    public void setSoapAction(String soapAction) {
        this.soapAction = soapAction;
    }

    public String getNamespaceURl() {
        return namespaceURl;
    }

    public void setNamespaceURl(String namespaceURl) {
        this.namespaceURl = namespaceURl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getObject() {
        return object;
    }

    public void setObject(Object[] object) {
        this.object = object;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
