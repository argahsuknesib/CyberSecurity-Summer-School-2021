package _m_j;

import java.nio.ByteBuffer;

public final class jlb {
    public static void O000000o(long j, ByteBuffer byteBuffer, int i) {
        if (i == 1) {
            jla.O00000o(byteBuffer, (int) (j & 255));
        } else if (i == 2) {
            jla.O00000Oo(byteBuffer, (int) (j & 65535));
        } else if (i == 3) {
            jla.O000000o(byteBuffer, (int) (j & 16777215));
        } else if (i == 4) {
            jla.O00000Oo(byteBuffer, j);
        } else if (i == 8) {
            jla.O000000o(byteBuffer, j);
        } else {
            throw new RuntimeException("I don't know how to read " + i + " bytes");
        }
    }
}
