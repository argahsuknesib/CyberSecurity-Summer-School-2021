package _m_j;

import _m_j.jol;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class jon extends jol.O00000Oo {
    private final joo O0000Oo;

    public jon(boolean z, joo joo) throws IOException {
        this.f1997O000000o = z;
        this.O0000Oo = joo;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.O00000Oo = joo.O00000o0(allocate, 16);
        this.O00000o0 = joo.O000000o(allocate, 32);
        this.O00000o = joo.O000000o(allocate, 40);
        this.O00000oO = joo.O00000o0(allocate, 54);
        this.O00000oo = joo.O00000o0(allocate, 56);
        this.O0000O0o = joo.O00000o0(allocate, 58);
        this.O0000OOo = joo.O00000o0(allocate, 60);
        this.O0000Oo0 = joo.O00000o0(allocate, 62);
    }

    public final jol.O00000o O000000o() throws IOException {
        return new jos(this.O0000Oo, this, 0);
    }

    public final jol.O00000o0 O000000o(long j) throws IOException {
        return new joq(this.O0000Oo, this, j);
    }

    public final jol.O000000o O000000o(long j, int i) throws IOException {
        return new jok(this.O0000Oo, this, j, i);
    }
}
