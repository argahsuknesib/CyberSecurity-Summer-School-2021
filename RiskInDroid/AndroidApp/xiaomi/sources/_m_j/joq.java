package _m_j;

import _m_j.jol;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class joq extends jol.O00000o0 {
    public joq(joo joo, jol.O00000Oo o00000Oo, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(o00000Oo.f1997O000000o ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = o00000Oo.O00000o0 + (j * ((long) o00000Oo.O00000oO));
        this.f1999O000000o = joo.O00000Oo(allocate, j2);
        this.O00000Oo = joo.O000000o(allocate, 8 + j2);
        this.O00000o0 = joo.O000000o(allocate, 16 + j2);
        this.O00000o = joo.O000000o(allocate, j2 + 40);
    }
}
