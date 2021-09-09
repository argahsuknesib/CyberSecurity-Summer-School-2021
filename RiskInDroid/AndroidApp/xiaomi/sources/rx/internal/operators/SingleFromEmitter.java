package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;
import rx.SingleEmitter;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
import rx.plugins.RxJavaHooks;

public final class SingleFromEmitter<T> implements Single.OnSubscribe<T> {
    final Action1<SingleEmitter<T>> producer;

    public SingleFromEmitter(Action1<SingleEmitter<T>> action1) {
        this.producer = action1;
    }

    public final void call(SingleSubscriber<? super T> singleSubscriber) {
        SingleEmitterImpl singleEmitterImpl = new SingleEmitterImpl(singleSubscriber);
        singleSubscriber.add(singleEmitterImpl);
        try {
            this.producer.call(singleEmitterImpl);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleEmitterImpl.onError(th);
        }
    }

    static final class SingleEmitterImpl<T> extends AtomicBoolean implements SingleEmitter<T>, Subscription {
        private static final long serialVersionUID = 8082834163465882809L;
        final SingleSubscriber<? super T> actual;
        final SequentialSubscription resource = new SequentialSubscription();

        SingleEmitterImpl(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
        }

        public final void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.resource.unsubscribe();
            }
        }

        public final boolean isUnsubscribed() {
            return get();
        }

        public final void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onSuccess(t);
                } finally {
                    this.resource.unsubscribe();
                }
            }
        }

        public final void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException();
            }
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onError(th);
                } finally {
                    this.resource.unsubscribe();
                }
            } else {
                RxJavaHooks.onError(th);
            }
        }

        public final void setSubscription(Subscription subscription) {
            this.resource.update(subscription);
        }

        public final void setCancellation(Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }
    }
}
