package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ffo extends ffm {
    int O00000Oo = -1;
    byte[] O00000o = new byte[0];
    int O00000o0 = -1;

    public ffo(byte[] bArr) {
        super(bArr);
        if (this.f16223O000000o.length >= 2) {
            ByteBuffer order = ByteBuffer.wrap(this.f16223O000000o).order(ByteOrder.LITTLE_ENDIAN);
            this.O00000Oo = order.getShort();
            if (order.remaining() > 0) {
                this.O00000o0 = order.get();
                this.O00000o = new byte[order.remaining()];
                byte[] bArr2 = this.O00000o;
                if (bArr2.length > 0) {
                    order.get(bArr2);
                }
            }
        }
    }

    public final String toString() {
        return "DfuCommandCompleteEvent{Command Opcode=" + this.O00000Oo + "Status=" + this.O00000o0 + '}';
    }
}
