package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public final class gog {

    /* renamed from: O000000o  reason: collision with root package name */
    public static WifiManager.MulticastLock f18093O000000o;

    public static String O000000o(Context context) {
        WifiInfo wifiInfo;
        if (context == null) {
            return "";
        }
        try {
            wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo != null) {
            return wifiInfo.getBSSID();
        }
        return null;
    }

    public static String O00000Oo(Context context) {
        WifiInfo wifiInfo;
        if (context == null) {
            return "";
        }
        try {
            wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo != null) {
            return wifiInfo.getBSSID();
        }
        return null;
    }

    public static String O00000o0(Context context) {
        WifiInfo wifiInfo;
        String ssid;
        if (context == null) {
            return "";
        }
        try {
            wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo == null || (ssid = wifiInfo.getSSID()) == null) {
            return null;
        }
        return (ssid.length() < 3 || !ssid.startsWith(jdn.f1779O000000o) || !ssid.endsWith(jdn.f1779O000000o)) ? ssid : ssid.substring(1, ssid.length() - 1);
    }

    public static String O00000o(Context context) {
        WifiInfo wifiInfo;
        if (context == null) {
            return "";
        }
        try {
            wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo != null) {
            return wifiInfo.getMacAddress();
        }
        return null;
    }

    public static String O00000oO(Context context) {
        if (context == null) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void O000000o() {
        try {
            if (f18093O000000o != null && f18093O000000o.isHeld()) {
                f18093O000000o.release();
            }
            f18093O000000o = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean O00000oo(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }
}
