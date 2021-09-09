package com.xiaomi.onetrack.b;

import android.text.TextUtils;
import com.xiaomi.onetrack.d.f;
import com.xiaomi.onetrack.g.c;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.r;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static String f6125a = "ConfigProvider";
    private static volatile boolean b = false;
    private static volatile boolean c = true;

    public static boolean a() {
        try {
            String[] b2 = f.a().b();
            boolean z = !TextUtils.isEmpty(b2[0]) && !TextUtils.isEmpty(b2[1]);
            boolean a2 = r.a(f6125a);
            if (!z || a2) {
                return false;
            }
            return true;
        } catch (Exception e) {
            q.a(f6125a, "ConfigProvider.available", e);
            return false;
        }
    }

    public static int a(int i) {
        int i2;
        if (q.b) {
            q.a(f6125a, "debug upload mode, send events immediately");
            return 0;
        }
        try {
            i2 = c.c().get(Integer.valueOf(i + 1)).intValue();
        } catch (Exception unused) {
            i2 = 60000;
        }
        q.a(f6125a, "getUploadInterval ".concat(String.valueOf(i2)));
        return i2;
    }

    public static synchronized void a(boolean z) {
        synchronized (l.class) {
            b = z;
        }
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (l.class) {
            z = b;
        }
        return z;
    }

    public static boolean c() {
        return c.a();
    }
}
