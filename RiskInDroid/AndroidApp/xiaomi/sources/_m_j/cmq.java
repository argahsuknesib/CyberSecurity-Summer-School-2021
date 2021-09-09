package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public final class cmq extends cmx {
    private List<cmh> O00000Oo;
    private cmk O00000o0;

    public cmq(String str, List<cmh> list, cmk cmk) {
        super(str, 2);
        this.O00000o = "GetPropertyPacket";
        this.O00000Oo = list;
        this.O00000o0 = cmk;
    }

    public final byte[] O000000o() {
        List<cmh> list = this.O00000Oo;
        if (list == null || list.isEmpty()) {
            return new byte[0];
        }
        int i = 6;
        int size = this.O00000Oo.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int i2 = 0;
        for (cmh next : this.O00000Oo) {
            ByteBuffer order = ByteBuffer.allocate(3).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) next.f14125O000000o);
            order.putShort((short) next.O00000Oo);
            byteBufferArr[i2] = order;
            i += order.capacity();
            i2++;
        }
        ByteBuffer order2 = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        order2.putShort((short) (i | 8192)).putShort((short) this.f14131O000000o).put((byte) 2).put((byte) size);
        for (int i3 = 0; i3 < size; i3++) {
            order2.put(byteBufferArr[i3].array());
        }
        return order2.array();
    }

    public final void O000000o(cmv cmv) {
        cmr cmr = (cmr) cmv;
        cmk cmk = this.O00000o0;
        if (cmk != null) {
            cmk.O000000o(cmr.f14129O000000o);
        }
    }

    public final void O000000o(int i, String str) {
        cmk cmk = this.O00000o0;
        if (cmk == null) {
            return;
        }
        if (i != 0) {
            cmk.O000000o(i, str);
        } else {
            O000000o("addWriteCallbackCode ,write data success ", new Object[0]);
        }
    }
}
