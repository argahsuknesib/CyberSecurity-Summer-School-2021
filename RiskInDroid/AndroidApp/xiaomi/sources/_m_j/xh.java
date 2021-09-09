package _m_j;

import com.drew.lang.Rational;
import java.text.DecimalFormat;

public final class xh {

    /* renamed from: O000000o  reason: collision with root package name */
    public final double f2592O000000o;
    public final double O00000Oo;

    public xh(double d, double d2) {
        this.f2592O000000o = d;
        this.O00000Oo = d2;
    }

    public static Double O000000o(Rational rational, Rational rational2, Rational rational3, boolean z) {
        double abs = Math.abs(rational.doubleValue()) + (rational2.doubleValue() / 60.0d) + (rational3.doubleValue() / 3600.0d);
        if (Double.isNaN(abs)) {
            return null;
        }
        if (z) {
            abs *= -1.0d;
        }
        return Double.valueOf(abs);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xh xhVar = (xh) obj;
        return Double.compare(xhVar.f2592O000000o, this.f2592O000000o) == 0 && Double.compare(xhVar.O00000Oo, this.O00000Oo) == 0;
    }

    public final int hashCode() {
        double d = this.f2592O000000o;
        long j = 0;
        long doubleToLongBits = d != 0.0d ? Double.doubleToLongBits(d) : 0;
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        double d2 = this.O00000Oo;
        if (d2 != 0.0d) {
            j = Double.doubleToLongBits(d2);
        }
        return (i * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return this.f2592O000000o + ", " + this.O00000Oo;
    }

    public static String O000000o(double d) {
        int i = (int) d;
        double abs = Math.abs((d % 1.0d) * 60.0d);
        double[] dArr = {(double) i, (double) ((int) abs), (abs % 1.0d) * 60.0d};
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        return String.format("%s° %s' %s\"", decimalFormat.format(dArr[0]), decimalFormat.format(dArr[1]), decimalFormat.format(dArr[2]));
    }
}
