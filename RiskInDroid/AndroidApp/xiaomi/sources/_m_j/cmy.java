package _m_j;

import android.os.RemoteException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class cmy extends cmx {
    private cml O00000Oo;

    public cmy(String str, cml cml) {
        super(str, 240);
        this.O00000Oo = cml;
    }

    public final byte[] O000000o() {
        ByteBuffer order = ByteBuffer.allocate(5).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(8197).putShort((short) O00000o0()).put((byte) -16);
        return order.array();
    }

    public final void O000000o(cmv cmv) throws RemoteException {
        int i = cmv.O0000O0o;
        cml cml = this.O00000Oo;
        if (cml != null) {
            cml.O000000o(i);
        }
    }

    public final void O000000o(int i, String str) throws RemoteException {
        cml cml = this.O00000Oo;
        if (cml == null) {
            return;
        }
        if (i != 0) {
            cml.O000000o(i, str);
        } else {
            O000000o("addWriteCallbackCode write data success", new Object[0]);
        }
    }
}
