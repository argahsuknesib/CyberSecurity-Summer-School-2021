package _m_j;

import _m_j.jol;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class joj extends jol.O000000o {
    public joj(joo joo, jol.O00000Oo o00000Oo, long j, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(o00000Oo.f1997O000000o ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 8));
        this.f1996O000000o = joo.O00000Oo(allocate, j2);
        this.O00000Oo = joo.O00000Oo(allocate, j2 + 4);
    }
}
