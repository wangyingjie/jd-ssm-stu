package com.jd.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyingjie1 on 2016/10/31.
 */
public class User {

    private int id ;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(String name){

        System.out.println("Hello " + name);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("world");

        //添加首元素
        list.add(0, "Hello");
        System.out.println(list);

        //覆盖首元素
        list.set(0, "xxx");
        System.out.println(list);
    }

}
