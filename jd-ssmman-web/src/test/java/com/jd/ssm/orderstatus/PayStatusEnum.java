package com.jd.ssm.orderstatus;

/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 2015/11/23
 * Time: 20:44
 *
 * 支付状态
 */
public enum PayStatusEnum {

    NO_PAY(0, "未支付"),// 未支付(包含部分退款)

    YES_PAY(1, "已支付"),// 已支付

    PAY_EXCEPTION(40, "支付异常"),// 支付异常
    PAY_FAIL(41, "支付失败"),// 支付失败

    WAIT_REFUND(2, "待申请退款"),// 待申请退款（已插入退款任务）

    REFUNDING(3, "退款中"),// 退款中  （已向网关推送退款请求）

    REFUND_SUCCESS(4, "退款成功"),// 退款成功

    REFUND_REJECT(50, "退款驳回"),//   退款驳回

    REFUND_FAIL(51, "退款失败");// 退款失败

    private int key;
    private String value;

    PayStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static PayStatusEnum getEnum(int key) {
        for (PayStatusEnum t : PayStatusEnum.values()) {
            if (key == t.getKey()) {
                return t;
            }
        }
        return null;
    }

    public static String getValueName(int intValue) {
        for (PayStatusEnum t : PayStatusEnum.values()) {
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
