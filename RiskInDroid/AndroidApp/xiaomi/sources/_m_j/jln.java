package _m_j;

public final class jln {

    /* renamed from: O000000o  reason: collision with root package name */
    public double f1925O000000o;
    public double O00000Oo;
    public double O00000o;
    public double O00000o0;
    public double O00000oO;
    public double O00000oo;
    public double O0000O0o;
    public double O0000OOo;
    public double O0000Oo;
    public double O0000Oo0;
    public double O0000OoO;
    public double O0000Ooo;
    public double O0000o;
    public double O0000o0;
    public double O0000o00;
    public double O0000o0O;
    public double O0000o0o;
    public double O0000oO;
    public double O0000oO0;
    public double O0000oOO;
    public double O0000oOo;
    public double O0000oo;
    public double O0000oo0;
    public double O0000ooO;

    private jln() {
        this.f1925O000000o = 0.0d;
        this.O00000Oo = 0.0d;
        this.O00000o0 = 0.0d;
        this.O00000o = 0.0d;
        this.O00000oO = 0.0d;
        this.O00000oo = 0.0d;
        this.O0000O0o = 0.0d;
        this.O0000OOo = 0.0d;
        this.O0000Oo0 = 0.0d;
        this.O0000Oo = 0.0d;
        O000000o();
    }

    public jln(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.f1925O000000o = dArr.length > 0 ? dArr[0] : 0.0d;
            this.O00000Oo = dArr.length > 1 ? dArr[1] : 0.0d;
            this.O00000o0 = dArr.length > 2 ? dArr[2] : 0.0d;
            this.O00000o = dArr.length > 3 ? dArr[3] : 0.0d;
            this.O00000oO = dArr.length > 4 ? dArr[4] : 0.0d;
            this.O00000oo = dArr.length > 5 ? dArr[5] : 0.0d;
            this.O0000O0o = dArr.length > 6 ? dArr[6] : 0.0d;
            this.O0000OOo = dArr.length > 7 ? dArr[7] : 0.0d;
            this.O0000Oo0 = dArr.length > 8 ? dArr[8] : 0.0d;
            this.O0000Oo = dArr.length > 9 ? dArr[9] : d;
            O000000o();
            return;
        }
        this.f1925O000000o = 0.0d;
        this.O00000Oo = 0.0d;
        this.O00000o0 = 0.0d;
        this.O00000o = 0.0d;
        this.O00000oO = 0.0d;
        this.O00000oo = 0.0d;
        this.O0000O0o = 0.0d;
        this.O0000OOo = 0.0d;
        this.O0000Oo0 = 0.0d;
        this.O0000Oo = 0.0d;
        this.O0000OoO = 0.0d;
        this.O0000Ooo = 0.0d;
        this.O0000o00 = 0.0d;
        this.O0000o0 = 0.0d;
        this.O0000o0O = 0.0d;
        this.O0000o0o = 0.0d;
        this.O0000o = 0.0d;
        this.O0000oO0 = 0.0d;
        this.O0000oO = 0.0d;
        this.O0000oOO = 0.0d;
        this.O0000oOo = 0.0d;
        this.O0000oo0 = 0.0d;
        this.O0000oo = 0.0d;
        this.O0000ooO = 0.0d;
    }

    public final String toString() {
        return "Moments [ \nm00=" + this.f1925O000000o + ", \nm10=" + this.O00000Oo + ", m01=" + this.O00000o0 + ", \nm20=" + this.O00000o + ", m11=" + this.O00000oO + ", m02=" + this.O00000oo + ", \nm30=" + this.O0000O0o + ", m21=" + this.O0000OOo + ", m12=" + this.O0000Oo0 + ", m03=" + this.O0000Oo + ", \nmu20=" + this.O0000OoO + ", mu11=" + this.O0000Ooo + ", mu02=" + this.O0000o00 + ", \nmu30=" + this.O0000o0 + ", mu21=" + this.O0000o0O + ", mu12=" + this.O0000o0o + ", mu03=" + this.O0000o + ", \nnu20=" + this.O0000oO0 + ", nu11=" + this.O0000oO + ", nu02=" + this.O0000oOO + ", \nnu30=" + this.O0000oOo + ", nu21=" + this.O0000oo0 + ", nu12=" + this.O0000oo + ", nu03=" + this.O0000ooO + ", \n]";
    }

    private void O000000o() {
        double d;
        double d2;
        double d3 = 0.0d;
        if (Math.abs(this.f1925O000000o) > 1.0E-8d) {
            double d4 = 1.0d / this.f1925O000000o;
            d2 = this.O00000Oo * d4;
            double d5 = d4;
            d3 = this.O00000o0 * d4;
            d = d5;
        } else {
            d2 = 0.0d;
            d = 0.0d;
        }
        double d6 = this.O00000o;
        double d7 = this.O00000Oo;
        double d8 = d6 - (d7 * d2);
        double d9 = this.O00000oO - (d7 * d3);
        double d10 = this.O00000oo;
        double d11 = d;
        double d12 = this.O00000o0;
        double d13 = d10 - (d12 * d3);
        this.O0000OoO = d8;
        this.O0000Ooo = d9;
        this.O0000o00 = d13;
        double d14 = d13;
        this.O0000o0 = this.O0000O0o - (((d8 * 3.0d) + (d2 * d7)) * d2);
        double d15 = d9 + d9;
        this.O0000o0O = (this.O0000OOo - ((d15 + (d2 * d12)) * d2)) - (d8 * d3);
        this.O0000o0o = (this.O0000Oo0 - ((d15 + (d7 * d3)) * d3)) - (d2 * d14);
        this.O0000o = this.O0000Oo - (d3 * ((d14 * 3.0d) + (d12 * d3)));
        double d16 = d11 * d11;
        double sqrt = Math.sqrt(Math.abs(d11)) * d16;
        this.O0000oO0 = this.O0000OoO * d16;
        this.O0000oO = this.O0000Ooo * d16;
        this.O0000oOO = this.O0000o00 * d16;
        this.O0000oOo = this.O0000o0 * sqrt;
        this.O0000oo0 = this.O0000o0O * sqrt;
        this.O0000oo = this.O0000o0o * sqrt;
        this.O0000ooO = this.O0000o * sqrt;
    }
}
