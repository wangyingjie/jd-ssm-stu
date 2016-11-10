package com.jd.ssm.aop.test;

import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/11/9.
 */
@Service("aopService")
public class AopServiceBean {

    private String aop = " aop test ";

    public String getAop() {
        return aop;
    }

    public void setAop(String aop) {
        this.aop = aop;
    }

    public void test() {
        System.out.println("============" + aop + "============");
    }
}
