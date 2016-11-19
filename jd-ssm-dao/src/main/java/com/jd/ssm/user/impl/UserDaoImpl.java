package com.jd.ssm.user.impl;

import com.jd.ssm.mapper.UserRowMapper;
import com.jd.ssm.user.User;
import com.jd.ssm.user.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyingjie1 on 2016/11/14.
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    private DruidDataSource dataSource;

    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(User user) {

        String sql = "insert into t_user(user_name, age, sex) values (?, ?, ?)";

        int count = jdbcTemplate.update(sql, new Object[]{user.getUserName(), user.getAge(), user.getSex()}, new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});

        System.out.println("save count=====" + count);

        return count;
    }

    @Override
    public int update(long id) {

        String sql = "update t_user set user_name='tx test name' where id=?";

        return jdbcTemplate.update(sql, id);
    }


    @Override
    public List<User> getAllUsers() {

        String sql = "select id, user_name, age, sex  from  t_user";

        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());

        return users;
    }

    @Override
    public List<Integer> getIDForListSingleColumn(String sex) {

        String sql = "select id  from  t_user  where sex= ? ";

        List<Integer> ids = jdbcTemplate.queryForList(sql, Integer.class, sex);

        return ids;
    }

    @Override
    public List<Map<String, Object>> getColumn2Map() {

        String sql = "select id, user_name, age, sex  from  t_user    where sex= ? ";

        //List<Map<String, Object>> queryForList(String sql, Object... args)
        //return jdbcTemplate.queryForList(sql);

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, "女");

        return maps;
    }


    @Override
    public User getByIdUser(long id) {
        String sql = "select id, user_name, age, sex  from  t_user  where id=?";

        User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, new UserRowMapper());

        return user;
    }

    public Map<String, Object> getForMap() {
        String sql = "select id, user_name, age, sex  from  t_user  where id=3";

        Map<String, Object> map = jdbcTemplate.queryForMap(sql);

        return map;
    }



}
