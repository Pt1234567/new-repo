package com.prashant.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {


    @Pointcut("execution (* com.prashant.AOPDemo.dao.*.*(..))")
    public void forDaoPackage(){}

    //create a pointcut for getter
    @Pointcut("execution (* com.prashant.AOPDemo.dao.*.get*(..))")
    public void getter(){}

    //create a pointcut for setter
    @Pointcut("execution (* com.prashant.AOPDemo.dao.*.set*(..))")
    public void setter(){}

    //create a pointcut: include package--- exclude getter/setter
    @Pointcut("forDaoPackage() && !( getter() || setter() )")
    public   void forDaoPackageNoGetterSetter(){}


}
