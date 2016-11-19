package com.jd.ssm.tx;

/**
 * Created by wangyingjie1 on 2016/11/19.
 */
public class MyConnection {

    private boolean autoCommit;

    public boolean isAutoCommit() {

        System.out.println(" isAutoCommit() ===========>"+ this);

        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {

        System.out.println(" setAutoCommit(boolean autoCommit) ===========>"+ this);

        this.autoCommit = autoCommit;
    }
}
