package _m_j;

public final class aix {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f12396O000000o = "-9223372036854775808";
    static final char[] O00000Oo = new char[4000];
    static final byte[] O00000o = new byte[4000];
    static final char[] O00000o0 = new char[4000];
    static final String[] O00000oO = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static final String[] O00000oo = {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    private static int O0000O0o = 1000000;
    private static int O0000OOo = 1000000000;
    private static long O0000Oo = 1000;
    private static long O0000Oo0 = 10000000000L;
    private static long O0000OoO = -2147483648L;
    private static long O0000Ooo = 2147483647L;

    static {
        int i = 0;
        int i2 = 0;
        while (i < 10) {
            char c = (char) (i + 48);
            char c2 = i == 0 ? 0 : c;
            int i3 = i2;
            int i4 = 0;
            while (i4 < 10) {
                char c3 = (char) (i4 + 48);
                char c4 = (i == 0 && i4 == 0) ? 0 : c3;
                int i5 = i3;
                for (int i6 = 0; i6 < 10; i6++) {
                    char c5 = (char) (i6 + 48);
                    char[] cArr = O00000Oo;
                    cArr[i5] = c2;
                    int i7 = i5 + 1;
                    cArr[i7] = c4;
                    int i8 = i5 + 2;
                    cArr[i8] = c5;
                    char[] cArr2 = O00000o0;
                    cArr2[i5] = c;
                    cArr2[i7] = c3;
                    cArr2[i8] = c5;
                    i5 += 4;
                }
                i4++;
                i3 = i5;
            }
            i++;
            i2 = i3;
        }
        for (int i9 = 0; i9 < 4000; i9++) {
            O00000o[i9] = (byte) O00000o0[i9];
        }
    }

    public static int O000000o(int i, char[] cArr, int i2) {
        int i3;
        int i4;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return O000000o((long) i, cArr, i2);
            }
            cArr[i2] = '-';
            i = -i;
            i2++;
        }
        if (i >= O0000O0o) {
            boolean z = i >= O0000OOo;
            if (z) {
                int i5 = O0000OOo;
                i -= i5;
                if (i >= i5) {
                    i -= i5;
                    i3 = i2 + 1;
                    cArr[i2] = '2';
                } else {
                    i3 = i2 + 1;
                    cArr[i2] = '1';
                }
            } else {
                i3 = i2;
            }
            int i6 = i / 1000;
            int i7 = i - (i6 * 1000);
            int i8 = i6 / 1000;
            int i9 = i6 - (i8 * 1000);
            if (z) {
                i4 = O00000o0(i8, cArr, i3);
            } else {
                i4 = O00000Oo(i8, cArr, i3);
            }
            return O00000o0(i7, cArr, O00000o0(i9, cArr, i4));
        } else if (i >= 1000) {
            int i10 = i / 1000;
            return O00000o0(i - (i10 * 1000), cArr, O00000Oo(i10, cArr, i2));
        } else if (i >= 10) {
            return O00000Oo(i, cArr, i2);
        } else {
            int i11 = i2 + 1;
            cArr[i2] = (char) (i + 48);
            return i11;
        }
    }

    public static int O000000o(long j, char[] cArr, int i) {
        if (j < 0) {
            if (j > O0000OoO) {
                return O000000o((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                int length = f12396O000000o.length();
                f12396O000000o.getChars(0, length, cArr, i);
                return i + length;
            }
            cArr[i] = '-';
            j = -j;
            i++;
        } else if (j <= O0000Ooo) {
            return O000000o((int) j, cArr, i);
        }
        int O00000Oo2 = O00000Oo(j) + i;
        int i2 = O00000Oo2;
        while (j > O0000Ooo) {
            i2 -= 3;
            long j2 = O0000Oo;
            long j3 = j / j2;
            O00000o0((int) (j - (j2 * j3)), cArr, i2);
            j = j3;
        }
        int i3 = (int) j;
        while (i3 >= 1000) {
            i2 -= 3;
            int i4 = i3 / 1000;
            O00000o0(i3 - (i4 * 1000), cArr, i2);
            i3 = i4;
        }
        O00000Oo(i3, cArr, i);
        return O00000Oo2;
    }

    public static String O000000o(int i) {
        String[] strArr = O00000oO;
        if (i < strArr.length) {
            if (i >= 0) {
                return strArr[i];
            }
            int i2 = (-i) - 1;
            String[] strArr2 = O00000oo;
            if (i2 < strArr2.length) {
                return strArr2[i2];
            }
        }
        return Integer.toString(i);
    }

    public static String O000000o(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            return Long.toString(j);
        }
        return O000000o((int) j);
    }

    public static String O000000o(double d) {
        return Double.toString(d);
    }

    private static int O00000Oo(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = O00000Oo[i3];
        if (c != 0) {
            cArr[i2] = c;
            i2++;
        }
        int i5 = i4 + 1;
        char c2 = O00000Oo[i4];
        if (c2 != 0) {
            cArr[i2] = c2;
            i2++;
        }
        int i6 = i2 + 1;
        cArr[i2] = O00000Oo[i5];
        return i6;
    }

    private static int O00000o0(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        char[] cArr2 = O00000o0;
        int i5 = i3 + 1;
        cArr[i2] = cArr2[i3];
        int i6 = i4 + 1;
        cArr[i4] = cArr2[i5];
        int i7 = i6 + 1;
        cArr[i6] = cArr2[i5 + 1];
        return i7;
    }

    private static int O00000Oo(long j) {
        int i = 10;
        for (long j2 = O0000Oo0; j >= j2 && i != 19; j2 = (j2 << 1) + (j2 << 3)) {
            i++;
        }
        return i;
    }
}
