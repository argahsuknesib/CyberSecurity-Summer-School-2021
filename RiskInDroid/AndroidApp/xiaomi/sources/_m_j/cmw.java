package _m_j;

import com.miot.spec.SpecManager;
import com.miot.spec.exception.ProtocolVersionIsLowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class cmw {
    public static cmv O000000o(String str, byte[] bArr) throws ProtocolVersionIsLowException {
        cmv cmv;
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        short s = order.getShort();
        int O000000o2 = cnb.O000000o((int) order.getShort());
        int O00000Oo = cnb.O00000Oo(order.get());
        if (O00000Oo == 1) {
            cmv = new cna(str, s, O000000o2, O00000Oo);
        } else if (O00000Oo == 3) {
            cmv = new cmr(str, s, O000000o2, O00000Oo);
        } else if (O00000Oo == 6) {
            cmv = new cmo(str, s, O000000o2, O00000Oo);
        } else if (O00000Oo == 4) {
            cmv = new cmt(str, s, O000000o2, O00000Oo);
            SpecManager.O000000o.f5247O000000o.O000000o(str, cmv.O0000O0o);
        } else if (O00000Oo == 7) {
            cmv = new cmp(str, s, O000000o2, O00000Oo);
            SpecManager.O000000o.f5247O000000o.O000000o(str, cmv.O0000O0o);
        } else if (O00000Oo == 240) {
            cmu cmu = new cmu(str, s, O000000o2, O00000Oo);
            SpecManager.O000000o.f5247O000000o.O000000o(str, cmu.O0000O0o);
            return cmu;
        } else {
            cmv = null;
        }
        if (cmv == null) {
            cnd.O00000Oo("ReceivePacketParser", "parse byte[],opCode %d is not support", Integer.valueOf(O00000Oo));
        } else if (cmv.O0000O0o <= 2) {
            cmv.O000000o(order);
        } else {
            throw new ProtocolVersionIsLowException();
        }
        return cmv;
    }
}
