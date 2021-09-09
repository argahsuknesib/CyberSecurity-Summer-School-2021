package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class fgd {

    /* renamed from: O000000o  reason: collision with root package name */
    byte[] f16255O000000o;
    ByteBuffer O00000Oo = ByteBuffer.wrap(this.f16255O000000o).order(ByteOrder.LITTLE_ENDIAN);

    public static int O000000o(int i, int i2, int i3) {
        return (i >> i2) & ((1 << ((i3 - i2) + 1)) - 1);
    }

    public static boolean O000000o(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    public fgd(fga fga) {
        this.f16255O000000o = fga.O00000o0;
    }

    public final int O000000o() {
        return this.O00000Oo.getShort() & 65535;
    }

    public final int O00000Oo() {
        return this.O00000Oo.get() & 255;
    }
}
