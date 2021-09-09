package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@Beta
public interface ListeningScheduledExecutorService extends ListeningExecutorService, ScheduledExecutorService {

    /* renamed from: com.google.common.util.concurrent.ListeningScheduledExecutorService$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit);

    <V> ListenableScheduledFuture<V> schedule(Callable callable, long j, TimeUnit timeUnit);

    ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit);
}
