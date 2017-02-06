package com.jd.ssm.lombok;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by wangyingjie1 on 2017/1/26.
 */
@Data
@Slf4j
public class Student {

    private int sid;
    private String name;
    private int sex;

    public void printLog() {
        log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        //log.debug(() -> "xxxx" + execute());

    }

    private String execute() {
        return "";
    }

    public static void print() {
        System.out.println("xxxxxxxxxxxxxxxx");
    }

    public static void main(String[] args) {
        log.info("");

        Runnable print = Student::print;
        print.run();
    }
}
