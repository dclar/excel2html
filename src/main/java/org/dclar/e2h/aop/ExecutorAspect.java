package org.dclar.e2h.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ExecutorAspect {


    //    @Before(value = "within(com.excel.core.ex.impl.*)")
//    public void beforeBegin() {
//
//        System.out.println("AOP ---------------------------------");
//
//    }
//    @Around("execution(* com.excel.core.ex.impl.DefaultExecutorImpl.begin(..))")
//    public Object refreshArgs(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        return joinPoint.proceed();
//
//
//    }


    @Before("execution(* org.dclar.e2h.core.ex.impl.DefaultExecutorImpl+.*(..))")
    public void before() throws Throwable {

        System.out.println("before");


    }

    @After("execution(* org.dclar.e2h.processor.impl.ProcessorImpl+.*(..))")
    public void before2() throws Throwable {

        System.out.println("processor before");


    }


}


