package com.sdu.didi.openapi.utils;

import _m_j.dbf;
import _m_j.oOOO00o0;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.sdu.didi.openapi.annotation.KeepClass;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;

public class Utils {
    @KeepClass
    public static String MD5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(dbf.O00000o0));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String O000000o(Context context) {
        TelephonyManager telephonyManager;
        String deviceId;
        return (oOOO00o0.O000000o(context, "android.permission.READ_PHONE_STATE") != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (deviceId = telephonyManager.getDeviceId()) == null) ? "" : deviceId;
    }

    public static String O000000o(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return "";
    }

    public static String O000000o(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry next : map.entrySet()) {
            builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        StringBuilder sb = new StringBuilder(builder.toString());
        if (sb.length() > 0 && sb.charAt(0) == '?') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static boolean O000000o() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static String O00000Oo(Context context) {
        if (context == null) {
            return null;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return "null";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        return connectionInfo.getMacAddress() != null ? connectionInfo.getMacAddress() : "null";
    }

    @KeepClass
    public static String getCurrentVersion() {
        return "2.0.0111_18060500163622";
    }

    @KeepClass
    public static String getRandomString(int i) {
        char[] cArr = new char[i];
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(61));
        }
        return new String(cArr);
    }

    @KeepClass
    public static String getTimestamp() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        return sb.toString();
    }
}
