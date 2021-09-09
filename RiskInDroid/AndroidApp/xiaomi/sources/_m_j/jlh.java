package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public final class jlh {
    public static byte[] O000000o(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) (mostSignificantBits >>> ((7 - i) * 8)));
        }
        for (int i2 = 8; i2 < 16; i2++) {
            bArr[i2] = (byte) ((int) (leastSignificantBits >>> ((7 - i2) * 8)));
        }
        return bArr;
    }

    public static UUID O000000o(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return new UUID(wrap.getLong(), wrap.getLong());
    }
}
