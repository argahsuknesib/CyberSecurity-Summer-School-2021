package com.xiaomi.smarthome.device.api;

public interface Callback<T> {
    void onFailure(int i, String str);

    void onSuccess(Object obj);
}
