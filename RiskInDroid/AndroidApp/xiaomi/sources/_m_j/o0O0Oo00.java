package _m_j;

public final class o0O0Oo00 {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[] f2241O000000o = new int[0];
    static final long[] O00000Oo = new long[0];
    static final Object[] O00000o0 = new Object[0];

    private static int O00000o0(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    public static int O000000o(int i) {
        return O00000o0(i * 4) / 4;
    }

    public static int O00000Oo(int i) {
        return O00000o0(i * 8) / 8;
    }

    public static boolean O000000o(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int O000000o(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    public static int O000000o(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else if (j2 <= j) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }
}
