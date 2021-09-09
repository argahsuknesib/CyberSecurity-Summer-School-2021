package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class iqs implements iqz {

    /* renamed from: O000000o  reason: collision with root package name */
    private final iqn f1565O000000o;
    private final Inflater O00000Oo;
    private boolean O00000o;
    private int O00000o0;

    iqs(iqn iqn, Inflater inflater) {
        if (iqn == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f1565O000000o = iqn;
            this.O00000Oo = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public iqs(iqz iqz, Inflater inflater) {
        this(iqt.O000000o(iqz), inflater);
    }

    private void O00000o0() throws IOException {
        int i = this.O00000o0;
        if (i != 0) {
            int remaining = i - this.O00000Oo.getRemaining();
            this.O00000o0 -= remaining;
            this.f1565O000000o.O00000oo((long) remaining);
        }
    }

    public final long O000000o(iql iql, long j) throws IOException {
        iqw O00000oO;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.O00000o) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean O00000Oo2 = O00000Oo();
                try {
                    O00000oO = iql.O00000oO(1);
                    int inflate = this.O00000Oo.inflate(O00000oO.f1572O000000o, O00000oO.O00000o0, 8192 - O00000oO.O00000o0);
                    if (inflate > 0) {
                        O00000oO.O00000o0 += inflate;
                        long j2 = (long) inflate;
                        iql.O00000Oo += j2;
                        return j2;
                    } else if (this.O00000Oo.finished()) {
                        break;
                    } else if (this.O00000Oo.needsDictionary()) {
                        break;
                    } else if (O00000Oo2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            O00000o0();
            if (O00000oO.O00000Oo != O00000oO.O00000o0) {
                return -1;
            }
            iql.f1560O000000o = O00000oO.O000000o();
            iqx.O000000o(O00000oO);
            return -1;
        }
    }

    public final ira O000000o() {
        return this.f1565O000000o.O000000o();
    }

    public final boolean O00000Oo() throws IOException {
        if (!this.O00000Oo.needsInput()) {
            return false;
        }
        O00000o0();
        if (this.O00000Oo.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f1565O000000o.O00000o()) {
            return true;
        } else {
            iqw iqw = this.f1565O000000o.O00000Oo().f1560O000000o;
            this.O00000o0 = iqw.O00000o0 - iqw.O00000Oo;
            this.O00000Oo.setInput(iqw.f1572O000000o, iqw.O00000Oo, this.O00000o0);
            return false;
        }
    }

    public final void close() throws IOException {
        if (!this.O00000o) {
            this.O00000Oo.end();
            this.O00000o = true;
            this.f1565O000000o.close();
        }
    }
}
