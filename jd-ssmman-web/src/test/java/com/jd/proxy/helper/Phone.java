package com.jd.proxy.helper;

import com.jd.proxy.Communication;

public class Phone implements Communication {

    @Override
    public void call() {
        System.out.println("call who phone no");
    }

    @Override
    public void email() {
        System.out.println("email ********************");
    }


}
