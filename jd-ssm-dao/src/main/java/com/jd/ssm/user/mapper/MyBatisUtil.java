package com.jd.ssm.user.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by wangyingjie1 on 2016/11/15.
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        String resource = "mybatis-config-self.xml";

        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader(resource);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("reading resource is error");
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }


    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        System.out.println(sqlSessionFactory);
    }
}
