package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> single;

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.single = singleSource;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.single.subscribe(new CompletableFromSingleObserver(completableObserver));
    }

    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        final CompletableObserver co;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.co = completableObserver;
        }

        public final void onError(Throwable th) {
            this.co.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.co.onSubscribe(disposable);
        }

        public final void onSuccess(T t) {
            this.co.onComplete();
        }
    }
}
