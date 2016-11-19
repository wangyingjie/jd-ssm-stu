package com.jd.ssm.tx;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyingjie1 on 2016/11/19.
 */
public class TransactionSupport {

    private MyConnection myConnection;

    private Map<String, Object> map = new HashMap<>();


    public TransactionSupport() {

        System.out.println("TransactionSupport() ===========>"+ this);

        this.myConnection = new MyConnection();
        myConnection.setAutoCommit(false);
    }

    public MyConnection getMyConnection() {

        System.out.println("getMyConnection() ===========>"+ this);

        return myConnection;
    }

    public void setMyConnection(MyConnection myConnection) {
        this.myConnection = myConnection;
    }

    public void onBinding(){

        System.out.println("onBinding()===========>" + this);

        map.put("xxx", this);

        System.out.println("this.getMyConnection().isAutoCommit()=================>"+ this.getMyConnection().isAutoCommit());
    }
}
