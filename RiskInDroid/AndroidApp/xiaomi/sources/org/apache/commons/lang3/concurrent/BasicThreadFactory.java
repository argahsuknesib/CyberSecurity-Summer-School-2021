package org.apache.commons.lang3.concurrent;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class BasicThreadFactory implements ThreadFactory {
    private final Boolean daemonFlag;
    private final String namingPattern;
    private final Integer priority;
    private final AtomicLong threadCounter;
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final ThreadFactory wrappedFactory;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ThreadFactory f15433O000000o;
        public Thread.UncaughtExceptionHandler O00000Oo;
        public Integer O00000o;
        public String O00000o0;
        public Boolean O00000oO;
    }

    private BasicThreadFactory(O000000o o000000o) {
        if (o000000o.f15433O000000o == null) {
            this.wrappedFactory = Executors.defaultThreadFactory();
        } else {
            this.wrappedFactory = o000000o.f15433O000000o;
        }
        this.namingPattern = o000000o.O00000o0;
        this.priority = o000000o.O00000o;
        this.daemonFlag = o000000o.O00000oO;
        this.uncaughtExceptionHandler = o000000o.O00000Oo;
        this.threadCounter = new AtomicLong();
    }

    public final ThreadFactory getWrappedFactory() {
        return this.wrappedFactory;
    }

    public final String getNamingPattern() {
        return this.namingPattern;
    }

    public final Boolean getDaemonFlag() {
        return this.daemonFlag;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.uncaughtExceptionHandler;
    }

    public long getThreadCount() {
        return this.threadCounter.get();
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = getWrappedFactory().newThread(runnable);
        initializeThread(newThread);
        return newThread;
    }

    private void initializeThread(Thread thread) {
        if (getNamingPattern() != null) {
            Long valueOf = Long.valueOf(this.threadCounter.incrementAndGet());
            thread.setName(String.format(getNamingPattern(), valueOf));
        }
        if (getUncaughtExceptionHandler() != null) {
            thread.setUncaughtExceptionHandler(getUncaughtExceptionHandler());
        }
        if (getPriority() != null) {
            thread.setPriority(getPriority().intValue());
        }
        if (getDaemonFlag() != null) {
            thread.setDaemon(getDaemonFlag().booleanValue());
        }
    }
}
