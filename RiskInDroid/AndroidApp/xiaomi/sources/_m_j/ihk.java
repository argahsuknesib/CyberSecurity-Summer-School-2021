package _m_j;

import java.lang.reflect.Array;

public final class ihk {

    /* renamed from: O000000o  reason: collision with root package name */
    final byte[][] f1297O000000o;
    public final int O00000Oo;
    public final int O00000o0;

    public ihk(int i, int i2) {
        this.f1297O000000o = (byte[][]) Array.newInstance(byte.class, i2, i);
        this.O00000Oo = i;
        this.O00000o0 = i2;
    }

    public final byte O000000o(int i, int i2) {
        return this.f1297O000000o[i2][i];
    }

    public final void O000000o(int i, int i2, int i3) {
        this.f1297O000000o[i2][i] = (byte) i3;
    }

    public final void O000000o(int i, int i2, boolean z) {
        this.f1297O000000o[i2][i] = z ? (byte) 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.O00000Oo * 2 * this.O00000o0) + 2);
        for (int i = 0; i < this.O00000o0; i++) {
            for (int i2 = 0; i2 < this.O00000Oo; i2++) {
                byte b = this.f1297O000000o[i][i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
