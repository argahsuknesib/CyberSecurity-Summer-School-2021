package _m_j;

public final class aui {
    public static float O000000o(float f) {
        if (f > 0.0f) {
            return 0.0f;
        }
        return f;
    }

    public static float O00000Oo(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    public static int O00000o0(float f) {
        double d = (double) f;
        Double.isNaN(d);
        return ((int) (d + 16384.0d)) - 16384;
    }

    public static int O00000o(float f) {
        double d = (double) f;
        Double.isNaN(d);
        return ((int) (d + 16384.999999999996d)) - 16384;
    }
}
