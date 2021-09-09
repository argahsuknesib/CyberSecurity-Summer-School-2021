package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

@GwtIncompatible
@CanIgnoreReturnValue
@Beta
public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return TrustedListenableFutureTask.create(runnable, t);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return TrustedListenableFutureTask.create(callable);
    }

    public ListenableFuture<?> submit(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{<T> java.util.concurrent.AbstractExecutorService.submit(java.lang.Runnable, java.lang.Object):java.util.concurrent.Future<T>}
     arg types: [java.lang.Runnable, T]
     candidates:
      com.google.common.util.concurrent.AbstractListeningExecutorService.submit(java.lang.Runnable, java.lang.Object):com.google.common.util.concurrent.ListenableFuture<T>
      com.google.common.util.concurrent.ListeningExecutorService.submit(java.lang.Runnable, java.lang.Object):com.google.common.util.concurrent.ListenableFuture<T>
      ClspMth{<T> java.util.concurrent.AbstractExecutorService.submit(java.lang.Runnable, java.lang.Object):java.util.concurrent.Future<T>} */
    public <T> ListenableFuture<T> submit(Runnable runnable, T t) {
        return (ListenableFuture) super.submit(runnable, (Object) t);
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return (ListenableFuture) super.submit((Callable) callable);
    }
}
