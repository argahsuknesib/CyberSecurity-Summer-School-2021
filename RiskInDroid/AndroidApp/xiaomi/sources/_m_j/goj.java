package _m_j;

public final class goj {
    public static int O000000o(int i) {
        if (i == 0) {
            return 1100;
        }
        if (i == 1) {
            return 1400;
        }
        return i == 3 ? 1200 : 1900;
    }

    public static boolean O000000o(int i, int i2) {
        return (i2 == 0 && i > 7) || (i2 == 1 && i > 3) || (i2 == 3 && i > 35);
    }
}
