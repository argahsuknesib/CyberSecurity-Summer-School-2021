package com.amap.api.services.a;

import com.amap.api.services.a.ef;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ee {

    /* renamed from: a  reason: collision with root package name */
    private static ee f3416a;
    private ExecutorService b;
    private ConcurrentHashMap<ef, Future<?>> c = new ConcurrentHashMap<>();
    private ef.a d = new ef.a() {
        /* class com.amap.api.services.a.ee.AnonymousClass1 */

        public void a(ef efVar) {
        }

        public void b(ef efVar) {
            ee.this.a(efVar, false);
        }
    };

    public static ee a(int i) {
        return new ee(i);
    }

    private ee(int i) {
        try {
            this.b = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256));
        } catch (Throwable th) {
            cl.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(ef efVar, boolean z) {
        try {
            Future remove = this.c.remove(efVar);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            cl.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
