package _m_j;

import com.xiaomi.push.jw;

public abstract class esk {
    public abstract int O000000o(byte[] bArr, int i, int i2);

    public void O000000o(int i) {
    }

    public byte[] O000000o() {
        return null;
    }

    public int O00000Oo() {
        return 0;
    }

    public abstract void O00000Oo(byte[] bArr, int i, int i2);

    public int O00000o0() {
        return -1;
    }

    public final int O00000o0(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int O000000o2 = O000000o(bArr, i3 + 0, i2 - i3);
            if (O000000o2 > 0) {
                i3 += O000000o2;
            } else {
                throw new jw("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
        }
        return i3;
    }
}
