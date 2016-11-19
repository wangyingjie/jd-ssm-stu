package com.jd.ssm.user;

/**
 * Created by wangyingjie1 on 2016/11/16.
 * <p>
 * user 的数据库操作事务管理类
 */
public interface UserManager {

    void save(User user);

    //嵌套事务测试
    void saveNestTx(User user);

    //事务方法嵌套一个无事务的方法
    void saveNestNoTx(User user);

    //该方法更新 user 但是不加事务注解
    void update(long id);

    //无事务注解的方法调用一个事务的方法
    void updateNoTxCallTx(long id, User user);

    //该方法更新 user 加事务注解
    void updateTx(long id);

}
