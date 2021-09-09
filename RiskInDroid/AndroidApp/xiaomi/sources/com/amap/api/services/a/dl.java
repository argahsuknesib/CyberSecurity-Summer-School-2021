package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class dl {

    /* renamed from: a  reason: collision with root package name */
    static WeakReference<dj> f3402a;

    public static void a(final Context context) {
        cl.c().submit(new Runnable() {
            /* class com.amap.api.services.a.dl.AnonymousClass1 */

            public final void run() {
                synchronized (dl.class) {
                    dj a2 = dp.a(dl.f3402a);
                    dp.a(context, a2, cj.j, 50, 102400, "10");
                    if (a2.g == null) {
                        String b = dl.c(context);
                        a2.g = new dt(new ds(context, new dx(), new cb(new cf(new cd())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", bp.b(context), bp.c(context), b));
                    }
                    a2.h = 14400000;
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "eKey";
                    }
                    if (a2.f == null) {
                        a2.f = new eb(context, a2.h, a2.i, new dy(5, a2.f3401a, new ed(context, false)));
                    }
                    dk.a(a2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static String c(Context context) {
        String u = bt.u(context);
        if (!TextUtils.isEmpty(u)) {
            return u;
        }
        String h = bt.h(context);
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        String m = bt.m(context);
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        return bt.b(context);
    }
}
