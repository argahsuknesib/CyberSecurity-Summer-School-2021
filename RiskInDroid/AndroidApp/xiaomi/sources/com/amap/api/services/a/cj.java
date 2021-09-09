package com.amap.api.services.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class cj {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3365a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    static final String e = "i";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    @TargetApi(9)
    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String a(Context context) {
        return c(context, e);
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f3365a + str;
    }

    public static void b(final Context context) {
        try {
            ExecutorService c2 = cl.c();
            if (c2 == null) {
                return;
            }
            if (!c2.isShutdown()) {
                c2.submit(new Runnable() {
                    /* class com.amap.api.services.a.cj.AnonymousClass1 */

                    public final void run() {
                        try {
                            dl.a(context);
                            cm.b(context);
                            cm.d(context);
                            cm.c(context);
                            Cdo.a(context);
                            dm.a(context);
                        } catch (RejectedExecutionException unused) {
                        } catch (Throwable th) {
                            cl.c(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            cl.c(th, "Lg", "proL");
        }
    }

    static List<by> c(Context context) {
        List<by> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                list = new cu(context, false).a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }

    static boolean a(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                for (String trim : str.split("\n")) {
                    String trim2 = trim.trim();
                    if (a(trim2)) {
                        return false;
                    }
                    if (b(strArr, trim2)) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("uncaughtException")) {
            return true;
        }
        return false;
    }

    static boolean b(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                String str2 = str;
                for (String str3 : strArr) {
                    str2 = str2.trim();
                    if (str2.startsWith("at ")) {
                        if (str2.contains(str3 + ".") && str2.endsWith(")") && !str2.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
