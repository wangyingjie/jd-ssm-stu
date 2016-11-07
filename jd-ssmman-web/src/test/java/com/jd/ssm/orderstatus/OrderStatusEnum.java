package com.jd.ssm.orderstatus;

/**
 * User: ckm
 * Date: 2015/11/23
 * Time: 20:32
 *
 * 订单状态
 */
public enum OrderStatusEnum {
    NO_PARTAKE(0, "未参与"),// 未参与

    WAIT_DISTRIBUTE(1, "待分配抢宝号"),// 待分配夺宝号

    PARTAKE_SUCCESS(2, "参与成功"),// 参与成功

    PARTAKE_FAIL(3, "参与失败(全额退款)"),// 参与失败(全额退款)

    FINISH(10, "已完成"),// 已完成

    CANCEL(11, "已取消(删单退款和超期未支付)");// 已取消(删单退款和超期未支付)

    private int key;
    private String value;

    OrderStatusEnum(int key, String value) {
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
