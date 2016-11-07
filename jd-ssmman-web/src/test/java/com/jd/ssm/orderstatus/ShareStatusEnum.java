package com.jd.ssm.orderstatus;

/**
 * 晒单状态
 */
public enum ShareStatusEnum {

    UN_SHARE(0, "待晒单"),

    SHAREED(1, "已晒单");


    private int key;
    private String value;

    ShareStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static ShareStatusEnum getEnum(int key) {
        for (ShareStatusEnum t : ShareStatusEnum.values()) {
            if (key == t.getKey()) {
                return t;
            }
        }
        return null;
    }

    public static String getValueName(int intValue) {
        for (ShareStatusEnum t : ShareStatusEnum.values()) {
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
