package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;

public class MetadataValueReader {
    private static Object sLock = new Object();
    private static boolean zzui;
    private static String zzuj;
    private static int zzuk;

    public static String getGoogleAppId(Context context) {
        zze(context);
        return zzuj;
    }

    public static int getGooglePlayServicesVersion(Context context) {
        zze(context);
        return zzuk;
    }

    @VisibleForTesting
    public static void resetForTesting() {
        synchronized (sLock) {
            zzui = false;
        }
    }

    @VisibleForTesting
    public static void setValuesForTesting(String str, int i) {
        synchronized (sLock) {
            zzuj = str;
            zzuk = i;
            zzui = true;
        }
    }

    private static void zze(Context context) {
        synchronized (sLock) {
            if (!zzui) {
                zzui = true;
                try {
                    Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
                    if (bundle != null) {
                        zzuj = bundle.getString("com.google.app.id");
                        zzuk = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
