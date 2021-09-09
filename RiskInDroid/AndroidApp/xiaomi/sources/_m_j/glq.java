package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class glq extends glr {
    public final String O000000o() {
        return "mng_ack";
    }

    public glq(int i, byte[] bArr) {
        super(i, bArr);
    }

    public final byte[] O00000Oo() {
        ByteBuffer order = ByteBuffer.allocate(this.O00000Oo.length + 4).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 5);
        order.put((byte) this.f17992O000000o);
        order.put(this.O00000Oo);
        return order.array();
    }
}
