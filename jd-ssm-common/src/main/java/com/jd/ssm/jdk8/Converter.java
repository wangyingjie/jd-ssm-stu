package com.jd.ssm.jdk8;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
// 不添加该注解依然可以
//@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);

}

