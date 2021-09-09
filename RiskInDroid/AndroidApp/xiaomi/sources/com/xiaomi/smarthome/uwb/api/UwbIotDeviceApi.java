package com.xiaomi.smarthome.uwb.api;

import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;

public class UwbIotDeviceApi {
    public static boolean isUWBAvailable() {
        return UwbIdmManager.getInstance().isUwbValid();
    }
}
