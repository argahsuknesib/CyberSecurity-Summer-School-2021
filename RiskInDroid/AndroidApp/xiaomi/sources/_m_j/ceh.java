package _m_j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ceh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ExecutorService f13687O000000o = Executors.newFixedThreadPool(10);
    private static int O00000Oo = 10;

    public static void O000000o(Runnable runnable) {
        f13687O000000o.execute(runnable);
    }
}
