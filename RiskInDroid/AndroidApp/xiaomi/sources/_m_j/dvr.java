package _m_j;

public final class dvr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f14976O000000o = {72, 76};
    public static final byte[] O00000Oo = {73, 67, 65, 77};
    public static final byte[] O00000o = {76, 79, 71, 84};
    public static final byte[] O00000o0 = {72, 76, 65, 77};
    public int O00000oO = 0;
    public byte[] O00000oo;
    private int O0000O0o = 0;
    private int O0000OOo = 5;

    private dvr(int i, int i2, int i3, byte[] bArr) {
        this.O00000oO = i;
        this.O0000O0o = i3;
        this.O00000oo = bArr;
        this.O0000OOo = i2;
    }

    public static byte[] O000000o(int i, int i2, byte[] bArr) {
        byte[] bArr2 = new byte[((i2 <= 0 ? 0 : i2) + 16)];
        dvp.O000000o(bArr2, 0, f14976O000000o, 1);
        dvp.O000000o(bArr2, 2, dvp.O00000Oo(5), 1);
        dvp.O000000o(bArr2, 4, dvp.O00000Oo(i), 1);
        if (bArr != null && i2 > 0) {
            dvp.O000000o(bArr2, 6, dvp.O00000Oo(bArr.length), 1);
            dvp.O000000o(bArr2, 16, bArr, i2 - 1);
        }
        return bArr2;
    }

    public static int O000000o(byte[] bArr, boolean z) {
        if (bArr.length < 16) {
            return -1;
        }
        int O000000o2 = dvp.O000000o(bArr, 6);
        if (!z && O000000o2 + 16 > bArr.length) {
            return -3;
        }
        return O000000o2;
    }

    public static dvr O000000o(byte[] bArr) {
        char c = 3;
        int i = -1;
        if (dvp.O000000o(O00000Oo, bArr, 3) || dvp.O000000o(O00000o0, bArr, 3)) {
            c = 2;
        } else if (dvp.O000000o(f14976O000000o, bArr, 1)) {
            c = 1;
        } else if (!dvp.O000000o(O00000o, bArr, 1)) {
            c = 65535;
        }
        if (c == 1) {
            int O000000o2 = O000000o(bArr, false);
            if (O000000o2 >= 0) {
                return new dvr(dvp.O000000o(bArr, 4), dvp.O000000o(bArr, 2), O000000o2, dvp.O000000o(bArr, 16, O000000o2 + 15));
            }
            return null;
        } else if (c != 2) {
            return null;
        } else {
            if (bArr.length < 23) {
                cki.O00000o("CamProtocolUtils", "checkLocalData: too short");
            } else {
                i = dvp.O000000o(bArr, 15);
                cki.O00000o("CamProtocolUtils", "checkLocalData: textLength=" + i + "  data length=" + bArr.length);
                if (i + 23 > bArr.length) {
                    i = -3;
                }
            }
            cki.O00000o("CamProtocolUtils", "getFromBytes: dataLength=".concat(String.valueOf(i)));
            if (i < 0) {
                return null;
            }
            int O000000o3 = dvp.O000000o(bArr, 4);
            byte b = bArr[6];
            cki.O00000o("CamProtocolUtils", "getFromBytes: code=".concat(String.valueOf(O000000o3)));
            return new dvr(O000000o3, b, i, dvp.O000000o(bArr, 23, i + 22));
        }
    }
}
