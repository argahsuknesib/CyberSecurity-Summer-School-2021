package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class rx extends bwl {
    private rv O000000o(rv rvVar, int i) {
        int O00000o0 = O00000o0(4);
        if (O00000o0 != 0) {
            return rvVar.O000000o(O00000o(O00000oo(O00000o0) + (i * 4)), this.O00000o0);
        }
        return null;
    }

    private rv O00000Oo(rv rvVar, int i) {
        int O00000o0 = O00000o0(6);
        if (O00000o0 != 0) {
            return rvVar.O000000o(O00000o(O00000oo(O00000o0) + (i * 4)), this.O00000o0);
        }
        return null;
    }

    public final int O000000o() {
        int O00000o0 = O00000o0(4);
        if (O00000o0 != 0) {
            return O00000oO(O00000o0);
        }
        return 0;
    }

    public final rv O000000o(int i) {
        return O000000o(new rv(), i);
    }

    public final int O00000Oo() {
        int O00000o0 = O00000o0(6);
        if (O00000o0 != 0) {
            return O00000oO(O00000o0);
        }
        return 0;
    }

    public final rv O00000Oo(int i) {
        return O00000Oo(new rv(), i);
    }

    public static rx O000000o(ByteBuffer byteBuffer) {
        rx rxVar = new rx();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        rxVar.O00000Oo = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        rxVar.O00000o0 = byteBuffer;
        return rxVar;
    }
}
