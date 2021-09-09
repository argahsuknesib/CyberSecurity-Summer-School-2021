package _m_j;

import java.nio.ByteBuffer;

public final class jkx {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f1913O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String O000000o(byte[] bArr) {
        return O000000o(bArr, 0);
    }

    public static String O000000o(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        StringBuilder sb = new StringBuilder();
        while (duplicate.remaining() > 0) {
            byte b = duplicate.get();
            sb.append(f1913O000000o[(b & 240) >>> 4]);
            sb.append(f1913O000000o[b & 15]);
        }
        return sb.toString();
    }

    public static String O000000o(byte[] bArr, int i) {
        int length = bArr.length;
        char[] cArr = new char[((length << 1) + (i > 0 ? length / i : 0))];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i > 0 && i3 % i == 0 && i2 > 0) {
                cArr[i2] = '-';
                i2++;
            }
            int i4 = i2 + 1;
            char[] cArr2 = f1913O000000o;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & 15];
        }
        return new String(cArr);
    }
}
