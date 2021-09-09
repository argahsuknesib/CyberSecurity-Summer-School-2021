package _m_j;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public final class gbm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile Scheduler f17500O000000o;
    private static final int O00000Oo = Runtime.getRuntime().availableProcessors();
    private static final ThreadPoolExecutor O00000o = new ThreadPoolExecutor(O00000o0, 32, 10, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private static final int O00000o0 = Math.min(5, O00000Oo);

    private static Scheduler O00000Oo() {
        if (f17500O000000o == null) {
            synchronized ("MRnSchedulers") {
                if (f17500O000000o == null) {
                    f17500O000000o = Schedulers.from(O00000o);
                }
            }
        }
        return f17500O000000o;
    }

    public static Scheduler O000000o() {
        if (f17500O000000o == null) {
            return O00000Oo();
        }
        return f17500O000000o;
    }
}
