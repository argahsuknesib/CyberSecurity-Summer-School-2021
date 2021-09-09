package com.alibaba.android.arouter.thread;

import _m_j.ny;
import _m_j.oe;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultPoolExecutor extends ThreadPoolExecutor {
    private static final int CPU_COUNT;
    private static final int INIT_THREAD_COUNT;
    private static final int MAX_THREAD_COUNT;
    private static DefaultPoolExecutor instance;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int i = availableProcessors + 1;
        INIT_THREAD_COUNT = i;
        MAX_THREAD_COUNT = i;
    }

    public static DefaultPoolExecutor getInstance() {
        if (instance == null) {
            synchronized (DefaultPoolExecutor.class) {
                if (instance == null) {
                    instance = new DefaultPoolExecutor(INIT_THREAD_COUNT, MAX_THREAD_COUNT, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new DefaultThreadFactory());
                }
            }
        }
        return instance;
    }

    private DefaultPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandler() {
            /* class com.alibaba.android.arouter.thread.DefaultPoolExecutor.AnonymousClass1 */

            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                ny.f2212O000000o.error("ARouter::", "Task rejected, too many task!");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (CancellationException e) {
                th = e;
            } catch (ExecutionException e2) {
                th = e2.getCause();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (th != null) {
            ILogger iLogger = ny.f2212O000000o;
            iLogger.warning("ARouter::", "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th.getMessage() + "]\n" + oe.O000000o(th.getStackTrace()));
        }
    }
}
