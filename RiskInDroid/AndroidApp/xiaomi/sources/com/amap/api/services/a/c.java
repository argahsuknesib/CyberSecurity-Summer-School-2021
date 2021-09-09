package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f3360a;
    private final Context b;
    private final String c = i.a("amap_device_adiu");
    private String d;

    public c(Context context) {
        this.b = context.getApplicationContext();
    }

    public static c a(Context context) {
        if (f3360a == null) {
            synchronized (c.class) {
                if (f3360a == null) {
                    f3360a = new c(context);
                }
            }
        }
        return f3360a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0086, code lost:
        return true;
     */
    public synchronized boolean a() {
        if (TextUtils.isEmpty(this.d)) {
            if (TextUtils.isEmpty(g.a())) {
                d.a(this.b).a(this.c);
                List<String> a2 = d.a(this.b).a();
                if (a2 != null && a2.size() > 0) {
                    String str = a2.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        this.d = str;
                        g.a(this.d);
                        String str2 = "";
                        if (a2.size() > 1) {
                            String str3 = a2.get(1);
                            if (!TextUtils.isEmpty(str3)) {
                                str2 = str3;
                            }
                        }
                        if (a2.size() > 2) {
                            String str4 = a2.get(2);
                            if (!TextUtils.isEmpty(str4)) {
                                str2 = ":".concat(String.valueOf(str4));
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            g.b(str2);
                        }
                    }
                }
            }
        }
    }

    public String b() {
        return g.a();
    }

    public void a(String str) {
        d.a(this.b).a(this.c);
        d.a(this.b).b(str);
    }
}
