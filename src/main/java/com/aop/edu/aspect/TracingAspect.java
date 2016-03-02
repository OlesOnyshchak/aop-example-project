package com.aop.edu.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
    public static Logger logger = Logger.getLogger(TracingAspect.class);

    @Before(
            "execution(** *(..))"
    )
    public void entering(JoinPoint joinPoint){
       logger.info("welcome "+joinPoint.getStaticPart().getSignature().toLongString());
    }
    @After(
            "execution(** *(..))"
    )
    public void bye(){
        logger.info("bye");
    }

    @AfterThrowing(
            pointcut = "execution(** *(..))",throwing = "ex"
    )
    public void afterThrowingAnArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex){
        logger.info("exception "+ex);
    }

    @AfterReturning(
            pointcut = "execution(** *(..))",returning = "s"
    )
    public void afterReturning(String s){
        logger.info("AfterReturning "+s);
    }
}
