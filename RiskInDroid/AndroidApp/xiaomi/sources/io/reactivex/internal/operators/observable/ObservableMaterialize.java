package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {
    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public final void subscribeActual(Observer<? super Notification<T>> observer) {
        this.source.subscribe(new MaterializeObserver(observer));
    }

    static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Notification<T>> downstream;
        Disposable upstream;

        MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.downstream = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.upstream.dispose();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final void onNext(T t) {
            this.downstream.onNext(Notification.createOnNext(t));
        }

        public final void onError(Throwable th) {
            this.downstream.onNext(Notification.createOnError(th));
            this.downstream.onComplete();
        }

        public final void onComplete() {
            this.downstream.onNext(Notification.createOnComplete());
            this.downstream.onComplete();
        }
    }
}
