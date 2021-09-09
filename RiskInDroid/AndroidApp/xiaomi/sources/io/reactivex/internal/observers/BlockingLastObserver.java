package io.reactivex.internal.observers;

public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public final void onNext(T t) {
        this.value = t;
    }

    public final void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }
}
