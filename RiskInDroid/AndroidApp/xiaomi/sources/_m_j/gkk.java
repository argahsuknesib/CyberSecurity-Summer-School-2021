package _m_j;

public final class gkk {
    public static boolean O000000o(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static void O000000o(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr2 != null && i >= 0) {
            while (i2 < bArr2.length && i < bArr.length) {
                bArr[i] = bArr2[i2];
                i++;
                i2++;
            }
        }
    }

    public static byte[] O000000o(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static byte[] O000000o(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) (j >>> (i * 8)));
        }
        return bArr;
    }

    public static String O00000Oo(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!O000000o(bArr)) {
            for (int i = 0; i < bArr.length; i++) {
                sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
            }
        }
        return sb.toString();
    }
}
