package _m_j;

public final class Oo0OOo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Oo0OOo f12346O000000o;
    public long O00000Oo;
    public int O00000o;
    public long O00000o0;

    public final void O000000o(long j, double d, double d2) {
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        float f2 = (0.01720197f * f) + 6.24006f;
        double d3 = (double) f2;
        Double.isNaN(d3);
        double sin = (Math.sin(d3) * 0.03341960161924362d) + d3 + (Math.sin((double) (2.0f * f2)) * 3.4906598739326E-4d) + (Math.sin((double) (f2 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double d5 = (double) (f - 9.0E-4f);
        Double.isNaN(d5);
        double round = (double) (((float) Math.round(d5 - d4)) + 9.0E-4f);
        Double.isNaN(round);
        double sin2 = round + d4 + (Math.sin(d3) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d6) * Math.sin(asin))) / (Math.cos(d6) * Math.cos(asin));
        if (sin3 >= 1.0d) {
            this.O00000o = 1;
            this.O00000Oo = -1;
            this.O00000o0 = -1;
        } else if (sin3 <= -1.0d) {
            this.O00000o = 0;
            this.O00000Oo = -1;
            this.O00000o0 = -1;
        } else {
            double acos = (double) ((float) (Math.acos(sin3) / 6.283185307179586d));
            Double.isNaN(acos);
            this.O00000Oo = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            Double.isNaN(acos);
            this.O00000o0 = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            if (this.O00000o0 >= j || this.O00000Oo <= j) {
                this.O00000o = 1;
            } else {
                this.O00000o = 0;
            }
        }
    }
}
