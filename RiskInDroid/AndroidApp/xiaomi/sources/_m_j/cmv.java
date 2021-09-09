package _m_j;

import java.nio.ByteBuffer;

public abstract class cmv extends cms {
    protected int O0000O0o;
    protected int O0000OOo;
    protected int O0000Oo0;

    protected static int O000000o(int i) {
        return i & 65535 & 4095;
    }

    /* access modifiers changed from: package-private */
    public abstract void O000000o(ByteBuffer byteBuffer);

    public cmv(String str, int i, int i2, int i3) {
        super(str);
        int i4 = 65535 & i;
        this.O0000OOo = i4 & 4095;
        this.O0000O0o = i4 >> 12;
        this.O0000Oo0 = i2;
        this.O00000oO = i3;
    }

    public final int O000000o() {
        return this.O00000oO;
    }

    public final String O00000o0() {
        return this.O00000oo + this.O0000Oo0;
    }
}
