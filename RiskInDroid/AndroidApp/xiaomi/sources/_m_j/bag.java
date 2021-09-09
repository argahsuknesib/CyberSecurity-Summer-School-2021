package _m_j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

public final class bag {
    public static int O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                bae.O00000Oo("parseInt--NumberFormatException" + e.getMessage());
            }
        }
        return -1;
    }

    public static String O000000o(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.append((char) i);
        }
        return sb.toString();
    }

    public static boolean O000000o(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            bae.O00000Oo("isExistPackage NameNotFoundException:" + e.getMessage());
            return false;
        }
    }

    public static boolean O000000o(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, NotificationCompat.FLAG_HIGH_PRIORITY);
        } catch (PackageManager.NameNotFoundException e) {
            bae.O00000Oo("isSupportPush NameNotFoundException:" + e.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    public static int O00000Oo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e) {
            bae.O000000o("getVersionCode--Exception:" + e.getMessage());
            return 0;
        }
    }

    public static String O00000o0(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e) {
            bae.O000000o("getVersionName--Exception:" + e.getMessage());
            return null;
        }
    }
}
