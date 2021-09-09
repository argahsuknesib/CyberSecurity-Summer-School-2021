package com.hzy.tvmao;

import android.os.Build;
import com.hzy.tvmao.utils.LogUtil;
import com.hzy.tvmao.utils.c;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public static int f4469a = 165;
    public static int b = 0;
    public static String c = "android";
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static int g = 0;
    public static String h = null;
    public static String i = null;
    public static String j = null;
    public static boolean k = false;
    public static String l = "xiaomi";

    public static void a() {
        d = c.b();
        e = c.d();
        b = c.c();
        f = Build.VERSION.RELEASE;
        h = Build.MODEL;
        i = Build.MANUFACTURER;
        g = Build.VERSION.SDK_INT;
        j = c.e();
        b();
    }

    public static void b() {
        LogUtil.i("DpAppInfo [APP_VERCODE=" + b + ", APP_VERSION=" + d + ", APP_PACKAGE=" + e + ", PHONE_ANDROID_VERSION=" + f + ", PHONE_MODEL=" + h + ", PHONE_MANUFACTURER=" + i + ", PHONE_DEVICEID=" + j + "]");
    }
}
