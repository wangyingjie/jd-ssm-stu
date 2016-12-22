package com.jd.ssm.cache;

/**
 * Created by wangyingjie1 on 2016/12/22.
 */
public class Account {

    private int id;
    private String name;
    public Account(String name) {
        this.name = name;
    }
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
}
