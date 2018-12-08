package org.tempuri;

import javax.swing.text.html.Option;
import javax.wsdl.*;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) throws Exception{
//		try {
//			HubSoapProxy hubSoapProxy=new HubSoapProxy();
//			String obj=hubSoapProxy.sendService("18861827985", "今天是个好天气");
//			System.out.println("调用接口返回值为:"+obj);
//		}catch(Exception e) {
//			System.out.println("调用接口报错:"+e.getMessage());
//		}
		WSDLFactory wsdlFactory=WSDLFactory.newInstance();
		WSDLReader wsdlReader=wsdlFactory.newWSDLReader();
		wsdlReader.setFeature("javax.wsdl.verbose",true);
		wsdlReader.setFeature("javax.wsdl.importDocuments",true);
		Definition def=wsdlReader.readWSDL("http://sqcy.shjgj-xxzx.org/MsgHubLocal/Hub.asmx?wsdl");
		Map bindings=def.getBindings();
		Iterator<Map.Entry> iterator=bindings.entrySet().iterator();
		while(iterator.hasNext()){
			Binding binding=(Binding)iterator.next().getValue();
			if(binding!=null){
				PortType portType=binding.getPortType();
				QName qName=portType.getQName();
				String nameSpaceUrl=qName.getNamespaceURI();
				String name=qName.getLocalPart();
				List<Operation> operations=binding.getPortType().getOperations();
				List<BindingOperation> list=binding.getBindingOperations();
				for(BindingOperation operation:list){
					String methName=operation.getName();
                    operation.getExtensibilityElements();
				}
				System.out.println(operations);

			}
		}
	}
}
