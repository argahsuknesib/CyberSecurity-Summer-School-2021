package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler extends Scheduler {
    private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory threadFactory;

    public NewThreadScheduler() {
        this(THREAD_FACTORY);
    }

    public NewThreadScheduler(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
    }

    @NonNull
    public final Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}
