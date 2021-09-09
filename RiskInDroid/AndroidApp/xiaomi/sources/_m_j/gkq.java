package _m_j;

import java.util.Random;

public final class gkq implements gkr {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f17946O000000o;
    private float O00000Oo;
    private int O00000o;
    private int O00000o0;
    private boolean O00000oO = true;

    public gkq(float f, float f2) {
        this.f17946O000000o = f;
        this.O00000Oo = f2;
        this.O00000oO = false;
    }

    public final void O000000o(gkp gkp, Random random) {
        int i = this.O00000o0;
        float f = (float) i;
        int i2 = this.O00000o;
        if (i2 != i) {
            f = (float) (random.nextInt(i2 - i) + this.O00000o0);
        }
        double d = (double) f;
        Double.isNaN(d);
        float f2 = (float) ((d * 3.141592653589793d) / 180.0d);
        float nextFloat = random.nextFloat();
        float f3 = this.O00000Oo;
        float f4 = this.f17946O000000o;
        float f5 = (nextFloat * (f3 - f4)) + f4;
        if (this.O00000oO) {
            double d2 = (double) f5;
            double d3 = (double) f2;
            double cos = Math.cos(d3);
            Double.isNaN(d2);
            gkp.O0000Oo = (float) (cos * d2);
            double sin = Math.sin(d3);
            Double.isNaN(d2);
            gkp.O0000OoO = (float) (d2 * sin);
            return;
        }
        gkp.O0000Oo = f5;
        gkp.O0000OoO = f5;
    }
}
