package com.mi.util;

import _m_j.bxp;
import _m_j.ccr;
import _m_j.cdx;
import _m_j.cdy;
import _m_j.cej;
import _m_j.cem;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;

public class Device {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f5099O000000o;
    public static int O00000Oo;
    public static int O00000o;
    public static String O00000o0;
    public static String O00000oO;
    public static String O00000oo;
    public static String O0000O0o;
    public static String O0000OOo;
    public static String O0000Oo;
    public static String O0000Oo0;
    public static String O0000OoO;
    public static String O0000Ooo;
    public static String O0000o;
    public static String O0000o0;
    public static int O0000o00;
    public static String O0000o0O;
    public static boolean O0000o0o;
    public static String O0000oO;
    public static int O0000oO0;
    public static boolean O0000oOO;
    public static String O0000oOo;
    public static String O0000oo;
    public static String O0000oo0;
    public static String O0000ooO;
    public static String O0000ooo;
    public static String O000O00o;
    public static String O000O0OO;
    public static boolean O000O0Oo;
    public static String O00oOooO;
    public static String O00oOooo;

    public static native String getDToken();

    private static String O000000o() {
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (String) cls.getMethod("get", String.class).invoke(cls, "permanent.hw.custom.serialno");
        } catch (Exception unused2) {
            return null;
        }
    }

    private static boolean O000000o(Context context) {
        try {
            if ((context.getPackageManager().getPackageInfo("com.miui.cloudservice", 0).applicationInfo.flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (Error e) {
            e.printStackTrace();
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            ccr.O000000o("device", "meet name not found exception!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public static void O000000o(Context context, boolean z) {
        String str;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        O00000Oo = displayMetrics.heightPixels;
        f5099O000000o = displayMetrics.widthPixels;
        O00000o0 = O00000Oo + "*" + f5099O000000o;
        O00000o = displayMetrics.densityDpi;
        O00000oO = Build.MODEL;
        O00000oo = Build.DEVICE;
        O0000O0o = Build.PRODUCT;
        O0000OOo = Build.BOARD;
        O0000Oo0 = Build.HARDWARE;
        O0000Oo = Build.MANUFACTURER;
        O0000OoO = Build.BRAND;
        O0000Ooo = Build.TYPE;
        O00oOooO = Build.SERIAL;
        if (Build.VERSION.SDK_INT == 28 && cem.O000000o(context, "android.permission.READ_PHONE_STATE")) {
            O00oOooO = Build.getSerial();
        }
        O0000o0O = Build.VERSION.RELEASE;
        O0000o0 = Build.VERSION.INCREMENTAL;
        O0000o00 = Build.VERSION.SDK_INT;
        O0000o0o = O000000o(context);
        WifiInfo connectionInfo = ((WifiManager) bxp.f13383O000000o.getSystemService("wifi")).getConnectionInfo();
        String macAddress = connectionInfo != null ? connectionInfo.getMacAddress() : null;
        if (!TextUtils.isEmpty(macAddress)) {
            cej.O00000Oo.O000000o(bxp.f13383O000000o, "pref_key_user_mac_address", macAddress);
        }
        O000O0OO = macAddress;
        O00oOooo = O000000o();
        ccr.O00000Oo("device", "acquireAppInfo");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            O0000o = packageInfo.packageName;
            O0000oO0 = packageInfo.versionCode;
            ccr.O00000Oo("device", "acquireAppInfo get APP_VERSION:" + O0000oO0);
            O0000oO = packageInfo.versionName;
            O0000oOO = (packageInfo.applicationInfo.flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            ccr.O00000Oo("device", "acquireAppInfo NameNotFoundException:" + e.toString());
            e.printStackTrace();
            O0000oO0 = 0;
            O0000oO = "";
            O0000oOO = false;
        }
        O0000oOo = Locale.getDefault().getCountry();
        O0000oo0 = Locale.getDefault().getLanguage();
        O0000oo = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (context != null) {
            if (!z || Build.VERSION.SDK_INT >= 29) {
                str = "";
            } else {
                str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            O0000ooo = str;
            String macAddress2 = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(str);
            }
            if (!TextUtils.isEmpty(macAddress2)) {
                stringBuffer.append("_");
                stringBuffer.append(macAddress2);
            }
            O0000ooO = cdy.O000000o(stringBuffer.toString());
            String O00000Oo2 = cej.O00000Oo.O00000Oo(context, "pref_channel", (String) null);
            if (O00000Oo2 == null || O00000Oo2.length() <= 0) {
                O00000Oo2 = cdx.O000000o(context);
                if (O00000Oo2 != null) {
                    cej.O00000Oo.O000000o(context, "pref_channel", O00000Oo2);
                } else {
                    O00000Oo2 = "unknown";
                }
            }
            O000O00o = O00000Oo2;
        }
        long O000000o2 = cej.O00000Oo.O000000o(context, "installTime");
        long currentTimeMillis = System.currentTimeMillis();
        if (O000000o2 > 0) {
            long j = currentTimeMillis - O000000o2;
            if (j >= 0) {
                if (j < 604800000) {
                    O000O0Oo = true;
                    return;
                } else {
                    O000O0Oo = false;
                    return;
                }
            }
        }
        O000O0Oo = true;
        cej.O00000Oo.O000000o(context, "installTime", Long.valueOf(currentTimeMillis));
    }
}
