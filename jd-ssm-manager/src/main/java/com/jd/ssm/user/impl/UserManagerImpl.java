package com.jd.ssm.user.impl;

import com.jd.ssm.user.User;
import com.jd.ssm.user.UserDao;
import com.jd.ssm.user.UserManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangyingjie1 on 2016/11/16.
 */
//@Service("userManager")
public class UserManagerImpl implements UserManager {

    //@Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void save(User user) {

        userDao.save(user);

        //测试数据库事务，抛异常数据库将回滚不入库
        //throw new RuntimeException("抛异常数据库将回滚不入库");
    }

    @Transactional
    @Override
    public void saveNestTx(User user){

        userDao.save(user);

        //测试数据库事务，抛异常数据库将回滚不入库
        //throw new RuntimeException("抛异常数据库将回滚不入库");

        // 嵌套事务处理  打断点观察嵌套事务的回滚处理流程
        this.updateTx(2);
    }

    @Transactional
    @Override
    public void saveNestNoTx(User user) {
        userDao.save(user);

        // 嵌套一个无事务处理的方法,且无事务的方法内部抛异常，验证事务是否回滚
        this.update(7);
    }

    //该方法及接口类方法均无事务注解
    @Override
    public void update(long id) {

        userDao.update(id);

        //测试数据库事务，抛异常数据库将回滚不入库
        throw new RuntimeException("抛异常数据库将回滚不入库");
    }

    @Override
    public void updateNoTxCallTx(long id, User user) {
        userDao.update(3);
        this.save(user);

        //测试数据库事务，抛异常数据库将回滚不入库
        throw new RuntimeException("抛异常数据库将回滚不入库");
    }

    @Transactional
    @Override
    public void updateTx(long id) {
        userDao.update(id);

        //测试数据库事务，抛异常数据库将回滚不入库
        throw new RuntimeException("抛异常数据库将回滚不入库");
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
