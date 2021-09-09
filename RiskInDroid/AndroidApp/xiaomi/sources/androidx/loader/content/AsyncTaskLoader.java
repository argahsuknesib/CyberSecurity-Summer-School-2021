package androidx.loader.content;

import _m_j.bg;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.ModernAsyncTask;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    volatile AsyncTaskLoader<D>.O000000o mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader<D>.O000000o mTask;
    long mUpdateThrottle;

    public void cancelLoadInBackground() {
    }

    public abstract D loadInBackground();

    public void onCanceled(D d) {
    }

    final class O000000o extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        final CountDownLatch f2886O000000o = new CountDownLatch(1);
        boolean O00000Oo;

        O000000o() {
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000Oo */
        public D O000000o() {
            try {
                return AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException e) {
                if (this.O0000OOo.get()) {
                    return null;
                }
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        public final void O000000o(D d) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, d);
            } finally {
                this.f2886O000000o.countDown();
            }
        }

        /* access modifiers changed from: protected */
        public final void O00000Oo(D d) {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, d);
            } finally {
                this.f2886O000000o.countDown();
            }
        }

        public final void run() {
            this.O00000Oo = false;
            AsyncTaskLoader.this.executePendingTask();
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.O00000o);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new O000000o();
        executePendingTask();
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.O00000Oo) {
                this.mTask.O00000Oo = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.O00000Oo) {
            this.mTask.O00000Oo = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            AsyncTaskLoader<D>.O000000o o000000o = this.mTask;
            o000000o.O0000OOo.set(true);
            boolean cancel = o000000o.O00000oo.cancel(false);
            if (cancel) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return cancel;
        }
    }

    /* access modifiers changed from: package-private */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.O00000Oo) {
                this.mTask.O00000Oo = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                AsyncTaskLoader<D>.O000000o o000000o = this.mTask;
                Executor executor = this.mExecutor;
                if (o000000o.O0000O0o != ModernAsyncTask.Status.PENDING) {
                    int i = ModernAsyncTask.AnonymousClass4.f2890O000000o[o000000o.O0000O0o.ordinal()];
                    if (i == 1) {
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    } else if (i != 2) {
                        throw new IllegalStateException("We should never reach this state");
                    } else {
                        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    }
                } else {
                    o000000o.O0000O0o = ModernAsyncTask.Status.RUNNING;
                    o000000o.O00000oO.mParams = null;
                    executor.execute(o000000o.O00000oo);
                }
            } else {
                this.mTask.O00000Oo = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnCancelled(AsyncTaskLoader<D>.O000000o o000000o, D d) {
        onCanceled(d);
        if (this.mCancellingTask == o000000o) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.O000000o o000000o, D d) {
        if (this.mTask != o000000o) {
            dispatchOnCancelled(o000000o, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d);
        }
    }

    /* access modifiers changed from: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.O000000o o000000o = this.mTask;
        if (o000000o != null) {
            try {
                o000000o.f2886O000000o.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.O00000Oo);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.O00000Oo);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            bg.O000000o(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            bg.O000000o(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
