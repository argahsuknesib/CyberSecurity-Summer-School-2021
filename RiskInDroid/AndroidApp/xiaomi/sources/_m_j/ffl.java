package _m_j;

import com.xiaomi.smarthome.library.log.LogType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ffl {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f16222O000000o;
    public String O00000Oo;
    byte[] O00000o = null;
    public int O00000o0 = -1;

    public static ffl O000000o(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        byte b = order.get();
        int i = order.get();
        if (b == 255) {
            byte b2 = order.get();
            byte b3 = order.get();
            LogType logType = LogType.BLUETOOTH;
            gsy.O00000o0(logType, "MCU-EVENT", " Parse value fail, opcode= " + ((int) b2) + ",errorCode=" + ((int) b3));
            return new ffl(b3, b2, null);
        }
        byte[] bArr2 = new byte[i];
        order.get(bArr2);
        return new ffl(0, b, bArr2);
    }

    private ffl(int i, int i2, byte[] bArr) {
        this.f16222O000000o = i2;
        this.O00000o0 = i;
        this.O00000o = bArr;
        this.O00000Oo = new String(bArr);
    }
}
