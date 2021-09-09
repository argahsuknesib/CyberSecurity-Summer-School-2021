package com.facebook.common.executors;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorServiceImpl extends AbstractExecutorService implements HandlerExecutorService {
    private final Handler mHandler;

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public HandlerExecutorServiceImpl(Handler handler) {
        this.mHandler = handler;
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    /* access modifiers changed from: protected */
    public <T> ScheduledFutureImpl<T> newTaskFor(Runnable runnable, T t) {
        return new ScheduledFutureImpl<>(this.mHandler, runnable, t);
    }

    /* access modifiers changed from: protected */
    public <T> ScheduledFutureImpl<T> newTaskFor(Callable<T> callable) {
        return new ScheduledFutureImpl<>(this.mHandler, callable);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.common.executors.HandlerExecutorServiceImpl.submit(java.lang.Runnable, java.lang.Object):java.util.concurrent.ScheduledFuture<T>
     arg types: [java.lang.Runnable, ?[OBJECT, ARRAY]]
     candidates:
      com.facebook.common.executors.HandlerExecutorServiceImpl.submit(java.lang.Runnable, java.lang.Object):java.util.concurrent.Future
      ClspMth{<T> java.util.concurrent.AbstractExecutorService.submit(java.lang.Runnable, java.lang.Object):java.util.concurrent.Future<T>}
      ClspMth{<T> java.util.concurrent.ExecutorService.submit(java.lang.Runnable, java.lang.Object):java.util.concurrent.Future<T>}
      ClspMth{<T> java.util.concurrent.ExecutorService.submit(java.lang.Runnable, java.lang.Object):java.util.concurrent.Future<T>}
      com.facebook.common.executors.HandlerExecutorServiceImpl.submit(java.lang.Runnable, java.lang.Object):java.util.concurrent.ScheduledFuture<T> */
    public ScheduledFuture<?> submit(Runnable runnable) {
        return submit(runnable, (Object) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.common.executors.HandlerExecutorServiceImpl.newTaskFor(java.lang.Runnable, java.lang.Object):com.facebook.common.executors.ScheduledFutureImpl<T>
     arg types: [java.lang.Runnable, T]
     candidates:
      com.facebook.common.executors.HandlerExecutorServiceImpl.newTaskFor(java.lang.Runnable, java.lang.Object):java.util.concurrent.RunnableFuture
      ClspMth{<T> java.util.concurrent.AbstractExecutorService.newTaskFor(java.lang.Runnable, java.lang.Object):java.util.concurrent.RunnableFuture<T>}
      com.facebook.common.executors.HandlerExecutorServiceImpl.newTaskFor(java.lang.Runnable, java.lang.Object):com.facebook.common.executors.ScheduledFutureImpl<T> */
    public <T> ScheduledFuture<T> submit(Runnable runnable, T t) {
        if (runnable != null) {
            ScheduledFutureImpl newTaskFor = newTaskFor(runnable, (Object) t);
            execute(newTaskFor);
            return newTaskFor;
        }
        throw new NullPointerException();
    }

    public <T> ScheduledFuture<T> submit(Callable<T> callable) {
        if (callable != null) {
            ScheduledFutureImpl<T> newTaskFor = newTaskFor((Callable) callable);
            execute(newTaskFor);
            return newTaskFor;
        }
        throw new NullPointerException();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.common.executors.HandlerExecutorServiceImpl.newTaskFor(java.lang.Runnable, java.lang.Object):com.facebook.common.executors.ScheduledFutureImpl<T>
     arg types: [java.lang.Runnable, ?[OBJECT, ARRAY]]
     candidates:
      com.facebook.common.executors.HandlerExecutorServiceImpl.newTaskFor(java.lang.Runnable, java.lang.Object):java.util.concurrent.RunnableFuture
      ClspMth{<T> java.util.concurrent.AbstractExecutorService.newTaskFor(java.lang.Runnable, java.lang.Object):java.util.concurrent.RunnableFuture<T>}
      com.facebook.common.executors.HandlerExecutorServiceImpl.newTaskFor(java.lang.Runnable, java.lang.Object):com.facebook.common.executors.ScheduledFutureImpl<T> */
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledFutureImpl newTaskFor = newTaskFor(runnable, (Object) null);
        this.mHandler.postDelayed(newTaskFor, timeUnit.toMillis(j));
        return newTaskFor;
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ScheduledFutureImpl<T> newTaskFor = newTaskFor((Callable) callable);
        this.mHandler.postDelayed(newTaskFor, timeUnit.toMillis(j));
        return newTaskFor;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void quit() {
        this.mHandler.getLooper().quit();
    }

    public boolean isHandlerThread() {
        return Thread.currentThread() == this.mHandler.getLooper().getThread();
    }
}
