package com.xiaomi.youpin.common.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class AsyncThreadTask$1 implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AsyncThreadTask #" + this.mCount.getAndIncrement());
        thread.setPriority(10);
        return thread;
    }
}
