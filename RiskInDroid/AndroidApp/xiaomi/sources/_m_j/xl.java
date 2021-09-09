package _m_j;

import java.io.EOFException;
import java.io.IOException;

public final class xl extends xm {
    private final byte[] O00000Oo;
    private int O00000o0;

    public final long O000000o() {
        return (long) this.O00000o0;
    }

    public xl(byte[] bArr) {
        this(bArr, 0);
    }

    public xl(byte[] bArr, int i) {
        if (bArr != null) {
            this.O00000Oo = bArr;
            this.O00000o0 = i;
            return;
        }
        throw new NullPointerException();
    }

    public final byte O00000Oo() throws IOException {
        int i = this.O00000o0;
        byte[] bArr = this.O00000Oo;
        if (i < bArr.length) {
            this.O00000o0 = i + 1;
            return bArr[i];
        }
        throw new EOFException("End of data reached.");
    }

    public final byte[] O000000o(int i) throws IOException {
        int i2 = this.O00000o0;
        int i3 = i2 + i;
        byte[] bArr = this.O00000Oo;
        if (i3 <= bArr.length) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, i2, bArr2, 0, i);
            this.O00000o0 += i;
            return bArr2;
        }
        throw new EOFException("End of data reached.");
    }

    public final void O000000o(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.O00000o0;
        int i4 = i3 + i2;
        byte[] bArr2 = this.O00000Oo;
        if (i4 <= bArr2.length) {
            System.arraycopy(bArr2, i3, bArr, i, i2);
            this.O00000o0 += i2;
            return;
        }
        throw new EOFException("End of data reached.");
    }

    public final void O000000o(long j) throws IOException {
        if (j >= 0) {
            int i = this.O00000o0;
            if (((long) i) + j <= ((long) this.O00000Oo.length)) {
                this.O00000o0 = (int) (((long) i) + j);
                return;
            }
            throw new EOFException("End of data reached.");
        }
        throw new IllegalArgumentException("n must be zero or greater.");
    }

    public final boolean O00000Oo(long j) throws IOException {
        if (j >= 0) {
            this.O00000o0 = (int) (((long) this.O00000o0) + j);
            int i = this.O00000o0;
            byte[] bArr = this.O00000Oo;
            if (i <= bArr.length) {
                return true;
            }
            this.O00000o0 = bArr.length;
            return false;
        }
        throw new IllegalArgumentException("n must be zero or greater.");
    }

    public final int O00000o0() {
        return this.O00000Oo.length - this.O00000o0;
    }
}
