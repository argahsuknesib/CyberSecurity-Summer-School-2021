package bolts;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class AndroidExecutors {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int f3055O000000o;
    static final int O00000Oo = ((O00000oO * 2) + 1);
    private static final AndroidExecutors O00000o0 = new AndroidExecutors();
    private static final int O00000oO;
    private final Executor O00000o = new UIThreadExecutor();

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        O00000oO = availableProcessors;
        f3055O000000o = availableProcessors + 1;
    }

    private AndroidExecutors() {
    }

    public static ExecutorService O000000o() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f3055O000000o, O00000Oo, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return threadPoolExecutor;
    }

    public static Executor O00000Oo() {
        return O00000o0.O00000o;
    }

    static class UIThreadExecutor implements Executor {
        private UIThreadExecutor() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
