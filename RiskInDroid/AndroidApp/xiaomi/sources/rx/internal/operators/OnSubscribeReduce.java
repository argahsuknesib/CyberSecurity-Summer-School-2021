package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeReduce<T> implements Observable.OnSubscribe<T> {
    final Func2<T, T, T> reducer;
    final Observable<T> source;

    public OnSubscribeReduce(Observable<T> observable, Func2<T, T, T> func2) {
        this.source = observable;
        this.reducer = func2;
    }

    public final void call(Subscriber<? super T> subscriber) {
        final ReduceSubscriber reduceSubscriber = new ReduceSubscriber(subscriber, this.reducer);
        subscriber.add(reduceSubscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeReduce.AnonymousClass1 */

            public void request(long j) {
                reduceSubscriber.downstreamRequest(j);
            }
        });
        this.source.unsafeSubscribe(reduceSubscriber);
    }

    static final class ReduceSubscriber<T> extends Subscriber<T> {
        static final Object EMPTY = new Object();
        final Subscriber<? super T> actual;
        boolean done;
        final Func2<T, T, T> reducer;
        T value = EMPTY;

        public ReduceSubscriber(Subscriber<? super T> subscriber, Func2<T, T, T> func2) {
            this.actual = subscriber;
            this.reducer = func2;
            request(0);
        }

        public final void onNext(T t) {
            if (!this.done) {
                T t2 = this.value;
                if (t2 == EMPTY) {
                    this.value = t;
                    return;
                }
                try {
                    this.value = this.reducer.call(t2, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    unsubscribe();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.actual.onError(th);
                return;
            }
            RxJavaHooks.onError(th);
        }

        public final void onCompleted() {
            if (!this.done) {
                this.done = true;
                T t = this.value;
                if (t != EMPTY) {
                    this.actual.onNext(t);
                    this.actual.onCompleted();
                    return;
                }
                this.actual.onError(new NoSuchElementException());
            }
        }

        /* access modifiers changed from: package-private */
        public final void downstreamRequest(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was ".concat(String.valueOf(j)));
            } else if (j != 0) {
                request(Long.MAX_VALUE);
            }
        }
    }
}
