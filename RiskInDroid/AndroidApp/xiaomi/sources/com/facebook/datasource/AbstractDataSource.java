package com.facebook.datasource;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public abstract class AbstractDataSource<T> implements DataSource<T> {
    private DataSourceStatus mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
    private Throwable mFailureThrowable = null;
    private boolean mIsClosed = false;
    private float mProgress = 0.0f;
    private T mResult = null;
    private final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers = new ConcurrentLinkedQueue<>();

    enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    /* access modifiers changed from: protected */
    public void closeResult(T t) {
    }

    protected AbstractDataSource() {
    }

    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    public synchronized boolean isFinished() {
        return this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS;
    }

    public synchronized boolean hasResult() {
        return this.mResult != null;
    }

    public synchronized T getResult() {
        return this.mResult;
    }

    public synchronized boolean hasFailed() {
        return this.mDataSourceStatus == DataSourceStatus.FAILURE;
    }

    public synchronized Throwable getFailureCause() {
        return this.mFailureThrowable;
    }

    public synchronized float getProgress() {
        return this.mProgress;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        closeResult(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (isFinished() != false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        notifyDataSubscribers();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.mSubscribers.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        if (r1 == null) goto L_0x0016;
     */
    public boolean close() {
        synchronized (this) {
            if (this.mIsClosed) {
                return false;
            }
            this.mIsClosed = true;
            T t = this.mResult;
            this.mResult = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        notifyDataSubscriber(r3, r4, hasFailed(), wasCancelled());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    public void subscribe(DataSubscriber<T> dataSubscriber, Executor executor) {
        boolean z;
        Preconditions.checkNotNull(dataSubscriber);
        Preconditions.checkNotNull(executor);
        synchronized (this) {
            if (!this.mIsClosed) {
                if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                    this.mSubscribers.add(Pair.create(dataSubscriber, executor));
                }
                if (!hasResult() && !isFinished()) {
                    if (!wasCancelled()) {
                        z = false;
                    }
                }
                z = true;
            }
        }
    }

    private void notifyDataSubscribers() {
        boolean hasFailed = hasFailed();
        boolean wasCancelled = wasCancelled();
        Iterator<Pair<DataSubscriber<T>, Executor>> it = this.mSubscribers.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            notifyDataSubscriber((DataSubscriber) next.first, (Executor) next.second, hasFailed, wasCancelled);
        }
    }

    private void notifyDataSubscriber(final DataSubscriber<T> dataSubscriber, Executor executor, final boolean z, final boolean z2) {
        executor.execute(new Runnable() {
            /* class com.facebook.datasource.AbstractDataSource.AnonymousClass1 */

            public void run() {
                if (z) {
                    dataSubscriber.onFailure(AbstractDataSource.this);
                } else if (z2) {
                    dataSubscriber.onCancellation(AbstractDataSource.this);
                } else {
                    dataSubscriber.onNewResult(AbstractDataSource.this);
                }
            }
        });
    }

    private synchronized boolean wasCancelled() {
        return isClosed() && !isFinished();
    }

    /* access modifiers changed from: protected */
    public boolean setResult(T t, boolean z) {
        boolean resultInternal = setResultInternal(t, z);
        if (resultInternal) {
            notifyDataSubscribers();
        }
        return resultInternal;
    }

    /* access modifiers changed from: protected */
    public boolean setFailure(Throwable th) {
        boolean failureInternal = setFailureInternal(th);
        if (failureInternal) {
            notifyDataSubscribers();
        }
        return failureInternal;
    }

    public boolean setProgress(float f) {
        boolean progressInternal = setProgressInternal(f);
        if (progressInternal) {
            notifyProgressUpdate();
        }
        return progressInternal;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0026, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0028, code lost:
        closeResult(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0025=Splitter:B:20:0x0025, B:24:0x002d=Splitter:B:24:0x002d} */
    private boolean setResultInternal(T t, boolean z) {
        T t2 = null;
        try {
            synchronized (this) {
                try {
                    if (!this.mIsClosed) {
                        if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                            if (z) {
                                this.mDataSourceStatus = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.mResult != t2) {
                                T t3 = this.mResult;
                                try {
                                    this.mResult = t2;
                                    r4 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t2 = t3;
                                    throw th;
                                }
                            } else {
                                r4 = t2;
                            }
                            try {
                            } catch (Throwable th2) {
                                t2 = r4;
                                th = th2;
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } finally {
            if (t2 != null) {
                closeResult(t2);
            }
        }
    }

    private synchronized boolean setFailureInternal(Throwable th) {
        if (!this.mIsClosed) {
            if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                this.mDataSourceStatus = DataSourceStatus.FAILURE;
                this.mFailureThrowable = th;
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001b, code lost:
        return false;
     */
    private synchronized boolean setProgressInternal(float f) {
        if (!this.mIsClosed) {
            if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                if (f < this.mProgress) {
                    return false;
                }
                this.mProgress = f;
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void notifyProgressUpdate() {
        Iterator<Pair<DataSubscriber<T>, Executor>> it = this.mSubscribers.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            final DataSubscriber dataSubscriber = (DataSubscriber) next.first;
            ((Executor) next.second).execute(new Runnable() {
                /* class com.facebook.datasource.AbstractDataSource.AnonymousClass2 */

                public void run() {
                    dataSubscriber.onProgressUpdate(AbstractDataSource.this);
                }
            });
        }
    }
}
