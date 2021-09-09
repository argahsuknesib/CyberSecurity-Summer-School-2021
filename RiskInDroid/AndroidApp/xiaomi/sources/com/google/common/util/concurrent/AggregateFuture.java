package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible
abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    public static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
    public AggregateFuture<InputT, OutputT>.RunningState runningState;

    AggregateFuture() {
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        super.afterDone();
        AggregateFuture<InputT, OutputT>.RunningState runningState2 = this.runningState;
        if (runningState2 != null) {
            this.runningState = null;
            ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = runningState2.futures;
            boolean wasInterrupted = wasInterrupted();
            if (wasInterrupted) {
                runningState2.interruptTask();
            }
            if (isCancelled() && (immutableCollection != null)) {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = immutableCollection.iterator();
                while (it.hasNext()) {
                    ((ListenableFuture) it.next()).cancel(wasInterrupted);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection;
        AggregateFuture<InputT, OutputT>.RunningState runningState2 = this.runningState;
        if (runningState2 == null || (immutableCollection = runningState2.futures) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + "]";
    }

    /* access modifiers changed from: package-private */
    public final void init(AggregateFuture<InputT, OutputT>.RunningState runningState2) {
        this.runningState = runningState2;
        runningState2.init();
    }

    abstract class RunningState extends AggregateFutureState implements Runnable {
        private final boolean allMustSucceed;
        private final boolean collectsValues;
        public ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

        /* access modifiers changed from: package-private */
        public abstract void collectOneValue(boolean z, int i, InputT inputt);

        /* access modifiers changed from: package-private */
        public abstract void handleAllCompleted();

        /* access modifiers changed from: package-private */
        public void interruptTask() {
        }

        RunningState(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
            super(immutableCollection.size());
            this.futures = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
            this.allMustSucceed = z;
            this.collectsValues = z2;
        }

        public final void run() {
            decrementCountAndMaybeComplete();
        }

        public void init() {
            if (this.futures.isEmpty()) {
                handleAllCompleted();
            } else if (this.allMustSucceed) {
                final int i = 0;
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                while (it.hasNext()) {
                    final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                    listenableFuture.addListener(new Runnable() {
                        /* class com.google.common.util.concurrent.AggregateFuture.RunningState.AnonymousClass1 */

                        public void run() {
                            try {
                                RunningState.this.handleOneInputDone(i, listenableFuture);
                            } finally {
                                RunningState.this.decrementCountAndMaybeComplete();
                            }
                        }
                    }, MoreExecutors.directExecutor());
                    i++;
                }
            } else {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
                while (it2.hasNext()) {
                    ((ListenableFuture) it2.next()).addListener(this, MoreExecutors.directExecutor());
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        private void handleException(Throwable th) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Preconditions.checkNotNull(th);
            boolean z5 = true;
            if (this.allMustSucceed) {
                z2 = AggregateFuture.this.setException(th);
                if (z2) {
                    releaseResourcesAfterFailure();
                } else {
                    z = AggregateFuture.addCausalChain(getOrInitSeenExceptions(), th);
                    z3 = th instanceof Error;
                    z4 = this.allMustSucceed;
                    if (z2) {
                        z5 = false;
                    }
                    if (!(z4 & z5 & z) && !z3) {
                        AggregateFuture.logger.log(Level.SEVERE, z3 ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
                        return;
                    }
                    return;
                }
            } else {
                z2 = false;
            }
            z = true;
            z3 = th instanceof Error;
            z4 = this.allMustSucceed;
            if (z2) {
            }
            if (!(z4 & z5 & z) && !z3) {
            }
        }

        /* access modifiers changed from: package-private */
        public final void addInitialException(Set<Throwable> set) {
            if (!AggregateFuture.this.isCancelled()) {
                AggregateFuture.addCausalChain(set, AggregateFuture.this.tryInternalFastPathGetFailure());
            }
        }

        public void handleOneInputDone(int i, Future<? extends InputT> future) {
            Preconditions.checkState(this.allMustSucceed || !AggregateFuture.this.isDone() || AggregateFuture.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (this.allMustSucceed) {
                    if (future.isCancelled()) {
                        AggregateFuture.this.runningState = null;
                        AggregateFuture.this.cancel(false);
                        return;
                    }
                    Object done = Futures.getDone(future);
                    if (this.collectsValues) {
                        collectOneValue(this.allMustSucceed, i, done);
                    }
                } else if (this.collectsValues && !future.isCancelled()) {
                    collectOneValue(this.allMustSucceed, i, Futures.getDone(future));
                }
            } catch (ExecutionException e) {
                handleException(e.getCause());
            } catch (Throwable th) {
                handleException(th);
            }
        }

        public void decrementCountAndMaybeComplete() {
            int decrementRemainingAndGet = decrementRemainingAndGet();
            Preconditions.checkState(decrementRemainingAndGet >= 0, "Less than 0 remaining futures");
            if (decrementRemainingAndGet == 0) {
                processCompleted();
            }
        }

        private void processCompleted() {
            if (this.collectsValues && (!this.allMustSucceed)) {
                int i = 0;
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                while (it.hasNext()) {
                    handleOneInputDone(i, (ListenableFuture) it.next());
                    i++;
                }
            }
            handleAllCompleted();
        }

        /* access modifiers changed from: package-private */
        @ForOverride
        @OverridingMethodsMustInvokeSuper
        public void releaseResourcesAfterFailure() {
            this.futures = null;
        }
    }

    public static boolean addCausalChain(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
