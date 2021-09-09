package com.xiaomi.smarthome.library.bluetooth.connect.response;

public interface BleResponse<T> {
    void onResponse(int i, T t);
}
