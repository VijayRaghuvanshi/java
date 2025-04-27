package com.java;

import com.java.annotation.processor.LogExecutionTimeProxy;
import com.java.service.MyService;
import com.java.service.MyServiceImpl;


public class Main {
    public static void main(String[] args) {
        MyService service  = new MyServiceImpl();
        MyService proxy = LogExecutionTimeProxy.createProxy(service);
        proxy.serve();
    }
}