package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler extends Scheduler {
    static final Disposable DISPOSED;
    public static final Scheduler INSTANCE = new ImmediateThinScheduler();
    static final Scheduler.Worker WORKER = new ImmediateThinWorker();

    static {
        Disposable empty = Disposables.empty();
        DISPOSED = empty;
        empty.dispose();
    }

    private ImmediateThinScheduler() {
    }

    @NonNull
    public final Disposable scheduleDirect(@NonNull Runnable runnable) {
        runnable.run();
        return DISPOSED;
    }

    @NonNull
    public final Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @NonNull
    public final Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @NonNull
    public final Scheduler.Worker createWorker() {
        return WORKER;
    }

    static final class ImmediateThinWorker extends Scheduler.Worker {
        public final void dispose() {
        }

        public final boolean isDisposed() {
            return false;
        }

        ImmediateThinWorker() {
        }

        @NonNull
        public final Disposable schedule(@NonNull Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.DISPOSED;
        }

        @NonNull
        public final Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @NonNull
        public final Disposable schedulePeriodically(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }
}
