package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtCompatible
final class ForwardingFluentFuture<V> extends FluentFuture<V> {
    private final ListenableFuture<V> delegate;

    ForwardingFluentFuture(ListenableFuture<V> listenableFuture) {
        this.delegate = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.delegate.cancel(z);
    }

    public final boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    public final boolean isDone() {
        return this.delegate.isDone();
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.delegate.get();
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.get(j, timeUnit);
    }
}
