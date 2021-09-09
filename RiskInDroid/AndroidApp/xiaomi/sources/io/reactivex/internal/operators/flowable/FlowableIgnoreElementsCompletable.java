package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {
    final Flowable<T> source;

    public FlowableIgnoreElementsCompletable(Flowable<T> flowable) {
        this.source = flowable;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((FlowableSubscriber) new IgnoreElementsSubscriber(completableObserver));
    }

    public final Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableIgnoreElements(this.source));
    }

    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final CompletableObserver downstream;
        Subscription upstream;

        public final void onNext(T t) {
        }

        IgnoreElementsSubscriber(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onError(Throwable th) {
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onComplete();
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
