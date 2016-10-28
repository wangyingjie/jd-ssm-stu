package com.jd;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Created by wangyingjie1 on 2016/10/28.
 *
 * This 关键字的测试
 */
public class ThisTest {

    private int id = 1;
    private String name = "this is test";

    public void cool() {

        HashMap<Object, Object> map = Maps.newHashMap();

        map.put("xx", ThisTest.this);

        ThisTest tt = (ThisTest) map.get("xx");

        System.out.println(tt.id);

        System.out.println("this==============>" + (ThisTest.this == this));
    }

    public static void main(String[] args) {

        ThisTest tt = new ThisTest();
        tt.cool();
    }
}
