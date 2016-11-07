package com.jd.ssm.orderstatus;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * User: ckm
 * Date: 2015/12/11
 * Time: 12:49
 */
public class OrderShowStatus {

    public static final Map<String, OrderShowStatusEnum> orderShowStatusEnumMap = Maps.newHashMap();

    static {
        OrderShowStatusEnum[] values = OrderShowStatusEnum.values();
        for (OrderShowStatusEnum showStatusEnum : values) {
            orderShowStatusEnumMap.put(showStatusEnum.getKey(), showStatusEnum);
        }
    }
}
