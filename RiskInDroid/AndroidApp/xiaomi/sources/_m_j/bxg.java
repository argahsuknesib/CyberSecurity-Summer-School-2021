package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class bxg {
    public static short[] O000000o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        short[] sArr = new short[(bArr.length / 2)];
        ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
        return sArr;
    }

    public static byte[] O000000o(short s) {
        return new byte[]{(byte) s, (byte) (s >>> 8)};
    }
}
