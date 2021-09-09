package com.xiaomi.smarthome.library.bluetooth.connect.listener;

public interface ReadRssiListener extends GattResponseListener {
    void onReadRemoteRssi(int i, int i2);
}
