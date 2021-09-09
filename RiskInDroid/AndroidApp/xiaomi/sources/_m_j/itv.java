package _m_j;

public final class itv {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final char[] f1627O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String O00000Oo;
    private static final char[] O00000o = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private static final int O00000o0;

    static {
        String property = System.getProperty("line.separator");
        O00000Oo = property;
        O00000o0 = property.length();
    }

    public static String O000000o(int i) {
        char[] cArr = new char[8];
        int i2 = i;
        for (int i3 = 8; i3 > 0; i3--) {
            int i4 = (i3 + 0) - 1;
            if (i4 < 8) {
                cArr[i4] = f1627O000000o[i2 & 15];
            }
            if (i2 != 0) {
                i2 >>>= 4;
            }
        }
        return new String(cArr);
    }
}
