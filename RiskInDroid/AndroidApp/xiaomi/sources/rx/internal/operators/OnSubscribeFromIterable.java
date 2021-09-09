package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends T> is;

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.is = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    public final void call(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends T> it = this.is.iterator();
            boolean hasNext = it.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                subscriber.onCompleted();
            } else {
                subscriber.setProducer(new IterableProducer(subscriber, it));
            }
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
        }
    }

    static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final Subscriber<? super T> o;

        IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it2) {
            this.o = subscriber;
            this.it = it2;
        }

        public final void request(long j) {
            if (get() != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    fastPath();
                } else if (j > 0 && BackpressureUtils.getAndAddRequest(this, j) == 0) {
                    slowPath(j);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void slowPath(long j) {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it2 = this.it;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = BackpressureUtils.produced(this, j3);
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        try {
                            subscriber.onNext(it2.next());
                            if (!subscriber.isUnsubscribed()) {
                                try {
                                    if (it2.hasNext()) {
                                        j3++;
                                    } else if (!subscriber.isUnsubscribed()) {
                                        subscriber.onCompleted();
                                        return;
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwOrReport(th, subscriber);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }

        /* access modifiers changed from: package-private */
        public final void fastPath() {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it2 = this.it;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext(it2.next());
                    if (!subscriber.isUnsubscribed()) {
                        try {
                            if (!it2.hasNext()) {
                                if (!subscriber.isUnsubscribed()) {
                                    subscriber.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, subscriber);
                    return;
                }
            }
        }
    }
}
