package _m_j;

import _m_j.oOO0OOo0;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.LinkedHashMap;

public final class oO00O00o implements Comparable<oO00O00o> {

    /* renamed from: O000000o  reason: collision with root package name */
    static String[] f2269O000000o = {"position", "x", "y", "width", "height", "pathRotate"};
    o0OO0o00 O00000Oo;
    public float O00000o;
    int O00000o0 = 0;
    public float O00000oO;
    public float O00000oo;
    public float O0000O0o;
    public float O0000OOo;
    float O0000Oo = Float.NaN;
    public float O0000Oo0;
    float O0000OoO = Float.NaN;
    int O0000Ooo = oO0000o0.f2264O000000o;
    int O0000o0 = 0;
    LinkedHashMap<String, ConstraintAttribute> O0000o00 = new LinkedHashMap<>();
    double[] O0000o0O = new double[18];
    double[] O0000o0o = new double[18];

    public final /* synthetic */ int compareTo(Object obj) {
        return Float.compare(this.O00000oO, ((oO00O00o) obj).O00000oO);
    }

    public oO00O00o() {
    }

    public oO00O00o(int i, int i2, oO000OOO oo000ooo, oO00O00o oo00o00o, oO00O00o oo00o00o2) {
        float f;
        int i3;
        oO000OOO oo000ooo2 = oo000ooo;
        oO00O00o oo00o00o3 = oo00o00o;
        oO00O00o oo00o00o4 = oo00o00o2;
        int i4 = oo000ooo2.O0000o0o;
        if (i4 == 1) {
            oO00O00o oo00o00o5 = oo00o00o3;
            float f2 = ((float) oo000ooo2.O00000Oo) / 100.0f;
            this.O00000o = f2;
            this.O00000o0 = oo000ooo2.O0000Oo0;
            float f3 = Float.isNaN(oo000ooo2.O0000Oo) ? f2 : oo000ooo2.O0000Oo;
            float f4 = Float.isNaN(oo000ooo2.O0000OoO) ? f2 : oo000ooo2.O0000OoO;
            float f5 = oo00o00o4.O0000OOo - oo00o00o5.O0000OOo;
            float f6 = oo00o00o4.O0000Oo0 - oo00o00o5.O0000Oo0;
            this.O00000oO = this.O00000o;
            f2 = !Float.isNaN(oo000ooo2.O0000Ooo) ? oo000ooo2.O0000Ooo : f2;
            float f7 = oo00o00o5.O00000oo;
            float f8 = oo00o00o5.O0000OOo;
            float f9 = oo00o00o5.O0000O0o;
            float f10 = oo00o00o5.O0000Oo0;
            float f11 = (oo00o00o4.O00000oo + (oo00o00o4.O0000OOo / 2.0f)) - ((f8 / 2.0f) + f7);
            float f12 = (oo00o00o4.O0000O0o + (oo00o00o4.O0000Oo0 / 2.0f)) - (f9 + (f10 / 2.0f));
            float f13 = f11 * f2;
            float f14 = f5 * f3;
            float f15 = f14 / 2.0f;
            this.O00000oo = (float) ((int) ((f7 + f13) - f15));
            float f16 = f2 * f12;
            float f17 = f6 * f4;
            float f18 = f17 / 2.0f;
            this.O0000O0o = (float) ((int) ((f9 + f16) - f18));
            this.O0000OOo = (float) ((int) (f8 + f14));
            this.O0000Oo0 = (float) ((int) (f10 + f17));
            float f19 = Float.isNaN(oo000ooo2.O0000o00) ? 0.0f : oo000ooo2.O0000o00;
            this.O0000o0 = 1;
            oO00O00o oo00o00o6 = oo00o00o;
            this.O00000oo = (float) ((int) ((oo00o00o6.O00000oo + f13) - f15));
            this.O0000O0o = (float) ((int) ((oo00o00o6.O0000O0o + f16) - f18));
            this.O00000oo += (-f12) * f19;
            this.O0000O0o += f11 * f19;
            this.O00000Oo = o0OO0o00.O000000o(oo000ooo2.O0000O0o);
            this.O0000Ooo = oo000ooo2.O0000OOo;
        } else if (i4 != 2) {
            float f20 = ((float) oo000ooo2.O00000Oo) / 100.0f;
            this.O00000o = f20;
            this.O00000o0 = oo000ooo2.O0000Oo0;
            float f21 = Float.isNaN(oo000ooo2.O0000Oo) ? f20 : oo000ooo2.O0000Oo;
            float f22 = Float.isNaN(oo000ooo2.O0000OoO) ? f20 : oo000ooo2.O0000OoO;
            float f23 = oo00o00o4.O0000OOo;
            float f24 = oo00o00o3.O0000OOo;
            float f25 = oo00o00o4.O0000Oo0;
            float f26 = oo00o00o3.O0000Oo0;
            this.O00000oO = this.O00000o;
            float f27 = oo00o00o3.O00000oo;
            float f28 = oo00o00o3.O0000O0o;
            float f29 = (oo00o00o4.O00000oo + (f23 / 2.0f)) - (f27 + (f24 / 2.0f));
            float f30 = (oo00o00o4.O0000O0o + (f25 / 2.0f)) - (f28 + (f26 / 2.0f));
            float f31 = (f23 - f24) * f21;
            float f32 = f31 / 2.0f;
            this.O00000oo = (float) ((int) ((f27 + (f29 * f20)) - f32));
            float f33 = (f25 - f26) * f22;
            float f34 = f33 / 2.0f;
            this.O0000O0o = (float) ((int) ((f28 + (f30 * f20)) - f34));
            this.O0000OOo = (float) ((int) (f24 + f31));
            this.O0000Oo0 = (float) ((int) (f26 + f33));
            float f35 = Float.isNaN(oo000ooo2.O0000Ooo) ? f20 : oo000ooo2.O0000Ooo;
            float f36 = Float.isNaN(oo000ooo2.O0000o0O) ? 0.0f : oo000ooo2.O0000o0O;
            f20 = !Float.isNaN(oo000ooo2.O0000o00) ? oo000ooo2.O0000o00 : f20;
            if (Float.isNaN(oo000ooo2.O0000o0)) {
                i3 = 2;
                f = 0.0f;
            } else {
                f = oo000ooo2.O0000o0;
                i3 = 2;
            }
            this.O0000o0 = i3;
            oO00O00o oo00o00o7 = oo00o00o;
            this.O00000oo = (float) ((int) (((oo00o00o7.O00000oo + (f35 * f29)) + (f * f30)) - f32));
            this.O0000O0o = (float) ((int) (((oo00o00o7.O0000O0o + (f29 * f36)) + (f30 * f20)) - f34));
            this.O00000Oo = o0OO0o00.O000000o(oo000ooo2.O0000O0o);
            this.O0000Ooo = oo000ooo2.O0000OOo;
        } else {
            oO00O00o oo00o00o8 = oo00o00o3;
            float f37 = ((float) oo000ooo2.O00000Oo) / 100.0f;
            this.O00000o = f37;
            this.O00000o0 = oo000ooo2.O0000Oo0;
            float f38 = Float.isNaN(oo000ooo2.O0000Oo) ? f37 : oo000ooo2.O0000Oo;
            float f39 = Float.isNaN(oo000ooo2.O0000OoO) ? f37 : oo000ooo2.O0000OoO;
            float f40 = oo00o00o4.O0000OOo;
            float f41 = oo00o00o8.O0000OOo;
            float f42 = oo00o00o4.O0000Oo0;
            float f43 = oo00o00o8.O0000Oo0;
            this.O00000oO = this.O00000o;
            float f44 = oo00o00o8.O00000oo;
            float f45 = oo00o00o8.O0000O0o;
            float f46 = oo00o00o4.O00000oo + (f40 / 2.0f);
            float f47 = oo00o00o4.O0000O0o + (f42 / 2.0f);
            float f48 = (f40 - f41) * f38;
            this.O00000oo = (float) ((int) ((f44 + ((f46 - ((f41 / 2.0f) + f44)) * f37)) - (f48 / 2.0f)));
            float f49 = (f42 - f43) * f39;
            this.O0000O0o = (float) ((int) ((f45 + ((f47 - (f45 + (f43 / 2.0f))) * f37)) - (f49 / 2.0f)));
            this.O0000OOo = (float) ((int) (f41 + f48));
            this.O0000Oo0 = (float) ((int) (f43 + f49));
            this.O0000o0 = 3;
            oO000OOO oo000ooo3 = oo000ooo;
            if (!Float.isNaN(oo000ooo3.O0000Ooo)) {
                this.O00000oo = (float) ((int) (oo000ooo3.O0000Ooo * ((float) ((int) (((float) i) - this.O0000OOo)))));
            }
            if (!Float.isNaN(oo000ooo3.O0000o00)) {
                this.O0000O0o = (float) ((int) (oo000ooo3.O0000o00 * ((float) ((int) (((float) i2) - this.O0000Oo0)))));
            }
            this.O00000Oo = o0OO0o00.O000000o(oo000ooo3.O0000O0o);
            this.O0000Ooo = oo000ooo3.O0000OOo;
        }
    }

    static boolean O000000o(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.O00000oo;
        float f2 = this.O0000O0o;
        float f3 = this.O0000OOo;
        float f4 = this.O0000Oo0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    public static void O000000o(float f, float f2, float[] fArr, int[] iArr, double[] dArr) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            int i2 = iArr[i];
            if (i2 != 0) {
                if (i2 == 1) {
                    f3 = f7;
                } else if (i2 == 2) {
                    f5 = f7;
                } else if (i2 == 3) {
                    f4 = f7;
                } else if (i2 == 4) {
                    f6 = f7;
                }
            }
        }
        float f8 = f3 - ((f4 * 0.0f) / 2.0f);
        float f9 = f5 - ((f6 * 0.0f) / 2.0f);
        fArr[0] = (f8 * (1.0f - f)) + (((f4 * 1.0f) + f8) * f) + 0.0f;
        fArr[1] = (f9 * (1.0f - f2)) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(double[] dArr, int[] iArr) {
        float[] fArr = {this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo};
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < 6) {
                dArr[i] = (double) fArr[iArr[i2]];
                i++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(String str, double[] dArr, int i) {
        ConstraintAttribute constraintAttribute = this.O0000o00.get(str);
        int i2 = 0;
        if (constraintAttribute.O000000o() == 1) {
            dArr[0] = (double) constraintAttribute.O00000Oo();
            return 1;
        }
        int O000000o2 = constraintAttribute.O000000o();
        float[] fArr = new float[O000000o2];
        constraintAttribute.O000000o(fArr);
        while (i2 < O000000o2) {
            dArr[i] = (double) fArr[i2];
            i2++;
            i++;
        }
        return O000000o2;
    }

    public final void O000000o(float f, float f2, float f3, float f4) {
        this.O00000oo = f;
        this.O0000O0o = f2;
        this.O0000OOo = f3;
        this.O0000Oo0 = f4;
    }

    public final void O000000o(oOO0OOo0.O000000o o000000o) {
        this.O00000Oo = o0OO0o00.O000000o(o000000o.O00000o0.O00000o0);
        this.O0000Ooo = o000000o.O00000o0.O00000o;
        this.O0000Oo = o000000o.O00000o0.O0000O0o;
        this.O00000o0 = o000000o.O00000o0.O00000oO;
        this.O0000OoO = o000000o.O00000Oo.O00000oO;
        for (String next : o000000o.O00000oo.keySet()) {
            ConstraintAttribute constraintAttribute = o000000o.O00000oo.get(next);
            if (constraintAttribute.O00000Oo != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.O0000o00.put(next, constraintAttribute);
            }
        }
    }
}
