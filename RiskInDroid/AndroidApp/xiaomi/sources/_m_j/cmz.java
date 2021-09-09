package _m_j;

import _m_j.cna;
import com.miot.spec.entity.SpecValueType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public final class cmz extends cmx {
    private List<cmh> O00000Oo;
    private cmm O00000o0;

    public cmz(String str, List<cmh> list, cmm cmm) {
        super(str, 0);
        this.O00000o = "SetPropertyPacket";
        this.O00000Oo = list;
        this.O00000o0 = cmm;
    }

    public final byte[] O000000o() {
        List<cmh> list = this.O00000Oo;
        if (list == null || list.isEmpty()) {
            O00000Oo("buildBytes ,property list is null or empty", new Object[0]);
            return new byte[0];
        }
        int i = 6;
        int size = this.O00000Oo.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int i2 = 0;
        for (cmh next : this.O00000Oo) {
            SpecValueType specValueType = next.O00000o;
            Object obj = next.O00000o0;
            int i3 = next.f14125O000000o;
            int i4 = next.O00000Oo;
            int O000000o2 = O000000o(next);
            ByteBuffer order = ByteBuffer.allocate(O00000Oo(next) + 5).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) i3);
            order.putShort((short) i4);
            order.putShort((short) O000000o2);
            O000000o(order, specValueType, obj);
            byteBufferArr[i2] = order;
            i += order.capacity();
            i2++;
        }
        ByteBuffer order2 = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        order2.putShort((short) (i | 8192)).putShort((short) this.f14131O000000o).put((byte) 0).put((byte) size);
        for (int i5 = 0; i5 < size; i5++) {
            order2.put(byteBufferArr[i5].array());
        }
        return order2.array();
    }

    public final void O000000o(cmv cmv) {
        List<cna.O000000o> list = ((cna) cmv).f14133O000000o;
        for (cmh next : this.O00000Oo) {
            for (cna.O000000o next2 : list) {
                if (next2.f14134O000000o == next.f14125O000000o && next2.O00000Oo == next.O00000Oo) {
                    next.O00000oO = next2.O00000o0;
                }
            }
        }
        cmm cmm = this.O00000o0;
        if (cmm != null) {
            cmm.O000000o(this.O00000Oo);
        }
    }

    public final void O000000o(int i, String str) {
        cmm cmm = this.O00000o0;
        if (cmm == null) {
            return;
        }
        if (i != 0) {
            cmm.O000000o(i, str);
        } else {
            O000000o("addWriteCallbackCode write data success", new Object[0]);
        }
    }
}
