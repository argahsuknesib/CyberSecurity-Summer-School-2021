package _m_j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class fsu {
    private static volatile fsu O00000Oo;
    private static Object O00000o0 = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public ExecutorService f17074O000000o = Executors.newCachedThreadPool();

    private fsu() {
    }

    public static fsu O000000o() {
        if (O00000Oo == null) {
            synchronized (O00000o0) {
                if (O00000Oo == null) {
                    O00000Oo = new fsu();
                }
            }
        }
        return O00000Oo;
    }
}
