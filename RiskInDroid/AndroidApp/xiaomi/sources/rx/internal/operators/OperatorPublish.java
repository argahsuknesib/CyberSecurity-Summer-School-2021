package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observables.ConnectableObservable;
import rx.subscriptions.Subscriptions;

public final class OperatorPublish<T> extends ConnectableObservable<T> {
    final AtomicReference<PublishSubscriber<T>> current;
    final Observable<? extends T> source;

    public static <T> ConnectableObservable<T> create(Observable observable) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorPublish.AnonymousClass1 */

            public final void call(Subscriber<? super T> subscriber) {
                while (true) {
                    PublishSubscriber publishSubscriber = (PublishSubscriber) atomicReference.get();
                    if (publishSubscriber == null || publishSubscriber.isUnsubscribed()) {
                        PublishSubscriber publishSubscriber2 = new PublishSubscriber(atomicReference);
                        publishSubscriber2.init();
                        if (atomicReference.compareAndSet(publishSubscriber, publishSubscriber2)) {
                            publishSubscriber = publishSubscriber2;
                        } else {
                            continue;
                        }
                    }
                    InnerProducer innerProducer = new InnerProducer(publishSubscriber, subscriber);
                    if (publishSubscriber.add(innerProducer)) {
                        subscriber.add(innerProducer);
                        subscriber.setProducer(innerProducer);
                        return;
                    }
                }
            }
        }, observable, atomicReference);
    }

    public static <T, R> Observable<R> create(Observable observable, Func1 func1) {
        return create(observable, func1, false);
    }

    public static <T, R> Observable<R> create(final Observable<? extends T> observable, final Func1<? super Observable<T>, ? extends Observable<R>> func1, final boolean z) {
        return unsafeCreate(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorPublish.AnonymousClass2 */

            public final void call(final Subscriber<? super R> subscriber) {
                final OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(RxRingBuffer.SIZE, z);
                AnonymousClass1 r1 = new Subscriber<R>() {
                    /* class rx.internal.operators.OperatorPublish.AnonymousClass2.AnonymousClass1 */

                    public void onNext(R r) {
                        subscriber.onNext(r);
                    }

                    public void onError(Throwable th) {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onError(th);
                    }

                    public void onCompleted() {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onCompleted();
                    }

                    public void setProducer(Producer producer) {
                        subscriber.setProducer(producer);
                    }
                };
                subscriber.add(onSubscribePublishMulticast);
                subscriber.add(r1);
                ((Observable) func1.call(Observable.unsafeCreate(onSubscribePublishMulticast))).unsafeSubscribe(r1);
                observable.unsafeSubscribe(onSubscribePublishMulticast.subscriber());
            }
        });
    }

    private OperatorPublish(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<PublishSubscriber<T>> atomicReference) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    public final void connect(Action1<? super Subscription> action1) {
        PublishSubscriber publishSubscriber;
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isUnsubscribed()) {
                break;
            }
            PublishSubscriber publishSubscriber2 = new PublishSubscriber(this.current);
            publishSubscriber2.init();
            if (this.current.compareAndSet(publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = true;
        if (publishSubscriber.shouldConnect.get() || !publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        action1.call(publishSubscriber);
        if (z) {
            this.source.unsafeSubscribe(publishSubscriber);
        }
    }

    static final class PublishSubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final AtomicReference<PublishSubscriber<T>> current;
        boolean emitting;
        boolean missed;
        final AtomicReference<InnerProducer[]> producers;
        final Queue<Object> queue;
        final AtomicBoolean shouldConnect;
        volatile Object terminalEvent;

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference) {
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscArrayQueue<>(RxRingBuffer.SIZE) : new SpscAtomicArrayQueue<>(RxRingBuffer.SIZE);
            this.producers = new AtomicReference<>(EMPTY);
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        /* access modifiers changed from: package-private */
        public final void init() {
            add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorPublish.PublishSubscriber.AnonymousClass1 */

                public void call() {
                    PublishSubscriber.this.producers.getAndSet(PublishSubscriber.TERMINATED);
                    PublishSubscriber.this.current.compareAndSet(PublishSubscriber.this, null);
                }
            }));
        }

        public final void onStart() {
            request((long) RxRingBuffer.SIZE);
        }

        public final void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                dispatch();
            }
        }

        public final void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
            }
        }

        public final void onCompleted() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.completed();
                dispatch();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean add(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            if (innerProducer != null) {
                do {
                    innerProducerArr = this.producers.get();
                    if (innerProducerArr == TERMINATED) {
                        return false;
                    }
                    int length = innerProducerArr.length;
                    innerProducerArr2 = new InnerProducer[(length + 1)];
                    System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, length);
                    innerProducerArr2[length] = innerProducer;
                } while (!this.producers.compareAndSet(innerProducerArr, innerProducerArr2));
                return true;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: package-private */
        public final void remove(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            do {
                innerProducerArr = this.producers.get();
                if (innerProducerArr != EMPTY && innerProducerArr != TERMINATED) {
                    int i = -1;
                    int length = innerProducerArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerProducerArr[i2].equals(innerProducer)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerProducerArr2 = EMPTY;
                        } else {
                            InnerProducer[] innerProducerArr3 = new InnerProducer[(length - 1)];
                            System.arraycopy(innerProducerArr, 0, innerProducerArr3, 0, i);
                            System.arraycopy(innerProducerArr, i + 1, innerProducerArr3, i, (length - i) - 1);
                            innerProducerArr2 = innerProducerArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.producers.compareAndSet(innerProducerArr, innerProducerArr2));
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isCompleted(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    try {
                        InnerProducer[] andSet = this.producers.getAndSet(TERMINATED);
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(error);
                            i++;
                        }
                        return true;
                    } finally {
                        unsubscribe();
                    }
                } else if (z) {
                    this.current.compareAndSet(this, null);
                    try {
                        InnerProducer[] andSet2 = this.producers.getAndSet(TERMINATED);
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].child.onCompleted();
                            i++;
                        }
                        return true;
                    } finally {
                        unsubscribe();
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = r1.terminalEvent;
            r4 = r1.queue.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            if (checkTerminated(r0, r4) == false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            if (r4 != false) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            r5 = r1.producers.get();
            r0 = r5.length;
            r8 = r5.length;
            r9 = Long.MAX_VALUE;
            r6 = 0;
            r7 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
            if (r6 >= r8) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            r13 = r5[r6].get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
            if (r13 < 0) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
            r9 = java.lang.Math.min(r9, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
            if (r13 != Long.MIN_VALUE) goto L_0x0051;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
            if (r0 != r7) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0058, code lost:
            r0 = r1.terminalEvent;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
            if (r1.queue.poll() != null) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0062, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0069, code lost:
            if (checkTerminated(r0, r4) == false) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x006c, code lost:
            request(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
            r0 = r4;
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0072, code lost:
            r6 = (long) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0075, code lost:
            if (r6 >= r9) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0077, code lost:
            r0 = r1.terminalEvent;
            r8 = r1.queue.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
            if (r8 != null) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0081, code lost:
            r15 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0083, code lost:
            r15 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
            if (checkTerminated(r0, r15) == false) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x008a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008b, code lost:
            if (r15 != false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008d, code lost:
            r6 = rx.internal.operators.NotificationLite.getValue(r8);
            r7 = r5.length;
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0093, code lost:
            if (r8 >= r7) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
            r2 = r5[r8];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x009d, code lost:
            if (r2.get() <= 0) goto L_0x00b1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            r2.child.onNext(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r2.produced(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a9, code lost:
            r2.unsubscribe();
            rx.exceptions.Exceptions.throwOrReport(r0, r2.child, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b5, code lost:
            r4 = r4 + 1;
            r0 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ba, code lost:
            r15 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00bb, code lost:
            if (r4 <= 0) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00bd, code lost:
            request(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c2, code lost:
            if (r9 == 0) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c4, code lost:
            if (r15 == false) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c6, code lost:
            monitor-enter(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c9, code lost:
            if (r1.missed != false) goto L_0x00d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00cb, code lost:
            r1.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ce, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00cf, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00d0, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            r1.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d4, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x00d8, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x00d9, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x00dc, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x00de, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x00e0, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x00e1, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x00e2, code lost:
            if (r2 == false) goto L_0x00e4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x00e4, code lost:
            monitor-enter(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
            r1.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x00ec, code lost:
            throw r0;
         */
        public final void dispatch() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                } else {
                    this.emitting = true;
                    this.missed = false;
                }
            }
            int i = i + 1;
        }
    }

    static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        final PublishSubscriber<T> parent;

        public InnerProducer(PublishSubscriber<T> publishSubscriber, Subscriber<? super T> subscriber) {
            this.parent = publishSubscriber;
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        public final void request(long j) {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 >= 0 && j == 0) {
                            return;
                        }
                        if (j2 == -4611686018427387904L) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.dispatch();
            }
        }

        public final long produced(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == -4611686018427387904L) {
                        throw new IllegalStateException("Produced without request");
                    } else if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    } else {
                        j3 = j2 - j;
                        if (j3 < 0) {
                            throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                        }
                    }
                } while (!compareAndSet(j2, j3));
                return j3;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        public final boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public final void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.dispatch();
            }
        }
    }
}
