package com.java;

import com.java.annotation.processor.LogExecutionTimeProxy;
import com.java.service.MyService;
import com.java.service.MyServiceImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MyService service  = new MyServiceImpl();
        MyService proxy = LogExecutionTimeProxy.createProxy(service);
        proxy.serve();
    }
}