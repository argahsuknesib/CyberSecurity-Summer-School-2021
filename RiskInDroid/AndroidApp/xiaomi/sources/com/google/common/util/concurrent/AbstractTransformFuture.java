package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@GwtCompatible
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    F function;
    ListenableFuture<? extends I> inputFuture;

    /* access modifiers changed from: package-private */
    @ForOverride
    public abstract T doTransform(F f, I i) throws Exception;

    /* access modifiers changed from: package-private */
    @ForOverride
    public abstract void setResult(T t);

    static <I, O> ListenableFuture<O> create(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    static <I, O> ListenableFuture<O> create(ListenableFuture listenableFuture, Function function2, Executor executor) {
        Preconditions.checkNotNull(function2);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function2);
        listenableFuture.addListener(transformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, transformFuture));
        return transformFuture;
    }

    AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.function = Preconditions.checkNotNull(f);
    }

    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        boolean z = true;
        boolean isCancelled = isCancelled() | (listenableFuture == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.inputFuture = null;
            if (listenableFuture.isCancelled()) {
                setFuture(listenableFuture);
                return;
            }
            try {
                try {
                    Object doTransform = doTransform(f, Futures.getDone(listenableFuture));
                    this.function = null;
                    setResult(doTransform);
                } catch (Throwable th) {
                    this.function = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    /* access modifiers changed from: protected */
    public String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f != null) {
            return str + "function=[" + ((Object) f) + "]";
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        /* access modifiers changed from: package-private */
        public final ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> asyncFunction, I i) throws Exception {
            ListenableFuture<? extends O> apply = asyncFunction.apply(i);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* access modifiers changed from: package-private */
        public final void setResult(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        /* access modifiers changed from: package-private */
        public final O doTransform(Function<? super I, ? extends O> function, I i) {
            return function.apply(i);
        }

        /* access modifiers changed from: package-private */
        public final void setResult(O o) {
            set(o);
        }
    }
}
