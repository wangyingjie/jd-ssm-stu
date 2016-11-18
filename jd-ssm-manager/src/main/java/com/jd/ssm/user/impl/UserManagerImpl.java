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

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
