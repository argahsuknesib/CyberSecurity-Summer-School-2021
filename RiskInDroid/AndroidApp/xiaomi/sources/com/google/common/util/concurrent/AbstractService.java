package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@Beta
public abstract class AbstractService implements Service {
    private static final ListenerCallQueue.Event<Service.Listener> RUNNING_EVENT = new ListenerCallQueue.Event<Service.Listener>() {
        /* class com.google.common.util.concurrent.AbstractService.AnonymousClass2 */

        public final String toString() {
            return "running()";
        }

        public final void call(Service.Listener listener) {
            listener.running();
        }
    };
    private static final ListenerCallQueue.Event<Service.Listener> STARTING_EVENT = new ListenerCallQueue.Event<Service.Listener>() {
        /* class com.google.common.util.concurrent.AbstractService.AnonymousClass1 */

        public final String toString() {
            return "starting()";
        }

        public final void call(Service.Listener listener) {
            listener.starting();
        }
    };
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_RUNNING_EVENT = stoppingEvent(Service.State.RUNNING);
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_STARTING_EVENT = stoppingEvent(Service.State.STARTING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_NEW_EVENT = terminatedEvent(Service.State.NEW);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_RUNNING_EVENT = terminatedEvent(Service.State.RUNNING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STARTING_EVENT = terminatedEvent(Service.State.STARTING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STOPPING_EVENT = terminatedEvent(Service.State.STOPPING);
    private final Monitor.Guard hasReachedRunning = new HasReachedRunningGuard();
    private final Monitor.Guard isStartable = new IsStartableGuard();
    private final Monitor.Guard isStoppable = new IsStoppableGuard();
    private final Monitor.Guard isStopped = new IsStoppedGuard();
    private final ListenerCallQueue<Service.Listener> listeners = new ListenerCallQueue<>();
    public final Monitor monitor = new Monitor();
    private volatile StateSnapshot snapshot = new StateSnapshot(Service.State.NEW);

    /* access modifiers changed from: protected */
    @ForOverride
    public void doCancelStart() {
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract void doStart();

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract void doStop();

    private static ListenerCallQueue.Event<Service.Listener> terminatedEvent(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() {
            /* class com.google.common.util.concurrent.AbstractService.AnonymousClass3 */

            public final void call(Service.Listener listener) {
                listener.terminated(state);
            }

            public final String toString() {
                return "terminated({from = " + state + "})";
            }
        };
    }

    private static ListenerCallQueue.Event<Service.Listener> stoppingEvent(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() {
            /* class com.google.common.util.concurrent.AbstractService.AnonymousClass4 */

            public final void call(Service.Listener listener) {
                listener.stopping(state);
            }

            public final String toString() {
                return "stopping({from = " + state + "})";
            }
        };
    }

    final class IsStartableGuard extends Monitor.Guard {
        IsStartableGuard() {
            super(AbstractService.this.monitor);
        }

        public final boolean isSatisfied() {
            return AbstractService.this.state() == Service.State.NEW;
        }
    }

    final class IsStoppableGuard extends Monitor.Guard {
        IsStoppableGuard() {
            super(AbstractService.this.monitor);
        }

        public final boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    final class HasReachedRunningGuard extends Monitor.Guard {
        HasReachedRunningGuard() {
            super(AbstractService.this.monitor);
        }

        public final boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    final class IsStoppedGuard extends Monitor.Guard {
        IsStoppedGuard() {
            super(AbstractService.this.monitor);
        }

        public final boolean isSatisfied() {
            return AbstractService.this.state().isTerminal();
        }
    }

    protected AbstractService() {
    }

    @CanIgnoreReturnValue
    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable)) {
            try {
                this.snapshot = new StateSnapshot(Service.State.STARTING);
                enqueueStartingEvent();
                doStart();
            } catch (Throwable th) {
                this.monitor.leave();
                dispatchListenerEvents();
                throw th;
            }
            this.monitor.leave();
            dispatchListenerEvents();
            return this;
        }
        throw new IllegalStateException("Service " + this + " has already been started");
    }

    @CanIgnoreReturnValue
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable)) {
            try {
                Service.State state = state();
                switch (state) {
                    case NEW:
                        this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                        enqueueTerminatedEvent(Service.State.NEW);
                        break;
                    case STARTING:
                        this.snapshot = new StateSnapshot(Service.State.STARTING, true, null);
                        enqueueStoppingEvent(Service.State.STARTING);
                        doCancelStart();
                        break;
                    case RUNNING:
                        this.snapshot = new StateSnapshot(Service.State.STOPPING);
                        enqueueStoppingEvent(Service.State.RUNNING);
                        doStop();
                        break;
                    case STOPPING:
                    case TERMINATED:
                    case FAILED:
                        throw new AssertionError("isStoppable is incorrectly implemented, saw: ".concat(String.valueOf(state)));
                }
            } catch (Throwable th) {
                this.monitor.leave();
                dispatchListenerEvents();
                throw th;
            }
            this.monitor.leave();
            dispatchListenerEvents();
        }
        return this;
    }

    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        try {
            checkCurrentState(Service.State.RUNNING);
        } finally {
            this.monitor.leave();
        }
    }

    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, j, timeUnit)) {
            try {
                checkCurrentState(Service.State.RUNNING);
            } finally {
                this.monitor.leave();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
        }
    }

    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        try {
            checkCurrentState(Service.State.TERMINATED);
        } finally {
            this.monitor.leave();
        }
    }

    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, j, timeUnit)) {
            try {
                checkCurrentState(Service.State.TERMINATED);
            } finally {
                this.monitor.leave();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + state());
        }
    }

    @GuardedBy("monitor")
    private void checkCurrentState(Service.State state) {
        Service.State state2 = state();
        if (state2 == state) {
            return;
        }
        if (state2 == Service.State.FAILED) {
            throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but the service has FAILED", failureCause());
        }
        throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but was " + state2);
    }

    /* access modifiers changed from: protected */
    public final void notifyStarted() {
        this.monitor.enter();
        try {
            if (this.snapshot.state == Service.State.STARTING) {
                if (this.snapshot.shutdownWhenStartupFinishes) {
                    this.snapshot = new StateSnapshot(Service.State.STOPPING);
                    doStop();
                } else {
                    this.snapshot = new StateSnapshot(Service.State.RUNNING);
                    enqueueRunningEvent();
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.snapshot.state);
            notifyFailed(illegalStateException);
            throw illegalStateException;
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyStopped() {
        this.monitor.enter();
        try {
            Service.State state = state();
            switch (state) {
                case NEW:
                case TERMINATED:
                case FAILED:
                    throw new IllegalStateException("Cannot notifyStopped() when the service is ".concat(String.valueOf(state)));
                case STARTING:
                case RUNNING:
                case STOPPING:
                    this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                    enqueueTerminatedEvent(state);
                    break;
            }
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyFailed(Throwable th) {
        Preconditions.checkNotNull(th);
        this.monitor.enter();
        try {
            Service.State state = state();
            int i = AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()];
            if (i != 1) {
                if (i == 2 || i == 3 || i == 4) {
                    this.snapshot = new StateSnapshot(Service.State.FAILED, false, th);
                    enqueueFailedEvent(state, th);
                } else if (i != 5) {
                }
                return;
            }
            throw new IllegalStateException("Failed while in state:".concat(String.valueOf(state)), th);
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    public final boolean isRunning() {
        return state() == Service.State.RUNNING;
    }

    public final Service.State state() {
        return this.snapshot.externalState();
    }

    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    public final void addListener(Service.Listener listener, Executor executor) {
        this.listeners.addListener(listener, executor);
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }

    private void dispatchListenerEvents() {
        if (!this.monitor.isOccupiedByCurrentThread()) {
            this.listeners.dispatch();
        }
    }

    private void enqueueStartingEvent() {
        this.listeners.enqueue(STARTING_EVENT);
    }

    private void enqueueRunningEvent() {
        this.listeners.enqueue(RUNNING_EVENT);
    }

    private void enqueueStoppingEvent(Service.State state) {
        if (state == Service.State.STARTING) {
            this.listeners.enqueue(STOPPING_FROM_STARTING_EVENT);
        } else if (state == Service.State.RUNNING) {
            this.listeners.enqueue(STOPPING_FROM_RUNNING_EVENT);
        } else {
            throw new AssertionError();
        }
    }

    private void enqueueTerminatedEvent(Service.State state) {
        switch (state) {
            case NEW:
                this.listeners.enqueue(TERMINATED_FROM_NEW_EVENT);
                return;
            case STARTING:
                this.listeners.enqueue(TERMINATED_FROM_STARTING_EVENT);
                return;
            case RUNNING:
                this.listeners.enqueue(TERMINATED_FROM_RUNNING_EVENT);
                return;
            case STOPPING:
                this.listeners.enqueue(TERMINATED_FROM_STOPPING_EVENT);
                return;
            case TERMINATED:
            case FAILED:
                throw new AssertionError();
            default:
                return;
        }
    }

    private void enqueueFailedEvent(final Service.State state, final Throwable th) {
        this.listeners.enqueue(new ListenerCallQueue.Event<Service.Listener>() {
            /* class com.google.common.util.concurrent.AbstractService.AnonymousClass5 */

            public void call(Service.Listener listener) {
                listener.failed(state, th);
            }

            public String toString() {
                return "failed({from = " + state + ", cause = " + th + "})";
            }
        });
    }

    static final class StateSnapshot {
        final Throwable failure;
        final boolean shutdownWhenStartupFinishes;
        final Service.State state;

        StateSnapshot(Service.State state2) {
            this(state2, false, null);
        }

        StateSnapshot(Service.State state2, boolean z, Throwable th) {
            boolean z2 = false;
            Preconditions.checkArgument(!z || state2 == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state2);
            Preconditions.checkArgument(!((th != null) ^ (state2 == Service.State.FAILED)) ? true : z2, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state2, th);
            this.state = state2;
            this.shutdownWhenStartupFinishes = z;
            this.failure = th;
        }

        /* access modifiers changed from: package-private */
        public final Service.State externalState() {
            if (!this.shutdownWhenStartupFinishes || this.state != Service.State.STARTING) {
                return this.state;
            }
            return Service.State.STOPPING;
        }

        /* access modifiers changed from: package-private */
        public final Throwable failureCause() {
            Preconditions.checkState(this.state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", this.state);
            return this.failure;
        }
    }
}
