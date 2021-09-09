package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    public static <T> ConnectableFlowable<T> create(Flowable flowable, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowablePublish(new FlowablePublisher(atomicReference, i), flowable, atomicReference, i));
    }

    private FlowablePublish(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferSize = i;
    }

    public final Publisher<T> source() {
        return this.source;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    public final void connect(Consumer<? super Disposable> consumer) {
        PublishSubscriber publishSubscriber;
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber publishSubscriber2 = new PublishSubscriber(this.current, this.bufferSize);
            if (this.current.compareAndSet(publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = true;
        if (publishSubscriber.shouldConnect.get() || !publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(publishSubscriber);
            if (z) {
                this.source.subscribe((FlowableSubscriber) publishSubscriber);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile SimpleQueue<T> queue;
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference<>(EMPTY);
        volatile Object terminalEvent;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = i;
        }

        public final void dispose() {
            InnerSubscriber<T>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<T>[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr != innerSubscriberArr2 && ((InnerSubscriber[]) this.subscribers.getAndSet(innerSubscriberArr2)) != TERMINATED) {
                this.current.compareAndSet(this, null);
                SubscriptionHelper.cancel(this.upstream);
            }
        }

        public final boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
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
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        public final void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = EMPTY;
                        } else {
                            InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[(length - 1)];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                            System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                            innerSubscriberArr2 = innerSubscriberArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                    if (innerSubscriberArr.length != 0) {
                        int length = innerSubscriberArr.length;
                        while (i < length) {
                            innerSubscriberArr[i].child.onError(error);
                            i++;
                        }
                    } else {
                        RxJavaPlugins.onError(error);
                    }
                    return true;
                } else if (z) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                    int length2 = innerSubscriberArr2.length;
                    while (i < length2) {
                        innerSubscriberArr2[i].child.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x013e, code lost:
            if (r8 == 0) goto L_0x0151;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0143, code lost:
            if (r1.sourceMode == 1) goto L_0x0152;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0145, code lost:
            r1.upstream.get().request(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0156, code lost:
            if (r14 == 0) goto L_0x015c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0158, code lost:
            if (r0 == false) goto L_0x016a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x016a, code lost:
            continue;
         */
        public final void dispatch() {
            T t;
            InnerSubscriber[] innerSubscriberArr;
            boolean z;
            SimpleQueue<T> simpleQueue;
            T t2;
            if (getAndIncrement() == 0) {
                AtomicReference<InnerSubscriber<T>[]> atomicReference = this.subscribers;
                int i = 1;
                InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) atomicReference.get();
                int i2 = 1;
                while (true) {
                    Object obj = this.terminalEvent;
                    SimpleQueue<T> simpleQueue2 = this.queue;
                    boolean z2 = simpleQueue2 == null || simpleQueue2.isEmpty();
                    if (!checkTerminated(obj, z2)) {
                        if (!z2) {
                            int length = innerSubscriberArr2.length;
                            int i3 = 0;
                            long j = Long.MAX_VALUE;
                            for (InnerSubscriber innerSubscriber : innerSubscriberArr2) {
                                long j2 = innerSubscriber.get();
                                if (j2 != Long.MIN_VALUE) {
                                    j = Math.min(j, j2 - innerSubscriber.emitted);
                                } else {
                                    i3++;
                                }
                            }
                            if (length == i3) {
                                Object obj2 = this.terminalEvent;
                                try {
                                    t2 = simpleQueue2.poll();
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Exceptions.throwIfFatal(th2);
                                    this.upstream.get().cancel();
                                    obj2 = NotificationLite.error(th2);
                                    this.terminalEvent = obj2;
                                    t2 = null;
                                }
                                if (!checkTerminated(obj2, t2 == null)) {
                                    if (this.sourceMode != i) {
                                        this.upstream.get().request(1);
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                boolean z3 = z2;
                                int i4 = 0;
                                while (true) {
                                    long j3 = (long) i4;
                                    if (j3 >= j) {
                                        break;
                                    }
                                    Object obj3 = this.terminalEvent;
                                    try {
                                        t = simpleQueue2.poll();
                                    } catch (Throwable th3) {
                                        Throwable th4 = th3;
                                        Exceptions.throwIfFatal(th4);
                                        this.upstream.get().cancel();
                                        obj3 = NotificationLite.error(th4);
                                        this.terminalEvent = obj3;
                                        t = null;
                                    }
                                    boolean z4 = t == null;
                                    if (!checkTerminated(obj3, z4)) {
                                        if (z4) {
                                            z3 = z4;
                                            break;
                                        }
                                        Object value = NotificationLite.getValue(t);
                                        int length2 = innerSubscriberArr2.length;
                                        int i5 = 0;
                                        boolean z5 = false;
                                        while (i5 < length2) {
                                            InnerSubscriber innerSubscriber2 = innerSubscriberArr2[i5];
                                            long j4 = innerSubscriber2.get();
                                            if (j4 != Long.MIN_VALUE) {
                                                if (j4 != Long.MAX_VALUE) {
                                                    simpleQueue = simpleQueue2;
                                                    z = z4;
                                                    innerSubscriber2.emitted++;
                                                } else {
                                                    simpleQueue = simpleQueue2;
                                                    z = z4;
                                                }
                                                innerSubscriber2.child.onNext(value);
                                            } else {
                                                simpleQueue = simpleQueue2;
                                                z = z4;
                                                z5 = true;
                                            }
                                            i5++;
                                            simpleQueue2 = simpleQueue;
                                            z4 = z;
                                        }
                                        SimpleQueue<T> simpleQueue3 = simpleQueue2;
                                        boolean z6 = z4;
                                        i4++;
                                        innerSubscriberArr = (InnerSubscriber[]) atomicReference.get();
                                        if (!z5 && innerSubscriberArr == innerSubscriberArr2) {
                                            simpleQueue2 = simpleQueue3;
                                            z3 = z6;
                                        } else if (!(i4 == 0 || this.sourceMode == 1)) {
                                            this.upstream.get().request((long) i4);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                this.upstream.get().request((long) i4);
                                innerSubscriberArr2 = innerSubscriberArr;
                            }
                            i = 1;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 != 0) {
                            innerSubscriberArr2 = (InnerSubscriber[]) atomicReference.get();
                            i = 1;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        long emitted;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }

        public final void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE && (publishSubscriber = this.parent) != null) {
                publishSubscriber.remove(this);
                publishSubscriber.dispatch();
            }
        }
    }

    static final class FlowablePublisher<T> implements Publisher<T> {
        private final int bufferSize;
        private final AtomicReference<PublishSubscriber<T>> curr;

        FlowablePublisher(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.curr = atomicReference;
            this.bufferSize = i;
        }

        public final void subscribe(Subscriber<? super T> subscriber) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber innerSubscriber = new InnerSubscriber(subscriber);
            subscriber.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.curr.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.curr, this.bufferSize);
                    if (this.curr.compareAndSet(publishSubscriber, publishSubscriber2)) {
                        publishSubscriber = publishSubscriber2;
                    } else {
                        continue;
                    }
                }
                if (publishSubscriber.add(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.remove(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.dispatch();
        }
    }
}
