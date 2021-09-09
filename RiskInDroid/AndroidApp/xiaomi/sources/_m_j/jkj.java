package _m_j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public final class jkj extends OutputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    protected byte[] f1904O000000o;
    protected int O00000Oo;
    protected long O00000o0;

    public final void close() throws IOException {
    }

    public jkj() {
        this((byte) 0);
    }

    private jkj(byte b) {
        this.O00000o0 = 0;
        this.f1904O000000o = new byte[32];
    }

    public final byte[] O000000o(long j, int i) {
        byte[] bArr = new byte[i];
        try {
            System.arraycopy(this.f1904O000000o, jkv.O000000o(j - this.O00000o0), bArr, 0, i);
            return bArr;
        } catch (ArrayIndexOutOfBoundsException e) {
            PrintStream printStream = System.out;
            printStream.println("start: " + j + " count: " + i + " startOffset:" + this.O00000o0 + " count:" + i + " len(buf):" + this.f1904O000000o.length + " (start - startOffset):" + (j - this.O00000o0));
            throw e;
        }
    }

    private void O000000o(int i) {
        byte[] bArr = this.f1904O000000o;
        if (i - bArr.length > 0) {
            int length = bArr.length << 1;
            if (length - i < 0) {
                length = i;
            }
            if (length < 0) {
                if (i >= 0) {
                    length = Integer.MAX_VALUE;
                } else {
                    throw new OutOfMemoryError();
                }
            }
            this.f1904O000000o = Arrays.copyOf(this.f1904O000000o, length);
        }
    }

    public final synchronized void write(int i) {
        O000000o(this.O00000Oo + 1);
        this.f1904O000000o[this.O00000Oo] = (byte) i;
        this.O00000Oo++;
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (i >= 0) {
            if (i <= bArr.length && i2 >= 0 && (i + i2) - bArr.length <= 0) {
                O000000o(this.O00000Oo + i2);
                System.arraycopy(bArr, i, this.f1904O000000o, this.O00000Oo, i2);
                this.O00000Oo += i2;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public final synchronized String toString() {
        return new String(this.f1904O000000o, 0, this.O00000Oo);
    }

    public final synchronized long O000000o() {
        return this.O00000o0 + ((long) this.O00000Oo);
    }

    public final synchronized void O000000o(long j) {
        System.arraycopy(this.f1904O000000o, jkv.O000000o(j - this.O00000o0), this.f1904O000000o, 0, jkv.O000000o(((long) this.f1904O000000o.length) - (j - this.O00000o0)));
        this.O00000Oo = (int) (((long) this.O00000Oo) - (j - this.O00000o0));
        this.O00000o0 = j;
    }
}
