package _m_j;

import java.util.Random;

public final class gkt implements gkr {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f17948O000000o;
    private float O00000Oo;
    private int O00000o;
    private int O00000o0;

    public gkt(float f, float f2, int i, int i2) {
        int i3;
        this.f17948O000000o = f;
        this.O00000Oo = f2;
        this.O00000o0 = i;
        this.O00000o = i2;
        while (true) {
            int i4 = this.O00000o0;
            if (i4 >= 0) {
                break;
            }
            this.O00000o0 = i4 + 360;
        }
        while (true) {
            i3 = this.O00000o;
            if (i3 >= 0) {
                break;
            }
            this.O00000o = i3 + 360;
        }
        int i5 = this.O00000o0;
        if (i5 > i3) {
            this.O00000o0 = i3;
            this.O00000o = i5;
        }
    }

    public final void O000000o(gkp gkp, Random random) {
        float nextFloat = random.nextFloat();
        float f = this.O00000Oo;
        float f2 = this.f17948O000000o;
        float f3 = (nextFloat * (f - f2)) + f2;
        int i = this.O00000o;
        int i2 = this.O00000o0;
        if (i != i2) {
            i2 = random.nextInt(i - i2) + this.O00000o0;
        }
        double d = (double) i2;
        Double.isNaN(d);
        double d2 = (double) f3;
        double d3 = (double) ((float) ((d * 3.141592653589793d) / 180.0d));
        double cos = Math.cos(d3);
        Double.isNaN(d2);
        gkp.O0000OOo = (float) (cos * d2);
        double sin = Math.sin(d3);
        Double.isNaN(d2);
        gkp.O0000Oo0 = (float) (d2 * sin);
    }
}
