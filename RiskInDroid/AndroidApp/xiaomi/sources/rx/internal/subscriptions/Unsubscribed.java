package rx.internal.subscriptions;

import rx.Subscription;

public enum Unsubscribed implements Subscription {
    INSTANCE;

    public final boolean isUnsubscribed() {
        return true;
    }

    public final void unsubscribe() {
    }
}
