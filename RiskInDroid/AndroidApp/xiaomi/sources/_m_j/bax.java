package _m_j;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class bax {
    public static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
        byte[] bArr3 = new byte[(wrap.limit() - wrap.position())];
        wrap.get(bArr3);
        ByteBuffer wrap3 = ByteBuffer.wrap(bArr3);
        IntBuffer asIntBuffer = wrap3.asIntBuffer();
        IntBuffer asIntBuffer2 = wrap2.asIntBuffer();
        if (asIntBuffer2.limit() == 4) {
            if (asIntBuffer.limit() >= 2) {
                int i = asIntBuffer.get(0);
                int limit = ((52 / asIntBuffer.limit()) + 6) * -1640531527;
                int limit2 = asIntBuffer.limit();
                do {
                    int i2 = (limit >>> 2) & 3;
                    int limit3 = asIntBuffer.limit() - 1;
                    while (limit3 > 0) {
                        int i3 = asIntBuffer.get(limit3 - 1);
                        i = asIntBuffer.get(limit3) - (((i ^ limit) + (i3 ^ asIntBuffer2.get((limit3 & 3) ^ i2))) ^ (((i3 >>> 5) ^ (i << 2)) + ((i >>> 3) ^ (i3 << 4))));
                        asIntBuffer.put(limit3, i);
                        limit3--;
                    }
                    int i4 = asIntBuffer.get(limit2 - 1);
                    i = asIntBuffer.get(0) - (((i ^ limit) + (asIntBuffer2.get(i2 ^ (limit3 & 3)) ^ i4)) ^ (((i4 >>> 5) ^ (i << 2)) + ((i >>> 3) ^ (i4 << 4))));
                    asIntBuffer.put(0, i);
                    limit += 1640531527;
                } while (limit != 0);
            }
            return wrap3.array();
        }
        throw new IllegalArgumentException("XXTEA needs a 128-bits key");
    }
}
