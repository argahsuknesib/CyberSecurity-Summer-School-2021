package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class SingleHide<T> extends Single<T> {
    final SingleSource<? extends T> source;

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new HideSingleObserver(singleObserver));
    }

    static final class HideSingleObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> downstream;
        Disposable upstream;

        HideSingleObserver(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public final void dispose() {
            this.upstream.dispose();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }
    }
}
