package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class iqr implements iqz {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f1564O000000o = 0;
    private final iqn O00000Oo;
    private final iqs O00000o;
    private final Inflater O00000o0;
    private final CRC32 O00000oO = new CRC32();

    public iqr(iqz iqz) {
        if (iqz != null) {
            this.O00000o0 = new Inflater(true);
            this.O00000Oo = iqt.O000000o(iqz);
            this.O00000o = new iqs(this.O00000Oo, this.O00000o0);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void O000000o(iql iql, long j, long j2) {
        iqw iqw = iql.f1560O000000o;
        while (j >= ((long) (iqw.O00000o0 - iqw.O00000Oo))) {
            j -= (long) (iqw.O00000o0 - iqw.O00000Oo);
            iqw = iqw.O00000oo;
        }
        while (j2 > 0) {
            int i = (int) (((long) iqw.O00000Oo) + j);
            int min = (int) Math.min((long) (iqw.O00000o0 - i), j2);
            this.O00000oO.update(iqw.f1572O000000o, i, min);
            j2 -= (long) min;
            iqw = iqw.O00000oo;
            j = 0;
        }
    }

    private static void O000000o(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public final ira O000000o() {
        return this.O00000Oo.O000000o();
    }

    public final void close() throws IOException {
        this.O00000o.close();
    }

    public final long O000000o(iql iql, long j) throws IOException {
        long j2;
        iql iql2 = iql;
        long j3 = j;
        if (j3 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (j3 == 0) {
            return 0;
        } else {
            if (this.f1564O000000o == 0) {
                this.O00000Oo.O000000o(10);
                byte O00000Oo2 = this.O00000Oo.O00000Oo().O00000Oo(3L);
                boolean z = ((O00000Oo2 >> 1) & 1) == 1;
                if (z) {
                    O000000o(this.O00000Oo.O00000Oo(), 0, 10);
                }
                O000000o("ID1ID2", 8075, this.O00000Oo.O0000O0o());
                this.O00000Oo.O00000oo(8);
                if (((O00000Oo2 >> 2) & 1) == 1) {
                    this.O00000Oo.O000000o(2);
                    if (z) {
                        O000000o(this.O00000Oo.O00000Oo(), 0, 2);
                    }
                    long O0000Oo0 = (long) this.O00000Oo.O00000Oo().O0000Oo0();
                    this.O00000Oo.O000000o(O0000Oo0);
                    if (z) {
                        j2 = O0000Oo0;
                        O000000o(this.O00000Oo.O00000Oo(), 0, O0000Oo0);
                    } else {
                        j2 = O0000Oo0;
                    }
                    this.O00000Oo.O00000oo(j2);
                }
                if (((O00000Oo2 >> 3) & 1) == 1) {
                    long O000000o2 = this.O00000Oo.O000000o((byte) 0);
                    if (O000000o2 != -1) {
                        if (z) {
                            O000000o(this.O00000Oo.O00000Oo(), 0, O000000o2 + 1);
                        }
                        this.O00000Oo.O00000oo(O000000o2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((O00000Oo2 >> 4) & 1) == 1) {
                    long O000000o3 = this.O00000Oo.O000000o((byte) 0);
                    if (O000000o3 != -1) {
                        if (z) {
                            O000000o(this.O00000Oo.O00000Oo(), 0, O000000o3 + 1);
                        }
                        this.O00000Oo.O00000oo(O000000o3 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    O000000o("FHCRC", this.O00000Oo.O0000Oo0(), (short) ((int) this.O00000oO.getValue()));
                    this.O00000oO.reset();
                }
                this.f1564O000000o = 1;
            }
            if (this.f1564O000000o == 1) {
                long j4 = iql2.O00000Oo;
                long O000000o4 = this.O00000o.O000000o(iql2, j3);
                if (O000000o4 != -1) {
                    O000000o(iql, j4, O000000o4);
                    return O000000o4;
                }
                this.f1564O000000o = 2;
            }
            if (this.f1564O000000o == 2) {
                O000000o("CRC", this.O00000Oo.O0000Oo(), (int) this.O00000oO.getValue());
                O000000o("ISIZE", this.O00000Oo.O0000Oo(), this.O00000o0.getTotalOut());
                this.f1564O000000o = 3;
                if (!this.O00000Oo.O00000o()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }
}
