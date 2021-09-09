package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.content.Context;

public final class MacAddressUtil {
    public static String getMacAddress(Context context) {
        return HardwareInfo.getWifiMacAddress(context);
    }
}
