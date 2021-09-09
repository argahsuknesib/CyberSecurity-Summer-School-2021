package com.xiaomi.onetrack.h.a;

import android.content.Context;
import com.xiaomi.onetrack.h.a.a.c;
import com.xiaomi.onetrack.h.a.a.j;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.r;
import com.xiaomi.onetrack.h.v;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6142a = "a";
    private static volatile a b;
    private volatile boolean c = false;
    private volatile String d = "";

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public String a(Context context) {
        synchronized (this.d) {
            if (v.a()) {
                if (!q.f6178a) {
                    q.b(f6142a, "getOaid() throw exception : Don't use it on the main thread");
                    return "";
                }
                throw new IllegalStateException("Don't use it on the main thread");
            } else if (this.d != null && !this.d.equals("")) {
                String str = this.d;
                return str;
            } else if (this.c) {
                String str2 = this.d;
                return str2;
            } else if (r.a()) {
                this.d = o.b(context);
                String str3 = this.d;
                return str3;
            } else {
                String a2 = new j().a(context);
                if (a2 == null || a2.equals("")) {
                    String a3 = new c().a(context);
                    if (a3 == null || a3.equals("")) {
                        this.c = true;
                        String str4 = this.d;
                        return str4;
                    }
                    this.d = a3;
                    return a3;
                }
                this.d = a2;
                return a2;
            }
        }
    }
}
