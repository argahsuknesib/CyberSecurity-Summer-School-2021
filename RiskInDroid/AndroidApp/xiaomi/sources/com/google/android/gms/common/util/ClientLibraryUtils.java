package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.wrappers.Wrappers;

public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    public static int getClientVersion(Context context, String str) {
        return getClientVersion(getPackageInfo(context, str));
    }

    public static int getClientVersion(PackageInfo packageInfo) {
        Bundle bundle;
        if (packageInfo == null || packageInfo.applicationInfo == null || (bundle = packageInfo.applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(str, NotificationCompat.FLAG_HIGH_PRIORITY);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isPackageSide() {
        return false;
    }

    public static boolean isPackageStopped(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (Wrappers.packageManager(context).getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
