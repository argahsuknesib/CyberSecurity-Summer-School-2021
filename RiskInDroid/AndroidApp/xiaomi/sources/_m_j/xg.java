package _m_j;

public final class xg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int[] f2591O000000o = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean O00000Oo(int i, int i2, int i3) {
        return i >= 0 && i < 24 && i2 >= 0 && i2 < 60 && i3 >= 0 && i3 < 60;
    }

    public static boolean O000000o(int i, int i2, int i3) {
        if (i > 0 && i <= 9999 && i2 >= 0 && i2 <= 11) {
            int i4 = f2591O000000o[i2];
            if (i2 == 1) {
                if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                    i4++;
                }
            }
            return i3 > 0 && i3 <= i4;
        }
    }
}
