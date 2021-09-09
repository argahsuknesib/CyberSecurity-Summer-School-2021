package _m_j;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.common.threadpool.StatisticalRejectedExecutionPolicy;
import com.xiaomi.smarthome.library.common.threadpool.ThreadPoolMonitor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class goq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int f18096O000000o = Runtime.getRuntime().availableProcessors();
    private static final ThreadPoolExecutor O00000Oo = new ThreadPoolMonitor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue((int) NotificationCompat.FLAG_HIGH_PRIORITY), Executors.defaultThreadFactory(), "single-thread-pool", new StatisticalRejectedExecutionPolicy());
    private static final ThreadPoolExecutor O00000o;
    private static final ThreadPoolExecutor O00000o0;
    private static ThreadPoolExecutor O00000oO;
    private static final ThreadPoolExecutor O00000oo = new ThreadPoolMonitor(Math.max(5, f18096O000000o), Math.max(5, f18096O000000o), 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue((int) NotificationCompat.FLAG_HIGH_PRIORITY), Executors.defaultThreadFactory(), "default-thread-pool", new StatisticalRejectedExecutionPolicy());
    private static final ThreadPoolExecutor O0000O0o = new ThreadPoolMonitor(f18096O000000o + 1, 30, 60, TimeUnit.SECONDS, new LinkedBlockingQueue((int) NotificationCompat.FLAG_HIGH_PRIORITY), Executors.defaultThreadFactory(), "async-task-thread-pool", new StatisticalRejectedExecutionPolicy());
    private static final ScheduledExecutorService O0000OOo = Executors.newScheduledThreadPool(f18096O000000o + 1);

    static {
        int i = f18096O000000o;
        O00000o0 = new ThreadPoolMonitor((i * 2) + 1, (i * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue((int) NotificationCompat.FLAG_HIGH_PRIORITY), Executors.defaultThreadFactory(), "io-thread-pool", new StatisticalRejectedExecutionPolicy());
        int i2 = f18096O000000o;
        O00000o = new ThreadPoolMonitor(i2 + 1, (i2 * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue((int) NotificationCompat.FLAG_HIGH_PRIORITY), Executors.defaultThreadFactory(), "cpu-thread-pool", new StatisticalRejectedExecutionPolicy());
    }

    public static void O000000o(Runnable runnable) {
        O00000oo.execute(new gop(runnable, O000000o("executeTask")));
    }

    public static Future<?> O00000Oo(Runnable runnable) {
        return O00000oo.submit(new gop(runnable, O000000o("submitTask")));
    }

    public static void O00000o0(Runnable runnable) {
        O00000Oo.execute(new gop(runnable, O000000o("executeSingleTask")));
    }

    public static void O00000o(Runnable runnable) {
        O00000o.execute(new gop(runnable, O000000o("executeCpuTask")));
    }

    public static void O00000oO(Runnable runnable) {
        O00000o0.execute(new gop(runnable, O000000o("executeIoTask")));
    }

    public static Future<?> O000000o(Runnable runnable, long j) {
        return O0000OOo.schedule(new gop(runnable, O000000o("executeScheduledTask")), j, TimeUnit.MILLISECONDS);
    }

    public static ExecutorService O000000o() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (goq.class) {
            if (O00000oO == null) {
                O00000oO = new ThreadPoolMonitor(Math.max(gpy.O000000o(gkv.f17949O000000o, "SP_THREADPOOL_AB_CONFIG", "SP_THREADPOOL_COREPOOLSIZE", 10), 10), Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), Executors.defaultThreadFactory(), "OkHttp Dispatcher-thread-pool", new StatisticalRejectedExecutionPolicy());
            }
            threadPoolExecutor = O00000oO;
        }
        return threadPoolExecutor;
    }

    public static Executor O00000Oo() {
        return O0000O0o;
    }

    private static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i = 0;
        while (i < stackTrace.length) {
            if (!stackTrace[i].getClassName().contains("com.xiaomi.smarthome") || str.equalsIgnoreCase(stackTrace[i].getMethodName()) || "getRenameThreadName".equalsIgnoreCase(stackTrace[i].getMethodName())) {
                i++;
            } else {
                return stackTrace[i].getClassName() + "." + stackTrace[i].getMethodName();
            }
        }
        return "";
    }
}
