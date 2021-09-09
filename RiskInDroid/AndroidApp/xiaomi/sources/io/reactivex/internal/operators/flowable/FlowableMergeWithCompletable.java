package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource other;

    public FlowableMergeWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.other = completableSource;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.onSubscribe(mergeWithSubscriber);
        this.source.subscribe((FlowableSubscriber) mergeWithSubscriber);
        this.other.subscribe(mergeWithSubscriber.otherObserver);
    }

    static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        final Subscriber<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        volatile boolean mainDone;
        final AtomicReference<Subscription> mainSubscription = new AtomicReference<>();
        volatile boolean otherDone;
        final OtherObserver otherObserver = new OtherObserver(this);
        final AtomicLong requested = new AtomicLong();

        MergeWithSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, subscription);
        }

        public final void onNext(T t) {
            HalfSerializer.onNext(this.downstream, t, this, this.error);
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.cancel(this.mainSubscription);
            HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        public final void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, j);
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
        }

        /* access modifiers changed from: package-private */
        public final void otherError(Throwable th) {
            SubscriptionHelper.cancel(this.mainSubscription);
            HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithSubscriber<?> parent;

            OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.parent = mergeWithSubscriber;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onError(Throwable th) {
                this.parent.otherError(th);
            }

            public final void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
