package com.jd.ssm.orderstatus;


import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 订单详情返回结果工厂类
 * User: guohaifei
 * Date: 2016/2/25
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
@Service("orderDetailFactory")
public class OrderDetailFactoryImpl  {

//            Order_Status     2
//            Pay_Status       1
//            Award_Status     0
//            Pay_Type         2
//            Issue_Status     3
//            Share_Status     0
//            Open_Award_Time  2016-11-06 09:29:35

    public static void main(String[] args) {
        OrderShowStatusEnum orderShowStatusEnum = OrderShowStatusEnum.getOrderStatusEnum(
                2,
                1,
                0,
                3,
                0,
                2,
                DateUtil.getStr2Date("2016-11-06 09:29:35", DateUtil.DATE_FORMAT_1));

        orderShowStatusEnum.getValue();

        Map<OrderShowStatusEnum, Object> registerMap = Maps.newHashMap();

        List<OrderShowStatusEnum> showStatusEnumList = new ArrayList<OrderShowStatusEnum>(){
            {
                this.add(OrderShowStatusEnum.PARTAKE_SUCCESS);
                this.add(OrderShowStatusEnum.PUBLISHING);
                this.add(OrderShowStatusEnum.CANCEL);
                this.add(OrderShowStatusEnum.REFUND_FINISH);
                this.add(OrderShowStatusEnum.REFUND_FIAL);
                this.add(OrderShowStatusEnum.GIVE_UP);
                this.add(OrderShowStatusEnum.TREASURE_FAIL);
            }
        };

        for(OrderShowStatusEnum orderShowStatusEnum2 : showStatusEnumList){
            registerMap.put(orderShowStatusEnum2, null);
        }

    }
}
