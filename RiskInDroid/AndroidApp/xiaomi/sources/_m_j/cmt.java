package _m_j;

import com.miot.spec.entity.SpecValueType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class cmt extends cmv {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<cmh> f14130O000000o = new ArrayList();

    public cmt(String str, int i, int i2, int i3) {
        super(str, i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(ByteBuffer byteBuffer) {
        int i;
        int O00000Oo = cnb.O00000Oo(byteBuffer.get());
        for (int i2 = 0; i2 < O00000Oo; i2++) {
            int O00000Oo2 = cnb.O00000Oo(byteBuffer.get());
            if (this.O0000O0o == 1) {
                i = cnb.O00000Oo(byteBuffer.get());
            } else {
                i = cnb.O000000o((int) byteBuffer.getShort());
            }
            short s = byteBuffer.getShort();
            int O000000o2 = O000000o(s);
            SpecValueType convert2ValueType = SpecValueType.convert2ValueType((65535 & s) >> 12);
            byte[] bArr = new byte[O000000o2];
            byteBuffer.get(bArr);
            this.f14130O000000o.add(cmh.O000000o(O00000Oo2, i, convert2ValueType, SpecValueType.convertBytes2Value(convert2ValueType, bArr)));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("PropertyChangedPacket={");
        sb.append("frameLength=");
        sb.append(this.O0000OOo);
        sb.append(",tid=");
        sb.append(this.O0000Oo0);
        sb.append(",opcode=");
        sb.append(this.O00000oO);
        List<cmh> list = this.f14130O000000o;
        if (list == null || list.isEmpty()) {
            sb.append(", property list size=0");
        } else {
            for (cmh cmh : this.f14130O000000o) {
                sb.append(",");
                sb.append(cmh.toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
