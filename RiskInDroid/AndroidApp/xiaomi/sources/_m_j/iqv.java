package _m_j;

import gK.f;
import java.io.EOFException;
import java.io.IOException;

final class iqv implements iqn {

    /* renamed from: O000000o  reason: collision with root package name */
    public final iql f1571O000000o = new iql();
    public final iqz O00000Oo;
    boolean O00000o0;

    iqv(iqz iqz) {
        if (iqz != null) {
            this.O00000Oo = iqz;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private long O000000o(byte b, long j) throws IOException {
        if (!this.O00000o0) {
            while (0 >= this.f1571O000000o.O00000Oo) {
                if (this.O00000Oo.O000000o(this.f1571O000000o, 8192) == -1) {
                    return -1;
                }
            }
            do {
                long O000000o2 = this.f1571O000000o.O000000o(b, j);
                if (O000000o2 != -1) {
                    return O000000o2;
                }
                j = this.f1571O000000o.O00000Oo;
            } while (this.O00000Oo.O000000o(this.f1571O000000o, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    private boolean O00000Oo(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (!this.O00000o0) {
            while (this.f1571O000000o.O00000Oo < j) {
                if (this.O00000Oo.O000000o(this.f1571O000000o, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final long O000000o(byte b) throws IOException {
        return O000000o((byte) 0, 0);
    }

    public final long O000000o(iql iql, long j) throws IOException {
        if (iql == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.O00000o0) {
            throw new IllegalStateException("closed");
        } else if (this.f1571O000000o.O00000Oo == 0 && this.O00000Oo.O000000o(this.f1571O000000o, 8192) == -1) {
            return -1;
        } else {
            return this.f1571O000000o.O000000o(iql, Math.min(j, this.f1571O000000o.O00000Oo));
        }
    }

    public final ira O000000o() {
        return this.O00000Oo.O000000o();
    }

    public final void O000000o(long j) throws IOException {
        if (!O00000Oo(j)) {
            throw new EOFException();
        }
    }

    public final iql O00000Oo() {
        return this.f1571O000000o;
    }

    public final boolean O00000o() throws IOException {
        if (!this.O00000o0) {
            return this.f1571O000000o.O00000o() && this.O00000Oo.O000000o(this.f1571O000000o, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public final f O00000o0(long j) throws IOException {
        O000000o(j);
        return this.f1571O000000o.O00000o0(j);
    }

    public final byte[] O00000oO(long j) throws IOException {
        O000000o(j);
        return this.f1571O000000o.O00000oO(j);
    }

    public final byte O00000oo() throws IOException {
        O000000o(1);
        return this.f1571O000000o.O00000oo();
    }

    public final short O0000O0o() throws IOException {
        O000000o(2);
        return this.f1571O000000o.O0000O0o();
    }

    public final int O0000OOo() throws IOException {
        O000000o(4);
        return this.f1571O000000o.O0000OOo();
    }

    public final long O0000OoO() throws IOException {
        O000000o(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!O00000Oo((long) i2)) {
                break;
            }
            byte O00000Oo2 = this.f1571O000000o.O00000Oo((long) i);
            if ((O00000Oo2 >= 48 && O00000Oo2 <= 57) || ((O00000Oo2 >= 97 && O00000Oo2 <= 102) || (O00000Oo2 >= 65 && O00000Oo2 <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(O00000Oo2)));
            }
        }
        return this.f1571O000000o.O0000OoO();
    }

    public final byte[] O0000o0O() throws IOException {
        this.f1571O000000o.O000000o(this.O00000Oo);
        return this.f1571O000000o.O0000o0O();
    }

    public final void close() throws IOException {
        if (!this.O00000o0) {
            this.O00000o0 = true;
            this.O00000Oo.close();
            this.f1571O000000o.O0000o0o();
        }
    }

    public final String toString() {
        return "buffer(" + this.O00000Oo + ")";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    public final String O0000o0() throws IOException {
        long O000000o2 = O000000o((byte) 10, 0);
        if (O000000o2 != -1) {
            return this.f1571O000000o.O00000o(O000000o2);
        }
        iql iql = new iql();
        iql iql2 = this.f1571O000000o;
        iql2.O000000o(iql, 0, Math.min(32L, iql2.O00000Oo));
        throw new EOFException("\\n not found: size=" + this.f1571O000000o.O00000Oo + " content=" + iql.O0000Ooo().O00000Oo() + "...");
    }

    public final short O0000Oo0() throws IOException {
        O000000o(2);
        return irb.O000000o(this.f1571O000000o.O0000O0o());
    }

    public final int O0000Oo() throws IOException {
        O000000o(4);
        return irb.O000000o(this.f1571O000000o.O0000OOo());
    }

    public final void O00000oo(long j) throws IOException {
        if (!this.O00000o0) {
            while (j > 0) {
                if (this.f1571O000000o.O00000Oo == 0 && this.O00000Oo.O000000o(this.f1571O000000o, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f1571O000000o.O00000Oo);
                this.f1571O000000o.O00000oo(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }
}
