package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ffn {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f16224O000000o;
    private byte[] O00000Oo;

    public ffn(int i, byte[] bArr) throws Exception {
        if (bArr == null || bArr.length <= 17) {
            this.f16224O000000o = i;
            this.O00000Oo = bArr;
            return;
        }
        throw new Exception("params exceed max size 17");
    }

    public final byte[] O000000o() {
        byte[] bArr = this.O00000Oo;
        int length = bArr != null ? bArr.length + 3 : 3;
        ByteBuffer order = ByteBuffer.allocate(length).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort((short) this.f16224O000000o);
        order.put((byte) (length - 3));
        byte[] bArr2 = this.O00000Oo;
        if (bArr2 != null && bArr2.length > 0) {
            order.put(bArr2);
        }
        return order.array();
    }

    public final String toString() {
        return "DfuCommand{Command=" + this.f16224O000000o + '}';
    }
}
