package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableHide<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableHide(Flowable<T> flowable) {
        super(flowable);
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new HideSubscriber(subscriber));
    }

    static final class HideSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> downstream;
        Subscription upstream;

        HideSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        public final void request(long j) {
            this.upstream.request(j);
        }

        public final void cancel() {
            this.upstream.cancel();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }
    }
}
