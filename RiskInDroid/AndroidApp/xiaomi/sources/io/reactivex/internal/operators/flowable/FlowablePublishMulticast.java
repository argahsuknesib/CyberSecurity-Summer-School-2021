package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayError;
    final int prefetch;
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.selector = function;
        this.prefetch = i;
        this.delayError = z;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.prefetch, this.delayError);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.selector.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.source.subscribe((FlowableSubscriber) multicastProcessor);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> downstream;
        final MulticastProcessor<?> processor;
        Subscription upstream;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.downstream = subscriber;
            this.processor = multicastProcessor;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
            this.processor.dispose();
        }

        public final void onComplete() {
            this.downstream.onComplete();
            this.processor.dispose();
        }

        public final void request(long j) {
            this.upstream.request(j);
        }

        public final void cancel() {
            this.upstream.cancel();
            this.processor.dispose();
        }
    }

    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
        static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
        int consumed;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        MulticastProcessor(int i, boolean z) {
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.delayError = z;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        QueueDrainHelper.request(subscription, this.prefetch);
                        return;
                    }
                }
                this.queue = QueueDrainHelper.createQueue(this.prefetch);
                QueueDrainHelper.request(subscription, this.prefetch);
            }
        }

        public final void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.upstream);
            if (this.wip.getAndIncrement() == 0 && (simpleQueue = this.queue) != null) {
                simpleQueue.clear();
            }
        }

        public final boolean isDisposed() {
            return this.upstream.get() == SubscriptionHelper.CANCELLED;
        }

        public final void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0 || this.queue.offer(t)) {
                    drain();
                    return;
                }
                this.upstream.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean add(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.subscribers.get();
                if (multicastSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void remove(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.subscribers.get();
                int length = multicastSubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            multicastSubscriptionArr2 = EMPTY;
                        } else {
                            MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[(length - 1)];
                            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                            System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                            multicastSubscriptionArr2 = multicastSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        public final void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (!add(multicastSubscription)) {
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
            } else if (multicastSubscription.isCancelled()) {
                remove(multicastSubscription);
            } else {
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            Throwable th;
            Throwable th2;
            if (this.wip.getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.queue;
                int i = this.consumed;
                int i2 = this.limit;
                boolean z = this.sourceMode != 1;
                AtomicReference<MulticastSubscription<T>[]> atomicReference2 = this.subscribers;
                MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) atomicReference2.get();
                int i3 = i;
                int i4 = 1;
                while (true) {
                    int length = multicastSubscriptionArr.length;
                    if (simpleQueue == null || length == 0) {
                        atomicReference = atomicReference2;
                    } else {
                        int length2 = multicastSubscriptionArr.length;
                        long j = Long.MAX_VALUE;
                        int i5 = length;
                        long j2 = Long.MAX_VALUE;
                        int i6 = 0;
                        while (i6 < length2) {
                            MulticastSubscription multicastSubscription = multicastSubscriptionArr[i6];
                            AtomicReference<MulticastSubscription<T>[]> atomicReference3 = atomicReference2;
                            long j3 = multicastSubscription.get() - multicastSubscription.emitted;
                            if (j3 == Long.MIN_VALUE) {
                                i5--;
                            } else if (j2 > j3) {
                                j2 = j3;
                            }
                            i6++;
                            atomicReference2 = atomicReference3;
                        }
                        atomicReference = atomicReference2;
                        long j4 = 0;
                        if (i5 == 0) {
                            j2 = 0;
                        }
                        while (j2 != j4) {
                            if (isDisposed()) {
                                simpleQueue.clear();
                                return;
                            }
                            boolean z2 = this.done;
                            if (!z2 || this.delayError || (th2 = this.error) == null) {
                                try {
                                    T poll = simpleQueue.poll();
                                    boolean z3 = poll == null;
                                    if (!z2 || !z3) {
                                        if (z3) {
                                            break;
                                        }
                                        int length3 = multicastSubscriptionArr.length;
                                        int i7 = 0;
                                        boolean z4 = false;
                                        while (i7 < length3) {
                                            MulticastSubscription multicastSubscription2 = multicastSubscriptionArr[i7];
                                            long j5 = multicastSubscription2.get();
                                            if (j5 != Long.MIN_VALUE) {
                                                if (j5 != j) {
                                                    multicastSubscription2.emitted++;
                                                }
                                                multicastSubscription2.downstream.onNext(poll);
                                            } else {
                                                z4 = true;
                                            }
                                            i7++;
                                            j = Long.MAX_VALUE;
                                        }
                                        j2--;
                                        if (z && (i3 = i3 + 1) == i2) {
                                            this.upstream.get().request((long) i2);
                                            i3 = 0;
                                        }
                                        MulticastSubscription[] multicastSubscriptionArr2 = (MulticastSubscription[]) atomicReference.get();
                                        if (z4 || multicastSubscriptionArr2 != multicastSubscriptionArr) {
                                            multicastSubscriptionArr = multicastSubscriptionArr2;
                                            break;
                                        } else {
                                            j4 = 0;
                                            j = Long.MAX_VALUE;
                                        }
                                    } else {
                                        Throwable th3 = this.error;
                                        if (th3 != null) {
                                            errorAll(th3);
                                            return;
                                        } else {
                                            completeAll();
                                            return;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    Throwable th5 = th4;
                                    Exceptions.throwIfFatal(th5);
                                    SubscriptionHelper.cancel(this.upstream);
                                    errorAll(th5);
                                    return;
                                }
                            } else {
                                errorAll(th2);
                                return;
                            }
                        }
                        if (j2 == j4) {
                            if (isDisposed()) {
                                simpleQueue.clear();
                                return;
                            }
                            boolean z5 = this.done;
                            if (z5 && !this.delayError && (th = this.error) != null) {
                                errorAll(th);
                                return;
                            } else if (z5 && simpleQueue.isEmpty()) {
                                Throwable th6 = this.error;
                                if (th6 != null) {
                                    errorAll(th6);
                                    return;
                                } else {
                                    completeAll();
                                    return;
                                }
                            }
                        }
                    }
                    this.consumed = i3;
                    i4 = this.wip.addAndGet(-i4);
                    if (i4 != 0) {
                        if (simpleQueue == null) {
                            simpleQueue = this.queue;
                        }
                        multicastSubscriptionArr = (MulticastSubscription[]) atomicReference.get();
                        atomicReference2 = atomicReference;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void errorAll(Throwable th) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void completeAll() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onComplete();
                }
            }
        }
    }

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.parent.drain();
            }
        }

        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public final boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }
    }
}
