package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.upstream, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public final void onNext(T t) {
        this.downstream.onNext(t);
    }

    public final void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    public final void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    public final boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    public final void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
