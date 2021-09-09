package _m_j;

import java.io.IOException;
import java.util.zip.Deflater;

public final class jba implements jbm {

    /* renamed from: O000000o  reason: collision with root package name */
    private final jay f1723O000000o;
    private final Deflater O00000Oo;
    private boolean O00000o0;

    public jba(jbm jbm, Deflater deflater) {
        this(jbg.O000000o(jbm), deflater);
    }

    private jba(jay jay, Deflater deflater) {
        if (jay == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater != null) {
            this.f1723O000000o = jay;
            this.O00000Oo = deflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public final void write(jax jax, long j) throws IOException {
        jbp.O000000o(jax.O00000Oo, 0, j);
        while (j > 0) {
            jbk jbk = jax.f1718O000000o;
            int min = (int) Math.min(j, (long) (jbk.O00000o0 - jbk.O00000Oo));
            this.O00000Oo.setInput(jbk.f1738O000000o, jbk.O00000Oo, min);
            O000000o(false);
            long j2 = (long) min;
            jax.O00000Oo -= j2;
            jbk.O00000Oo += min;
            if (jbk.O00000Oo == jbk.O00000o0) {
                jax.f1718O000000o = jbk.O00000o0();
                jbl.O000000o(jbk);
            }
            j -= j2;
        }
    }

    private void O000000o(boolean z) throws IOException {
        jbk O00000oo;
        int i;
        jax O000000o2 = this.f1723O000000o.O000000o();
        while (true) {
            O00000oo = O000000o2.O00000oo(1);
            if (z) {
                i = this.O00000Oo.deflate(O00000oo.f1738O000000o, O00000oo.O00000o0, 8192 - O00000oo.O00000o0, 2);
            } else {
                i = this.O00000Oo.deflate(O00000oo.f1738O000000o, O00000oo.O00000o0, 8192 - O00000oo.O00000o0);
            }
            if (i > 0) {
                O00000oo.O00000o0 += i;
                O000000o2.O00000Oo += (long) i;
                this.f1723O000000o.O0000ooo();
            } else if (this.O00000Oo.needsInput()) {
                break;
            }
        }
        if (O00000oo.O00000Oo == O00000oo.O00000o0) {
            O000000o2.f1718O000000o = O00000oo.O00000o0();
            jbl.O000000o(O00000oo);
        }
    }

    public final void flush() throws IOException {
        O000000o(true);
        this.f1723O000000o.flush();
    }

    public final void close() throws IOException {
        if (!this.O00000o0) {
            Throwable th = null;
            try {
                this.O00000Oo.finish();
                O000000o(false);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.O00000Oo.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f1723O000000o.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.O00000o0 = true;
            if (th != null) {
                jbp.O000000o(th);
            }
        }
    }

    public final jbo timeout() {
        return this.f1723O000000o.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f1723O000000o + ")";
    }
}
