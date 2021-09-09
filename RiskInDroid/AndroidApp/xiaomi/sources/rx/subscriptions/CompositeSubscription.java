package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription implements Subscription {
    private Set<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public CompositeSubscription() {
    }

    public CompositeSubscription(Subscription... subscriptionArr) {
        this.subscriptions = new HashSet(Arrays.asList(subscriptionArr));
    }

    public final boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    public final void add(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.unsubscribed) {
                synchronized (this) {
                    if (!this.unsubscribed) {
                        if (this.subscriptions == null) {
                            this.subscriptions = new HashSet(4);
                        }
                        this.subscriptions.add(subscription);
                        return;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    public final void addAll(Subscription... subscriptionArr) {
        int i = 0;
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet(subscriptionArr.length);
                    }
                    int length = subscriptionArr.length;
                    while (i < length) {
                        Subscription subscription = subscriptionArr[i];
                        if (!subscription.isUnsubscribed()) {
                            this.subscriptions.add(subscription);
                        }
                        i++;
                    }
                    return;
                }
            }
        }
        int length2 = subscriptionArr.length;
        while (i < length2) {
            subscriptionArr[i].unsubscribe();
            i++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r2.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    public final void remove(Subscription subscription) {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions != null) {
                        boolean remove = this.subscriptions.remove(subscription);
                    }
                }
            }
        }
    }

    public final void clear() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions != null) {
                        Set<Subscription> set = this.subscriptions;
                        this.subscriptions = null;
                        unsubscribeFromAll(set);
                    }
                }
            }
        }
    }

    public final void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    this.unsubscribed = true;
                    Set<Subscription> set = this.subscriptions;
                    this.subscriptions = null;
                    unsubscribeFromAll(set);
                }
            }
        }
    }

    private static void unsubscribeFromAll(Collection<Subscription> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (Subscription unsubscribe : collection) {
                try {
                    unsubscribe.unsubscribe();
                } catch (Throwable th) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    public final boolean hasSubscriptions() {
        boolean z = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && this.subscriptions != null && !this.subscriptions.isEmpty()) {
                z = true;
            }
        }
        return z;
    }
}
