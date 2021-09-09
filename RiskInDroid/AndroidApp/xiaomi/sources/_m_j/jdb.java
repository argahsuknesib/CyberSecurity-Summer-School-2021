package _m_j;

public final class jdb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Long f1772O000000o = 0L;
    public static final Long O00000Oo = 1L;
    public static final Integer O00000o = 0;
    public static final Long O00000o0 = -1L;
    public static final Integer O00000oO = 1;
    public static final Integer O00000oo = -1;
    public static final Short O0000O0o = 0;
    public static final Short O0000OOo = 1;
    public static final Byte O0000Oo = (byte) 0;
    public static final Short O0000Oo0 = -1;
    public static final Byte O0000OoO = (byte) 1;
    public static final Byte O0000Ooo = (byte) -1;
    public static final Float O0000o = Float.valueOf(1.0f);
    public static final Double O0000o0 = Double.valueOf(1.0d);
    public static final Double O0000o00 = Double.valueOf(0.0d);
    public static final Double O0000o0O = Double.valueOf(-1.0d);
    public static final Float O0000o0o = Float.valueOf(0.0f);
    public static final Float O0000oO0 = Float.valueOf(-1.0f);

    public static boolean O000000o(String str) {
        boolean z = true;
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = charArray[0] == '-' ? 1 : 0;
        int i2 = i + 1;
        if (length > i2 && charArray[i] == '0' && charArray[i2] == 'x') {
            int i3 = i + 2;
            if (i3 == length) {
                return false;
            }
            while (i3 < charArray.length) {
                if ((charArray[i3] < '0' || charArray[i3] > '9') && ((charArray[i3] < 'a' || charArray[i3] > 'f') && (charArray[i3] < 'A' || charArray[i3] > 'F'))) {
                    return false;
                }
                i3++;
            }
            return true;
        }
        int i4 = length - 1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            if (i >= i4) {
                if (i >= i4 + 1 || !z2 || z3) {
                }
            }
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                z2 = false;
                z3 = true;
            } else if (charArray[i] == '.') {
                if (z5 || z4) {
                    return false;
                }
                z5 = true;
            } else if (charArray[i] != 'e' && charArray[i] != 'E') {
                if (charArray[i] != '+') {
                    if (charArray[i] != '-') {
                        return false;
                    }
                }
                if (!z2) {
                    return false;
                }
                z2 = false;
                z3 = false;
            } else if (z4 || !z3) {
                return false;
            } else {
                z2 = true;
                z4 = true;
            }
            i++;
            z = true;
        }
        if (i < charArray.length) {
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                return z;
            }
            if (!(charArray[i] == 'e' || charArray[i] == 'E')) {
                if (charArray[i] == '.') {
                    if (z5 || z4) {
                        return false;
                    }
                    return z3;
                } else if (!z2 && (charArray[i] == 'd' || charArray[i] == 'D' || charArray[i] == 'f' || charArray[i] == 'F')) {
                    return z3;
                } else {
                    if ((charArray[i] == 'l' || charArray[i] == 'L') && z3 && !z4) {
                        return z;
                    }
                }
            }
            return false;
        } else if (z2 || !z3) {
            return false;
        } else {
            return z;
        }
    }
}
