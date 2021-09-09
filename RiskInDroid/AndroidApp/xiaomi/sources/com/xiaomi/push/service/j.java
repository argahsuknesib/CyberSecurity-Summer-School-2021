package com.xiaomi.push.service;

import _m_j.duv;
import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static long f6561a;
    private static long b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f329a;

    /* renamed from: a  reason: collision with other field name */
    private final c f330a;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c f6562a;

        a(c cVar) {
            this.f6562a = cVar;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.push.service.j.c.a(com.xiaomi.push.service.j$c, boolean):boolean
         arg types: [com.xiaomi.push.service.j$c, int]
         candidates:
          com.xiaomi.push.service.j.c.a(com.xiaomi.push.service.j$c, com.xiaomi.push.service.j$d):void
          com.xiaomi.push.service.j.c.a(com.xiaomi.push.service.j$c, boolean):boolean */
        /* access modifiers changed from: protected */
        public final void finalize() {
            try {
                synchronized (this.f6562a) {
                    boolean unused = this.f6562a.c = true;
                    this.f6562a.notify();
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }
    }

    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected int f6563a;

        public b(int i) {
            this.f6563a = i;
        }
    }

    static final class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private volatile long f6564a = 0;

        /* renamed from: a  reason: collision with other field name */
        private a f331a = new a();

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f332a = false;
        private long b = 50;

        /* renamed from: b  reason: collision with other field name */
        private boolean f333b;
        /* access modifiers changed from: private */
        public boolean c;

        static final class a {

            /* renamed from: a  reason: collision with root package name */
            private int f6565a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f334a;
            private int b;
            private int c;

            private a() {
                this.f6565a = 256;
                this.f334a = new d[this.f6565a];
                this.b = 0;
                this.c = 0;
            }

            /* access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f334a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (this.f334a[i].f335a < this.f334a[i2].f335a) {
                    d[] dVarArr = this.f334a;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 < i3 && i3 > 0) {
                        int i4 = i2 + 1;
                        if (i4 < i3 && this.f334a[i4].f335a < this.f334a[i2].f335a) {
                            i2 = i4;
                        }
                        if (this.f334a[i].f335a >= this.f334a[i2].f335a) {
                            d[] dVarArr = this.f334a;
                            d dVar = dVarArr[i];
                            dVarArr[i] = dVarArr[i2];
                            dVarArr[i2] = dVar;
                            int i5 = i2;
                            i2 = (i2 * 2) + 1;
                            i = i5;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public final d a() {
                return this.f334a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public final void m216a() {
                this.f334a = new d[this.f6565a];
                this.b = 0;
            }

            public final void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f334a[i2].f6566a == i) {
                        this.f334a[i2].a();
                    }
                }
                b();
            }

            public final void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f334a[i2].f336a == bVar) {
                        this.f334a[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public final void m217a(d dVar) {
                d[] dVarArr = this.f334a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[(i * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f334a = dVarArr2;
                }
                d[] dVarArr3 = this.f334a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public final boolean m218a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public final boolean m219a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f334a[i2].f6566a == i) {
                        return true;
                    }
                }
                return false;
            }

            public final void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f334a[i].f338a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public final void b(int i) {
                int i2;
                if (i >= 0 && i < (i2 = this.b)) {
                    d[] dVarArr = this.f334a;
                    int i3 = i2 - 1;
                    this.b = i3;
                    dVarArr[i] = dVarArr[i3];
                    dVarArr[this.b] = null;
                    c(i);
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* access modifiers changed from: private */
        public void a(d dVar) {
            this.f331a.m217a(dVar);
            notify();
        }

        public final synchronized void a() {
            this.f333b = true;
            this.f331a.m216a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m215a() {
            return this.f332a && SystemClock.uptimeMillis() - this.f6564a > 600000;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|(2:8|(3:83|10|11)(2:12|13))(2:17|26)|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r10.f6564a = android.os.SystemClock.uptimeMillis();
            r10.f332a = true;
            r2.f336a.run();
            r10.f332a = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a6, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a7, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            r10.f333b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ab, code lost:
            throw r1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0018 */
        public final void run() {
            while (true) {
                synchronized (this) {
                    if (!this.f333b) {
                        if (!this.f331a.m218a()) {
                            long a2 = j.a();
                            d a3 = this.f331a.a();
                            synchronized (a3.f337a) {
                                if (a3.f338a) {
                                    this.f331a.b(0);
                                } else {
                                    long j = a3.f335a - a2;
                                    if (j > 0) {
                                        if (j > this.b) {
                                            j = this.b;
                                        }
                                        this.b += 50;
                                        if (this.b > 500) {
                                            this.b = 500;
                                        }
                                        wait(j);
                                    } else {
                                        this.b = 50;
                                        synchronized (a3.f337a) {
                                            int a4 = this.f331a.a().f335a != a3.f335a ? this.f331a.a(a3) : 0;
                                            if (a3.f338a) {
                                                this.f331a.b(this.f331a.a(a3));
                                            } else {
                                                a3.a(a3.f335a);
                                                this.f331a.b(a4);
                                                a3.f335a = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (!this.c) {
                            wait();
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            while (true) {
            }
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        int f6566a;

        /* renamed from: a  reason: collision with other field name */
        long f335a;

        /* renamed from: a  reason: collision with other field name */
        b f336a;

        /* renamed from: a  reason: collision with other field name */
        final Object f337a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f338a;
        private long b;

        d() {
        }

        /* access modifiers changed from: package-private */
        public void a(long j) {
            synchronized (this.f337a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f337a) {
                z = !this.f338a && this.f335a > 0;
                this.f338a = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        f6561a = j;
        b = j;
    }

    public j() {
        this(false);
    }

    public j(String str) {
        this(str, false);
    }

    public j(String str, boolean z) {
        if (str != null) {
            this.f330a = new c(str, z);
            this.f329a = new a(this.f330a);
            return;
        }
        throw new NullPointerException("name == null");
    }

    public j(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (j.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > b) {
                f6561a += elapsedRealtime - b;
            }
            b = elapsedRealtime;
            j = f6561a;
        }
        return j;
    }

    private static synchronized long b() {
        long j;
        synchronized (j.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f330a) {
            if (!c.a(this.f330a)) {
                long a2 = j + a();
                if (a2 >= 0) {
                    d dVar = new d();
                    dVar.f6566a = bVar.f6563a;
                    dVar.f336a = bVar;
                    dVar.f335a = a2;
                    this.f330a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: ".concat(String.valueOf(a2)));
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m211a() {
        duv.O000000o("quit. finalizer:" + this.f329a);
        this.f330a.a();
    }

    public void a(int i) {
        synchronized (this.f330a) {
            c.a(this.f330a).a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f330a) {
            c.a(this.f330a).a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (duv.O00000Oo() > 0 || Thread.currentThread() == this.f330a) {
            bVar.run();
        } else {
            duv.O00000o("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: ".concat(String.valueOf(j)));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m212a() {
        return this.f330a.m215a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m213a(int i) {
        boolean a2;
        synchronized (this.f330a) {
            a2 = c.a(this.f330a).m219a(i);
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m214b() {
        synchronized (this.f330a) {
            c.a(this.f330a).m216a();
        }
    }
}
