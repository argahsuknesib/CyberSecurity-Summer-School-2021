package com.lidroid.xutils.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityExecutor implements Executor {
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        /* class com.lidroid.xutils.task.PriorityExecutor.AnonymousClass1 */
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "PriorityExecutor #" + this.mCount.getAndIncrement());
        }
    };
    private final BlockingQueue<Runnable> mPoolWorkQueue;
    private final ThreadPoolExecutor mThreadPoolExecutor;

    public PriorityExecutor() {
        this(5);
    }

    public PriorityExecutor(int i) {
        this.mPoolWorkQueue = new PriorityObjectBlockingQueue();
        this.mThreadPoolExecutor = new ThreadPoolExecutor(i, 256, 1, TimeUnit.SECONDS, this.mPoolWorkQueue, sThreadFactory);
    }

    public int getPoolSize() {
        return this.mThreadPoolExecutor.getCorePoolSize();
    }

    public void setPoolSize(int i) {
        if (i > 0) {
            this.mThreadPoolExecutor.setCorePoolSize(i);
        }
    }

    public boolean isBusy() {
        return this.mThreadPoolExecutor.getActiveCount() >= this.mThreadPoolExecutor.getCorePoolSize();
    }

    public void execute(Runnable runnable) {
        this.mThreadPoolExecutor.execute(runnable);
    }
}
