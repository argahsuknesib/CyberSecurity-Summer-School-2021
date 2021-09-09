package _m_j;

import android.os.Looper;

public final class bni {
    public static <T> T O000000o(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void O000000o() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread. Was: " + Thread.currentThread());
        }
    }
}
