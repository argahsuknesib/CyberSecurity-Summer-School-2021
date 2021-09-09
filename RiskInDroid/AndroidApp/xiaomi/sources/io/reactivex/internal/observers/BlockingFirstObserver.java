package io.reactivex.internal.observers;

public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public final void onNext(T t) {
        if (this.value == null) {
            this.value = t;
            this.upstream.dispose();
            countDown();
        }
    }

    public final void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }
}
