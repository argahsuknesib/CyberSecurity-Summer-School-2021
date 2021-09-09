package com.xiaomi.youpin.common.thread;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);
    private final String mThreadName;
    public final int mThreadPriority;

    public PriorityThreadFactory(int i, String str) {
        this.mThreadPriority = i;
        this.mThreadName = str;
    }

    public Thread newThread(final Runnable runnable) {
        AnonymousClass1 r0 = new Runnable() {
            /* class com.xiaomi.youpin.common.thread.PriorityThreadFactory.AnonymousClass1 */

            public final void run() {
                try {
                    Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        };
        return new Thread(r0, this.mThreadName + " #" + this.mCount.getAndIncrement());
    }
}
