package com.jd.testlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangyingjie1 on 2016/12/19.
 */
public class ArrayListTest {

    @Test
    public void testListForRemove() {
        List<String> list = getList();

        // 删除、修改元素
        for (String item : list) {

            //会报错
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

            //会报错
            list.add("bbbbbbbbbbbbbbbbbb");
        }

        System.out.println(list);
    }


    private List<String> getList() {
        List<String> list = new ArrayList<String>();
        list.add("xxxxxxxxxxxx");
        list.add("yyyyyyyyyyyy");
        //list.add("zzzzzzzzzzzz");
        //list.add("aaaaaaaaaaaa");
        return list;
    }
}
