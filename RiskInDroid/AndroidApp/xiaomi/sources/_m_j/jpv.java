package _m_j;

import _m_j.jpi;
import _m_j.jrk;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public final class jpv implements jqa {

    /* renamed from: O000000o  reason: collision with root package name */
    final jqh f2036O000000o;
    final iqn O00000Oo;
    int O00000o = 0;
    final iqm O00000o0;
    private jpy O00000oO;

    public jpv(jqh jqh, iqn iqn, iqm iqm) {
        this.f2036O000000o = jqh;
        this.O00000Oo = iqn;
        this.O00000o0 = iqm;
    }

    public final iqz O000000o(long j) throws IOException {
        if (this.O00000o == 4) {
            this.O00000o = 5;
            return new O0000O0o(j);
        }
        throw new IllegalStateException("state: " + this.O00000o);
    }

    public final jrk.O000000o O000000o() throws IOException {
        return O00000o0();
    }

    public final void O000000o(jpy jpy) {
        this.O00000oO = jpy;
    }

    public final void O000000o(jqe jqe) throws IOException {
        if (this.O00000o == 1) {
            this.O00000o = 3;
            jqe.O000000o(this.O00000o0);
            return;
        }
        throw new IllegalStateException("state: " + this.O00000o);
    }

    public final void O00000Oo() throws IOException {
        this.O00000o0.flush();
    }

    public final jpi O00000o() throws IOException {
        jpi.O000000o o000000o = new jpi.O000000o();
        while (true) {
            String O0000o0 = this.O00000Oo.O0000o0();
            if (O0000o0.length() == 0) {
                return o000000o.O000000o();
            }
            jpn.O00000Oo.O000000o(o000000o, O0000o0);
        }
    }

    abstract class O000000o implements iqz {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final iqq f2037O000000o;
        protected boolean O00000Oo;

        /* synthetic */ O000000o(jpv jpv, byte b) {
            this();
        }

        public final ira O000000o() {
            return this.f2037O000000o;
        }

        private O000000o() {
            this.f2037O000000o = new iqq(jpv.this.O00000Oo.O000000o());
        }

        /* access modifiers changed from: protected */
        public final void O000000o(boolean z) throws IOException {
            if (jpv.this.O00000o != 6) {
                if (jpv.this.O00000o == 5) {
                    jpv.O000000o(this.f2037O000000o);
                    jpv jpv = jpv.this;
                    jpv.O00000o = 6;
                    if (jpv.f2036O000000o != null) {
                        jpv.this.f2036O000000o.O000000o(!z, jpv.this);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + jpv.this.O00000o);
            }
        }
    }

    final class O00000Oo implements iqy {
        private final iqq O00000Oo;
        private boolean O00000o0;

        /* synthetic */ O00000Oo(jpv jpv, byte b) {
            this();
        }

        public final ira O000000o() {
            return this.O00000Oo;
        }

        private O00000Oo() {
            this.O00000Oo = new iqq(jpv.this.O00000o0.O000000o());
        }

        public final void a_(iql iql, long j) throws IOException {
            if (this.O00000o0) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                jpv.this.O00000o0.O0000Oo0(j);
                jpv.this.O00000o0.O00000Oo("\r\n");
                jpv.this.O00000o0.a_(iql, j);
                jpv.this.O00000o0.O00000Oo("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.O00000o0) {
                jpv.this.O00000o0.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.O00000o0) {
                this.O00000o0 = true;
                jpv.this.O00000o0.O00000Oo("0\r\n\r\n");
                jpv.O000000o(this.O00000Oo);
                jpv.this.O00000o = 3;
            }
        }
    }

    final class O00000o implements iqy {
        private final iqq O00000Oo;
        private long O00000o;
        private boolean O00000o0;

        /* synthetic */ O00000o(jpv jpv, long j, byte b) {
            this(j);
        }

        public final ira O000000o() {
            return this.O00000Oo;
        }

        private O00000o(long j) {
            this.O00000Oo = new iqq(jpv.this.O00000o0.O000000o());
            this.O00000o = j;
        }

        public final void a_(iql iql, long j) throws IOException {
            if (!this.O00000o0) {
                jqp.O000000o(iql.O00000Oo, 0, j);
                if (j <= this.O00000o) {
                    jpv.this.O00000o0.a_(iql, j);
                    this.O00000o -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.O00000o + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public final void flush() throws IOException {
            if (!this.O00000o0) {
                jpv.this.O00000o0.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.O00000o0) {
                this.O00000o0 = true;
                if (this.O00000o <= 0) {
                    jpv.O000000o(this.O00000Oo);
                    jpv.this.O00000o = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    class O00000o0 extends O000000o {
        private long O00000oO = -1;
        private boolean O00000oo = true;
        private final jpy O0000O0o;

        O00000o0(jpy jpy) throws IOException {
            super(jpv.this, (byte) 0);
            this.O0000O0o = jpy;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean
         arg types: [_m_j.jpv$O00000o0, java.util.concurrent.TimeUnit]
         candidates:
          _m_j.jqp.O000000o(ss.q, boolean):java.lang.String
          _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void
          _m_j.jqp.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.jqp.O000000o(java.lang.String[], java.lang.String):boolean
          _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean */
        public final void close() throws IOException {
            if (!this.O00000Oo) {
                if (this.O00000oo && !jqp.O000000o((iqz) this, TimeUnit.MILLISECONDS)) {
                    O000000o(false);
                }
                this.O00000Oo = true;
            }
        }

        public final long O000000o(iql iql, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.O00000Oo) {
                throw new IllegalStateException("closed");
            } else if (!this.O00000oo) {
                return -1;
            } else {
                long j2 = this.O00000oO;
                if (j2 == 0 || j2 == -1) {
                    if (this.O00000oO != -1) {
                        jpv.this.O00000Oo.O0000o0();
                    }
                    try {
                        this.O00000oO = jpv.this.O00000Oo.O0000OoO();
                        String trim = jpv.this.O00000Oo.O0000o0().trim();
                        if (this.O00000oO < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.O00000oO + trim + jdn.f1779O000000o);
                        }
                        if (this.O00000oO == 0) {
                            this.O00000oo = false;
                            this.O0000O0o.O000000o(jpv.this.O00000o());
                            O000000o(true);
                        }
                        if (!this.O00000oo) {
                            return -1;
                        }
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long O000000o2 = jpv.this.O00000Oo.O000000o(iql, Math.min(j, this.O00000oO));
                if (O000000o2 != -1) {
                    this.O00000oO -= O000000o2;
                    return O000000o2;
                }
                O000000o(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    class O0000O0o extends O000000o {
        private long O00000oO;

        public O0000O0o(long j) throws IOException {
            super(jpv.this, (byte) 0);
            this.O00000oO = j;
            if (this.O00000oO == 0) {
                O000000o(true);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean
         arg types: [_m_j.jpv$O0000O0o, java.util.concurrent.TimeUnit]
         candidates:
          _m_j.jqp.O000000o(ss.q, boolean):java.lang.String
          _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void
          _m_j.jqp.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.jqp.O000000o(java.lang.String[], java.lang.String):boolean
          _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean */
        public final void close() throws IOException {
            if (!this.O00000Oo) {
                if (this.O00000oO != 0 && !jqp.O000000o((iqz) this, TimeUnit.MILLISECONDS)) {
                    O000000o(false);
                }
                this.O00000Oo = true;
            }
        }

        public final long O000000o(iql iql, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.O00000Oo) {
                throw new IllegalStateException("closed");
            } else if (this.O00000oO == 0) {
                return -1;
            } else {
                long O000000o2 = jpv.this.O00000Oo.O000000o(iql, Math.min(this.O00000oO, j));
                if (O000000o2 != -1) {
                    this.O00000oO -= O000000o2;
                    if (this.O00000oO == 0) {
                        O000000o(true);
                    }
                    return O000000o2;
                }
                O000000o(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    class O0000OOo extends O000000o {
        private boolean O00000oO;

        private O0000OOo() {
            super(jpv.this, (byte) 0);
        }

        /* synthetic */ O0000OOo(jpv jpv, byte b) {
            this();
        }

        public final void close() throws IOException {
            if (!this.O00000Oo) {
                if (!this.O00000oO) {
                    O000000o(false);
                }
                this.O00000Oo = true;
            }
        }

        public final long O000000o(iql iql, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.O00000Oo) {
                throw new IllegalStateException("closed");
            } else if (this.O00000oO) {
                return -1;
            } else {
                long O000000o2 = jpv.this.O00000Oo.O000000o(iql, j);
                if (O000000o2 != -1) {
                    return O000000o2;
                }
                this.O00000oO = true;
                O000000o(true);
                return -1;
            }
        }
    }

    public final iqy O000000o(jri jri, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(jri.O000000o("Transfer-Encoding"))) {
            if (this.O00000o == 1) {
                this.O00000o = 2;
                return new O00000Oo(this, (byte) 0);
            }
            throw new IllegalStateException("state: " + this.O00000o);
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.O00000o == 1) {
            this.O00000o = 2;
            return new O00000o(this, j, (byte) 0);
        } else {
            throw new IllegalStateException("state: " + this.O00000o);
        }
    }

    public final void O000000o(jri jri) throws IOException {
        this.O00000oO.O000000o();
        Proxy.Type type = this.O00000oO.O00000o0.O000000o().O000000o().O00000Oo.type();
        StringBuilder sb = new StringBuilder();
        sb.append(jri.O00000Oo);
        sb.append(' ');
        if (!jri.f2095O000000o.O00000Oo() && type == Proxy.Type.HTTP) {
            sb.append(jri.f2095O000000o);
        } else {
            sb.append(jqd.O000000o(jri.f2095O000000o));
        }
        sb.append(" HTTP/1.1");
        O000000o(jri.O00000o0, sb.toString());
    }

    public final jrl O000000o(jrk jrk) throws IOException {
        iqz iqz;
        if (!jpy.O00000o0(jrk)) {
            iqz = O000000o(0);
        } else if ("chunked".equalsIgnoreCase(jrk.O000000o("Transfer-Encoding"))) {
            jpy jpy = this.O00000oO;
            if (this.O00000o == 4) {
                this.O00000o = 5;
                iqz = new O00000o0(jpy);
            } else {
                throw new IllegalStateException("state: " + this.O00000o);
            }
        } else {
            long O000000o2 = jqb.O000000o(jrk);
            if (O000000o2 != -1) {
                iqz = O000000o(O000000o2);
            } else if (this.O00000o == 4) {
                jqh jqh = this.f2036O000000o;
                if (jqh != null) {
                    this.O00000o = 5;
                    jqh.O000000o(true, false, false);
                    iqz = new O0000OOo(this, (byte) 0);
                } else {
                    throw new IllegalStateException("streamAllocation == null");
                }
            } else {
                throw new IllegalStateException("state: " + this.O00000o);
            }
        }
        return new jqc(jrk.O00000oo, iqt.O000000o(iqz));
    }

    public final void O000000o(jpi jpi, String str) throws IOException {
        if (this.O00000o == 0) {
            this.O00000o0.O00000Oo(str).O00000Oo("\r\n");
            int length = jpi.f2020O000000o.length / 2;
            for (int i = 0; i < length; i++) {
                this.O00000o0.O00000Oo(jpi.O000000o(i)).O00000Oo(": ").O00000Oo(jpi.O00000Oo(i)).O00000Oo("\r\n");
            }
            this.O00000o0.O00000Oo("\r\n");
            this.O00000o = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.O00000o);
    }

    public final jrk.O000000o O00000o0() throws IOException {
        jqg O000000o2;
        jrk.O000000o O000000o3;
        int i = this.O00000o;
        if (i == 1 || i == 3) {
            do {
                try {
                    O000000o2 = jqg.O000000o(this.O00000Oo.O0000o0());
                    jrk.O000000o o000000o = new jrk.O000000o();
                    o000000o.O00000Oo = O000000o2.f2054O000000o;
                    o000000o.O00000o0 = O000000o2.O00000Oo;
                    o000000o.O00000o = O000000o2.O00000o0;
                    O000000o3 = o000000o.O000000o(O00000o());
                } catch (EOFException e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f2036O000000o);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (O000000o2.O00000Oo == 100);
            this.O00000o = 4;
            return O000000o3;
        }
        throw new IllegalStateException("state: " + this.O00000o);
    }

    static /* synthetic */ void O000000o(iqq iqq) {
        ira ira = iqq.f1563O000000o;
        ira ira2 = ira.O00000Oo;
        if (ira2 != null) {
            iqq.f1563O000000o = ira2;
            ira.O00000oO();
            ira.O00000o();
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }
}
