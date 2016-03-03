package com.aop.edu.methods;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Methods {
    private static Logger logger = Logger.getLogger(Methods.class);

    public String helloWorld() {
        return "HELLO ROUND ADVICE";
    }
}
