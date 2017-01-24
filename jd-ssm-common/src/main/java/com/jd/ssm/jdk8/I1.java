package com.jd.ssm.jdk8;

/**
 * Created by wangyingjie1 on 2017/1/24.
 */
public interface I1 {

    default void print() {
        System.out.println("I1");
    }

    void hello();
}
