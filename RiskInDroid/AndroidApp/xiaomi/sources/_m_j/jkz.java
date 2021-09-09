package _m_j;

import java.nio.ByteBuffer;

public final class jkz {
    public static long O000000o(ByteBuffer byteBuffer, int i) {
        int O000000o2;
        if (i == 1) {
            O000000o2 = jky.O000000o(byteBuffer.get());
        } else if (i == 2) {
            O000000o2 = jky.O00000o0(byteBuffer);
        } else if (i == 3) {
            O000000o2 = jky.O00000Oo(byteBuffer);
        } else if (i == 4) {
            return jky.O000000o(byteBuffer);
        } else {
            if (i == 8) {
                return jky.O00000oo(byteBuffer);
            }
            throw new RuntimeException("I don't know how to read " + i + " bytes");
        }
        return (long) O000000o2;
    }
}
