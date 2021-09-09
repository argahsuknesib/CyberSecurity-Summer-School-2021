package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class xn extends xm {
    static final /* synthetic */ boolean O00000o0 = (!xn.class.desiredAssertionStatus());
    public long O00000Oo;
    private final InputStream O00000o;

    public final long O000000o() {
        return this.O00000Oo;
    }

    public xn(InputStream inputStream) {
        if (inputStream != null) {
            this.O00000o = inputStream;
            this.O00000Oo = 0;
            return;
        }
        throw new NullPointerException();
    }

    public final byte O00000Oo() throws IOException {
        int read = this.O00000o.read();
        if (read != -1) {
            this.O00000Oo++;
            return (byte) read;
        }
        throw new EOFException("End of data reached.");
    }

    public final byte[] O000000o(int i) throws IOException {
        byte[] bArr = new byte[i];
        O000000o(bArr, 0, i);
        return bArr;
    }

    public final void O000000o(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 != i2) {
            int read = this.O00000o.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                i3 += read;
                if (!O00000o0 && i3 > i2) {
                    throw new AssertionError();
                }
            } else {
                throw new EOFException("End of data reached.");
            }
        }
        this.O00000Oo += (long) i3;
    }

    public final void O000000o(long j) throws IOException {
        if (j >= 0) {
            long O00000o02 = O00000o0(j);
            if (O00000o02 != j) {
                throw new EOFException(String.format("Unable to skip. Requested %d bytes but skipped %d.", Long.valueOf(j), Long.valueOf(O00000o02)));
            }
            return;
        }
        throw new IllegalArgumentException("n must be zero or greater.");
    }

    public final boolean O00000Oo(long j) throws IOException {
        if (j >= 0) {
            return O00000o0(j) == j;
        }
        throw new IllegalArgumentException("n must be zero or greater.");
    }

    public final int O00000o0() {
        try {
            return this.O00000o.available();
        } catch (IOException unused) {
            return 0;
        }
    }

    private long O00000o0(long j) throws IOException {
        long j2 = 0;
        while (j2 != j) {
            long skip = this.O00000o.skip(j - j2);
            if (O00000o0 || skip >= 0) {
                j2 += skip;
                if (skip == 0) {
                    break;
                }
            } else {
                throw new AssertionError();
            }
        }
        this.O00000Oo += j2;
        return j2;
    }
}
