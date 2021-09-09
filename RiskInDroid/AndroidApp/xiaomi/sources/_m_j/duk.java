package _m_j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class duk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ExecutorService f14949O000000o = Executors.newFixedThreadPool(3);

    public static void O000000o(Runnable runnable) {
        f14949O000000o.execute(runnable);
    }
}
