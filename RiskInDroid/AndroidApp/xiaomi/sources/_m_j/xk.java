package _m_j;

import com.drew.lang.BufferBoundsException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class xk extends xj {
    static final /* synthetic */ boolean O00000Oo = (!xk.class.desiredAssertionStatus());
    private final int O00000o;
    private final InputStream O00000o0;
    private final ArrayList<byte[]> O00000oO;
    private boolean O00000oo;
    private long O0000O0o;

    public xk(InputStream inputStream) {
        this(inputStream, -1);
    }

    public xk(InputStream inputStream, long j) {
        this.O00000oO = new ArrayList<>();
        if (inputStream != null) {
            this.O00000o = 2048;
            this.O00000o0 = inputStream;
            this.O0000O0o = j;
            return;
        }
        throw new NullPointerException();
    }

    public final long O000000o() throws IOException {
        long j = this.O0000O0o;
        if (j != -1) {
            return j;
        }
        O00000Oo(Integer.MAX_VALUE, 1);
        if (O00000Oo || this.O00000oo) {
            return this.O0000O0o;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, int i2) throws IOException {
        if (i < 0) {
            throw new BufferBoundsException(String.format("Attempt to read from buffer using a negative index (%d)", Integer.valueOf(i)));
        } else if (i2 < 0) {
            throw new BufferBoundsException("Number of requested bytes must be zero or greater");
        } else if ((((long) i) + ((long) i2)) - 1 > 2147483647L) {
            throw new BufferBoundsException(String.format("Number of requested bytes summed with starting index exceed maximum range of signed 32 bit integers (requested index: %d, requested count: %d)", Integer.valueOf(i), Integer.valueOf(i2)));
        } else if (O00000Oo(i, i2)) {
        } else {
            if (O00000Oo || this.O00000oo) {
                throw new BufferBoundsException(i, i2, this.O0000O0o);
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O00000Oo(int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0) {
            return false;
        }
        long j = (((long) i) + ((long) i2)) - 1;
        if (j > 2147483647L) {
            return false;
        }
        int i4 = (int) j;
        if (this.O00000oo) {
            return ((long) i4) < this.O0000O0o;
        }
        int i5 = i4 / this.O00000o;
        while (i5 >= this.O00000oO.size()) {
            if (O00000Oo || !this.O00000oo) {
                byte[] bArr = new byte[this.O00000o];
                int i6 = 0;
                while (!this.O00000oo && i6 != (i3 = this.O00000o)) {
                    int read = this.O00000o0.read(bArr, i6, i3 - i6);
                    if (read == -1) {
                        this.O00000oo = true;
                        int size = (this.O00000oO.size() * this.O00000o) + i6;
                        long j2 = this.O0000O0o;
                        if (j2 == -1) {
                            this.O0000O0o = (long) size;
                        } else if (j2 != ((long) size) && !O00000Oo) {
                            throw new AssertionError();
                        }
                        if (((long) i4) >= this.O0000O0o) {
                            this.O00000oO.add(bArr);
                            return false;
                        }
                    } else {
                        i6 += read;
                    }
                }
                this.O00000oO.add(bArr);
            } else {
                throw new AssertionError();
            }
        }
        return true;
    }

    public final byte O000000o(int i) throws IOException {
        if (O00000Oo || i >= 0) {
            int i2 = this.O00000o;
            int i3 = i / i2;
            return this.O00000oO.get(i3)[i % i2];
        }
        throw new AssertionError();
    }

    public final byte[] O00000o0(int i, int i2) throws IOException {
        O000000o(i, i2);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i2 != 0) {
            int i4 = this.O00000o;
            int i5 = i / i4;
            int i6 = i % i4;
            int min = Math.min(i2, i4 - i6);
            System.arraycopy(this.O00000oO.get(i5), i6, bArr, i3, min);
            i2 -= min;
            i += min;
            i3 += min;
        }
        return bArr;
    }
}
