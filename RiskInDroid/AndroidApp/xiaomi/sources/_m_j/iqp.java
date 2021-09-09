package _m_j;

import java.io.IOException;

public abstract class iqp implements iqz {

    /* renamed from: O000000o  reason: collision with root package name */
    private final iqz f1562O000000o;

    public iqp(iqz iqz) {
        if (iqz != null) {
            this.f1562O000000o = iqz;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public long O000000o(iql iql, long j) throws IOException {
        return this.f1562O000000o.O000000o(iql, j);
    }

    public final ira O000000o() {
        return this.f1562O000000o.O000000o();
    }

    public void close() throws IOException {
        this.f1562O000000o.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f1562O000000o.toString() + ")";
    }
}
