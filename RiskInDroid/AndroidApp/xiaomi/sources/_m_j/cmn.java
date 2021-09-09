package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class cmn extends cmx {
    private cmg O00000Oo;
    private cmj O00000o0;

    public cmn(String str, cmg cmg, cmj cmj) {
        super(str, 5);
        this.O00000o = "DoActionPacket";
        this.O00000Oo = cmg;
        this.O00000o0 = cmj;
    }

    public final byte[] O000000o() {
        cmg cmg = this.O00000Oo;
        if (cmg == null) {
            O00000Oo("buildBytes, but action entity is null", new Object[0]);
            return new byte[0];
        }
        int size = cmg.O000000o().size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int i = 8;
        for (int i2 = 0; i2 < size; i2++) {
            cmh cmh = this.O00000Oo.O000000o().get(i2);
            ByteBuffer order = ByteBuffer.allocate(O00000Oo(cmh) + 4).order(ByteOrder.LITTLE_ENDIAN);
            order.putShort((short) cmh.O00000Oo);
            order.putShort((short) O000000o(cmh));
            O000000o(order, cmh.O00000o, cmh.O00000o0);
            byteBufferArr[i2] = order;
            i += order.capacity();
        }
        ByteBuffer order2 = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        order2.putShort((short) (i | 8192)).putShort((short) this.f14131O000000o).put((byte) 5).put((byte) this.O00000Oo.O00000Oo).put((byte) this.O00000Oo.f14124O000000o).put((byte) size);
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                order2.put(byteBufferArr[i3].array());
            }
        }
        return order2.array();
    }

    public final void O000000o(cmv cmv) {
        int i = ((cmo) cmv).f14127O000000o;
        cmj cmj = this.O00000o0;
        if (cmj == null) {
            return;
        }
        if (i == 0) {
            cmj.O000000o();
        } else {
            cmj.O000000o(i, "code from device spec code");
        }
    }

    public final void O000000o(int i, String str) {
        if (i == 0) {
            O000000o("addWriteCallbackCode write data to ble success", new Object[0]);
            return;
        }
        cmj cmj = this.O00000o0;
        if (cmj != null) {
            if (str == null) {
                str = "code from ble,write data to ble fail";
            }
            cmj.O000000o(i, str);
        }
    }
}
