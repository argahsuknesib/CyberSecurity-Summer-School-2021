package com.xiaomi.youpin.common.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool$1 implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.mCount.getAndIncrement());
    }
}
