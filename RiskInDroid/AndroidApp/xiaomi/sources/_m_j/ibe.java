package _m_j;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.youpin.common.thread.Executors$1;
import com.xiaomi.youpin.common.thread.PriorityThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ibe {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int f1148O000000o = Runtime.getRuntime().availableProcessors();
    public static final Handler O00000Oo = new Handler(Looper.getMainLooper());
    private static final ThreadPoolExecutor O00000o;
    private static final ThreadPoolExecutor O00000o0;
    private static final Executor O00000oO = new Executors$1();

    static {
        PriorityThreadFactory priorityThreadFactory = new PriorityThreadFactory(10, "ForBackgroundTasks");
        int i = f1148O000000o;
        O00000o0 = new ThreadPoolExecutor(i * 2, i * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), priorityThreadFactory);
        PriorityThreadFactory priorityThreadFactory2 = new PriorityThreadFactory(10, "ForLightWeightBackgroundTasks");
        int i2 = f1148O000000o;
        O00000o = new ThreadPoolExecutor(i2 * 2, i2 * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), priorityThreadFactory2);
    }
}
