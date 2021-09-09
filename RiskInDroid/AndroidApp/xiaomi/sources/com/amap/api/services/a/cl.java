package com.amap.api.services.a;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class cl extends ci implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> g;
    private static final ThreadFactory h = new ThreadFactory() {
        /* class com.amap.api.services.a.cl.AnonymousClass2 */

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f3369a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f3369a.getAndIncrement());
        }
    };
    /* access modifiers changed from: private */
    public Context d;
    private List<a> i;

    public interface a {
        void a(Thread thread, Throwable th);
    }

    public static synchronized cl a(Context context, by byVar) throws bo {
        synchronized (cl.class) {
            if (byVar != null) {
                try {
                    if (byVar.a() == null || "".equals(byVar.a())) {
                        throw new bo("sdk name is invalid");
                    }
                    new cn().a(context);
                    if (!f.add(Integer.valueOf(byVar.hashCode()))) {
                        cl clVar = (cl) ci.f3364a;
                        return clVar;
                    }
                    if (ci.f3364a == null) {
                        ci.f3364a = new cl(context, byVar);
                    } else {
                        ci.f3364a.c = false;
                    }
                    ci.f3364a.a(context, byVar, ci.f3364a.c);
                    cl clVar2 = (cl) ci.f3364a;
                    return clVar2;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new bo("sdk info is null");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(by byVar, String str, String str2) {
        cm.b(byVar, this.d, str2, str);
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th, int i2, String str, String str2) {
        cm.a(this.d, th, i2, str, str2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        cj.b(this.d);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th);
        if (th != null) {
            a(th, 0, null, null);
            if (this.b != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.b);
                } catch (Throwable unused) {
                }
                this.b.uncaughtException(thread, th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(final Context context, final by byVar, final boolean z) {
        try {
            ExecutorService c = c();
            if (c == null) {
                return;
            }
            if (!c.isShutdown()) {
                c.submit(new Runnable() {
                    /* class com.amap.api.services.a.cl.AnonymousClass1 */

                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new cu(context, true).a(byVar);
                            }
                            if (z) {
                                cm.a(cl.this.d);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private cl(Context context, by byVar) {
        this.d = context;
        e();
    }

    private void e() {
        try {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            String obj = this.b.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            this.c = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            cj.b(g.get());
        } else if (ci.f3364a != null) {
            ci.f3364a.a();
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            if (ci.f3364a != null) {
                ci.f3364a.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(by byVar, String str, String str2, String str3, String str4) {
        try {
            if (ci.f3364a != null) {
                ci.f3364a.a(byVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",code:" + str4, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(by byVar, String str, String str2) {
        try {
            if (ci.f3364a != null) {
                ci.f3364a.a(byVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(by byVar, String str, bo boVar) {
        if (boVar != null) {
            a(byVar, str, boVar.c(), boVar.d(), boVar.b());
        }
    }

    public static synchronized ExecutorService c() {
        ExecutorService executorService;
        synchronized (cl.class) {
            try {
                if (e == null || e.isShutdown()) {
                    e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), h);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = e;
        }
        return executorService;
    }

    public static synchronized cl d() {
        cl clVar;
        synchronized (cl.class) {
            clVar = (cl) ci.f3364a;
        }
        return clVar;
    }

    private void a(Thread thread, Throwable th) {
        int i2 = 0;
        while (i2 < this.i.size() && i2 < 10) {
            try {
                a aVar = this.i.get(i2);
                if (aVar != null) {
                    aVar.a(thread, th);
                }
                i2++;
            } catch (Throwable unused) {
                return;
            }
        }
    }
}
