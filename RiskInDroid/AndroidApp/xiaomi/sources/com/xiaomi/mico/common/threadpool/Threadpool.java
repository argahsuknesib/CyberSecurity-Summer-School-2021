package com.xiaomi.mico.common.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadpool {
    private static final ExecutorService sExecutor = Executors.newCachedThreadPool();

    public static ExecutorService getSharedThreadPool() {
        return sExecutor;
    }
}
