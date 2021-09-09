package _m_j;

import java.io.IOException;
import java.util.zip.Deflater;

public final class iqo implements iqy {

    /* renamed from: O000000o  reason: collision with root package name */
    private final iqm f1561O000000o;
    private final Deflater O00000Oo;
    private boolean O00000o0;

    private iqo(iqm iqm, Deflater deflater) {
        if (iqm == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater != null) {
            this.f1561O000000o = iqm;
            this.O00000Oo = deflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public iqo(iqy iqy, Deflater deflater) {
        this(iqt.O000000o(iqy), deflater);
    }

    private void O000000o(boolean z) throws IOException {
        iqw O00000oO;
        iql O00000Oo2 = this.f1561O000000o.O00000Oo();
        while (true) {
            O00000oO = O00000Oo2.O00000oO(1);
            int deflate = z ? this.O00000Oo.deflate(O00000oO.f1572O000000o, O00000oO.O00000o0, 8192 - O00000oO.O00000o0, 2) : this.O00000Oo.deflate(O00000oO.f1572O000000o, O00000oO.O00000o0, 8192 - O00000oO.O00000o0);
            if (deflate > 0) {
                O00000oO.O00000o0 += deflate;
                O00000Oo2.O00000Oo += (long) deflate;
                this.f1561O000000o.O0000o();
            } else if (this.O00000Oo.needsInput()) {
                break;
            }
        }
        if (O00000oO.O00000Oo == O00000oO.O00000o0) {
            O00000Oo2.f1560O000000o = O00000oO.O000000o();
            iqx.O000000o(O00000oO);
        }
    }

    public final ira O000000o() {
        return this.f1561O000000o.O000000o();
    }

    public final void a_(iql iql, long j) throws IOException {
        irb.O000000o(iql.O00000Oo, 0, j);
        while (j > 0) {
            iqw iqw = iql.f1560O000000o;
            int min = (int) Math.min(j, (long) (iqw.O00000o0 - iqw.O00000Oo));
            this.O00000Oo.setInput(iqw.f1572O000000o, iqw.O00000Oo, min);
            O000000o(false);
            long j2 = (long) min;
            iql.O00000Oo -= j2;
            iqw.O00000Oo += min;
            if (iqw.O00000Oo == iqw.O00000o0) {
                iql.f1560O000000o = iqw.O000000o();
                iqx.O000000o(iqw);
            }
            j -= j2;
        }
    }

    public final void flush() throws IOException {
        O000000o(true);
        this.f1561O000000o.flush();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f1561O000000o + ")";
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
                this.f1561O000000o.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.O00000o0 = true;
            if (th != null) {
                irb.O000000o(th);
            }
        }
    }
}
