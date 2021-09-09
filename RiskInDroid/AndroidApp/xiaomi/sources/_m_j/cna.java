package _m_j;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class cna extends cmv {

    /* renamed from: O000000o  reason: collision with root package name */
    List<O000000o> f14133O000000o = new ArrayList();

    public cna(String str, int i, int i2, int i3) {
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
            this.f14133O000000o.add(new O000000o(O00000Oo2, i, cnb.O000000o((int) byteBuffer.getShort())));
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14134O000000o;
        public int O00000Oo;
        public int O00000o0;

        O000000o(int i, int i2, int i3) {
            this.f14134O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
        }

        public final String toString() {
            return String.format("resp property: siid=%d,piid=%d,status=%d", Integer.valueOf(this.f14134O000000o), Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("SetPropertyRespPacket={");
        sb.append("frameLength=");
        sb.append(this.O0000OOo);
        sb.append(",tid=");
        sb.append(this.O0000Oo0);
        sb.append(",opcode=");
        sb.append(this.O00000oO);
        List<O000000o> list = this.f14133O000000o;
        if (list == null || list.isEmpty()) {
            sb.append(",resp property size=0");
        } else {
            for (O000000o o000000o : this.f14133O000000o) {
                sb.append(",");
                sb.append(o000000o.toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
