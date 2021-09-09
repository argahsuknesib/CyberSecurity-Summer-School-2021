package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Partially;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtCompatible(emulated = true)
@Beta
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        TrustedFuture() {
        }

        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return FluentFuture.super.get();
        }

        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return FluentFuture.super.get(j, timeUnit);
        }

        public final boolean isDone() {
            return FluentFuture.super.isDone();
        }

        public final boolean isCancelled() {
            return FluentFuture.super.isCancelled();
        }

        public final void addListener(Runnable runnable, Executor executor) {
            FluentFuture.super.addListener(runnable, executor);
        }

        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return FluentFuture.super.cancel(z);
        }
    }

    FluentFuture() {
    }

    public static <V> FluentFuture<V> from(ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof FluentFuture ? (FluentFuture) listenableFuture : new ForwardingFluentFuture(listenableFuture);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> FluentFuture<V> catching(Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return (FluentFuture) Futures.catching(this, cls, function, executor);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> FluentFuture<V> catchingAsync(Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return (FluentFuture) Futures.catchingAsync(this, cls, asyncFunction, executor);
    }

    @GwtIncompatible
    public final FluentFuture<V> withTimeout(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (FluentFuture) Futures.withTimeout(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> FluentFuture<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (FluentFuture) Futures.transformAsync(this, asyncFunction, executor);
    }

    public final <T> FluentFuture<T> transform(Function<? super V, T> function, Executor executor) {
        return (FluentFuture) Futures.transform(this, function, executor);
    }

    public final void addCallback(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }
}
