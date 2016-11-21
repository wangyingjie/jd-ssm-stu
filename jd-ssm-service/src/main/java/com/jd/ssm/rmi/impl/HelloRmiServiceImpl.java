package com.jd.ssm.rmi.impl;

import com.jd.ssm.rmi.HelloRmiService;

/**
 * Created by wangyingjie1 on 2016/11/21.
 */
public class HelloRmiServiceImpl implements HelloRmiService {

    @Override
    public int getAdd(int a, int b) {

        return a + b;
    }
}
