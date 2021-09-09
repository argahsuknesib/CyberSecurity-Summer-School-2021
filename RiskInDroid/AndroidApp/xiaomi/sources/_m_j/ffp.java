package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ffp extends ffm {
    int O00000Oo = -1;
    private int O00000o0 = -1;

    public ffp(byte[] bArr) {
        super(bArr);
        if (this.f16223O000000o.length >= 3) {
            ByteBuffer order = ByteBuffer.wrap(this.f16223O000000o).order(ByteOrder.LITTLE_ENDIAN);
            this.O00000Oo = order.get();
            this.O00000o0 = order.getShort();
        }
    }

    public final String toString() {
        return "DfuTransferCompleteEvent{Status=" + this.O00000Oo + "Index=" + this.O00000o0 + '}';
    }
}
