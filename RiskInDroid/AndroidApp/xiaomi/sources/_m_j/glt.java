package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class glt extends gls {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17995O000000o;
    private final byte[] O00000Oo = new byte[4];

    public final String O000000o() {
        return "single_ack";
    }

    public glt(int i) {
        this.f17995O000000o = i;
    }

    public final byte[] O00000Oo() {
        ByteBuffer order = ByteBuffer.wrap(this.O00000Oo).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 3);
        order.put((byte) this.f17995O000000o);
        return order.array();
    }
}
