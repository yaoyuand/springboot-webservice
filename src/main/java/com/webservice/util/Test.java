package com.webservice.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws Exception{
        String str="";
        StringBuffer sbs=new StringBuffer();
        sbs.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:tem=\"http://webservice.webservice.com/\">   ");
        sbs.append("   <soapenv:Header/>                                                                                           ");
        sbs.append("   <soapenv:Body>                                                                                              ");
        sbs.append("      <tem:testService>                                                                                        ");
        sbs.append("         <!--Optional:-->                                                                                      ");
        sbs.append("         <tem:arg0>今天</tem:arg0>                                                                      ");
        sbs.append("         <!--Optional:-->                                                                                      ");
        sbs.append("         <tem:arg1>123</tem:arg1>                                                                    ");
        sbs.append("      </tem:testService>                                                                                       ");
        sbs.append("   </soapenv:Body>                                                                                             ");
        sbs.append("</soapenv:Envelope>                                                                                            ");
        str=sbs.toString();
        URL url=new URL("http://127.0.0.1:8088/webservice/api?wsdl");
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setRequestProperty("SOAPAction","http://tempuri.org/SendService");
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        OutputStream out=connection.getOutputStream();
        out.write(str.getBytes());
        out.flush();
        out.close();
        InputStream stream=connection.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(stream,"UTF-8"));
        String data=null;
        StringBuffer sb=new StringBuffer();
        while((data=bufferedReader.readLine())!=null)
            sb.append(data);
        bufferedReader.close();
        stream.close();
        connection.disconnect();
        String result=sb.toString();
        System.out.println("调用接口返回结果为:"+result);
    }
}
