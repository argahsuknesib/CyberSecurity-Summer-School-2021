package _m_j;

public final class baw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f12757O000000o = {73, 67, 65, 77};
    public static final byte[] O00000Oo = {72, 76, 65, 77};
    private static byte[] O00000o = {73, 67, 65, 77, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final byte[] O00000o0 = {76, 79, 71, 84};
    private static final byte[] O00000oO = {72, 76};

    public static byte[] O000000o(int i, byte[] bArr, int i2) {
        byte[] bArr2;
        if (bArr == null || bArr.length == 0) {
            bArr2 = new byte[O00000o.length];
        } else {
            bArr2 = new byte[(O00000o.length + bArr.length)];
        }
        bat.O000000o(bArr2, O00000o);
        bArr2[6] = (byte) i2;
        byte[] O00000Oo2 = bat.O00000Oo(i);
        bat.O000000o(bArr2, 4, O00000Oo2, 0, 1);
        System.arraycopy(O00000Oo2, 0, bArr2, 4, 2);
        if (bArr != null && bArr.length > 0) {
            System.arraycopy(bat.O000000o(bArr.length), 0, bArr2, 15, 4);
            System.arraycopy(bArr, 0, bArr2, 23, bArr.length);
        }
        return bArr2;
    }

    public static Boolean O000000o(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = O00000o;
        if (length < bArr2.length) {
            return Boolean.FALSE;
        }
        if (!bat.O00000Oo(bArr2, bArr)) {
            return Boolean.FALSE;
        }
        byte[] bArr3 = new byte[4];
        boolean z = false;
        bat.O000000o(bArr3, 0, bArr, 15, 18);
        if (bat.O00000Oo(bArr3) + O00000o.length <= bArr.length) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
