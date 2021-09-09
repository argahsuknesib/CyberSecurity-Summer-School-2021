package com.alibaba.android.arouter.thread;

import _m_j.ny;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public DefaultThreadFactory() {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.group = threadGroup;
        this.namePrefix = "ARouter task pool No." + poolNumber.getAndIncrement() + ", thread No.";
    }

    public Thread newThread(Runnable runnable) {
        String str = this.namePrefix + this.threadNumber.getAndIncrement();
        ny.f2212O000000o.info("ARouter::", "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.group, runnable, str, 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            /* class com.alibaba.android.arouter.thread.DefaultThreadFactory.AnonymousClass1 */

            public final void uncaughtException(Thread thread, Throwable th) {
                ILogger iLogger = ny.f2212O000000o;
                iLogger.info("ARouter::", "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th.getMessage() + "]");
            }
        });
        return thread;
    }
}
