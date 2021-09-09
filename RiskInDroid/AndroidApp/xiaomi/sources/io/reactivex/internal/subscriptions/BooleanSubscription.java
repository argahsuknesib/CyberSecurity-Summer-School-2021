package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;

public final class BooleanSubscription extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = -8127758972444290902L;

    public final void request(long j) {
        SubscriptionHelper.validate(j);
    }

    public final void cancel() {
        lazySet(true);
    }

    public final boolean isCancelled() {
        return get();
    }

    public final String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
