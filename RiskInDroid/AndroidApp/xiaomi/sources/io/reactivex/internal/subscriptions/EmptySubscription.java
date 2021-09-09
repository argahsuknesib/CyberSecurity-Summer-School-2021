package io.reactivex.internal.subscriptions;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;

public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    public final void cancel() {
    }

    public final void clear() {
    }

    public final boolean isEmpty() {
        return true;
    }

    @Nullable
    public final Object poll() {
        return null;
    }

    public final int requestFusion(int i) {
        return i & 2;
    }

    public final String toString() {
        return "EmptySubscription";
    }

    public final void request(long j) {
        SubscriptionHelper.validate(j);
    }

    public static void error(Throwable th, Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onError(th);
    }

    public static void complete(Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onComplete();
    }

    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
