package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCount<T> extends AbstractFlowableWithUpstream<T, Long> {
    public FlowableCount(Flowable<T> flowable) {
        super(flowable);
    }

    public final void subscribeActual(Subscriber<? super Long> subscriber) {
        this.source.subscribe((FlowableSubscriber) new CountSubscriber(subscriber));
    }

    static final class CountSubscriber extends DeferredScalarSubscription<Long> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        long count;
        Subscription upstream;

        CountSubscriber(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            this.count++;
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            complete(Long.valueOf(this.count));
        }

        public final void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}
