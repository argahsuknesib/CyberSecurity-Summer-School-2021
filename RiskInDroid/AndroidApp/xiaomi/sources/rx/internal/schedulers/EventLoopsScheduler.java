package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class EventLoopsScheduler extends Scheduler implements SchedulerLifecycle {
    static final int MAX_THREADS;
    static final FixedSchedulerPool NONE = new FixedSchedulerPool(null, 0);
    static final PoolWorker SHUTDOWN_WORKER;
    final AtomicReference<FixedSchedulerPool> pool = new AtomicReference<>(NONE);
    final ThreadFactory threadFactory;

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        MAX_THREADS = intValue;
        PoolWorker poolWorker = new PoolWorker(RxThreadFactory.NONE);
        SHUTDOWN_WORKER = poolWorker;
        poolWorker.unsubscribe();
    }

    static final class FixedSchedulerPool {
        final int cores;
        final PoolWorker[] eventLoops;
        long n;

        FixedSchedulerPool(ThreadFactory threadFactory, int i) {
            this.cores = i;
            this.eventLoops = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.eventLoops[i2] = new PoolWorker(threadFactory);
            }
        }

        public final PoolWorker getEventLoop() {
            int i = this.cores;
            if (i == 0) {
                return EventLoopsScheduler.SHUTDOWN_WORKER;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j = this.n;
            this.n = 1 + j;
            return poolWorkerArr[(int) (j % ((long) i))];
        }

        public final void shutdown() {
            for (PoolWorker unsubscribe : this.eventLoops) {
                unsubscribe.unsubscribe();
            }
        }
    }

    public EventLoopsScheduler(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
        start();
    }

    public final Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    public final void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(this.threadFactory, MAX_THREADS);
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

    public final Subscription scheduleDirect(Action0 action0) {
        return this.pool.get().getEventLoop().scheduleActual(action0, -1, TimeUnit.NANOSECONDS);
    }

    static final class EventLoopWorker extends Scheduler.Worker {
        private final SubscriptionList both = new SubscriptionList(this.serial, this.timed);
        private final PoolWorker poolWorker;
        private final SubscriptionList serial = new SubscriptionList();
        private final CompositeSubscription timed = new CompositeSubscription();

        EventLoopWorker(PoolWorker poolWorker2) {
            this.poolWorker = poolWorker2;
        }

        public final void unsubscribe() {
            this.both.unsubscribe();
        }

        public final boolean isUnsubscribed() {
            return this.both.isUnsubscribed();
        }

        public final Subscription schedule(final Action0 action0) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual(new Action0() {
                /* class rx.internal.schedulers.EventLoopsScheduler.EventLoopWorker.AnonymousClass1 */

                public void call() {
                    if (!EventLoopWorker.this.isUnsubscribed()) {
                        action0.call();
                    }
                }
            }, 0, (TimeUnit) null, this.serial);
        }

        public final Subscription schedule(final Action0 action0, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual(new Action0() {
                /* class rx.internal.schedulers.EventLoopsScheduler.EventLoopWorker.AnonymousClass2 */

                public void call() {
                    if (!EventLoopWorker.this.isUnsubscribed()) {
                        action0.call();
                    }
                }
            }, j, timeUnit, this.timed);
        }
    }

    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
