package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.RestrictTo;
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
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue(10);
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        /* class android.support.v4.content.ModernAsyncTask.AnonymousClass1 */
        private final AtomicInteger mCount = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    };
    public final AtomicBoolean mCancelled = new AtomicBoolean();
    private final FutureTask<Result> mFuture = new FutureTask<Result>(this.mWorker) {
        /* class android.support.v4.content.ModernAsyncTask.AnonymousClass3 */

        /* access modifiers changed from: protected */
        public void done() {
            try {
                ModernAsyncTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                ModernAsyncTask.this.postResultIfNotInvoked(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };
    private volatile Status mStatus = Status.PENDING;
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final WorkerRunnable<Params, Result> mWorker = new WorkerRunnable<Params, Result>() {
        /* class android.support.v4.content.ModernAsyncTask.AnonymousClass2 */

        public Result call() throws Exception {
            ModernAsyncTask.this.mTaskInvoked.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = ModernAsyncTask.this.doInBackground(this.mParams);
                Binder.flushPendingCommands();
                ModernAsyncTask.this.postResult(result);
                return result;
            } catch (Throwable th) {
                ModernAsyncTask.this.postResult(result);
                throw th;
            }
        }
    };

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground(Object... objArr);

    /* access modifiers changed from: protected */
    public void onCancelled() {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Progress... progressArr) {
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, (int) NotificationCompat.FLAG_HIGH_PRIORITY, 1, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        sDefaultExecutor = threadPoolExecutor;
    }

    private static Handler getHandler() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            internalHandler = sHandler;
        }
        return internalHandler;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    /* access modifiers changed from: package-private */
    public void postResultIfNotInvoked(Result result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    /* access modifiers changed from: package-private */
    public Result postResult(Result result) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
        onCancelled();
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$android$support$v4$content$ModernAsyncTask$Status = new int[Status.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$android$support$v4$content$ModernAsyncTask$Status[Status.RUNNING.ordinal()] = 1;
            $SwitchMap$android$support$v4$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = 2;
        }
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            int i = AnonymousClass4.$SwitchMap$android$support$v4$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    /* access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            getHandler().obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = Status.FINISHED;
    }

    static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
            } else if (i == 2) {
                asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
            }
        }
    }

    static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        WorkerRunnable() {
        }
    }

    static class AsyncTaskResult<Data> {
        final Data[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.mTask = modernAsyncTask;
            this.mData = dataArr;
        }
    }
}
