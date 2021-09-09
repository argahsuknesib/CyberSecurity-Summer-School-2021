package _m_j;

import _m_j.gls;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class glo extends gls {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17991O000000o;
    public gls.O000000o O00000Oo;
    private final byte[] O00000o0;

    public final String O000000o() {
        return "data";
    }

    public glo(int i, gls.O000000o o000000o) {
        this.O00000o0 = new byte[20];
        this.f17991O000000o = i;
        this.O00000Oo = o000000o;
    }

    public glo(int i, byte[] bArr, int i2, int i3) {
        this(i, new gls.O000000o(bArr, i2, i3));
    }

    public final void O000000o(ByteBuffer byteBuffer) {
        byteBuffer.put(this.O00000Oo.f17993O000000o, this.O00000Oo.O00000Oo, this.O00000Oo.O000000o());
    }

    public final String toString() {
        return "DataPacket{seq=" + this.f17991O000000o + ", size=" + this.O00000Oo.O000000o() + '}';
    }

    public final byte[] O00000Oo() {
        ByteBuffer byteBuffer;
        int O000000o2 = this.O00000Oo.O000000o() + 2;
        if (O000000o2 == 20) {
            Arrays.fill(this.O00000o0, (byte) 0);
            byteBuffer = ByteBuffer.wrap(this.O00000o0).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            byteBuffer = ByteBuffer.allocate(O000000o2).order(ByteOrder.LITTLE_ENDIAN);
        }
        byteBuffer.putShort((short) this.f17991O000000o);
        O000000o(byteBuffer);
        return byteBuffer.array();
    }
}
