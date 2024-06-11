package com.prashant.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our advices for logging

    //let's start with an @BeforeAdvice

    //this pointcut expression will match addAccount() method in any class
    @Before("execution (* com.prashant.AOPDemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("****** Executing @Before advice ******");
    }

}
