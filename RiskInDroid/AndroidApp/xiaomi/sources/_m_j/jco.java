package _m_j;

import org.apache.commons.compress.archivers.zip.ZipLong;

public abstract class jco {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f1763O000000o = ZipLong.O000000o(8448);

    public static int O000000o(byte b) {
        return b >= 0 ? b : b + 256;
    }

    public static byte[] O000000o(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            int i2 = length - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    public static byte O000000o(int i) {
        if (i <= 255 && i >= 0) {
            return i < 128 ? (byte) i : (byte) (i - 256);
        }
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + i + "]");
    }

    public static byte[] O00000Oo(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }
}
