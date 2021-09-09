package _m_j;

public final class o {
    private static String O0000O0o = "VelocityMatrix";

    /* renamed from: O000000o  reason: collision with root package name */
    float f2218O000000o;
    float O00000Oo;
    float O00000o;
    float O00000o0;
    float O00000oO;
    float O00000oo;

    public final void O000000o() {
        this.O00000oO = 0.0f;
        this.O00000o = 0.0f;
        this.O00000o0 = 0.0f;
        this.O00000Oo = 0.0f;
        this.f2218O000000o = 0.0f;
    }

    public final void O000000o(oO0O0OoO oo0o0ooo, float f) {
        if (oo0o0ooo != null) {
            this.O00000oO = oo0o0ooo.O00000Oo(f);
            this.O00000oo = oo0o0ooo.O000000o(f);
        }
    }

    public final void O000000o(oO0O0OoO oo0o0ooo, oO0O0OoO oo0o0ooo2, float f) {
        if (oo0o0ooo != null) {
            this.O00000o0 = oo0o0ooo.O00000Oo(f);
        }
        if (oo0o0ooo2 != null) {
            this.O00000o = oo0o0ooo2.O00000Oo(f);
        }
    }

    public final void O00000Oo(oO0O0OoO oo0o0ooo, oO0O0OoO oo0o0ooo2, float f) {
        if (oo0o0ooo != null) {
            this.f2218O000000o = oo0o0ooo.O00000Oo(f);
        }
        if (oo0o0ooo2 != null) {
            this.O00000Oo = oo0o0ooo2.O00000Oo(f);
        }
    }

    public final void O000000o(oO0OoOO0 oo0oooo0, float f) {
        if (oo0oooo0 != null) {
            this.O00000oO = oo0oooo0.O00000Oo(f);
        }
    }

    public final void O000000o(oO0OoOO0 oo0oooo0, oO0OoOO0 oo0oooo02, float f) {
        if (oo0oooo0 != null) {
            this.O00000o0 = oo0oooo0.O00000Oo(f);
        }
        if (oo0oooo02 != null) {
            this.O00000o = oo0oooo02.O00000Oo(f);
        }
    }

    public final void O00000Oo(oO0OoOO0 oo0oooo0, oO0OoOO0 oo0oooo02, float f) {
        if (oo0oooo0 != null || oo0oooo02 != null) {
            if (oo0oooo0 == null) {
                this.f2218O000000o = oo0oooo0.O00000Oo(f);
            }
            if (oo0oooo02 == null) {
                this.O00000Oo = oo0oooo02.O00000Oo(f);
            }
        }
    }

    public final void O000000o(float f, float f2, int i, int i2, float[] fArr) {
        int i3 = i;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = (f - 0.5f) * 2.0f;
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = f3 + this.O00000o0;
        float f8 = f4 + this.O00000o;
        float f9 = f7 + (this.f2218O000000o * f5);
        float f10 = f8 + (this.O00000Oo * f6);
        float radians = (float) Math.toRadians((double) this.O00000oO);
        double d = (double) (((float) (-i3)) * f5);
        double radians2 = (double) ((float) Math.toRadians((double) this.O00000oo));
        double sin = Math.sin(radians2);
        Double.isNaN(d);
        double d2 = d * sin;
        double d3 = (double) (((float) i2) * f6);
        double cos = Math.cos(radians2);
        Double.isNaN(d3);
        float f11 = f9 + (((float) (d2 - (cos * d3))) * radians);
        double d4 = (double) (((float) i3) * f5);
        double cos2 = Math.cos(radians2);
        Double.isNaN(d4);
        double d5 = d4 * cos2;
        double sin2 = Math.sin(radians2);
        Double.isNaN(d3);
        fArr[0] = f11;
        fArr[1] = f10 + (radians * ((float) (d5 - (d3 * sin2))));
    }
}
