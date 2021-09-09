package com.xiaomi.onetrack.h;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadPoolExecutor f6175a;
    private static int b = (Runtime.getRuntime().availableProcessors() + 1);

    static {
        int i = b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
        f6175a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        try {
            f6175a.execute(runnable);
        } catch (Throwable unused) {
        }
    }
}
