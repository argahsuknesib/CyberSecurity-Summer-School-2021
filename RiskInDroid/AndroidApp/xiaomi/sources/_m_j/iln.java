package _m_j;

import android.os.AsyncTask;
import com.ximalaya.ting.android.opensdk.util.MyAsyncTask$1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class iln<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f1446O000000o = new LinkedBlockingQueue();
    private static final ThreadFactory O00000Oo = new MyAsyncTask$1();
    public static final ThreadPoolExecutor O00000o;
    public static String O00000o0 = "MyAsyncTask";
    private static final int O00000oO = Runtime.getRuntime().availableProcessors();
    private static final int O00000oo = Math.max(2, Math.min(O00000oO - 1, 4));
    private static final int O0000O0o = ((O00000oO * 2) + 1);

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(O00000oo, O0000O0o, 30, TimeUnit.SECONDS, f1446O000000o, O00000Oo);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        O00000o = threadPoolExecutor;
    }

    public final iln<Params, Progress, Result> O000000o(Object... objArr) {
        ilk.O00000Oo("MyAsyncTask", "MyAsyncTask --- myexec ".concat(String.valueOf(this)));
        executeOnExecutor(O00000o, objArr);
        return this;
    }

    public static void O000000o(Runnable runnable) {
        O00000o.execute(runnable);
    }

    public static void O00000Oo(Runnable runnable) {
        if (O00000o.getQueue().size() < 10) {
            O00000o.execute(runnable);
        }
    }
}
