package com.jd.ssm.user.mapper;

import com.jd.ssm.user.User;

/**
 * Created by wangyingjie1 on 2016/11/15.
 * <p>
 * 注意：
 * <li>1、该接口是提供给 Mybatis的配置文件定义 namespace 的</li>
 * <li>2、mybatis 会根据该接口生成一个代理类，通过动态代理的机制，实现该接口中的方法调用 </li>
 * <li>3、sqlMap 中配置的 id 一定要和方法名保持一致 </li>
 */
public interface UserMapper {

    // sqlMap 中配置的 id 一定要和方法名一致 例如：<insert id="save" parameterType="User">
    void save(User user);

    // sqlMap 中配置的  例如：<select id="getUserById" resultType="User" parameterType="long">
    User getUserById(long id);

}
