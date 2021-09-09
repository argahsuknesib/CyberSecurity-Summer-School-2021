package _m_j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;

public final class ebs {
    public static int O000000o(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return -1;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String O000000o() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (ecd.O000000o(str)) {
            str = "";
        }
        if (ecd.O000000o(str2)) {
            str2 = "";
        }
        if (!ecd.O000000o(str2) && !ecd.O000000o(str) && str2.startsWith(str)) {
            return O000000o(str2);
        }
        return O000000o(str) + " " + str2;
    }

    private static String O000000o(String str) {
        if (ecd.O000000o(str)) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static void O000000o(String str, String str2) {
        if (eby.f15157O000000o) {
            Log.d(str, str2);
        }
    }

    public static boolean O000000o(Context context, String str) {
        PackageManager packageManager;
        return (context == null || (packageManager = context.getPackageManager()) == null || packageManager.checkPermission(str, context.getPackageName()) != 0) ? false : true;
    }

    public static eem O00000Oo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            eem eem = new eem();
            String networkOperator = telephonyManager.getNetworkOperator();
            if (ecd.O000000o(networkOperator)) {
                networkOperator = "";
            }
            eem.O00000o0 = networkOperator;
            GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
            if (gsmCellLocation != null) {
                eem.f15190O000000o = gsmCellLocation.getLac();
                eem.O00000Oo = gsmCellLocation.getCid();
            }
            return eem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O00000Oo(Context context, String str) {
        Bundle O00000o = O00000o(context);
        String string = O00000o != null ? O00000o.getString(str) : "";
        if (TextUtils.isEmpty(string)) {
            O000000o("XMAgent", "Could not read " + str + " meta-data from AndroidManifest.xml.");
        }
        return string;
    }

    static Bundle O00000o(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.metaData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O00000o0(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) == null) ? "" : packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
