package com.xiaomi.miot.localtranslatesrv.core.metaDatas;

public enum translateStatus {
    TRANSLATE_RETURN_CLOUD_CODE("当前 model 仅支持云端翻译", 365),
    TRANSLATE_RETURN_NOTNEEDTRANS("当前 model 不是 profile 设备, 无需翻译", 2),
    TRANSLATE_SUCCESS("翻译成功", 0),
    TRANSLATE_RETURN_ERROR("引擎内部错误", -1),
    TRANSLATE_NOT_FIND_RULE("未找到对应的翻译规则", -2),
    TRANSLATE_STATUS_DEFAULT("默认状态", -3);
    
    private String info;
    private int value;

    private translateStatus(String str, int i) {
        this.info = str;
        this.value = i;
    }

    public static translateStatus statusFactory(int i) {
        if (i == -2) {
            return TRANSLATE_NOT_FIND_RULE;
        }
        if (i == -1) {
            return TRANSLATE_RETURN_ERROR;
        }
        if (i == 0) {
            return TRANSLATE_SUCCESS;
        }
        if (i == 2) {
            return TRANSLATE_RETURN_NOTNEEDTRANS;
        }
        if (i != 365) {
            return TRANSLATE_STATUS_DEFAULT;
        }
        return TRANSLATE_RETURN_CLOUD_CODE;
    }

    public final int getValue() {
        return this.value;
    }

    public final String toString() {
        return "translate status:\t" + String.valueOf(this.value) + "\t" + this.info;
    }
}
