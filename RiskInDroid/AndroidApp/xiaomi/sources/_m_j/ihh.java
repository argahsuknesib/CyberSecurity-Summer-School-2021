package _m_j;

public final class ihh extends idg {
    public final int O00000o;
    public final float O00000o0;

    public ihh(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private ihh(float f, float f2, float f3, int i) {
        super(f, f2);
        this.O00000o0 = f3;
        this.O00000o = i;
    }

    public final ihh O00000Oo(float f, float f2, float f3) {
        int i = this.O00000o;
        int i2 = i + 1;
        float f4 = (((float) i) * this.f1209O000000o) + f2;
        float f5 = (float) i2;
        return new ihh(f4 / f5, ((((float) this.O00000o) * this.O00000Oo) + f) / f5, ((((float) this.O00000o) * this.O00000o0) + f3) / f5, i2);
    }

    public final boolean O000000o(float f, float f2, float f3) {
        if (Math.abs(f2 - this.O00000Oo) > f || Math.abs(f3 - this.f1209O000000o) > f) {
            return false;
        }
        float abs = Math.abs(f - this.O00000o0);
        if (abs <= 1.0f || abs <= this.O00000o0) {
            return true;
        }
        return false;
    }
}
