package _m_j;

import java.io.IOException;
import java.io.InputStream;

public class jjg {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static int f1881O000000o;
    protected jiw O00000Oo = new jiw();
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    private InputStream O00000oo;

    public jjg(InputStream inputStream) throws IOException {
        this.O00000oo = inputStream;
        this.O00000o = inputStream.read();
        this.O00000oO = inputStream.read();
    }

    public final int O000000o() throws IOException {
        if (this.O00000o0 == 8) {
            O00000Oo();
            if (this.O00000o == -1) {
                return -1;
            }
        }
        int i = this.O00000o;
        int i2 = this.O00000o0;
        int i3 = (i >> (7 - i2)) & 1;
        this.O00000o0 = i2 + 1;
        jiw jiw = this.O00000Oo;
        char c = i3 == 0 ? '0' : '1';
        if (jiw.O00000Oo < jiw.f1869O000000o.length - 1) {
            jiw.f1869O000000o[jiw.O00000Oo] = c;
            jiw.O00000Oo++;
        }
        f1881O000000o++;
        return i3;
    }

    public final long O000000o(int i) throws IOException {
        if (i <= 64) {
            long j = 0;
            for (int i2 = 0; i2 < i; i2++) {
                j = (j << 1) | ((long) O000000o());
            }
            return j;
        }
        throw new IllegalArgumentException("Can not readByte more then 64 bit");
    }

    public void O00000Oo() throws IOException {
        this.O00000o = this.O00000oO;
        this.O00000oO = this.O00000oo.read();
        this.O00000o0 = 0;
    }

    public final long O00000o0() throws IOException {
        return O000000o(8 - this.O00000o0);
    }
}
