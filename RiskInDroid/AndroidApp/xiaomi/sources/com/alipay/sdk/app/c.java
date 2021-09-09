package com.alipay.sdk.app;

public enum c {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");
    
    private int h;
    private String i;

    private c(int i2, String str) {
        this.h = i2;
        this.i = str;
    }

    public final void a(int i2) {
        this.h = i2;
    }

    public final int a() {
        return this.h;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final String b() {
        return this.i;
    }

    public static c b(int i2) {
        if (i2 == 4001) {
            return PARAMS_ERROR;
        }
        if (i2 == 5000) {
            return DOUBLE_REQUEST;
        }
        if (i2 == 8000) {
            return PAY_WAITTING;
        }
        if (i2 == 9000) {
            return SUCCEEDED;
        }
        if (i2 == 6001) {
            return CANCELED;
        }
        if (i2 != 6002) {
            return FAILED;
        }
        return NETWORK_ERROR;
    }
}
