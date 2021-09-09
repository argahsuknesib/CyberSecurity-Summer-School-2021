package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i, boolean z) {
        this.source = parallelFlowable;
        this.prefetch = i;
        this.delayErrors = z;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscriptionBase;
        if (this.delayErrors) {
            joinSubscriptionBase = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscriptionBase = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        }
        subscriber.onSubscribe(joinSubscriptionBase);
        this.source.subscribe(joinSubscriptionBase.subscribers);
    }

    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final AtomicInteger done = new AtomicInteger();
        final Subscriber<? super T> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final JoinInnerSubscriber<T>[] subscribers;

        /* access modifiers changed from: package-private */
        public abstract void drain();

        /* access modifiers changed from: package-private */
        public abstract void onComplete();

        /* access modifiers changed from: package-private */
        public abstract void onError(Throwable th);

        /* access modifiers changed from: package-private */
        public abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i, int i2) {
            this.downstream = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                joinInnerSubscriberArr[i3] = new JoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    cleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            for (JoinInnerSubscriber<T> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void cleanup() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.queue = null;
            }
        }
    }

    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        public final void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.downstream.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        public final void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        public final void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
            if (r13 == false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0062, code lost:
            if (r11 == false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0067, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0068, code lost:
            if (r11 == false) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006a, code lost:
            r10 = r14;
         */
        public final void drainLoop() {
            boolean z;
            long j;
            T poll;
            JoinInnerSubscriber[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber subscriber = this.downstream;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (!this.cancelled) {
                            Throwable th = (Throwable) this.errors.get();
                            if (th == null) {
                                boolean z2 = this.done.get() == 0;
                                j = j3;
                                int i2 = 0;
                                boolean z3 = true;
                                while (true) {
                                    if (i2 >= joinInnerSubscriberArr.length) {
                                        break;
                                    }
                                    JoinInnerSubscriber joinInnerSubscriber = joinInnerSubscriberArr[i2];
                                    SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                                    if (!(simplePlainQueue == null || (poll = simplePlainQueue.poll()) == null)) {
                                        subscriber.onNext(poll);
                                        joinInnerSubscriber.requestOne();
                                        long j4 = 1 + j;
                                        if (j4 == j2) {
                                            j3 = j4;
                                            break;
                                        } else {
                                            j = j4;
                                            z3 = false;
                                        }
                                    }
                                    i2++;
                                }
                            } else {
                                cleanup();
                                subscriber.onError(th);
                                return;
                            }
                        } else {
                            cleanup();
                            return;
                        }
                    } else {
                        break;
                    }
                    j3 = j;
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th2 = (Throwable) this.errors.get();
                    if (th2 != null) {
                        cleanup();
                        subscriber.onError(th2);
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i3].queue;
                            if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i3++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                    this.requested.addAndGet(-j3);
                }
                int i4 = get();
                if (i4 != i || (i4 = addAndGet(-i)) != 0) {
                    i = i4;
                } else {
                    return;
                }
            }
        }
    }

    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        /* access modifiers changed from: package-private */
        public final void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    joinInnerSubscriber.cancel();
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }

        /* access modifiers changed from: package-private */
        public final void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
            if (r13 == false) goto L_0x006a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
            if (r11 == false) goto L_0x006a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
            if (((java.lang.Throwable) r0.errors.get()) == null) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
            r3.onError(r0.errors.terminate());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x006a, code lost:
            if (r11 == false) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x006c, code lost:
            r10 = r14;
         */
        public final void drainLoop() {
            boolean z;
            long j;
            T poll;
            JoinInnerSubscriber[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber subscriber = this.downstream;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (!this.cancelled) {
                            boolean z2 = this.done.get() == 0;
                            j = j3;
                            int i2 = 0;
                            boolean z3 = true;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                JoinInnerSubscriber joinInnerSubscriber = joinInnerSubscriberArr[i2];
                                SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                                if (!(simplePlainQueue == null || (poll = simplePlainQueue.poll()) == null)) {
                                    subscriber.onNext(poll);
                                    joinInnerSubscriber.requestOne();
                                    long j4 = 1 + j;
                                    if (j4 == j2) {
                                        j3 = j4;
                                        break;
                                    } else {
                                        j = j4;
                                        z3 = false;
                                    }
                                }
                                i2++;
                            }
                        } else {
                            cleanup();
                            return;
                        }
                    } else {
                        break;
                    }
                    j3 = j;
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i3].queue;
                            if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i3++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        if (((Throwable) this.errors.get()) != null) {
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                    this.requested.addAndGet(-j3);
                }
                int i4 = get();
                if (i4 != i || (i4 = addAndGet(-i)) != 0) {
                    i = i4;
                } else {
                    return;
                }
            }
        }
    }

    static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.prefetch);
        }

        public final void onNext(T t) {
            this.parent.onNext(this, t);
        }

        public final void onError(Throwable th) {
            this.parent.onError(th);
        }

        public final void onComplete() {
            this.parent.onComplete();
        }

        public final void requestOne() {
            long j = this.produced + 1;
            if (j == ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j);
                return;
            }
            this.produced = j;
        }

        public final void request(long j) {
            long j2 = this.produced + j;
            if (j2 >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.produced = j2;
        }

        public final boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        /* access modifiers changed from: package-private */
        public final SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }
    }
}
