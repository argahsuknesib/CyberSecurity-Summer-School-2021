package _m_j;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.youpin.common.thread.ThreadPool$1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ibg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Executor f1150O000000o = new ThreadPoolExecutor(O00000o0, 30, 60, TimeUnit.SECONDS, O00000oO, O00000o);
    private static final int O00000Oo;
    private static final ThreadFactory O00000o = new ThreadPool$1();
    private static final int O00000o0;
    private static final BlockingQueue<Runnable> O00000oO = new LinkedBlockingQueue((int) NotificationCompat.FLAG_HIGH_PRIORITY);

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        O00000Oo = availableProcessors;
        O00000o0 = availableProcessors + 1;
    }
}
