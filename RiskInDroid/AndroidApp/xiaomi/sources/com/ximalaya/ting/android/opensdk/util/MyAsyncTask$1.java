package com.ximalaya.ting.android.opensdk.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyAsyncTask$1 implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "MyAsyncTask #" + this.mCount.getAndIncrement());
    }
}
