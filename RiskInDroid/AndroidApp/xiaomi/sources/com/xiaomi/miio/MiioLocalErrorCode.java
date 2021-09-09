package com.xiaomi.miio;

public enum MiioLocalErrorCode {
    SUCCESS(0, "ok"),
    PERMISSION_DENIED(-1, "permission denied"),
    EXCEPTION(-4, "internal exception occurred from local api"),
    DEVICE_EXCEPTION(-5, "internal exception occurred from device"),
    TIMEOUT(-3, "request time out"),
    UNKNOWN(-9, "unknown error"),
    MSG_ID_NOT_MATCH(-10, "upd send and receive msg id not match"),
    MSG_TOO_LONG(-99, "msg too long");
    
    private int code;
    private String message;

    private MiioLocalErrorCode(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
