package _m_j;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public final class diu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final Uri f14700O000000o = Uri.parse("content://telephony/carriers/preferapn");

    public static String O000000o() {
        return "";
    }

    public static String O000000o(Context context) {
        int O00000o = O00000o(context);
        if (O00000o == 2) {
            return "wifi";
        }
        if (O00000o == 1) {
            return "cmwap";
        }
        if (O00000o == 4) {
            return "cmnet";
        }
        if (O00000o == 16) {
            return "uniwap";
        }
        if (O00000o == 8) {
            return "uninet";
        }
        if (O00000o == 64) {
            return "wap";
        }
        if (O00000o == 32) {
            return "net";
        }
        if (O00000o == 512) {
            return "ctwap";
        }
        if (O00000o == 256) {
            return "ctnet";
        }
        if (O00000o == 2048) {
            return "3gnet";
        }
        return O00000o == 1024 ? "3gwap" : "none";
    }

    private static String O00000o0(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f14700O000000o, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            if (query != null) {
                query.close();
            }
            return string;
        } catch (SecurityException e) {
            diz.O00000oO("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
            return "";
        }
    }

    private static int O00000o(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return NotificationCompat.FLAG_HIGH_PRIORITY;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
                return 2;
            }
            String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (lowerCase.startsWith("cmwap")) {
                return 1;
            }
            if (lowerCase.startsWith("cmnet")) {
                return 4;
            }
            if (lowerCase.startsWith("epc.tmobile.com")) {
                return 4;
            }
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith("net")) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String O00000o0 = O00000o0(context);
                if (O00000o0 == null || O00000o0.length() <= 0) {
                    return 256;
                }
                return 512;
            }
            return NotificationCompat.FLAG_HIGH_PRIORITY;
        } catch (Exception e) {
            diz.O00000oO("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e.getMessage());
        }
    }

    public static String O00000Oo(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "MOBILE";
        }
        return activeNetworkInfo.getTypeName();
    }
}
