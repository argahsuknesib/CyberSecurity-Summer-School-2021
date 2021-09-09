package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class jbe implements jbn {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f1725O000000o = 0;
    private final jaz O00000Oo;
    private final jbf O00000o;
    private final Inflater O00000o0;
    private final CRC32 O00000oO = new CRC32();

    public jbe(jbn jbn) {
        if (jbn != null) {
            this.O00000o0 = new Inflater(true);
            this.O00000Oo = jbg.O000000o(jbn);
            this.O00000o = new jbf(this.O00000Oo, this.O00000o0);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final long read(jax jax, long j) throws IOException {
        long j2;
        jax jax2 = jax;
        long j3 = j;
        if (j3 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (j3 == 0) {
            return 0;
        } else {
            if (this.f1725O000000o == 0) {
                this.O00000Oo.O000000o(10);
                byte O00000o02 = this.O00000Oo.O000000o().O00000o0(3L);
                boolean z = ((O00000o02 >> 1) & 1) == 1;
                if (z) {
                    O000000o(this.O00000Oo.O000000o(), 0, 10);
                }
                O000000o("ID1ID2", 8075, this.O00000Oo.O0000OOo());
                this.O00000Oo.O0000Oo0(8);
                if (((O00000o02 >> 2) & 1) == 1) {
                    this.O00000Oo.O000000o(2);
                    if (z) {
                        O000000o(this.O00000Oo.O000000o(), 0, 2);
                    }
                    long O0000OoO = (long) this.O00000Oo.O000000o().O0000OoO();
                    this.O00000Oo.O000000o(O0000OoO);
                    if (z) {
                        j2 = O0000OoO;
                        O000000o(this.O00000Oo.O000000o(), 0, O0000OoO);
                    } else {
                        j2 = O0000OoO;
                    }
                    this.O00000Oo.O0000Oo0(j2);
                }
                if (((O00000o02 >> 3) & 1) == 1) {
                    long O0000oo0 = this.O00000Oo.O0000oo0();
                    if (O0000oo0 != -1) {
                        if (z) {
                            O000000o(this.O00000Oo.O000000o(), 0, O0000oo0 + 1);
                        }
                        this.O00000Oo.O0000Oo0(O0000oo0 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((O00000o02 >> 4) & 1) == 1) {
                    long O0000oo02 = this.O00000Oo.O0000oo0();
                    if (O0000oo02 != -1) {
                        if (z) {
                            O000000o(this.O00000Oo.O000000o(), 0, O0000oo02 + 1);
                        }
                        this.O00000Oo.O0000Oo0(O0000oo02 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    O000000o("FHCRC", this.O00000Oo.O0000OoO(), (short) ((int) this.O00000oO.getValue()));
                    this.O00000oO.reset();
                }
                this.f1725O000000o = 1;
            }
            if (this.f1725O000000o == 1) {
                long j4 = jax2.O00000Oo;
                long read = this.O00000o.read(jax2, j3);
                if (read != -1) {
                    O000000o(jax, j4, read);
                    return read;
                }
                this.f1725O000000o = 2;
            }
            if (this.f1725O000000o == 2) {
                O000000o("CRC", this.O00000Oo.O0000Ooo(), (int) this.O00000oO.getValue());
                O000000o("ISIZE", this.O00000Oo.O0000Ooo(), (int) this.O00000o0.getBytesWritten());
                this.f1725O000000o = 3;
                if (!this.O00000Oo.O00000o()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final jbo timeout() {
        return this.O00000Oo.timeout();
    }

    public final void close() throws IOException {
        this.O00000o.close();
    }

    private void O000000o(jax jax, long j, long j2) {
        jbk jbk = jax.f1718O000000o;
        while (j >= ((long) (jbk.O00000o0 - jbk.O00000Oo))) {
            j -= (long) (jbk.O00000o0 - jbk.O00000Oo);
            jbk = jbk.O00000oo;
        }
        while (j2 > 0) {
            int i = (int) (((long) jbk.O00000Oo) + j);
            int min = (int) Math.min((long) (jbk.O00000o0 - i), j2);
            this.O00000oO.update(jbk.f1738O000000o, i, min);
            j2 -= (long) min;
            jbk = jbk.O00000oo;
            j = 0;
        }
    }

    private static void O000000o(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
