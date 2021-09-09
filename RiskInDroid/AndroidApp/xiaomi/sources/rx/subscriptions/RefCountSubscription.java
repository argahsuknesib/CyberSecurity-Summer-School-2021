package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class RefCountSubscription implements Subscription {
    static final State EMPTY_STATE = new State(false, 0);
    private final Subscription actual;
    final AtomicReference<State> state = new AtomicReference<>(EMPTY_STATE);

    static final class State {
        final int children;
        final boolean isUnsubscribed;

        State(boolean z, int i) {
            this.isUnsubscribed = z;
            this.children = i;
        }

        /* access modifiers changed from: package-private */
        public final State addChild() {
            return new State(this.isUnsubscribed, this.children + 1);
        }

        /* access modifiers changed from: package-private */
        public final State removeChild() {
            return new State(this.isUnsubscribed, this.children - 1);
        }

        /* access modifiers changed from: package-private */
        public final State unsubscribe() {
            return new State(true, this.children);
        }
    }

    public RefCountSubscription(Subscription subscription) {
        if (subscription != null) {
            this.actual = subscription;
            return;
        }
        throw new IllegalArgumentException("s");
    }

    public final Subscription get() {
        State state2;
        AtomicReference<State> atomicReference = this.state;
        do {
            state2 = atomicReference.get();
            if (state2.isUnsubscribed) {
                return Subscriptions.unsubscribed();
            }
        } while (!atomicReference.compareAndSet(state2, state2.addChild()));
        return new InnerSubscription(this);
    }

    public final boolean isUnsubscribed() {
        return this.state.get().isUnsubscribed;
    }

    public final void unsubscribe() {
        State state2;
        State unsubscribe;
        AtomicReference<State> atomicReference = this.state;
        do {
            state2 = atomicReference.get();
            if (!state2.isUnsubscribed) {
                unsubscribe = state2.unsubscribe();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(state2, unsubscribe));
        unsubscribeActualIfApplicable(unsubscribe);
    }

    private void unsubscribeActualIfApplicable(State state2) {
        if (state2.isUnsubscribed && state2.children == 0) {
            this.actual.unsubscribe();
        }
    }

    /* access modifiers changed from: package-private */
    public final void unsubscribeAChild() {
        State state2;
        State removeChild;
        AtomicReference<State> atomicReference = this.state;
        do {
            state2 = atomicReference.get();
            removeChild = state2.removeChild();
        } while (!atomicReference.compareAndSet(state2, removeChild));
        unsubscribeActualIfApplicable(removeChild);
    }

    static final class InnerSubscription extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        public final void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.unsubscribeAChild();
            }
        }

        public final boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
