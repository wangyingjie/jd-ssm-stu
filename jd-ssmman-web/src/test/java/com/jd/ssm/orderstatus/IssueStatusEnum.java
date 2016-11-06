package com.jd.ssm.orderstatus;

/**
 * Created by renyi7 on 2015/11/30.
 */
public enum IssueStatusEnum {

    OPEN_ISSUE(1, "已开期"),// 已开期

    END_ISSUE(2, "已结期"),// 已结期(待算奖)

    WAIT_CONFIRM_ADDRESS(3, "已算奖"),// 已算奖(待确认收货地址)

    WAIT_SEND(4, "待商家发货"),// 待商家发货

    WAIT_RECEIVE(5, "待确认收货"),// 待确认收货

    RECEIVED(6, "已确认收货"),// 已确认收货

    REFUND_ISSUE(50, "未结期退款");//未结期退款

    private int type;
    private String value;

    IssueStatusEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getValueByType(int type) {
        IssueStatusEnum[] issueStatusEnums = IssueStatusEnum.values();
        for (int i = 0; i < issueStatusEnums.length; i++) {
            IssueStatusEnum issueStatusEnum = issueStatusEnums[i];
            if (type == issueStatusEnum.getType()) {
                return issueStatusEnum.getValue();
            }
        }
        return null;
    }
}
