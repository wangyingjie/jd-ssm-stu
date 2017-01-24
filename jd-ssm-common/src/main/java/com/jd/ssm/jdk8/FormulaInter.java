package com.jd.ssm.jdk8;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
public interface FormulaInter {

    void run();

    default String foot(){
        System.out.println("so slow walk*****************");
        return "fast";
    }

    static String m3() {
        return "Hello static method in Interface!";
    }
}
