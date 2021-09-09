package _m_j;

public final class idu {

    /* renamed from: O000000o  reason: collision with root package name */
    final float f1218O000000o;
    final float O00000Oo;
    final float O00000o;
    final float O00000o0;
    final float O00000oO;
    final float O00000oo;
    final float O0000O0o;
    final float O0000OOo;
    final float O0000Oo0;

    private idu(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f1218O000000o = f;
        this.O00000Oo = f4;
        this.O00000o0 = f7;
        this.O00000o = f2;
        this.O00000oO = f5;
        this.O00000oo = f8;
        this.O0000O0o = f3;
        this.O0000OOo = f6;
        this.O0000Oo0 = f9;
    }

    public static idu O000000o(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return O000000o(f9, f10, f11, f12, f13, f14, f15, f16).O000000o(O00000Oo(f, f2, f3, f4, f5, f6, f7, f8));
    }

    private static idu O000000o(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new idu(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new idu((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f4 - f2) + (f16 * f4), (f8 - f2) + (f17 * f8), f2, f16, f17, 1.0f);
    }

    private static idu O00000Oo(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return O000000o(f, f2, f3, f4, f5, f6, f7, f8).O000000o();
    }

    private idu O000000o() {
        float f = this.O00000oO;
        float f2 = this.O0000Oo0;
        float f3 = this.O00000oo;
        float f4 = this.O0000OOo;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.O0000O0o;
        float f7 = this.O00000o;
        float f8 = (f3 * f6) - (f7 * f2);
        float f9 = (f7 * f4) - (f * f6);
        float f10 = this.O00000o0;
        float f11 = this.O00000Oo;
        float f12 = (f10 * f4) - (f11 * f2);
        float f13 = this.f1218O000000o;
        return new idu(f5, f8, f9, f12, (f2 * f13) - (f10 * f6), (f6 * f11) - (f4 * f13), (f11 * f3) - (f10 * f), (f10 * f7) - (f3 * f13), (f13 * f) - (f11 * f7));
    }

    private idu O000000o(idu idu) {
        idu idu2 = idu;
        float f = this.f1218O000000o;
        float f2 = idu2.f1218O000000o;
        float f3 = this.O00000o;
        float f4 = idu2.O00000Oo;
        float f5 = this.O0000O0o;
        float f6 = idu2.O00000o0;
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = idu2.O00000o;
        float f9 = idu2.O00000oO;
        float f10 = idu2.O00000oo;
        float f11 = (f * f8) + (f3 * f9) + (f5 * f10);
        float f12 = idu2.O0000O0o;
        float f13 = idu2.O0000OOo;
        float f14 = idu2.O0000Oo0;
        float f15 = (f * f12) + (f3 * f13) + (f5 * f14);
        float f16 = this.O00000Oo;
        float f17 = f15;
        float f18 = this.O00000oO;
        float f19 = f11;
        float f20 = this.O0000OOo;
        float f21 = (f16 * f2) + (f18 * f4) + (f20 * f6);
        float f22 = (f20 * f14) + (f16 * f12) + (f18 * f13);
        float f23 = this.O00000o0;
        float f24 = this.O00000oo;
        float f25 = (f2 * f23) + (f4 * f24);
        float f26 = this.O0000Oo0;
        float f27 = (f23 * f12) + (f24 * f13) + (f26 * f14);
        return new idu(f7, f19, f17, f21, (f16 * f8) + (f18 * f9) + (f20 * f10), f22, (f6 * f26) + f25, (f8 * f23) + (f9 * f24) + (f10 * f26), f27);
    }
}
