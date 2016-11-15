package com.jd.mybatiss;

import com.jd.ssm.user.User;
import com.jd.ssm.user.mapper.MyBatisUtil;
import com.jd.ssm.user.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by wangyingjie1 on 2016/11/15.
 */
public class UserMapperTest {

    private static SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

    @Test
    public void testSave(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = getUser();

            mapper.save(user);

            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    private User getUser() {
        User user = new User();
        user.setUserName("mybatis");
        user.setAge(100);
        user.setSex("x");
        return user;
    }

    @Test
    public void testGetUserById(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.getUserById(2);

            System.out.println("user===========>" + user);

            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


}
