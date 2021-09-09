package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;

/* renamed from: com.amap.api.services.a.do  reason: invalid class name */
public class Cdo {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<dj> f3407a;

    public static synchronized void a(final dn dnVar, final Context context) {
        synchronized (Cdo.class) {
            cl.c().submit(new Runnable() {
                /* class com.amap.api.services.a.Cdo.AnonymousClass1 */

                public final void run() {
                    try {
                        synchronized (Cdo.class) {
                            Cdo.b(context, dnVar.a());
                        }
                    } catch (Throwable th) {
                        cl.c(th, "stm", "as");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, byte[] bArr) throws IOException {
        dj a2 = dp.a(f3407a);
        dp.a(context, a2, cj.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new ce();
        }
        Random random = new Random();
        try {
            dk.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            cl.c(th, "stm", "wts");
        }
    }

    public static void a(final Context context) {
        cl.c().submit(new Runnable() {
            /* class com.amap.api.services.a.Cdo.AnonymousClass2 */

            public final void run() {
                try {
                    dj a2 = dp.a(Cdo.f3407a);
                    dp.a(context, a2, cj.h, 1000, 307200, "2");
                    if (a2.g == null) {
                        a2.g = new dq(new du(context, new dr(new dv(new dx()))));
                    }
                    a2.h = 3600000;
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "cKey";
                    }
                    if (a2.f == null) {
                        a2.f = new eb(context, a2.h, a2.i, new dy(30, a2.f3401a, new ed(context, false)));
                    }
                    dk.a(a2);
                } catch (Throwable th) {
                    cl.c(th, "stm", "usd");
                }
            }
        });
    }
}
