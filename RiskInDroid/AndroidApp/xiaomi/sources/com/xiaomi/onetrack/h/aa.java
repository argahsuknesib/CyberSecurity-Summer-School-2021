package com.xiaomi.onetrack.h;

import android.util.Log;

public class aa {
    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            Log.e(q.a("SystemProperties"), "get e", e);
            return str2;
        }
    }

    public static String a(String str) {
        return a(str, "");
    }

    public static long a(String str, Long l) {
        try {
            return ((Long) Class.forName("android.os.SystemProperties").getMethod("getLong", String.class, Long.TYPE).invoke(null, str, l)).longValue();
        } catch (Exception e) {
            Log.e(q.a("SystemProperties"), "getLong e", e);
            return l.longValue();
        }
    }
}
