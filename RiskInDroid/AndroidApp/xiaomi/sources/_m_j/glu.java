package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class glu extends gls {

    /* renamed from: O000000o  reason: collision with root package name */
    public byte[] f17996O000000o;
    public int O00000Oo;

    public final String O000000o() {
        return "single_ctr";
    }

    public glu(int i, byte[] bArr) {
        this.f17996O000000o = bArr;
        this.O00000Oo = i;
    }

    public final byte[] O00000Oo() {
        ByteBuffer order = ByteBuffer.allocate(this.f17996O000000o.length + 4).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 2);
        order.put((byte) this.O00000Oo);
        order.put(this.f17996O000000o);
        return order.array();
    }
}
