package _m_j;

import android.util.Log;
import java.util.Arrays;

public class o0OO0o00 {

    /* renamed from: O000000o  reason: collision with root package name */
    static o0OO0o00 f2251O000000o = new o0OO0o00();
    public static String[] O00000o0 = {"standard", "accelerate", "decelerate", "linear"};
    String O00000Oo = "identity";

    public double O000000o(double d) {
        return d;
    }

    public double O00000Oo(double d) {
        return 1.0d;
    }

    public static o0OO0o00 O000000o(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new O000000o(str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c = 1;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 3;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            return new O000000o("cubic(0.4, 0.0, 0.2, 1)");
        }
        if (c == 1) {
            return new O000000o("cubic(0.4, 0.05, 0.8, 0.7)");
        }
        if (c == 2) {
            return new O000000o("cubic(0.0, 0.0, 0.2, 0.95)");
        }
        if (c == 3) {
            return new O000000o("cubic(1, 1, 0, 0)");
        }
        Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(O00000o0));
        return f2251O000000o;
    }

    public String toString() {
        return this.O00000Oo;
    }

    static class O000000o extends o0OO0o00 {
        private static double O0000OOo = 0.01d;
        private static double O0000Oo0 = 1.0E-4d;
        double O00000o;
        double O00000oO;
        double O00000oo;
        double O0000O0o;

        O000000o(String str) {
            this.O00000Oo = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.O00000o = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.O00000oO = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.O00000oo = Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.O0000O0o = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        private double O00000o0(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.O00000o * d2 * d3 * d) + (this.O00000oo * d3 * d * d) + (d * d * d);
        }

        private double O00000o(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.O00000oO * d2 * d3 * d) + (this.O0000O0o * d3 * d * d) + (d * d * d);
        }

        public final double O00000Oo(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > O0000Oo0) {
                d2 *= 0.5d;
                d3 = O00000o0(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d3 + d2;
            return (O00000o(d5) - O00000o(d4)) / (O00000o0(d5) - O00000o0(d4));
        }

        public final double O000000o(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > O0000OOo) {
                d2 *= 0.5d;
                d3 = O00000o0(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double O00000o0 = O00000o0(d4);
            double d5 = d3 + d2;
            double O00000o02 = O00000o0(d5);
            double O00000o2 = O00000o(d4);
            return (((O00000o(d5) - O00000o2) * (d - O00000o0)) / (O00000o02 - O00000o0)) + O00000o2;
        }
    }
}
