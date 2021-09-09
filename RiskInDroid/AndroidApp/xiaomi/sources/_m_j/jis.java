package _m_j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class jis extends FilterInputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    int f1864O000000o = -1;
    int O00000Oo = -1;

    public final boolean markSupported() {
        return false;
    }

    public jis(InputStream inputStream) {
        super(inputStream);
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read == 3 && this.f1864O000000o == 0 && this.O00000Oo == 0) {
            this.f1864O000000o = -1;
            this.O00000Oo = -1;
            read = super.read();
        }
        this.f1864O000000o = this.O00000Oo;
        this.O00000Oo = read;
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            int read = read();
            if (read == -1) {
                return -1;
            }
            bArr[i] = (byte) read;
            int i3 = 1;
            while (i3 < i2) {
                try {
                    int read2 = read();
                    if (read2 == -1) {
                        break;
                    }
                    bArr[i + i3] = (byte) read2;
                    i3++;
                } catch (IOException unused) {
                }
            }
            return i3;
        }
    }
}
