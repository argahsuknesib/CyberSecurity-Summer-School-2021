package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastSingle<T> extends Single<T> {
    final T defaultItem;
    final Publisher<T> source;

    public FlowableLastSingle(Publisher<T> publisher, T t) {
        this.source = publisher;
        this.defaultItem = t;
    }

    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new LastSubscriber(singleObserver, this.defaultItem));
    }

    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final T defaultItem;
        final SingleObserver<? super T> downstream;
        T item;
        Subscription upstream;

        LastSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.downstream = singleObserver;
            this.defaultItem = t;
        }

        public final void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        public final boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.item = t;
        }

        public final void onError(Throwable th) {
            this.upstream = SubscriptionHelper.CANCELLED;
            this.item = null;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            T t = this.item;
            if (t != null) {
                this.item = null;
                this.downstream.onSuccess(t);
                return;
            }
            T t2 = this.defaultItem;
            if (t2 != null) {
                this.downstream.onSuccess(t2);
            } else {
                this.downstream.onError(new NoSuchElementException());
            }
        }
    }
}
