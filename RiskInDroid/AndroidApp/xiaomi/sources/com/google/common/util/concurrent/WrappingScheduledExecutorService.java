package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@CanIgnoreReturnValue
abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService {
    final ScheduledExecutorService delegate;

    protected WrappingScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = scheduledExecutorService;
    }

    public final ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.delegate.schedule(wrapTask(runnable), j, timeUnit);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.concurrent.Callable, java.util.concurrent.Callable<V>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final <V> ScheduledFuture<V> schedule(Callable<V> r2, long j, TimeUnit timeUnit) {
        return this.delegate.schedule(wrapTask((Callable) r2), j, timeUnit);
    }

    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.delegate.scheduleAtFixedRate(wrapTask(runnable), j, j2, timeUnit);
    }

    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.delegate.scheduleWithFixedDelay(wrapTask(runnable), j, j2, timeUnit);
    }
}
