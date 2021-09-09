package com.mibi.sdk.common;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;

public class PermissionUtils {
    public static final String[] BASIC_PERMISSIONS = new String[0];

    public static boolean isPermissionGranted(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static boolean isPermissionsGranted(Context context, String... strArr) {
        for (String isPermissionGranted : strArr) {
            if (!isPermissionGranted(context, isPermissionGranted)) {
                return false;
            }
        }
        return true;
    }

    public static String[] getUngrantedPermissions(Context context, String... strArr) {
        if (strArr == null || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!isPermissionGranted(context, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    public static boolean isAllGranted(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
