package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;
import rx.subjects.PublishSubject;

public final class OperatorDelayWithSelector<T, V> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends Observable<V>> itemDelay;
    final Observable<? extends T> source;

    public OperatorDelayWithSelector(Observable<? extends T> observable, Func1<? super T, ? extends Observable<V>> func1) {
        this.source = observable;
        this.itemDelay = func1;
    }

    public final Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final PublishSubject create = PublishSubject.create();
        subscriber.add(Observable.merge(create).unsafeSubscribe(Subscribers.from(serializedSubscriber)));
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorDelayWithSelector.AnonymousClass1 */

            public void onCompleted() {
                create.onCompleted();
            }

            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
            }

            public void onNext(final T t) {
                try {
                    create.onNext(((Observable) OperatorDelayWithSelector.this.itemDelay.call(t)).take(1).defaultIfEmpty(null).map(new Func1<V, T>() {
                        /* class rx.internal.operators.OperatorDelayWithSelector.AnonymousClass1.AnonymousClass1 */

                        public T call(V v) {
                            return t;
                        }
                    }));
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }
        };
    }
}
