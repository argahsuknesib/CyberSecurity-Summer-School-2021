package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
import java.util.Map;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f3158a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static Map<String, String> f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (i.class) {
            String concat = "apdidTokenCache".concat(String.valueOf(str));
            if (f.containsKey(concat)) {
                String str2 = f.get(concat);
                if (a.b(str2)) {
                    return str2;
                }
            }
            return "";
        }
    }

    public static synchronized void a() {
        synchronized (i.class) {
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (i.class) {
            if (bVar != null) {
                f3158a = bVar.f3154a;
                b = bVar.b;
                c = bVar.c;
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                f3158a = cVar.f3155a;
                b = cVar.b;
                d = cVar.d;
                e = cVar.e;
                c = cVar.c;
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (i.class) {
            String concat = "apdidTokenCache".concat(String.valueOf(str));
            if (f.containsKey(concat)) {
                f.remove(concat);
            }
            f.put(concat, str2);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    public static synchronized boolean a(Context context, String str) {
        boolean z;
        synchronized (i.class) {
            long j = 86400000;
            long a2 = h.a(context);
            if (a2 >= 0) {
                j = a2;
            }
            try {
                if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j) {
                    z = true;
                }
            } catch (Throwable th) {
                com.alipay.apmobilesecuritysdk.c.a.a(th);
            }
            z = false;
        }
        return z;
    }

    public static synchronized String b() {
        String str;
        synchronized (i.class) {
            str = f3158a;
        }
        return str;
    }

    public static void b(String str) {
        f3158a = str;
    }

    public static synchronized String c() {
        String str;
        synchronized (i.class) {
            str = b;
        }
        return str;
    }

    public static void c(String str) {
        b = str;
    }

    public static synchronized String d() {
        String str;
        synchronized (i.class) {
            str = d;
        }
        return str;
    }

    public static void d(String str) {
        c = str;
    }

    public static synchronized String e() {
        String str;
        synchronized (i.class) {
            str = e;
        }
        return str;
    }

    public static void e(String str) {
        d = str;
    }

    public static synchronized String f() {
        String str;
        synchronized (i.class) {
            str = c;
        }
        return str;
    }

    public static void f(String str) {
        e = str;
    }

    public static synchronized c g() {
        c cVar;
        synchronized (i.class) {
            cVar = new c(f3158a, b, c, d, e);
        }
        return cVar;
    }

    public static void h() {
        f.clear();
        f3158a = "";
        b = "";
        d = "";
        e = "";
        c = "";
    }
}
