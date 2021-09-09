package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

public class a {
    private static a c;
    private String b;

    public String a() {
        return "000000000000000";
    }

    public String b() {
        return "000000000000000";
    }

    public static a a(Context context) {
        if (c == null) {
            c = new a(context);
        }
        return c;
    }

    private a(Context context) {
        try {
            this.b = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (TextUtils.isEmpty(this.b)) {
                this.b = "00:00:00:00:00:00";
            }
        } catch (Exception e) {
            c.a(e);
            if (TextUtils.isEmpty(this.b)) {
                this.b = "00:00:00:00:00:00";
            }
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = "00:00:00:00:00:00";
            }
            throw th;
        }
    }

    public String c() {
        String str = b() + "|";
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return str + "000000000000000";
        }
        return str + a2;
    }

    public String d() {
        return this.b;
    }

    public static e b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                return e.a(activeNetworkInfo.getSubtype());
            }
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                return e.NONE;
            }
            return e.WIFI;
        } catch (Exception unused) {
            return e.NONE;
        }
    }

    public static String c(Context context) {
        return a(context).c().substring(0, 8);
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
