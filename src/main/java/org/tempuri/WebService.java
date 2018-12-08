package org.tempuri;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.description.OperationDesc;

import javax.xml.namespace.QName;
import java.net.URL;


public class WebService {
    public static void main(String[] args) {
        try {
            String endpoint = "http://sqcy.shjgj-xxzx.org/MsgHubLocal/Hub.asmx?wsdl";
            //直接引用远程的wsdl文件
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new URL(endpoint));
            call.setOperationName(new QName( "SendService"));
            call.addParameter("strMobile", org.apache.axis.encoding.XMLType.XSD_DATE,
                    javax.xml.rpc.ParameterMode.IN);//接口的参数
            call.addParameter("strMessage", org.apache.axis.encoding.XMLType.XSD_DATE,
                    javax.xml.rpc.ParameterMode.IN);//接口的参数
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
            String temp1="18861827985";
            String temp2="今天天气不错";
            String result =(String)call.invoke(new Object[]{temp1,temp2});
            //给方法传递参数，并且调用方法
            System.out.println("result is "+result);
        }
        catch (Exception e) {
            System.out.println("发送消息报错:"+e.getMessage());
        }
    }
}
