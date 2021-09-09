package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
    final Func1<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Observable<? extends T> source;

    protected OnSubscribeFlattenIterable(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i;
    }

    public final void call(Subscriber<? super R> subscriber) {
        final FlattenIterableSubscriber flattenIterableSubscriber = new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch);
        subscriber.add(flattenIterableSubscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeFlattenIterable.AnonymousClass1 */

            public void request(long j) {
                flattenIterableSubscriber.requestMore(j);
            }
        });
        this.source.unsafeSubscribe(flattenIterableSubscriber);
    }

    public static <T, R> Observable<R> createFrom(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        if (observable instanceof ScalarSynchronousObservable) {
            return Observable.unsafeCreate(new OnSubscribeScalarFlattenIterable(((ScalarSynchronousObservable) observable).get(), func1));
        }
        return Observable.unsafeCreate(new OnSubscribeFlattenIterable(observable, func1, i));
    }

    static final class FlattenIterableSubscriber<T, R> extends Subscriber<T> {
        Iterator<? extends R> active;
        final Subscriber<? super R> actual;
        volatile boolean done;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final long limit;
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        long produced;
        final Queue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
            this.actual = subscriber;
            this.mapper = func1;
            if (i == Integer.MAX_VALUE) {
                this.limit = Long.MAX_VALUE;
                this.queue = new SpscLinkedArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.limit = (long) (i - (i >> 2));
                if (UnsafeAccess.isUnsafeAvailable()) {
                    this.queue = new SpscArrayQueue(i);
                } else {
                    this.queue = new SpscAtomicArrayQueue(i);
                }
            }
            request((long) i);
        }

        public final void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        public final void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaHooks.onError(th);
        }

        public final void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void requestMore(long j) {
            if (j > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            } else if (j < 0) {
                throw new IllegalStateException("n >= 0 required but it was ".concat(String.valueOf(j)));
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c9, code lost:
            if (r14 != null) goto L_0x00cf;
         */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00d8 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0010 A[SYNTHETIC] */
        public final void drain() {
            int i;
            Iterator<? extends R> it;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.actual;
                Queue<Object> queue2 = this.queue;
                int i2 = 1;
                while (true) {
                    Iterator<? extends R> it2 = this.active;
                    boolean z = false;
                    if (it2 == null) {
                        boolean z2 = this.done;
                        Object poll = queue2.poll();
                        boolean z3 = poll == null;
                        if (!checkTerminated(z2, z3, subscriber, queue2)) {
                            if (!z3) {
                                long j = this.produced + 1;
                                i = i2;
                                if (j == this.limit) {
                                    this.produced = 0;
                                    request(j);
                                } else {
                                    this.produced = j;
                                }
                                try {
                                    it2 = ((Iterable) this.mapper.call(NotificationLite.getValue(poll))).iterator();
                                    if (it2.hasNext()) {
                                        this.active = it2;
                                        if (it2 != null) {
                                            long j2 = this.requested.get();
                                            long j3 = 0;
                                            while (true) {
                                                it = null;
                                                if (j3 == j2) {
                                                    it = it2;
                                                    break;
                                                } else if (!checkTerminated(this.done, false, subscriber, queue2)) {
                                                    try {
                                                        subscriber.onNext(it2.next());
                                                        if (!checkTerminated(this.done, false, subscriber, queue2)) {
                                                            j3++;
                                                            try {
                                                                if (!it2.hasNext()) {
                                                                    this.active = null;
                                                                    break;
                                                                }
                                                            } catch (Throwable th) {
                                                                Throwable th2 = th;
                                                                Exceptions.throwIfFatal(th2);
                                                                this.active = null;
                                                                onError(th2);
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } catch (Throwable th3) {
                                                        Throwable th4 = th3;
                                                        Exceptions.throwIfFatal(th4);
                                                        this.active = null;
                                                        onError(th4);
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                            if (j3 == j2) {
                                                boolean z4 = this.done;
                                                if (queue2.isEmpty() && it == null) {
                                                    z = true;
                                                }
                                                if (checkTerminated(z4, z, subscriber, queue2)) {
                                                    return;
                                                }
                                            }
                                            if (j3 != 0) {
                                                BackpressureUtils.produced(this.requested, j3);
                                            }
                                        }
                                        i2 = this.wip.addAndGet(-i);
                                        if (i2 != 0) {
                                            return;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    Exceptions.throwIfFatal(th5);
                                    onError(th5);
                                }
                                i2 = i;
                            }
                        } else {
                            return;
                        }
                    }
                    i = i2;
                    if (it2 != null) {
                    }
                    i2 = this.wip.addAndGet(-i);
                    if (i2 != 0) {
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue2) {
            if (subscriber.isUnsubscribed()) {
                queue2.clear();
                this.active = null;
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    unsubscribe();
                    queue2.clear();
                    this.active = null;
                    subscriber.onError(terminate);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onCompleted();
                    return true;
                }
            }
        }
    }

    static final class OnSubscribeScalarFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        final T value;

        public OnSubscribeScalarFlattenIterable(T t, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.value = t;
            this.mapper = func1;
        }

        public final void call(Subscriber<? super R> subscriber) {
            try {
                Iterator it = ((Iterable) this.mapper.call(this.value)).iterator();
                if (!it.hasNext()) {
                    subscriber.onCompleted();
                } else {
                    subscriber.setProducer(new OnSubscribeFromIterable.IterableProducer(subscriber, it));
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, subscriber, this.value);
            }
        }
    }
}
