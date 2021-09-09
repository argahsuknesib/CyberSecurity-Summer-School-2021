package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    static final int MAX_THREADS = cap(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final FixedSchedulerPool NONE;
    static final PoolWorker SHUTDOWN_WORKER;
    static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
    final AtomicReference<FixedSchedulerPool> pool;
    final ThreadFactory threadFactory;

    static int cap(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        SHUTDOWN_WORKER = poolWorker;
        poolWorker.dispose();
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, THREAD_FACTORY);
        NONE = fixedSchedulerPool;
        fixedSchedulerPool.shutdown();
    }

    static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        final int cores;
        final PoolWorker[] eventLoops;
        long n;

        FixedSchedulerPool(int i, ThreadFactory threadFactory) {
            this.cores = i;
            this.eventLoops = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.eventLoops[i2] = new PoolWorker(threadFactory);
            }
        }

        public final PoolWorker getEventLoop() {
            int i = this.cores;
            if (i == 0) {
                return ComputationScheduler.SHUTDOWN_WORKER;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j = this.n;
            this.n = 1 + j;
            return poolWorkerArr[(int) (j % ((long) i))];
        }

        public final void shutdown() {
            for (PoolWorker dispose : this.eventLoops) {
                dispose.dispose();
            }
        }

        public final void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i2 = this.cores;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    workerCallback.onWorker(i3, ComputationScheduler.SHUTDOWN_WORKER);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                workerCallback.onWorker(i5, new EventLoopWorker(this.eventLoops[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = (long) i4;
        }
    }

    public ComputationScheduler() {
        this(THREAD_FACTORY);
    }

    public ComputationScheduler(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
        this.pool = new AtomicReference<>(NONE);
        start();
    }

    @NonNull
    public final Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    public final void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive(i, "number > 0 required");
        this.pool.get().createWorkers(i, workerCallback);
    }

    @NonNull
    public final Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        return this.pool.get().getEventLoop().scheduleDirect(runnable, j, timeUnit);
    }

    @NonNull
    public final Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.pool.get().getEventLoop().schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
    }

    public final void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(MAX_THREADS, this.threadFactory);
        if (!this.pool.compareAndSet(NONE, fixedSchedulerPool)) {
            fixedSchedulerPool.shutdown();
        }
    }

    public final void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.pool.get();
            fixedSchedulerPool2 = NONE;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!this.pool.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.shutdown();
    }

    static final class EventLoopWorker extends Scheduler.Worker {
        private final ListCompositeDisposable both = new ListCompositeDisposable();
        volatile boolean disposed;
        private final PoolWorker poolWorker;
        private final ListCompositeDisposable serial = new ListCompositeDisposable();
        private final CompositeDisposable timed = new CompositeDisposable();

        EventLoopWorker(PoolWorker poolWorker2) {
            this.poolWorker = poolWorker2;
            this.both.add(this.serial);
            this.both.add(this.timed);
        }

        public final void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.both.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.disposed;
        }

        @NonNull
        public final Disposable schedule(@NonNull Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, 0, TimeUnit.MILLISECONDS, this.serial);
        }

        @NonNull
        public final Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, j, timeUnit, this.timed);
        }
    }

    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
