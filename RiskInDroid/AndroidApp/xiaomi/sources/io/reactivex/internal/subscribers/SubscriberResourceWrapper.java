package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;
    final Subscriber<? super T> downstream;
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            this.downstream.onSubscribe(this);
        }
    }

    public final void onNext(T t) {
        this.downstream.onNext(t);
    }

    public final void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th);
    }

    public final void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.upstream.get().request(j);
        }
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    public final boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    public final void cancel() {
        dispose();
    }

    public final void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
