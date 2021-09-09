package com.xiaomi.smarthome.library.common.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMonitor extends ThreadPoolExecutor {
    private String poolName;
    private ConcurrentHashMap<Integer, Long> startTimes = new ConcurrentHashMap<>();

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
    }

    public ThreadPoolMonitor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, String str, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.poolName = str;
    }
}
