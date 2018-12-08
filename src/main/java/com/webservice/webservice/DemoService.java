package com.webservice.webservice;

import javax.jws.WebService;

@WebService(targetNamespace = "http://webservice.webservice.com/")
public interface DemoService {
    public String testService(String json) throws Exception;

    public String result(String id) throws Exception;
}
