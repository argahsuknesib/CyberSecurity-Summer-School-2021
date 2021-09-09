package com.tiqiaa.icontrol.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class ManifestMetaData {
    private static Object readKey(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            Bundle bundle = applicationInfo.metaData;
            LogUtil.d("ManifestMetaData", "readKey..............keyName = " + str + ",metaData -> " + applicationInfo.metaData.keySet());
            return bundle.get(str);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e("ManifestMetaData", "readKey..............keyName = " + str + ",NameNotFoundException -> " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static int getInt(Context context, String str) {
        return ((Integer) readKey(context, str)).intValue();
    }

    public static String getString(Context context, String str) {
        return (String) readKey(context, str);
    }

    public static Boolean getBoolean(Context context, String str) {
        return (Boolean) readKey(context, str);
    }

    public static Object get(Context context, String str) {
        return readKey(context, str);
    }
}
