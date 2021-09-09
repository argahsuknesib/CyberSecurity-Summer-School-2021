package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

public final class ol {

    /* renamed from: O000000o  reason: collision with root package name */
    public static O000000o f2355O000000o = null;
    public static O00000Oo O00000Oo = null;
    private static volatile String O00000o = null;
    private static volatile String O00000o0 = null;
    private static volatile String O00000oO = null;
    private static volatile String O00000oo = null;
    private static volatile String O0000O0o = null;
    private static volatile boolean O0000OOo = true;

    public interface O000000o {
        String O000000o();
    }

    public interface O00000Oo {
        String O000000o();
    }

    public static String O000000o() {
        if (TextUtils.isEmpty(O00000oO)) {
            try {
                if (f2355O000000o != null) {
                    O00000oO = f2355O000000o.O000000o();
                }
            } catch (Exception unused) {
            }
        }
        return O00000oO == null ? "" : O00000oO;
    }

    public static String O000000o(Context context) {
        if (O00000o0 == null && O0000OOo) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                O00000o0 = Build.VERSION.SDK_INT >= 26 ? telephonyManager.getImei() : telephonyManager.getDeviceId();
            } catch (Throwable unused) {
            }
            if (O00000o0 == null) {
                O00000o0 = "";
            }
        }
        return O00000o0 == null ? "" : O00000o0;
    }

    public static void O000000o(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(O00000o)) {
            O00000o = str;
            try {
                context.getSharedPreferences("sp_common", 0).edit().putString("tid", oz.O000000o(str)).apply();
            } catch (Exception unused) {
            }
        }
    }

    public static void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            O00000oO = str;
        }
    }

    public static void O000000o(boolean z) {
        O0000OOo = z;
    }

    public static String O00000Oo() {
        if (TextUtils.isEmpty(O00000oO)) {
            try {
                if (f2355O000000o != null) {
                    O00000oO = f2355O000000o.O000000o();
                }
            } catch (Exception unused) {
            }
        }
        return O00000oO == null ? "" : O00000oO;
    }

    public static String O00000Oo(Context context) {
        if (O00000o == null) {
            try {
                if (O0000OOo) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("sp_common", 0);
                    String O00000Oo2 = oz.O00000Oo(sharedPreferences.getString("tid", null));
                    if (TextUtils.isEmpty(O00000Oo2) && O00000Oo != null) {
                        O00000Oo2 = O00000Oo.O000000o();
                        if (!TextUtils.isEmpty(O00000Oo2)) {
                            sharedPreferences.edit().putString("tid", oz.O000000o(O00000Oo2)).apply();
                        } else {
                            O00000o = "";
                        }
                    }
                    O00000o = O00000Oo2;
                }
            } catch (Exception unused) {
            }
        }
        return O00000o == null ? "" : O00000o;
    }

    public static void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            O00000oO = str;
        }
    }

    public static long O00000o(Context context) {
        return pe.O000000o(O00000oO(context));
    }

    public static String O00000o() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER;
    }

    public static String O00000o0() {
        return Build.MODEL == null ? "" : Build.MODEL;
    }

    public static String O00000o0(Context context) {
        if (O00000oo == null) {
            try {
                if (O0000OOo) {
                    O00000oo = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                }
            } catch (Exception | SecurityException unused) {
            }
            if (O00000oo == null) {
                O00000oo = "";
            }
        }
        return O00000oo == null ? "" : O00000oo;
    }

    public static int O00000oO() {
        return Build.VERSION.SDK_INT;
    }

    public static String O00000oO(Context context) {
        WifiInfo connectionInfo;
        if (!TextUtils.isEmpty(O0000O0o)) {
            return O0000O0o;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
                String macAddress = connectionInfo.getMacAddress();
                if (Build.VERSION.SDK_INT >= 23 && macAddress != null && macAddress.equals("02:00:00:00:00:00")) {
                    macAddress = O00000oo();
                }
                if (macAddress != null && macAddress.length() > 0) {
                    String replace = macAddress.replace(":", "");
                    if (replace != null && replace.length() > 0) {
                        O0000O0o = replace;
                    }
                    return replace;
                }
            }
        } catch (Exception | SecurityException unused) {
        }
        return "";
    }

    private static String O00000oo() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    if (Build.VERSION.SDK_INT >= 9) {
                        bArr = networkInterface.getHardwareAddress();
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = bArr.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(bArr[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
