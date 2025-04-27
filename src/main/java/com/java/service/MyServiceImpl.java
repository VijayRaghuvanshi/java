package com.java.service;

import com.java.annotation.custom.LogExecutionTime;

public class MyServiceImpl implements MyService{
    @Override
    public void serve() {
        System.out.println("Serving...");
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }

    }
}
