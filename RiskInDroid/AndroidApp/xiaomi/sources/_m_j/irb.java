package _m_j;

import java.nio.charset.Charset;

public final class irb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Charset f1577O000000o = Charset.forName("UTF-8");

    public static int O000000o(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static short O000000o(short s) {
        short s2 = s & 65535;
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    public static void O000000o(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static boolean O000000o(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 + 0;
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    public static void O000000o(Throwable th) {
        throw th;
    }
}
