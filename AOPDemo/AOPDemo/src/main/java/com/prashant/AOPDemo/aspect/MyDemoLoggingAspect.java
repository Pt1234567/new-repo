package com.prashant.AOPDemo.aspect;

import com.prashant.AOPDemo.Account;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Around("execution(* com.prashant.AOPDemo.Service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        //print out method we are advising on
        String method=proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @Around advice on method: "+method);
        //get begin timestamp

        long begin=System.currentTimeMillis();

        //execute method
        Object result=null;

        try{
            result=proceedingJoinPoint.proceed();
        }catch (Exception exc){
            //log the Exception
            System.out.println(exc.getMessage());
            //rethrow Exception

            throw  exc;

        }

        //get end timestamp
        long end=System.currentTimeMillis();

        //compute duration and display it
        long duration =end-begin;

        System.out.println("\n===> Duration : "+duration/1000.0 +" Seconds");

        return result;
    }


    @After("execution(* com.prashant.AOPDemo.dao.AccountDao.findAccount(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
        //print out which method we are advising on
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @After advice on method: "+method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.prashant.AOPDemo.dao.AccountDao.findAccount(..))",
            throwing = "thrExc")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint , Throwable thrExc){
          //print out which method we are advising on
           String method=joinPoint.getSignature().toShortString();
           System.out.println("\n=====> Executing @AfterThrowing on method: "+method);
          //log the exception

           System.out.println("\n=====> Exception is: "+thrExc);
    }



    //add a new advice for @AfterReturning on findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.prashant.AOPDemo.dao.AccountDao.findAccount(..))",
             returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
      //print out which method we are advising on
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: "+method);

        //print out the results of method call
        System.out.println("\n====> Result is: "+result);

        //lets post process the data -->modify it
        //convert the account name to upper case
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====> Result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account temp:result){
            String name=temp.getName().toUpperCase();
            temp.setName(name);
        }
    }


    @Before("com.prashant.AOPDemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("****** Executing @Before advice ******");

        //display the method signature
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

        System.out.println("Method"+ methodSignature);

        //display method args

        //get args
        Object[] args=joinPoint.getArgs();

        //loop thru args
        for(Object tempArg:args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                //downcast and print Account specific stuff
                Account account=(Account) tempArg;

                System.out.println("account name : "+ account.getName());
                System.out.println("account level : "+account.getLevel());
            }
        }

    }
}
