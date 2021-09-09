package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
abstract class ImmediateFuture<V> implements ListenableFuture<V> {
    private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());

    public boolean cancel(boolean z) {
        return false;
    }

    public abstract V get() throws ExecutionException;

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    ImmediateFuture() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.RuntimeException]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    public void addListener(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.checkNotNull(timeUnit);
        return get();
    }

    static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateSuccessfulFuture<Object> NULL = new ImmediateSuccessfulFuture<>(null);
        private final V value;

        ImmediateSuccessfulFuture(V v) {
            this.value = v;
        }

        public V get() {
            return this.value;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + ((Object) this.value) + "]]";
        }
    }

    @GwtIncompatible
    static class ImmediateSuccessfulCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
        private final V value;

        ImmediateSuccessfulCheckedFuture(V v) {
            this.value = v;
        }

        public V get() {
            return this.value;
        }

        public V checkedGet() {
            return this.value;
        }

        public V checkedGet(long j, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            return this.value;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + ((Object) this.value) + "]]";
        }
    }

    static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateFailedFuture(Throwable th) {
            setException(th);
        }
    }

    static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    @GwtIncompatible
    static class ImmediateFailedCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
        private final X thrown;

        ImmediateFailedCheckedFuture(X x) {
            this.thrown = x;
        }

        public V get() throws ExecutionException {
            throw new ExecutionException((Throwable) this.thrown);
        }

        public V checkedGet() throws Exception {
            throw this.thrown;
        }

        public V checkedGet(long j, TimeUnit timeUnit) throws Exception {
            Preconditions.checkNotNull(timeUnit);
            throw this.thrown;
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + ((Object) this.thrown) + "]]";
        }
    }
}
