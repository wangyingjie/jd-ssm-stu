package com.jd.ssm.user;

import java.util.List;
import java.util.Map;

/**
 * Created by wangyingjie1 on 2016/11/14.
 */
public interface UserDao {

    int save(User user);

    int update(long id);

    List<User> getAllUsers();

    //获取满足条件的 数据库Id列的所有值，只支持单列的查询操作
    List<Integer> getIDForListSingleColumn(String sex);

    //返回sql语句的 列值 映射map
    List<Map<String, Object>> getColumn2Map();

    Map<String, Object> getForMap();

    User getByIdUser(long id);

}
