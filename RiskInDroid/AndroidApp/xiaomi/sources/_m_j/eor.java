package _m_j;

import com.xiaomi.push.c;
import com.xiaomi.push.d;
import java.io.IOException;

public abstract class eor {
    public abstract int O000000o();

    public abstract eor O000000o(elx elx);

    public final eor O000000o(byte[] bArr) {
        return O00000Oo(bArr, 0, bArr.length);
    }

    public abstract void O000000o(c cVar);

    public final void O000000o(byte[] bArr, int i, int i2) {
        try {
            c O000000o2 = c.O000000o(bArr, i, i2);
            O000000o(O000000o2);
            O000000o2.O00000Oo();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public abstract int O00000Oo();

    public final byte[] O00000o0() {
        byte[] bArr = new byte[O00000Oo()];
        O000000o(bArr, 0, bArr.length);
        return bArr;
    }

    public final eor O00000Oo(byte[] bArr, int i, int i2) {
        try {
            elx elx = new elx(bArr, i, i2);
            O000000o(elx);
            elx.O000000o(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }
}
