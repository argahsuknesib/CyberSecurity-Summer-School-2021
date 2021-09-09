package _m_j;

import com.drew.lang.BufferBoundsException;
import java.io.IOException;

public final class xc extends xj {
    private final byte[] O00000Oo;
    private final int O00000o0;

    public xc(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private xc(byte[] bArr, byte b) {
        if (bArr != null) {
            this.O00000Oo = bArr;
            this.O00000o0 = 0;
            return;
        }
        throw new NullPointerException();
    }

    public final long O000000o() {
        return (long) (this.O00000Oo.length - this.O00000o0);
    }

    public final byte O000000o(int i) throws IOException {
        O000000o(i, 1);
        return this.O00000Oo[i + this.O00000o0];
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, int i2) throws IOException {
        if (!O00000Oo(i, i2)) {
            throw new BufferBoundsException(i + this.O00000o0, i2, (long) this.O00000Oo.length);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O00000Oo(int i, int i2) throws IOException {
        return i2 >= 0 && i >= 0 && (((long) i) + ((long) i2)) - 1 < O000000o();
    }

    public final byte[] O00000o0(int i, int i2) throws IOException {
        O000000o(i, i2);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.O00000Oo, i + this.O00000o0, bArr, 0, i2);
        return bArr;
    }
}
