package com.jd.ssm.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wangyingjie1 on 2016/11/9.
 */
@Aspect
@Component("aopAspectJService")
public class AopAspectJService {

    @Pointcut("execution(* *.test(..)))")
    public void test(){

    }

    @Before("test()")
    public void beforeTest(){
        System.out.println(" before test ");
    }

    @After("test()")
    public void afterTest(){
        System.out.println(" after test ");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p){
        System.out.println(" aroundTest before starting*********************");

        Object object = null;

        try {
            object = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("aroundTest after end***************************");

        return object;
    }
}
