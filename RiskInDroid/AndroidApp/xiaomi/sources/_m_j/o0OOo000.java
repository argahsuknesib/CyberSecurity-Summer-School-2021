package _m_j;

import java.util.Arrays;

public final class o0OOo000 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f2254O000000o = "Oscillator";
    public float[] O00000Oo = new float[0];
    public double[] O00000o;
    public double[] O00000o0 = new double[0];
    public int O00000oO;
    double O00000oo = 6.283185307179586d;
    public boolean O0000O0o = false;

    public final String toString() {
        return "pos =" + Arrays.toString(this.O00000o0) + " period=" + Arrays.toString(this.O00000Oo);
    }

    public final void O000000o(double d, float f) {
        int length = this.O00000Oo.length + 1;
        int binarySearch = Arrays.binarySearch(this.O00000o0, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.O00000o0 = Arrays.copyOf(this.O00000o0, length);
        this.O00000Oo = Arrays.copyOf(this.O00000Oo, length);
        this.O00000o = new double[length];
        double[] dArr = this.O00000o0;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.O00000o0[binarySearch] = d;
        this.O00000Oo[binarySearch] = f;
        this.O0000O0o = false;
    }

    private double O00000o0(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.O00000o0, d);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i = (-binarySearch) - 1;
        float[] fArr = this.O00000Oo;
        int i2 = i - 1;
        double d2 = (double) (fArr[i] - fArr[i2]);
        double[] dArr = this.O00000o0;
        Double.isNaN(d2);
        double d3 = d2 / (dArr[i] - dArr[i2]);
        double d4 = this.O00000o[i2];
        double d5 = (double) fArr[i2];
        Double.isNaN(d5);
        return d4 + ((d5 - (dArr[i2] * d3)) * (d - dArr[i2])) + ((d3 * ((d * d) - (dArr[i2] * dArr[i2]))) / 2.0d);
    }

    public final double O000000o(double d) {
        double abs;
        switch (this.O00000oO) {
            case 1:
                return Math.signum(0.5d - (O00000o0(d) % 1.0d));
            case 2:
                abs = Math.abs((((O00000o0(d) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((O00000o0(d) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((O00000o0(d) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.O00000oo * O00000o0(d));
            case 6:
                double abs2 = 1.0d - Math.abs(((O00000o0(d) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.O00000oo * O00000o0(d));
        }
        return 1.0d - abs;
    }

    private double O00000o(double d) {
        if (d <= 0.0d) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.O00000o0, d);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i = (-binarySearch) - 1;
        float[] fArr = this.O00000Oo;
        int i2 = i - 1;
        double d2 = (double) (fArr[i] - fArr[i2]);
        double[] dArr = this.O00000o0;
        Double.isNaN(d2);
        double d3 = d2 / (dArr[i] - dArr[i2]);
        double d4 = d * d3;
        double d5 = (double) fArr[i2];
        Double.isNaN(d5);
        return (d5 - (d3 * dArr[i2])) + d4;
    }

    public final double O00000Oo(double d) {
        double O00000o2;
        double signum;
        double O00000o3;
        double O00000o4;
        double sin;
        switch (this.O00000oO) {
            case 1:
                return 0.0d;
            case 2:
                O00000o2 = O00000o(d) * 4.0d;
                signum = Math.signum((((O00000o0(d) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return O00000o2 * signum;
            case 3:
                O00000o3 = O00000o(d);
                return O00000o3 * 2.0d;
            case 4:
                O00000o3 = -O00000o(d);
                return O00000o3 * 2.0d;
            case 5:
                O00000o4 = (-this.O00000oo) * O00000o(d);
                sin = Math.sin(this.O00000oo * O00000o0(d));
                return O00000o4 * sin;
            case 6:
                O00000o2 = O00000o(d) * 4.0d;
                signum = (((O00000o0(d) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return O00000o2 * signum;
            default:
                O00000o4 = this.O00000oo * O00000o(d);
                sin = Math.cos(this.O00000oo * O00000o0(d));
                return O00000o4 * sin;
        }
    }
}
