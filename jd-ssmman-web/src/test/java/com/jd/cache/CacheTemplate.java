package com.jd.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.jd.beans.User;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class CacheTemplate {

    public <T> T getCache(TypeReference<T> clazz, CacheLoadable<T> cacheLoadable) {

        System.out.println(clazz.getType().getTypeName());

        String json = JSON.toJSONString(getUsers());
        T parseObject = JSON.parseObject(json, clazz);

        // return parseObject
        System.out.println(json);

        // if parseObject is null get db

        // double check
        System.out.println(clazz.getType().getTypeName());

        return parseObject;
    }

    public static List<User> getUsers() {
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("xxx" + i);
            user.setId(i);
            list.add(user);
        }
        return list;
    }

    public static void main(String[] args) {
        CacheTemplate template = new CacheTemplate();
        List<User> userList = template.getCache(
                new TypeReference<List<User>>() {
                },
                () -> getUsers()
        );



        System.out.println(JSON.toJSONString(userList));

        TypeReference<Runnable> typeReference = new TypeReference<Runnable>() {
        };


        Type referenceType = typeReference.getType();

        String typeName = referenceType.getTypeName();

        System.out.println(typeName + "========" + referenceType);
    }

}
