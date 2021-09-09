package com.xiaomi.smarthome.framework.plugin.rn.constants;

public enum RnApiErrorInfo {
    AUTHORITY_ERROR(-1, "has no authority"),
    PARAMS_ERROR(-2, "params error"),
    REQUEST_ERROR(-3, "request error"),
    DEVICE_ERROR(-4, "device is null"),
    INVALID_ERROR(-9999, "invalid error");
    
    private int mCode;
    private String mMessage;

    private RnApiErrorInfo(int i, String str) {
        this.mCode = i;
        this.mMessage = str;
    }

    public final int getCode() {
        return this.mCode;
    }

    public final String getMessage() {
        return this.mMessage;
    }
}
