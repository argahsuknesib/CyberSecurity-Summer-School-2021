package _m_j;

import java.nio.ByteBuffer;

public final class cmo extends cmv {

    /* renamed from: O000000o  reason: collision with root package name */
    int f14127O000000o;

    public cmo(String str, int i, int i2, int i3) {
        super(str, i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(ByteBuffer byteBuffer) {
        this.f14127O000000o = cnb.O000000o((int) byteBuffer.getShort());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("DoActionRespPacket={");
        sb.append("frameLength=");
        sb.append(this.O0000OOo);
        sb.append(",tid=");
        sb.append(this.O0000Oo0);
        sb.append(",opcode=");
        sb.append(this.O00000oO);
        sb.append(",respCode=");
        sb.append(this.f14127O000000o);
        sb.append("}");
        return sb.toString();
    }
}
