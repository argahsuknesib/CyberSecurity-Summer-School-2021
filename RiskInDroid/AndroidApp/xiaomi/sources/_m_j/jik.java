package _m_j;

import java.util.Arrays;

public final class jik implements jij {

    /* renamed from: O000000o  reason: collision with root package name */
    private double f1855O000000o;

    public jik() {
        this.f1855O000000o = 2.0d;
        this.f1855O000000o = 2.0d;
    }

    public final long[] O000000o(jig jig) {
        long[] O0000Oo = jig.O0000Oo();
        long[] O00000Oo = jig.O00000Oo();
        long j = jig.O0000Ooo().O00000o0;
        long[] jArr = {1};
        double d = 0.0d;
        for (int i = 0; i < O0000Oo.length; i++) {
            double d2 = (double) O0000Oo[i];
            double d3 = (double) j;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d += d2 / d3;
            if (d >= this.f1855O000000o && (O00000Oo == null || Arrays.binarySearch(O00000Oo, (long) (i + 1)) >= 0)) {
                if (i > 0) {
                    jArr = jlc.O000000o(jArr, (long) (i + 1));
                }
                d = 0.0d;
            }
        }
        return jArr;
    }
}
