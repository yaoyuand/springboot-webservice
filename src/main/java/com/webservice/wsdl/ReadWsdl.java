package com.webservice.wsdl;

import javax.wsdl.*;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadWsdl {
    public static void main(String[] args) {
        String webServiceUrl = "http://localhost:8082/mcm/master";
        try {
            WSDLFactory factory = WSDLFactory.newInstance();
            WSDLReader reader = factory.newWSDLReader();
            reader.setFeature("javax.wsdl.verbose", true);
            reader.setFeature("javax.wsdl.importDocuments", true);
            Definition def = reader.readWSDL(webServiceUrl + "?wsdl");
            Service service = def.getService(def.getQName());
            String portStr = "";
            Map<?, ?> ports = service.getPorts();
            Iterator<?> itor = ports.entrySet().iterator();
            while (itor.hasNext()) {
                Map.Entry<?, ?> map = (Map.Entry<?, ?>) itor.next();
                Object key = map.getKey();
                portStr = (key == null ? "" : key.toString());
                break;
            }
            Port port = service.getPort(portStr);
            Binding binding = port.getBinding();
            PortType portType = binding.getPortType();
            List<?> operations = portType.getOperations();
            Iterator<?> operIter = operations.iterator();
            while (operIter.hasNext()) {
                Operation operation = (Operation) operIter.next();
                if (!operation.isUndefined()) {
                    System.out.println("方法名称:" + operation.getName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
