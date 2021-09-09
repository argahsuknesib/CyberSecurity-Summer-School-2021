package _m_j;

import com.xiaomi.youpin.login.other.common.PriorityThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class icn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int f1192O000000o = Runtime.getRuntime().availableProcessors();
    private static final ThreadPoolExecutor O00000Oo;

    static {
        PriorityThreadFactory priorityThreadFactory = new PriorityThreadFactory(10, "ForLightWeightBackgroundTasks");
        int i = f1192O000000o;
        O00000Oo = new ThreadPoolExecutor(i * 2, i * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), priorityThreadFactory);
    }

    public static void O000000o(Runnable runnable) {
        O00000Oo.execute(runnable);
    }
}
