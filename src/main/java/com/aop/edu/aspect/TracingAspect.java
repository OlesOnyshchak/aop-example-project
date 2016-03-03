package com.aop.edu.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TracingAspect {
    public static Logger logger = Logger.getLogger(TracingAspect.class);

    @Before(
            "execution(** *(..))"
    )
    public void entering(JoinPoint joinPoint){
       logger.info("welcome (before advice)"+joinPoint.getStaticPart().getSignature().toLongString());
    }
    @After(
            "execution(** *(..))"
    )
    public void bye(){
        logger.info("bye (after advice)");
    }

    @AfterThrowing(
            pointcut = "execution(** *(..))",throwing = "ex"
    )
    public void afterThrowingAnArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex){
        logger.info("exception (after throwing advice)"+ex);
    }

    @AfterReturning(
            pointcut = "execution(** *(..))",returning = "s"
    )
    public void afterReturning(String s){
        logger.info("AfterReturning advice "+s);
    }

    @Around(
            "execution(** *(..))"
    )
    public void roundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("round advice");
        String name = null;
        try{
            name = (String) proceedingJoinPoint.proceed();
        }
        catch (Throwable throwable){
            System.out.println("exception");
        }
        System.out.println(name);
    }

}
