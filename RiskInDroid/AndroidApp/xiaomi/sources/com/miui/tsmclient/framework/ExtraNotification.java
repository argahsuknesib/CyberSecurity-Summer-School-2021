package com.miui.tsmclient.framework;

import android.app.Notification;

public class ExtraNotification {
    public static void setCustomizedIcon(Notification notification, boolean z) {
        notification.extraNotification.setCustomizedIcon(z);
    }
}
