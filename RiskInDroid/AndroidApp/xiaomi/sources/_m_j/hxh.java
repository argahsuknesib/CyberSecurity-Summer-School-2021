package _m_j;

import android.text.TextUtils;
import org.json.JSONObject;

public final class hxh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static hyg f949O000000o = new hyg("plugin");
    private static hyg O00000Oo = new hyg("click");
    private static hyg O00000o0 = new hyg("result");

    public static final String O000000o(long j, long j2) {
        return hxw.O000000o(j, j2);
    }

    public static long O000000o(String str) {
        return f949O000000o.O000000o("entry", str, new Object[0]);
    }

    public static void O000000o(String str, long j, String str2, long j2, long j3, String str3, String str4) {
        f949O000000o.O000000o("rn_plugin_open_time", str, "time", Long.valueOf(j), "model", str2, "plugin_id", Long.valueOf(j2), "package_id", Long.valueOf(j3), "package_name", str3, "sdk_level", 10058L, "sdk_version_name", str4);
    }

    public static void O00000Oo(String str, long j, String str2, long j2, long j3, String str3, String str4) {
        f949O000000o.O000000o("rn_plugin_hot_start", str, "time", Long.valueOf(j), "model", str2, "plugin_id", Long.valueOf(j2), "package_id", Long.valueOf(j3), "package_name", str3, "sdk_level", 10058L, "sdk_version_name", str4);
    }

    public static void O00000o0(String str, long j, String str2, long j2, long j3, String str3, String str4) {
        f949O000000o.O000000o("rn_plugin_loadtime", str, "time", Long.valueOf(j), "model", str2, "plugin_id", Long.valueOf(j2), "package_id", Long.valueOf(j3), "package_name", str3, "sdk_level", 10058L, "sdk_version_name", str4);
    }

    public static void O00000o(String str, long j, String str2, long j2, long j3, String str3, String str4) {
        f949O000000o.O000000o("rn_plugin_hot_loadtime", str, "time", Long.valueOf(j), "model", str2, "plugin_id", Long.valueOf(j2), "package_id", Long.valueOf(j3), "package_name", str3, "sdk_level", 10058L, "sdk_version_name", str4);
    }

    public static void O00000oO(String str, long j, String str2, long j2, long j3, String str3, String str4) {
        f949O000000o.O000000o("rn_plugin_rendering_time", str, "time", Long.valueOf(j), "model", str2, "plugin_id", Long.valueOf(j2), "package_id", Long.valueOf(j3), "package_name", str3, "sdk_level", 10058L, "sdk_version_name", str4);
    }

    public static void O00000oo(String str, long j, String str2, long j2, long j3, String str3, String str4) {
        f949O000000o.O000000o("rn_plugin_rendering_opentime", str, "time", Long.valueOf(j), "model", str2, "plugin_id", Long.valueOf(j2), "package_id", Long.valueOf(j3), "package_name", str3, "sdk_level", 10058L, "sdk_version_name", str4);
    }

    public static long O000000o(String str, long j) {
        return f949O000000o.O000000o("exit", str, "stay_time", Long.valueOf((System.currentTimeMillis() - j) / 1000));
    }

    public static void O000000o(String str, long j, String str2, int i) {
        f949O000000o.O000000o("plugin_launcher_time", str, "time", Long.valueOf(j), "model", str2, "version", Integer.valueOf(i));
    }

    public static void O00000Oo(String str, long j, String str2, int i) {
        f949O000000o.O000000o("plugin_open_time", str, "time", Long.valueOf(j), "model", str2, "version", Integer.valueOf(i));
    }

    public static void O000000o(String str, long j, long j2, long j3, String str2, int i) {
        f949O000000o.O000000o("plugin_init_time", str, "time", Long.valueOf(j), "startTime", Long.valueOf(j2), "loadTime", Long.valueOf(j3), "model", str2, "version", Integer.valueOf(i));
    }

    public static long O000000o(String str, String str2, String str3, Object obj, String str4) {
        if (TextUtils.isEmpty(str4)) {
            str4 = obj.getClass().toString();
        }
        return f949O000000o.O000000o("page_start", str, "model", str2, "name", str4, "did", str3);
    }

    public static long O000000o(String str, String str2, String str3, Object obj, long j, String str4) {
        if (TextUtils.isEmpty(str4)) {
            str4 = obj.getClass().toString();
        }
        return f949O000000o.O000000o("page_end", str, "model", str2, "name", str4, "did", str3, "stay_time", Long.valueOf((System.currentTimeMillis() - j) / 1000));
    }

    public static void O000000o(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        hyg hyg;
        if ("click".equals(str2)) {
            hyg = O00000Oo;
        } else if ("result".equals(str2)) {
            hyg = O00000o0;
        } else {
            return;
        }
        hyg.O000000o(str3, str, hyg.O000000o("plugin", jSONObject), str4);
    }
}
