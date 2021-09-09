package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Looper;
import android.os.Process;

public final class b {
    private static a aG = null;
    private static a aH = null;
    private static final String aI;
    /* access modifiers changed from: private */
    public static int level = 6;

    public interface a {
        void f(String str, String str2);

        void g(String str, String str2);

        int getLogLevel();

        void h(String str, String str2);

        void i(String str, String str2);
    }

    static {
        c cVar = new c();
        aG = cVar;
        aH = cVar;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
            sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
            sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
            sb.append("] BOARD:[" + Build.BOARD);
            sb.append("] DEVICE:[" + Build.DEVICE);
            sb.append("] DISPLAY:[" + Build.DISPLAY);
            sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            sb.append("] HOST:[" + Build.HOST);
            sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            sb.append("] MODEL:[" + Build.MODEL);
            sb.append("] PRODUCT:[" + Build.PRODUCT);
            sb.append("] TAGS:[" + Build.TAGS);
            sb.append("] TYPE:[" + Build.TYPE);
            sb.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        aI = sb.toString();
    }

    public static void a(String str, String str2, Object... objArr) {
        a aVar = aH;
        if (aVar != null && aVar.getLogLevel() <= 4) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            a aVar2 = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar2.i(str, str2);
        }
    }

    public static void b(String str, String str2) {
        a(str, str2, null);
    }

    public static void c(String str, String str2) {
        a aVar = aH;
        if (aVar != null && aVar.getLogLevel() <= 3) {
            a aVar2 = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar2.h(str, str2);
        }
    }

    public static void d(String str, String str2) {
        a aVar = aH;
        if (aVar != null && aVar.getLogLevel() <= 2) {
            a aVar2 = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar2.f(str, str2);
        }
    }

    public static void e(String str, String str2) {
        a aVar = aH;
        if (aVar != null && aVar.getLogLevel() <= 1) {
            if (str2 == null) {
                str2 = "";
            }
            a aVar2 = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar2.g(str, str2);
        }
    }
}
