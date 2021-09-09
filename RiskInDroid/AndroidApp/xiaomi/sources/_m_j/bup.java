package _m_j;

import com.loc.df;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class bup {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final TimeUnit f13294O000000o = TimeUnit.SECONDS;
    private static final ThreadFactory O00000Oo = new df();
    private static final ExecutorService O00000o0 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, f13294O000000o, new SynchronousQueue(), O00000Oo);

    static ExecutorService O000000o() {
        return O00000o0;
    }
}
