package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Cancellable;
import rx.plugins.RxJavaHooks;

public final class CancellableSubscription extends AtomicReference<Cancellable> implements Subscription {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(Cancellable cancellable) {
        super(cancellable);
    }

    public final boolean isUnsubscribed() {
        return get() == null;
    }

    public final void unsubscribe() {
        Cancellable cancellable;
        if (get() != null && (cancellable = (Cancellable) getAndSet(null)) != null) {
            try {
                cancellable.cancel();
            } catch (Exception e) {
                Exceptions.throwIfFatal(e);
                RxJavaHooks.onError(e);
            }
        }
    }
}
