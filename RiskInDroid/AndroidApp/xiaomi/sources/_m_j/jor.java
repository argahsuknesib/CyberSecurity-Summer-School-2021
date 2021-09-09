package _m_j;

import _m_j.jol;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class jor extends jol.O00000o {
    public jor(joo joo, jol.O00000Oo o00000Oo, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(o00000Oo.f1997O000000o ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f1998O000000o = joo.O00000Oo(allocate, o00000Oo.O00000o + ((long) (o00000Oo.O0000O0o * 0)) + 28);
    }
}
