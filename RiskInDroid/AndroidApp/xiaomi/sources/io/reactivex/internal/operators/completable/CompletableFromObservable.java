package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> observable;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.observable = observableSource;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.observable.subscribe(new CompletableFromObservableObserver(completableObserver));
    }

    static final class CompletableFromObservableObserver<T> implements Observer<T> {
        final CompletableObserver co;

        public final void onNext(T t) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.co = completableObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.co.onSubscribe(disposable);
        }

        public final void onError(Throwable th) {
            this.co.onError(th);
        }

        public final void onComplete() {
            this.co.onComplete();
        }
    }
}
