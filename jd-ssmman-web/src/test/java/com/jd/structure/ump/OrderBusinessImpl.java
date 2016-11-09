package com.jd.structure.ump;

/**
 * Created by wangyingjie1 on 2016/11/8.
 */
public class OrderBusinessImpl extends AbstractBusiness {


    @Override
    public void start() {

    }

    @Override
    public void end() {

    }

    @Override
    protected void doProcessor() {

    }

    public static void main(String[] args) {
        AbstractBusiness business = new OrderBusinessImpl();

        business.processor();
    }
}
