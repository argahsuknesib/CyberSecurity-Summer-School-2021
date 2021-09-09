package _m_j;

public abstract class o0OOoOO0 {
    public abstract double O000000o(double d);

    public abstract void O000000o(double d, double[] dArr);

    public abstract void O000000o(double d, float[] fArr);

    public abstract double[] O000000o();

    public abstract double O00000Oo(double d);

    public abstract void O00000Oo(double d, double[] dArr);

    public static o0OOoOO0 O000000o(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i == 0) {
            return new o0OOOO0o(dArr, dArr2);
        }
        if (i != 2) {
            return new o0OOOO00(dArr, dArr2);
        }
        return new O000000o(dArr[0], dArr2[0]);
    }

    static class O000000o extends o0OOoOO0 {

        /* renamed from: O000000o  reason: collision with root package name */
        double f2255O000000o;
        double[] O00000Oo;

        public final double O00000Oo(double d) {
            return 0.0d;
        }

        O000000o(double d, double[] dArr) {
            this.f2255O000000o = d;
            this.O00000Oo = dArr;
        }

        public final void O000000o(double d, double[] dArr) {
            double[] dArr2 = this.O00000Oo;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public final void O000000o(double d, float[] fArr) {
            int i = 0;
            while (true) {
                double[] dArr = this.O00000Oo;
                if (i < dArr.length) {
                    fArr[i] = (float) dArr[i];
                    i++;
                } else {
                    return;
                }
            }
        }

        public final double O000000o(double d) {
            return this.O00000Oo[0];
        }

        public final void O00000Oo(double d, double[] dArr) {
            for (int i = 0; i < this.O00000Oo.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        public final double[] O000000o() {
            return new double[]{this.f2255O000000o};
        }
    }
}
