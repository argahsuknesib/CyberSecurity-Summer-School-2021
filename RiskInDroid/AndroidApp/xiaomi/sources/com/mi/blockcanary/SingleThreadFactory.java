package com.mi.blockcanary;

import java.util.concurrent.ThreadFactory;

public final class SingleThreadFactory implements ThreadFactory {
    private final String threadName;

    public SingleThreadFactory(String str) {
        this.threadName = "BlockCanary-".concat(String.valueOf(str));
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.threadName);
    }
}
