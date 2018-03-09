package com.jd.ssm.cache;

/**
 * Created by wangyingjie1 on 2016/12/22.
 */
public interface AccountService2 {

    Account getAccountByName(String accountName);

    void sayHello(String world);

    void sayHello3(String world);
}
