package com.jd.beans;

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
}
