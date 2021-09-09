package _m_j;

import java.io.IOException;

public final class jbh {

    /* renamed from: O000000o  reason: collision with root package name */
    final long f1731O000000o = 8192;
    final jax O00000Oo = new jax();
    boolean O00000o;
    boolean O00000o0;
    public final jbm O00000oO = new O000000o();
    public final jbn O00000oo = new O00000Oo();

    final class O000000o implements jbm {

        /* renamed from: O000000o  reason: collision with root package name */
        final jbo f1732O000000o = new jbo();

        O000000o() {
        }

        public final void write(jax jax, long j) throws IOException {
            synchronized (jbh.this.O00000Oo) {
                if (!jbh.this.O00000o0) {
                    while (j > 0) {
                        if (!jbh.this.O00000o) {
                            long j2 = jbh.this.f1731O000000o - jbh.this.O00000Oo.O00000Oo;
                            if (j2 == 0) {
                                this.f1732O000000o.waitUntilNotified(jbh.this.O00000Oo);
                            } else {
                                long min = Math.min(j2, j);
                                jbh.this.O00000Oo.write(jax, min);
                                j -= min;
                                jbh.this.O00000Oo.notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }

        public final void flush() throws IOException {
            synchronized (jbh.this.O00000Oo) {
                if (jbh.this.O00000o0) {
                    throw new IllegalStateException("closed");
                } else if (jbh.this.O00000o) {
                    if (jbh.this.O00000Oo.O00000Oo > 0) {
                        throw new IOException("source is closed");
                    }
                }
            }
        }

        public final void close() throws IOException {
            synchronized (jbh.this.O00000Oo) {
                if (!jbh.this.O00000o0) {
                    if (jbh.this.O00000o) {
                        if (jbh.this.O00000Oo.O00000Oo > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    jbh.this.O00000o0 = true;
                    jbh.this.O00000Oo.notifyAll();
                }
            }
        }

        public final jbo timeout() {
            return this.f1732O000000o;
        }
    }

    final class O00000Oo implements jbn {

        /* renamed from: O000000o  reason: collision with root package name */
        final jbo f1733O000000o = new jbo();

        O00000Oo() {
        }

        public final long read(jax jax, long j) throws IOException {
            synchronized (jbh.this.O00000Oo) {
                if (!jbh.this.O00000o) {
                    while (jbh.this.O00000Oo.O00000Oo == 0) {
                        if (jbh.this.O00000o0) {
                            return -1;
                        }
                        this.f1733O000000o.waitUntilNotified(jbh.this.O00000Oo);
                    }
                    long read = jbh.this.O00000Oo.read(jax, j);
                    jbh.this.O00000Oo.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        public final void close() throws IOException {
            synchronized (jbh.this.O00000Oo) {
                jbh.this.O00000o = true;
                jbh.this.O00000Oo.notifyAll();
            }
        }

        public final jbo timeout() {
            return this.f1733O000000o;
        }
    }
}
