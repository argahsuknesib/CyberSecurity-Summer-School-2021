package com.xiaomi.accountsdk.request;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.xiaomi.accountsdk.utils.CloudCoder;

public class NetworkUtils {
    public static String getNetworkNameForMiUrlStat(Context context) {
        return deleteUrlUnsafeChar(getActiveConnPoint(context));
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    static String getActiveConnPoint(Context context) {
        NetworkInfo activeNetworkInfo;
        String str = "";
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return str;
            }
            if (activeNetworkInfo.getType() != 1) {
                return String.format("%s-%s-%s", activeNetworkInfo.getTypeName(), replacePlusToPChar(activeNetworkInfo.getSubtypeName()), activeNetworkInfo.getExtraInfo()).toLowerCase();
            }
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                str = wifiManager.getConnectionInfo() != null ? wifiManager.getConnectionInfo().getSSID() : null;
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(str)) {
                return "wifi";
            }
            return "wifi-" + CloudCoder.hashDeviceInfo(str).substring(0, 3).toLowerCase();
        } catch (Exception unused2) {
            return str;
        }
    }

    static String replacePlusToPChar(String str) {
        if (str != null) {
            return str.replaceAll("\\+", "p");
        }
        return null;
    }

    static String deleteUrlUnsafeChar(String str) {
        if (str != null) {
            return str.replaceAll("[^a-zA-Z0-9-_.]", "");
        }
        return null;
    }
}
