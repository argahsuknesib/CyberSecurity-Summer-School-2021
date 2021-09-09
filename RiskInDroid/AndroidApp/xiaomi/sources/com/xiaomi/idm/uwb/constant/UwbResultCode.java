package com.xiaomi.idm.uwb.constant;

import com.xiaomi.idm.uwb.util.LogUtil;

public enum UwbResultCode {
    DEFAULT_SUCCESS(0, "Default Success"),
    GENERAL_SUCCESS(1, "General Success"),
    SCAN_ON(2, "Scan on"),
    SCAN_OFF(3, "Scan off"),
    CONNECTED(4, "Connected"),
    DISCONNECTED(5, "Disconnected"),
    TAG_PLUGGED_IN(6, "TAG Device Plugged in"),
    TAG_UNPLUGGED(7, "TAG Device Unplugged"),
    UWB_LOGIN_SUCCESS(8, "Uwb Login success"),
    GENERAL_ERROR(-1, "General Error"),
    MI_CONNECT_SERVICE_NOT_AVAILABLE(-2, "MiConnectService Not Available"),
    START_SCAN_FAILED(-3, "Start Scan failed"),
    STOP_SCAN_FAILED(-4, "Stopt Scan failed"),
    PAY_LOAD_NOT_VALID(-5, "Pay load info not valid"),
    DEVICE_NOT_FOUND(-6, "device not found"),
    UWB_LOGIN_FAIL(-7, "Uwb Login fail"),
    UWB_BLUETOOTH_OFF(-8, "Bluetooth status OFF"),
    UWB_CONNECT_FAILED(-9, "Connect failed"),
    UWB_DISCONNECT_FAILED(-10, "Disconnect failed"),
    UWB_SWITCH_PATH_FAILED(-11, "Switch Path failed"),
    REMOTE_EXCEPTION(-12, "Remote Exception Occurred"),
    UNKNOWN(-9999, "UNKNOWN");
    
    public static final String TAG = UwbResultCode.class.getSimpleName();
    private final int code;
    private final String msg;

    private UwbResultCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public static UwbResultCode fromCode(int i) {
        for (UwbResultCode uwbResultCode : values()) {
            if (uwbResultCode.code == i) {
                return uwbResultCode;
            }
        }
        LogUtil.e(TAG, "fromCode: code parse failed, code = ".concat(String.valueOf(i)), new Object[0]);
        return UNKNOWN;
    }
}
