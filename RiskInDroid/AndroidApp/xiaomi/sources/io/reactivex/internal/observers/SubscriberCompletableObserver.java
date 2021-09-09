package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {
    final Subscriber<? super T> subscriber;
    Disposable upstream;

    public final void request(long j) {
    }

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber2) {
        this.subscriber = subscriber2;
    }

    public final void onComplete() {
        this.subscriber.onComplete();
    }

    public final void onError(Throwable th) {
        this.subscriber.onError(th);
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.subscriber.onSubscribe(this);
        }
    }

    public final void cancel() {
        this.upstream.dispose();
    }
}
