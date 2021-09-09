package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OperatorMapNotification<T, R> implements Observable.Operator<R, T> {
    final Func0<? extends R> onCompleted;
    final Func1<? super Throwable, ? extends R> onError;
    final Func1<? super T, ? extends R> onNext;

    public OperatorMapNotification(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        this.onNext = func1;
        this.onError = func12;
        this.onCompleted = func0;
    }

    public final Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        final MapNotificationSubscriber mapNotificationSubscriber = new MapNotificationSubscriber(subscriber, this.onNext, this.onError, this.onCompleted);
        subscriber.add(mapNotificationSubscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorMapNotification.AnonymousClass1 */

            public void request(long j) {
                mapNotificationSubscriber.requestInner(j);
            }
        });
        return mapNotificationSubscriber;
    }

    static final class MapNotificationSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final AtomicLong missedRequested = new AtomicLong();
        final Func0<? extends R> onCompleted;
        final Func1<? super Throwable, ? extends R> onError;
        final Func1<? super T, ? extends R> onNext;
        long produced;
        final AtomicReference<Producer> producer = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        R value;

        public MapNotificationSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
            this.actual = subscriber;
            this.onNext = func1;
            this.onError = func12;
            this.onCompleted = func0;
        }

        public final void onNext(T t) {
            try {
                this.produced++;
                this.actual.onNext(this.onNext.call(t));
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.actual, t);
            }
        }

        public final void onError(Throwable th) {
            accountProduced();
            try {
                this.value = this.onError.call(th);
            } catch (Throwable th2) {
                Exceptions.throwOrReport(th2, this.actual, th);
            }
            tryEmit();
        }

        public final void onCompleted() {
            accountProduced();
            try {
                this.value = this.onCompleted.call();
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.actual);
            }
            tryEmit();
        }

        /* access modifiers changed from: package-private */
        public final void accountProduced() {
            long j = this.produced;
            if (j != 0 && this.producer.get() != null) {
                BackpressureUtils.produced(this.requested, j);
            }
        }

        public final void setProducer(Producer producer2) {
            if (this.producer.compareAndSet(null, producer2)) {
                long andSet = this.missedRequested.getAndSet(0);
                if (andSet != 0) {
                    producer2.request(andSet);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Producer already set!");
        }

        /* access modifiers changed from: package-private */
        public final void tryEmit() {
            long j;
            do {
                j = this.requested.get();
                if ((j & Long.MIN_VALUE) != 0) {
                    return;
                }
            } while (!this.requested.compareAndSet(j, Long.MIN_VALUE | j));
            if (j != 0 || this.producer.get() == null) {
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onNext(this.value);
                }
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onCompleted();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void requestInner(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was ".concat(String.valueOf(j)));
            } else if (j != 0) {
                while (true) {
                    long j2 = this.requested.get();
                    if ((j2 & Long.MIN_VALUE) != 0) {
                        long j3 = Long.MAX_VALUE & j2;
                        if (this.requested.compareAndSet(j2, Long.MIN_VALUE | BackpressureUtils.addCap(j3, j))) {
                            if (j3 == 0) {
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onNext(this.value);
                                }
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onCompleted();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        if (this.requested.compareAndSet(j2, BackpressureUtils.addCap(j2, j))) {
                            AtomicReference<Producer> atomicReference = this.producer;
                            Producer producer2 = atomicReference.get();
                            if (producer2 != null) {
                                producer2.request(j);
                                return;
                            }
                            BackpressureUtils.getAndAddRequest(this.missedRequested, j);
                            Producer producer3 = atomicReference.get();
                            if (producer3 != null) {
                                long andSet = this.missedRequested.getAndSet(0);
                                if (andSet != 0) {
                                    producer3.request(andSet);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
