package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ThreadFactory f2889O000000o = new ThreadFactory() {
        /* class androidx.loader.content.ModernAsyncTask.AnonymousClass1 */
        private final AtomicInteger mCount = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> O00000Oo = new LinkedBlockingQueue(10);
    public static final Executor O00000o;
    private static O00000Oo O00000o0;
    private static volatile Executor O0000Oo;
    final WorkerRunnable<Params, Result> O00000oO = new WorkerRunnable<Params, Result>() {
        /* class androidx.loader.content.ModernAsyncTask.AnonymousClass2 */

        public Result call() throws Exception {
            ModernAsyncTask.this.O0000Oo0.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = ModernAsyncTask.this.O000000o();
                Binder.flushPendingCommands();
                ModernAsyncTask.this.O00000o(result);
                return result;
            } catch (Throwable th) {
                ModernAsyncTask.this.O00000o(result);
                throw th;
            }
        }
    };
    final FutureTask<Result> O00000oo = new FutureTask<Result>(this.O00000oO) {
        /* class androidx.loader.content.ModernAsyncTask.AnonymousClass3 */

        /* access modifiers changed from: protected */
        public void done() {
            try {
                ModernAsyncTask.this.O00000o0(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                ModernAsyncTask.this.O00000o0(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };
    volatile Status O0000O0o = Status.PENDING;
    final AtomicBoolean O0000OOo = new AtomicBoolean();
    final AtomicBoolean O0000Oo0 = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result O000000o();

    /* access modifiers changed from: protected */
    public void O000000o(Result result) {
    }

    /* access modifiers changed from: protected */
    public void O00000Oo(Result result) {
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, (int) NotificationCompat.FLAG_HIGH_PRIORITY, 1, TimeUnit.SECONDS, O00000Oo, f2889O000000o);
        O00000o = threadPoolExecutor;
        O0000Oo = threadPoolExecutor;
    }

    private static Handler O00000Oo() {
        O00000Oo o00000Oo;
        synchronized (ModernAsyncTask.class) {
            if (O00000o0 == null) {
                O00000o0 = new O00000Oo();
            }
            o00000Oo = O00000o0;
        }
        return o00000Oo;
    }

    ModernAsyncTask() {
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(Result result) {
        if (!this.O0000Oo0.get()) {
            O00000o(result);
        }
    }

    /* access modifiers changed from: package-private */
    public final Result O00000o(Result result) {
        O00000Oo().obtainMessage(1, new O000000o(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2890O000000o = new int[Status.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f2890O000000o[Status.RUNNING.ordinal()] = 1;
            f2890O000000o[Status.FINISHED.ordinal()] = 2;
        }
    }

    static class O00000Oo extends Handler {
        O00000Oo() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            O000000o o000000o = (O000000o) message.obj;
            if (message.what == 1) {
                o000000o.f2891O000000o.O00000oO(o000000o.O00000Oo[0]);
            }
        }
    }

    static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        WorkerRunnable() {
        }
    }

    static class O000000o<Data> {

        /* renamed from: O000000o  reason: collision with root package name */
        final ModernAsyncTask f2891O000000o;
        final Data[] O00000Oo;

        O000000o(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f2891O000000o = modernAsyncTask;
            this.O00000Oo = dataArr;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oO(Result result) {
        if (this.O0000OOo.get()) {
            O00000Oo(result);
        } else {
            O000000o(result);
        }
        this.O0000O0o = Status.FINISHED;
    }
}
