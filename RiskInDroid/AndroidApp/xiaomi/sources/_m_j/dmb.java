package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dmb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14780O000000o = "";

    public static String O000000o(Context context) {
        try {
            if (O000000o(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
                return null;
            }
            Log.e("MtaSDK", "Could not get permission of android.permission.READ_PHONE_STATE");
            return null;
        } catch (Throwable th) {
            Log.e("MtaSDK", "get device id error", th);
            return null;
        }
    }

    public static String O000000o(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(dlq.O00000Oo(dlr.O000000o(str.getBytes("UTF-8"))), "UTF-8");
        } catch (Throwable th) {
            Log.e("MtaSDK", "decode error", th);
            return str;
        }
    }

    public static void O000000o(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                Log.e("MtaSDK", "jsonPut error", th);
            }
        }
    }

    public static boolean O000000o(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            Log.e("MtaSDK", "checkPermission error", th);
            return false;
        }
    }

    public static String O00000Oo(Context context) {
        if (O000000o(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                Log.e("MtaSDK", "get wifi address error", e);
                return "";
            }
        } else {
            Log.e("MtaSDK", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return "";
        }
    }

    public static String O00000Oo(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(dlr.O00000Oo(dlq.O000000o(str.getBytes("UTF-8"))), "UTF-8");
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
            return str;
        }
    }

    public static String O00000o(Context context) {
        try {
            WifiInfo O0000O0o = O0000O0o(context);
            if (O0000O0o != null) {
                return O0000O0o.getSSID();
            }
            return null;
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
            return null;
        }
    }

    public static String O00000o0(Context context) {
        try {
            WifiInfo O0000O0o = O0000O0o(context);
            if (O0000O0o != null) {
                return O0000O0o.getBSSID();
            }
            return null;
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
            return null;
        }
    }

    public static boolean O00000oO(Context context) {
        try {
            if (!O000000o(context, "android.permission.INTERNET") || !O000000o(context, "android.permission.ACCESS_NETWORK_STATE")) {
                Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    return true;
                }
                Log.w("MtaSDK", "Network error");
                return false;
            }
            return false;
        } catch (Throwable th) {
            Log.e("MtaSDK", "isNetworkAvailable error", th);
        }
    }

    public static JSONArray O00000oo(Context context) {
        List<ScanResult> scanResults;
        try {
            if (!O000000o(context, "android.permission.INTERNET") || !O000000o(context, "android.permission.ACCESS_NETWORK_STATE")) {
                Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (scanResults = wifiManager.getScanResults()) == null || scanResults.size() <= 0) {
                return null;
            }
            Collections.sort(scanResults, new dmc());
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (i < scanResults.size() && i < 10) {
                ScanResult scanResult = scanResults.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bs", scanResult.BSSID);
                jSONObject.put("ss", scanResult.SSID);
                jSONArray.put(jSONObject);
                i++;
            }
            return jSONArray;
        } catch (Throwable th) {
            Log.e("MtaSDK", "isWifiNet error", th);
            return null;
        }
    }

    private static WifiInfo O0000O0o(Context context) {
        WifiManager wifiManager;
        if (!O000000o(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }
}
