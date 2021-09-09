package com.miui.tsmclient.util;

import android.content.Context;
import com.miui.tsmclient.common.net.request.BaseRequest;

public class CardEnvironmentConfig {
    private static IDeviceInfo sIDeviceInfo;

    public static void setDeviceInfo(IDeviceInfo iDeviceInfo) {
        sIDeviceInfo = iDeviceInfo;
    }

    public static IDeviceInfo getDeviceInfo() {
        return sIDeviceInfo;
    }

    public static String getDefaultDevice() {
        Context context = EnvironmentConfig.getContext();
        if (context == null) {
            return null;
        }
        return context.getPackageName();
    }

    public static BaseRequest.RequestType getDefaultSecureType() {
        return EnvironmentConfig.isLoginAuth() ? BaseRequest.RequestType.SECURE : BaseRequest.RequestType.AUTH;
    }

    private CardEnvironmentConfig() {
    }
}
