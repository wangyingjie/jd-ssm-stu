package com.jd.ssm.example.impl;

import com.jd.ssm.example.CycleService1;
import com.jd.ssm.example.CycleService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/11/1.
 */
@Service("cycleService1")
public class CycleServiceImpl1 implements CycleService1 {

    @Autowired
    private CycleService2 cycleService2;

    @Override
    public String method1() {

        System.out.println(this.getClass() + " 被调用了 …………………………………………………………" + cycleService2);

        return "";
    }


}
