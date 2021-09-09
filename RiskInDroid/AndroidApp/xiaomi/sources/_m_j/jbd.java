package _m_j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class jbd extends jbo {

    /* renamed from: O000000o  reason: collision with root package name */
    public jbo f1724O000000o;

    public jbd(jbo jbo) {
        if (jbo != null) {
            this.f1724O000000o = jbo;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final jbd O000000o(jbo jbo) {
        if (jbo != null) {
            this.f1724O000000o = jbo;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final jbo timeout(long j, TimeUnit timeUnit) {
        return this.f1724O000000o.timeout(j, timeUnit);
    }

    public final long timeoutNanos() {
        return this.f1724O000000o.timeoutNanos();
    }

    public final boolean hasDeadline() {
        return this.f1724O000000o.hasDeadline();
    }

    public final long deadlineNanoTime() {
        return this.f1724O000000o.deadlineNanoTime();
    }

    public final jbo deadlineNanoTime(long j) {
        return this.f1724O000000o.deadlineNanoTime(j);
    }

    public final jbo clearTimeout() {
        return this.f1724O000000o.clearTimeout();
    }

    public final jbo clearDeadline() {
        return this.f1724O000000o.clearDeadline();
    }

    public final void throwIfReached() throws IOException {
        this.f1724O000000o.throwIfReached();
    }
}
