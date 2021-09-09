package _m_j;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class clq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f14092O000000o = "clq";
    public static final HashMap<Long, Integer> O00000oo = new HashMap<>();
    public ExecutorService O00000Oo = Executors.newSingleThreadExecutor();
    public int O00000o = 0;
    dty O00000o0;
    public AtomicInteger O00000oO = new AtomicInteger();
    long O0000O0o = 0;

    public clq(dty dty) {
        this.O00000o0 = dty;
    }

    public static int O000000o(long j) {
        Integer num = O00000oo.get(Long.valueOf(j));
        if (num == null) {
            num = -1;
        }
        return num.intValue();
    }

    public static void O000000o() {
        O00000oo.clear();
    }
}
