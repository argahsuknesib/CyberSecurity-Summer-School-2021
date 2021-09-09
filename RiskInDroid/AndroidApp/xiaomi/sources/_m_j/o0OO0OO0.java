package _m_j;

import java.util.Arrays;

public final class o0OO0OO0 extends o0OOoOO0 {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o[] f2249O000000o;
    private final double[] O00000Oo;

    public final void O000000o(double d, double[] dArr) {
        if (d < this.f2249O000000o[0].O00000o0) {
            d = this.f2249O000000o[0].O00000o0;
        }
        O000000o[] o000000oArr = this.f2249O000000o;
        if (d > o000000oArr[o000000oArr.length - 1].O00000o) {
            O000000o[] o000000oArr2 = this.f2249O000000o;
            d = o000000oArr2[o000000oArr2.length - 1].O00000o;
        }
        int i = 0;
        while (true) {
            O000000o[] o000000oArr3 = this.f2249O000000o;
            if (i >= o000000oArr3.length) {
                return;
            }
            if (d > o000000oArr3[i].O00000o) {
                i++;
            } else if (this.f2249O000000o[i].O0000oO0) {
                dArr[0] = this.f2249O000000o[i].O00000Oo(d);
                dArr[1] = this.f2249O000000o[i].O00000o0(d);
                return;
            } else {
                this.f2249O000000o[i].O000000o(d);
                dArr[0] = this.f2249O000000o[i].O000000o();
                dArr[1] = this.f2249O000000o[i].O00000Oo();
                return;
            }
        }
    }

    public final void O000000o(double d, float[] fArr) {
        if (d < this.f2249O000000o[0].O00000o0) {
            d = this.f2249O000000o[0].O00000o0;
        } else {
            O000000o[] o000000oArr = this.f2249O000000o;
            if (d > o000000oArr[o000000oArr.length - 1].O00000o) {
                O000000o[] o000000oArr2 = this.f2249O000000o;
                d = o000000oArr2[o000000oArr2.length - 1].O00000o;
            }
        }
        int i = 0;
        while (true) {
            O000000o[] o000000oArr3 = this.f2249O000000o;
            if (i >= o000000oArr3.length) {
                return;
            }
            if (d > o000000oArr3[i].O00000o) {
                i++;
            } else if (this.f2249O000000o[i].O0000oO0) {
                fArr[0] = (float) this.f2249O000000o[i].O00000Oo(d);
                fArr[1] = (float) this.f2249O000000o[i].O00000o0(d);
                return;
            } else {
                this.f2249O000000o[i].O000000o(d);
                fArr[0] = (float) this.f2249O000000o[i].O000000o();
                fArr[1] = (float) this.f2249O000000o[i].O00000Oo();
                return;
            }
        }
    }

    public final void O00000Oo(double d, double[] dArr) {
        if (d < this.f2249O000000o[0].O00000o0) {
            d = this.f2249O000000o[0].O00000o0;
        } else {
            O000000o[] o000000oArr = this.f2249O000000o;
            if (d > o000000oArr[o000000oArr.length - 1].O00000o) {
                O000000o[] o000000oArr2 = this.f2249O000000o;
                d = o000000oArr2[o000000oArr2.length - 1].O00000o;
            }
        }
        int i = 0;
        while (true) {
            O000000o[] o000000oArr3 = this.f2249O000000o;
            if (i >= o000000oArr3.length) {
                return;
            }
            if (d > o000000oArr3[i].O00000o) {
                i++;
            } else if (this.f2249O000000o[i].O0000oO0) {
                dArr[0] = this.f2249O000000o[i].O0000Ooo;
                dArr[1] = this.f2249O000000o[i].O0000o00;
                return;
            } else {
                this.f2249O000000o[i].O000000o(d);
                dArr[0] = this.f2249O000000o[i].O00000o0();
                O000000o o000000o = this.f2249O000000o[i];
                double d2 = o000000o.O0000Oo * o000000o.O0000o0o;
                double d3 = (-o000000o.O0000OoO) * o000000o.O0000o0O;
                double hypot = o000000o.O0000o0 / Math.hypot(d2, d3);
                dArr[1] = o000000o.O0000o ? (-d3) * hypot : d3 * hypot;
                return;
            }
        }
    }

    public final double O000000o(double d) {
        int i = 0;
        if (d < this.f2249O000000o[0].O00000o0) {
            d = this.f2249O000000o[0].O00000o0;
        } else {
            O000000o[] o000000oArr = this.f2249O000000o;
            if (d > o000000oArr[o000000oArr.length - 1].O00000o) {
                O000000o[] o000000oArr2 = this.f2249O000000o;
                d = o000000oArr2[o000000oArr2.length - 1].O00000o;
            }
        }
        while (true) {
            O000000o[] o000000oArr3 = this.f2249O000000o;
            if (i >= o000000oArr3.length) {
                return Double.NaN;
            }
            if (d > o000000oArr3[i].O00000o) {
                i++;
            } else if (this.f2249O000000o[i].O0000oO0) {
                return this.f2249O000000o[i].O00000Oo(d);
            } else {
                this.f2249O000000o[i].O000000o(d);
                return this.f2249O000000o[i].O000000o();
            }
        }
    }

    public final double O00000Oo(double d) {
        int i = 0;
        if (d < this.f2249O000000o[0].O00000o0) {
            d = this.f2249O000000o[0].O00000o0;
        }
        O000000o[] o000000oArr = this.f2249O000000o;
        if (d > o000000oArr[o000000oArr.length - 1].O00000o) {
            O000000o[] o000000oArr2 = this.f2249O000000o;
            d = o000000oArr2[o000000oArr2.length - 1].O00000o;
        }
        while (true) {
            O000000o[] o000000oArr3 = this.f2249O000000o;
            if (i >= o000000oArr3.length) {
                return Double.NaN;
            }
            if (d > o000000oArr3[i].O00000o) {
                i++;
            } else if (this.f2249O000000o[i].O0000oO0) {
                return this.f2249O000000o[i].O0000Ooo;
            } else {
                this.f2249O000000o[i].O000000o(d);
                return this.f2249O000000o[i].O00000o0();
            }
        }
    }

    public final double[] O000000o() {
        return this.O00000Oo;
    }

    public o0OO0OO0(int[] iArr, double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        this.O00000Oo = dArr3;
        this.f2249O000000o = new O000000o[(dArr3.length - 1)];
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.f2249O000000o.length) {
            int i4 = iArr[i];
            int i5 = 2;
            if (i4 == 0) {
                i5 = 3;
            } else if (i4 == 1) {
                i2 = 1;
                i5 = 1;
            } else if (i4 == 2) {
                i2 = 2;
            } else if (i4 != 3) {
                i5 = i3;
            } else {
                i5 = i2 != 1 ? 1 : i5;
                i2 = i5;
            }
            int i6 = i + 1;
            this.f2249O000000o[i] = new O000000o(i5, dArr3[i], dArr3[i6], dArr2[i][0], dArr2[i][1], dArr2[i6][0], dArr2[i6][1]);
            i = i6;
            i3 = i5;
        }
    }

    static class O000000o {
        private static double[] O0000oO = new double[91];

        /* renamed from: O000000o  reason: collision with root package name */
        double[] f2250O000000o;
        double O00000Oo;
        double O00000o;
        double O00000o0;
        double O00000oO;
        double O00000oo;
        double O0000O0o;
        double O0000OOo;
        double O0000Oo;
        double O0000Oo0;
        double O0000OoO;
        double O0000Ooo;
        boolean O0000o;
        double O0000o0;
        double O0000o00;
        double O0000o0O;
        double O0000o0o;
        boolean O0000oO0 = false;

        O000000o(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            int i2 = i;
            double d7 = d3;
            double d8 = d5;
            double d9 = d6;
            boolean z = false;
            this.O0000o = i2 == 1 ? true : z;
            this.O00000o0 = d;
            this.O00000o = d2;
            this.O0000Oo0 = 1.0d / (this.O00000o - this.O00000o0);
            if (3 == i2) {
                this.O0000oO0 = true;
            }
            double d10 = d8 - d7;
            double d11 = d4;
            double d12 = d9 - d11;
            if (this.O0000oO0 || Math.abs(d10) < 0.001d || Math.abs(d12) < 0.001d) {
                this.O0000oO0 = true;
                this.O00000oO = d7;
                this.O00000oo = d8;
                this.O0000O0o = d11;
                this.O0000OOo = d9;
                this.O00000Oo = Math.hypot(d12, d10);
                this.O0000o0 = this.O00000Oo * this.O0000Oo0;
                double d13 = this.O00000o;
                double d14 = this.O00000o0;
                this.O0000Ooo = d10 / (d13 - d14);
                this.O0000o00 = d12 / (d13 - d14);
                return;
            }
            this.f2250O000000o = new double[101];
            double d15 = (double) (this.O0000o ? -1 : 1);
            Double.isNaN(d15);
            this.O0000Oo = d10 * d15;
            double d16 = (double) (this.O0000o ? 1 : -1);
            Double.isNaN(d16);
            this.O0000OoO = d12 * d16;
            this.O0000Ooo = this.O0000o ? d8 : d7;
            this.O0000o00 = this.O0000o ? d11 : d9;
            O000000o(d3, d4, d5, d6);
            this.O0000o0 = this.O00000Oo * this.O0000Oo0;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(double d) {
            double O00000o2 = O00000o((this.O0000o ? this.O00000o - d : d - this.O00000o0) * this.O0000Oo0) * 1.5707963267948966d;
            this.O0000o0O = Math.sin(O00000o2);
            this.O0000o0o = Math.cos(O00000o2);
        }

        /* access modifiers changed from: package-private */
        public final double O000000o() {
            return this.O0000Ooo + (this.O0000Oo * this.O0000o0O);
        }

        /* access modifiers changed from: package-private */
        public final double O00000Oo() {
            return this.O0000o00 + (this.O0000OoO * this.O0000o0o);
        }

        /* access modifiers changed from: package-private */
        public final double O00000o0() {
            double d = this.O0000Oo * this.O0000o0o;
            double hypot = this.O0000o0 / Math.hypot(d, (-this.O0000OoO) * this.O0000o0O);
            return this.O0000o ? (-d) * hypot : d * hypot;
        }

        public final double O00000Oo(double d) {
            double d2 = (d - this.O00000o0) * this.O0000Oo0;
            double d3 = this.O00000oO;
            return d3 + (d2 * (this.O00000oo - d3));
        }

        public final double O00000o0(double d) {
            double d2 = (d - this.O00000o0) * this.O0000Oo0;
            double d3 = this.O0000O0o;
            return d3 + (d2 * (this.O0000OOo - d3));
        }

        private double O00000o(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f2250O000000o;
            double length = (double) (dArr.length - 1);
            Double.isNaN(length);
            double d2 = d * length;
            int i = (int) d2;
            double d3 = (double) i;
            Double.isNaN(d3);
            return dArr[i] + ((d2 - d3) * (dArr[i + 1] - dArr[i]));
        }

        private void O000000o(double d, double d2, double d3, double d4) {
            double d5;
            double d6 = d3 - d;
            double d7 = d2 - d4;
            int i = 0;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            while (true) {
                double[] dArr = O0000oO;
                if (i >= dArr.length) {
                    break;
                }
                double d11 = (double) i;
                Double.isNaN(d11);
                double d12 = d8;
                double length = (double) (dArr.length - 1);
                Double.isNaN(length);
                double radians = Math.toRadians((d11 * 90.0d) / length);
                double sin = Math.sin(radians) * d6;
                double cos = Math.cos(radians) * d7;
                if (i > 0) {
                    d5 = d12 + Math.hypot(sin - d9, cos - d10);
                    O0000oO[i] = d5;
                } else {
                    d5 = d12;
                }
                i++;
                d10 = cos;
                double d13 = sin;
                d8 = d5;
                d9 = d13;
            }
            double d14 = d8;
            this.O00000Oo = d14;
            int i2 = 0;
            while (true) {
                double[] dArr2 = O0000oO;
                if (i2 >= dArr2.length) {
                    break;
                }
                dArr2[i2] = dArr2[i2] / d14;
                i2++;
            }
            int i3 = 0;
            while (true) {
                double[] dArr3 = this.f2250O000000o;
                if (i3 < dArr3.length) {
                    double d15 = (double) i3;
                    double length2 = (double) (dArr3.length - 1);
                    Double.isNaN(d15);
                    Double.isNaN(length2);
                    double d16 = d15 / length2;
                    int binarySearch = Arrays.binarySearch(O0000oO, d16);
                    if (binarySearch >= 0) {
                        this.f2250O000000o[i3] = (double) (binarySearch / (O0000oO.length - 1));
                    } else if (binarySearch == -1) {
                        this.f2250O000000o[i3] = 0.0d;
                    } else {
                        int i4 = -binarySearch;
                        int i5 = i4 - 2;
                        double d17 = (double) i5;
                        double[] dArr4 = O0000oO;
                        Double.isNaN(d17);
                        double length3 = (double) (dArr4.length - 1);
                        Double.isNaN(length3);
                        this.f2250O000000o[i3] = (d17 + ((d16 - dArr4[i5]) / (dArr4[i4 - 1] - dArr4[i5]))) / length3;
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }
}
