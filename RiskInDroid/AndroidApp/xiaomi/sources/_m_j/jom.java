package _m_j;

import _m_j.jol;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class jom extends jol.O00000Oo {
    private final joo O0000Oo;

    public jom(boolean z, joo joo) throws IOException {
        this.f1997O000000o = z;
        this.O0000Oo = joo;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.O00000Oo = joo.O00000o0(allocate, 16);
        this.O00000o0 = joo.O00000Oo(allocate, 28);
        this.O00000o = joo.O00000Oo(allocate, 32);
        this.O00000oO = joo.O00000o0(allocate, 42);
        this.O00000oo = joo.O00000o0(allocate, 44);
        this.O0000O0o = joo.O00000o0(allocate, 46);
        this.O0000OOo = joo.O00000o0(allocate, 48);
        this.O0000Oo0 = joo.O00000o0(allocate, 50);
    }

    public final jol.O00000o O000000o() throws IOException {
        return new jor(this.O0000Oo, this, 0);
    }

    public final jol.O00000o0 O000000o(long j) throws IOException {
        return new jop(this.O0000Oo, this, j);
    }

    public final jol.O000000o O000000o(long j, int i) throws IOException {
        return new joj(this.O0000Oo, this, j, i);
    }
}
