package com.jd.cache;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class CacheService {

    // AOP 思想进行复用 解耦
    // 缓存检索
    public Object getObject() {
        // get cache

        // if get is not null return

        // double check lock
        synchronized (this) {
            // 查数据库

            List<String> dataList = getDataList("hello");
            // 放缓存

        }
        return null;
    }

    public List<String> getDataList(String key) {
        return Lists.newArrayList("123213", "dfdf");
    }




}
