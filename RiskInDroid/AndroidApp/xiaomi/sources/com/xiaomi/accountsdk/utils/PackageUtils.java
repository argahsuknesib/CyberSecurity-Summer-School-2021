package com.xiaomi.accountsdk.utils;

import android.content.Context;
import java.util.Arrays;

public class PackageUtils {
    private PackageUtils() {
    }

    public static boolean isAppDebuggable(Context context) {
        if (context != null) {
            return (context.getApplicationInfo().flags & 2) != 0;
        }
        throw new NullPointerException("context cannot be null");
    }

    private static String[] getPackagesByUid(Context context, int i) {
        return context.getPackageManager().getPackagesForUid(i);
    }

    public static String getMinimumPackageNameByCallingUid(Context context, int i) {
        String[] packagesByUid = getPackagesByUid(context, i);
        if (packagesByUid == null || packagesByUid.length <= 0) {
            return null;
        }
        Arrays.sort(packagesByUid);
        return packagesByUid[0];
    }
}
