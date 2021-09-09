package _m_j;

import java.io.IOException;
import java.nio.charset.Charset;

public abstract class xm {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f2595O000000o = true;

    public abstract long O000000o() throws IOException;

    public abstract void O000000o(long j) throws IOException;

    public abstract void O000000o(byte[] bArr, int i, int i2) throws IOException;

    public abstract byte[] O000000o(int i) throws IOException;

    public abstract byte O00000Oo() throws IOException;

    public abstract boolean O00000Oo(long j) throws IOException;

    public abstract int O00000o0();

    public final short O00000o() throws IOException {
        return (short) (O00000Oo() & 255);
    }

    public final int O00000oO() throws IOException {
        byte O00000Oo;
        byte O00000Oo2;
        if (this.f2595O000000o) {
            O00000Oo = (O00000Oo() << 8) & 65280;
            O00000Oo2 = O00000Oo() & 255;
        } else {
            O00000Oo = O00000Oo() & 255;
            O00000Oo2 = 65280 & (O00000Oo() << 8);
        }
        return O00000Oo | O00000Oo2;
    }

    public final short O00000oo() throws IOException {
        short O00000Oo;
        short O00000Oo2;
        if (this.f2595O000000o) {
            O00000Oo = (((short) O00000Oo()) << 8) & -256;
            O00000Oo2 = ((short) O00000Oo()) & 255;
        } else {
            O00000Oo = ((short) O00000Oo()) & 255;
            O00000Oo2 = (((short) O00000Oo()) << 8) & -256;
        }
        return (short) (O00000Oo | O00000Oo2);
    }

    public final long O0000O0o() throws IOException {
        if (this.f2595O000000o) {
            return (4278190080L & (((long) O00000Oo()) << 24)) | (16711680 & (((long) O00000Oo()) << 16)) | ((((long) O00000Oo()) << 8) & 65280) | (((long) O00000Oo()) & 255);
        }
        long O00000Oo = 255 & ((long) O00000Oo());
        long O00000Oo2 = 16711680 & (((long) O00000Oo()) << 16);
        return (4278190080L & (((long) O00000Oo()) << 24)) | O00000Oo2 | (65280 & (((long) O00000Oo()) << 8)) | O00000Oo;
    }

    public final int O0000OOo() throws IOException {
        byte O00000Oo;
        byte O00000Oo2;
        if (this.f2595O000000o) {
            O00000Oo = ((O00000Oo() << 24) & -16777216) | ((O00000Oo() << 16) & 16711680) | ((O00000Oo() << 8) & 65280);
            O00000Oo2 = O00000Oo() & 255;
        } else {
            O00000Oo = (O00000Oo() & 255) | (65280 & (O00000Oo() << 8)) | (16711680 & (O00000Oo() << 16));
            O00000Oo2 = -16777216 & (O00000Oo() << 24);
        }
        return O00000Oo | O00000Oo2;
    }

    public final long O0000Oo0() throws IOException {
        if (this.f2595O000000o) {
            return (-72057594037927936L & (((long) O00000Oo()) << 56)) | (71776119061217280L & (((long) O00000Oo()) << 48)) | ((((long) O00000Oo()) << 40) & 280375465082880L) | ((((long) O00000Oo()) << 32) & 1095216660480L) | ((((long) O00000Oo()) << 24) & 4278190080L) | ((((long) O00000Oo()) << 16) & 16711680) | ((((long) O00000Oo()) << 8) & 65280) | (((long) O00000Oo()) & 255);
        }
        return ((((long) O00000Oo()) << 8) & 65280) | (((long) O00000Oo()) & 255) | ((((long) O00000Oo()) << 16) & 16711680) | ((((long) O00000Oo()) << 24) & 4278190080L) | (1095216660480L & (((long) O00000Oo()) << 32)) | (280375465082880L & (((long) O00000Oo()) << 40)) | (71776119061217280L & (((long) O00000Oo()) << 48)) | ((((long) O00000Oo()) << 56) & -72057594037927936L);
    }

    public final String O00000Oo(int i) throws IOException {
        return new String(O000000o(i));
    }

    public final xv O000000o(int i, Charset charset) throws IOException {
        return new xv(O000000o(i), charset);
    }

    public final String O00000Oo(int i, Charset charset) throws IOException {
        return O00000o0(i, charset).toString();
    }

    public final xv O00000o0(int i, Charset charset) throws IOException {
        return new xv(O00000o0(i), charset);
    }

    public final byte[] O00000o0(int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            byte O00000Oo = O00000Oo();
            bArr[i2] = O00000Oo;
            if (O00000Oo == 0) {
                break;
            }
            i2++;
        }
        if (i2 == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        if (i2 > 0) {
            System.arraycopy(bArr, 0, bArr2, 0, i2);
        }
        return bArr2;
    }
}
