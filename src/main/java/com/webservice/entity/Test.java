package com.webservice.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

@DataProcess(value = "{param=bean,param=,param@params=bean}")


public class Test {
    public static void main(String[] args) throws Exception{
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=format.parse("2018-12-4 10:33:00");
        Date date1=format.parse("2018-12-4 10:35:00");
        Long time=date1.getTime()-date.getTime();
        System.out.println(time);

    }
}
