package com.xiaomi.smarthome.library.bluetooth.connect.response;

public interface BleUpgradeResponse extends BleResponse<String> {
    void onProgress(int i);
}
