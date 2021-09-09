package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends Scheduler {
    static final Scheduler HELPER = Schedulers.single();
    @NonNull
    final Executor executor;
    final boolean interruptibleWorker;

    public ExecutorScheduler(@NonNull Executor executor2, boolean z) {
        this.executor = executor2;
        this.interruptibleWorker = z;
    }

    @NonNull
    public final Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.executor, this.interruptibleWorker);
    }

    @NonNull
    public final Disposable scheduleDirect(@NonNull Runnable runnable) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            if (this.executor instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((ExecutorService) this.executor).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.interruptibleWorker) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(onSchedule, null);
                this.executor.execute(interruptibleRunnable);
                return interruptibleRunnable;
            } else {
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(onSchedule);
                this.executor.execute(booleanRunnable);
                return booleanRunnable;
            }
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @NonNull
    public final Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (this.executor instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.executor).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            DelayedRunnable delayedRunnable = new DelayedRunnable(onSchedule);
            delayedRunnable.timed.replace(HELPER.scheduleDirect(new DelayedDispose(delayedRunnable), j, timeUnit));
            return delayedRunnable;
        }
    }

    @NonNull
    public final Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.executor instanceof ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(runnable));
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.executor).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        volatile boolean disposed;
        final Executor executor;
        final boolean interruptibleWorker;
        final MpscLinkedQueue<Runnable> queue;
        final CompositeDisposable tasks = new CompositeDisposable();
        final AtomicInteger wip = new AtomicInteger();

        public ExecutorWorker(Executor executor2, boolean z) {
            this.executor = executor2;
            this.queue = new MpscLinkedQueue<>();
            this.interruptibleWorker = z;
        }

        @NonNull
        public final Disposable schedule(@NonNull Runnable runnable) {
            Disposable disposable;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            if (this.interruptibleWorker) {
                disposable = new InterruptibleRunnable(onSchedule, this.tasks);
                this.tasks.add(disposable);
            } else {
                disposable = new BooleanRunnable(onSchedule);
            }
            this.queue.offer(disposable);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (RejectedExecutionException e) {
                    this.disposed = true;
                    this.queue.clear();
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return disposable;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{<V> java.util.concurrent.ScheduledExecutorService.schedule(java.util.concurrent.Callable, long, java.util.concurrent.TimeUnit):java.util.concurrent.ScheduledFuture<V>}
         arg types: [io.reactivex.internal.schedulers.ScheduledRunnable, long, java.util.concurrent.TimeUnit]
         candidates:
          ClspMth{java.util.concurrent.ScheduledExecutorService.schedule(java.lang.Runnable, long, java.util.concurrent.TimeUnit):java.util.concurrent.ScheduledFuture<?>}
          ClspMth{<V> java.util.concurrent.ScheduledExecutorService.schedule(java.util.concurrent.Callable, long, java.util.concurrent.TimeUnit):java.util.concurrent.ScheduledFuture<V>} */
        @NonNull
        public final Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (j <= 0) {
                return schedule(runnable);
            }
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.onSchedule(runnable)), this.tasks);
            this.tasks.add(scheduledRunnable);
            Executor executor2 = this.executor;
            if (executor2 instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor2).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e) {
                    this.disposed = true;
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new DisposeOnCancel(ExecutorScheduler.HELPER.scheduleDirect(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }

        public final void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
                if (this.wip.getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.disposed;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            if (r3.disposed == false) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
            r0.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
            r1 = r3.wip.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
            return;
         */
        public final void run() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.queue;
            int i = 1;
            while (!this.disposed) {
                while (true) {
                    Runnable poll = mpscLinkedQueue.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.run();
                    if (this.disposed) {
                        mpscLinkedQueue.clear();
                        return;
                    }
                }
            }
            mpscLinkedQueue.clear();
        }

        static final class BooleanRunnable extends AtomicBoolean implements Disposable, Runnable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            public final void run() {
                if (!get()) {
                    try {
                        this.actual.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }

            public final void dispose() {
                lazySet(true);
            }

            public final boolean isDisposed() {
                return get();
            }
        }

        final class SequentialDispose implements Runnable {
            private final Runnable decoratedRun;
            private final SequentialDisposable mar;

            SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.mar = sequentialDisposable;
                this.decoratedRun = runnable;
            }

            public final void run() {
                this.mar.replace(ExecutorWorker.this.schedule(this.decoratedRun));
            }
        }

        static final class InterruptibleRunnable extends AtomicInteger implements Disposable, Runnable {
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final DisposableContainer tasks;
            volatile Thread thread;

            InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
                this.run = runnable;
                this.tasks = disposableContainer;
            }

            public final void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.run.run();
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                cleanup();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th) {
                            this.thread = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                cleanup();
                            }
                            throw th;
                        }
                    } else {
                        this.thread = null;
                    }
                }
            }

            public final void dispose() {
                while (true) {
                    int i = get();
                    if (i >= 2) {
                        return;
                    }
                    if (i == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread2 = this.thread;
                        if (thread2 != null) {
                            thread2.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public final void cleanup() {
                DisposableContainer disposableContainer = this.tasks;
                if (disposableContainer != null) {
                    disposableContainer.delete(this);
                }
            }

            public final boolean isDisposed() {
                return get() >= 2;
            }
        }
    }

    static final class DelayedRunnable extends AtomicReference<Runnable> implements Disposable, SchedulerRunnableIntrospection, Runnable {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct = new SequentialDisposable();
        final SequentialDisposable timed = new SequentialDisposable();

        DelayedRunnable(Runnable runnable) {
            super(runnable);
        }

        public final void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                }
            }
        }

        public final boolean isDisposed() {
            return get() == null;
        }

        public final void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public final Runnable getWrappedRunnable() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                return runnable;
            }
            return Functions.EMPTY_RUNNABLE;
        }
    }

    final class DelayedDispose implements Runnable {
        private final DelayedRunnable dr;

        DelayedDispose(DelayedRunnable delayedRunnable) {
            this.dr = delayedRunnable;
        }

        public final void run() {
            this.dr.direct.replace(ExecutorScheduler.this.scheduleDirect(this.dr));
        }
    }
}
