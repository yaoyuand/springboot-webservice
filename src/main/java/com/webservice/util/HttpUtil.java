package com.webservice.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public static String sendSoapPost(String url, String xml,
                                      String contentType, String soapAction) {
        String urlString = url;
        HttpURLConnection httpConn = null;
        OutputStream out = null;
        String returnXml = "";
        try {
            httpConn = (HttpURLConnection) new URL(urlString).openConnection();
            httpConn.setRequestProperty("Content-Type", contentType);
            if (null != soapAction) {
                httpConn.setRequestProperty("SOAPAction", soapAction);
            }
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.connect();
            out = httpConn.getOutputStream(); // 获取输出流对象
            httpConn.getOutputStream().write(xml.getBytes("UTF-8")); // 将要提交服务器的SOAP请求字符流写入输出流
            out.flush();
            out.close();
            int code = httpConn.getResponseCode(); // 用来获取服务器响应状态
            String tempString = null;
            StringBuffer sb1 = new StringBuffer();
            if (code == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(httpConn.getInputStream(),
                                "UTF-8"));
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader) {
                    reader.close();
                }
            } else {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(httpConn.getErrorStream(),
                                "UTF-8"));
                // 一次读入一行，直到读入null为文件结束
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader) {
                    reader.close();
                }
            }
            // 响应报文
            returnXml = sb1.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnXml;
    }

    public static void main(String[] args) {
        String url = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";

        StringBuilder sb = new StringBuilder("");
        sb.append(
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ")
                .append("xmlns:web=\"http://WebXml.com.cn/\"><soapenv:Header/><soapenv:Body>")
                .append("<web:getSupportProvince/></soapenv:Body></soapenv:Envelope>");
        String dataXml = sb.toString();
        String contentType = "text/xml; charset=utf-8";
        String soapAction = "http://WebXml.com.cn/getSupportProvince";
        String resultXml = HttpUtil.sendSoapPost(url, dataXml, contentType,
                soapAction);
        System.out.println(resultXml);
    }
}