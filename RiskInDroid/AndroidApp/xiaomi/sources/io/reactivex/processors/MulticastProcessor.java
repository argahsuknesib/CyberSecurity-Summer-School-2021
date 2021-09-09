package io.reactivex.processors;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
    static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
    final int bufferSize;
    int consumed;
    volatile boolean done;
    volatile Throwable error;
    int fusionMode;
    final int limit;
    final AtomicBoolean once;
    volatile SimpleQueue<T> queue;
    final boolean refcount;
    final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    final AtomicReference<Subscription> upstream = new AtomicReference<>();
    final AtomicInteger wip = new AtomicInteger();

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(bufferSize(), false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(boolean z) {
        return new MulticastProcessor<>(bufferSize(), z);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i) {
        return new MulticastProcessor<>(i, false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i, boolean z) {
        return new MulticastProcessor<>(i, z);
    }

    MulticastProcessor(int i, boolean z) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        this.bufferSize = i;
        this.limit = i - (i >> 2);
        this.refcount = z;
        this.once = new AtomicBoolean();
    }

    public final void start() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscArrayQueue(this.bufferSize);
        }
    }

    public final void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        }
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    drain();
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

    public final void onNext(T t) {
        if (!this.once.get()) {
            if (this.fusionMode == 0) {
                ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                if (!this.queue.offer(t)) {
                    SubscriptionHelper.cancel(this.upstream);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            drain();
        }
    }

    public final boolean offer(T t) {
        if (this.once.get()) {
            return false;
        }
        ObjectHelper.requireNonNull(t, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.fusionMode != 0 || !this.queue.offer(t)) {
            return false;
        }
        drain();
        return true;
    }

    public final void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.error = th;
            this.done = true;
            drain();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public final void onComplete() {
        if (this.once.compareAndSet(false, true)) {
            this.done = true;
            drain();
        }
    }

    public final boolean hasSubscribers() {
        return ((MulticastSubscription[]) this.subscribers.get()).length != 0;
    }

    public final boolean hasThrowable() {
        return this.once.get() && this.error != null;
    }

    public final boolean hasComplete() {
        return this.once.get() && this.error == null;
    }

    public final Throwable getThrowable() {
        if (this.once.get()) {
            return this.error;
        }
        return null;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable th;
        MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
        subscriber.onSubscribe(multicastSubscription);
        if (add(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                remove(multicastSubscription);
            } else {
                drain();
            }
        } else if ((this.once.get() || !this.refcount) && (th = this.error) != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
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
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = (MulticastSubscription[]) this.subscribers.get();
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
                if (i < 0) {
                    return;
                }
                if (length != 1) {
                    MulticastSubscription[] multicastSubscriptionArr2 = new MulticastSubscription[(length - 1)];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                    System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                    if (this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2)) {
                        return;
                    }
                } else if (this.refcount) {
                    if (this.subscribers.compareAndSet(multicastSubscriptionArr, TERMINATED)) {
                        SubscriptionHelper.cancel(this.upstream);
                        this.once.set(true);
                        return;
                    }
                } else if (this.subscribers.compareAndSet(multicastSubscriptionArr, EMPTY)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void drain() {
        boolean z;
        T t;
        if (this.wip.getAndIncrement() == 0) {
            AtomicReference<MulticastSubscription<T>[]> atomicReference = this.subscribers;
            int i = this.consumed;
            int i2 = this.limit;
            int i3 = this.fusionMode;
            int i4 = 1;
            while (true) {
                SimpleQueue<T> simpleQueue = this.queue;
                if (simpleQueue != null) {
                    MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) atomicReference.get();
                    if (multicastSubscriptionArr.length != 0) {
                        int length = multicastSubscriptionArr.length;
                        long j = -1;
                        long j2 = -1;
                        int i5 = 0;
                        while (i5 < length) {
                            MulticastSubscription multicastSubscription = multicastSubscriptionArr[i5];
                            long j3 = multicastSubscription.get();
                            if (j3 >= 0) {
                                if (j2 == j) {
                                    j2 = j3 - multicastSubscription.emitted;
                                } else {
                                    j2 = Math.min(j2, j3 - multicastSubscription.emitted);
                                }
                            }
                            i5++;
                            j = -1;
                        }
                        int i6 = i;
                        while (true) {
                            if (j2 > 0) {
                                MulticastSubscription[] multicastSubscriptionArr2 = (MulticastSubscription[]) atomicReference.get();
                                if (multicastSubscriptionArr2 != TERMINATED) {
                                    if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                                        break;
                                    }
                                    try {
                                        z = this.done;
                                        t = simpleQueue.poll();
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                        Exceptions.throwIfFatal(th2);
                                        SubscriptionHelper.cancel(this.upstream);
                                        t = null;
                                        this.error = th2;
                                        this.done = true;
                                        z = true;
                                    }
                                    boolean z2 = t == null;
                                    if (!z || !z2) {
                                        if (z2) {
                                            break;
                                        }
                                        for (MulticastSubscription onNext : multicastSubscriptionArr) {
                                            onNext.onNext(t);
                                        }
                                        j2--;
                                        if (i3 != 1) {
                                            int i7 = i6 + 1;
                                            if (i7 == i2) {
                                                this.upstream.get().request((long) i2);
                                                i6 = 0;
                                            } else {
                                                i6 = i7;
                                            }
                                        }
                                    } else {
                                        Throwable th3 = this.error;
                                        if (th3 != null) {
                                            for (MulticastSubscription onError : (MulticastSubscription[]) atomicReference.getAndSet(TERMINATED)) {
                                                onError.onError(th3);
                                            }
                                            return;
                                        }
                                        for (MulticastSubscription onComplete : (MulticastSubscription[]) atomicReference.getAndSet(TERMINATED)) {
                                            onComplete.onComplete();
                                        }
                                        return;
                                    }
                                } else {
                                    simpleQueue.clear();
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                        if (j2 == 0) {
                            MulticastSubscription[] multicastSubscriptionArr3 = (MulticastSubscription[]) atomicReference.get();
                            if (multicastSubscriptionArr3 == TERMINATED) {
                                simpleQueue.clear();
                                return;
                            }
                            if (multicastSubscriptionArr == multicastSubscriptionArr3) {
                                if (this.done && simpleQueue.isEmpty()) {
                                    Throwable th4 = this.error;
                                    if (th4 != null) {
                                        for (MulticastSubscription onError2 : (MulticastSubscription[]) atomicReference.getAndSet(TERMINATED)) {
                                            onError2.onError(th4);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription onComplete2 : (MulticastSubscription[]) atomicReference.getAndSet(TERMINATED)) {
                                        onComplete2.onComplete();
                                    }
                                    return;
                                }
                            }
                            i = i6;
                        }
                        i = i6;
                    }
                }
                i4 = this.wip.addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            }
        }
    }

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        public final void request(long j) {
            long j2;
            long j3;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        j3 = Long.MAX_VALUE;
                        if (j2 != Long.MAX_VALUE) {
                            long j4 = j2 + j;
                            if (j4 >= 0) {
                                j3 = j4;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.drain();
            }
        }

        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        /* access modifiers changed from: package-private */
        public final void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public final void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }
    }
}
