package com.webservice.wsdl;

import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import java.util.List;
import java.util.Map;

public class AnalysisWsdl {
    public static void main(String[] args) throws Exception{
        String url="http://localhost:8082/mcm/master";
        WSDLFactory wsdlFactory=WSDLFactory.newInstance();
        WSDLReader wsdlReader=wsdlFactory.newWSDLReader();
        wsdlReader.setFeature("javax.wsdl.verbose", true);
        wsdlReader.setFeature("javax.wsdl.importDocuments", true);
        Definition definition=wsdlReader.readWSDL(url+"?wsdl");
        String targetNamespace=definition.getTargetNamespace();
        Service service=definition.getService(definition.getQName());
        Map<Object,Object> map=service.getPorts();
        Object obj=null;
        for(Object set:map.keySet()){
            obj=map.get(set);
        }
        if(obj==null)
            return;
        Port port=(Port)obj;
        List<Operation> lists=port.getBinding().getBindingOperations();
        for(Operation operation:lists){
            String name=operation.getName();
            System.out.println("获取方法名称为:"+name);
        }
        System.out.println(service);
    }
}
