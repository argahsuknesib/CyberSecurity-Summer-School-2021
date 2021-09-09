package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@CanIgnoreReturnValue
@Beta
public final class FakeTimeLimiter implements TimeLimiter {
    public final <T> T newProxy(T t, Class<T> cls, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        return t;
    }

    public final <T> T callWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        try {
            return callable.call();
        } catch (RuntimeException e) {
            throw new UncheckedExecutionException(e);
        } catch (Exception e2) {
            throw new ExecutionException(e2);
        } catch (Error e3) {
            throw new ExecutionError(e3);
        } catch (Throwable th) {
            throw new ExecutionException(th);
        }
    }

    public final <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException {
        return callWithTimeout(callable, j, timeUnit);
    }

    public final void runWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        try {
            runnable.run();
        } catch (RuntimeException e) {
            throw new UncheckedExecutionException(e);
        } catch (Error e2) {
            throw new ExecutionError(e2);
        } catch (Throwable th) {
            throw new UncheckedExecutionException(th);
        }
    }

    public final void runUninterruptiblyWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) {
        runWithTimeout(runnable, j, timeUnit);
    }
}
