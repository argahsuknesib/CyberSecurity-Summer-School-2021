package _m_j;

import _m_j.jqs;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import ss.ss.ss.a;
import ss.ss.ss.g;
import ss.u;

public final class jqu implements Closeable {
    static final /* synthetic */ boolean O0000OoO = (!jqu.class.desiredAssertionStatus());
    /* access modifiers changed from: private */
    public static final ExecutorService O0000Ooo = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), jqp.O000000o("OkHttp FramedConnection"));

    /* renamed from: O000000o  reason: collision with root package name */
    public final u f2065O000000o;
    final boolean O00000Oo;
    long O00000o;
    long O00000o0;
    public jrd O00000oO;
    final jrd O00000oo;
    final jrf O0000O0o;
    final Socket O0000OOo;
    final O00000o0 O0000Oo;
    public final jqt O0000Oo0;
    /* access modifiers changed from: private */
    public int O0000o;
    /* access modifiers changed from: private */
    public final Map<Integer, jqv> O0000o0;
    /* access modifiers changed from: private */
    public final O00000Oo O0000o00;
    /* access modifiers changed from: private */
    public final String O0000o0O;
    /* access modifiers changed from: private */
    public int O0000o0o;
    private long O0000oO;
    /* access modifiers changed from: private */
    public boolean O0000oO0;
    private final ExecutorService O0000oOO;
    private Map<Integer, jrb> O0000oOo;
    private int O0000oo;
    /* access modifiers changed from: private */
    public final jrc O0000oo0;
    /* access modifiers changed from: private */
    public boolean O0000ooO;
    /* access modifiers changed from: private */
    public final Set<Integer> O0000ooo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public Socket f2066O000000o;
        public String O00000Oo;
        public iqm O00000o;
        public iqn O00000o0;
        public O00000Oo O00000oO = O00000Oo.O0000Ooo;
        public u O00000oo = u.SPDY_3;
        jrc O0000O0o = jrc.f2086O000000o;
        boolean O0000OOo = true;
    }

    public static abstract class O00000Oo {
        public static final O00000Oo O0000Ooo = new O00000Oo() {
            /* class _m_j.jqu.O00000Oo.AnonymousClass1 */

            public final void O000000o(jqv jqv) throws IOException {
                jqv.O000000o(a.REFUSED_STREAM);
            }
        };

        public void O000000o(jqu jqu) {
        }

        public abstract void O000000o(jqv jqv) throws IOException;
    }

    public /* synthetic */ jqu(O000000o o000000o, byte b) throws IOException {
        this(o000000o);
    }

    private void O000000o(a aVar) throws IOException {
        synchronized (this.O0000Oo0) {
            synchronized (this) {
                if (!this.O0000oO0) {
                    this.O0000oO0 = true;
                    int i = this.O0000o0o;
                    this.O0000Oo0.O000000o(i, aVar, jqp.f2062O000000o);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(a aVar, a aVar2) throws IOException {
        int i;
        jqv[] jqvArr;
        if (O0000OoO || !Thread.holdsLock(this)) {
            jrb[] jrbArr = null;
            try {
                O000000o(aVar);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            synchronized (this) {
                if (!this.O0000o0.isEmpty()) {
                    jqvArr = (jqv[]) this.O0000o0.values().toArray(new jqv[this.O0000o0.size()]);
                    this.O0000o0.clear();
                    O000000o(false);
                } else {
                    jqvArr = null;
                }
                if (this.O0000oOo != null) {
                    this.O0000oOo = null;
                    jrbArr = (jrb[]) this.O0000oOo.values().toArray(new jrb[this.O0000oOo.size()]);
                }
            }
            if (jqvArr != null) {
                IOException iOException = e;
                for (jqv O000000o2 : jqvArr) {
                    try {
                        O000000o2.O000000o(aVar2);
                    } catch (IOException e2) {
                        if (iOException != null) {
                            iOException = e2;
                        }
                    }
                }
                e = iOException;
            }
            if (jrbArr != null) {
                for (jrb O000000o3 : jrbArr) {
                    O000000o3.O000000o();
                }
            }
            try {
                this.O0000Oo0.close();
            } catch (IOException e3) {
                if (e == null) {
                    e = e3;
                }
            }
            try {
                this.O0000OOo.close();
            } catch (IOException e4) {
                e = e4;
            }
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    private synchronized void O000000o(boolean z) {
        long j;
        if (z) {
            try {
                j = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            j = Long.MAX_VALUE;
        }
        this.O0000oO = j;
    }

    /* access modifiers changed from: private */
    public synchronized jrb O00000o0(int i) {
        if (this.O0000oOo == null) {
            return null;
        }
        return this.O0000oOo.remove(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public final synchronized jqv O000000o(int i) {
        return this.O0000o0.get(Integer.valueOf(i));
    }

    public final jqv O000000o(List<jqw> list, boolean z, boolean z2) throws IOException {
        int i;
        jqv jqv;
        boolean z3 = !z;
        synchronized (this.O0000Oo0) {
            synchronized (this) {
                if (!this.O0000oO0) {
                    i = this.O0000o;
                    this.O0000o += 2;
                    jqv = new jqv(i, this, z3, false, list);
                    if (jqv.O000000o()) {
                        this.O0000o0.put(Integer.valueOf(i), jqv);
                        O000000o(false);
                    }
                } else {
                    throw new IOException("shutdown");
                }
            }
            this.O0000Oo0.O000000o(z3, false, i, 0, list);
        }
        if (!z) {
            this.O0000Oo0.O00000Oo();
        }
        return jqv;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        O0000Ooo.execute(new jpp("OkHttp Window Update %s stream %d", new Object[]{this.O0000o0O, Integer.valueOf(i)}) {
            /* class _m_j.jqu.AnonymousClass2 */

            public final void O000000o() {
                try {
                    jqu.this.O0000Oo0.O000000o(i2, j2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, a aVar) {
        final int i2 = i;
        final a aVar2 = aVar;
        O0000Ooo.submit(new jpp("OkHttp %s stream %d", new Object[]{this.O0000o0O, Integer.valueOf(i)}) {
            /* class _m_j.jqu.AnonymousClass1 */

            public final void O000000o() {
                try {
                    jqu.this.O00000Oo(i2, aVar2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.O00000o), r8.O0000Oo0.O00000o0());
        r6 = (long) r3;
        r8.O00000o -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    public final void O000000o(int i, boolean z, iql iql, long j) throws IOException {
        int min;
        long j2;
        if (j == 0) {
            this.O0000Oo0.O000000o(z, i, iql, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    if (this.O00000o > 0) {
                        break;
                    } else if (this.O0000o0.containsKey(Integer.valueOf(i))) {
                        wait();
                    } else {
                        throw new IOException("stream closed");
                    }
                }
            }
            j -= j2;
            this.O0000Oo0.O000000o(z && j == 0, i, iql, min);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized jqv O00000Oo(int i) {
        jqv remove;
        remove = this.O0000o0.remove(Integer.valueOf(i));
        if (remove != null && this.O0000o0.isEmpty()) {
            O000000o(true);
        }
        notifyAll();
        return remove;
    }

    public final void O00000Oo() throws IOException {
        this.O0000Oo0.O00000Oo();
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(int i, a aVar) throws IOException {
        this.O0000Oo0.O000000o(i, aVar);
    }

    public final void close() throws IOException {
        O000000o(a.NO_ERROR, a.CANCEL);
    }

    class O00000o0 extends jpp implements jqs.O000000o {
        final jqs O00000Oo;

        private O00000o0(jqs jqs) {
            super("OkHttp %s", jqu.this.O0000o0O);
            this.O00000Oo = jqs;
        }

        /* synthetic */ O00000o0(jqu jqu, jqs jqs, byte b) {
            this(jqs);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0 = ss.ss.ss.a.b;
            r1 = ss.ss.ss.a.b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2 = r4.O00000o0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            _m_j.jqu.O000000o(r4.O00000o0, r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
            _m_j.jqp.O000000o(r4.O00000Oo);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0028 */
        public final void O000000o() {
            a aVar = a.INTERNAL_ERROR;
            a aVar2 = a.INTERNAL_ERROR;
            if (!jqu.this.O00000Oo) {
                this.O00000Oo.O000000o();
            }
            do {
            } while (this.O00000Oo.O000000o(this));
            aVar = a.NO_ERROR;
            a aVar3 = a.CANCEL;
            try {
                jqu jqu = jqu.this;
                jqu.O000000o(aVar, aVar3);
            } catch (IOException unused) {
            }
            jqp.O000000o(this.O00000Oo);
        }

        public final void O000000o(int i, long j) {
            if (i == 0) {
                synchronized (jqu.this) {
                    jqu.this.O00000o += j;
                    jqu.this.notifyAll();
                }
                return;
            }
            jqv O000000o2 = jqu.this.O000000o(i);
            if (O000000o2 != null) {
                synchronized (O000000o2) {
                    O000000o2.O000000o(j);
                }
            }
        }

        public final void O000000o(int i, List<jqw> list) {
            jqu.O000000o(jqu.this, i, list);
        }

        public final void O000000o(int i, a aVar) {
            if (jqu.O000000o(jqu.this, i)) {
                jqu.O000000o(jqu.this, i, aVar);
                return;
            }
            jqv O00000Oo2 = jqu.this.O00000Oo(i);
            if (O00000Oo2 != null) {
                O00000Oo2.O00000o0(aVar);
            }
        }

        public final void O000000o(boolean z, int i, iqn iqn, int i2) throws IOException {
            if (jqu.O000000o(jqu.this, i)) {
                jqu.O000000o(jqu.this, i, iqn, i2, z);
                return;
            }
            jqv O000000o2 = jqu.this.O000000o(i);
            if (O000000o2 == null) {
                jqu.this.O000000o(i, a.INVALID_STREAM);
                iqn.O00000oo((long) i2);
            } else if (jqv.O0000Oo || !Thread.holdsLock(O000000o2)) {
                O000000o2.O00000oo.O000000o(iqn, (long) i2);
                if (z) {
                    O000000o2.O00000oO();
                }
            } else {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
            if (r15.b() == false) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
            r1.O00000Oo(ss.ss.ss.a.b);
            r10.O00000o0.O00000Oo(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x009e, code lost:
            if (_m_j.jqv.O0000Oo != false) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a4, code lost:
            if (java.lang.Thread.holdsLock(r1) != false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ac, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ad, code lost:
            r11 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ae, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b1, code lost:
            if (r1.O00000oO != null) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b7, code lost:
            if (r15.c() == false) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b9, code lost:
            r11 = ss.ss.ss.a.b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bc, code lost:
            r1.O00000oO = r14;
            r2 = r1.O000000o();
            r1.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ca, code lost:
            if (r15.d() == false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cc, code lost:
            r11 = ss.ss.ss.a.e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00cf, code lost:
            r13 = new java.util.ArrayList();
            r13.addAll(r1.O00000oO);
            r13.addAll(r14);
            r1.O00000oO = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00de, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00df, code lost:
            if (r11 == null) goto L_0x00e5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e1, code lost:
            r1.O00000Oo(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e5, code lost:
            if (r2 != false) goto L_0x00ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e7, code lost:
            r1.O00000o.O00000Oo(r1.O00000o0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ee, code lost:
            if (r12 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f0, code lost:
            r1.O00000oO();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        public final void O000000o(boolean z, boolean z2, int i, List<jqw> list, g gVar) {
            if (jqu.O000000o(jqu.this, i)) {
                jqu.O000000o(jqu.this, i, list, z2);
                return;
            }
            synchronized (jqu.this) {
                if (!jqu.this.O0000oO0) {
                    jqv O000000o2 = jqu.this.O000000o(i);
                    boolean z3 = true;
                    if (O000000o2 == null) {
                        if (gVar.a()) {
                            jqu.this.O000000o(i, a.INVALID_STREAM);
                        } else if (i > jqu.this.O0000o0o) {
                            if (i % 2 != jqu.this.O0000o % 2) {
                                final jqv jqv = new jqv(i, jqu.this, z, z2, list);
                                int unused = jqu.this.O0000o0o = i;
                                jqu.this.O0000o0.put(Integer.valueOf(i), jqv);
                                jqu.O0000Ooo.execute(new jpp("OkHttp %s stream %d", new Object[]{jqu.this.O0000o0O, Integer.valueOf(i)}) {
                                    /* class _m_j.jqu.O00000o0.AnonymousClass1 */

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
                                     arg types: [java.util.logging.Level, java.lang.String, java.io.IOException]
                                     candidates:
                                      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
                                      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
                                      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
                                      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
                                    public final void O000000o() {
                                        try {
                                            jqu.this.O0000o00.O000000o(jqv);
                                        } catch (IOException e) {
                                            Logger logger = jpn.f2027O000000o;
                                            Level level = Level.INFO;
                                            logger.log(level, "FramedConnection.Listener failure for " + jqu.this.O0000o0O, (Throwable) e);
                                            try {
                                                jqv.O000000o(a.PROTOCOL_ERROR);
                                            } catch (IOException unused) {
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }

        /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        public final void O000000o(boolean z, final jrd jrd) {
            int i;
            jqv[] jqvArr;
            long j;
            synchronized (jqu.this) {
                int O00000Oo2 = jqu.this.O00000oo.O00000Oo();
                if (z) {
                    jrd jrd2 = jqu.this.O00000oo;
                    jrd2.O00000o0 = 0;
                    jrd2.O00000Oo = 0;
                    jrd2.f2087O000000o = 0;
                    Arrays.fill(jrd2.O00000o, 0);
                }
                jrd jrd3 = jqu.this.O00000oo;
                for (int i2 = 0; i2 < 10; i2++) {
                    if (jrd.O000000o(i2)) {
                        jrd3.O000000o(i2, jrd.O00000Oo(i2), jrd.O00000o[i2]);
                    }
                }
                if (jqu.this.f2065O000000o == u.HTTP_2) {
                    jqu.O0000Ooo.execute(new jpp("OkHttp %s ACK Settings", new Object[]{jqu.this.O0000o0O}) {
                        /* class _m_j.jqu.O00000o0.AnonymousClass3 */

                        public final void O000000o() {
                            try {
                                jqu.this.O0000Oo0.O000000o(jrd);
                            } catch (IOException unused) {
                            }
                        }
                    });
                }
                int O00000Oo3 = jqu.this.O00000oo.O00000Oo();
                jqvArr = null;
                if (O00000Oo3 == -1 || O00000Oo3 == O00000Oo2) {
                    j = 0;
                } else {
                    j = (long) (O00000Oo3 - O00000Oo2);
                    if (!jqu.this.O0000ooO) {
                        jqu jqu = jqu.this;
                        jqu.O00000o += j;
                        if (j > 0) {
                            jqu.notifyAll();
                        }
                        boolean unused = jqu.this.O0000ooO = true;
                    }
                    if (!jqu.this.O0000o0.isEmpty()) {
                        jqvArr = jqu.this.O0000o0.values().toArray(new jqv[jqu.this.O0000o0.size()]);
                    }
                }
                jqu.O0000Ooo.execute(new jpp("OkHttp %s settings", jqu.this.O0000o0O) {
                    /* class _m_j.jqu.O00000o0.AnonymousClass2 */

                    public final void O000000o() {
                        jqu.this.O0000o00.O000000o(jqu.this);
                    }
                });
            }
            if (jqvArr != null && j != 0) {
                for (jqv jqv : jqvArr) {
                    synchronized (jqv) {
                        jqv.O000000o(j);
                    }
                }
            }
        }

        public final void O000000o(boolean z, int i, int i2) {
            if (z) {
                jrb O00000o02 = jqu.this.O00000o0(i);
                if (O00000o02 == null) {
                    return;
                }
                if (O00000o02.O00000o0 != -1 || O00000o02.O00000Oo == -1) {
                    throw new IllegalStateException();
                }
                O00000o02.O00000o0 = System.nanoTime();
                O00000o02.f2085O000000o.countDown();
                return;
            }
            jqu.O0000Ooo.execute(new jpp("OkHttp %s ping %08x%08x", new Object[]{jqu.this.O0000o0O, Integer.valueOf(i), Integer.valueOf(i2)}, true, i, i2, null) {
                /* class _m_j.jqu.AnonymousClass3 */
                final /* synthetic */ boolean O00000Oo = true;
                final /* synthetic */ int O00000o;
                final /* synthetic */ int O00000o0;
                final /* synthetic */ jrb O00000oO;

                {
                    this.O00000o0 = r5;
                    this.O00000o = r6;
                    this.O00000oO = null;
                }

                public final void O000000o() {
                    try {
                        jqu.O000000o(jqu.this, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        public final void O000000o(int i) {
            jqv[] jqvArr;
            synchronized (jqu.this) {
                jqvArr = (jqv[]) jqu.this.O0000o0.values().toArray(new jqv[jqu.this.O0000o0.size()]);
                boolean unused = jqu.this.O0000oO0 = true;
            }
            for (jqv jqv : jqvArr) {
                if (jqv.O00000o0 > i && jqv.O00000Oo()) {
                    jqv.O00000o0(a.REFUSED_STREAM);
                    jqu.this.O00000Oo(jqv.O00000o0);
                }
            }
        }
    }

    private jqu(O000000o o000000o) throws IOException {
        this.O0000o0 = new HashMap();
        this.O0000oO = System.nanoTime();
        this.O00000o0 = 0;
        this.O00000oO = new jrd();
        this.O00000oo = new jrd();
        this.O0000ooO = false;
        this.O0000ooo = new LinkedHashSet();
        this.f2065O000000o = o000000o.O00000oo;
        this.O0000oo0 = o000000o.O0000O0o;
        this.O00000Oo = o000000o.O0000OOo;
        this.O0000o00 = o000000o.O00000oO;
        int i = 2;
        this.O0000o = o000000o.O0000OOo ? 1 : 2;
        if (o000000o.O0000OOo && this.f2065O000000o == u.HTTP_2) {
            this.O0000o += 2;
        }
        this.O0000oo = o000000o.O0000OOo ? 1 : i;
        if (o000000o.O0000OOo) {
            this.O00000oO.O000000o(7, 0, 16777216);
        }
        this.O0000o0O = o000000o.O00000Oo;
        if (this.f2065O000000o == u.HTTP_2) {
            this.O0000O0o = new jqy();
            this.O0000oOO = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), jqp.O000000o(String.format("OkHttp %s Push Observer", this.O0000o0O)));
            this.O00000oo.O000000o(7, 0, 65535);
            this.O00000oo.O000000o(5, 0, 16384);
        } else if (this.f2065O000000o == u.SPDY_3) {
            this.O0000O0o = new jre();
            this.O0000oOO = null;
        } else {
            throw new AssertionError(this.f2065O000000o);
        }
        this.O00000o = (long) this.O00000oo.O00000Oo();
        this.O0000OOo = o000000o.f2066O000000o;
        this.O0000Oo0 = this.O0000O0o.O000000o(o000000o.O00000o, this.O00000Oo);
        this.O0000Oo = new O00000o0(this, this.O0000O0o.O000000o(o000000o.O00000o0, this.O00000Oo), (byte) 0);
        new Thread(this.O0000Oo).start();
    }

    public final synchronized int O000000o() {
        jrd jrd = this.O00000oo;
        if ((jrd.f2087O000000o & 16) == 0) {
            return Integer.MAX_VALUE;
        }
        return jrd.O00000o[4];
    }

    static /* synthetic */ void O000000o(jqu jqu, boolean z, int i, int i2, jrb jrb) throws IOException {
        synchronized (jqu.O0000Oo0) {
            if (jrb != null) {
                if (jrb.O00000Oo == -1) {
                    jrb.O00000Oo = System.nanoTime();
                } else {
                    throw new IllegalStateException();
                }
            }
            jqu.O0000Oo0.O000000o(z, i, i2);
        }
    }

    static /* synthetic */ boolean O000000o(jqu jqu, int i) {
        return jqu.f2065O000000o == u.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    static /* synthetic */ void O000000o(jqu jqu, int i, iqn iqn, int i2, boolean z) throws IOException {
        final iql iql = new iql();
        long j = (long) i2;
        iqn.O000000o(j);
        iqn.O000000o(iql, j);
        if (iql.O00000Oo == j) {
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            jqu.O0000oOO.execute(new jpp("OkHttp %s Push Data[%s]", new Object[]{jqu.O0000o0O, Integer.valueOf(i)}) {
                /* class _m_j.jqu.AnonymousClass6 */

                public final void O000000o() {
                    try {
                        jqu.this.O0000oo0.O000000o(iql, i4);
                        jqu.this.O0000Oo0.O000000o(i3, a.CANCEL);
                        synchronized (jqu.this) {
                            jqu.this.O0000ooo.remove(Integer.valueOf(i3));
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(iql.O00000Oo + " != " + i2);
    }

    static /* synthetic */ void O000000o(jqu jqu, int i, List list, boolean z) {
        final int i2 = i;
        final List list2 = list;
        final boolean z2 = z;
        jqu.O0000oOO.execute(new jpp("OkHttp %s Push Headers[%s]", new Object[]{jqu.O0000o0O, Integer.valueOf(i)}) {
            /* class _m_j.jqu.AnonymousClass5 */

            public final void O000000o() {
                jrc unused = jqu.this.O0000oo0;
                try {
                    jqu.this.O0000Oo0.O000000o(i2, a.CANCEL);
                    synchronized (jqu.this) {
                        jqu.this.O0000ooo.remove(Integer.valueOf(i2));
                    }
                } catch (IOException unused2) {
                }
            }
        });
    }

    static /* synthetic */ void O000000o(jqu jqu, int i, a aVar) {
        final int i2 = i;
        final a aVar2 = aVar;
        jqu.O0000oOO.execute(new jpp("OkHttp %s Push Reset[%s]", new Object[]{jqu.O0000o0O, Integer.valueOf(i)}) {
            /* class _m_j.jqu.AnonymousClass7 */

            public final void O000000o() {
                jrc unused = jqu.this.O0000oo0;
                synchronized (jqu.this) {
                    jqu.this.O0000ooo.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    static /* synthetic */ void O000000o(jqu jqu, int i, List list) {
        synchronized (jqu) {
            if (jqu.O0000ooo.contains(Integer.valueOf(i))) {
                jqu.O000000o(i, a.PROTOCOL_ERROR);
                return;
            }
            jqu.O0000ooo.add(Integer.valueOf(i));
            final int i2 = i;
            final List list2 = list;
            jqu.O0000oOO.execute(new jpp("OkHttp %s Push Request[%s]", new Object[]{jqu.O0000o0O, Integer.valueOf(i)}) {
                /* class _m_j.jqu.AnonymousClass4 */

                public final void O000000o() {
                    jrc unused = jqu.this.O0000oo0;
                    try {
                        jqu.this.O0000Oo0.O000000o(i2, a.CANCEL);
                        synchronized (jqu.this) {
                            jqu.this.O0000ooo.remove(Integer.valueOf(i2));
                        }
                    } catch (IOException unused2) {
                    }
                }
            });
        }
    }
}
