package _m_j;

import _m_j.jol;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class jok extends jol.O000000o {
    public jok(joo joo, jol.O00000Oo o00000Oo, long j, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(o00000Oo.f1997O000000o ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 16));
        this.f1996O000000o = joo.O000000o(allocate, j2);
        this.O00000Oo = joo.O000000o(allocate, j2 + 8);
    }
}
