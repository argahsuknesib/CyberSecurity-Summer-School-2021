package _m_j;

import java.nio.ByteBuffer;

public final class qe extends bwl {
    public static int O000000o(bwk bwk, boolean z, long j, short s, int i, short s2, short s3) {
        bwk.O00000Oo(6);
        bwk.O000000o(1, j);
        bwk.O00000o0(3, i);
        bwk.O000000o(5, s3);
        bwk.O000000o(4, s2);
        bwk.O000000o(2, s);
        if (bwk.O0000o00 || z) {
            bwk.O000000o(1, 0);
            ByteBuffer byteBuffer = bwk.f13337O000000o;
            int i2 = bwk.O00000Oo - 1;
            bwk.O00000Oo = i2;
            byteBuffer.put(i2, z ? (byte) 1 : 0);
            bwk.O00000o0(0);
        }
        return bwk.O00000Oo();
    }
}
