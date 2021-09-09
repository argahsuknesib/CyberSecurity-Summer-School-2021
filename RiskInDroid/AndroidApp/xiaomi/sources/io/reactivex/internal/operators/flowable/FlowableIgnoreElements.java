package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableIgnoreElements(Flowable<T> flowable) {
        super(flowable);
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new IgnoreElementsSubscriber(subscriber));
    }

    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, QueueSubscription<T> {
        final Subscriber<? super T> downstream;
        Subscription upstream;

        public final void clear() {
        }

        public final boolean isEmpty() {
            return true;
        }

        public final void onNext(T t) {
        }

        @Nullable
        public final T poll() {
            return null;
        }

        public final void request(long j) {
        }

        public final int requestFusion(int i) {
            return i & 2;
        }

        IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        public final boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public final boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public final void cancel() {
            this.upstream.cancel();
        }
    }
}
