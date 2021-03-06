package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class AsyncSubscription extends AtomicLong implements Disposable, Subscription {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<Subscription> actual;
    final AtomicReference<Disposable> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    public AsyncSubscription(Disposable disposable) {
        this();
        this.resource.lazySet(disposable);
    }

    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.actual, this, j);
    }

    public final void cancel() {
        dispose();
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    public final boolean isDisposed() {
        return this.actual.get() == SubscriptionHelper.CANCELLED;
    }

    public final boolean setResource(Disposable disposable) {
        return DisposableHelper.set(this.resource, disposable);
    }

    public final boolean replaceResource(Disposable disposable) {
        return DisposableHelper.replace(this.resource, disposable);
    }

    public final void setSubscription(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, subscription);
    }
}
