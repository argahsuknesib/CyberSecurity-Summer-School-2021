package _m_j;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import org.json.JSONObject;

public final class dgi {
    static String O000000o(Context context) {
        try {
            if (O000000o(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                return deviceId != null ? deviceId : "";
            }
            Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
            return "";
        } catch (Throwable th) {
            Log.w("MID", th);
            return "";
        }
    }

    private static void O000000o(String str, Throwable th) {
        Log.e("MID", str, th);
    }

    static void O000000o(JSONObject jSONObject, String str, String str2) {
        if (O000000o(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public static boolean O000000o(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            O000000o("checkPermission error", th);
            return false;
        }
    }

    static boolean O000000o(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    static String O00000Oo(Context context) {
        String str;
        if (O000000o(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                str = "get wifi address error".concat(String.valueOf(e));
            }
        } else {
            str = "Could not get permission of android.permission.ACCESS_WIFI_STATE";
            Log.i("MID", str);
            return "";
        }
    }

    public static boolean O00000Oo(String str) {
        return str != null && str.trim().length() >= 40;
    }

    public static String O00000o0(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(dlq.O000000o(Base64.decode(str.getBytes("UTF-8"), 0), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            O000000o("decode error", th);
            return str;
        }
    }

    static String O00000o(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(dlq.O000000o(str.getBytes("UTF-8"), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            O000000o("decode error", th);
            return str;
        }
    }
}
