package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

@Beta
public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Object>> ref = new AtomicReference<>(Futures.immediateFuture(null));

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    public final <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        return submitAsync(new AsyncCallable<T>() {
            /* class com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass1 */

            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public final <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> asyncCallable, final Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        final AtomicReference atomicReference = new AtomicReference(RunningState.NOT_RUN);
        AnonymousClass2 r0 = new AsyncCallable<T>() {
            /* class com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass2 */

            public ListenableFuture<T> call() throws Exception {
                if (!atomicReference.compareAndSet(RunningState.NOT_RUN, RunningState.STARTED)) {
                    return Futures.immediateCancelledFuture();
                }
                return asyncCallable.call();
            }

            public String toString() {
                return asyncCallable.toString();
            }
        };
        final SettableFuture create = SettableFuture.create();
        final ListenableFuture andSet = this.ref.getAndSet(create);
        ListenableFuture submitAsync = Futures.submitAsync(r0, new Executor() {
            /* class com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass3 */

            public void execute(Runnable runnable) {
                andSet.addListener(runnable, executor);
            }
        });
        ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(submitAsync);
        final ListenableFuture listenableFuture = submitAsync;
        final ListenableFuture<T> listenableFuture2 = nonCancellationPropagating;
        AnonymousClass4 r02 = new Runnable() {
            /* class com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass4 */

            public void run() {
                if (listenableFuture.isDone() || (listenableFuture2.isCancelled() && atomicReference.compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED))) {
                    create.setFuture(andSet);
                }
            }
        };
        nonCancellationPropagating.addListener(r02, MoreExecutors.directExecutor());
        submitAsync.addListener(r02, MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }
}
