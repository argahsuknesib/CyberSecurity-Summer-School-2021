package _m_j;

import java.util.Random;

public final class hfn implements hfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f18865O000000o;
    private float O00000Oo;
    private int O00000o;
    private int O00000o0;
    private boolean O00000oO;

    public hfn(float f, float f2) {
        this(f, f2, 0, 360);
    }

    private hfn(float f, float f2, int i, int i2) {
        int i3;
        this.f18865O000000o = f;
        this.O00000Oo = f2;
        this.O00000o0 = 0;
        this.O00000o = 360;
        this.O00000oO = true;
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

    public final void O000000o(hfi hfi, Random random) {
        float nextFloat = random.nextFloat();
        float f = this.O00000Oo;
        float f2 = this.f18865O000000o;
        float f3 = (nextFloat * (f - f2)) + f2;
        int i = this.O00000o;
        int i2 = this.O00000o0;
        if (i != i2) {
            if (this.O00000oO) {
                i2 = random.nextInt(i - i2) + this.O00000o0;
            } else {
                int nextInt = random.nextInt(360 - (i - i2)) + this.O00000o;
                while (nextInt < 0) {
                    nextInt += 360;
                }
                while (nextInt > 360) {
                    nextInt -= 360;
                }
                i2 = nextInt;
            }
        }
        float f4 = (float) i2;
        double d = (double) f4;
        Double.isNaN(d);
        float f5 = (float) ((d * 3.141592653589793d) / 180.0d);
        if (f4 < 90.0f) {
            double d2 = (double) f5;
            hfi.O0000OoO = ((float) Math.cos(d2)) * f3;
            hfi.O0000Ooo = ((float) Math.sin(d2)) * f3;
        } else if (f4 == 90.0f) {
            hfi.O0000OoO = 0.0f;
            hfi.O0000Ooo = f3;
        } else if (f4 > 90.0f && f4 < 180.0f) {
            double d3 = (double) (180.0f - f4);
            Double.isNaN(d3);
            double d4 = (double) ((float) ((d3 * 3.141592653589793d) / 180.0d));
            hfi.O0000OoO = (-((float) Math.cos(d4))) * f3;
            hfi.O0000Ooo = ((float) Math.sin(d4)) * f3;
        } else if (f4 == 180.0f) {
            hfi.O0000OoO = f3;
            hfi.O0000Ooo = 0.0f;
        } else if (f4 > 180.0f && f4 < 270.0f) {
            double d5 = (double) (f4 - 180.0f);
            Double.isNaN(d5);
            double d6 = (double) ((float) ((d5 * 3.141592653589793d) / 180.0d));
            hfi.O0000OoO = (-((float) Math.cos(d6))) * f3;
            hfi.O0000Ooo = (-((float) Math.sin(d6))) * f3;
        } else if (f4 == 270.0f) {
            hfi.O0000OoO = 0.0f;
            hfi.O0000Ooo = -f3;
        } else {
            double d7 = (double) (360.0f - f4);
            Double.isNaN(d7);
            double d8 = (double) ((float) ((d7 * 3.141592653589793d) / 180.0d));
            hfi.O0000OoO = ((float) Math.cos(d8)) * f3;
            hfi.O0000Ooo = (-((float) Math.sin(d8))) * f3;
        }
    }
}
