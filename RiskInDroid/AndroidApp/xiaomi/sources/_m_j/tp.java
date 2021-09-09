package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class tp {

    /* renamed from: O000000o  reason: collision with root package name */
    protected tr f2507O000000o = new tr(this.O00000Oo);
    private ByteBuffer O00000Oo;

    protected tp(int i) {
        this.O00000Oo = ByteBuffer.allocate(i);
        this.O00000Oo.order(ByteOrder.LITTLE_ENDIAN);
    }

    public final tp O000000o() {
        this.f2507O000000o.O000000o(this.O00000Oo);
        return this;
    }
}
