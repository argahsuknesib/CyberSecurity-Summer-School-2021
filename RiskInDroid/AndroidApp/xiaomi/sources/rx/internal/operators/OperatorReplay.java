package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.util.OpenHashSet;
import rx.observables.ConnectableObservable;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

public final class OperatorReplay<T> extends ConnectableObservable<T> implements Subscription {
    static final Func0 DEFAULT_UNBOUNDED_FACTORY = new Func0() {
        /* class rx.internal.operators.OperatorReplay.AnonymousClass1 */

        public final Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    final Func0<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Observable<? extends T> source;

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    public static <T, U, R> Observable<R> multicastSelector(final Func0<? extends ConnectableObservable<U>> func0, final Func1<? super Observable<U>, ? extends Observable<R>> func1) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass2 */

            public final void call(final Subscriber<? super R> subscriber) {
                try {
                    ConnectableObservable connectableObservable = (ConnectableObservable) func0.call();
                    ((Observable) func1.call(connectableObservable)).subscribe((Subscriber) subscriber);
                    connectableObservable.connect(new Action1<Subscription>() {
                        /* class rx.internal.operators.OperatorReplay.AnonymousClass2.AnonymousClass1 */

                        public void call(Subscription subscription) {
                            subscriber.add(subscription);
                        }
                    });
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber);
                }
            }
        });
    }

    public static <T> ConnectableObservable<T> observeOn(final ConnectableObservable connectableObservable, Scheduler scheduler) {
        final Observable observeOn = connectableObservable.observeOn(scheduler);
        return new ConnectableObservable<T>(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass3 */

            public final void call(final Subscriber<? super T> subscriber) {
                observeOn.unsafeSubscribe(new Subscriber<T>(subscriber) {
                    /* class rx.internal.operators.OperatorReplay.AnonymousClass3.AnonymousClass1 */

                    public void onNext(T t) {
                        subscriber.onNext(t);
                    }

                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    public void onCompleted() {
                        subscriber.onCompleted();
                    }
                });
            }
        }) {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass4 */

            public final void connect(Action1<? super Subscription> action1) {
                connectableObservable.connect(action1);
            }
        };
    }

    public static <T> ConnectableObservable<T> create(Observable observable) {
        return create(observable, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableObservable<T> create(Observable observable, final int i) {
        if (i == Integer.MAX_VALUE) {
            return create(observable);
        }
        return create(observable, new Func0<ReplayBuffer<T>>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass5 */

            public final ReplayBuffer<T> call() {
                return new SizeBoundReplayBuffer(i);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(observable, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j, TimeUnit timeUnit, final Scheduler scheduler, final int i) {
        final long millis = timeUnit.toMillis(j);
        return create(observable, new Func0<ReplayBuffer<T>>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass6 */

            public final ReplayBuffer<T> call() {
                return new SizeAndTimeBoundReplayBuffer(i, millis, scheduler);
            }
        });
    }

    static <T> ConnectableObservable<T> create(Observable observable, final Func0 func0) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass7 */

            /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
            public final void call(Subscriber<? super T> subscriber) {
                ReplaySubscriber replaySubscriber;
                while (true) {
                    replaySubscriber = (ReplaySubscriber) atomicReference.get();
                    if (replaySubscriber != null) {
                        break;
                    }
                    ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) func0.call());
                    replaySubscriber2.init();
                    if (atomicReference.compareAndSet(replaySubscriber, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                }
                InnerProducer innerProducer = new InnerProducer(replaySubscriber, subscriber);
                replaySubscriber.add(innerProducer);
                subscriber.add(innerProducer);
                replaySubscriber.buffer.replay(innerProducer);
                subscriber.setProducer(innerProducer);
            }
        }, observable, atomicReference, func0);
    }

    private OperatorReplay(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<ReplaySubscriber<T>> atomicReference, Func0<? extends ReplayBuffer<T>> func0) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
        this.bufferFactory = func0;
    }

    public final void unsubscribe() {
        this.current.lazySet(null);
    }

    public final boolean isUnsubscribed() {
        ReplaySubscriber replaySubscriber = this.current.get();
        return replaySubscriber == null || replaySubscriber.isUnsubscribed();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    public final void connect(Action1<? super Subscription> action1) {
        ReplaySubscriber replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isUnsubscribed()) {
                break;
            }
            ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) this.bufferFactory.call());
            replaySubscriber2.init();
            if (this.current.compareAndSet(replaySubscriber, replaySubscriber2)) {
                replaySubscriber = replaySubscriber2;
                break;
            }
        }
        boolean z = true;
        if (replaySubscriber.shouldConnect.get() || !replaySubscriber.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        action1.call(replaySubscriber);
        if (z) {
            this.source.unsafeSubscribe(replaySubscriber);
        }
    }

    static final class ReplaySubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final ReplayBuffer<T> buffer;
        boolean coordinateAll;
        List<InnerProducer<T>> coordinationQueue;
        boolean done;
        boolean emitting;
        long maxChildRequested;
        long maxUpstreamRequested;
        boolean missed;
        volatile Producer producer;
        final OpenHashSet<InnerProducer<T>> producers = new OpenHashSet<>();
        InnerProducer<T>[] producersCache = EMPTY;
        long producersCacheVersion;
        volatile long producersVersion;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        volatile boolean terminated;

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            request(0);
        }

        /* access modifiers changed from: package-private */
        public final void init() {
            add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorReplay.ReplaySubscriber.AnonymousClass1 */

                public void call() {
                    if (!ReplaySubscriber.this.terminated) {
                        synchronized (ReplaySubscriber.this.producers) {
                            if (!ReplaySubscriber.this.terminated) {
                                ReplaySubscriber.this.producers.terminate();
                                ReplaySubscriber.this.producersVersion++;
                                ReplaySubscriber.this.terminated = true;
                            }
                        }
                    }
                }
            }));
        }

        /* access modifiers changed from: package-private */
        public final boolean add(InnerProducer<T> innerProducer) {
            if (innerProducer == null) {
                throw new NullPointerException();
            } else if (this.terminated) {
                return false;
            } else {
                synchronized (this.producers) {
                    if (this.terminated) {
                        return false;
                    }
                    this.producers.add(innerProducer);
                    this.producersVersion++;
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void remove(InnerProducer<T> innerProducer) {
            if (!this.terminated) {
                synchronized (this.producers) {
                    if (!this.terminated) {
                        this.producers.remove(innerProducer);
                        if (this.producers.isEmpty()) {
                            this.producersCache = EMPTY;
                        }
                        this.producersVersion++;
                    }
                }
            }
        }

        public final void setProducer(Producer producer2) {
            if (this.producer == null) {
                this.producer = producer2;
                manageRequests(null);
                replay();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }

        public final void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        public final void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.error(th);
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        public final void onCompleted() {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.complete();
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
            r0 = r9.maxChildRequested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            if (r10 == null) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
            r3 = java.lang.Math.max(r0, r10.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            r10 = copyProducers();
            r3 = r10.length;
            r5 = r0;
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
            if (r4 >= r3) goto L_0x0051;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
            r7 = r10[r4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            if (r7 == null) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
            r5 = java.lang.Math.max(r5, r7.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
            r4 = r4 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
            r3 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
            makeRequest(r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            if (isUnsubscribed() == false) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005f, code lost:
            if (r9.missed != false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0065, code lost:
            r9.missed = false;
            r10 = r9.coordinationQueue;
            r9.coordinationQueue = null;
            r0 = r9.coordinateAll;
            r9.coordinateAll = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0070, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0071, code lost:
            r3 = r9.maxChildRequested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0073, code lost:
            if (r10 == null) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0075, code lost:
            r10 = r10.iterator();
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x007e, code lost:
            if (r10.hasNext() == false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0080, code lost:
            r5 = java.lang.Math.max(r5, r10.next().totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0092, code lost:
            if (r0 == false) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0094, code lost:
            r10 = copyProducers();
            r0 = r10.length;
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x009a, code lost:
            if (r1 >= r0) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009c, code lost:
            r7 = r10[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009e, code lost:
            if (r7 == null) goto L_0x00aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a0, code lost:
            r5 = java.lang.Math.max(r5, r7.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00aa, code lost:
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ad, code lost:
            makeRequest(r5, r3);
         */
        public final void manageRequests(InnerProducer<T> innerProducer) {
            if (!isUnsubscribed()) {
                synchronized (this) {
                    if (this.emitting) {
                        if (innerProducer != null) {
                            List list = this.coordinationQueue;
                            if (list == null) {
                                list = new ArrayList();
                                this.coordinationQueue = list;
                            }
                            list.add(innerProducer);
                        } else {
                            this.coordinateAll = true;
                        }
                        this.missed = true;
                        return;
                    }
                    this.emitting = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final InnerProducer<T>[] copyProducers() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.producers) {
                Object[] values = this.producers.values();
                int length = values.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(values, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        /* access modifiers changed from: package-private */
        public final void makeRequest(long j, long j2) {
            long j3 = this.maxUpstreamRequested;
            Producer producer2 = this.producer;
            long j4 = j - j2;
            if (j4 != 0) {
                this.maxChildRequested = j;
                if (producer2 == null) {
                    long j5 = j3 + j4;
                    if (j5 < 0) {
                        j5 = Long.MAX_VALUE;
                    }
                    this.maxUpstreamRequested = j5;
                } else if (j3 != 0) {
                    this.maxUpstreamRequested = 0;
                    producer2.request(j3 + j4);
                } else {
                    producer2.request(j4);
                }
            } else if (j3 != 0 && producer2 != null) {
                this.maxUpstreamRequested = 0;
                producer2.request(j3);
            }
        }

        /* access modifiers changed from: package-private */
        public final void replay() {
            InnerProducer<T>[] innerProducerArr = this.producersCache;
            if (this.producersCacheVersion != this.producersVersion) {
                synchronized (this.producers) {
                    innerProducerArr = this.producersCache;
                    Object[] values = this.producers.values();
                    int length = values.length;
                    if (innerProducerArr.length != length) {
                        innerProducerArr = new InnerProducer[length];
                        this.producersCache = innerProducerArr;
                    }
                    System.arraycopy(values, 0, innerProducerArr, 0, length);
                    this.producersCacheVersion = this.producersVersion;
                }
            }
            ReplayBuffer<T> replayBuffer = this.buffer;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    replayBuffer.replay(innerProducer);
                }
            }
        }
    }

    static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        public final void request(long j) {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 < 0 || j != 0) {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                addTotalRequested(j);
                this.parent.manageRequests(this);
                this.parent.buffer.replay(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void addTotalRequested(long j) {
            long j2;
            long j3;
            do {
                j2 = this.totalRequested.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(j2, j3));
        }

        public final long produced(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
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
                this.parent.manageRequests(this);
                this.child = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final <U> U index() {
            return this.index;
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        public final void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        public final void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        public final void complete() {
            add(NotificationLite.completed());
            this.size++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            if (r13.isUnsubscribed() == false) goto L_0x0014;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r0 = r12.size;
            r1 = (java.lang.Integer) r13.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
            if (r1 == null) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r1 = r1.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r3 = r13.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if (r3 != null) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            r4 = r13.get();
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            if (r8 == r4) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            if (r1 >= r0) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
            r10 = get(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
            if (rx.internal.operators.NotificationLite.accept(r3, r10) == false) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
            if (r13.isUnsubscribed() == false) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
            r1 = r1 + 1;
            r8 = r8 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x004f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r0);
            r13.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005a, code lost:
            if (rx.internal.operators.NotificationLite.isError(r10) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0062, code lost:
            r3.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r0, rx.internal.operators.NotificationLite.getValue(r10)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0070, code lost:
            if (r8 == 0) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
            r13.index = java.lang.Integer.valueOf(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007f, code lost:
            if (r4 == Long.MAX_VALUE) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0081, code lost:
            r13.produced(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
            monitor-enter(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0087, code lost:
            if (r13.missed != false) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0089, code lost:
            r13.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x008b, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008d, code lost:
            r13.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008f, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            return;
         */
        public final void replay(InnerProducer<T> innerProducer) {
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
            }
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        /* access modifiers changed from: package-private */
        public Object enterTransform(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public Object leaveTransform(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public void truncate() {
        }

        /* access modifiers changed from: package-private */
        public void truncateFinal() {
        }

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0);
            this.tail = node;
            set(node);
        }

        /* access modifiers changed from: package-private */
        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        /* access modifiers changed from: package-private */
        public final void removeFirst() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        /* access modifiers changed from: package-private */
        public final void removeSome(int i) {
            Node node = (Node) get();
            while (i > 0) {
                node = (Node) node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        /* access modifiers changed from: package-private */
        public final void setFirst(Node node) {
            set(node);
        }

        /* access modifiers changed from: package-private */
        public Node getInitialHead() {
            return (Node) get();
        }

        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.completed());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0014;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r0 = (rx.internal.operators.OperatorReplay.Node) r12.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
            if (r0 != null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
            r0 = getInitialHead();
            r12.index = r0;
            r12.addTotalRequested(r0.index);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            r1 = r12.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
            if (r1 != null) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            r2 = r12.get();
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
            if (r6 == r2) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
            r8 = (rx.internal.operators.OperatorReplay.Node) r0.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
            if (r8 == null) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
            r0 = leaveTransform(r8.value);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
            if (rx.internal.operators.NotificationLite.accept(r1, r0) == false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
            r12.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
            r0 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            r12.index = null;
            rx.exceptions.Exceptions.throwIfFatal(r2);
            r12.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x006f, code lost:
            if (rx.internal.operators.NotificationLite.isError(r0) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0077, code lost:
            r1.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r2, rx.internal.operators.NotificationLite.getValue(r0)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0085, code lost:
            if (r6 == 0) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0087, code lost:
            r12.index = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0090, code lost:
            if (r2 == Long.MAX_VALUE) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0092, code lost:
            r12.produced(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0095, code lost:
            monitor-enter(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0099, code lost:
            if (r12.missed != false) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009b, code lost:
            r12.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009d, code lost:
            monitor-exit(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
            r12.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a1, code lost:
            monitor-exit(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return;
         */
        public final void replay(InnerProducer<T> innerProducer) {
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = (Node) initialHead.get();
                if (initialHead != null) {
                    Object leaveTransform = leaveTransform(initialHead.value);
                    if (!NotificationLite.isCompleted(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                        collection.add(NotificationLite.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean hasError() {
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        /* access modifiers changed from: package-private */
        public boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isCompleted(leaveTransform(this.tail.value));
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        /* access modifiers changed from: package-private */
        public final void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final Scheduler scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, Scheduler scheduler2) {
            this.scheduler = scheduler2;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        /* access modifiers changed from: package-private */
        public final Object enterTransform(Object obj) {
            return new Timestamped(this.scheduler.now(), obj);
        }

        /* access modifiers changed from: package-private */
        public final Object leaveTransform(Object obj) {
            return ((Timestamped) obj).getValue();
        }

        /* access modifiers changed from: package-private */
        public final Node getInitialHead() {
            Node node;
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 == null) {
                    break;
                }
                Object obj2 = node2.value;
                Object leaveTransform = leaveTransform(obj2);
                if (NotificationLite.isCompleted(leaveTransform) || NotificationLite.isError(leaveTransform) || ((Timestamped) obj2).getTimestampMillis() > now) {
                    break;
                }
                obj = node2.get();
            }
            return node;
        }

        /* access modifiers changed from: package-private */
        public final void truncate() {
            Node node;
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    if (this.size <= this.limit) {
                        if (((Timestamped) node2.value).getTimestampMillis() > now) {
                            break;
                        }
                        i++;
                        this.size--;
                        node3 = (Node) node2.get();
                    } else {
                        i++;
                        this.size--;
                        node3 = (Node) node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
        public final void truncateFinal() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                Node node3 = node2;
                Node node4 = node;
                node = node3;
                if (node != null && this.size > 1 && ((Timestamped) node.value).getTimestampMillis() <= now) {
                    i++;
                    this.size--;
                    node2 = (Node) node.get();
                } else if (i == 0) {
                    setFirst(node4);
                    return;
                } else {
                    return;
                }
            }
            if (i == 0) {
            }
        }
    }
}
