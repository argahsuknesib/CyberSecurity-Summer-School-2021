package _m_j;

import java.nio.ByteBuffer;

public final class dhs {
    public static boolean O000000o(int i, int i2) {
        return i == i2;
    }

    public static boolean O000000o(long j, long j2) {
        return j == j2;
    }

    public static boolean O000000o(boolean z, boolean z2) {
        return z == z2;
    }

    public static boolean O000000o(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static byte[] O000000o(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        return bArr;
    }

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
    }
}
