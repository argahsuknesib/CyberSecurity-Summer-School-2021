package _m_j;

import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class ihb {
    private static final int[][] O00000o0 = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: O000000o  reason: collision with root package name */
    final ErrorCorrectionLevel f1288O000000o;
    final byte O00000Oo;

    private ihb(int i) {
        this.f1288O000000o = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.O00000Oo = (byte) (i & 7);
    }

    static int O000000o(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    static ihb O00000Oo(int i, int i2) {
        ihb O00000o02 = O00000o0(i, i2);
        if (O00000o02 != null) {
            return O00000o02;
        }
        return O00000o0(i ^ 21522, i2 ^ 21522);
    }

    private static ihb O00000o0(int i, int i2) {
        int bitCount;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : O00000o0) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new ihb(iArr[1]);
            }
            int bitCount2 = Integer.bitCount(i ^ i5);
            if (bitCount2 < i3) {
                i4 = iArr[1];
                i3 = bitCount2;
            }
            if (i != i2 && (bitCount = Integer.bitCount(i5 ^ i2)) < i3) {
                i4 = iArr[1];
                i3 = bitCount;
            }
        }
        if (i3 <= 3) {
            return new ihb(i4);
        }
        return null;
    }

    public final int hashCode() {
        return (this.f1288O000000o.ordinal() << 3) | this.O00000Oo;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ihb)) {
            return false;
        }
        ihb ihb = (ihb) obj;
        if (this.f1288O000000o == ihb.f1288O000000o && this.O00000Oo == ihb.O00000Oo) {
            return true;
        }
        return false;
    }
}
