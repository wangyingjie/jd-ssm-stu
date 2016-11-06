package com.jd.ssm.orderstatus;

/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 2015/11/23
 * Time: 21:36
 * 中奖状态
 */
public enum AwardStatusEnum {

    NOT_AWARD(0, "未中奖"),// 未中奖

    AWARD(1, "已中奖"),// 已中奖

    AWARD_CANCEL(2, "中奖取消");// 中奖取消(用于再次算奖)


    private int key;
    private String value;

    AwardStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static OrderStatusEnum getEnum(int key) {
        for (OrderStatusEnum t : OrderStatusEnum.values()) {
            if (key == t.getKey()) {
                return t;
            }
        }
        return null;
    }

    public static String getValueName(int intValue) {
        for (OrderStatusEnum t : OrderStatusEnum.values()) {
            if (intValue == t.getKey()) {
                return t.getValue();
            }
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
