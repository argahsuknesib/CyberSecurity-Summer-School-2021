package _m_j;

import java.io.IOException;
import java.net.ProtocolException;

public final class jqe implements iqy {

    /* renamed from: O000000o  reason: collision with root package name */
    public final iql f2052O000000o;
    private boolean O00000Oo;
    private final int O00000o0;

    public jqe() {
        this(-1);
    }

    public jqe(int i) {
        this.f2052O000000o = new iql();
        this.O00000o0 = i;
    }

    public final ira O000000o() {
        return ira.O00000Oo;
    }

    public final void flush() throws IOException {
    }

    public final void close() throws IOException {
        if (!this.O00000Oo) {
            this.O00000Oo = true;
            if (this.f2052O000000o.O00000Oo < ((long) this.O00000o0)) {
                throw new ProtocolException("content-length promised " + this.O00000o0 + " bytes, but received " + this.f2052O000000o.O00000Oo);
            }
        }
    }

    public final void a_(iql iql, long j) throws IOException {
        if (!this.O00000Oo) {
            jqp.O000000o(iql.O00000Oo, 0, j);
            if (this.O00000o0 == -1 || this.f2052O000000o.O00000Oo <= ((long) this.O00000o0) - j) {
                this.f2052O000000o.a_(iql, j);
                return;
            }
            throw new ProtocolException("exceeded content-length limit of " + this.O00000o0 + " bytes");
        }
        throw new IllegalStateException("closed");
    }

    public final void O000000o(iqy iqy) throws IOException {
        iql iql = new iql();
        iql iql2 = this.f2052O000000o;
        iql2.O000000o(iql, 0, iql2.O00000Oo);
        iqy.a_(iql, iql.O00000Oo);
    }
}
