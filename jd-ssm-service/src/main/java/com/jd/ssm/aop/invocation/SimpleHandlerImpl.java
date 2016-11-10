package com.jd.ssm.aop.invocation;

/**
 * Created by wangyingjie1 on 2016/11/10.
 */
public class SimpleHandlerImpl implements SimpleHandler{

    public void say(){
        System.out.println(" SimpleHandlerImpl  say************************");
    }

    public void smile(){
        System.out.println("SimpleHandlerImpl  smile************************");
    }

    public boolean runFast(){
        System.out.println("SimpleHandlerImpl  run fast************************");
        return true;
    }
}

