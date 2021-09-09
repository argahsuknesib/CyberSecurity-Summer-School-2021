package com.xiaomi.onetrack.h;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.onetrack.f.a;

public class z {
    private static SharedPreferences c;
    private static SharedPreferences.Editor d;

    private static void C() {
        if (d == null) {
            synchronized (z.class) {
                if (d == null) {
                    SharedPreferences sharedPreferences = a.a().getSharedPreferences("one_track_pref", 0);
                    c = sharedPreferences;
                    d = sharedPreferences.edit();
                }
            }
        }
    }

    private static String a(String str, String str2) {
        C();
        return c.getString(str, str2);
    }

    private static void b(String str, String str2) {
        C();
        d.putString(str, str2).apply();
    }

    private static long a(String str, long j) {
        C();
        return c.getLong(str, j);
    }

    private static void b(String str, long j) {
        C();
        d.putLong(str, j).apply();
    }

    private static boolean a(String str, boolean z) {
        C();
        return c.getBoolean(str, z);
    }

    private static void b(String str, boolean z) {
        C();
        d.putBoolean(str, z).apply();
    }

    private static void a(String str, float f) {
        C();
        d.putFloat(str, f).apply();
    }

    private static float b(String str, float f) {
        C();
        return c.getFloat(str, f);
    }

    private static void k(String str) {
        C();
        d.remove(str).apply();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long a() {
        return a("last_upload_active_time", 0L);
    }

    public static void a(long j) {
        b("last_upload_active_time", j);
    }

    public static long b(long j) {
        return a("last_upload_usage_time", j);
    }

    public static void c(long j) {
        b("last_collect_crash_time", j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long b() {
        return a("last_collect_crash_time", 0L);
    }

    public static void d(long j) {
        b("report_crash_ticket", j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long c() {
        return a("report_crash_ticket", 0L);
    }

    public static void e(long j) {
        b("last_upload_usage_time", j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long d() {
        return a("s_t", 0L);
    }

    public static void f(long j) {
        b("s_t", j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long e() {
        return a("l_t", 0L);
    }

    public static void g(long j) {
        b("l_t", j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long f() {
        return a("e_t", 0L);
    }

    public static void h(long j) {
        b("e_t", j);
    }

    public static void a(String str) {
        b("secret_key_data", str);
    }

    public static String g() {
        return a("secret_key_data", "");
    }

    public static void b(String str) {
        b("region_rul", str);
    }

    public static String h() {
        return a("region_rul", "");
    }

    public static void i(long j) {
        b("last_secret_key_time", j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long i() {
        return a("last_secret_key_time", 0L);
    }

    public static void j(long j) {
        b("next_update_common_conf_time", j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long j() {
        return a("next_update_common_conf_time", 0L);
    }

    public static void c(String str) {
        b("common_config_hash", str);
    }

    public static String k() {
        return a("common_config_hash", "");
    }

    public static void d(String str) {
        b("common_cloud_data", str);
    }

    public static String l() {
        return a("common_cloud_data", "");
    }

    public static String m() {
        return a("pref_instance_id", "");
    }

    public static void e(String str) {
        b("pref_instance_id", str);
        k(ab.a());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long n() {
        return a("pref_instance_id_last_use_time", 0L);
    }

    public static void k(long j) {
        b("pref_instance_id_last_use_time", j);
    }

    public static String o() {
        return a("last_usage_resume_component", "");
    }

    public static void f(String str) {
        b("last_usage_resume_component", str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long p() {
        return a("last_usage_resume_time", 0L);
    }

    public static void l(long j) {
        b("last_usage_resume_time", j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean */
    public static boolean q() {
        return a("network_access_enabled", true);
    }

    public static void a(boolean z) {
        b("network_access_enabled", z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean */
    public static boolean r() {
        return a("anonymous_enabled", false);
    }

    public static void b(boolean z) {
        b("anonymous_enabled", z);
    }

    public static void c(boolean z) {
        b("onetrack_first_open", z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean */
    public static boolean s() {
        return a("onetrack_first_open", true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long t() {
        return a("dau_last_time", 0L);
    }

    public static void m(long j) {
        b("dau_last_time", j);
    }

    public static void g(String str) {
        b("onetrack_user_id", str);
    }

    public static String u() {
        return a("onetrack_user_id", "");
    }

    public static void v() {
        k("onetrack_user_id");
    }

    public static void h(String str) {
        b("onetrack_user_type", str);
    }

    public static String w() {
        return a("onetrack_user_type", "");
    }

    public static void x() {
        k("onetrack_user_type");
    }

    public static void a(Context context, String str) {
        b("custom_id", str);
    }

    public static String a(Context context) {
        return a("custom_id", "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long y() {
        return a("network_access_enabled", 0L);
    }

    public static String z() {
        return a("page_end", "");
    }

    public static void i(String str) {
        b("page_end", str);
    }

    public static void j(String str) {
        b("last_app_version", str);
    }

    public static String A() {
        return a("last_app_version", "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.z.a(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.h.z.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.z.a(android.content.Context, java.lang.String):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, float):void
      com.xiaomi.onetrack.h.z.a(java.lang.String, boolean):boolean
      com.xiaomi.onetrack.h.z.a(java.lang.String, long):long */
    public static long B() {
        return a("first_launch_time", 0L);
    }

    public static void n(long j) {
        b("first_launch_time", j);
    }
}
