package com.jd.ssm.example.impl;

import com.jd.ssm.example.CycleService1;
import com.jd.ssm.example.CycleService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/11/1.
 */
@Service("cycleService2")
public class CycleServiceImpl2 implements CycleService2 {

    @Autowired
    private CycleService1 cycleService1;

    @Override
    public String method1() {

        System.out.println(this.getClass() + " 被调用了 …………………………………………………………" + cycleService1);

        return "";
    }
}
