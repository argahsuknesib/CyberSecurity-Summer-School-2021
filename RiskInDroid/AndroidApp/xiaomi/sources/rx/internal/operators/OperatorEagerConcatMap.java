package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

public final class OperatorEagerConcatMap<T, R> implements Observable.Operator<R, T> {
    final int bufferSize;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    private final int maxConcurrent;

    public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        this.mapper = func1;
        this.bufferSize = i;
        this.maxConcurrent = i2;
    }

    public final Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        EagerOuterSubscriber eagerOuterSubscriber = new EagerOuterSubscriber(this.mapper, this.bufferSize, this.maxConcurrent, subscriber);
        eagerOuterSubscriber.init();
        return eagerOuterSubscriber;
    }

    static final class EagerOuterProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = -657299606803478389L;
        final EagerOuterSubscriber<?, ?> parent;

        public EagerOuterProducer(EagerOuterSubscriber<?, ?> eagerOuterSubscriber) {
            this.parent = eagerOuterSubscriber;
        }

        public final void request(long j) {
            if (j < 0) {
                throw new IllegalStateException("n >= 0 required but it was ".concat(String.valueOf(j)));
            } else if (j > 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                this.parent.drain();
            }
        }
    }

    static final class EagerOuterSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final Func1<? super T, ? extends Observable<? extends R>> mapper;
        private EagerOuterProducer sharedProducer;
        final Queue<EagerInnerSubscriber<R>> subscribers = new LinkedList();
        final AtomicInteger wip = new AtomicInteger();

        public EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2, Subscriber<? super R> subscriber) {
            this.mapper = func1;
            this.bufferSize = i;
            this.actual = subscriber;
            request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
        }

        /* access modifiers changed from: package-private */
        public final void init() {
            this.sharedProducer = new EagerOuterProducer(this);
            add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.AnonymousClass1 */

                public void call() {
                    EagerOuterSubscriber eagerOuterSubscriber = EagerOuterSubscriber.this;
                    eagerOuterSubscriber.cancelled = true;
                    if (eagerOuterSubscriber.wip.getAndIncrement() == 0) {
                        EagerOuterSubscriber.this.cleanup();
                    }
                }
            }));
            this.actual.add(this);
            this.actual.setProducer(this.sharedProducer);
        }

        /* access modifiers changed from: package-private */
        public final void cleanup() {
            ArrayList<Subscription> arrayList;
            synchronized (this.subscribers) {
                arrayList = new ArrayList<>(this.subscribers);
                this.subscribers.clear();
            }
            for (Subscription unsubscribe : arrayList) {
                unsubscribe.unsubscribe();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            if (r3.cancelled == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            r0.unsafeSubscribe(r4);
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            return;
         */
        public final void onNext(T t) {
            try {
                Observable observable = (Observable) this.mapper.call(t);
                if (!this.cancelled) {
                    EagerInnerSubscriber eagerInnerSubscriber = new EagerInnerSubscriber(this, this.bufferSize);
                    synchronized (this.subscribers) {
                        if (!this.cancelled) {
                            this.subscribers.add(eagerInnerSubscriber);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.actual, t);
            }
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            EagerInnerSubscriber peek;
            int i;
            boolean z;
            if (this.wip.getAndIncrement() == 0) {
                EagerOuterProducer eagerOuterProducer = this.sharedProducer;
                Subscriber<? super R> subscriber = this.actual;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z2 = this.done;
                    synchronized (this.subscribers) {
                        peek = this.subscribers.peek();
                    }
                    boolean z3 = false;
                    boolean z4 = peek == null;
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            cleanup();
                            subscriber.onError(th);
                            return;
                        } else if (z4) {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (!z4) {
                        long j = eagerOuterProducer.get();
                        Queue<Object> queue = peek.queue;
                        long j2 = 0;
                        while (true) {
                            boolean z5 = peek.done;
                            Object peek2 = queue.peek();
                            if (peek2 == null) {
                                i = i2;
                                z = true;
                            } else {
                                i = i2;
                                z = false;
                            }
                            if (z5) {
                                Throwable th2 = peek.error;
                                if (th2 == null) {
                                    if (z) {
                                        synchronized (this.subscribers) {
                                            this.subscribers.poll();
                                        }
                                        peek.unsubscribe();
                                        request(1);
                                        z3 = true;
                                        break;
                                    }
                                } else {
                                    cleanup();
                                    subscriber.onError(th2);
                                    return;
                                }
                            }
                            if (z || j == j2) {
                                break;
                            }
                            queue.poll();
                            try {
                                subscriber.onNext(NotificationLite.getValue(peek2));
                                j2++;
                                i2 = i;
                            } catch (Throwable th3) {
                                Exceptions.throwOrReport(th3, subscriber, peek2);
                                return;
                            }
                        }
                        if (j2 != 0) {
                            if (j != Long.MAX_VALUE) {
                                BackpressureUtils.produced(eagerOuterProducer, j2);
                            }
                            if (!z3) {
                                peek.requestMore(j2);
                            }
                        }
                        if (z3) {
                            i2 = i;
                        }
                    } else {
                        i = i2;
                    }
                    i2 = this.wip.addAndGet(-i);
                    if (i2 == 0) {
                        return;
                    }
                }
                cleanup();
            }
        }
    }

    static final class EagerInnerSubscriber<T> extends Subscriber<T> {
        volatile boolean done;
        Throwable error;
        final EagerOuterSubscriber<?, T> parent;
        final Queue<Object> queue;

        public EagerInnerSubscriber(EagerOuterSubscriber<?, T> eagerOuterSubscriber, int i) {
            Queue<Object> queue2;
            this.parent = eagerOuterSubscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscArrayQueue<>(i);
            } else {
                queue2 = new SpscAtomicArrayQueue<>(i);
            }
            this.queue = queue2;
            request((long) i);
        }

        public final void onNext(T t) {
            this.queue.offer(NotificationLite.next(t));
            this.parent.drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        public final void onCompleted() {
            this.done = true;
            this.parent.drain();
        }

        /* access modifiers changed from: package-private */
        public final void requestMore(long j) {
            request(j);
        }
    }
}
