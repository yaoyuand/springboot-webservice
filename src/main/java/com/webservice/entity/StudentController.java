package com.webservice.entity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/show")
    @ResponseBody
    public Student show(){
        Student student=new Student("张三","江苏","12");
        return student;
    }
    @RequestMapping("/test")
    @ResponseBody
    public String shows(){
        Map<String,String> map=new HashMap<>();
        map.put("name","张三");
        map.put("address","江苏");
        map.put("age","12");
        return  map.toString();
    }
    @RequestMapping("/test1")
    @ResponseBody
    public Map<String,String> show1(){
        Map<String,String> map=new HashMap<>();
        map.put("name","张三");
        map.put("address","江苏");
        map.put("age","12");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test1();
            }
        }).start();
        return  map;
    }
    public void test1(){

        System.out.println("今天是个好天气");
    }
}
