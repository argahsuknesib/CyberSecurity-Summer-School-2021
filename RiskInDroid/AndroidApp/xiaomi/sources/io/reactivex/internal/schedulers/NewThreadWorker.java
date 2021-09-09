package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker extends Scheduler.Worker implements Disposable {
    volatile boolean disposed;
    private final ScheduledExecutorService executor;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.executor = SchedulerPoolFactory.create(threadFactory);
    }

    @NonNull
    public Disposable schedule(@NonNull Runnable runnable) {
        return schedule(runnable, 0, null);
    }

    @NonNull
    public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        if (this.disposed) {
            return EmptyDisposable.INSTANCE;
        }
        return scheduleActual(runnable, j, timeUnit, null);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable));
        if (j <= 0) {
            try {
                future = this.executor.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.executor.schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (j2 <= 0) {
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(onSchedule, this.executor);
            if (j <= 0) {
                try {
                    future = this.executor.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e) {
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.executor.schedule(instantPeriodicTask, j, timeUnit);
            }
            instantPeriodicTask.setFirst(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(onSchedule);
        try {
            scheduledDirectPeriodicTask.setFuture(this.executor.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{<V> java.util.concurrent.ScheduledExecutorService.schedule(java.util.concurrent.Callable, long, java.util.concurrent.TimeUnit):java.util.concurrent.ScheduledFuture<V>}
     arg types: [io.reactivex.internal.schedulers.ScheduledRunnable, long, java.util.concurrent.TimeUnit]
     candidates:
      ClspMth{java.util.concurrent.ScheduledExecutorService.schedule(java.lang.Runnable, long, java.util.concurrent.TimeUnit):java.util.concurrent.ScheduledFuture<?>}
      ClspMth{<V> java.util.concurrent.ScheduledExecutorService.schedule(java.util.concurrent.Callable, long, java.util.concurrent.TimeUnit):java.util.concurrent.ScheduledFuture<V>} */
    @NonNull
    public ScheduledRunnable scheduleActual(Runnable runnable, long j, @NonNull TimeUnit timeUnit, @Nullable DisposableContainer disposableContainer) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.add(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j <= 0) {
            try {
                future = this.executor.submit((Callable) scheduledRunnable);
            } catch (RejectedExecutionException e) {
                if (disposableContainer != null) {
                    disposableContainer.remove(scheduledRunnable);
                }
                RxJavaPlugins.onError(e);
            }
        } else {
            future = this.executor.schedule((Callable) scheduledRunnable, j, timeUnit);
        }
        scheduledRunnable.setFuture(future);
        return scheduledRunnable;
    }

    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.executor.shutdownNow();
        }
    }

    public void shutdown() {
        if (!this.disposed) {
            this.disposed = true;
            this.executor.shutdown();
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }
}
