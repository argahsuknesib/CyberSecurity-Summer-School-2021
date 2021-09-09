package _m_j;

public final class o0Oo0000 extends oO0O0o0o {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f2257O000000o;
    private float O00000Oo;
    private float O00000o;
    private float O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private float O0000OOo;
    private int O0000Oo;
    private float O0000Oo0;
    private String O0000OoO;
    private boolean O0000Ooo = false;
    private float O0000o0;
    private float O0000o00;

    private float O000000o(float f) {
        float f2 = this.O00000o;
        if (f <= f2) {
            float f3 = this.f2257O000000o;
            return f3 + (((this.O00000Oo - f3) * f) / f2);
        }
        int i = this.O0000Oo;
        if (i == 1) {
            return 0.0f;
        }
        float f4 = f - f2;
        float f5 = this.O00000oO;
        if (f4 < f5) {
            float f6 = this.O00000Oo;
            return f6 + (((this.O00000o0 - f6) * f4) / f5);
        } else if (i == 2) {
            return this.O0000OOo;
        } else {
            float f7 = f4 - f5;
            float f8 = this.O00000oo;
            if (f7 >= f8) {
                return this.O0000Oo0;
            }
            float f9 = this.O00000o0;
            return f9 - ((f7 * f9) / f8);
        }
    }

    public final void O000000o(float f, float f2, float f3, float f4, float f5, float f6) {
        this.O0000o00 = f;
        this.O0000Ooo = f > f2;
        if (this.O0000Ooo) {
            O000000o(-f3, f - f2, f5, f6, f4);
        } else {
            O000000o(f3, f2 - f, f5, f6, f4);
        }
    }

    public final float O000000o() {
        return this.O0000Ooo ? -O000000o(this.O0000o0) : O000000o(this.O0000o0);
    }

    private void O000000o(float f, float f2, float f3, float f4, float f5) {
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.f2257O000000o = f;
        float f6 = f / f3;
        float f7 = (f6 * f) / 2.0f;
        if (f < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f2 - ((((-f) / f3) * f) / 2.0f)) * f3));
            if (sqrt < f4) {
                this.O0000OoO = "backward accelerate, decelerate";
                this.O0000Oo = 2;
                this.f2257O000000o = f;
                this.O00000Oo = sqrt;
                this.O00000o0 = 0.0f;
                this.O00000o = (sqrt - f) / f3;
                this.O00000oO = sqrt / f3;
                this.O0000O0o = ((f + sqrt) * this.O00000o) / 2.0f;
                this.O0000OOo = f2;
                this.O0000Oo0 = f2;
                return;
            }
            this.O0000OoO = "backward accelerate cruse decelerate";
            this.O0000Oo = 3;
            this.f2257O000000o = f;
            this.O00000Oo = f4;
            this.O00000o0 = f4;
            this.O00000o = (f4 - f) / f3;
            this.O00000oo = f4 / f3;
            float f8 = ((f + f4) * this.O00000o) / 2.0f;
            float f9 = (this.O00000oo * f4) / 2.0f;
            this.O00000oO = ((f2 - f8) - f9) / f4;
            this.O0000O0o = f8;
            this.O0000OOo = f2 - f9;
            this.O0000Oo0 = f2;
        } else if (f7 >= f2) {
            this.O0000OoO = "hard stop";
            this.O0000Oo = 1;
            this.f2257O000000o = f;
            this.O00000Oo = 0.0f;
            this.O0000O0o = f2;
            this.O00000o = (2.0f * f2) / f;
        } else {
            float f10 = f2 - f7;
            float f11 = f10 / f;
            if (f11 + f6 < f5) {
                this.O0000OoO = "cruse decelerate";
                this.O0000Oo = 2;
                this.f2257O000000o = f;
                this.O00000Oo = f;
                this.O00000o0 = 0.0f;
                this.O0000O0o = f10;
                this.O0000OOo = f2;
                this.O00000o = f11;
                this.O00000oO = f6;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) ((f3 * f2) + ((f * f) / 2.0f)));
            float f12 = (sqrt2 - f) / f3;
            this.O00000o = f12;
            float f13 = sqrt2 / f3;
            this.O00000oO = f13;
            if (sqrt2 < f4) {
                this.O0000OoO = "accelerate decelerate";
                this.O0000Oo = 2;
                this.f2257O000000o = f;
                this.O00000Oo = sqrt2;
                this.O00000o0 = 0.0f;
                this.O00000o = f12;
                this.O00000oO = f13;
                this.O0000O0o = ((f + sqrt2) * this.O00000o) / 2.0f;
                this.O0000OOo = f2;
                return;
            }
            this.O0000OoO = "accelerate cruse decelerate";
            this.O0000Oo = 3;
            this.f2257O000000o = f;
            this.O00000Oo = f4;
            this.O00000o0 = f4;
            this.O00000o = (f4 - f) / f3;
            this.O00000oo = f4 / f3;
            float f14 = ((f + f4) * this.O00000o) / 2.0f;
            float f15 = (this.O00000oo * f4) / 2.0f;
            this.O00000oO = ((f2 - f14) - f15) / f4;
            this.O0000O0o = f14;
            this.O0000OOo = f2 - f15;
            this.O0000Oo0 = f2;
        }
    }

    public final float getInterpolation(float f) {
        float f2;
        float f3 = this.O00000o;
        if (f <= f3) {
            float f4 = this.f2257O000000o;
            f2 = (f4 * f) + ((((this.O00000Oo - f4) * f) * f) / (f3 * 2.0f));
        } else {
            int i = this.O0000Oo;
            if (i == 1) {
                f2 = this.O0000O0o;
            } else {
                float f5 = f - f3;
                float f6 = this.O00000oO;
                if (f5 < f6) {
                    float f7 = this.O0000O0o;
                    float f8 = this.O00000Oo;
                    f2 = f7 + (f8 * f5) + ((((this.O00000o0 - f8) * f5) * f5) / (f6 * 2.0f));
                } else if (i == 2) {
                    f2 = this.O0000OOo;
                } else {
                    float f9 = f5 - f6;
                    float f10 = this.O00000oo;
                    if (f9 < f10) {
                        float f11 = this.O0000OOo;
                        float f12 = this.O00000o0;
                        f2 = (f11 + (f12 * f9)) - (((f12 * f9) * f9) / (f10 * 2.0f));
                    } else {
                        f2 = this.O0000Oo0;
                    }
                }
            }
        }
        this.O0000o0 = f;
        return this.O0000Ooo ? this.O0000o00 - f2 : this.O0000o00 + f2;
    }
}
