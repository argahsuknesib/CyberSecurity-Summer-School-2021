package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;
import ss.ss.ss.a;

public final class jqv {
    static final /* synthetic */ boolean O0000Oo = (!jqv.class.desiredAssertionStatus());

    /* renamed from: O000000o  reason: collision with root package name */
    long f2067O000000o = 0;
    long O00000Oo;
    /* access modifiers changed from: package-private */
    public final jqu O00000o;
    /* access modifiers changed from: package-private */
    public final int O00000o0;
    List<jqw> O00000oO;
    public final O00000Oo O00000oo;
    final O000000o O0000O0o;
    public final O00000o0 O0000OOo = new O00000o0();
    public final O00000o0 O0000Oo0 = new O00000o0();
    private final List<jqw> O0000OoO;
    /* access modifiers changed from: private */
    public a O0000Ooo = null;

    class O00000o0 extends iqj {
        O00000o0() {
        }

        public final IOException O00000Oo(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public final void O00000o0() {
            jqv.this.O00000Oo(a.CANCEL);
        }

        public final void O0000O0o() throws IOException {
            if (O00000Oo()) {
                throw O00000Oo(null);
            }
        }
    }

    jqv(int i, jqu jqu, boolean z, boolean z2, List<jqw> list) {
        if (jqu == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.O00000o0 = i;
            this.O00000o = jqu;
            this.O00000Oo = (long) jqu.O00000oo.O00000Oo();
            this.O00000oo = new O00000Oo(this, (long) jqu.O00000oO.O00000Oo(), (byte) 0);
            this.O0000O0o = new O000000o();
            boolean unused = this.O00000oo.O0000O0o = z2;
            boolean unused2 = this.O0000O0o.O00000oO = z;
            this.O0000OoO = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    private boolean O00000o(a aVar) {
        if (O0000Oo || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.O0000Ooo != null) {
                    return false;
                }
                if (this.O00000oo.O0000O0o && this.O0000O0o.O00000oO) {
                    return false;
                }
                this.O0000Ooo = aVar;
                notifyAll();
                this.O00000o.O00000Oo(this.O00000o0);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void O00000oo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(long j) {
        this.O00000Oo += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public final void O000000o(a aVar) throws IOException {
        if (O00000o(aVar)) {
            this.O00000o.O00000Oo(this.O00000o0, aVar);
        }
    }

    public final synchronized boolean O000000o() {
        if (this.O0000Ooo != null) {
            return false;
        }
        return (!this.O00000oo.O0000O0o && !this.O00000oo.O00000oo) || (!this.O0000O0o.O00000oO && !this.O0000O0o.O00000o) || this.O00000oO == null;
    }

    public final void O00000Oo(a aVar) {
        if (O00000o(aVar)) {
            this.O00000o.O000000o(this.O00000o0, aVar);
        }
    }

    public final boolean O00000Oo() {
        return this.O00000o.O00000Oo == ((this.O00000o0 & 1) == 1);
    }

    public final iqy O00000o() {
        synchronized (this) {
            if (this.O00000oO == null) {
                if (!O00000Oo()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.O0000O0o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r3.O0000OOo.O0000O0o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized List<jqw> O00000o0() throws IOException {
        this.O0000OOo.K_();
        while (this.O00000oO == null && this.O0000Ooo == null) {
            O00000oo();
        }
        this.O0000OOo.O0000O0o();
        if (this.O00000oO != null) {
        } else {
            throw new IOException("stream was reset: " + this.O0000Ooo);
        }
        return this.O00000oO;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O00000o0(a aVar) {
        if (this.O0000Ooo == null) {
            this.O0000Ooo = aVar;
            notifyAll();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqv.O00000Oo.O000000o(_m_j.jqv$O00000Oo, boolean):boolean
     arg types: [_m_j.jqv$O00000Oo, int]
     candidates:
      _m_j.jqv.O00000Oo.O000000o(_m_j.iql, long):long
      _m_j.jqv.O00000Oo.O000000o(_m_j.iqn, long):void
      _m_j.iqz.O000000o(_m_j.iql, long):long
      _m_j.jqv.O00000Oo.O000000o(_m_j.jqv$O00000Oo, boolean):boolean */
    /* access modifiers changed from: package-private */
    public final void O00000oO() {
        boolean O000000o2;
        if (O0000Oo || !Thread.holdsLock(this)) {
            synchronized (this) {
                boolean unused = this.O00000oo.O0000O0o = true;
                O000000o2 = O000000o();
                notifyAll();
            }
            if (!O000000o2) {
                this.O00000o.O00000Oo(this.O00000o0);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    final class O000000o implements iqy {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ boolean f2068O000000o = (!jqv.class.desiredAssertionStatus());
        /* access modifiers changed from: private */
        public boolean O00000o;
        private final iql O00000o0 = new iql();
        /* access modifiers changed from: private */
        public boolean O00000oO;

        O000000o() {
        }

        public final ira O000000o() {
            return jqv.this.O0000Oo0;
        }

        public final void a_(iql iql, long j) throws IOException {
            if (f2068O000000o || !Thread.holdsLock(jqv.this)) {
                this.O00000o0.a_(iql, j);
                while (this.O00000o0.O00000Oo >= 16384) {
                    O000000o(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: finally extract failed */
        private void O000000o(boolean z) throws IOException {
            long min;
            synchronized (jqv.this) {
                jqv.this.O0000Oo0.K_();
                while (jqv.this.O00000Oo <= 0 && !this.O00000oO && !this.O00000o && jqv.this.O0000Ooo == null) {
                    try {
                        jqv.this.O00000oo();
                    } catch (Throwable th) {
                        jqv.this.O0000Oo0.O0000O0o();
                        throw th;
                    }
                }
                jqv.this.O0000Oo0.O0000O0o();
                jqv.O0000OOo(jqv.this);
                min = Math.min(jqv.this.O00000Oo, this.O00000o0.O00000Oo);
                jqv.this.O00000Oo -= min;
            }
            jqv.this.O0000Oo0.K_();
            try {
                jqv.this.O00000o.O000000o(jqv.this.O00000o0, z && min == this.O00000o0.O00000Oo, this.O00000o0, min);
            } finally {
                jqv.this.O0000Oo0.O0000O0o();
            }
        }

        public final void flush() throws IOException {
            if (f2068O000000o || !Thread.holdsLock(jqv.this)) {
                synchronized (jqv.this) {
                    jqv.O0000OOo(jqv.this);
                }
                while (this.O00000o0.O00000Oo > 0) {
                    O000000o(false);
                    jqv.this.O00000o.O00000Oo();
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jqu.O000000o(int, boolean, _m_j.iql, long):void
         arg types: [int, int, ?[OBJECT, ARRAY], int]
         candidates:
          _m_j.jqu.O000000o(_m_j.jqu, int, java.util.List, boolean):void
          _m_j.jqu.O000000o(int, boolean, _m_j.iql, long):void */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.O00000Oo.O0000O0o.O00000oO != false) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
            if (r8.O00000o0.O00000Oo <= 0) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
            if (r8.O00000o0.O00000Oo <= 0) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
            O000000o(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
            _m_j.jqv.O000000o(r8.O00000Oo).O000000o(_m_j.jqv.O00000Oo(r8.O00000Oo), true, (_m_j.iql) null, 0L);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
            r2 = r8.O00000Oo;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.O00000o = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
            _m_j.jqv.O000000o(r8.O00000Oo).O00000Oo();
            _m_j.jqv.O00000oo(r8.O00000Oo);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
            return;
         */
        public final void close() throws IOException {
            if (f2068O000000o || !Thread.holdsLock(jqv.this)) {
                synchronized (jqv.this) {
                    if (this.O00000o) {
                    }
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    final class O00000Oo implements iqz {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ boolean f2069O000000o = (!jqv.class.desiredAssertionStatus());
        private final iql O00000o;
        private final iql O00000o0;
        private final long O00000oO;
        /* access modifiers changed from: private */
        public boolean O00000oo;
        /* access modifiers changed from: private */
        public boolean O0000O0o;

        private O00000Oo(long j) {
            this.O00000o0 = new iql();
            this.O00000o = new iql();
            this.O00000oO = j;
        }

        /* synthetic */ O00000Oo(jqv jqv, long j, byte b) {
            this(j);
        }

        public final ira O000000o() {
            return jqv.this.O0000OOo;
        }

        public final void close() throws IOException {
            synchronized (jqv.this) {
                this.O00000oo = true;
                this.O00000o.O0000o0o();
                jqv.this.notifyAll();
            }
            jqv.O00000oo(jqv.this);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
            r10 = _m_j.jqv.O000000o(r7.O00000Oo);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            _m_j.jqv.O000000o(r7.O00000Oo).O00000o0 += r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0093, code lost:
            if (_m_j.jqv.O000000o(r7.O00000Oo).O00000o0 < ((long) (_m_j.jqv.O000000o(r7.O00000Oo).O00000oO.O00000Oo() / 2))) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0095, code lost:
            _m_j.jqv.O000000o(r7.O00000Oo).O000000o(0, _m_j.jqv.O000000o(r7.O00000Oo).O00000o0);
            _m_j.jqv.O000000o(r7.O00000Oo).O00000o0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00af, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b0, code lost:
            return r8;
         */
        public final long O000000o(iql iql, long j) throws IOException {
            if (j >= 0) {
                synchronized (jqv.this) {
                    O00000Oo();
                    if (this.O00000oo) {
                        throw new IOException("stream closed");
                    } else if (jqv.this.O0000Ooo != null) {
                        throw new IOException("stream was reset: " + jqv.this.O0000Ooo);
                    } else if (this.O00000o.O00000Oo == 0) {
                        return -1;
                    } else {
                        long O000000o2 = this.O00000o.O000000o(iql, Math.min(j, this.O00000o.O00000Oo));
                        jqv.this.f2067O000000o += O000000o2;
                        if (jqv.this.f2067O000000o >= ((long) (jqv.this.O00000o.O00000oO.O00000Oo() / 2))) {
                            jqv.this.O00000o.O000000o(jqv.this.O00000o0, jqv.this.f2067O000000o);
                            jqv.this.f2067O000000o = 0;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
        }

        private void O00000Oo() throws IOException {
            jqv.this.O0000OOo.K_();
            while (this.O00000o.O00000Oo == 0 && !this.O0000O0o && !this.O00000oo && jqv.this.O0000Ooo == null) {
                try {
                    jqv.this.O00000oo();
                } finally {
                    jqv.this.O0000OOo.O0000O0o();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(iqn iqn, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (f2069O000000o || !Thread.holdsLock(jqv.this)) {
                while (j > 0) {
                    synchronized (jqv.this) {
                        z = this.O0000O0o;
                        z2 = true;
                        z3 = this.O00000o.O00000Oo + j > this.O00000oO;
                    }
                    if (z3) {
                        iqn.O00000oo(j);
                        jqv.this.O00000Oo(a.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        iqn.O00000oo(j);
                        return;
                    } else {
                        long O000000o2 = iqn.O000000o(this.O00000o0, j);
                        if (O000000o2 != -1) {
                            j -= O000000o2;
                            synchronized (jqv.this) {
                                if (this.O00000o.O00000Oo != 0) {
                                    z2 = false;
                                }
                                this.O00000o.O000000o(this.O00000o0);
                                if (z2) {
                                    jqv.this.notifyAll();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }
    }

    static /* synthetic */ void O00000oo(jqv jqv) throws IOException {
        boolean z;
        boolean O000000o2;
        if (O0000Oo || !Thread.holdsLock(jqv)) {
            synchronized (jqv) {
                z = !jqv.O00000oo.O0000O0o && jqv.O00000oo.O00000oo && (jqv.O0000O0o.O00000oO || jqv.O0000O0o.O00000o);
                O000000o2 = jqv.O000000o();
            }
            if (z) {
                jqv.O000000o(a.CANCEL);
            } else if (!O000000o2) {
                jqv.O00000o.O00000Oo(jqv.O00000o0);
            }
        } else {
            throw new AssertionError();
        }
    }

    static /* synthetic */ void O0000OOo(jqv jqv) throws IOException {
        if (jqv.O0000O0o.O00000o) {
            throw new IOException("stream closed");
        } else if (jqv.O0000O0o.O00000oO) {
            throw new IOException("stream finished");
        } else if (jqv.O0000Ooo != null) {
            throw new IOException("stream was reset: " + jqv.O0000Ooo);
        }
    }
}
