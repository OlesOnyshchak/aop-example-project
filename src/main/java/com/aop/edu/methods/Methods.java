package com.aop.edu.methods;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Methods {
    private static Logger logger = Logger.getLogger(Methods.class);

    public String helloWorld() {
        String s = "Hello World";
        logger.info(s);
        return s;
    }
}
