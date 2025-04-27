package com.java.service;

import com.java.annotation.custom.LogExecutionTime;

public interface MyService {

    @LogExecutionTime
    void serve();
}
