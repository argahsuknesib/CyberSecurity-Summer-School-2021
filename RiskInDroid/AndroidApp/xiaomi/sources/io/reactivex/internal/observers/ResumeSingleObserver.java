package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ResumeSingleObserver<T> implements SingleObserver<T> {
    final SingleObserver<? super T> downstream;
    final AtomicReference<Disposable> parent;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.parent = atomicReference;
        this.downstream = singleObserver;
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.parent, disposable);
    }

    public final void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }

    public final void onError(Throwable th) {
        this.downstream.onError(th);
    }
}
