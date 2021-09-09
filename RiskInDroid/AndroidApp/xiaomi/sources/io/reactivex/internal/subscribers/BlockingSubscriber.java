package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue2) {
        this.queue = queue2;
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
    }

    public final void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    public final void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    public final void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    public final void request(long j) {
        ((Subscription) get()).request(j);
    }

    public final void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public final boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }
}
