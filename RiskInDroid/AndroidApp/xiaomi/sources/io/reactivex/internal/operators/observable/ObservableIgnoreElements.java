package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new IgnoreObservable(observer));
    }

    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        final Observer<? super T> downstream;
        Disposable upstream;

        public final void onNext(T t) {
        }

        IgnoreObservable(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        public final void dispose() {
            this.upstream.dispose();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}
