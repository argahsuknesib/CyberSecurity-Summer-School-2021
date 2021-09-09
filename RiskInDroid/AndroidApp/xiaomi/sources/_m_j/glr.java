package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class glr extends gls {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f17992O000000o;
    protected byte[] O00000Oo;
    protected int O00000o;
    protected int O00000o0;
    protected byte[] O00000oO;

    public String O000000o() {
        return "mng";
    }

    public glr(int i, byte[] bArr) {
        this.f17992O000000o = i;
        this.O00000Oo = bArr;
    }

    public final int O00000o0() {
        return this.O00000o0;
    }

    public final int O00000o() {
        return this.O00000o;
    }

    public final int O00000oO() {
        return this.f17992O000000o;
    }

    public final byte[] O00000oo() {
        return this.O00000oO;
    }

    public final void O0000O0o() {
        ByteBuffer order = ByteBuffer.wrap(this.O00000Oo).order(ByteOrder.LITTLE_ENDIAN);
        if (this.f17992O000000o == 0) {
            this.O00000o0 = order.get();
            this.O00000o = order.get() & 255;
            return;
        }
        this.O00000oO = order.array();
    }

    public byte[] O00000Oo() {
        ByteBuffer order = ByteBuffer.allocate(this.O00000Oo.length + 4).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 4);
        order.put((byte) this.f17992O000000o);
        order.put(this.O00000Oo);
        return order.array();
    }
}
