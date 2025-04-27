package com.java.annotation.processor;

import com.java.annotation.custom.LogExecutionTime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Proxy to log method execution time.
 */
public class LogExecutionTimeProxy implements InvocationHandler {

    private final Object target;
    public LogExecutionTimeProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy of "+method.getName());
        if (method.isAnnotationPresent(LogExecutionTime.class)){
            Instant start  = Instant.now();
            Object result = method.invoke(this.target, args);
            Instant end  = Instant.now();
            String exeTime = String.format("Method %s execution time is %s ms",method.getName(), Duration.between(start,end).toMillis());
            System.out.println(exeTime);
            return result;
        }else {
            return method.invoke(this.target, args);
        }
    }
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Object target){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LogExecutionTimeProxy(target));
    }
}
