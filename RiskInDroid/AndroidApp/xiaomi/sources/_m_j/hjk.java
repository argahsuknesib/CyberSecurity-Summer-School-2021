package _m_j;

public final class hjk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static double f18990O000000o = 3.141592653589793d;
    public static double O00000Oo = 6378245.0d;
    public static double O00000o0 = 0.006693421622965943d;

    private static boolean O00000o(double d, double d2) {
        return d2 < 72.004d || d2 > 137.8347d || d < 0.8293d || d > 55.8271d;
    }

    public static hpv O000000o(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        if (O00000o(d, d2)) {
            return new hpv(d3, d4);
        }
        double d5 = d4 - 105.0d;
        double d6 = d3 - 35.0d;
        double O00000oO = O00000oO(d5, d6);
        double O00000oo = O00000oo(d5, d6);
        double d7 = (d3 / 180.0d) * f18990O000000o;
        double sin = Math.sin(d7);
        double d8 = 1.0d - ((O00000o0 * sin) * sin);
        double sqrt = Math.sqrt(d8);
        double d9 = O00000Oo;
        return new hpv(d3 + ((O00000oO * 180.0d) / ((((1.0d - O00000o0) * d9) / (d8 * sqrt)) * f18990O000000o)), d4 + ((O00000oo * 180.0d) / (((d9 / sqrt) * Math.cos(d7)) * f18990O000000o)));
    }

    private static double O00000oO(double d, double d2) {
        double d3 = d * 2.0d;
        return -100.0d + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d * 6.0d) * f18990O000000o) * 20.0d) + (Math.sin(d3 * f18990O000000o) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f18990O000000o * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f18990O000000o) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f18990O000000o) * 160.0d) + (Math.sin((d2 * f18990O000000o) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double O00000oo(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * f18990O000000o) * 20.0d) + (Math.sin((d * 2.0d) * f18990O000000o) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f18990O000000o * d) * 20.0d) + (Math.sin((d / 3.0d) * f18990O000000o) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * f18990O000000o) * 150.0d) + (Math.sin((d / 30.0d) * f18990O000000o) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static hpv O00000o0(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        if (O00000o(d, d2)) {
            return new hpv(d3, d4);
        }
        double d5 = d4 - 105.0d;
        double d6 = d3 - 35.0d;
        double O00000oO = O00000oO(d5, d6);
        double O00000oo = O00000oo(d5, d6);
        double d7 = (d3 / 180.0d) * f18990O000000o;
        double sin = Math.sin(d7);
        double d8 = 1.0d - ((O00000o0 * sin) * sin);
        double sqrt = Math.sqrt(d8);
        double d9 = O00000Oo;
        return new hpv(d3 - ((O00000oO * 180.0d) / ((((1.0d - O00000o0) * d9) / (d8 * sqrt)) * f18990O000000o)), d4 - ((O00000oo * 180.0d) / (((d9 / sqrt) * Math.cos(d7)) * f18990O000000o)));
    }

    public static hpv O00000Oo(double d, double d2) {
        hpv hpv;
        double d3 = d;
        double d4 = d2;
        if (O00000o(d, d2)) {
            hpv = new hpv(d3, d4);
        } else {
            double d5 = d4 - 105.0d;
            double d6 = d3 - 35.0d;
            double O00000oO = O00000oO(d5, d6);
            double O00000oo = O00000oo(d5, d6);
            double d7 = (d3 / 180.0d) * f18990O000000o;
            double sin = Math.sin(d7);
            double d8 = 1.0d - ((O00000o0 * sin) * sin);
            double sqrt = Math.sqrt(d8);
            double d9 = O00000Oo;
            hpv = new hpv(d3 + ((O00000oO * 180.0d) / ((((1.0d - O00000o0) * d9) / (d8 * sqrt)) * f18990O000000o)), ((O00000oo * 180.0d) / (((d9 / sqrt) * Math.cos(d7)) * f18990O000000o)) + d4);
        }
        return new hpv((d4 * 2.0d) - hpv.f511O000000o, (d3 * 2.0d) - hpv.O00000Oo);
    }
}
