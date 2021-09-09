package io.reactivex.internal.subscribers;

public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public final void onNext(T t) {
        this.value = t;
    }

    public final void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }
}
