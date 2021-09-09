package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {
    public FlowableMaterialize(Flowable<T> flowable) {
        super(flowable);
    }

    public final void subscribeActual(Subscriber<? super Notification<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new MaterializeSubscriber(subscriber));
    }

    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        MaterializeSubscriber(Subscriber<? super Notification<T>> subscriber) {
            super(subscriber);
        }

        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(Notification.createOnNext(t));
        }

        public final void onError(Throwable th) {
            complete(Notification.createOnError(th));
        }

        public final void onComplete() {
            complete(Notification.createOnComplete());
        }

        /* access modifiers changed from: protected */
        public final void onDrop(Notification<T> notification) {
            if (notification.isOnError()) {
                RxJavaPlugins.onError(notification.getError());
            }
        }
    }
}