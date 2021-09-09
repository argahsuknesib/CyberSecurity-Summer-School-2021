package _m_j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class O00o000 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static O00o000 f6652O000000o;
    public static ThreadPoolExecutor O00000Oo;

    public O00o000() {
        O00000Oo = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static O00o000 O000000o() {
        if (f6652O000000o == null) {
            synchronized (O00o000.class) {
                if (f6652O000000o == null) {
                    f6652O000000o = new O00o000();
                }
            }
        }
        return f6652O000000o;
    }

    public static void O000000o(Runnable runnable) {
        O00000Oo.execute(runnable);
    }
}
