package com.aop.edu;

import com.aop.edu.config.ApplicationConfig;
import com.aop.edu.methods.Methods;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Methods methods = applicationContext.getBean(Methods.class);
        System.out.println();
        methods.helloWorld();

    }
}
