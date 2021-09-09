package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> other;

    public FlowableSwitchIfEmpty(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.other = publisher;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(subscriber, this.other);
        subscriber.onSubscribe(switchIfEmptySubscriber.arbiter);
        this.source.subscribe((FlowableSubscriber) switchIfEmptySubscriber);
    }

    static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {
        final SubscriptionArbiter arbiter = new SubscriptionArbiter(false);
        final Subscriber<? super T> downstream;
        boolean empty = true;
        final Publisher<? extends T> other;

        SwitchIfEmptySubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.downstream = subscriber;
            this.other = publisher;
        }

        public final void onSubscribe(Subscription subscription) {
            this.arbiter.setSubscription(subscription);
        }

        public final void onNext(T t) {
            if (this.empty) {
                this.empty = false;
            }
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (this.empty) {
                this.empty = false;
                this.other.subscribe(this);
                return;
            }
            this.downstream.onComplete();
        }
    }
}
