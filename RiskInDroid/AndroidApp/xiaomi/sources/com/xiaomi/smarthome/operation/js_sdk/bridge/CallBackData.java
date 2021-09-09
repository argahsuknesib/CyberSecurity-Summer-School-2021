package com.xiaomi.smarthome.operation.js_sdk.bridge;

import java.io.Serializable;

public class CallBackData implements Serializable {
    public String data;
    public CallBackStatus status;

    public final void O000000o(int i) {
        this.status = CallBackStatus.valueOf(i);
    }
}
