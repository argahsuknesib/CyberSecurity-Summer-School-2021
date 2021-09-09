package _m_j;

public final class jlc {
    public static long[] O000000o(long[] jArr, long... jArr2) {
        if (jArr == null) {
            jArr = new long[0];
        }
        long[] jArr3 = new long[(jArr.length + 1)];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, 1);
        return jArr3;
    }

    public static int[] O000000o(int[] iArr, int... iArr2) {
        if (iArr == null) {
            iArr = new int[0];
        }
        int[] iArr3 = new int[(iArr.length + 1)];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, 1);
        return iArr3;
    }

    public static byte[] O000000o(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] bArr3 = new byte[(bArr.length + 1)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, 1);
        return bArr3;
    }
}
