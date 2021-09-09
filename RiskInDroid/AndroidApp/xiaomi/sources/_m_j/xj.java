package _m_j;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class xj {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f2594O000000o = true;

    public abstract byte O000000o(int i) throws IOException;

    public abstract long O000000o() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i, int i2) throws IOException;

    /* access modifiers changed from: protected */
    public abstract boolean O00000Oo(int i, int i2) throws IOException;

    public abstract byte[] O00000o0(int i, int i2) throws IOException;

    public final boolean O00000Oo(int i) throws IOException {
        int i2 = i / 8;
        O000000o(i2, 1);
        if (((O000000o(i2) >> (i % 8)) & 1) == 1) {
            return true;
        }
        return false;
    }

    public final short O00000o0(int i) throws IOException {
        O000000o(i, 1);
        return (short) (O000000o(i) & 255);
    }

    public final byte O00000o(int i) throws IOException {
        O000000o(i, 1);
        return O000000o(i);
    }

    public final int O00000oO(int i) throws IOException {
        byte O000000o2;
        byte O000000o3;
        O000000o(i, 2);
        if (this.f2594O000000o) {
            O000000o2 = (O000000o(i) << 8) & 65280;
            O000000o3 = O000000o(i + 1);
        } else {
            O000000o2 = (O000000o(i + 1) << 8) & 65280;
            O000000o3 = O000000o(i);
        }
        return (O000000o3 & 255) | O000000o2;
    }

    public final short O00000oo(int i) throws IOException {
        short O000000o2;
        byte O000000o3;
        O000000o(i, 2);
        if (this.f2594O000000o) {
            O000000o2 = (((short) O000000o(i)) << 8) & -256;
            O000000o3 = O000000o(i + 1);
        } else {
            O000000o2 = (((short) O000000o(i + 1)) << 8) & -256;
            O000000o3 = O000000o(i);
        }
        return (short) ((((short) O000000o3) & 255) | O000000o2);
    }

    public final int O0000O0o(int i) throws IOException {
        byte O000000o2;
        byte O000000o3;
        O000000o(i, 3);
        if (this.f2594O000000o) {
            O000000o2 = ((O000000o(i) << 16) & 16711680) | (65280 & (O000000o(i + 1) << 8));
            O000000o3 = O000000o(i + 2);
        } else {
            O000000o2 = ((O000000o(i + 2) << 16) & 16711680) | (65280 & (O000000o(i + 1) << 8));
            O000000o3 = O000000o(i);
        }
        return (O000000o3 & 255) | O000000o2;
    }

    public final long O0000OOo(int i) throws IOException {
        long O000000o2;
        byte O000000o3;
        O000000o(i, 4);
        if (this.f2594O000000o) {
            long O000000o4 = 4278190080L & (((long) O000000o(i)) << 24);
            O000000o2 = (65280 & (((long) O000000o(i + 2)) << 8)) | (16711680 & (((long) O000000o(i + 1)) << 16)) | O000000o4;
            O000000o3 = O000000o(i + 3);
        } else {
            long O000000o5 = 4278190080L & (((long) O000000o(i + 3)) << 24);
            O000000o2 = (65280 & (((long) O000000o(i + 1)) << 8)) | (16711680 & (((long) O000000o(i + 2)) << 16)) | O000000o5;
            O000000o3 = O000000o(i);
        }
        return (255 & ((long) O000000o3)) | O000000o2;
    }

    public final int O0000Oo0(int i) throws IOException {
        byte O000000o2;
        byte O000000o3;
        O000000o(i, 4);
        if (this.f2594O000000o) {
            O000000o2 = ((O000000o(i) << 24) & -16777216) | (16711680 & (O000000o(i + 1) << 16)) | (65280 & (O000000o(i + 2) << 8));
            O000000o3 = O000000o(i + 3);
        } else {
            O000000o2 = ((O000000o(i + 3) << 24) & -16777216) | (16711680 & (O000000o(i + 2) << 16)) | (65280 & (O000000o(i + 1) << 8));
            O000000o3 = O000000o(i);
        }
        return (O000000o3 & 255) | O000000o2;
    }

    public final long O0000Oo(int i) throws IOException {
        long O000000o2;
        byte O000000o3;
        int i2 = i;
        O000000o(i2, 8);
        if (this.f2594O000000o) {
            O000000o2 = ((((long) O000000o(i)) << 56) & -72057594037927936L) | (71776119061217280L & (((long) O000000o(i2 + 1)) << 48)) | (280375465082880L & (((long) O000000o(i2 + 2)) << 40)) | (1095216660480L & (((long) O000000o(i2 + 3)) << 32)) | ((((long) O000000o(i2 + 4)) << 24) & 4278190080L) | ((((long) O000000o(i2 + 5)) << 16) & 16711680) | ((((long) O000000o(i2 + 6)) << 8) & 65280);
            O000000o3 = O000000o(i2 + 7);
        } else {
            O000000o2 = ((((long) O000000o(i2 + 7)) << 56) & -72057594037927936L) | (71776119061217280L & (((long) O000000o(i2 + 6)) << 48)) | (280375465082880L & (((long) O000000o(i2 + 5)) << 40)) | (1095216660480L & (((long) O000000o(i2 + 4)) << 32)) | ((((long) O000000o(i2 + 3)) << 24) & 4278190080L) | ((((long) O000000o(i2 + 2)) << 16) & 16711680) | ((((long) O000000o(i2 + 1)) << 8) & 65280);
            O000000o3 = O000000o(i);
        }
        return O000000o2 | (((long) O000000o3) & 255);
    }

    public final float O0000OoO(int i) throws IOException {
        double O000000o2;
        double d;
        O000000o(i, 4);
        if (this.f2594O000000o) {
            byte O000000o3 = (O000000o(i + 3) & 255) | ((O000000o(i + 2) & 255) << 8);
            O000000o2 = (double) ((float) (((O000000o(i) & 255) << 8) | (O000000o(i + 1) & 255)));
            double d2 = (double) O000000o3;
            Double.isNaN(d2);
            d = d2 / 65536.0d;
            Double.isNaN(O000000o2);
        } else {
            byte O000000o4 = (O000000o(i) & 255) | ((O000000o(i + 1) & 255) << 8);
            O000000o2 = (double) ((float) (((O000000o(i + 3) & 255) << 8) | (O000000o(i + 2) & 255)));
            double d3 = (double) O000000o4;
            Double.isNaN(d3);
            d = d3 / 65536.0d;
            Double.isNaN(O000000o2);
        }
        return (float) (O000000o2 + d);
    }

    public final float O0000Ooo(int i) throws IOException {
        return Float.intBitsToFloat(O0000Oo0(i));
    }

    public final double O0000o00(int i) throws IOException {
        return Double.longBitsToDouble(O0000Oo(i));
    }

    public final String O000000o(int i, int i2, Charset charset) throws IOException {
        return new String(O00000o0(i, i2), charset.name());
    }

    public final String O000000o(int i, int i2, String str) throws IOException {
        byte[] O00000o0 = O00000o0(i, i2);
        try {
            return new String(O00000o0, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(O00000o0);
        }
    }

    public final String O00000Oo(int i, int i2, Charset charset) throws IOException {
        return new String(O00000o(i, i2), charset.name());
    }

    public final byte[] O00000o(int i, int i2) throws IOException {
        byte[] O00000o0 = O00000o0(i, i2);
        int i3 = 0;
        while (i3 < O00000o0.length && O00000o0[i3] != 0) {
            i3++;
        }
        if (i3 == i2) {
            return O00000o0;
        }
        byte[] bArr = new byte[i3];
        if (i3 > 0) {
            System.arraycopy(O00000o0, 0, bArr, 0, i3);
        }
        return bArr;
    }
}
