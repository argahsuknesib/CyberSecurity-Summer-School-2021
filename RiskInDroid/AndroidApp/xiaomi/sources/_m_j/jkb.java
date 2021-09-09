package _m_j;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public final class jkb {

    /* renamed from: O000000o  reason: collision with root package name */
    ByteBuffer f1894O000000o;
    public int O00000Oo;
    public int O00000o = O00000oO();
    public int O00000o0 = O00000oO();

    public jkb(ByteBuffer byteBuffer) {
        this.f1894O000000o = byteBuffer;
    }

    private int O00000oO() {
        try {
            byte b = this.f1894O000000o.get();
            return b < 0 ? b + 256 : b;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }

    private int O00000oo() throws IOException {
        if (this.O00000Oo == 8) {
            O000000o();
            if (this.O00000o0 == -1) {
                return -1;
            }
        }
        int i = this.O00000o0;
        int i2 = this.O00000Oo;
        int i3 = (i >> (7 - i2)) & 1;
        this.O00000Oo = i2 + 1;
        return i3;
    }

    public final void O000000o() throws IOException {
        this.O00000o0 = this.O00000o;
        this.O00000o = O00000oO();
        this.O00000Oo = 0;
    }

    public final int O00000Oo() throws IOException {
        int i = 0;
        while (O00000oo() == 0) {
            i++;
        }
        if (i > 0) {
            return (int) (((long) ((1 << i) - 1)) + O000000o(i));
        }
        return 0;
    }

    public final long O000000o(int i) throws IOException {
        if (i <= 64) {
            long j = 0;
            for (int i2 = 0; i2 < i; i2++) {
                j = (j << 1) | ((long) O00000oo());
            }
            return j;
        }
        throw new IllegalArgumentException("Can not readByte more then 64 bit");
    }

    public final boolean O00000o0() throws IOException {
        return O00000oo() != 0;
    }

    public final int O00000o() throws IOException {
        int O00000Oo2 = O00000Oo();
        int i = O00000Oo2 & 1;
        return ((O00000Oo2 >> 1) + i) * ((i << 1) - 1);
    }
}
