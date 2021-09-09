package _m_j;

import android.os.Looper;

public final class elu {
    public static void O000000o() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
