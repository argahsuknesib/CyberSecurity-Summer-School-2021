package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Publisher<? extends U> other;

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.combiner = biFunction;
        this.other = publisher;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(serializedSubscriber, this.combiner);
        serializedSubscriber.onSubscribe(withLatestFromSubscriber);
        this.other.subscribe(new FlowableWithLatestSubscriber(withLatestFromSubscriber));
        this.source.subscribe((FlowableSubscriber) withLatestFromSubscriber);
    }

    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final Subscriber<? super R> downstream;
        final AtomicReference<Subscription> other = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.downstream = subscriber;
            this.combiner = biFunction;
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        public final void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.get().request(1);
            }
        }

        public final boolean tryOnNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.downstream.onNext(ObjectHelper.requireNonNull(this.combiner.apply(t, obj), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.downstream.onError(th);
                }
            }
            return false;
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(th);
        }

        public final void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onComplete();
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        public final boolean setOther(Subscription subscription) {
            return SubscriptionHelper.setOnce(this.other, subscription);
        }

        public final void otherError(Throwable th) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(th);
        }
    }

    final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {
        private final WithLatestFromSubscriber<T, U, R> wlf;

        public final void onComplete() {
        }

        FlowableWithLatestSubscriber(WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.wlf = withLatestFromSubscriber;
        }

        public final void onSubscribe(Subscription subscription) {
            if (this.wlf.setOther(subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(U u) {
            this.wlf.lazySet(u);
        }

        public final void onError(Throwable th) {
            this.wlf.otherError(th);
        }
    }
}
