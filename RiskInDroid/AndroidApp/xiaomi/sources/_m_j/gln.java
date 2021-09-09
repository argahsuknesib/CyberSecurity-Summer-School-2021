package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class gln extends gls {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17990O000000o;
    public int O00000Oo;
    private final byte[] O00000o0 = new byte[6];

    public final String O000000o() {
        return "ctr";
    }

    public gln(int i, int i2) {
        this.f17990O000000o = i;
        this.O00000Oo = i2;
    }

    public final byte[] O00000Oo() {
        ByteBuffer order = ByteBuffer.wrap(this.O00000o0).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 0);
        order.put((byte) this.O00000Oo);
        order.putShort((short) this.f17990O000000o);
        return order.array();
    }

    public final String toString() {
        return "FlowPacket{frameCount=" + this.f17990O000000o + "packageType=" + this.O00000Oo + '}';
    }
}
