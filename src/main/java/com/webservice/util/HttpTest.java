package com.webservice.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {
    public static void main(String[] args) {
        try {
            HttpTest.test("http://gc.ditu.aliyun.com/geocoding?a=淮安市","");
        } catch (Exception e) {
            System.out.println("接口报错信息为:"+e.getMessage());
        }
    }
    public static void test(String url,String data) throws Exception{
        HttpURLConnection connection=(HttpURLConnection)new URL(url).openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStream outputStream=connection.getOutputStream();
        InputStream inputStream=connection.getInputStream();
        outputStream.write(data.getBytes());
        outputStream.flush();
        outputStream.close();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer sb=new StringBuffer();
        String str=null;
        while((str=bufferedReader.readLine())!=null)
            sb.append(str);
        bufferedReader.close();
        inputStream.close();
        connection.disconnect();
        System.out.println("返回值为:"+sb.toString());
    }
}
