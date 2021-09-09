package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class dm {

    /* renamed from: a  reason: collision with root package name */
    static int f3404a = 1000;
    static boolean b = false;
    static int c = 20;
    /* access modifiers changed from: private */
    public static WeakReference<dj> d = null;
    /* access modifiers changed from: private */
    public static int e = 10;

    public static void a(final Context context) {
        cl.c().submit(new Runnable() {
            /* class com.amap.api.services.a.dm.AnonymousClass1 */

            public final void run() {
                try {
                    dj a2 = dp.a(dm.d);
                    dp.a(context, a2, cj.i, dm.f3404a, 2097152, "6");
                    a2.h = 14400000;
                    if (a2.g == null) {
                        cb cbVar = new cb(new cd(new cf()));
                        a2.g = new dt(new ds(context, new dx(), cbVar, new String(cg.a(10)), bp.f(context), bt.u(context), bt.m(context), bt.h(context), bt.a(), Build.MANUFACTURER, Build.DEVICE, bt.w(context), bp.c(context), Build.MODEL, bp.d(context), bp.b(context)));
                    }
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "fKey";
                    }
                    a2.f = new eb(context, a2.h, a2.i, new dz(context, dm.b, dm.e * 1024, dm.c * 1024));
                    dk.a(a2);
                } catch (Throwable th) {
                    cl.c(th, "ofm", "uold");
                }
            }
        });
    }
}
