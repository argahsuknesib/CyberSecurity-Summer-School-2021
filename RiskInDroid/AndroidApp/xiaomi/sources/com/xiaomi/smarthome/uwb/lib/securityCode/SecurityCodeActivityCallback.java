package com.xiaomi.smarthome.uwb.lib.securityCode;

import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;

public interface SecurityCodeActivityCallback {
    void onAuthSuccess(UwbScanDevice uwbScanDevice, String str, String str2, String str3);

    void onConnEstablished(UwbScanDevice uwbScanDevice);
}
