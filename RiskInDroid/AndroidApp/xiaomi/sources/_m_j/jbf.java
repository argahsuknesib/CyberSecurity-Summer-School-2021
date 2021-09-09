package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class jbf implements jbn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final jaz f1726O000000o;
    private final Inflater O00000Oo;
    private boolean O00000o;
    private int O00000o0;

    public jbf(jbn jbn, Inflater inflater) {
        this(jbg.O000000o(jbn), inflater);
    }

    jbf(jaz jaz, Inflater inflater) {
        if (jaz == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f1726O000000o = jaz;
            this.O00000Oo = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public final long read(jax jax, long j) throws IOException {
        jbk O00000oo;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.O00000o) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean O000000o2 = O000000o();
                try {
                    O00000oo = jax.O00000oo(1);
                    int inflate = this.O00000Oo.inflate(O00000oo.f1738O000000o, O00000oo.O00000o0, (int) Math.min(j, (long) (8192 - O00000oo.O00000o0)));
                    if (inflate > 0) {
                        O00000oo.O00000o0 += inflate;
                        long j2 = (long) inflate;
                        jax.O00000Oo += j2;
                        return j2;
                    } else if (this.O00000Oo.finished()) {
                        break;
                    } else if (this.O00000Oo.needsDictionary()) {
                        break;
                    } else if (O000000o2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            O00000Oo();
            if (O00000oo.O00000Oo != O00000oo.O00000o0) {
                return -1;
            }
            jax.f1718O000000o = O00000oo.O00000o0();
            jbl.O000000o(O00000oo);
            return -1;
        }
    }

    public final boolean O000000o() throws IOException {
        if (!this.O00000Oo.needsInput()) {
            return false;
        }
        O00000Oo();
        if (this.O00000Oo.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f1726O000000o.O00000o()) {
            return true;
        } else {
            jbk jbk = this.f1726O000000o.O000000o().f1718O000000o;
            this.O00000o0 = jbk.O00000o0 - jbk.O00000Oo;
            this.O00000Oo.setInput(jbk.f1738O000000o, jbk.O00000Oo, this.O00000o0);
            return false;
        }
    }

    private void O00000Oo() throws IOException {
        int i = this.O00000o0;
        if (i != 0) {
            int remaining = i - this.O00000Oo.getRemaining();
            this.O00000o0 -= remaining;
            this.f1726O000000o.O0000Oo0((long) remaining);
        }
    }

    public final jbo timeout() {
        return this.f1726O000000o.timeout();
    }

    public final void close() throws IOException {
        if (!this.O00000o) {
            this.O00000Oo.end();
            this.O00000o = true;
            this.f1726O000000o.close();
        }
    }
}
