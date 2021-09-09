package io.reactivex.internal.subscriptions;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    private static final long serialVersionUID = -3830916580126663321L;
    final Subscriber<? super T> subscriber;
    final T value;

    public final int requestFusion(int i) {
        return i & 1;
    }

    public ScalarSubscription(Subscriber<? super T> subscriber2, T t) {
        this.subscriber = subscriber2;
        this.value = t;
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber2 = this.subscriber;
            subscriber2.onNext(this.value);
            if (get() != 2) {
                subscriber2.onComplete();
            }
        }
    }

    public final void cancel() {
        lazySet(2);
    }

    public final boolean isCancelled() {
        return get() == 2;
    }

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Nullable
    public final T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    public final boolean isEmpty() {
        return get() != 0;
    }

    public final void clear() {
        lazySet(1);
    }
}
