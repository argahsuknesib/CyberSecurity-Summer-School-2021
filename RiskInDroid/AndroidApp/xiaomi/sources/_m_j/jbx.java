package _m_j;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class jbx implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Queue<O000000o> f1751O000000o;
    private final jcq O00000Oo;
    private final jby O00000o0;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final jcl f1752O000000o;
        final long O00000Oo;
        final long O00000o;
        final long O00000o0;

        public O000000o(jcl jcl, long j, long j2, long j3) {
            this.f1752O000000o = jcl;
            this.O00000Oo = j;
            this.O00000o0 = j2;
            this.O00000o = j3;
        }
    }

    public final void O000000o(jcl jcl) throws IOException {
        Throwable th;
        InputStream O000000o2 = jcl.O000000o();
        try {
            this.O00000o0.O000000o(O000000o2, jcl.f1762O000000o);
            if (O000000o2 != null) {
                O000000o2.close();
            }
            this.f1751O000000o.add(new O000000o(jcl, this.O00000o0.f1753O000000o.getValue(), this.O00000o0.O00000Oo, this.O00000o0.O00000o0));
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public final void close() throws IOException {
        this.O00000Oo.close();
        this.O00000o0.close();
    }
}
