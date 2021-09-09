package _m_j;

import java.io.IOException;

public final class jkf {

    /* renamed from: O000000o  reason: collision with root package name */
    public int[] f1899O000000o;
    public boolean O00000Oo;

    public static jkf O000000o(jkb jkb, int i) throws IOException {
        jkf jkf = new jkf();
        jkf.f1899O000000o = new int[i];
        int i2 = 0;
        int i3 = 8;
        int i4 = 8;
        while (i2 < i) {
            if (i3 != 0) {
                i3 = ((jkb.O00000o() + i4) + 256) % 256;
                jkf.O00000Oo = i2 == 0 && i3 == 0;
            }
            int[] iArr = jkf.f1899O000000o;
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i2] = i4;
            i4 = jkf.f1899O000000o[i2];
            i2++;
        }
        return jkf;
    }

    public final String toString() {
        return "ScalingList{scalingList=" + this.f1899O000000o + ", useDefaultScalingMatrixFlag=" + this.O00000Oo + '}';
    }
}
