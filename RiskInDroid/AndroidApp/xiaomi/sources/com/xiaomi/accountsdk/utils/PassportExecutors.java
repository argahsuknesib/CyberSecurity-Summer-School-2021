package com.xiaomi.accountsdk.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PassportExecutors {
    public static ExecutorService newFixedThreadPool(int i, final String str) {
        return Executors.newFixedThreadPool(i, new ThreadFactory() {
            /* class com.xiaomi.accountsdk.utils.PassportExecutors.AnonymousClass1 */
            private final AtomicInteger mCount = new AtomicInteger(1);

            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, str + " #" + this.mCount.getAndIncrement());
            }
        });
    }
}
