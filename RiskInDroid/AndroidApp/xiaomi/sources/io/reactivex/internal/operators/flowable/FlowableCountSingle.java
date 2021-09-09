package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {
    final Flowable<T> source;

    public FlowableCountSingle(Flowable<T> flowable) {
        this.source = flowable;
    }

    public final void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe((FlowableSubscriber) new CountSubscriber(singleObserver));
    }

    public final Flowable<Long> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCount(this.source));
    }

    static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {
        long count;
        final SingleObserver<? super Long> downstream;
        Subscription upstream;

        CountSubscriber(SingleObserver<? super Long> singleObserver) {
            this.downstream = singleObserver;
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
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onSuccess(Long.valueOf(this.count));
        }

        public final void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        public final boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }
    }
}
