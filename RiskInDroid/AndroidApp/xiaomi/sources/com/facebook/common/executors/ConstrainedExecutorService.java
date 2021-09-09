package com.facebook.common.executors;

import com.facebook.common.logging.FLog;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstrainedExecutorService extends AbstractExecutorService {
    public static final Class<?> TAG = ConstrainedExecutorService.class;
    private final Executor mExecutor;
    private volatile int mMaxConcurrency;
    private final AtomicInteger mMaxQueueSize;
    public final String mName;
    public final AtomicInteger mPendingWorkers;
    private final Worker mTaskRunner;
    public final BlockingQueue<Runnable> mWorkQueue;

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public ConstrainedExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i > 0) {
            this.mName = str;
            this.mExecutor = executor;
            this.mMaxConcurrency = i;
            this.mWorkQueue = blockingQueue;
            this.mTaskRunner = new Worker();
            this.mPendingWorkers = new AtomicInteger(0);
            this.mMaxQueueSize = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    public static ConstrainedExecutorService newConstrainedExecutor(String str, int i, int i2, Executor executor) {
        return new ConstrainedExecutorService(str, i, executor, new LinkedBlockingQueue(i2));
    }

    public boolean isIdle() {
        return this.mWorkQueue.isEmpty() && this.mPendingWorkers.get() == 0;
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        } else if (this.mWorkQueue.offer(runnable)) {
            int size = this.mWorkQueue.size();
            int i = this.mMaxQueueSize.get();
            if (size > i && this.mMaxQueueSize.compareAndSet(i, size)) {
                FLog.v(TAG, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
            }
            startWorkerIfNeeded();
        } else {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mWorkQueue.size());
        }
    }

    public void startWorkerIfNeeded() {
        int i = this.mPendingWorkers.get();
        while (i < this.mMaxConcurrency) {
            int i2 = i + 1;
            if (this.mPendingWorkers.compareAndSet(i, i2)) {
                FLog.v(TAG, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mMaxConcurrency));
                this.mExecutor.execute(this.mTaskRunner);
                return;
            }
            FLog.v(TAG, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mPendingWorkers.get();
        }
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    class Worker implements Runnable {
        private Worker() {
        }

        public void run() {
            AtomicInteger atomicInteger;
            boolean isEmpty;
            try {
                Runnable poll = ConstrainedExecutorService.this.mWorkQueue.poll();
                if (poll != null) {
                    poll.run();
                } else {
                    FLog.v(ConstrainedExecutorService.TAG, "%s: Worker has nothing to run", ConstrainedExecutorService.this.mName);
                }
                if (isEmpty) {
                    FLog.v(ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", ConstrainedExecutorService.this.mName, Integer.valueOf(atomicInteger.decrementAndGet()));
                }
            } finally {
                int decrementAndGet = ConstrainedExecutorService.this.mPendingWorkers.decrementAndGet();
                if (!ConstrainedExecutorService.this.mWorkQueue.isEmpty()) {
                    ConstrainedExecutorService.this.startWorkerIfNeeded();
                } else {
                    FLog.v(ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", ConstrainedExecutorService.this.mName, Integer.valueOf(decrementAndGet));
                }
            }
        }
    }
}
