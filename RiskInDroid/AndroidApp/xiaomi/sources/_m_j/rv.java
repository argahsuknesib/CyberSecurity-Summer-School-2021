package _m_j;

import java.nio.ByteBuffer;

public final class rv extends bwl {
    public final long O000000o() {
        int O00000o0 = O00000o0(4);
        if (O00000o0 != 0) {
            return this.O00000o0.getLong(O00000o0 + this.O00000Oo);
        }
        return 0;
    }

    public final int O00000Oo() {
        int O00000o0 = O00000o0(6);
        if (O00000o0 != 0) {
            return this.O00000o0.getInt(O00000o0 + this.O00000Oo);
        }
        return 0;
    }

    public final short O00000o() {
        int O00000o0 = O00000o0(10);
        if (O00000o0 != 0) {
            return this.O00000o0.getShort(O00000o0 + this.O00000Oo);
        }
        return 0;
    }

    public final int O00000o0() {
        int O00000o0 = O00000o0(8);
        if (O00000o0 != 0) {
            return this.O00000o0.getInt(O00000o0 + this.O00000Oo);
        }
        return 0;
    }

    public final byte O00000oO() {
        int O00000o0 = O00000o0(12);
        if (O00000o0 != 0) {
            return this.O00000o0.get(O00000o0 + this.O00000Oo);
        }
        return 0;
    }

    public final rv O000000o(int i, ByteBuffer byteBuffer) {
        this.O00000Oo = i;
        this.O00000o0 = byteBuffer;
        return this;
    }
}
