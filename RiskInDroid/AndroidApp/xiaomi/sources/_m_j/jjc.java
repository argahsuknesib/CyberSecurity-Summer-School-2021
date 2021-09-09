package _m_j;

import java.io.IOException;

public final class jjc {

    /* renamed from: O000000o  reason: collision with root package name */
    public int[] f1876O000000o;
    public boolean O00000Oo;

    public static jjc O000000o(jjh jjh, int i) throws IOException {
        jjc jjc = new jjc();
        jjc.f1876O000000o = new int[i];
        int i2 = 0;
        int i3 = 8;
        int i4 = 8;
        while (i2 < i) {
            if (i3 != 0) {
                i3 = ((jjh.O00000Oo("deltaScale") + i4) + 256) % 256;
                jjc.O00000Oo = i2 == 0 && i3 == 0;
            }
            int[] iArr = jjc.f1876O000000o;
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i2] = i4;
            i4 = jjc.f1876O000000o[i2];
            i2++;
        }
        return jjc;
    }

    public final String toString() {
        return "ScalingList{scalingList=" + this.f1876O000000o + ", useDefaultScalingMatrixFlag=" + this.O00000Oo + '}';
    }
}
