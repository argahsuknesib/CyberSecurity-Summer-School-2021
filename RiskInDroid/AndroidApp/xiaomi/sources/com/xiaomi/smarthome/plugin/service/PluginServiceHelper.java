package com.xiaomi.smarthome.plugin.service;

import android.content.Intent;

public class PluginServiceHelper {
    @Deprecated
    public static Intent getNotificationIntent(String str, Intent intent) {
        return getNotificationIntent(str, "", intent);
    }

    public static Intent getNotificationIntent(String str, String str2, Intent intent) {
        Intent intent2 = new Intent();
        intent2.setClassName("com.xiaomi.smarthome", "com.xiaomi.smarthome.device.utils.DeviceLauncher2");
        intent2.setAction("pluignservice.startForeground.notification.pendingIntent");
        intent2.putExtra("params", intent);
        intent2.putExtra("model", str);
        intent2.putExtra("did", str2);
        return intent2;
    }
}
