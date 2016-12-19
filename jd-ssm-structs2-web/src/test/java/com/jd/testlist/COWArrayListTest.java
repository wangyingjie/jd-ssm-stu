package com.jd.testlist;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wangyingjie1 on 2016/12/19.
 *
 * CopyOnWriteArrayList  来自 concurrent 包，是ArrayList线程安全的实现方式
 */
public class COWArrayListTest {

    @Test
    public void testListForRemove() {
        List<String> list = getList();

        // 删除、修改元素
        for (String item : list) {

            //不会报错
            list.remove(item);
        }

        System.out.println(list);
    }

    @Test
    public void testListIteratorForAdd() {
        List<String> list = getList();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String nextValue = iterator.next();
            System.out.println("nextValue=========>" + nextValue);

            //不会报错
            list.add("bbbbbbbbbbbbbbbbbb");
        }

        System.out.println(list);
    }


    private List<String> getList() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("xxxxxxxxxxxx");
        list.add("yyyyyyyyyyyy");
        list.add("zzzzzzzzzzzz");
        list.add("aaaaaaaaaaaa");
        return list;
    }
}
