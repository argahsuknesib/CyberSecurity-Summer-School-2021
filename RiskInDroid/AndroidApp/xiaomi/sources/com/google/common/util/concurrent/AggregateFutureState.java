package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
abstract class AggregateFutureState {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
    public volatile int remaining;
    public volatile Set<Throwable> seenExceptions = null;

    /* access modifiers changed from: package-private */
    public abstract void addInitialException(Set<Throwable> set);

    static {
        AtomicHelper atomicHelper;
        Throwable th = null;
        try {
            atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
        } catch (Throwable th2) {
            th = th2;
            atomicHelper = new SynchronizedAtomicHelper();
        }
        ATOMIC_HELPER = atomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    AggregateFutureState(int i) {
        this.remaining = i;
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newConcurrentHashSet = Sets.newConcurrentHashSet();
        addInitialException(newConcurrentHashSet);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, newConcurrentHashSet);
        return this.seenExceptions;
    }

    /* access modifiers changed from: package-private */
    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    static abstract class AtomicHelper {
        /* access modifiers changed from: package-private */
        public abstract void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        public abstract int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState);

        private AtomicHelper() {
        }
    }

    static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicIntegerFieldUpdater<AggregateFutureState> remainingCountUpdater;
        final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> seenExceptionsUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        public final void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            this.seenExceptionsUpdater.compareAndSet(aggregateFutureState, set, set2);
        }

        /* access modifiers changed from: package-private */
        public final int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (aggregateFutureState.seenExceptions == set) {
                    aggregateFutureState.seenExceptions = set2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            int i;
            synchronized (aggregateFutureState) {
                aggregateFutureState.remaining--;
                i = aggregateFutureState.remaining;
            }
            return i;
        }
    }
}
