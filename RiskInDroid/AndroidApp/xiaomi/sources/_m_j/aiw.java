package _m_j;

public final class aiw {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f12395O000000o = "-9223372036854775808".substring(1);
    static final String O00000Oo = "9223372036854775807";

    public static final int O000000o(char[] cArr, int i, int i2) {
        int i3 = cArr[i] - '0';
        int i4 = i2 + i;
        int i5 = i + 1;
        if (i5 >= i4) {
            return i3;
        }
        int i6 = (i3 * 10) + (cArr[i5] - '0');
        int i7 = i5 + 1;
        if (i7 >= i4) {
            return i6;
        }
        int i8 = (i6 * 10) + (cArr[i7] - '0');
        int i9 = i7 + 1;
        if (i9 >= i4) {
            return i8;
        }
        int i10 = (i8 * 10) + (cArr[i9] - '0');
        int i11 = i9 + 1;
        if (i11 >= i4) {
            return i10;
        }
        int i12 = (i10 * 10) + (cArr[i11] - '0');
        int i13 = i11 + 1;
        if (i13 >= i4) {
            return i12;
        }
        int i14 = (i12 * 10) + (cArr[i13] - '0');
        int i15 = i13 + 1;
        if (i15 >= i4) {
            return i14;
        }
        int i16 = (i14 * 10) + (cArr[i15] - '0');
        int i17 = i15 + 1;
        if (i17 >= i4) {
            return i16;
        }
        int i18 = (i16 * 10) + (cArr[i17] - '0');
        int i19 = i17 + 1;
        return i19 < i4 ? (i18 * 10) + (cArr[i19] - '0') : i18;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0075, code lost:
        return java.lang.Integer.parseInt(r8);
     */
    public static final int O000000o(String str) {
        boolean z = false;
        char charAt = str.charAt(0);
        int length = str.length();
        int i = 1;
        if (charAt == '-') {
            z = true;
        }
        if (z) {
            if (length == 1 || length > 10) {
                return Integer.parseInt(str);
            }
            charAt = str.charAt(1);
            i = 2;
        } else if (length > 9) {
            return Integer.parseInt(str);
        }
        if (charAt > '9' || charAt < '0') {
            return Integer.parseInt(str);
        }
        int i2 = charAt - '0';
        if (i < length) {
            int i3 = i + 1;
            char charAt2 = str.charAt(i);
            if (charAt2 > '9' || charAt2 < '0') {
                return Integer.parseInt(str);
            }
            i2 = (i2 * 10) + (charAt2 - '0');
            if (i3 < length) {
                int i4 = i3 + 1;
                char charAt3 = str.charAt(i3);
                if (charAt3 > '9' || charAt3 < '0') {
                    return Integer.parseInt(str);
                }
                i2 = (i2 * 10) + (charAt3 - '0');
                if (i4 < length) {
                    while (true) {
                        int i5 = i4 + 1;
                        char charAt4 = str.charAt(i4);
                        if (charAt4 <= '9' && charAt4 >= '0') {
                            i2 = (i2 * 10) + (charAt4 - '0');
                            if (i5 >= length) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                }
            }
        }
        return z ? -i2 : i2;
    }

    public static final long O00000Oo(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return (((long) O000000o(cArr, i, i3)) * 1000000000) + ((long) O000000o(cArr, i + i3, 9));
    }

    public static final long O00000Oo(String str) {
        if (str.length() <= 9) {
            return (long) O000000o(str);
        }
        return Long.parseLong(str);
    }

    public static final boolean O000000o(char[] cArr, int i, int i2, boolean z) {
        String str = z ? f12395O000000o : O00000Oo;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int charAt = cArr[i + i3] - str.charAt(i3);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static final boolean O00000o0(String str) {
        String str2 = O00000Oo;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int charAt = str.charAt(i) - str2.charAt(i);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r2 == '-') goto L_0x0029;
     */
    public static int O000000o(String str, int i) {
        String trim;
        int length;
        if (str == null || (length = (trim = str.trim()).length()) == 0) {
            return 0;
        }
        int i2 = 1;
        if (length > 0) {
            char charAt = trim.charAt(0);
            if (charAt == '+') {
                trim = trim.substring(1);
                length = trim.length();
            }
        }
        i2 = 0;
        while (i2 < length) {
            char charAt2 = trim.charAt(i2);
            if (charAt2 > '9' || charAt2 < '0') {
                try {
                    return (int) O00000o(trim);
                } catch (NumberFormatException unused) {
                    return 0;
                }
            } else {
                i2++;
            }
        }
        try {
            return Integer.parseInt(trim);
        } catch (NumberFormatException unused2) {
            return 0;
        }
    }

    public static long O000000o(String str, long j) {
        String trim;
        int length;
        if (str == null || (length = (trim = str.trim()).length()) == 0) {
            return 0;
        }
        int i = 0;
        if (length > 0) {
            char charAt = trim.charAt(0);
            if (charAt == '+') {
                trim = trim.substring(1);
                length = trim.length();
            } else if (charAt == '-') {
                i = 1;
            }
        }
        while (i < length) {
            char charAt2 = trim.charAt(i);
            if (charAt2 > '9' || charAt2 < '0') {
                try {
                    return (long) O00000o(trim);
                } catch (NumberFormatException unused) {
                    return 0;
                }
            } else {
                i++;
            }
        }
        try {
            return Long.parseLong(trim);
        } catch (NumberFormatException unused2) {
            return 0;
        }
    }

    public static final double O00000o(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }
}
