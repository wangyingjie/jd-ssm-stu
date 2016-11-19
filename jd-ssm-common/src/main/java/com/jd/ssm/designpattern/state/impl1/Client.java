package com.jd.ssm.designpattern.state.impl1;

/**
 * Created by wangyingjie1 on 2016/11/19.
 */
public class Client {

    public static void main(String[] args) {

        Switch s1 = new Switch("开关1");
        Switch s2 = new Switch("开关2");

        s1.on();
        s2.on();
        s1.off();
        s2.off();
        s2.on();
        s1.on();
    }
}
