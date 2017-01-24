package com.jd.ssm.jdk8;

/**
 * Created by wangyingjie1 on 2017/1/24.
 *
 * 同时实现的接口中拥有一个共同的默认接口方法
 */
public class Impl implements I1, I2 {

    @Override
    public void print() {//必须重写两个接口的公有方法
        I1.super.print();
        I2.super.print();
    }

    public void hello() {
    }

    public void world() {
    }

    public static void main(String[] args) {
        Impl impl = new Impl();
        impl.print();
    }
}
