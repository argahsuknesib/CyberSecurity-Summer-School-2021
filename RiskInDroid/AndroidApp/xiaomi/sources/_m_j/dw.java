package _m_j;

import _m_j.dt;

public final class dw {

    /* renamed from: O000000o  reason: collision with root package name */
    double f14992O000000o = Math.sqrt(1500.0d);
    public double O00000Oo = 0.5d;
    double O00000o;
    public boolean O00000o0 = false;
    double O00000oO;
    double O00000oo = Double.MAX_VALUE;
    private double O0000O0o;
    private double O0000OOo;
    private final dt.O000000o O0000Oo = new dt.O000000o();
    private double O0000Oo0;

    public dw() {
    }

    public dw(float f) {
        this.O00000oo = (double) f;
    }

    public final dw O000000o(float f) {
        if (f > 0.0f) {
            this.f14992O000000o = Math.sqrt((double) f);
            this.O00000o0 = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    private void O000000o() {
        if (!this.O00000o0) {
            if (this.O00000oo != Double.MAX_VALUE) {
                double d = this.O00000Oo;
                if (d > 1.0d) {
                    double d2 = this.f14992O000000o;
                    this.O0000O0o = ((-d) * d2) + (d2 * Math.sqrt((d * d) - 1.0d));
                    double d3 = this.O00000Oo;
                    double d4 = this.f14992O000000o;
                    this.O0000OOo = ((-d3) * d4) - (d4 * Math.sqrt((d3 * d3) - 1.0d));
                } else if (d >= 0.0d && d < 1.0d) {
                    this.O0000Oo0 = this.f14992O000000o * Math.sqrt(1.0d - (d * d));
                }
                this.O00000o0 = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    /* access modifiers changed from: package-private */
    public final dt.O000000o O000000o(double d, double d2, long j) {
        double d3;
        double d4;
        O000000o();
        double d5 = (double) j;
        Double.isNaN(d5);
        double d6 = d5 / 1000.0d;
        double d7 = d - this.O00000oo;
        double d8 = this.O00000Oo;
        if (d8 > 1.0d) {
            double d9 = this.O0000OOo;
            double d10 = this.O0000O0o;
            double d11 = d7 - (((d9 * d7) - d2) / (d9 - d10));
            double d12 = ((d7 * d9) - d2) / (d9 - d10);
            d4 = (Math.pow(2.718281828459045d, d9 * d6) * d11) + (Math.pow(2.718281828459045d, this.O0000O0o * d6) * d12);
            double d13 = this.O0000OOo;
            double pow = d11 * d13 * Math.pow(2.718281828459045d, d13 * d6);
            double d14 = this.O0000O0o;
            d3 = pow + (d12 * d14 * Math.pow(2.718281828459045d, d14 * d6));
        } else if (d8 == 1.0d) {
            double d15 = this.f14992O000000o;
            double d16 = d2 + (d15 * d7);
            double d17 = d7 + (d16 * d6);
            d4 = Math.pow(2.718281828459045d, (-d15) * d6) * d17;
            double pow2 = d17 * Math.pow(2.718281828459045d, (-this.f14992O000000o) * d6);
            double d18 = this.f14992O000000o;
            d3 = (d16 * Math.pow(2.718281828459045d, (-d18) * d6)) + (pow2 * (-d18));
        } else {
            double d19 = 1.0d / this.O0000Oo0;
            double d20 = this.f14992O000000o;
            double d21 = d19 * ((d8 * d20 * d7) + d2);
            double pow3 = Math.pow(2.718281828459045d, (-d8) * d20 * d6) * ((Math.cos(this.O0000Oo0 * d6) * d7) + (Math.sin(this.O0000Oo0 * d6) * d21));
            double d22 = this.f14992O000000o;
            double d23 = this.O00000Oo;
            double d24 = (-d22) * pow3 * d23;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d6);
            double d25 = this.O0000Oo0;
            double d26 = pow3;
            double sin = (-d25) * d7 * Math.sin(d25 * d6);
            double d27 = this.O0000Oo0;
            d3 = d24 + (pow4 * (sin + (d21 * d27 * Math.cos(d27 * d6))));
            d4 = d26;
        }
        dt.O000000o o000000o = this.O0000Oo;
        o000000o.f14911O000000o = (float) (d4 + this.O00000oo);
        o000000o.O00000Oo = (float) d3;
        return o000000o;
    }
}
