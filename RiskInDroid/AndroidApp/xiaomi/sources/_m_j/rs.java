package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class rs {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ru f2443O000000o;
    private ByteBuffer O00000Oo = ByteBuffer.allocate(1000);

    protected rs() {
        this.O00000Oo.order(ByteOrder.LITTLE_ENDIAN);
        this.f2443O000000o = new ru(this.O00000Oo);
    }

    public final rs O000000o() {
        this.f2443O000000o.O000000o(this.O00000Oo);
        return this;
    }
}
