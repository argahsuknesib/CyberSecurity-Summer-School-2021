package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum EmptyComponent implements CompletableObserver, FlowableSubscriber<Object>, MaybeObserver<Object>, Observer<Object>, SingleObserver<Object>, Disposable, Subscription {
    INSTANCE;

    public final void cancel() {
    }

    public final void dispose() {
    }

    public final boolean isDisposed() {
        return true;
    }

    public final void onComplete() {
    }

    public final void onNext(Object obj) {
    }

    public final void onSuccess(Object obj) {
    }

    public final void request(long j) {
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public final void onSubscribe(Disposable disposable) {
        disposable.dispose();
    }

    public final void onSubscribe(Subscription subscription) {
        subscription.cancel();
    }

    public final void onError(Throwable th) {
        RxJavaPlugins.onError(th);
    }
}
