package com.jd.ssm.aop.user.impl;

/**
 * Created by wangyingjie1 on 2016/11/9.
 */
public class UserManagerImpl implements UserManager {

    public String findUserById(int userId) {
        System.out.println("---------UserManagerImpl.findUserById()--------");
        if (userId <= 0) {
            throw new IllegalArgumentException("该用户不存在!");
        }
        return "张三";
    }
}
