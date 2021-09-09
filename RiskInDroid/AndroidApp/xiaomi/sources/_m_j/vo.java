package _m_j;

import android.os.Looper;

public final class vo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f2550O000000o = "0123456789abcdef".toCharArray();
    private static final char[] O00000Oo = new char[64];

    private static boolean O000000o(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean O000000o(int i, int i2) {
        return O000000o(i) && O000000o(i2);
    }

    public static void O000000o() {
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }
}
