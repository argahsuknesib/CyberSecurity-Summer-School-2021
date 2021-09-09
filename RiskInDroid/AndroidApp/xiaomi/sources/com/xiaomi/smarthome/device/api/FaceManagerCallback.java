package com.xiaomi.smarthome.device.api;

public interface FaceManagerCallback<T> {
    void onFailure(int i, String str);

    void onSuccess(T t, T t2);
}
