package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastOne<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableTakeLastOne(Flowable<T> flowable) {
        super(flowable);
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new TakeLastOneSubscriber(subscriber));
    }

    static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5467847744262967226L;
        Subscription upstream;

        TakeLastOneSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.value = t;
        }

        public final void onError(Throwable th) {
            this.value = null;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            Object obj = this.value;
            if (obj != null) {
                complete(obj);
            } else {
                this.downstream.onComplete();
            }
        }

        public final void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}
