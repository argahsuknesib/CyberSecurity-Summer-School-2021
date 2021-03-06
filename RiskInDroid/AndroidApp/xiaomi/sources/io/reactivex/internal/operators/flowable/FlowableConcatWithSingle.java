package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final SingleSource<? extends T> other;

    public FlowableConcatWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.other = singleSource;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new ConcatWithSubscriber(subscriber, this.other));
    }

    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        SingleSource<? extends T> other;
        final AtomicReference<Disposable> otherDisposable = new AtomicReference<>();

        ConcatWithSubscriber(Subscriber<? super T> subscriber, SingleSource<? extends T> singleSource) {
            super(subscriber);
            this.other = singleSource;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.otherDisposable, disposable);
        }

        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onSuccess(T t) {
            complete(t);
        }

        public final void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            SingleSource<? extends T> singleSource = this.other;
            this.other = null;
            singleSource.subscribe(this);
        }

        public final void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }
    }
}
