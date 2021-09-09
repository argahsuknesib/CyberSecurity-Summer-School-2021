package com.xiaomi.accountsdk.request;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IPExecutorService {
    static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void execute(Runnable runnable) {
        executorService.execute(runnable);
    }
}
