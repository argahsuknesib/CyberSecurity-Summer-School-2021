package _m_j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class ira {
    public static final ira O00000Oo = new ira() {
        /* class _m_j.ira.AnonymousClass1 */

        public final ira O000000o(long j) {
            return this;
        }

        public final ira O000000o(long j, TimeUnit timeUnit) {
            return this;
        }

        public final void O00000oo() throws IOException {
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f1576O000000o;
    private long O00000o;
    private long O00000o0;

    public boolean M_() {
        return this.f1576O000000o;
    }

    public long N_() {
        if (this.f1576O000000o) {
            return this.O00000o0;
        }
        throw new IllegalStateException("No deadline");
    }

    public long O000000o() {
        return this.O00000o;
    }

    public ira O000000o(long j) {
        this.f1576O000000o = true;
        this.O00000o0 = j;
        return this;
    }

    public ira O000000o(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        } else if (timeUnit != null) {
            this.O00000o = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public ira O00000o() {
        this.O00000o = 0;
        return this;
    }

    public ira O00000oO() {
        this.f1576O000000o = false;
        return this;
    }

    public void O00000oo() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f1576O000000o && this.O00000o0 - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
