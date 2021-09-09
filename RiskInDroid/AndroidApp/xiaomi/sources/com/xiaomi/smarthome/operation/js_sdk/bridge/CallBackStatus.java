package com.xiaomi.smarthome.operation.js_sdk.bridge;

public enum CallBackStatus {
    RESULT_ERROR(0),
    RESULT_CANCEL(-1),
    RESULT_SUCCESS(1);
    
    private int value;

    private CallBackStatus(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static CallBackStatus valueOf(int i) {
        if (i == -1) {
            return RESULT_CANCEL;
        }
        if (i == 0) {
            return RESULT_ERROR;
        }
        if (i != 1) {
            return null;
        }
        return RESULT_SUCCESS;
    }
}
