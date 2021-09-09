package com.xiaomi.smarthome.frame;

public enum ErrorCode {
    LOGIN_XIAOMI_ACCOUNT_FAIL(1),
    LOGIN_TIME_OUT(2),
    SUCCESS(0),
    SUCCESS_CACHE(3),
    ERROR_PERMISSION_DENIED(-1),
    ERROR_DEVICE_OFF_LINE(-2),
    ERROR_REQUEST_TIME_OUT(-3),
    ERROR_INTERNAL_SERVER_ERROR(-4),
    ERROR_INTERNAL_DEVICE_ERROR(-5),
    ERROR_INVALID_REQUEST(-6),
    ERROR_MSG_TOO_LONG(-7),
    ERROR_MSG_FORMAT_ERROR(-8),
    ERROR_UNKNOWN_ERROR(-9),
    ERROR_NO_METHOD(-10),
    ERROR_REPEATED_REQUEST(-11),
    ERROR_FEQUENT_REQUEST(-12),
    ERROR_MAXIMAL_SHARE_REQUEST(-13),
    ERROR_SUBDEVICE_NOT_FOUND(-14),
    ERROR_SUBDEVICE_NO_METHOD(-15),
    ERROR_SUBDEVICE_ERROR(-16),
    ERROR_RETRY_ERROR(-17),
    ERROR_DECRYPT_FAIL(-30),
    ERROR_RESPONSE_JSON_FAIL(-31),
    ERROR_UNLOGIN(-32),
    ERROR_NETWORK_ERROR(-33),
    ERROR_ENCRYPT_FAIL(-34),
    ERROR_PARAM_JSON_ERROR(-35),
    ERROR_NOT_SUPPORT(-1001),
    ERROR_ALARM(-5001),
    INVALID(-9999),
    ERROR_JSON_PARSER_EXCEPTION(-10000);
    
    private int mCode;

    private ErrorCode(int i) {
        this.mCode = i;
    }

    public static ErrorCode valueof(int i) {
        for (ErrorCode errorCode : values()) {
            if (i == errorCode.getCode()) {
                return errorCode;
            }
        }
        return INVALID;
    }

    public final int getCode() {
        return this.mCode;
    }
}
