package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
public final class MaterializeSingleObserver<T> implements CompletableObserver, MaybeObserver<T>, SingleObserver<T>, Disposable {
    final SingleObserver<? super Notification<T>> downstream;
    Disposable upstream;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.downstream = singleObserver;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public final void onComplete() {
        this.downstream.onSuccess(Notification.createOnComplete());
    }

    public final void onSuccess(T t) {
        this.downstream.onSuccess(Notification.createOnNext(t));
    }

    public final void onError(Throwable th) {
        this.downstream.onSuccess(Notification.createOnError(th));
    }

    public final boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public final void dispose() {
        this.upstream.dispose();
    }
}
