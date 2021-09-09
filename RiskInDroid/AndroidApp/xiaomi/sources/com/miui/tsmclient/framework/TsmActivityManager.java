package com.miui.tsmclient.framework;

import android.app.ActivityManager;
import android.content.pm.IPackageDataObserver;

public class TsmActivityManager {
    public static void clearApplicationUserData(ActivityManager activityManager, String str, IPackageDataObserver iPackageDataObserver) {
        activityManager.clearApplicationUserData(str, iPackageDataObserver);
    }
}
