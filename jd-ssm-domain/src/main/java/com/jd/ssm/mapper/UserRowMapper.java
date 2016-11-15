package com.jd.ssm.mapper;

import com.jd.ssm.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wangyingjie1 on 2016/11/14.
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("user_name"));
        user.setAge(rs.getInt("age"));
        user.setSex(rs.getString("sex"));

        return user;
    }
}
