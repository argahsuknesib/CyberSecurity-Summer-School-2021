package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class CompletableAndThenPublisher<R> extends Flowable<R> {
    final Publisher<? extends R> other;
    final CompletableSource source;

    public CompletableAndThenPublisher(CompletableSource completableSource, Publisher<? extends R> publisher) {
        this.source = completableSource;
        this.other = publisher;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new AndThenPublisherSubscriber(subscriber, this.other));
    }

    static final class AndThenPublisherSubscriber<R> extends AtomicReference<Subscription> implements CompletableObserver, FlowableSubscriber<R>, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;
        final Subscriber<? super R> downstream;
        Publisher<? extends R> other;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        AndThenPublisherSubscriber(Subscriber<? super R> subscriber, Publisher<? extends R> publisher) {
            this.downstream = subscriber;
            this.other = publisher;
        }

        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            Publisher<? extends R> publisher = this.other;
            if (publisher == null) {
                this.downstream.onComplete();
                return;
            }
            this.other = null;
            publisher.subscribe(this);
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }

        public final void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, subscription);
        }
    }
}
