package _m_j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class azg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static azg f12732O000000o;
    private static ThreadPoolExecutor O00000Oo;

    private azg() {
        O00000Oo = new ThreadPoolExecutor(0, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static azg O000000o() {
        if (f12732O000000o == null) {
            synchronized (azg.class) {
                if (f12732O000000o == null) {
                    f12732O000000o = new azg();
                }
            }
        }
        return f12732O000000o;
    }

    public static void O000000o(Runnable runnable) {
        O00000Oo.execute(runnable);
    }
}
