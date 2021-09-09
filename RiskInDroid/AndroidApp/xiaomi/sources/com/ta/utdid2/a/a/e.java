package com.ta.utdid2.a.a;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;

public class e {
    public static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] bytes = d.getBytes(currentTimeMillis);
        byte[] bytes2 = d.getBytes(nanoTime);
        byte[] bytes3 = d.getBytes(nextInt);
        byte[] bytes4 = d.getBytes(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return b.encodeToString(bArr, 2);
    }

    public static String a(Context context) {
        String str = null;
        if (!c.a() && context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Exception unused) {
            }
        }
        if (g.m101a(str)) {
            str = b();
        }
        if (g.m101a(str)) {
            str = b(context);
        }
        return g.m101a(str) ? a() : str;
    }

    private static String b(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            try {
                if (TextUtils.isEmpty(string) || string.equalsIgnoreCase("a5f5faddde9e9f02") || string.equalsIgnoreCase("8e17f7422b35fbea") || string.equalsIgnoreCase("0000000000000000")) {
                    return "";
                }
                return string;
            } catch (Throwable unused) {
                return string;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static String b() {
        String str = h.get("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(str)) {
            str = h.get("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(str) ? c() : str;
    }

    private static String c() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (Exception unused) {
            }
        }
        return g.m101a(str) ? a() : str;
    }
}
