package com.jd.structure.ump;

import com.jd.structure.Ump;

/**
 * Created by wangyingjie1 on 2016/11/8.
 */
public abstract class AbstractBusiness implements Ump {

    public void processor(){
        this.start();

        System.out.println(this.getClass());

        doProcessor();

        this.end();
    }

    protected abstract void doProcessor();
}
