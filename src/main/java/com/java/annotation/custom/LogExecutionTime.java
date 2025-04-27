package com.java.annotation.custom;

import java.lang.annotation.*;
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
}
