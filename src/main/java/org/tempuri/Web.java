package org.tempuri;

import org.apache.axis.AxisEngine;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.soap.SOAPConstants;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Web {
    public static void main(String[] args) {
        try {
            Web web=new Web();
//            WebServiceContext webServiceContext=new WebServiceContext();
//            webServiceContext.setUrl("http://sqcy.shjgj-xxzx.org/MsgHubLocal/Hub.asmx?wsdl");
//            webServiceContext.setNamespaceURl("http://tempuri.org/");
//            webServiceContext.setPortName("HubSoap");
//            webServiceContext.setMethod("SendService");
//            webServiceContext.setSoapAction("http://tempuri.org/SendService");
//            Map<String,String> map=new HashMap<>();
//            map.put("strMobile","string");
//            map.put("strMessage","string");
//            webServiceContext.setMap(map);
//            Object[] object=new Object[]{"18861827985","今天天气挺好"};
//            webServiceContext.setObject(object);
//            Object obj=web.useService(webServiceContext);
//            System.out.println("接口返回值为:"+obj);
            web.getInfo("http://sqcy.shjgj-xxzx.org/MsgHubLocal/Hub.asmx?wsdl");
        } catch (Exception e) {
            System.out.println("调用接口报错:"+e.getMessage());
        }
    }

    public Object useService(WebServiceContext webServiceContext) throws Exception{
        Service service=new Service();
        Call call=(Call)service.createCall();
        call.setUsername("");
        call.setPassword("");
        call.setTargetEndpointAddress(new URL(webServiceContext.getUrl()));
        call.setPortName(new QName(webServiceContext.getPortName()));
        call.setOperation(this.setParam(webServiceContext.getNamespaceURl(),webServiceContext.getMap()));//设置参数
        call.setUseSOAPAction(true);
        call.setSOAPActionURI(webServiceContext.getSoapAction());
        call.setEncodingStyle(null);
        call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new QName(webServiceContext.getNamespaceURl(), webServiceContext.getMethod()));
        Object obj = call.invoke(webServiceContext.getObject());
        return obj;
    }
    /**
     * @param namespaceURl  接口中的targetNamespace
     * @param map map中key代表参数名称value代表参数类型
     * */
    private OperationDesc setParam(String namespaceURl, Map<String,String> map){
        OperationDesc oper = new OperationDesc();
        for(String str:map.keySet()){
            //http://www.w3.org/2001/XMLSchema代表xml规范
            if("arg".contains(str))
                namespaceURl="";
            ParameterDesc params = new ParameterDesc(new QName(namespaceURl, str),
                    ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema",
                    map.get(str)), String.class, false, false);
            oper.addParameter(params);
        }
        return oper;
    }
    /**
     *
     * */
    public void getInfo(String webserviceUrl) throws  Exception{
        URL url=new URL(webserviceUrl);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setRequestMethod("GET");
        InputStream inputStream=connection.getInputStream();
//        this.xpath(inputStream);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        StringBuffer stringBuffer=new StringBuffer();
        while(true){
            String data=bufferedReader.readLine();
            if(data==null)
                break;
            stringBuffer.append(data);
        }
        System.out.println(stringBuffer);
    }
    /**
     * 解析xml
     * */
    public void xpath(InputStream inputStream) throws Exception{
        SAXReader saxReader=new SAXReader();
        Document doc=saxReader.read(inputStream);
        List<Element> elements= doc.selectNodes("/wsdl:types/s:schema");
        String targetNamespace=elements.get(0).attributeValue("targetNamespace");
        System.out.println("targetNamespace:"+targetNamespace);
    }
}
