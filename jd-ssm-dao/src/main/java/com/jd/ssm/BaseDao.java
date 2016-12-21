package com.jd.ssm;

import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
public class BaseDao {

    @Resource
    private SqlSession sqlSession;

    public <E> E executeForObject(String sqlID, Object bindParams, Class<E> clazz) {
        E rObj = null;
        try {
            // 执行SQL：取得记录
            Object obj = sqlSession.selectOne(sqlID, bindParams);

            if (clazz != null && obj != null) {
                rObj = (E) clazz.cast(obj);
            }
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
        return rObj;
    }

    public <E> List<E> executeForObjectList(String sqlID, Object bindParams) {
        // 执行SQL：取得记录
        List<E> list = sqlSession.selectList(sqlID, bindParams);
        return list;
    }

    public int execute(String sqlID, Object bindParams) {
        // 执行SQL: 更新数据
        int row = sqlSession.update(sqlID, bindParams);
        return row;
    }



}
