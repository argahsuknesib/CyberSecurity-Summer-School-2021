package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {
    final ObservableSource<T> source;

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new IgnoreObservable(completableObserver));
    }

    public final Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this.source));
    }

    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        final CompletableObserver downstream;
        Disposable upstream;

        public final void onNext(T t) {
        }

        IgnoreObservable(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
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
