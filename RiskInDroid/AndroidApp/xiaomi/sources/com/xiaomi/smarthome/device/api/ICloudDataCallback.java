package com.xiaomi.smarthome.device.api;

public interface ICloudDataCallback<T> {
    void onCloudDataFailed(int i, String str);

    void onCloudDataProgress(int i);

    void onCloudDataSuccess(Object obj, Object obj2);
}
