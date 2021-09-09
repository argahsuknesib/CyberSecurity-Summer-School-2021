package _m_j;

import gK.f;
import java.io.IOException;

final class iqu implements iqm {

    /* renamed from: O000000o  reason: collision with root package name */
    public final iql f1570O000000o = new iql();
    public final iqy O00000Oo;
    boolean O00000o0;

    iqu(iqy iqy) {
        if (iqy != null) {
            this.O00000Oo = iqy;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public final long O000000o(iqz iqz) throws IOException {
        if (iqz != null) {
            long j = 0;
            while (true) {
                long O000000o2 = iqz.O000000o(this.f1570O000000o, 8192);
                if (O000000o2 == -1) {
                    return j;
                }
                j += O000000o2;
                O0000o();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final ira O000000o() {
        return this.O00000Oo.O000000o();
    }

    public final iql O00000Oo() {
        return this.f1570O000000o;
    }

    public final iqm O00000Oo(f fVar) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O00000Oo(fVar);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O00000Oo(String str) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O00000Oo(str);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O00000Oo(byte[] bArr) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O00000Oo(bArr);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O00000Oo(byte[] bArr, int i, int i2) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O00000Oo(bArr, i, i2);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O00000oo(int i) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O00000oo(i);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O0000O0o(int i) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O0000O0o(i);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O0000OOo(int i) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O0000OOo(i);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O0000Oo(long j) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O0000Oo(j);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O0000Oo0(long j) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.O0000Oo0(j);
            return O0000o();
        }
        throw new IllegalStateException("closed");
    }

    public final iqm O0000o() throws IOException {
        if (!this.O00000o0) {
            long O00000oO = this.f1570O000000o.O00000oO();
            if (O00000oO > 0) {
                this.O00000Oo.a_(this.f1570O000000o, O00000oO);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final void a_(iql iql, long j) throws IOException {
        if (!this.O00000o0) {
            this.f1570O000000o.a_(iql, j);
            O0000o();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final void close() throws IOException {
        if (!this.O00000o0) {
            Throwable th = null;
            try {
                if (this.f1570O000000o.O00000Oo > 0) {
                    this.O00000Oo.a_(this.f1570O000000o, this.f1570O000000o.O00000Oo);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.O00000Oo.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.O00000o0 = true;
            if (th != null) {
                irb.O000000o(th);
            }
        }
    }

    public final void flush() throws IOException {
        if (!this.O00000o0) {
            if (this.f1570O000000o.O00000Oo > 0) {
                iqy iqy = this.O00000Oo;
                iql iql = this.f1570O000000o;
                iqy.a_(iql, iql.O00000Oo);
            }
            this.O00000Oo.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final String toString() {
        return "buffer(" + this.O00000Oo + ")";
    }

    public final iqm O00000o0() throws IOException {
        if (!this.O00000o0) {
            long j = this.f1570O000000o.O00000Oo;
            if (j > 0) {
                this.O00000Oo.a_(this.f1570O000000o, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
