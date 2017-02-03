package com.jd.jdbctransaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangyingjie1 on 2017/1/25.
 */
public class TransactionTest {

    @Transactional
    public void testRowLock(){

        String sql = "update t_order set order_status=2 where order_status=1 and order_id=100000000";

        //executeSQL(sql);

        System.out.println("xxxxxxxxxxxxxxxxxx");
    }

}
