package com.xiaomi.smarthome.library.bluetooth.connect.listener;

public interface RequestMtuListener extends GattResponseListener {
    void onMtuChanged(int i, int i2);
}
