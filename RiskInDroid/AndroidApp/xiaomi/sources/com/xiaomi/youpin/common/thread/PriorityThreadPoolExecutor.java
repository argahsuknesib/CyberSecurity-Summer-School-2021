package com.xiaomi.youpin.common.thread;

import _m_j.ibf;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {
    public PriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
    }

    public Future<?> submit(Runnable runnable) {
        PriorityFutureTask priorityFutureTask = new PriorityFutureTask((ibf) runnable);
        execute(priorityFutureTask);
        return priorityFutureTask;
    }

    static final class PriorityFutureTask extends FutureTask<ibf> implements Comparable<PriorityFutureTask> {
        private final ibf priorityRunnable;

        public PriorityFutureTask(ibf ibf) {
            super(ibf, null);
            this.priorityRunnable = ibf;
        }

        public final int compareTo(PriorityFutureTask priorityFutureTask) {
            return priorityFutureTask.priorityRunnable.f1149O000000o.ordinal() - this.priorityRunnable.f1149O000000o.ordinal();
        }
    }
}
