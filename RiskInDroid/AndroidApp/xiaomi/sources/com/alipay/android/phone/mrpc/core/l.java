package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l implements ab {
    private static l b;
    private static final ThreadFactory i = new n();

    /* renamed from: a  reason: collision with root package name */
    Context f3141a;
    private ThreadPoolExecutor c = new ThreadPoolExecutor(10, 11, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
    private b d = b.a("android");
    private long e;
    private long f;
    private long g;
    private int h;

    private l(Context context) {
        this.f3141a = context;
        try {
            this.c.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f3141a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        l lVar = b;
        return lVar != null ? lVar : b(context);
    }

    private static final synchronized l b(Context context) {
        synchronized (l.class) {
            if (b != null) {
                l lVar = b;
                return lVar;
            }
            l lVar2 = new l(context);
            b = lVar2;
            return lVar2;
        }
    }

    public final b a() {
        return this.d;
    }

    public final Future<u> a(t tVar) {
        if (s.a(this.f3141a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.c.getActiveCount());
            objArr[1] = Long.valueOf(this.c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.c.getTaskCount());
            long j = this.g;
            long j2 = 0;
            objArr[3] = Long.valueOf(j == 0 ? 0 : ((this.e * 1000) / j) >> 10);
            int i2 = this.h;
            if (i2 != 0) {
                j2 = this.f / ((long) i2);
            }
            objArr[4] = Long.valueOf(j2);
            objArr[5] = Long.valueOf(this.e);
            objArr[6] = Long.valueOf(this.f);
            objArr[7] = Long.valueOf(this.g);
            objArr[8] = Integer.valueOf(this.h);
            String.format(str, objArr);
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.c.execute(mVar);
        return mVar;
    }

    public final void a(long j) {
        this.e += j;
    }

    public final void b(long j) {
        this.f += j;
        this.h++;
    }

    public final void c(long j) {
        this.g += j;
    }
}
