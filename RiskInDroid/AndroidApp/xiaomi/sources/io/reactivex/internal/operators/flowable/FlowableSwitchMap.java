package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.mapper = function;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            this.source.subscribe((FlowableSubscriber) new SwitchMapSubscriber(subscriber, this.mapper, this.bufferSize, this.delayErrors));
        }
    }

    static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicThrowable error;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final AtomicLong requested = new AtomicLong();
        volatile long unique;
        Subscription upstream;

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>(null, -1, 1);
            CANCELLED = switchMapInnerSubscriber;
            switchMapInnerSubscriber.cancel();
        }

        SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            this.downstream = subscriber;
            this.mapper = function;
            this.bufferSize = i;
            this.delayErrors = z;
            this.error = new AtomicThrowable();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            if (!this.done) {
                long j = this.unique + 1;
                this.unique = j;
                SwitchMapInnerSubscriber switchMapInnerSubscriber2 = this.active.get();
                if (switchMapInnerSubscriber2 != null) {
                    switchMapInnerSubscriber2.cancel();
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The publisher returned is null");
                    SwitchMapInnerSubscriber switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber(this, j, this.bufferSize);
                    do {
                        switchMapInnerSubscriber = this.active.get();
                        if (switchMapInnerSubscriber == CANCELLED) {
                            return;
                        }
                    } while (!this.active.compareAndSet(switchMapInnerSubscriber, switchMapInnerSubscriber3));
                    publisher.subscribe(switchMapInnerSubscriber3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.done || !this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.unique == 0) {
                    this.upstream.request(Long.MAX_VALUE);
                } else {
                    drain();
                }
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeInner();
            }
        }

        /* access modifiers changed from: package-private */
        public final void disposeInner() {
            SwitchMapInnerSubscriber<Object, Object> andSet;
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = this.active.get();
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber2 = CANCELLED;
            if (switchMapInnerSubscriber != switchMapInnerSubscriber2 && (andSet = this.active.getAndSet(switchMapInnerSubscriber2)) != CANCELLED && andSet != null) {
                andSet.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e5, code lost:
            r14 = true;
         */
        public final void drain() {
            boolean z;
            R r;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.downstream;
                int i = 1;
                while (!this.cancelled) {
                    if (this.done) {
                        if (this.delayErrors) {
                            if (this.active.get() == null) {
                                if (((Throwable) this.error.get()) != null) {
                                    subscriber.onError(this.error.terminate());
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                        } else if (((Throwable) this.error.get()) != null) {
                            disposeInner();
                            subscriber.onError(this.error.terminate());
                            return;
                        } else if (this.active.get() == null) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.active.get();
                    SimpleQueue<R> simpleQueue = switchMapInnerSubscriber != null ? switchMapInnerSubscriber.queue : null;
                    if (simpleQueue != null) {
                        if (switchMapInnerSubscriber.done) {
                            if (!this.delayErrors) {
                                if (((Throwable) this.error.get()) != null) {
                                    disposeInner();
                                    subscriber.onError(this.error.terminate());
                                    return;
                                } else if (simpleQueue.isEmpty()) {
                                    this.active.compareAndSet(switchMapInnerSubscriber, null);
                                }
                            } else if (simpleQueue.isEmpty()) {
                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                            }
                        }
                        long j = this.requested.get();
                        long j2 = 0;
                        while (true) {
                            z = false;
                            if (j2 != j) {
                                if (!this.cancelled) {
                                    boolean z2 = switchMapInnerSubscriber.done;
                                    try {
                                        r = simpleQueue.poll();
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                        Exceptions.throwIfFatal(th2);
                                        switchMapInnerSubscriber.cancel();
                                        this.error.addThrowable(th2);
                                        r = null;
                                        z2 = true;
                                    }
                                    boolean z3 = r == null;
                                    if (switchMapInnerSubscriber != this.active.get()) {
                                        break;
                                    }
                                    if (z2) {
                                        if (this.delayErrors) {
                                            if (z3) {
                                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                                                break;
                                            }
                                        } else if (((Throwable) this.error.get()) == null) {
                                            if (z3) {
                                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                                                break;
                                            }
                                        } else {
                                            subscriber.onError(this.error.terminate());
                                            return;
                                        }
                                    }
                                    if (z3) {
                                        break;
                                    }
                                    subscriber.onNext(r);
                                    j2++;
                                } else {
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                        if (j2 != 0 && !this.cancelled) {
                            if (j != Long.MAX_VALUE) {
                                this.requested.addAndGet(-j2);
                            }
                            ((Subscription) switchMapInnerSubscriber.get()).request(j2);
                        }
                        if (z) {
                            continue;
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
                this.active.lazySet(null);
            }
        }
    }

    static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile SimpleQueue<R> queue;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j, int i) {
            this.parent = switchMapSubscriber;
            this.index = j;
            this.bufferSize = i;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request((long) this.bufferSize);
            }
        }

        public final void onNext(R r) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index != switchMapSubscriber.unique) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(r)) {
                switchMapSubscriber.drain();
            } else {
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        public final void onError(Throwable th) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index != switchMapSubscriber.unique || !switchMapSubscriber.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!switchMapSubscriber.delayErrors) {
                switchMapSubscriber.upstream.cancel();
            }
            this.done = true;
            switchMapSubscriber.drain();
        }

        public final void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                this.done = true;
                switchMapSubscriber.drain();
            }
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}
